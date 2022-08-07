import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * This program computes the following SQL query:
 * <p>
 * select
 * 100 * (sum(price * discount) / sum(price)) as discount_ratio,
 * avg(price) as avg_price
 * from
 * item
 * where (
 * discount between .05 and .07
 * and quantity < 24
 * and status = 'A'
 * ) or comment LIKE 'PROMO%SUMMER'
 * <p>
 * It is composed by 3 main tasks:
 * 1. Read input
 * 2. Filter by WHERE condition
 * 3. Aggregate
 * <p>
 * Traditionally data is represented in row format:
 * <p>
 * --------------------------------------------------------
 * RowId   Quantity   Price   Discount   Status   Comment
 * --------------------------------------------------------
 * 0       6          19.9    0.07       "A"      "PROMO"
 * --------------------------------------------------------
 * 1       18         24.9    0.04       "A"      ""
 * --------------------------------------------------------
 * 2       6          9.9     0.08       "AR"     ""
 * --------------------------------------------------------
 * <p>
 * This program represents data in columnar format:
 * <p>
 * -------------------------------------
 * RowId      0         1         2
 * -------------------------------------
 * Quantity   6         18        6
 * -------------------------------------
 * Price      19.9      24.9      9.9
 * -------------------------------------
 * Discount   0.07      0.04      0.08
 * -------------------------------------
 * Status     "A"       "A"       "AR"
 * -------------------------------------
 * Comment    "PROMO"   ""        ""
 * -------------------------------------
 */
public class Main {

  public static class InputBatch {
    public int numRows;
    public int[] quantity;
    public double[] price;
    public double[] discount;
    public StringColumn status = new StringColumn();
    public StringColumn comment = new StringColumn();
  }

  public static class FilteredBatch {
    public int numRows;
    public int[] quantity;
    public double[] price;
    public double[] discount;
    public StringColumn status = new StringColumn();
    public StringColumn comment = new StringColumn();

    public void resizeArray() {
      this.quantity = Arrays.copyOf(this.quantity, this.numRows);
      this.price = Arrays.copyOf(this.price, this.numRows);
      this.discount = Arrays.copyOf(this.discount, this.numRows);
      this.status.offset = Arrays.copyOf(this.status.offset, this.numRows);
      this.status.length = Arrays.copyOf(this.status.length, this.numRows);
      this.status.buffer = Arrays.copyOf(this.status.buffer, this.numRows);
      this.comment.offset = Arrays.copyOf(this.comment.offset, this.numRows);
      this.comment.length = Arrays.copyOf(this.comment.length, this.numRows);
      this.comment.buffer = Arrays.copyOf(this.comment.buffer, this.numRows);
    }
  }

  public static class AggregatedBatch {
    public int numRows;
    public double[] discount_ratio;
    public double[] avg_price;
  }

  /**
   * Variable length ASCII string.
   */
  public static class StringColumn {
    public int[] offset; // start of string in `buffer` (for each row)
    public int[] length; // lengths (for each row)
    public byte[] buffer; // buffer with data of all strings

    // Example: 2 strings - "Hi" and "there"
    //
    // offset  |  0  2
    // length  |  2  5
    // buffer  |  H  i  t  h  e  r  e
  }

  /**
   * Implement TODOs.
   * Feel free to create new functions but keep existing ones.
   */
  public static void main(String[] args) {
    InputBatch input = input();
    FilteredBatch filtered = filter(input);
    AggregatedBatch aggregated = aggregate(filtered);

    assertResult(5.8893854d, aggregated.discount_ratio[0], "discount ratio");
    assertResult(17.9d, aggregated.avg_price[0], "avg price");
  }

  public static InputBatch input() {
    InputBatch output = new InputBatch();

    output.numRows = 10;
    output.quantity = new int[]{6, 18, 6, 30, 24, 12, 18, 6, 24, 12};
    output.price = new double[]{19.9d, 24.9d, 9.9d, 14.9d, 9.9d, 19.9d, 24.9d, 19.9d, 9.9d, 14.9};
    output.discount = inputDiscount();

    output.status.offset = new int[]{0, 1, 2, 4, 5, 6, 7, 8, 9, 10};
    output.status.length = new int[]{1, 1, 2, 1, 1, 1, 1, 1, 1, 1};
    output.status.buffer = "AAARNAANAAA".getBytes();

    output.comment.offset = new int[]{0, 0, 0, 5, 0, 0, 0, 0, 20, 0};
    output.comment.length = new int[]{5, 0, 0, 15, 5, 0, 0, 0, 12, 5};
    output.comment.buffer = "PROMOPROMO IN SUMMERPROMO WINTER".getBytes();

    return output;
  }

