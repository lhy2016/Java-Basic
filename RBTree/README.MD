<h3>Red Black Binary Search Tree</h3>
<p>This project implements a red black tree. Generic data type is used. 
Every time a new node is inserted into the RBT, a fixup algorithm fix the tree starting from current Node recursively, 
to ensure that the tree is always balanced, which means the longest path from the root to a leaf cannot be 
more than twice of the shortest path from the root to a leaf.</p>
<p>   Additionally, since the RBT is a balanced BST, this project include all general method a BST should include such as insert(), search(), getSibling(), getAunt(), getParent(), print(), rotateLeft/Right(), inOrder(), preOrder(), postOrder() and a unique fixTree() method which is designed to make the RBT balanced.
    The program is used to build a dictionary: add words from an input text file to a RBT, which is a smaller version of a real dictionary. Then look up the word in the dictionary by using RBT’s search algorithm. The running time is O(lg(n))
</p>
<p>Since the characteristics of RBT determines that it is a sorted data structure, the input data should not be duplicate with each other. For our cases, we use words(String). </p>
<p>Since it’s very hard, in real life situation, that we can find an extremely long paragraph with no duplicate words, I only found a very short paragraph and apply my algorithm on it. Therefore, the search() algorithm complete really fast(0 ms). For the need of future development, a method which removes all duplicate words in a paragraph would be nice to optimize this project, then we can expect to have an almost real dictionary as long as we have a fairly large input.
</p>
