package es.uned.lsi.eped.EvalJun2020;

public class Comp implements Comparable<Comp>{
	
	Integer i;
	
	public Comp(Integer i) {
		this.i = i;
	}

	@Override
	public int compareTo(Comp arg0) {
		if(this.i < arg0.i) {
			return -1;
		}
		if(this.i > arg0.i) {
			return 1;
		}
		return 0;
	}

}
