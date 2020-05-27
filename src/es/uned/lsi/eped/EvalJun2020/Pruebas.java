package es.uned.lsi.eped.EvalJun2020;

import es.uned.lsi.eped.DataStructures.List;

public class Pruebas {

	public static void main(String[] args) {

		List<Integer> l = new List<>();
		
		l.insert(1, 1);
		l.insert(2, 2);
		l.insert(3, 3);
		l.insert(2, 78);
		
		int i = 1;
		while(i <= l.size()) {
			System.out.println(l.get(i));
			i++;
		}
	}

}
