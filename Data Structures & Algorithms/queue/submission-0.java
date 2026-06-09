class ListNode {

    int val;
    ListNode next;
    ListNode prev;

    ListNode(int val){
        this.val = val;
        this.next = null;
        this.prev = null;
    }

}


class Deque {

    ListNode head;
    ListNode tail;

    public Deque() {

        this.head = new ListNode(-1);
        this.tail = new ListNode(-1);
        this.head.next = tail;
        this.tail.prev = head;

    }

    public boolean isEmpty() {

        if(this.head.next == tail)
            return true;
        else
            return false;

    }

    public void append(int value) {
       
        ListNode add = new ListNode(value);

        ListNode prev = this.tail.prev;
        ListNode next = this.tail;

        add.prev = prev;
        add.next = next;
        prev.next = add;
        next.prev = add;

    }

    public void appendleft(int value) {

        ListNode add = new ListNode(value);

        ListNode prev = this.head;
        ListNode next = this.head.next;

        add.prev = prev;
        add.next = next;
        prev.next = add;
        next.prev = add;
        
    }

    public int pop() {

        if(this.isEmpty())
            return -1;

        ListNode pop = this.tail.prev;
        
        ListNode prev = pop.prev;
        ListNode next = pop.next;

        prev.next = next;
        next.prev = prev;

        return pop.val;
        
    }

    public int popleft() {

        if(this.isEmpty())
            return -1;

        ListNode pop = this.head.next;
        
        ListNode prev = pop.prev;
        ListNode next = pop.next;

        prev.next = next;
        next.prev = prev;

        return pop.val;
        
    }
}
