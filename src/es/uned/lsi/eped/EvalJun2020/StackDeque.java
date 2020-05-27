package es.uned.lsi.eped.EvalJun2020;

import es.uned.lsi.eped.DataStructures.IteratorIF;
import es.uned.lsi.eped.DataStructures.StackIF;

public class StackDeque<E> implements StackIF<E> {

	private DequeIF<E> deque;

	public StackDeque() {
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
	public E getTop() {
		return deque.getBack();
	}

	@Override
	public void push(E elem) {
		deque.insertBack(elem);
	}

	@Override
	public void pop() {
		deque.removeBack();
	}

}
