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
	public double quantitat() {
		double quantitat = 0;
    	switch (getVehicle().getCategoria()) {
	        case Vehicle.BASIC:
	            quantitat += 3;
	            if (getDies() > 3) {
	                quantitat += (getDies() - 3) * 1.5;
	            }
	            break;
	        case Vehicle.GENERAL:
	            quantitat += 4;
	            if (getDies() > 2) {
	                quantitat += (getDies() - 2) * 2.5;
	            }
	            break;
	        case Vehicle.LUXE:
	            quantitat += getDies() * 6;
	            break;
	    }
		return quantitat;
	}
	public int bonificacions() {
		int bonificacions = 1;
        if (getVehicle().getCategoria() == Vehicle.LUXE &&
                getDies()>1 ) {
            bonificacions ++;
        }
		return bonificacions;
	}
}
