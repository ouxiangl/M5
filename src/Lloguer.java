import java.util.Date;

public class Lloguer {
	private Date date;
	private int dia;
	private Vehicle vehicle;
	
	public Lloguer(Date date, int dia, Vehicle vehicle){
		this.date = date;
		this.dia = dia;
		this.vehicle = vehicle;
	}

	public Date getData() {
		return date;
	}

	public Vehicle getVehicle() {
		return this.vehicle;
	}

	public int getDies() {
		return this.dia;
	}
}