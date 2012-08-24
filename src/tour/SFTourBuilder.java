package tour;

public class SFTourBuilder extends TourBuilder {
	
	private Tour tour;

	@Override
	public void buildANewTour() {
		tour=new Tour("San Francisco - 2 Days 1 Night");
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

}
