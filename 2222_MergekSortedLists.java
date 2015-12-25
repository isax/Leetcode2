/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    // dive and conquer
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0) return null;
        return divide(lists, 0, lists.length-1);
    }
    
    private ListNode divide(ListNode[] lists, int i, int j){
        //if(i>j) return null;
        if(i==j) return lists[i];
        
        int mid = i + (j-i)/2;
        return mergeTwoLists(divide(lists, i, mid), divide(lists, mid+1, j));
    }
    
    // conquer
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1==null?l2:l1;
        return dummy.next;
    }
    
    // heap
    public ListNode mergeKListsHeap(ListNode[] lists) {
        if(lists==null || lists.length==0) return null;
        
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        
        Queue<ListNode> q = new PriorityQueue(lists.length, new Comparator<ListNode>(){
           public int compare(ListNode n1, ListNode n2){
               return n1.val - n2.val;
           } 
        });
        
        for(ListNode node :lists){
            if(node!=null) q.offer(node);
        }
        
        while(!q.isEmpty()){
            ListNode node = q.poll();
            cur.next = node;
            cur = cur.next;
            
            if(node.next!=null) q.offer(node.next);
        }
        return dummy.next;
    }
}
