class ListNode{

    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}

class LinkedList {

    private ListNode head;
    private ListNode tail;

    public LinkedList() {

        this.head = new ListNode(-1);
        this.tail = this.head;

    }

    public int get(int index) {

        ListNode cur = this.head.next;

        int i = 0;

        while (cur != null){
            if(i == index)
                return cur.val;
            i++;
            cur = cur.next;
        }
        return -1;
        
    }

    public void insertHead(int val) {
        ListNode newHead = new ListNode(val);
        newHead.next = head.next;
        this.head.next = newHead;

        if(newHead.next == null)
            this.tail = newHead;
    }

    public void insertTail(int val) {
        ListNode newTail = new ListNode(val);
        this.tail.next = newTail;
        this.tail = newTail;
    }

    public boolean remove(int index) {
        
        ListNode cur = this.head;
        int i = 0;

        while(i < index && cur != null){
            cur = cur.next;
            i++;
        }

        if(cur != null && cur.next != null){
            if(cur.next == this.tail)
                this.tail = cur;

            cur.next = cur.next.next;
            return true;
        }

        return false;
        
    }

    public ArrayList<Integer> getValues() {

        ArrayList<Integer> values = new ArrayList<>();

        ListNode cur = this.head.next;
        while(cur != null){
            values.add(cur.val);
            cur = cur.next;
        }

        return values;

    }
}
