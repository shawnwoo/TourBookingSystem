package tour;

import java.text.DecimalFormat;

public class Temperature {

	private double TempF;

	public Temperature(double TempF) {
		this.TempF = TempF;
	}

	/**
	 * @return the tempF
	 */
	public String getTempF() {
		return FToOneDecimal(TempF);
	}

	/**
	 * @param tempF
	 *            the tempF to set
	 */
	public void setTempF(double tempF) {
		TempF = tempF;
	}

	public String getTempC() {
		return FToOneDecimal((TempF - 32) * 5 / 9);
	}

	private String FToOneDecimal(Double d) {
		DecimalFormat df = new DecimalFormat("#.#");
		return df.format(d);
	}

}
