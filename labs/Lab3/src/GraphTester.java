// @author Michael Peters

import java.util.ArrayDeque;
import java.util.Queue;

public class GraphTester {
	
	
	/**
	 * Returns true if a path exists on graph, from startVertex to endVertex; 
	 * otherwise returns false. Uses breadth-first search algorithm.
	 * @param graph
	 * @param startVertex
	 * @param endVertex
	 * @return
	 */
	private static boolean isPathBF(GraphInterface<String> graph,
			String startVertex, 
			String endVertex    ) {
		
		Queue<String> queue = new ArrayDeque<String>();
		Queue<String> vertexQueue = new ArrayDeque<String>();

		boolean found = false;
		String currVertex;      // vertex being processed
		String adjVertex;       // adjacent to currVertex

		graph.clearMarks();
		graph.markVertex(startVertex);
		queue.add(startVertex);

		do
		{
			currVertex = queue.remove();
			// System.out.println(currVertex);
			if (currVertex.equals(endVertex))
				found = true;
			else
			{
				vertexQueue = graph.getToVertices(currVertex); 
				while (!vertexQueue.isEmpty())
				{
					adjVertex = vertexQueue.remove();
					if (!graph.isMarked(adjVertex))
					{
						graph.markVertex(adjVertex);
						queue.add(adjVertex);
					}
				}
			}
		} while (!queue.isEmpty() && !found);

		return found;
	}


	public static void main(String[] args) {
		
		UndirectedGraph<String> graph = new UndirectedGraph<>();
	    String p1 = new String("Bob");
	    String p2 = new String("Jack");
	    String p3 = new String("Cynthia");
	    String p4 = new String("Alex");
	    String p5 = new String("Cathy");
	    String p6 = new String("Kevin");
	    String p7 = new String("Colleen");
	    String p8 = new String("George");
		
	    
	    graph.addVertex(p1);
	    graph.addVertex(p2);
	    graph.addVertex(p3);
	    graph.addVertex(p4);
	    graph.addVertex(p5);
	    graph.addVertex(p6);
	    graph.addVertex(p7);
	    graph.addVertex(p8);
	    
	    
	    graph.addEdge(p1, p2);
	    graph.addEdge(p1, p3);
	    graph.addEdge(p1, p4);
	    graph.addEdge(p3, p4);
	    graph.addEdge(p4, p5);
	    graph.addEdge(p6, p7);
	    graph.addEdge(p6, p8);
	    
	    
	    System.out.println("Bob's friends are " + graph.getToVertices(p1));
	    System.out.println("Alex's friends are " + graph.getToVertices(p4));
	    System.out.println("George's friends are " + graph.getToVertices(p8));
	    
	    System.out.println("Are Jack and Cathy indirect friends?: " + isPathBF(graph, p2, p5));
	    System.out.println("Are Jack and George indirect friends?: " + isPathBF(graph, p2, p8));
	    

	}

}
