package tour;

import java.util.ArrayList;

public class TourPackage {
	
	private ArrayList<Tour> tourList=new ArrayList<Tour>();
	
	public void addTour(Tour tour){
		tourList.add(tour);
	}
	
	public String[] getNameList(){
		String[] nameList=new String[tourList.size()];
		
		for(int i=0;i<tourList.size();++i){
			nameList[i]=tourList.get(i).getName();
			System.out.println(nameList[i]);
			//System.out.println(tourList.get(i).getName());
		};
//		
//		return nameList;
		
//		Tour[] tour=(Tour[]) tourList.toArray();
//		String[] nameList=new String[tour.length];
//		for(int i=0;i<tour.length;i++){
//			nameList[i]=tour[i].getName();
//		};
//	
//		System.out.println(tourList.get(0).getName());
//		System.out.println(nameList.length);
		
		
		return nameList;
		
		
	}
	
	

}
