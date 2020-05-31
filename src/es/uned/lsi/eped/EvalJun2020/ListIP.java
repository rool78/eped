package es.uned.lsi.eped.EvalJun2020;

public class ListIP<E> extends SequenceDL<E> implements ListIPIF<E> {

	private NodeSequence nodeInPointer;
	private int pointer;

	public ListIP() {
		super();
		pointer = 1;
	}

	@Override
	public int getPointer() {
		return pointer;
	}

	@Override
	public void moveNext() {
		if (getPointer() <= this.size) {
			pointer++;
			if (nodeInPointer.getNext() != null) {
				nodeInPointer = nodeInPointer.getNext();
			}
		}
	}

	@Override
	public void movePrev() {
		if (getPointer() > 1) {
			if (nodeInPointer.getPrevious() != null && getPointer() <= this.size) {
				nodeInPointer = nodeInPointer.getPrevious();
			}
			pointer--;
		}
	}

	@Override
	public void moveTo(int pos) {
		pointer = pos;
		if (pos > this.size) {
			nodeInPointer = getNode(pos - 1);
		} else {
			nodeInPointer = getNode(pos);
		}
	}

	@Override
	public void insert(E elem) {
		NodeSequence newNode = new NodeSequence(elem);
		if (getPointer() == 1) {
			if (this.firstNode == null) {
				this.firstNode = newNode;
				nodeInPointer = this.firstNode;
			} else {
				newNode.setNext(this.firstNode);
				this.firstNode.setPrevious(newNode);
				this.firstNode = newNode;
				nodeInPointer = this.firstNode;
			}
		} else {
			if (nodeInPointer.getNext() == null && getPointer() > this.size) {
				newNode.setPrevious(nodeInPointer);
				nodeInPointer.setNext(newNode);
				nodeInPointer = newNode;
			} else {
				newNode.setNext(nodeInPointer);
				newNode.setPrevious(nodeInPointer.getPrevious());

				if (nodeInPointer.getPrevious() != null) {
					nodeInPointer.getPrevious().setNext(newNode);
					nodeInPointer.setPrevious(newNode);
				}
				nodeInPointer = newNode;
			}
		}
		this.size++;
	}

	@Override
	public void remove() {
		if (pointer == 1) {
			if (this.firstNode != null) {
				if (this.firstNode.getNext() != null) {
					this.firstNode = this.firstNode.getNext();
				}
				if (this.size == 1) {
					this.firstNode = null;
					nodeInPointer = null;
					this.size--;
					return;
				} else {
					this.firstNode.setPrevious(null);
					nodeInPointer = this.firstNode;
					this.size--;
				}
			}
		} else {
			if (nodeInPointer.getNext() != null) {
				nodeInPointer.getPrevious().setNext(nodeInPointer.getNext());
				nodeInPointer.getNext().setPrevious(nodeInPointer.getPrevious());
				if (nodeInPointer.getNext() != null) {
					nodeInPointer = nodeInPointer.getNext();
					this.size--;
					return;
				}
				if (nodeInPointer.getPrevious() != null) {
					nodeInPointer = nodeInPointer.getPrevious();
				}
			} else {
				nodeInPointer.getPrevious().setNext(null);
			}
			this.size--;
		}
	}

	@Override
	public E getElem() {
		return nodeInPointer.getValue();
	}

	@Override
	public void setElem(E elem) {
		nodeInPointer.setValue(elem);
	}

}
