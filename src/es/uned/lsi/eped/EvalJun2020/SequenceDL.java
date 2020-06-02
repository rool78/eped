package es.uned.lsi.eped.EvalJun2020;

import es.uned.lsi.eped.DataStructures.Collection;
import es.uned.lsi.eped.DataStructures.IteratorIF;

public abstract class SequenceDL<E> extends Collection<E> implements SequenceDLIF<E> {
	
	/* Clase privada que implementa la estructura de nodos de la secuencia */
	protected class NodeSequenceDL {

		private E value;
		private NodeSequenceDL next;
		private NodeSequenceDL previous;
		
		NodeSequenceDL(){
			this.value = null;
			this.next = null;
			this.previous = null;
			
		}
		
		NodeSequenceDL(E e){
			this.value = e;
			this.next = null;
			this.previous = null;
		}
				
		public E getValue(){
			return this.value;
		}
		
		public void setValue(E e){
			this.value = e;
		}
		
		public NodeSequenceDL getNext(){
			return this.next;
		}
		
		public void setNext(NodeSequenceDL n){
			this.next = n;
		}

		public NodeSequenceDL getPrevious() {
			return previous;
		}

		public void setPrevious(NodeSequenceDL previous) {
			this.previous = previous;
		}
		
	}

	/* Clase privada que implementa un iterador para la secuencia */
	private class SequenceIterator implements IteratorIF<E> {
		
		private NodeSequenceDL currentNode;
		
		SequenceIterator(){
			this.currentNode = firstNode;
		}
		
		public E getNext() {
			E elem = this.currentNode.getValue(); 
			this.currentNode = this.currentNode.getNext();
			return elem;
		}
	    
		public boolean hasNext() {
			return this.currentNode != null;
		}

		public void reset() {
			this.currentNode = firstNode;
		}

	}
	
	protected NodeSequenceDL firstNode;
	
	/* Devuelve el primer nodo de la secuencia */
	private NodeSequenceDL getFirstNode() {
		return this.firstNode;
	}

	/* Constructor de una secuencia vacía */
	public SequenceDL () {
		super();               /* Creamos una colección */         
		this.firstNode = null; /* La secuencia es vacía */
	}
	
	/* Constructor por copia */
	public SequenceDL (SequenceDL<E> s) {
		this();
		if ( ! s.isEmpty() ) {
			this.size = s.size();
			NodeSequenceDL nodeS = s.getFirstNode();
			NodeSequenceDL pNode = new NodeSequenceDL(nodeS.getValue());
			this.firstNode = pNode;
			while ( nodeS.getNext() != null ) {
				nodeS = nodeS.getNext();
				NodeSequenceDL newNode = new NodeSequenceDL(nodeS.getValue());
				pNode.setNext(newNode);
				pNode = newNode;
			}
		}
	}

	/* Reimplementación/Especialización de algunos métodos de Collection */

	/* Elimina todos los elementos de la secuencia */
	public void clear () {
		super.clear();    /* Vaciamos la colección */
		this.firstNode = null; /* La secuencia es vacía */
	}

	/* Métodos heredados de CollectionIF */

	/* Comprueba si la secuencia contiene el elemento */
	public boolean contains(E e) {
		NodeSequenceDL node = this.firstNode;
		while(node!=null){
			E next = node.getValue();
			if(next.equals(e)){
				return true;
			}
			node = node.getNext();
		}
		return false;
	}

	/* Devuelve un iterador para la secuencia */
    public IteratorIF<E> iterator() {
    	return new SequenceIterator();
    }
    
	/* Devuelve el nodo i-ésimo de la secuencia        *
	 * @Pre: 1 <= i <= size()                          */
	protected NodeSequenceDL getNode(int i){
		NodeSequenceDL node = this.firstNode;
		for ( int aux = 1 ; aux < i ; aux++ ) {
			node = node.getNext();
		}
		return node;
	}
}
