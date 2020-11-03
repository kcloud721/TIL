package gene;

import java.util.ArrayList;

public class Factory<P> {
	ArrayList<P> list;
	public Factory() {
		list = new ArrayList<>();
	}
	public void addItem(P p) {
		list.add(p);
	}
	public ArrayList<P> getList(){
		return list;
	}
	
}
