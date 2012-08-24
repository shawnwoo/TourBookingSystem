package globeTrotters;

import tour.*;

public class ConstructTourPackageA {

	TourDirector director = new TourDirector();
	TourBuilder LABuilder = new LATourBuilder();
	TourBuilder SFBuilder = new SFTourBuilder();
	TourBuilder VegasBuilder = new VegasTourBuilder();
	TourPackage tourPackageA=new TourPackage();

	public  void construct() {
		director.setBuilder(LABuilder);
		director.construct();
		tourPackageA.addTour(director.getTour());
		
		director.setBuilder(SFBuilder);
		director.construct();
		tourPackageA.addTour(director.getTour());
		
		director.setBuilder(VegasBuilder);
		director.construct();
		tourPackageA.addTour(director.getTour());
		

	};
	
	public TourPackage getA(){
		return tourPackageA;
	}
	
	

}
