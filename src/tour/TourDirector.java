package tour;


public class TourDirector {
	
	private TourBuilder builder;
	
	public void setBuilder(TourBuilder builder){
		this.builder=builder;
		
	}
	
	public Tour getTour(){
		return builder.retrieveResult();
	}
	
	public void construct(){
		builder.buildANewTour();
		builder.buildAirline();
		builder.buildHotel();
		builder.buildTrans();
		builder.retrieveResult();
	}
	

}
