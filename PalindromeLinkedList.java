/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    // Reverse: https://leetcode.com/discuss/44775/share-my-c-solution-o-n-time-and-o-1-memory
    public boolean isPalindrome(ListNode head) {
        if(head==null) return true;
        
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        if(fast!=null && slow!=null) slow = slow.next;
        
        if(slow!=null){ // 1  single node
            ListNode p = slow.next;
            slow.next = null;
        
            while(p!=null){
                 ListNode next = p.next;
                 p.next = slow;
                 slow = p;
                 p = next;
            }
        }
        
        while(slow!=null){
            if(head.val!=slow.val) return false;
            slow = slow.next;
            head = head.next;
        }
        return true;
    }
    
    
    // Mine
    public boolean isPalindromeMine(ListNode head) {
        int len = 0;
        ListNode fast = head;
        
        while(fast!=null){
            len++;
            fast = fast.next;
        }
        
        return helper(head, len).res;
    }
    
    private MyResult helper(ListNode head, int len){
        if(head==null) return new MyResult(null, true);
        
        if(len==0) return new MyResult(head, true);
        if(len==1) return new MyResult(head.next, true);
        
        MyResult next = helper(head.next, len-2);
        
        if(!next.res || head.val!=next.nextCheck.val) return new MyResult(null, false);
        else return new MyResult(next.nextCheck.next, true);
    }
    
    private static class MyResult{
        ListNode nextCheck;
        boolean res;
        
        public MyResult(ListNode nextCheck, boolean res){
            this.nextCheck = nextCheck;
            this.res = res;
        }
    }
}
