package tour;

public class LocalTransport implements Reservations {

	private String desc;
	private double price;

	public LocalTransport(String string, double d) {
		this.setDesc(string);
		this.price = d;
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return price;
	}

	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * @param desc
	 *            the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;

	}

	public void setPrice(double price) {
		this.price = price;
	}
}
