package tour;

public class SFTourBuilder extends TourBuilder {

	private Tour tour;

	@Override
	public void buildANewTour() {
		tour = new Tour("San Francisco - 1/8~14/8");
		tour.setCap(10);
		tour.setTemp(74);
	}

	public void buildAirline() {
		// TODO Auto-generated method stub
		tour.setAirline(new Airline("UA666", 300.00));
	}

	@Override
	public void buildHotel() {
		tour.setHotel(new Hotel("Golden Gate", 400.00));

	}

	@Override
	public void buildTrans() {
		tour.setTrans(new LocalTransport("BUS", 100.00));
	}

	@Override
	public Tour retrieveResult() {
		// TODO Auto-generated method stub
		return tour;
	}

}
