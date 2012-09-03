package tour;

import java.io.Serializable;
import java.util.ArrayList;

public class TourPackage  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7365844411888132580L;
	private ArrayList<Tour> tourList = new ArrayList<Tour>();
	private String name;
	
	public TourPackage(String name){
		this.name=name;
	}

	public void addTour(Tour tour) {
		tourList.add(tour);
	}

	public String[] getNameList() {
		String[] nameList = new String[tourList.size()];

		for (int i = 0; i < tourList.size(); ++i) {
			nameList[i] = tourList.get(i).getName();
			System.out.println(nameList[i]);

		}
		;

		return nameList;

	}
	
	public Tour getTour(int index){
		return tourList.get(index);
		
	}
	
	public double getPrice(){
	 double totalPrice=0;
	 for(int i=0;i<tourList.size();++i){
		 totalPrice+=tourList.get(i).getPrice();
	 }
	 
	 return totalPrice;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
