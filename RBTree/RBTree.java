package sjsu.Liu.cs146.project3;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class RBTree <Key extends Comparable<Key>>
{
	private enum LRN{leftChild,rightChild,none} //none means the node doesn't have a parent
	private RBNode<Key> root;

	class MyVisitor implements Visitor<Key>
	{           
		String result = "";           
		public void visit(RBNode<Key> n)           
		{              
			result = result + ""+n.getData();           
		}
		public void clear()
		{
			result = "";
		}
	}
	//MyVisitor v = new MyVisitor();
	
	public RBTree()
	{
		root = null;
	}
	
	public RBNode<Key> getRoot() {return this.root;}
	
	public void insert(Key newData)
	{
		RBNode <Key> newNode = new RBNode<Key>(newData);
		if(root == null)
		{
			newNode.changeColor();   // change color to black
			root = newNode;
		}
		else
		{
			RBNode<Key> temp = root;
			while(temp != null)
			{
				if(newData.compareTo(temp.getData()) < 0) // if less than current
				{
					if(temp.getLeft()!=null)
					{
						temp = temp.getLeft();        // go to left
					}
					else
					{
						temp.setLeft(newNode);        // or insert at left
						newNode.setParent(temp);
						fixTree(newNode);                          
						temp = null;
					}
				}
				else if(newData.compareTo(temp.getData()) > 0)//if greater than current
				{
					if(temp.getRight()!=null)
					{
						temp = temp.getRight();				  // go to right
					}
					else
					{
						temp.setRight(newNode);              // or insert at right
						newNode.setParent(temp);
						fixTree(newNode);								
						temp = null;
					}
				}
				else										// if equal, exit.
				{
					System.out.println("Insertion fail! Duplicate element error!");
					temp = null;
				}
			}
		}
	}
	
	public RBNode<Key> search(Key data, MyVisitor v)
	{
		RBNode<Key> temp = root;
		while(temp!=null)
		{
			v.visit(temp);
			if(data.compareTo(temp.getData()) == 0)
			{
				return temp;
			}
			else if(data.compareTo(temp.getData())<0)
			{
				temp = temp.getLeft();
			}
			else
			{
				temp = temp.getRight();
			}
		}
		return null;
	}
	
	public void preOrderVisit(Visitor<Key> v)
	{
		preOrderVisit(v,root);
	}
	
	public void preOrderVisit(Visitor<Key> v,RBNode<Key> root)
	{
		if(root!=null)
		{
			v.visit(root);
			preOrderVisit(v,root.getLeft());
			preOrderVisit(v,root.getRight());
		}
	}
	
	public void inOrderVisit(MyVisitor v,RBNode<Key> root)
	{
		if(root!=null)
		{
			inOrderVisit(v,root.getLeft());
			v.visit(root);
			inOrderVisit(v,root.getRight());
		}
	}
	
	public void postOrderVisit(MyVisitor v,RBNode<Key> root)
	{
		if(root!=null)
		{
			postOrderVisit(v,root.getLeft());
			postOrderVisit(v,root.getRight());
			v.visit(root);
		}
	}
	
	public void print(MyVisitor v)
	{
		v.clear();
		preOrderVisit(v,root);
		System.out.println(v.result);
	}
	
	private RBNode<Key> getSibling(RBNode<Key> node)
	{
		if(this.leftRightOrNoneChildOfParent(node) == LRN.none)
		{
			return null;
		}
		else if(this.leftRightOrNoneChildOfParent(node) == LRN.leftChild)
		{
			return node.getParent().getRight();
		}
		else
		{
			return node.getParent().getLeft();
		}
	}
	
	private RBNode<Key> getAunt(RBNode<Key> node)
	{
		if(this.getGrandparent(node) == null)
		{
			return null;
		}
		else 
		{
			return this.getSibling(node.getParent());
		}
	}
    
	private RBNode<Key> getGrandparent(RBNode<Key> node)
	{
		if(node.getParent() == null)
		{
			return null;
		}
		else
		{
			return node.getParent().getParent();
		}
	}
	
	private void rotateLeft(RBNode<Key> x)
	{
		if(x.getRight() != null)
		{
			RBNode<Key> y = x.getRight();
			RBNode<Key> B = y.getLeft();
			y.setLeft(null);  //disconnect
			if(B!=null)
			{
				B.setParent(null);
			}
			x.setRight(null);
			y.setParent(null);
			if(this.leftRightOrNoneChildOfParent(x) == LRN.none)       // if x is the root
			{
				root = y;
				y.setParent(null);
			}
			else if(this.leftRightOrNoneChildOfParent(x) == LRN.leftChild)
			{
				x.getParent().setLeft(y);
				y.setParent(x.getParent());
				x.setParent(null);
			}
			else
			{
				x.getParent().setRight(y);
				y.setParent(x.getParent());
				x.setParent(null);
			}
			y.setLeft(x);
			x.setParent(y);
			x.setRight(B);
			if(B!=null)
			{
				B.setParent(x);
			}
		}
	}
	
	private void rotateRight(RBNode<Key> y)
	{
		if(y.getLeft() != null)
		{
			RBNode<Key> x = y.getLeft();
			RBNode<Key> B = x.getRight();
			x.setRight(null); //disconnect
			if(B!=null)
			{
				B.setParent(null);
			}
			y.setLeft(null);
			x.setParent(null);
			if(this.leftRightOrNoneChildOfParent(y) == LRN.none)
			{
				root = x;
				x.setParent(null);
			}
			else if(this.leftRightOrNoneChildOfParent(y)==LRN.leftChild)
			{
				y.getParent().setLeft(x);
				x.setParent(y.getParent());
				y.setParent(null);
			}
			else
			{
				y.getParent().setRight(x);
				x.setParent(y.getParent());
				y.setParent(null);
			}
			x.setRight(y);
			y.setParent(x);
			y.setLeft(B);
			if(B!=null)
			{
				B.setParent(y);
			}
		}	
	}
	
	private void fixTree(RBNode<Key> current)
	{
		// for root, changing to black is already implmented in insert()
		if(current!= root)
		{
			if(current.getParent().getColor() == RBNode.Color.black)
			{
				return;
			}
			else if(current.getColor() == RBNode.Color.red) // if parent is red, current is red (red parent means grandparent is not empty)
			{
				if(getAunt(current)==null || getAunt(current).getColor() == RBNode.Color.black)// Case I: if aunt is black
				{
					if(this.leftRightOrNoneChildOfParent(current.getParent()) == LRN.leftChild) // Case I:and parent is left child
					{
						if(this.leftRightOrNoneChildOfParent(current)== LRN.rightChild) //Case I(A):  and current is right child
						{
							rotateLeft(current.getParent());
							fixTree(current.getLeft());
						}
						else // Case I(C): and current is left child
						{
							current.getParent().changeColor();  // make parent black
							getGrandparent(current).setColor(RBNode.Color.red); // make grandparent red
							rotateRight(getGrandparent(current));
						}
					}
					
					else if(this.leftRightOrNoneChildOfParent(current.getParent()) == LRN.rightChild) //CaseI: and parent is 
					{
						if(this.leftRightOrNoneChildOfParent(current) == LRN.leftChild)//CaseI(B):and current is right child
						{
							rotateRight(current.getParent());
							fixTree(current.getRight());
						}
						else  // Case I(D): and current is left child
						{
							current.getParent().changeColor(); //make parent black
							getGrandparent(current).setColor(RBNode.Color.red);
							rotateLeft(getGrandparent(current));
						}
					}
				}
				
				else       // Case II: if the aunt is red
				{
					current.getParent().changeColor();
					getAunt(current).changeColor();
					if(getGrandparent(current)!=root)
					{
						getGrandparent(current).setColor(RBNode.Color.red);
					}
					fixTree(getGrandparent(current));
				}
			}
		}
	}
	
	private LRN leftRightOrNoneChildOfParent(RBNode<Key> node) // determine if a node is a left, right or none child of its parent
    {
    	if(node.getParent() == null)
    	{
    		return LRN.none;
    	}
    	else if(node.getParent().getLeft() == node)
    	{
    		return LRN.leftChild;
    	}
    	else
    	{
    		return LRN.rightChild;
    	}
    }
	
	public static void main(String [] args) 
	{
		System.out.println("Start creating dictionary using RB tree...");
		long time1 = System.currentTimeMillis();
		RBTree<String> dictionary = new RBTree <String>();
		try {
		Scanner scanner = new Scanner(new File("test.txt"));
 		while(scanner.hasNext())
 		{
 			String line = scanner.nextLine();
 			String[] words = line.split("[\\p{Punct}\\s]+");
 			for(int i = 0;i<words.length;i++)
 			{
 				dictionary.insert(words[i]);
 			}
 		}
		}
 		catch(IOException e) {
 			System.out.println(e);
 		}
 		long timeToCreate = System.currentTimeMillis()-time1;
 		System.out.println("Dictionary finished in "+timeToCreate+" ms");
 		
 		RBTree<String>.MyVisitor v = dictionary.new MyVisitor();
 		long time2 = System.currentTimeMillis();
 		v.clear();
 		String wordToSearch = "music";
 		dictionary.search(wordToSearch, v);
 		System.out.print("Searched words: ");
 		System.out.println(v.result);
 		long timeToSearch = System.currentTimeMillis()-time2;
 		System.out.println("Found "+wordToSearch+" in "+timeToSearch+" ms.");
 		
	}
}
