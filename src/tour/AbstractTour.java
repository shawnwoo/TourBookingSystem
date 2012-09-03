package tour;

import java.util.ArrayList;
import java.util.Date;

import people.People;
import people.Tourist;

public abstract class AbstractTour {

	private Date startDate;
	private Date endDate;
	private Airline airline;
	private Hotel hotel;
	private LocalTransport trans;
	private String name;
	private int cap;

	private Temperature temperature = new Temperature(100);
	private double discountedPrice;
	private final int discountPercentage = 10;

	private ArrayList<Tourist> touristList = new ArrayList<Tourist>();
	private ArrayList<Tourist> waitingList = new ArrayList<Tourist>();
	private int vacancy;

	public AbstractTour(String name) {
		this.name = name;
	}

	public AbstractTour() {

	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return airline.getPrice() + hotel.getPrice() + trans.getPrice();
	}

	public double getDiscountedPrice() {
		return this.getPrice() * (100 - discountPercentage) / 100;
	}

	public String getDiscountNumber() {
		return "With group discount " + discountPercentage + "%";
	}

	// public void setDiscountedPrice(double price){
	// this.discountedPrice=price;
	// }

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate
	 *            the startDate to set
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
	 * @param endDate
	 *            the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the airline
	 */
	public Airline getAirline() {
		return airline;
	}

	/**
	 * @param airline
	 *            the airline to set
	 */
	public void setAirline(Airline airline) {
		this.airline = airline;
	}

	/**
	 * @return the hotel
	 */
	public Hotel getHotel() {
		return hotel;
	}

	/**
	 * @param hotel
	 *            the hotel to set
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
	 * @param trans
	 *            the trans to set
	 */
	public void setTrans(LocalTransport trans) {
		this.trans = trans;
	}

	public void setCap(int cap) {
		this.cap = cap;
		this.vacancy = cap;
	}

	public int getCap() {
		return this.cap;
	}

	public void setTemp(double tempF) {
		temperature.setTempF(tempF);
	}

	public String getTempF() {
		return temperature.getTempF();
	}

	public String getTempC() {
		return temperature.getTempC();
	}

	public void addTourist(Tourist tourist) {

		if (vacancy > 0) {
			touristList.add(tourist);
			vacancy--;
		} else {
			waitingList.add(tourist);
		}

	}

	public boolean stillAvailable() {
		if (vacancy > 0)
			return true;
		else
			return false;
	}

	public int getVacancy() {
		return vacancy;
	}

	public int getWaitingNum() {
		return waitingList.size();
	}

	public ArrayList<Tourist> getTouristList() {
		return touristList;

	}

	public ArrayList<Tourist> getWaitingList() {
		return waitingList;
	}

}
