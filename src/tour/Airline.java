package tour;

public class Airline implements Reservations {

	private double price;
	private String desc;

	public Airline(String desc, double price) {
		this.desc = desc;
		this.price = price;
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
