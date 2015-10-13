/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    
     public ListNode mergeKLists(ListNode[] lists) {
         if(lists==null || lists.length==0) return null;
         PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
             @Override
             public int compare(ListNode l1, ListNode l2){
                 return l1.val - l2.val;
             }
         });
         
         for(ListNode node : lists){
             if(node!=null){
                 q.offer(node);
             }
         }
         ListNode dummy = new ListNode(0);
         ListNode head = dummy;
         
         while(!q.isEmpty()){
             ListNode node = q.poll();
             head.next = node;
             if(node.next!=null){
                 q.offer(node.next);
             }
             head = head.next;
         }
         return dummy.next;
    }
    
    // Code Ganker: http://blog.csdn.net/linhuanmars/article/details/19899259
    public ListNode mergeKLists2(ListNode[] lists) {
         if(lists==null || lists.length==0) return null;
         return helper(lists,0,lists.length-1);
    }
    
    private ListNode helper(ListNode [] lists, int l, int r)
    {
        if(l==r) return lists[l]; // base
        
        int mid = (l+r)/2;
        return merge(helper(lists, l, mid), helper(lists, mid+1, r));
    }
    
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        
        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                head.next = l1;
                l1 = l1.next;
            }else{
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        
        head.next = l1==null?l2:l1;
        return dummy.next;
    }
}
