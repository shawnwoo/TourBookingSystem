package globeTrotters;

public class TourDirector {
	
	private TourBuilder builder;
	
	public void construct(){
		builder = new ConcreteTourBuilder();
		builder.buildAirline();
		builder.buildHotel();
		builder.buildTrans();
		builder.retrieveResult();
	}
	

}
