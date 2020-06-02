package es.uned.lsi.eped.EvalJun2020;

public class Deque<E> extends SequenceDL<E> implements DequeIF<E> {

	private NodeSequenceDL lastNode;

	@Override
	public E getFront() {
		return this.firstNode.getValue();
	}

	@Override
	public E getBack() {
		return lastNode.getValue();
	}

	@Override
	public void insertFront(E e) {
		NodeSequenceDL newNode = new NodeSequenceDL(e);
		if (isEmpty()) {
			this.firstNode = newNode;
			this.lastNode = newNode;
		} else {
			newNode.setNext(this.firstNode);
			this.firstNode.setPrevious(newNode);
			this.firstNode = newNode;
		}
		this.size++;
	}

	@Override
	public void insertBack(E e) {
		NodeSequenceDL newNode = new NodeSequenceDL(e);
		if (isEmpty()) {
			this.firstNode = newNode;
			this.lastNode = newNode;
		} else {
			newNode.setPrevious(lastNode);
			this.lastNode.setNext(newNode);
		}
		this.lastNode = newNode;
		this.size++;
	}

	@Override
	public void removeFront() {
		if (this.size == 1) {
			this.firstNode = null;
			lastNode = null;
		} else {
			if (this.firstNode.getNext() != null) {
				this.firstNode = this.firstNode.getNext();
				this.firstNode.setPrevious(null);
			}
		}
		this.size--;
	}

	@Override
	public void removeBack() {
		if (this.size == 1) {
			this.firstNode = null;
			lastNode = null;
		} else {
			if (lastNode.getPrevious() != null) {
				lastNode = lastNode.getPrevious();
				lastNode.setNext(null);
			}
		}
		this.size--;
	}
	
}
