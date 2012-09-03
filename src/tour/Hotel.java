package tour;


public class Hotel implements Reservations {
	
	private String desc;
	private double price;

	public Hotel(String string, double d) {
		
		this.desc=string;
		this.price=d;
	}

	@Override
	public double getPrice() {
		return price;
	}

	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

}
