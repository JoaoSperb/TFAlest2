// Java program to implement Graph
// with the help of Generics

import java.util.*;

class Graph<String> {
    private Map<String, List<String> > map = new HashMap<>();

    public void addVertex(String s)
    {
        map.put(s, new LinkedList<String>());
        

    }

    public void addEdge(String source, String destination,
                        boolean bidirectional)
    {

        if (!map.containsKey(source))
            addVertex(source);

        if (!map.containsKey(destination))
            addVertex(destination);

        map.get(source).add(destination);
        if (bidirectional == true) {
            map.get(destination).add(source);
        }
    }

    // This function gives the count of vertices
    public void getVertexCount()
    {
        System.out.println("The graph has "
                           + map.keySet().size()
                           + " vertex");
    }

    // This function gives the count of edges
    public void getEdgesCount(boolean bidirection)
    {
        int count = 0;
        for (String v : map.keySet()) {
            count += map.get(v).size();
        }
        if (bidirection == true) {
            count = count / 2;
        }
        System.out.println("The graph has " + count
                           + " edges.");
    }

    

    // This function gives whether an edge is present or
    // not.
    public void hasEdge(String s, String d)
    {
        if (map.get(s).contains(d)) {
            System.out.println(
                "The graph has an edge between " + s
                + " and " + d + ".");
        }
        else {
            System.out.println(
                "The graph has no edge between " + s
                + " and " + d + ".");
        }
    }
}
