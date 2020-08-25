package graph;

import util.Node;

import java.util.*;

public class T133_cloneGraph {

    Map<Node,Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (null == node || node.neighbors == null) {
            return node;
        }

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            // get the first node
            Node temp = queue.poll();

            // judge
            if (!visited.containsKey(temp)) {

                ArrayList<Node> nodeList = new ArrayList<>();
                Node clone = new Node(temp.val,nodeList);
                visited.put(temp, clone);

                for (Node nb : temp.neighbors) {
                    if (!visited.containsKey(nb)) {
                        queue.add(nb);
                        nodeList.add(new Node(nb.val));
                    }
                }
            }
        }
        return visited.get(node);
    }
}
