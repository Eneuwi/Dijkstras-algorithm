
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class GraphMatrix 
{
	private Vertex[] vertices;
	private int[][] edgeWeights;
	
	
	private int length(Vertex u, Vertex v) {
		return (Math.abs(u.getDistance() - v.getDistance()));
	}
	
	public GraphMatrix(Vertex[] vertices, int[][] edgeWeights)
	{
		this.vertices = vertices;
		this.edgeWeights = edgeWeights;
	}
	
	
	public void Dijkstra(int sourceIndex)
	{
		Vertex source = vertices[sourceIndex]; //Vertex source = vertices[sourceIndex]
		PriorityQueue<Vertex> Q = new PriorityQueue<Vertex>(); //create PriorityQueue<Vertex> Q
		HashMap<Vertex, Vertex> predecessor = new HashMap<Vertex, Vertex>(); //Create a HashMap<Vertex, Vertex> predecessor
		
		for(Vertex v: this.vertices)//for each vertex v in Graph:
		{
			v.setDistance(Integer.MAX_VALUE);//dist[v] = INFINITY
			if(v == source)//if v is source
			{
				source.setDistance(0);//set dist[source] = 0
			}
			Q.add(v);//add v to Q
		}//end for
		
		while(!Q.isEmpty())//while Q is not empty do
		{
			//u = vertex in Q with min distance
			Vertex u = Q.remove();
			int uIndex = -1;//uIndex = index of u in vertices
			for(int i = 0; i< vertices.length; i++)
			{
				if(vertices[i] == u) //find uIndex in vertices
				{
					uIndex = i;
				}
			}
			
			for(int i = 0; i < vertices.length; i++)
			{
				if(this.edgeWeights[uIndex][i] > 0 && Q.contains(vertices[i])) //if v still in Q and edge from u to v
				{
						int alt = u.getDistance() + this.edgeWeights[uIndex][i];//alt = dist[u] + length(u,v)
						if(alt < vertices[i].getDistance())//if alt < dist[v]
						{
							Q.remove(vertices[i]); //remove v from Q
							vertices[i].setDistance(alt); //dist[v] = alt
							Q.add(vertices[i]);//add v to Q
							predecessor.put(vertices[i], u);//set u to be predecessor to v	
						}
					}	
				}
			}
	
//print out distance to each vertex from the source
//print out path from source to each vertex
		for(int i = 0; i < vertices.length; i++) { // for each vertex current in vertices
			String path = ""; //String path = "";
			Vertex current = vertices[i];
			if(current != vertices[sourceIndex])//if(not sourceIndex)
			{
				path = " -> "+ current; //path = " -> "+path
				while(predecessor.containsKey(current))//while(predecessor contains key (current))
				{
					if(predecessor.get(current) == source)//if( predecessor of current is source)
					{
						path = predecessor.get(current) + path;//path = predecessor get current + path
					}
					else
					{
						path = " -> " +predecessor.get(current) + path;//path = " -> " +predecessor get current + path
					}
					current = predecessor.get(current);//current = predecessor get current
				} //end while
			} //end if
			System.out.println(path);//print path
		}//end for
}
	
	public String toString() {
        String arrow = " -> ";
        String comma = ", ";
        StringBuilder builder = new StringBuilder("Adjacency matrix for graph:\n");
        
        // Loop around the edge weights.
        for (int i = 0; i < edgeWeights.length; i++)
        {
            // Add the starter vertex.
            builder.append(vertices[i].getName());


            // Loop around the other edges.
            for (int j = 0; j < edgeWeights[i].length; j++)
            {

                // Only add a string if it is not the same vertex.
                if (i != j)
                {
                    builder.append(arrow);
                    builder.append(vertices[j].getName() + comma + edgeWeights[i][j]);
                }
            }
            builder.append("\n");
        }

        //Return the string that had been built.
        return builder.toString();
    }
}
