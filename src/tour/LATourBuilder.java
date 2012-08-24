package tour;

public class LATourBuilder extends TourBuilder {
	
	private Tour tour;

	@Override
	public void buildANewTour() {
		tour=new Tour("LA - 3 Days 2 Nights");

	}

	@Override
	public void buildAirline() {
		// TODO Auto-generated method stub

	}

	@Override
	public void buildHotel() {
		// TODO Auto-generated method stub

	}

	@Override
	public void buildTrans() {
		// TODO Auto-generated method stub

	}

	@Override
	public Tour retrieveResult() {
		// TODO Auto-generated method stub
		return tour;
	}
	
//	public static void main(String[] args){
//		LATourBuilder la=new LATourBuilder();
//		la.buildANewTour();
//		Tour tour=la.retrieveResult();
//		System.out.println(tour.getName());
//	}

}
