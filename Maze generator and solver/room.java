package sjsu.Liu.cs146.project4;
/* This class is used as the room class in order to form a complete maze.
 * There are several properties in this class, majorly, 4-direction room pointers(references)
 * which represent "4-direction walls" of each room. The walls are regarded as "being broken" if these
 * walls pointers are refering to their adjacent rooms, in another word, rooms are connected.
 * */

public class room 
{
	//wall pointers
	private room up;                 
	private room left;
	private room right;
	private room down;
	
	private int visitOrder; // it records the visit order while the maze is traversed by BFS or DFS
	private room parent;    // refers to the parent of current node.(The node which points to current node)
	private boolean visited; // used in BFS and DFS to avoid duplicated accessing
	private boolean nodeOfPath; // to record if current room is on the path.(Majorly used by printPath method)
	private int x,y; // since before the maze is created, walls are not "broken", and rooms are all isolated.
	                 // direct index accessing is important to determine the neighbor rooms. Majorly used in maze creation method.
	
	//getters
	public room getUp(){return up;}
	public room getLeft(){return left;}
	public room getRight(){return right;}
	public room getDown(){return down;}
	public int getOrder(){return visitOrder;}
	public boolean isVisited(){return visited;}
	public boolean isNodeOnPath(){return nodeOfPath;}
	public int getX(){return x;}
	public int getY(){return y;}
	public room getParent(){return parent;}
	public boolean wallIntact()
	{
		return up == null && left == null && 
			right == null && down == null;
	}
	
	//setters
	public void setUp(room newUp){up = newUp;}
	public void setLeft(room newLeft){left = newLeft;}
	public void setRight(room newRight){right = newRight;}
	public void setDown(room newDown){down = newDown;}
	public void markVisited(){visited = true;}
	public void markUnvisited(){visited = false;}
	public void setOrder(int order){visitOrder = order;}
	public void setX(int newX){x = newX;}
	public void setY(int newY){y = newY;}
	public void setOnPath(){nodeOfPath = true;}
	public void setOffPath(){nodeOfPath = false;}
	public void setParent(room newParent){parent = newParent;}
	
	//constructor
	public room()
	{
		up = null;
		left = null;
		right = null;
		down = null;
		visitOrder = -1;
		visited = false;
		nodeOfPath = false;
		x = y = -1;
		parent = null;
	}
}
