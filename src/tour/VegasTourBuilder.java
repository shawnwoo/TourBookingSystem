package tour;



public class VegasTourBuilder extends TourBuilder {
	
	private Tour tour;

	public void buildAirline() {
		tour.setAirline(new Airline("UA777", 200.00));
	}

	@Override
	public void buildHotel() {
		tour.setHotel(new Hotel("Strosphere", 400.00));

	}

	@Override
	public void buildTrans() {
		tour.setTrans(new LocalTransport("LIMO", 200.00));
	}

	@Override
	public Tour retrieveResult() {
		// TODO Auto-generated method stub
		return tour;
	}

	

	@Override
	public void buildANewTour() {
		tour=new Tour("Las Vegas - 1/8~14/8");
		tour.setCap(10);
		tour.setTemp(100);
	}

	

}
