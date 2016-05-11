package de.hs_mannheim.ss16.ib.tpe.g1_1.uebung1;

/**
 * models a LinkedList which contains ListNodes containing BTreeNodes
 */
public class MyBTreeLinkedList {

	private ListNode head;

	public MyBTreeLinkedList(ListNode head) {
        this.head = head;
	}

	/**
	 * adds element at the end of the list
	 * @param element
	 */
	public void addLast(ListNode element) {
        ListNode n = this.head;
        while (n.getNext() != null) 
            n = n.getNext();
        n.setNext(element);
	}

	/**
	 * 
	 * @param i
	 * @return ListNode at specified position i. null for invalid i.
	 */
	public ListNode get(int i) {
	    if (i < 0 || i >= this.size()) {
	        return null;
	    } else {
	        ListNode node = head;
	        int index = 0;
	        while (index < i) {
	            node = node.getNext();
	            index++;
	        }
	        return node;
	    }
	}
	
	/**
	 * 
	 * @return number of ListNodes in the list
	 */
	public int size() {
	    int size = 1;
	    ListNode node = head;
	    while (node.getNext() != null) {
	        node = node.getNext();
	        size++;
	    }
	    return size;
	}
}
