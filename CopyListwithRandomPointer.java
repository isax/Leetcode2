/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    // https://leetcode.com/discuss/69052/very-short-java-solution-with-map
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> hm = new HashMap<RandomListNode, RandomListNode>();
        
        RandomListNode cur = head;
        while(cur!=null){
            hm.put(cur, new RandomListNode(cur.label));
            cur = cur.next;
        }
        
        for(Map.Entry<RandomListNode, RandomListNode> entry:hm.entrySet()){
            RandomListNode node = entry.getKey();
            RandomListNode copy = entry.getValue();
            copy.next = hm.get(node.next);
            copy.random = hm.get(node.random);
        }
        return hm.get(head);
    }
}
