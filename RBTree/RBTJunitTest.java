package sjsu.Liu.cs146.project3;

import static org.junit.Assert.*;

import org.junit.Test;

import sjsu.Liu.cs146.project3.RBTree.MyVisitor;

public class RBTJunitTest 
{
	

	@Test
	public void test() 
	{
		RBTree<String> rbt = new RBTree<String>();
		 rbt.insert("D");         
		 rbt.insert("B");         
		 rbt.insert("A");         
		 rbt.insert("C");         
		 rbt.insert("F");         
		 rbt.insert("E");        
		 rbt.insert("H");         
		 rbt.insert("G");        
		 rbt.insert("I");         
		 rbt.insert("J");
		 RBTree<String>.MyVisitor v = rbt.new MyVisitor();   
		 rbt.preOrderVisit(v, rbt.getRoot());
		 assertEquals("DBACFEHGIJ", v.result);
		 
String str = 		 
"Color: black, Key:D Parent: \n"+
"Color: black, Key:B Parent: D\n"+
"Color: black, Key:A Parent: B\n"+
"Color: black, Key:C Parent: B\n"+
"Color: black, Key:F Parent: D\n"+
"Color: black, Key:E Parent: F\n"+
"Color: red, Key:H Parent: F\n"+
"Color: black, Key:G Parent: H\n"+
"Color: black, Key:I Parent: H\n"+
"Color: red, Key:J Parent: I\n";
		
		 
		 /*   // b for black, r for red
		 *                         D(b)
		 *                       /     \
		 *                    B(b)        F(b)
		 *                   /    \      /  \
		 *               A(b)    C(b)  E(b)   H(r)
		 *                                   /   \
		 *                                  G(b)  I(b)
		 *                                            \
		 *                                             J(r)
		 * 
		 * */
		 
	
		
		assertEquals(str, makeStringDetails(rbt));
		
		// I DON'T KNOW WHY THE STATEMENT ABOVE DIDN'T PASS THE UNIT TEST!
        // Then I checked each node's key and color, it seems they are ALL CORRECT
		 
		
		 //D:
		 RBNode<String> x = rbt.getRoot();     
		 System.out.println(x.getData()+" "+x.getColor());  
		 
		 //B:
		 x = rbt.getRoot().getLeft();          
		 System.out.println(x.getData()+" "+x.getColor());
		 
		 //A:
		 x = rbt.getRoot().getLeft().getLeft();
		 System.out.println(x.getData()+" "+x.getColor());
		 
		 //C:
		 x = rbt.getRoot().getLeft().getRight();
		 System.out.println(x.getData()+" "+x.getColor());
		 
		 //F:
		 x = rbt.getRoot().getRight();
		 System.out.println(x.getData()+" "+x.getColor());
		 
		 //E:
		 x = rbt.getRoot().getRight().getLeft();
		 System.out.println(x.getData()+" "+x.getColor());
		 
		 //H:
		 x = rbt.getRoot().getRight().getRight();
		 System.out.println(x.getData()+" "+x.getColor());
		 
		 //G:
		 x = rbt.getRoot().getRight().getRight().getLeft();
		 System.out.println(x.getData()+" "+x.getColor());;
		 
		 //I:
		 x = rbt.getRoot().getRight().getRight().getRight();
		 System.out.println(x.getData()+" "+x.getColor());
		 
		 //J:
		 x = rbt.getRoot().getRight().getRight().getRight().getRight();
		 System.out.println(x.getData()+" "+x.getColor());
		 

		 
	}
	
	public static String makeStringDetails(RBTree<String> t) 
	{
		class MyVisitor implements Visitor<String> 
		{
			String result = "";
	    	public void visit(RBNode<String> n)
	    	{
	    		if(!(n.getData()).equals(""))
	    	    result = result +"Color: "+n.getColor().toString()+", Key:"+n.getData().toString()+" Parent: "+(n.getParent() != null? n.getParent().getData().toString():"")+"\n";
	    	}
	    	public void clear()
	    	{
	    		result = "";
	    	}
		};
	    MyVisitor v = new MyVisitor();
	    v.clear();
	    t.preOrderVisit(v,t.getRoot());
	    return v.result;
	    	 
	 }
}


