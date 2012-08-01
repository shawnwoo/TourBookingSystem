package globeTrotters;

import java.util.Date;

public abstract class  Tour {
	
	private Date startDate;
	private Date endDate;
	private Airlne airline;
	private Hotel hotel;
	private LocalTransport trans;
	private String name;
	
	public void setName(String name){
		this.name=name;
	}
	
	

}
