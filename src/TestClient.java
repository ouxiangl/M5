import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;


public class TestClient {

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
			System.out.println(cliente.informe());
			assertEquals(cliente.informe(),"Informe de lloguers del client Pepe (12345678g)\n" + 
					"	Tata Vista: 90.0€\n" + 
					"Import a pagar: 90.0€\n" + 
					"Punts guanyats: 1\n");
		} catch (ParseException e) {
			e.printStackTrace();
		}
  }
	
	public static void main(String args[]) {
    org.junit.runner.JUnitCore.main("TestPunt");
  }

}
