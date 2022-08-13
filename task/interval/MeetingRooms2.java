package interval;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given an array of meeting time intervals consisting of start and end times
 * [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.)
 * <p>
 * Input: intervals = [(0,30),(5,10),(15,20)]
 * Output: 2
 * Explanation:
 * We need two meeting rooms
 * room1: (0,30)
 * room2: (5,10),(15,20)
 * <p>
 * Input: intervals = [(2,7)]
 * Output: 1
 * Explanation:
 * Only need one meeting room
 */
public class MeetingRooms2 {
    public static int minMeetingRooms(List<Interval> intervals) {
        if (intervals == null ||
                intervals.size() == 0) return 0;

        var startRanges = intervals.stream().map(a -> a.start).sorted().toArray(Integer[]::new);
        var endRanges = intervals.stream().map(a -> a.end).sorted().toArray(Integer[]::new);

        int s = 0, e = 0;
        int result = 0, counter = 0;

        while (s < intervals.size()) {
            if (startRanges[s] < endRanges[e]) {
                s++;
                counter++;
            } else {
                e++;
                counter--;
            }

            result = Math.max(result, counter);
        }

        return result;
    }

    public static void main(String[] args) {
        var input5 = new int[][]{{65, 424}, {351, 507}, {314, 807}, {387, 722}, {19, 797}, {259, 722}, {165, 221}, {136, 897}};
        var data5 = createListOfInterval(input5);
        System.out.println(minMeetingRooms(data5)); // 7

        var data = new int[][]{{567707, 730827}, {166232, 719216}, {634677, 756013}, {285191, 729059}, {237939, 915914},
                {201296, 789707}, {578258, 585240}, {164298, 218749}, {37396, 968315}, {666722, 934674},
                {742749, 824917}, {141115, 417022}, {613457, 708897}, {343495, 994363}, {380250, 428265},
                {214441, 493643}, {588487, 811879}, {97538, 262361}, {312269, 400232}, {119183, 598077},
                {48359, 662082}, {275411, 998607}, {732520, 813383}, {523587, 945442}, {25499, 187818},
                {384094, 677532}, {515481, 904358}, {367073, 534689}, {74379, 285755}, {5175, 274185},
                {217306, 359251}, {157681, 697795}, {10408, 50527}, {244728, 788413}, {60159, 513570},
                {87670, 618955}, {123002, 685804}, {379941, 544148}, {752885, 952000}, {93326, 513158},
                {724941, 998846}, {380834, 713191}, {44977, 758923}, {82478, 863827}, {191702, 202103},
                {132379, 894865}, {33622, 873933}, {29205, 85762}, {154893, 736522}, {65801, 673648},
                {524615, 925054}, {54903, 503215}, {184486, 923679}, {429446, 722503}, {433374, 648218},
                {221866, 866873}, {460293, 767671}, {120556, 899800}, {471650, 884153}, {260903, 444940},
                {764956, 900171}, {309912, 608549}, {185563, 806731}, {120163, 485407}, {418426, 787505},
                {366182, 765471}, {387482, 509524}, {269290, 965760}, {601620, 925056}, {77986, 263210},
                {307558, 385490}, {232270, 339488}, {500796, 742417}, {380705, 468257}, {65075, 908144},
                {199833, 764292}, {236020, 666098}, {66185, 189939}, {82749, 497671}, {191217, 375842},
                {197768, 679395}, {193098, 715861}, {441216, 949168}, {70640, 164591}, {47205, 785067},
                {488750, 598205}, {13213, 617815}, {323318, 918171}, {414290, 772744}, {252493, 666573},
                {271755, 888520}, {127330, 511709}, {221211, 255366}, {189693, 496201}, {59348, 213072},
                {848245, 886578}, {297360, 706720}, {416648, 713923}, {597845, 948100}, {598216, 887392},
                {291671, 885441}, {470685, 911757}, {753936, 779842}, {402359, 607590}, {405439, 709142},
                {214403, 993931}, {410523, 809693}, {394872, 807901}, {104075, 813021}, {726, 567120}, {118216, 440587},
                {451018, 831426}, {134313, 437745}, {580445, 723821}, {812199, 974362}, {206646, 330279},
                {76614, 396575}, {490128, 495052}, {159918, 891113}, {317757, 944351}, {367136, 561514},
                {47693, 397141}, {624885, 944320}, {22262, 713662}, {14887, 710022}, {887543, 997929},
                {211476, 296206}, {560776, 619572}, {49048, 602570}, {169071, 575311}, {645076, 686241},
                {577490, 777716}, {431009, 702971}, {197437, 728985}, {62590, 339659}, {474951, 503156},
                {637923, 899120}, {973131, 976272}, {450579, 954240}, {318272, 635074}, {68073, 677042},
                {127777, 185375}, {426756, 912534}, {370844, 592811}, {724, 630896}, {732456, 896268},
                {592795, 641974}, {321324, 337142}, {505427, 594421}, {74917, 273591}};
        var data1 = createListOfInterval(data);
        System.out.println(minMeetingRooms(data1)); // 85

        var input2 = new int[][]{{0, 30}, {5, 10}, {15, 20}};
        var data2 = createListOfInterval(input2);
        System.out.println(minMeetingRooms(data2)); // 2

        var input3 = new int[][]{{2, 7}};
        var data3 = createListOfInterval(input3);
        System.out.println(minMeetingRooms(data3)); // 1

        var input4 = new int[][]{{5, 8}, {6, 8}};
        var data4 = createListOfInterval(input4);
        System.out.println(minMeetingRooms(data4)); // 2
    }

    private static List<Interval> createListOfInterval(int[][] data) {
        return Arrays.stream(data).map(Interval::new).collect(Collectors.toList());
    }
}
