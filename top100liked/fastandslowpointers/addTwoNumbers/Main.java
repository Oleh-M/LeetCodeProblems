package twonumbers;

public class Main {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));

        ListNode recursiveResult = new RecursiveSolution().addTwoNumbers(l1, l2);
        ListNode iterativeResult = new IterativeSolution().addTwoNumbers(l1, l2);

        System.out.println();
    }
}
