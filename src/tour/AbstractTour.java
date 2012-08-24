package tour;


import java.util.ArrayList;
import java.util.Date;

import people.People;

public abstract class  AbstractTour {
	
	private Date startDate;
	private Date endDate;
	private Airlne airline;
	private Hotel hotel;
	private LocalTransport trans;
	private String name;
	private int cap;
	private ArrayList<People> waitingList;
	
	public AbstractTour(String name){
		this.name=name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public double getPrice(){
		return 0;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the airline
	 */
	public Airlne getAirline() {
		return airline;
	}

	/**
	 * @param airline the airline to set
	 */
	public void setAirline(Airlne airline) {
		this.airline = airline;
	}

	/**
	 * @return the hotel
	 */
	public Hotel getHotel() {
		return hotel;
	}

	/**
	 * @param hotel the hotel to set
	 */
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	/**
	 * @return the trans
	 */
	public LocalTransport getTrans() {
		return trans;
	}

	/**
	 * @param trans the trans to set
	 */
	public void setTrans(LocalTransport trans) {
		this.trans = trans;
	}
	
	public void setCap(int cap){
		this.cap=cap;
	}
	
	public int getCap(){
		return this.cap; 
	}

}
