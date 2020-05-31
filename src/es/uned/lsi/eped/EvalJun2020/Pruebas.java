package es.uned.lsi.eped.EvalJun2020;

import es.uned.lsi.eped.DataStructures.IteratorIF;
import es.uned.lsi.eped.DataStructures.Stack;
import es.uned.lsi.eped.DataStructures.StackIF;

public class Pruebas {

	public static Integer myE;

	public static void main(String args[]) {
		DequeIF<Comp> deq = new Deque<>();

		deq.insertFront(new Comp(4));
		deq.insertFront(new Comp(3));
		deq.insertFront(new Comp(5));

		// printStatus(deq);
		// H(deq);
		// printStatus(deq);

		StackIF<Integer> s = new Stack<>();

		s.push(1);
		s.push(2);
		s.push(3);

		pushBottom(s, 69);
		popBottom(s);
		popBottom(s);


		IteratorIF<Integer> it = s.iterator();

		while (it.hasNext()) {
			System.out.println(it.getNext());
		}

		System.out.println(s.getTop());

	}

	public static void pushBottom(StackIF<Integer> stack, Integer elem) {
		if (stack.size() == 0) {
			stack.push(elem);
			return;
		}
		Integer e = stack.getTop();
		stack.pop();
		pushBottom(stack, elem);
		stack.push(e);
	}

	public static void popBottom(StackIF<Integer> stack) {
		if (stack.size() >= 1) {
			if (stack.size() == 1) {
				stack.pop();
				return;
			}
			Integer e = stack.getTop();
			stack.pop();
			popBottom(stack);
			stack.push(e);
		}
	}

	public static <E extends Comparable<E>> DequeIF<E> H(DequeIF<E> d) {
		int s = d.size();
		if (s <= 1) {
			return d;
		}
		int m = s / 2;
		IteratorIF<E> it = d.iterator();
		int cont = 1;
		Deque<E> daux1 = new Deque<E>();
		Deque<E> daux2 = new Deque<E>();
		while (cont <= m) {
			daux1.insertBack(it.getNext());
			cont++;
		}
		while (cont <= s) {
			daux2.insertBack(it.getNext());
			cont++;
		}
		daux1 = (Deque<E>) H(daux1);
		daux2 = (Deque<E>) H(daux2);
		if (daux1.getBack().compareTo(daux2.getFront()) <= 0) {
			IteratorIF<E> itAux = daux2.iterator();
			while (itAux.hasNext()) {
				daux1.insertBack(itAux.getNext());
			}
			return daux1;
		}
		DequeIF<E> R = Haux(daux1, daux2);
		return R;
	}

	public static <E extends Comparable<E>> DequeIF<E> Haux(DequeIF<E> d1, DequeIF<E> d2) {
		DequeIF<E> R = new Deque<E>();
		while (d1.size() > 0 && d2.size() > 0) {
			if (d1.getFront().compareTo(d2.getFront()) <= 0) {
				R.insertBack(d1.getFront());
				d1.removeFront();
			} else {
				R.insertBack(d2.getFront());
				d2.removeFront();
			}
		}
		if (d1.size() > 0) {
			IteratorIF<E> itAux = d1.iterator();
			while (itAux.hasNext()) {
				R.insertBack(itAux.getNext());
			}
		}
		if (d2.size() > 0) {
			IteratorIF<E> itAux = d2.iterator();
			while (itAux.hasNext()) {
				R.insertBack(itAux.getNext());
			}
		}
		return R;
	}

	public static <E extends Comparable<E>> boolean F(DequeIF<E> d) {
		if (d.size() > 1) {
			if (d.getFront().compareTo(d.getBack()) != 0) {
				return false;
			}
			d.removeFront();
			d.removeBack();
			return F(d);
		}
		return true;
	}

	public static <E> void G(DequeIF<E> d) {
		Gaux(d, d.size());
	}

	public static <E> void Gaux(DequeIF<E> d, int s) {
		if (s > 1) {
			E e = d.getFront();
			d.removeFront();
			Gaux(d, s - 1);
			d.insertBack(e);
		}
	}

	public static void printStatus(DequeIF<Comp> param) {
		System.out.print("Tamaño: ");
		System.out.println(param.size());
		if (!param.isEmpty()) {
			System.out.print("Primer elemento: ");
			System.out.println(param.getFront());
			System.out.print("Último elemento: ");
			System.out.println(param.getBack());
		}
		System.out.print("Iterador: ");
		IteratorIF<Comp> it = param.iterator();
		while (it.hasNext()) {
			System.out.print(it.getNext().i);
			if (it.hasNext()) {
				System.out.print(",");
			}
		}
		System.out.println();
		System.out.println("--------------------------");
	}

}
