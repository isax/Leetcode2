/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        
        RandomListNode node = head;
        while(node!=null){
            RandomListNode copy = new RandomListNode(node.label);
            map.put(node, copy);
            node = node.next;
        }
        
        node = head;
        while(node!=null){
            RandomListNode copy = map.get(node);
            copy.next = map.get(node.next);
            copy.random = map.get(node.random);
            node = node.next;
        }
        
        return map.get(head);
    }
    
    public RandomListNode copyRandomList2(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        return dfs(head, map);
    }
    
    private RandomListNode dfs(RandomListNode node, Map<RandomListNode, RandomListNode> map){
        if(node==null) return null;
        if(!map.containsKey(node)){
            RandomListNode newNode = new RandomListNode(node.label);
            map.put(node, newNode);
            newNode.next = dfs(node.next, map);
            newNode.random = dfs(node.random, map);
        }
        RandomListNode newNode = map.get(node);
        return newNode;
    }
}
