package de.hs_mannheim.ss16.tpe.g1_1.uebung2.teil2.aufgabe1;

import static gdi.MakeItSimple.*;

public class BTree implements BTreeInterface {

    private String className; // Class name of the objects which are being managed
    private BTreeNode root;
    private int degree;
    private int height;
    private int size;
    private Comparable max;
    private Comparable min;

    public BTree (int degree) {
        if (degree <= 0)
            throw new GDIException("Invalid degree!");

        this.root = new BTreeNode(degree);
        this.degree = degree;
    }

    private BTree (BTreeNode root) {
        this.root = root;
    }

    @Override
    public boolean insert(Comparable o) {
        if (this.isEmpty() && o != null)
            this.className = o.getClass().getSimpleName();
        
        if (o == null || this.contains(o)) {
            return false;
        } else {
            BTreeNode node = this.root;

            // find correct BTreeNode for insertion
            int i = 0;
            while (node.hasReferences()) {
                if (node.getValue(i).compareTo(o) > 0) {
                    node = node.getReferences()[i];
                    i = 0;
                } else {
                    i++;

                    if (node.getElements()[i] == null || i == node.getElements().length - 1) {
                        node = node.getReferences()[i];
                        i = 0;
                    }
                }
            }

            int insertPos = findInsertPos(node, o);
            node.addVal(insertPos, o);

            while (checkOverflow(node)) {
                if (node == this.root) {
                    BTreeNode newRoot = new BTreeNode(degree);
                    BTreeNode newRight = new BTreeNode(degree);

                    newRoot.getReferences()[0] = node;
                    newRoot.getReferences()[1] = newRight;
                    newRoot.getElements()[0] = node.getElements()[degree];

                    // newRight gets all values and references from index degree to BTreeNode's end
                    // node is going to be left child of newRoot now
                    // node gets all values and references till the index degree; all other values will be deleted
                    // references of node will be saved in newReferencesOfNode
                    int j = 0;
//                    BTreeNode[] newReferencesOfNode = new BTreeNode[2*degree+2];
                    for (i = degree + 1; i < node.getElements().length; i++, j++) {
                        newRight.getElements()[j] = node.getElements()[i];
                        node.getElements()[i] = null;
//                        newReferencesOfNode[j] = node.getReferences()[j];
                        newRight.getReferences()[j] = node.getReferences()[i];
                        node.getReferences()[i] = null;
                    }
                    newRight.getReferences()[j] = node.getReferences()[i];
                    node.getReferences()[i] = null;
//                    newReferencesOfNode[j] = node.getReferences()[degree];
//                    node.setReferences(newReferencesOfNode);
                    node.getElements()[degree] = null;


                    this.root = newRoot;
                    this.height++; // root pop -> tree grows
                } else {
                    BTreeNode parent = getParentOf(node);
                    BTreeNode newRight = new BTreeNode(degree);
                    Comparable newValForParent = node.getValue(degree);
                    insertPos = findInsertPos(parent, node.getValue(degree));
                    parent.addVal(insertPos, newValForParent);

                    // newRight gets all values and references from index degree to BTreeNode's end
                    // node splits itself and will only retain its left half 
                    int j = 0;
//                    BTreeNode[] newReferencesOfNode = new BTreeNode[2*degree+2];
                    for (i = degree + 1; i < node.getElements().length; i++, j++) {
                        newRight.getElements()[j] = node.getElements()[i];
                        node.getElements()[i] = null;
//                        newReferencesOfNode[j] = node.getReferences()[j]; 
                        newRight.getReferences()[j] = node.getReferences()[i];
                        node.getReferences()[i] = null;
                    }
                    newRight.getReferences()[j] = node.getReferences()[i];
                    node.getReferences()[i] = null;
//                    newReferencesOfNode[j] = node.getReferences()[degree];
//                    node.setReferences(newReferencesOfNode);

                    parent.getReferences()[insertPos + 1] = newRight;
                    node.getElements()[degree] = null;


                    node = parent;
                }
            }
        }

        this.size++;

        if (this.max == null || o.compareTo(this.max) > 0)
            this.max = o;

        if (this.min == null || o.compareTo(this.min) < 0)
            this.min = o;

        return true;
    }

