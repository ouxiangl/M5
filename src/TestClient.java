import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;


public class TestClient {
	@Test
	public void testInformeZeroVehicle() {
			Client cliente = new Client("12345678g","Pepe","+34123456789");
			//System.out.println(cliente.informe());
			assertEquals(cliente.informe(),"Informe de lloguers del client Pepe (12345678g)\n" + 
					"Import a pagar: 0.0€\n" + 
					"Punts guanyats: 0\n");
    }
	@Test
	public void testInformeUnVehicleBasic() {
		try {
			Vehicle vehicleBasic = new Vehicle("Tata", "Vista", Vehicle.BASIC);
			
			// demostració de construccuó d'un lloguer amb una data
			SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
			Date date;
			date = dateFormat.parse("2/8/2013");
			Lloguer lloguerBasic = new Lloguer(date, 2, vehicleBasic);
			
			Client cliente = new Client("12345678g","Pepe","+34123456789");
			cliente.afegeix(lloguerBasic);
			//System.out.println(cliente.informe());
			assertEquals(cliente.informe(),"Informe de lloguers del client Pepe (12345678g)\n" + 
					"	Tata Vista: 90.0€\n" + 
					"Import a pagar: 90.0€\n" + 
					"Punts guanyats: 1\n");
		} catch (ParseException e) {
			e.printStackTrace();
		}
    }
	@Test
	public void testInformeDosVehicle() {
		try {
			Vehicle vehicleBasic = new Vehicle("Tata", "Vista", Vehicle.BASIC);
			Vehicle vehicleGeneral = new Vehicle("Tata2", "Vista2", Vehicle.GENERAL);
			
			// demostració de construccuó d'un lloguer amb una data
			SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
			Date date;
			date = dateFormat.parse("2/8/2013");
			Lloguer lloguerBasic = new Lloguer(date, 2, vehicleBasic);
			Lloguer lloguerGeneral = new Lloguer(date, 2, vehicleGeneral);
			
			Client cliente = new Client("12345678g","Pepe","+34123456789");
			cliente.afegeix(lloguerBasic);
			cliente.afegeix(lloguerGeneral);
			//System.out.println(cliente.informe());
			assertEquals(cliente.informe(),"Informe de lloguers del client Pepe (12345678g)\n" + 
					"	Tata Vista: 90.0€\n" + 
					"	Tata2 Vista2: 120.0€\n" + 
					"Import a pagar: 210.0€\n" + 
					"Punts guanyats: 2\n");
		} catch (ParseException e) {
			e.printStackTrace();
		}
    }
	@Test
	public void testInformeTresVehicle() {
		try {
			Vehicle vehicleBasic = new Vehicle("Tata", "Vista", Vehicle.BASIC);
			Vehicle vehicleGeneral = new Vehicle("Tata2", "Vista2", Vehicle.GENERAL);
			Vehicle vehicleLuxe = new Vehicle("Tata3", "Vista3", Vehicle.LUXE);
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
			Date date;
			date = dateFormat.parse("2/8/2013");
			Lloguer lloguerBasic = new Lloguer(date, 2, vehicleBasic);
			Lloguer lloguerGeneral = new Lloguer(date, 2, vehicleGeneral);
			Lloguer lloguerLuxe = new Lloguer(date, 2, vehicleLuxe);
			
			Client cliente = new Client("12345678g","Pepe","+34123456789");
			cliente.afegeix(lloguerBasic);
			cliente.afegeix(lloguerGeneral);
			cliente.afegeix(lloguerLuxe);
			//System.out.println(cliente.informe());
			assertEquals(cliente.informe(),"Informe de lloguers del client Pepe (12345678g)\n" + 
					"	Tata Vista: 90.0€\n" + 
					"	Tata2 Vista2: 120.0€\n" + 
					"	Tata3 Vista3: 360.0€\n" + 
					"Import a pagar: 570.0€\n" + 
					"Punts guanyats: 4\n");
		} catch (ParseException e) {
			e.printStackTrace();
		}
    }
	@Test
	public void testInformeTresVehicleAmbDiesDiferent() {
		try {
			Vehicle vehicleBasic = new Vehicle("Tata", "Vista", Vehicle.BASIC);
			Vehicle vehicleGeneral = new Vehicle("Tata2", "Vista2", Vehicle.GENERAL);
			Vehicle vehicleLuxe = new Vehicle("Tata3", "Vista3", Vehicle.LUXE);
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
			Date date;
			date = dateFormat.parse("2/8/2013");
			Lloguer lloguerBasic = new Lloguer(date, 7, vehicleBasic);
			Lloguer lloguerGeneral = new Lloguer(date, 5, vehicleGeneral);
			Lloguer lloguerLuxe = new Lloguer(date, 3, vehicleLuxe);
			
			Client cliente = new Client("12345678g","Pepe","+34123456789");
			cliente.afegeix(lloguerBasic);
			cliente.afegeix(lloguerGeneral);
			cliente.afegeix(lloguerLuxe);
			//System.out.println(cliente.informe());
			assertEquals(cliente.informe(),"Informe de lloguers del client Pepe (12345678g)\n" + 
					"	Tata Vista: 270.0€\n" + 
					"	Tata2 Vista2: 345.0€\n" + 
					"	Tata3 Vista3: 540.0€\n" + 
					"Import a pagar: 1155.0€\n" + 
					"Punts guanyats: 4\n");
		} catch (ParseException e) {
			e.printStackTrace();
		}
    }
	
	public static void main(String args[]) {
        org.junit.runner.JUnitCore.main("TestPunt");
    }

}
