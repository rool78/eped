package es.uned.lsi.eped.EvalJun2020;

import es.uned.lsi.eped.DataStructures.IteratorIF;
import es.uned.lsi.eped.DataStructures.List;

public class Pruebas {

	public static void main(String[] args) {
		Deque<Integer> q = new Deque<Integer>();
		q.insertBack(5);
		q.insertBack(6);
		q.insertBack(7);
		q.insertBack(8);
		q.insertFront(1);
		
		
		printStatus(q);
		
		System.out.println(q.getFront());
		System.out.println(q.getBack());
			
		
	}
	
	public static void printStatus(DequeIF<Integer> param) {
		System.out.print("Tamaño: ");
		System.out.println(param.size());
		if(!param.isEmpty()){
			System.out.print("Primer elemento: ");
			System.out.println(param.getFront());
			System.out.print("Último elemento: ");
			System.out.println(param.getBack());
		}
		System.out.print("Iterador: ");
		IteratorIF<Integer> it = param.iterator();
		while (it.hasNext()) {
			System.out.print(it.getNext());
			if (it.hasNext()) { System.out.print(","); }
		}
		System.out.println();
		System.out.println("--------------------------");
	}

}
