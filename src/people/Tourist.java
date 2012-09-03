package people;

import tour.Tour;

public class Tourist implements People {
	
	private Tour tour;
	private double totalPrice;
	private String email;
	private String address;
	private String name;
	
	
	

	@Override
	public double calculateTotalPrice() {
		// TODO Auto-generated method stub
		totalPrice=tour.getPrice();
		
		
		return totalPrice;
	}

	public Tourist(String name){
		this.name=name;
	}


	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}




	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}




	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}




	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}




	/**
	 * @return the phoneNumber
	 */
	public String getName() {
		return name;
	}




	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
