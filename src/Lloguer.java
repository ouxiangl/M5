import java.util.Date;

public class Lloguer {
	private static final double EUROS_PER_UNITAT_DE_COST_VEHICLE_BASIC = 3;
	private static final double DIES_INICI_VEHICLE_BASIC = 3;
	private static final double EUROS_PER_DIES_INICI_VEHICLE_BASIC = 1.5;
	private static final double EUROS_PER_UNITAT_DE_COST_VEHICLE_GENERAL = 4;
	private static final double DIES_INICI_VEHICLE_GENERAL = 2;
	private static final double EUROS_PER_DIES_INICI_VEHICLE_GENERAL = 2.5;
	private static final double EUROS_PER_DIES_VEHICLE_LUXE = 6;
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
	            quantitat += EUROS_PER_UNITAT_DE_COST_VEHICLE_BASIC;
	            if (getDies() > DIES_INICI_VEHICLE_BASIC) {
	                quantitat += (getDies() - DIES_INICI_VEHICLE_BASIC) * EUROS_PER_DIES_INICI_VEHICLE_BASIC;
	            }
	            break;
	        case Vehicle.GENERAL:
	            quantitat += EUROS_PER_UNITAT_DE_COST_VEHICLE_GENERAL;
	            if (getDies() > DIES_INICI_VEHICLE_GENERAL) {
	                quantitat += (getDies() - DIES_INICI_VEHICLE_GENERAL) * EUROS_PER_DIES_INICI_VEHICLE_GENERAL;
	            }
	            break;
	        case Vehicle.LUXE:
	            quantitat += getDies() * EUROS_PER_DIES_VEHICLE_LUXE;
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
