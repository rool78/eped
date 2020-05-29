package es.uned.lsi.eped.EvalJun2020;

public class ListIP<E> extends SequenceDL<E> implements ListIPIF<E> {

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
		}
	}

	@Override
	public void movePrev() {
		if (getPointer() > 1) {
			pointer--;
		}
	}

	@Override
	public void moveTo(int pos) {
		pointer = pos;
	}

	@Override
	public void insert(E elem) {
		NodeSequence newNode = new NodeSequence(elem);
		if (pointer == 1) {
			if (this.firstNode != null) {
				this.firstNode.setPrevious(newNode);
			}
			newNode.setNext(this.firstNode);
			this.firstNode = newNode;
		} else {
			NodeSequence nodeInPointer = getNode(pointer);

			newNode.setNext(nodeInPointer);
			if (nodeInPointer != null) {
				nodeInPointer.getPrevious().setNext(newNode);
				newNode.setPrevious(nodeInPointer.getPrevious());
				nodeInPointer.setPrevious(newNode);
			} else {
				getNode(pointer - 1).setNext(newNode);
				newNode.setPrevious(getNode(pointer - 1));
			}
		}

		this.size++;
	}

	@Override
	public void remove() {
		if (pointer == 1) {
			this.firstNode = this.firstNode.getNext();
			if (this.firstNode != null) {
				this.firstNode.setPrevious(null);
			}
		} else {
			NodeSequence nodeToRemove = getNode(pointer);
			if (nodeToRemove != null) {
				nodeToRemove.getPrevious().setNext(nodeToRemove.getNext());
				nodeToRemove.getNext().setPrevious(nodeToRemove.getPrevious());
			}
		}
		this.size--;
	}

	@Override
	public E getElem() {
		NodeSequence node = getNode(pointer);
		return node.getValue();
	}

	@Override
	public void setElem(E elem) {
		NodeSequence node = getNode(pointer);
		node.setValue(elem);
	}

}
