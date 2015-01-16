/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        if (node == null) return null;
        return copy(node, map);
    }
    
    private UndirectedGraphNode copy(UndirectedGraphNode node, HashMap<UndirectedGraphNode, UndirectedGraphNode> map) {
        UndirectedGraphNode cpNode = map.get(node);
        if (cpNode == null) {
            cpNode = new UndirectedGraphNode(node.label);
            map.put(node, cpNode);
            for (UndirectedGraphNode adjNode : node.neighbors)
                cpNode.neighbors.add(copy(adjNode, map));
        }
        return cpNode;
    }
}

