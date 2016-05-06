package de.hs_mannheim.ss16.ib.tpe.g1_1.uebung2.teil2.aufgabe1;

/**
 * The class ListNode is a helper class for MyBTreeLinkedList
 */
public class ListNode {

	private BTreeNode element;
	private ListNode next;

	public ListNode(BTreeNode element0) {
	    this.element = element0;
	}
	
	/**
	 * @return the value of the current node
	 */
	public BTreeNode getElement() {
		return element;
	}

	/**
	 * @param value
	 *             the new value of the current node
	 */
	public void setElement(BTreeNode value) {
		this.element = value;
	}

	/**
	 * @return the next element
	 */
	public ListNode getNext() {
		return next;
	}

	/**
	 * 
	 * @param next
	 *            the new next element
	 */
	public void setNext(ListNode next) {
		this.next = next;
	}
}

