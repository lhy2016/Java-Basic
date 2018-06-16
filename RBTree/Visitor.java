package sjsu.Liu.cs146.project3;

public interface Visitor<Key extends Comparable<Key>>
{
    void visit(RBNode<Key> n);
    void clear();
}