    public boolean delete(Comparable o) {
        if (!contains(o)) {
            return false;
        } else {
            BTreeNode node = this.root;
            
            int i = 0;
            while (node.getValue(i).compareTo(o) != 0) {
                if (node.getValue(i).compareTo(o) > 0) {
                    node = node.getReferences()[i];
                    i = 0;
                } else if (node.getValue(i).compareTo(o) < 0) {
                    i++;

                    if (node.getElements()[i] == null || i == node.getElements().length - 1) {
                        node = node.getReferences()[i];
                        i = 0;
                    }
                }
            }
            
            node.getElements()[i] = null;
            int indexOfDeletedElement = i;
            if (node == root) {
                if (node.hasReferences()) {
                    // replace empty place of node with greatest element of its left sub tree
                    if (getGreatestFromLeftSubtree(node, indexOfDeletedElement) != null) {
                        node.getElements()[indexOfDeletedElement] = getGreatestFromLeftSubtree(node, indexOfDeletedElement);
                    // replace empty place of node with smallest element of its right sub tree
                    } else if (getSmallestFromRightSubtree(node, indexOfDeletedElement) != null) {
                        node.getElements()[indexOfDeletedElement] = getSmallestFromRightSubtree(node, indexOfDeletedElement);
                    } else {
                        // Situationen wo sich die Höhe des Baumes ändert
                    }
                } else {
                    // no problem
                }
            } else {
                if (node.getNumberOfElements() < degree) {
                    if (node.hasReferences()) {
                        // replace empty place of node with greatest element of its left sub tree
                        if (getGreatestFromLeftSubtree(node, indexOfDeletedElement) != null) {
                            node.getElements()[indexOfDeletedElement] = getGreatestFromLeftSubtree(node, indexOfDeletedElement);
                        // replace empty place of node with smallest element of its right sub tree
                        } else if (getSmallestFromRightSubtree(node, indexOfDeletedElement) != null) {
                            node.getElements()[indexOfDeletedElement] = getSmallestFromRightSubtree(node, indexOfDeletedElement);
                        } else {
                          // Situationen wo sich die Höhe des Baumes ändert  
                        }
                    } else {
                        // node is leaf
                        
                        // node is a leaf
                        // push all elements one to the left from the index of the deleted element
                        for (int j = indexOfDeletedElement; j < node.getElements().length - 2; j++)
                            node.getElements()[j] = node.getElements()[j+1];

                        BTreeNode parent = getParentOf(node);
                        BTreeNode leftSibling = null;
                        BTreeNode rightSibling = null;
                        int childIndex = 0;
                        while (parent.getReferences()[childIndex] != node)
                            childIndex++;

                        if (childIndex > 0)
                            leftSibling = parent.getReferences()[childIndex - 1];

                        if (childIndex < parent.getReferences().length - 1)
                            rightSibling = parent.getReferences()[childIndex + 1];

                        // push greatest element of left sibling up to parent
                        // and push parent element down to correct underflow of node
                        if (leftSibling != null && leftSibling.getNumberOfElements() > degree) {
                            Comparable newValForNode = parent.getElements()[childIndex - 1];
                            Comparable newValForParent = leftSibling.getMax();
                            
                            parent.getElements()[childIndex - 1] = newValForParent;
                            node.addVal(0, newValForNode);
                            leftSibling.getElements()[leftSibling.getNumberOfElements() - 1] = null;
                            this.size--;
                            
                        // push smallest element of right sibling up to parent
                        // and push parent element down to correct underflow of node
                        } else if (rightSibling != null && rightSibling.getNumberOfElements() > degree) {
                            Comparable newValForNode = parent.getElements()[childIndex];
                            Comparable newValForParent = rightSibling.getMin();
                            
                            parent.getElements()[childIndex] = newValForParent;
                            node.addVal(node.getNumberOfElements(), newValForNode);
                            for (int j = 0; j < rightSibling.getNumberOfElements(); j++)
                                rightSibling.getElements()[j] = rightSibling.getElements()[j+1];
                            this.size--;
                            
                        } else {
                            // right or left sibling or both of them have minimum number of elements
                            // push parent element down and merge specified children
                            if (parent.getNumberOfElements() > degree) {
                                if (leftSibling != null) {
                                    Comparable parentElementOfleftSiblingAndNode = parent.getElements()[childIndex - 1];
                                    node.addVal(0, parentElementOfleftSiblingAndNode);
                                    BTreeNode newChild = merge(leftSibling, node);
                                    for (int j = childIndex - 1; j < parent.getElements().length-2; j++) {
                                        parent.getElements()[j] = parent.getElements()[j+1];
                                        parent.getReferences()[j+1] = parent.getReferences()[j+2];
                                    }
                                    parent.getReferences()[childIndex - 1] = newChild;
                                } else {
                                    Comparable parentElementOfrightSiblingAndNode = parent.getElements()[childIndex];
                                    node.addVal(node.getNumberOfElements(), parentElementOfrightSiblingAndNode);
                                    BTreeNode newChild = merge(node, rightSibling);
                                    for (int j = childIndex; j < parent.getElements().length-2; j++) {
                                        parent.getElements()[j] = parent.getElements()[j+1];
                                        parent.getReferences()[j+1] = parent.getReferences()[j+2];
                                    }
                                    parent.getReferences()[childIndex] = newChild;
                                }
                            } else {
                                // Situationen wo sich die Höhe des Baumes ändert
                            }
                        }
                    }
                }
            }
            return true;
        }
    }
    
