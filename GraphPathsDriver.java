
public class GraphPathsDriver {
	public static void main(String ars[])
	{
		//Create vertices.

		Vertex A = new Vertex("A");

		Vertex B = new Vertex("B");

		Vertex C = new Vertex("C");

		//Store in an array of vertices

		Vertex[] vertices = new Vertex[3];

		vertices[0] = A;

		vertices[1] = B;

		vertices[2] = C;

		//Create edge weight matrix and use to create graph.

		int[][] distances = { {0, 1, 3}, {1, 0, 1}, {3, 1, 0} };

		GraphMatrix graph1 = new GraphMatrix( vertices, distances);

		//Print out graph for 20 points.

		System.out.println(graph1);

		//Call Dijkstra with Vertex A index. Uncomment once implemented. //Test with more challenging graphs.

		graph1.Dijkstra(0);
	}
}
