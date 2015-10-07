/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode heada = headA;
        int countA = 0;
        while(heada!=null){
            countA++;
            heada = heada.next;
        }
        
        ListNode headb = headB;
        int countB = 0;
        while(headb!=null){
            countB++;
            headb = headb.next;
        }
        
        if(countA>countB){
            int diff = countA-countB;
            while(diff!=0){
                headA = headA.next;
                diff--;
            }
        }else if(countA<countB){
            int diff = countB-countA;
            while(diff!=0){
                headB = headB.next;
                diff--;
            }
        }
        
        while(headA!=null){
            if(headA==headB){
                return headA;
            }else{
                headA = headA.next;
                headB = headB.next;
            }
        }
        return null;
    }
}
