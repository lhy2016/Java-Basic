package sjsu.Liu.cs146.project4;
import static org.junit.Assert.*;
import java.io.FileReader;
import java.io.BufferedReader;
import org.junit.Test;

public class maze_JunitTest 
{

	@Test
	// Test case 1, size: 4
	public void test_size_4() throws Exception
	{
		
		maze mz1 = new maze(4);
		String size_4_solution = 
				  "Entrance\n"
				+ "+   +---+---+---+\n"
				+ "| #   # |       |\n"
				+ "+---+   +   +   +\n"
				+ "| #   # |   |   |\n"
				+ "+   +---+   +   +\n"
				+ "| #   # |   |   |\n"
				+ "+---+   +---+   +\n"
				+ "|     #   #   # |\n"
				+ "+---+---+---+   +\n"
				+ "             Exit\n";
		
		mz1.printMaze();
		
		mz1.BFS();
		mz1.printVisitedOrder();
		mz1.printPath();
		
		mz1.DFS();
		mz1.printVisitedOrder();
		mz1.printPath();
		
		String size_4_output = readFileIntoString("size_4_output.txt");
		assertEquals(size_4_output,size_4_solution);
	}
	
	@Test
	public void test_size_6() throws Exception
	{
		// Test case 2, size: 6
				maze mz2 = new maze(6);
				String size_6_solution = 
						  "Entrance\n"
						+ "+   +---+---+---+---+---+\n"
						+ "| #   # | #   #   # |   |\n"
						+ "+---+   +   +---+   +   +\n"
						+ "| #   # | # | #   # |   |\n"
						+ "+   +---+   +   +---+   +\n"
						+ "| #   # | # | #   #   # |\n"
						+ "+---+   +   +---+---+   +\n"
						+ "| #   # | # | #   #   # |\n"
						+ "+   +---+   +   +---+---+\n"
						+ "| #   #   # | #   # |   |\n"
						+ "+---+---+---+---+   +   +\n"
						+ "|                 #   # |\n"
						+ "+---+---+---+---+---+   +\n"
		                + "                     Exit\n";
				mz2.printMaze();
				
				mz2.BFS();
				mz2.printVisitedOrder();
				mz2.printPath();
				
				mz2.DFS();
				mz2.printVisitedOrder();
				mz2.printPath();
				
				String size_6_output = readFileIntoString("size_6_output.txt");
				assertEquals(size_6_output,size_6_solution);
	}
	@Test
	public void test_size_8() throws Exception
	{
		// Test case 3, size: 8
		maze mz3 = new maze(8);
		String size_8_solution = 
				    "Entrance\n"
				  + "+   +---+---+---+---+---+---+---+\n"
				  + "| #   # | #   #   # |           |\n"
				  + "+---+   +   +---+   +   +---+   +\n"
				  + "| #   # | # | #   # |   |       |\n"
				  + "+   +---+   +   +---+---+   +---+\n"
				  + "| #   # | # | #   #   # |       |\n"
				  + "+---+   +   +---+---+   +---+   +\n"
				  + "| #   # | # | #   # | #   #   # |\n"
				  + "+   +---+   +   +   +---+---+   +\n"
				  + "| #   #   # | # | #   #   #   # |\n"
				  + "+---+---+---+   +---+---+---+---+\n"
				  + "|           | #   # |           |\n"
				  + "+   +---+   +---+   +   +---+   +\n"
				  + "|       |   | #   # |       |   |\n"
				  + "+---+   +   +   +---+---+---+   +\n"
				  + "|       |     #   #   #   #   # |\n"
				  + "+---+---+---+---+---+---+---+   +\n"
				  + "                             Exit\n";
		mz3.printMaze();
		
		mz3.BFS();
		mz3.printVisitedOrder();
		mz3.printPath();
		
		mz3.DFS();
		mz3.printVisitedOrder();
		mz3.printPath();
		
		String size_8_output = readFileIntoString("size_8_output.txt");
		assertEquals(size_8_output,size_8_solution);
	}
	
	@Test
	public void test_size_10() throws Exception
	{
		// Test case 4, size: 10
				maze mz4 = new maze(10);
				String size_10_solution = 
						      "Entrance\n"
						    + "+   +---+---+---+---+---+---+---+---+---+\n"
						    + "| #   # | #   #   # |                   |\n"
						    + "+---+   +   +---+   +   +---+---+   +   +\n"
						    + "| #   # | # | #   # |           |   |   |\n"
						    + "+   +---+   +   +---+---+---+   +   +---+\n"
						    + "| #   # | # | #   #   # |       |       |\n"
						    + "+---+   +   +---+---+   +---+---+---+   +\n"
						    + "| #   # | # |       | #   #   #   #   # |\n"
						    + "+   +---+   +   +---+---+---+---+---+   +\n"
						    + "| #   #   # |   | #   #   #   # | #   # |\n"
						    + "+---+---+---+   +   +---+---+   +   +---+\n"
						    + "|               | # |       | # | # |   |\n"
						    + "+   +---+---+   +   +---+   +   +   +   +\n"
						    + "|   |       |   | # | #   # | # | #   # |\n"
						    + "+   +---+   +   +   +   +   +   +---+   +\n"
						    + "|   |       |   | #   # | # | # | #   # |\n"
						    + "+   +   +---+   +---+---+   +   +   +---+\n"
						    + "|   |   |               | # | #   # |   |\n"
						    + "+   +   +   +---+---+---+   +---+---+   +\n"
						    + "|       |                 #   #   #   # |\n"
						    + "+---+---+---+---+---+---+---+---+---+   +\n"
						    + "                                     Exit\n";
				mz4.printMaze();
				
				mz4.BFS();
				mz4.printVisitedOrder();
				mz4.printPath();
				
				mz4.DFS();
				mz4.printVisitedOrder();
				mz4.printPath();
				
				String size_10_output = readFileIntoString("size_10_output.txt");
				assertEquals(size_10_output,size_10_solution);
	}
	@Test
	public void test_BFS_equalsTo_DFS()throws Exception
	{
		//Test Case 5: to test if BFS and DFS print the exactly same path
		String BFS = readFileIntoString("BFS.txt");
		String DFS = readFileIntoString("DFS.txt");
		assertEquals(BFS,DFS);
		
	}
	
	public String readFileIntoString(String fileName) throws Exception
	{
		FileReader file = new FileReader(fileName);
		BufferedReader reader = new BufferedReader(file);
		
		String text = "";
			reader.readLine(); //skip
			reader.readLine(); //skip
			reader.readLine();// skip
			reader.readLine();// skip
			reader.readLine();// skip
			reader.readLine(); //read from 6th line
			String line = reader.readLine();
		while(line != null)
		{
			text+=line+"\n";
			line = reader.readLine();
		}
		return text;
	}

	
}
