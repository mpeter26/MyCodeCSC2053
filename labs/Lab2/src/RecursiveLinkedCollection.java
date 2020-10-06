//			Lab 2			Recursive Linked Collection
// 			@author :  Michael Peters

public class RecursiveLinkedCollection<T> implements CollectionInterface<T> {

	LLNode<T> front;
	int size;
	
	RecursiveLinkedCollection() {
		front = null;
		size = 0;
	}
	
	private LLNode<T> recAdd(LLNode<T> node, T target) {
		if (node != null)
			node.setLink(recAdd(node.getLink(), target));
		else
			node = new LLNode<T>(target);
			return node;
	}
	
	public boolean add(T element) {
		front = recAdd(front, element);
		return true;
	}
	
	

	private T recGet(LLNode<T> node, T target) {
		if(node == null) {
			return null;
		}
		if(node.getInfo().equals(target)) {
			return node.getInfo();
		}
		else {
			return recGet(node.getLink(), target);
		}
	}
	
	public T get(T target) {
		return recGet(front, target);
	}
	
	
	
	private LLNode<T> recRemove(LLNode<T> node, T target) {
		if (node == null) {
			return node;
		}
		LLNode<T> temp = node.getLink();
		if (temp.getInfo().equals(target)) {
			node.setLink(temp.getLink());
			return node;
		}
		else {
			return recRemove(node.getLink(), target);
		}
		
	}
	
	public boolean remove(T element) {
		recRemove(front, element);
		return true;
	}
	
	
	
	private boolean recContains(LLNode<T> node, T target) {
		if(node == null) {
			return false;
		}
		if(node.getInfo().equals(target)) {
			return true;
		}
		else {
			return recContains(node.getLink(), target);
		}
	}
	
	public boolean contains(T target) {
		return recContains(front, target);
	}
	
	
	public boolean isFull() {
		return false; /* Linked List is never full. 
		Nodes can always be added when memory is available. */
	}
	
	public boolean isEmpty() {
		if (front == null) // Could also use "if (size() == 0)" depending on preference.
			return true;
		else 
			return false;
	}
	
	
	private int recSize(LLNode<T> node) {
		if(node == null) {
			return 0;
		}
		return 1 + recSize(node.getLink());
	}
	
	public int size() {
		return recSize(front);
	}
	
	
	public String toString() {
		if(front == null) {
			return "";
		}
		String ret = front.getInfo().toString();
		LLNode<T> temp = front.getLink();
		while (temp != null) {
			ret += "," + temp.getInfo().toString();
			temp = temp.getLink();
		}
		return ret;
	}

}