public class Vertex implements Comparable<Vertex>{

	//constant color values for BFS Algorithm
	public static final int WHITE = 1;
	public static final int GREEN = 2;
	public static final int BLACK = 3;
	//instance variables
	private String name;
	private int color;
	private boolean visited; //used for DFS algorithm
	int distance;
	/*
	vertex constructor to initialize instance variables
	@param name
	*/
	
	public Vertex(String name)
	{
		this.name = name;
		color = 0;
		visited = false;
	}
	
	@Override
	public String toString()
	{
		return name + ", " + distance;
	}
	
	
	public String getName()
	{
		return name;
	}
	
	public int getColor()
	{
		return color;
	}
	
	public int getDistance()
	{
		return distance;
	}
	
	public void setDistance(int newDistance)
	{
		distance = newDistance;
	}
	
	public void setColor(int col)
	{
		color = col;
	}
	
	public boolean isVisited()
	{
		if(visited == true)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	public void setVisited(boolean newVisited)
	{
		visited = newVisited;
	}

	public int compareTo(Vertex o) {
		int value = 0;//int value = 0
		if(distance < o.getDistance())//if(distance < o.getDistance())
		{
			value = -1;//value = -1;\
		}
		else if(distance > o.getDistance())//elseif(distance > o.getDistance())
		{
			value = 1;//value = 1
		}
		return value;
	}
}
