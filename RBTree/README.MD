<h3>Red Black Binary Search Tree</h3>
<p>This project implements a red black tree. Generic data type is used. 
Every time a new node is inserted into the RBT, a fixup algorithm fix the tree starting from current Node recursively, 
to ensure that the tree is always balanced, which means the longest path from the root to a leaf cannot be 
more than twice of the shortest path from the root to a leaf.</p>
<p>   Additionally, since the RBT is a balanced BST, this project include all general method a BST should include such as insert(), search(), getSibling(), getAunt(), getParent(), print(), rotateLeft/Right(), inOrder(), preOrder(), postOrder() and a unique fixTree() method which is designed to make the RBT balanced.
    The program is used to build a dictionary: add words from an input text file to a RBT, which is a smaller version of a real dictionary. Then look up the word in the dictionary by using RBT’s search algorithm. The running time is O(lg(n))
</p>
<p>Since the characteristics of RBT determines that it is a sorted data structure, the input data should not be duplicate with each other. For our cases, we use words(String). </p>