    private BTreeNode merge(BTreeNode nodeWithSmallerElements, BTreeNode nodeWithGreaterElements) {
        if (isMergeable(nodeWithSmallerElements, nodeWithGreaterElements)) {
            BTreeNode mergedNode = new BTreeNode(degree);
            BTreeNode[] referencesOfMergedNode = new BTreeNode[2*degree+2];
            int numberOfElements = nodeWithSmallerElements.getNumberOfElements() + nodeWithGreaterElements.getNumberOfElements();
            int i;
            for (i = 0; i < numberOfElements; i++) {
                // last references of nodeWithSmallerElements
                if (i == nodeWithSmallerElements.getNumberOfElements())
                    referencesOfMergedNode[i] = nodeWithSmallerElements.getReferences()[i];
                
                if (i < nodeWithSmallerElements.getNumberOfElements()) {
                    mergedNode.addVal(i, nodeWithSmallerElements.getValue(i));
                    referencesOfMergedNode[i] = nodeWithSmallerElements.getReferences()[i];
                } else {
                    mergedNode.addVal(i, nodeWithGreaterElements.getValue(i));
                    referencesOfMergedNode[i] = nodeWithGreaterElements.getReferences()[i];
                }
            }
            // last reference of nodeWithGreaterElements
            referencesOfMergedNode[i] = nodeWithGreaterElements.getReferences()[i];
            
            return mergedNode;
        } else {
            return null;
        }
    }

    private boolean isMergeable(BTreeNode node1, BTreeNode node2) {
        if (node1.getNumberOfElements() + node2.getNumberOfElements() <= 2*degree)
            return true;
        else
            return false;
    }

    private Comparable getSmallestFromRightSubtree(BTreeNode subRoot, int indexOfElement) {
        BTreeNode node = subRoot.getReferences()[indexOfElement + 1];
        while (node.hasReferences())
            node = node.getReferences()[0];

        if (node.getNumberOfElements() > degree) {
            Comparable valForReplacement = node.getMin();
            for (int i = 0; i < node.getNumberOfElements(); i++)
                node.getElements()[i] = node.getElements()[i+1];
            return valForReplacement;
        } else {
            return null;
        }
    }

    private Comparable getGreatestFromLeftSubtree(BTreeNode subRoot, int indexOfElement) {
        BTreeNode node = subRoot.getReferences()[indexOfElement];
        while(node.hasReferences())
            node = node.getReferences()[node.getNumberOfElements()];
        
        if (node.getNumberOfElements() > degree)
            return node.getMax();
        else
            return null;
    }

    /**
     * this method return the parent of the node. Parent is the BTree, which contains node within its references
     * @param node
     *             the node of whose parent is looked for
     * @return the parent of node
     */
    private BTreeNode getParentOf(BTreeNode node) {
        if (node == this.root)
            return null;

        Comparable maxValOfNode = node.getMax();
        BTreeNode parent = this.root;
        int i = 0;
        while(parent.hasReferences()) {
            if (parent.getValue(i).compareTo(maxValOfNode) < 0) {
                i++;
            } else {
                if (parent.getReferences()[i] == node) {
                    return parent;
                } else {
                    parent = parent.getReferences()[i];
                    i = 0;
                }
            }

            if (i == parent.getElements().length || parent.getElements()[i] == null) {
                if (parent.getReferences()[i] == node) {
                    return parent;
                } else {
                    parent = parent.getReferences()[i];
                    i = 0;
                }
            }
        }

        return null;
    }

