package sjsu.Liu.cs146.project3;

public class RBNode<Key extends Comparable<Key>>
{
    private Key data;
    private RBNode<Key> leftChild;
    private RBNode<Key> rightChild;
    private RBNode<Key> parent;
    public enum Color {red, black};
    private Color color = Color.red;  // default color is red
    
    public RBNode(Key newData) //constructor
    {
    	this.data = newData;
    	this.leftChild = null;
    	this.rightChild = null;
    	this.parent = null;
    	this.color = Color.red;
    }
    
    //getters
    public Key getData() {return this.data;}  
    public RBNode<Key> getLeft () {return this.leftChild;}
    public RBNode<Key> getRight (){return this.rightChild;}
    public RBNode<Key> getParent (){return this.parent;}
    public Color getColor(){return this.color;}
    
    //setters
    public void setData(Key newData)        
    {
    	this.data = newData;
    }
    
    public void setLeft(RBNode<Key> newNode)
    {
    	this.leftChild = newNode;
    }
    public void setRight(RBNode<Key> newNode)
    {
    	this.rightChild = newNode;
    }
    public void setParent(RBNode<Key> newNode)
    {
    	this.parent = newNode;
    }
    public void changeColor() //flip the color
    {
    	this.color = this.color == Color.red ? Color.black: Color.red;
    }
    public void setColor(Color color)
    {
    	this.color = color;
    }
}      
