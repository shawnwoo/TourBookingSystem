package tour;

public class LATourBuilder extends TourBuilder {
	
	private Tour tour;

	@Override
	public void buildANewTour() {
		tour=new Tour("LA - 1/8~14/8");
		tour.setCap(5);
		tour.setTemp(80);

	}

	@Override
	public void buildAirline() {
		// TODO Auto-generated method stub
		tour.setAirline(new Airline("UA555",200.00 ));
	}

	@Override
	public void buildHotel() {
		tour.setHotel(new Hotel("Hilton",400.00));

	}

	@Override
	public void buildTrans() {
		tour.setTrans(new LocalTransport("BUS",100.00));
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
