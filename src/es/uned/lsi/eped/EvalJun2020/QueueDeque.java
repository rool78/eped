package es.uned.lsi.eped.EvalJun2020;

import es.uned.lsi.eped.DataStructures.IteratorIF;
import es.uned.lsi.eped.DataStructures.QueueIF;

public class QueueDeque<E> implements QueueIF<E> {
	
	private DequeIF<E> deque;
	
	public QueueDeque() {
		this.deque = new Deque<>();
	}

	@Override
	public IteratorIF<E> iterator() {
		return deque.iterator();
	}

	@Override
	public int size() {
		return deque.size();
	}

	@Override
	public boolean isEmpty() {
		return deque.isEmpty();
	}

	@Override
	public boolean contains(E e) {
		return deque.contains(e);
	}

	@Override
	public void clear() {
		deque.clear();
	}

	@Override
	public E getFirst() {
		return deque.getFront();
	}

	@Override
	public void enqueue(E elem) {
		deque.insertBack(elem);
	}

	@Override
	public void dequeue() {
		deque.removeFront();
	}

}
