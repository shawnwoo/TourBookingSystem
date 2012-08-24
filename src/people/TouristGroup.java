package people;

import java.util.Enumeration;
import java.util.Vector;

public class TouristGroup implements People {
	private Vector tourGroup= new java.util.Vector();
	private double totalPrice=0;
	

	@Override
	public double calculateTotalPrice() {
		
		Enumeration enu=people();
		while(enu.hasMoreElements()){
			totalPrice+=((People)enu.nextElement()).calculateTotalPrice();
		}
		
		
		return totalPrice;
	}
	
	public Enumeration people(){
		return tourGroup.elements();
	}
	
	public void add(People node){
		tourGroup.addElement(node);
	}
	
	public void remove(People node){
		tourGroup.removeElement(node);
	}
}
