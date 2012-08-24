package tour;


public abstract class TourBuilder {
	
	public abstract void buildANewTour();
	
	public abstract void buildAirline();

	public abstract void buildHotel();

	public abstract void buildTrans();

	public abstract Tour retrieveResult();

}
