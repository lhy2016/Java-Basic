package sjsu.Liu.cs146.project4;
/* This program creates random maze based on the size 
 * that the user provided. After the maze is generated, 
 * it firstly prints the the maze, then it applies BFS(Breadth First Search)
 * and DFS(Deapth First Search) algorithm on the same maze to solve it.
 * For each algorithm, the answer path and the actual traverse order are printed.
 * 
 * Note that the maze is designed to have only one path from entrance to exit, so
 * the printed path of two algorithm should be identical.
 * */


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class maze 
{
	private room start;     // the start(entrance) pointer of the maze
	private room finish;    // the finish(exit) pointer of the maze
	private room[][] mazeContainer; // since before the maze is created, walls are not "broken", and rooms are all isolated.
                                    // direct index accessing is important to determine the neighbor rooms and break the walls.
	                                // also used in all printing methods.
	
	private Random myRandGen;
	             
	// getters
	public room getStart(){return start;}
	public room getFinish(){return finish;}
	public room[][] getMaze(){return mazeContainer;}  
	public double myrandom() {  return myRandGen.nextDouble(); }
	
	//constructor
	public maze(int size)
	{
		myRandGen=new java.util.Random(0); 
		setup(size);
	    createMaze();
	}
	
	//Allocate memories and create rooms based on the size that user provided without breaking walls yet.
	public void setup(int size)
	{
		mazeContainer = new room[size][size];
		for(int i = 0;i<size;i++)
		{
			for(int j = 0;j<size;j++)
			{
				mazeContainer[i][j] = new room();
				mazeContainer[i][j].setX(i);
				mazeContainer[i][j].setY(j);
			}
		}
		start = mazeContainer[0][0];
		finish = mazeContainer[size-1][size-1];
	}
	
	//Breaking walls by using DFS to create a one-path maze.
	public void createMaze()
	{
		Stack<room> sk = new Stack<room>();
		int room_num = mazeContainer.length*mazeContainer.length;
	    room current = start;
	    int visitedRooms = 1;
	    while(visitedRooms < room_num)
	    {
	    	int x = current.getX();
	    	int y = current.getY();
	    	ArrayList<room> temp = new ArrayList<room>();
	    	
	    	if(x-1>=0 && mazeContainer[x-1][y].wallIntact())  // up neighbor
	    	{
	    		temp.add(mazeContainer[x-1][y]);
	    	}
	    	if(x+1<=mazeContainer.length-1 && mazeContainer[x+1][y].wallIntact())  // down neighbor
	    	{
	    		temp.add(mazeContainer[x+1][y]);
	    	}
	    	if(y-1>=0 && mazeContainer[x][y-1].wallIntact()) //left neightbor
	    	{
	    		temp.add(mazeContainer[x][y-1]);
	    	}
	    	if(y+1<=mazeContainer.length-1 && mazeContainer[x][y+1].wallIntact()) // right neighbor
	    	{
	    		temp.add(mazeContainer[x][y+1]);
	    	}
	    	if(temp.size()>0) // if found one or more neighbor rooms with intact wall
	    	{
	    		int randIndex = 0 + (int)(myrandom()*(temp.size()));  // randomly choose one from the ArrayList
	    		room chosen = temp.get(randIndex);
	    		
	    		if(chosen.getX() == x-1) // if the chosen room is up neighbor
	    		{
	    			current.setUp(chosen);
	    			chosen.setDown(current);
	    		}
	    		else if(chosen.getX() == x+1) // if the chosen room is down neighbor
	    		{
	    			current.setDown(chosen);
	    			chosen.setUp(current);
	    		}
	    		else if(chosen.getY() == y-1) // if the chosen room is left neighbor
	    		{
	    			current.setLeft(chosen);
	    			chosen.setRight(current);
	    		}
	    		else if(chosen.getY() == y+1) // if the chosen room is right neighbor
	    		{
	    			current.setRight(chosen);
	    			chosen.setLeft(current);
	    		}
	    		sk.push(current);     // push current on the stack
	    		current = chosen;
	    		visitedRooms += 1;
	    	}
	    	else
	    	{
	    		current  = sk.pop();
	    	}
	    }
	   
	}
	
	//print the original maze.
	public void printMaze()
	{
		System.out.println("Entrance");
		for(int i = 0;i<mazeContainer.length;i++)
		{
			for(int j = 0;j<mazeContainer[i].length;j++)
			{
				System.out.print("+");
				if(mazeContainer[i][j] == start)
				{
					System.out.print("   ");
				}
				else
				{
					System.out.print(mazeContainer[i][j].getUp() == null ? "---":"   ");
				}	
			}
			System.out.println("+");
			for(int k = 0;k<mazeContainer[i].length;k++)
			{
				System.out.print(mazeContainer[i][k].getLeft() == null?"|":" ");
				System.out.print("   ");
				if(k == mazeContainer[i].length-1)
					System.out.println(mazeContainer[i][k].getRight() == null?"|":" ");
			}
			if(i == mazeContainer.length-1)
			{
				for(int j = 0;j<mazeContainer[i].length;j++)
				{
					System.out.print("+");
					if(mazeContainer[i][j] == finish)
					{
						System.out.print("   ");
					}
					else
					{
						System.out.print(mazeContainer[i][j].getDown()==null?"---":"   ");
					}
				}
				System.out.println("+");
			}
		}
		for(int i = 0;i<mazeContainer.length*4-3;i++)
		{
			System.out.print(" ");
		}
		System.out.println("Exit");
	}
	
	//BFS algorithm
	public void BFS()
	{
		System.out.println("\nSolving the maze with BFS:\n");
		for(int i = 0;i<mazeContainer.length;i++)
		{
			for(int j = 0;j<mazeContainer[i].length;j++) // reset the graph
			{
				mazeContainer[i][j].markUnvisited();
				mazeContainer[i][j].setOrder(-1);
				mazeContainer[i][j].setParent(null);
				mazeContainer[i][j].setOffPath();
			}
		}
		start.markVisited();
		int visitedOrder = 0;
		start.setOrder(visitedOrder);
		Queue<room> q = new LinkedList<room>();
	    q.add(start);
	    while(!q.contains(finish) && !q.isEmpty())
	    {
	    	room u = q.remove();
	    	if(u.getUp()!=null && !u.getUp().isVisited())
	    	{
	    		room v = u.getUp();
	    		v.markVisited();
	    		visitedOrder++;
	    		v.setOrder(visitedOrder);
	    		v.setParent(u);
	    		q.add(v);
	    	}
	    	if(q.contains(finish))
	    		break;
	    	if(u.getLeft()!=null && !u.getLeft().isVisited())
	    	{
	    		room v = u.getLeft();
	    		v.markVisited();
	    		visitedOrder++;
	    		v.setOrder(visitedOrder);
	    		v.setParent(u);
	    		q.add(v);
	    	}
	    	if(q.contains(finish))
	    		break;
	    	if(u.getRight()!=null && !u.getRight().isVisited())
	    	{
	    		room v = u.getRight();
	    		v.markVisited();
	    		visitedOrder++;
	    		v.setOrder(visitedOrder);
	    		v.setParent(u);
	    		q.add(v);
	    	}
	    	if(q.contains(finish))
	    		break;
	    	if(u.getDown()!=null && !u.getDown().isVisited())
	    	{
	    		room v = u.getDown();
	    		v.markVisited();
	    		visitedOrder++;
	    		v.setOrder(visitedOrder);
	    		v.setParent(u);
	    		q.add(v);
	    	}
	    }
		
	}
	
	//DFS algorithm
	public void DFS()
	{
		System.out.println("\nSolving the maze with DFS:\n");
		for(int i = 0;i<mazeContainer.length;i++)
		{
			for(int j = 0;j<mazeContainer[i].length;j++) // reset the graph
			{
				mazeContainer[i][j].markUnvisited();
				mazeContainer[i][j].setOrder(-1);
				mazeContainer[i][j].setParent(null);
				mazeContainer[i][j].setOffPath();
			}
		}
		
		int visitedOrder = -1;
		Stack<room> sk = new Stack<room>();
	    sk.push(start);
	    while(!sk.empty())
	    {
	    	room u = sk.pop();
	    	if(!u.isVisited())
	    	{
	    		u.markVisited();
	    		visitedOrder++;
	    		u.setOrder(visitedOrder);
	    		if(u == finish)
	    			return;
	    	}
	    	if(u.getUp()!=null && !u.getUp().isVisited())
	    	{
	    		room v = u.getUp();
	    		v.setParent(u);
	    		sk.push(v);
	    	}
	    	if(u.getLeft()!=null && !u.getLeft().isVisited())
	    	{
	    		room v = u.getLeft();
	    		v.setParent(u);
	    		sk.push(v);
	    	}
	    	
	    	if(u.getRight()!=null && !u.getRight().isVisited())
	    	{
	    		room v = u.getRight();
	    		v.setParent(u);
	    		sk.push(v);
	    	}
	    	if(u.getDown()!=null && !u.getDown().isVisited())
	    	{
	    		room v = u.getDown();
	    		v.setParent(u);
	    		sk.push(v);
	    	}
	    }
		
	}
	
	//Determine if a path can be found for the maze, 
	//if found, mark all the rooms which are on the path.
	public boolean FoundPath(room v)
	{
		if(v == start)
		{
			start.setOnPath();
			return true;
		}
		if(v.getParent() == null)
		{
			return false;
		}
		else
		{
			v.setOnPath();
			v = v.getParent();
			return FoundPath(v);
		}
			
	}
	
	//print the traverse order, must be used after BFS or DFS
	public void printVisitedOrder()
	{
		System.out.println("Entrance");
		for(int i = 0;i<mazeContainer.length;i++)
		{
			for(int j = 0;j<mazeContainer[i].length;j++)
			{
				System.out.print("+");
				if(mazeContainer[i][j] == start)
				{
					System.out.print("   ");
				}
				else
				{
					System.out.print(mazeContainer[i][j].getUp() == null ? "---":"   ");
				}	
			}
			System.out.println("+");
			for(int k = 0;k<mazeContainer[i].length;k++)
			{
				System.out.print(mazeContainer[i][k].getLeft() == null?"|":" ");
				System.out.print(mazeContainer[i][k].getOrder() == -1?"   ":" "+mazeContainer[i][k].getOrder()%10+" ");
				if(k == mazeContainer[i].length-1)
					System.out.println(mazeContainer[i][k].getRight() == null?"|":" ");
			}
			if(i == mazeContainer.length-1)
			{
				for(int j = 0;j<mazeContainer[i].length;j++)
				{
					System.out.print("+");
					if(mazeContainer[i][j] == finish)
					{
						System.out.print("   ");
					}
					else
					{
						System.out.print(mazeContainer[i][j].getDown()==null?"---":"   ");
					}
				}
				System.out.println("+");
			}
		}
		for(int i = 0;i<mazeContainer.length*4-3;i++)
		{
			System.out.print(" ");
		}
		System.out.println("Exit");
	}
	
	//print the path
	public void printPath()
	{
		if(FoundPath(finish))
		{
			System.out.println("\nPath founded!\n");
			System.out.println("Entrance");
			for(int i = 0;i<mazeContainer.length;i++)
			{
				for(int j = 0;j<mazeContainer[i].length;j++)
				{
					System.out.print("+");
					if(mazeContainer[i][j] == start)
					{
						System.out.print("   ");
					}
					else
					{
						System.out.print(mazeContainer[i][j].getUp() == null ? "---":"   ");
					}	
				}
				System.out.println("+");
				for(int k = 0;k<mazeContainer[i].length;k++)
				{
					System.out.print(mazeContainer[i][k].getLeft() == null?"|":" ");
					System.out.print(" "+(mazeContainer[i][k].isNodeOnPath()?"#":" ")+" ");
					if(k == mazeContainer[i].length-1)
						System.out.println(mazeContainer[i][k].getRight() == null?"|":" ");
				}
				if(i == mazeContainer.length-1)
				{
					for(int j = 0;j<mazeContainer[i].length;j++)
					{
						System.out.print("+");
						if(mazeContainer[i][j] == finish)
						{
							System.out.print("   ");
						}
						else
						{
							System.out.print(mazeContainer[i][j].getDown()==null?"---":"   ");
						}
					}
					System.out.println("+");
				}
			}
			for(int i = 0;i<mazeContainer.length*4-3;i++)
			{
				System.out.print(" ");
			}
			System.out.println("Exit");
		}
		else
		{
			System.out.println("No path founded for this maze!");
		}
	}
	
	// main method for testing
	public static void main(String [] args)
	{
		int size = 0;
		Scanner scanner = new Scanner(System.in);
		do
		{
			System.out.println("Please enter the maze size:");
			size = scanner.nextInt();
			if(size<=0)
			{
				System.out.println("Maze size must be positive integer!");
			}
		}
		while(size<=0);
		scanner.close();
		maze mz = new maze(size);
		mz.printMaze();
		
		mz.BFS();
		mz.printVisitedOrder();
		mz.printPath();
		
		mz.DFS();
		mz.printVisitedOrder();
		mz.printPath();
	}
	
	

}