    /**
     * checks, if the node has too much values and has to pop
     * @param node
     *             BTreeNode to be checked
     * @return whether is has to be popped or not
     */
    private boolean checkOverflow(BTreeNode node){
        if(node.getElements()[node.getElements().length-1] != null)
            return true;
        else 
            return false;
    }

    /**
     * finds the the index where val has to be added in node
     * @param node
     * @param val
     *            value to be added
     * @return
     */
    private int findInsertPos(BTreeNode node, Comparable val){
        if (node.getElements()[0] == null)
            return 0;

        int posOfHighestVal = node.getElements().length-2;
        while (node.getElements()[posOfHighestVal] == null)
            posOfHighestVal--;

        for(int i = posOfHighestVal;i >= 0;i--){
            if(node.getValue(i).compareTo(val) < 0){
                return i+1;
            }
        }
        return 0;
    }   


    @Override
    public boolean insert(String filename) {
        boolean allValuesAdded = true;
        if (fileCanBeOpened(filename)) {
            Object file = openInputFile(filename);
            while (!isEndOfInputFile(file)) {
                if (!this.insert(readInt(file)))
                    allValuesAdded = false;
            }
            closeInputFile(file);
        } else {
            return false;
        }

        return allValuesAdded;
    }

    /**
     * this method checks,
     * if the given path is valid (has to end with '.txt'),
     * if the file exists and can be read.
     * @param filePath path of file to be opened
     * @return true, if tests were passed and file can be opened. Otherwise false
     */
    private boolean fileCanBeOpened(String filePath) {

        if (!pathEndsWith(filePath, ".txt")) {
            print("No .txt-file. ");
            return false;
        }

        if (isFilePresent(filePath)) {
            if (isFileReadable(filePath)) {
                return true;
            } else {
                print("File not readable. ");
                return false;
            }
        } else {
            print("File does not exist. ");
            return false;
        }
    }

    /**
     * this method checks, if a path has specified ending
     * @param path path to be checked
     * @param ending the suffix of the path
     * @return true, if 'path' ends with 'ending'. Otherwise false 
     */
    private boolean pathEndsWith(String path, String ending) {

        int numberOfCorrectLetters = 0;
        if (path.length() <= ending.length() || ending.length() < 4)
            return false;

        for (int i = path.length() - ending.length(), j = 0; i < path.length(); i++, j++) {
            if (path.charAt(i) == ending.charAt(j))
                numberOfCorrectLetters++;    
        }

        if (numberOfCorrectLetters == ending.length())
            return true;
        else
            return false;
    }

    @Override
    public boolean contains(Comparable o) {
        if (o == null)
            return false;

        BTreeNode node = this.root;
        int i = 0;

        while (node != null && node.getElements()[i] != null) {
            if (node.getValue(i).compareTo(o) == 0) // found
                return true;
            else if (node.getValue(i).compareTo(o) > 0) { // o is smaller -> left child
                node = node.getReferences()[i];
                i = 0;
            } else {
                i++;

                if (i == node.getElements().length || node.getValue(i) == null) { // o is greater than last entry -> right child
                    node = node.getReferences()[i];
                    i = 0;
                }
            }
        }

        return false;
    }
    @Override
    public int size() {
        return this.size;
    }
    @Override
    public int height() {
        return this.height;
    }
    @Override
    public Comparable getMax() {
        return this.max;
    }
    @Override
    public Comparable getMin() {
        return this.min;
    }
    @Override
    public boolean isEmpty() {
        if (this.root == null)
            return true;
        BTreeNode node = this.root;
        if (node.getElements()[0] == null)
            return true;
        else
            return false;
    }

    @Override
    public void addAll(BTree otherTree) {
        ListNode nodeOfList = otherTree.getLevelorder().get(0);
        
        // iterates otherTree in the LevelorderLinkedList
        while (nodeOfList != null) {
            BTreeNode node = nodeOfList.getElement();
            Comparable[] elements = node.getElements();
            
            // iterate whole node and try to add Comparable elements
            for (int i = 0; i < elements.length; i++) {
                if (!this.contains(elements[i]))
                        this.insert(elements[i]);
            }
            
            nodeOfList = nodeOfList.getNext();
        }
    }

