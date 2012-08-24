package tour;



public class VegasTourBuilder extends TourBuilder {
	
	private Tour tour;

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

	

	@Override
	public void buildANewTour() {
		tour=new Tour("Las Vegas - 5 Days 4 Nights");
		
	}

	

}
