package de.hs_mannheim.ss16.ib.tpe.g1_1.uebung2.teil2.aufgabe1;

/**
 * this class models a node of BTree
 *
 */
public class BTreeNode {
    private int degree;
    private Comparable elements []; // values of node
    private BTreeNode references []; // children of node

    public BTreeNode(int degree){
        this.degree=degree;
        elements = new Integer[2*degree+1];
        references = new BTreeNode[2*degree+2];
    }

    public int getDegree() {
        return degree;
    }
    
    /**
     * 
     * @return elements of node
     */
    public Comparable[] getElements(){
        return this.elements;
    }

    /**
     * 
     * @return references (children) of node
     */
    public BTreeNode[] getReferences(){
        return this.references;
    }

    /**
     * 
     * @param pos
     * @return element at specified position pos
     */
    private Comparable findObject(int pos){
        Comparable object = null;

        for(int i=0;i <= pos;i++){
            object = elements[i];
        }
        return object;
    }

    /**
     * 
     * @param pos
     * @return value of element at specifief position pos
     */
    public Comparable getValue(int pos){
        if (pos >= elements.length || pos < 0)
            return null;

        Comparable val = findObject(pos);

        return val;
    }

    /**
     * checks, if node has any references (children)
     * @return true, when it has at least one reference (child). Otherwise false.
     */
    public boolean hasReferences() {
        for (int i = 0; i < this.references.length; i++) {
            if (this.references[i] != null)
                return true;
        }

        return false;
    }

    /**
     * assigns a new set of references (children) to node
     * @param newReferences
     *                      new references (new children)
     */
    public void setReferences(BTreeNode[] newReferences) {
        this.references = newReferences;
    }

    /**
     * 
     * @return the highest value of the node. null, if node is empty
     */
    public Comparable getMax() {
        int i = this.getElements().length-1;
        while (i >= 0 && this.getElements()[i] == null)
            i--;

        if (i < 0)
            return null;
        else
            return this.getValue(i);
    }

    /**
     * 
     * @return the smallest value of the node. null, if node is empty
     */
    public Comparable getMin() {
        if (this.getElements()[0] != null)
            return this.getValue(0);
        else
            return null;
    }

    public int getNumberOfElements() {
        int numberOfElements = 0;
        while (this.getElements()[numberOfElements] != null)
            numberOfElements++;
        return numberOfElements;
    }

    /**
     * adds the value val at the specified position index in node. All greater values will
     * be pushed one index further
     * @param index
     *              the position, where the value shall be added
     * @param val
     *            value to be added
     */
    public void addVal(int index, Comparable val) {
        if (this.elements[elements.length - 1] != null)
            return;

        for(int i = this.getElements().length-2;i >= index;i--){
            this.getElements()[i+1] = this.getElements()[i];
            this.getReferences()[i+2] = this.getReferences()[i+1];
        }
        this.getElements()[index] = val;
    }

    /**
     * @return a BTreeNode with a deep copy of its elements without copying the references
     */
    public BTreeNode cloneDeep() {
        BTreeNode clone = new BTreeNode(this.degree);

        int i = 0;
        while (i < this.elements.length && this.elements[i] != null) {
            clone.getElements()[i] = this.getValue(i);
            i++;
        }

        return clone;
    }
}
