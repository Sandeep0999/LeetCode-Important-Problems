class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode prev = new ListNode();
        prev.next = head;
        ListNode dummy = prev;
        ListNode temp = head;

        while (temp != null) {
            if (temp.next != null && temp.val == temp.next.val) {
                ListNode curr = temp.next.next;
                while (curr != null && curr.val == temp.val) {
                    curr = curr.next;
                }
                prev.next = curr;
                temp = curr;         
            }
            else {
                prev = temp;          
                temp = temp.next;     
            }
        }

        return dummy.next;
    }
}