    @Override
    public void printInorder() {
        printInorderSubroutine(this.root);
        println();
    }

    /**
     * this is a sub method for printInorder()
     * @param node
     */
    private void printInorderSubroutine(BTreeNode node) {
        if (node != null) {
            int i = 0;
            while (i < node.getElements().length - 1 && node.getElements()[i] != null) {
                if (node.getReferences()[i] != null) {
                    printInorderSubroutine(node.getReferences()[i]);
                    i++;
                } else {
                    print(node.getValue(i) + ", ");
                    i++;
                }
            }
            printInorderSubroutine(node.getReferences()[i]);
            print("; ");
        }
    }

    @Override
    public void printPostorder() {
        printPostorder(this.root);
        println();
    }

    /**
     * this is a sub method for printPostorder()
     * @param node
     */
    private void printPostorder(BTreeNode node) {
        if(node != null){
            for( int i=0; i < node.getReferences().length; i++){
                if(node.getReferences()[i] != null){
                    printPostorder(node.getReferences()[i]);
                }
            }
            for( int i = 0; i < node.getElements().length; i++){
                if(node.getElements()[i] != null){
                    print(node.getElements()[i] + " ");
                }
            }
        }
    }

    @Override
    public void printPreorder() {
        printPreorder(this.root);
        println();
    }

    /**
     * this is a sub method for printPreorder
     * @param n
     */
    private void printPreorder(BTreeNode n){
        if(n!=null){
            for( int i = 0; i < n.getElements().length; i++){
                if(n.getElements()[i] != null){
                    print(n.getElements()[i] + " ");
                }
            }
            for( int i = 0; i < n.getReferences().length; i++){
                if(n.getReferences()[i] != null){
                    printPreorder(n.getReferences()[i]);
                }
            }
        }
    }

    @Override
    public void printLevelorder() {
        MyBTreeLinkedList nodes = getLevelorder();

        int i = 0;
        while (i  < nodes.size()) {
            BTreeNode node = nodes.get(i).getElement();
            int j = 0;
            while (j < node.getElements().length-2) {
                if (node.getElements()[j] == null)
                    print("null, ");
                else
                    print(node.getElements()[j] + ", ");

                j++;
            }

            if (node.getElements()[j] != null)
                print(node.getElements()[j] + "; ");
            else
                print("null; ");

            i++;
        }

        println();
    }

    /**
     * this method puts all BTreeNodes of this BTree in a list starting with the nodes from the lowest to the highest level
     * @return list with BTreeNodes
     */
    private MyBTreeLinkedList getLevelorder() {
        int i = 0;
        MyBTreeLinkedList nodesList = new MyBTreeLinkedList(new ListNode(this.root));

        while (nodesList.get(i) != null) {
            for (int j = 0; j < nodesList.get(i).getElement().getReferences().length - 1; j++) {
                if (nodesList.get(i).getElement().getReferences()[j] != null)
                    nodesList.addLast(new ListNode(nodesList.get(i).getElement().getReferences()[j]));
            }
            i++;
        }

        return nodesList;
    }

    @Override
    public BTree cloneDeep() {
        BTree clone = new BTree(this.root.cloneDeep());
        MyBTreeLinkedList nodesList = getLevelorder();

        int i = 0;
        while (i < nodesList.size()) {
            BTreeNode node = nodesList.get(i).getElement();
            BTreeNode clonedNode = clone.getLevelorder().get(i).getElement();
            BTreeNode[] references = new BTreeNode[2*this.degree+2];
            for (int j = i + 1, l = 0; j < nodesList.size(); j++) {
                if (getParentOf(nodesList.get(j).getElement()) == node) {
                    references[l] = nodesList.get(j).getElement().cloneDeep();
                    l++;
                }
            }
            clonedNode.setReferences(references);
            i++;
        }

        clone.className = this.root.getClass().getSimpleName();
        clone.height = this.height();
        clone.degree = this.degree;
        clone.max = this.getMax();
        clone.min = this.getMin();
        return clone;
    }
}
