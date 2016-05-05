package de.hs_mannheim.ss16.tpe.g1_1.uebung1;

public interface BTreeInterface {
    
    /**
     * Makes inserting Integer values into the B-Tree possible
     * @param o is the value which is to be inserted into the tree
     * @return Boolean which declares whether insertion was successful
     */
    public boolean insert (Integer o);
    
    /**
     * Enables the user to insert several Integers saved in a file to the tree with a single method
     * @param Filename is the path where the file you are calling is saved
     * @return Boolean which declares whether insertion was successful
     */
    public boolean insert (String filename);
    
    /**
     * Checks whether the BTree already contains the Integer o
     * @return Boolean which declares whether value is contained
     */
    public boolean contains(Integer o);
    
    /**
     * 
     * @return The size of the tree(number of all values saved in it) as an int 
     */
    public int size();
    
    /**
     * 
     * @return The height of the tree as an int
     */
    public int height();
    
    /**
     * 
     * @return The maximum value contained in the BTree
     */
    public Integer getMax();
    
    /**
     * 
     * @return The minimum value contained in the BTree
     */
    public Integer getMin();
    
    /**
     * Checks whether the tree contains no values(Integers)
     * @return Boolean which declares whether the tree is empty
     */
    public boolean isEmpty();
    
    /**
     * Adds all values of another BTree to your current BTree
     */
    public void addAll(BTree otherTree);
    
    /**
     * Prints all values of the tree sorted by size
     */
    public void printInorder();
    
    /**
     * Prints all values
     * First the node's values then its left successor's values and then its right successor(s)' value(s)
     */
    public void printPostorder();
    
    /**
     * Prints all values
     * First the left successor's value then the right successor(s)' values and then the node's values
     */
    public void printPreorder();
    
    /**
     * Prints all values based on their level(their height) in the tree starting by the root 
     */
    public void printLevelorder();

    /**
     * 
     * @return deep copy of the tree
     */
    public BTree cloneDeep();
}
