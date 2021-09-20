package explore.linkedlist;

class MyLinkedList {

    static class Node {
        int val;
        Node next;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    Node head;
    int size = 0;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        int counter = 0;
        Node pointer = this.head;
        while (pointer != null) {
            if (counter++ == index) return pointer.val;
            pointer = pointer.next;
        }
        return -1;
    }

    /**
     * Add a node of value val before the first element of the linked list.
     * After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        if (head == null) {
            this.head = new Node(val);
        } else {
            this.head = new Node(val, head);
        }
        this.size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        if (this.head == null) {
            this.head = new Node(val);
        } else {
            Node pointer = this.head;
            while (pointer.next != null) {
                pointer = pointer.next;
            }
            pointer.next = new Node(val);
        }
        this.size++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list.
     * If index equals to the length of linked list, the node will be appended to the end of linked list.
     * If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index == this.size) {
            this.addAtTail(val);
        } else if (index == 0) {
            this.addAtHead(val);
        } else if (index < this.size) {
            Node nodeToInsert = new Node(val);

            int counter = 1;
            Node slow = this.head,
                    fast = this.head.next;
            while (fast != null) {
                if (counter++ == index) {
                    nodeToInsert.next = fast;
                    slow.next = nodeToInsert;
                    break;
                } else {
                    fast = fast.next;
                    slow = slow.next;
                }
            }
            this.size++;
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index >= this.size) return;
        if (index == 0) {
            this.head = head.next;
        } else {
            int counter = 1;
            Node slow = this.head,
                    fast = this.head.next;
            while (fast != null) {
                if (counter++ == index) {
                    slow.next = fast.next;
                } else {
                    fast = fast.next;
                    slow = slow.next;
                }
            }
        }
        this.size--;
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtIndex(0, 10);
        myLinkedList.addAtIndex(0, 20);
        myLinkedList.addAtIndex(1, 30);
        System.out.println(myLinkedList.get(0)); // 20


        MyLinkedList myLinkedList1 = new MyLinkedList();
        myLinkedList1.addAtHead(1);
        myLinkedList1.addAtTail(3);
        myLinkedList1.addAtIndex(1, 2);
        System.out.println(myLinkedList1.get(1));
        myLinkedList1.deleteAtIndex(1);
        System.out.println(myLinkedList1.get(1));
// "addAtHead","addAtIndex","addAtIndex","addAtHead","deleteAtIndex","addAtIndex","addAtHead","addAtTail","addAtHead","get"
//   [86],      [1,54],     [1,14],         [83],       [4],            [3,18],     [46],       [3],        [76],       [5]
        MyLinkedList lastTest = new MyLinkedList();
        lastTest.addAtHead(86);
        lastTest.addAtIndex(1, 54);
        lastTest.addAtIndex(1,14);
        lastTest.addAtHead(83);
        lastTest.deleteAtIndex(4);
        lastTest.addAtIndex(3, 18);
        lastTest.addAtHead(46);
        lastTest.addAtTail(3);
        lastTest.addAtHead(76);
        System.out.println(lastTest.get(5));
    }
}