  public static double[] inputDiscount() {
    // Possible discount values.
    double[] dictionary = {0.04d, 0.05d, 0.07d, 0.08d};

    // Contains for each row the index in the discount dictionary.
    int[] ids = {2, 0, 3, 1, 0, 2, 2, 1, 3, 1};

    // NOTE: in case we will have id's that is out of the range of dictionary we should throw an exception with
    // corresponding message. Incorrect results returning is unacceptable in this case
    double[] expected = new double[ids.length];
    for (int i = 0; i < ids.length; i++) {
      expected[i] = dictionary[ids[i]];
    }

    return expected;
  }

  /**
   * Applies filter: (
   * discount between .05 and .07
   * and quantity < 24
   * and status = 'A'
   * ) or comment LIKE 'PROMO%SUMMER'
   */
  public static FilteredBatch filter(InputBatch input) {
    FilteredBatch output = new FilteredBatch();

    output.quantity = new int[input.quantity.length];
    output.price = new double[input.price.length];
    output.discount = new double[input.discount.length];
    output.status.offset = new int[input.status.offset.length];
    output.status.length = new int[input.status.length.length];
    output.status.buffer = new byte[input.status.buffer.length];
    output.comment.offset = new int[input.comment.offset.length];
    output.comment.length = new int[input.comment.length.length];
    output.comment.buffer = new byte[input.comment.buffer.length];

    int rowNum = 0;
    for (int i = 0; i < input.numRows; i++) {

      boolean firstCondition =
              input.discount[i] >= 0.05d &&
                      input.discount[i] <= 0.07d &&
                      input.quantity[i] < 24 &&
                      isEqualToA(i, input.status);

      if (firstCondition || isLikePromoSummer(i, input.comment)) {
        output.quantity[rowNum] = input.quantity[i];
        output.price[rowNum] = input.price[i];
        output.discount[rowNum] = input.discount[i];
        output.status.offset[rowNum] = input.status.offset[i];
        output.status.length[rowNum] = input.status.length[i];
        output.status.buffer[rowNum] = input.status.buffer[i];
        output.comment.offset[rowNum] = input.comment.offset[i];
        output.comment.length[rowNum] = input.comment.length[i];
        output.comment.buffer[rowNum] = input.comment.buffer[i];

        rowNum++;
      }
    }

    output.numRows = rowNum;
    output.resizeArray();

    return output;
  }

  public static boolean isEqualToA(int rowId, StringColumn str) {
    var string = getStringFromBytesRange(rowId, str);
    return string.equals("A");
  }

  public static boolean isLikePromoSummer(int rowId, StringColumn str) {
    var string = getStringFromBytesRange(rowId, str);
    return string.matches("PROMO.*SUMMER");
  }

  private static String getStringFromBytesRange(int rowId, StringColumn str) {
    int offset = str.offset[rowId];
    int length = str.length[rowId] + offset;

    var buf = Arrays.copyOfRange(str.buffer, offset, length);
    return new String(buf, StandardCharsets.UTF_8);
  }

  /**
   * Compute:
   * - 100 * (sum(price * discount) / sum(price)) as discount_ratio
   * - avg(price) as avg_price
   */
  public static AggregatedBatch aggregate(FilteredBatch input) {
    AggregatedBatch output = new AggregatedBatch();
    // NOTE: we could change it to single values only instead of arrays!
    output.discount_ratio = new double[1];
    output.avg_price = new double[1];

    var discountPriceSum = IntStream.range(0, input.numRows)
            .mapToDouble(i -> input.price[i] * input.discount[i])
            .sum();
    var priceSum = Arrays.stream(input.price).sum();
    var discountRatio = 100d * (discountPriceSum / priceSum);

    var priceAvg = Arrays.stream(input.price).average().orElse(0.0);

    output.discount_ratio[0] = discountRatio;
    output.avg_price[0] = priceAvg;

    return output;
  }

  private static void assertResult(double expected, double actual, String description) {
    if (Math.abs(expected - actual) > 0.000001d)
      throw new RuntimeException("Unexpected " + description);
  }
}
