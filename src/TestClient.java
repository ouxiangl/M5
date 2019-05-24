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
	//----------------------------------------------------------------------------------------------------------------------//
	//----------------------------------------------------------------------------------------------------------------------//
	//----------------------------------------------------------------------------------------------------------------------//
	//----------------------------------------------------------------------------------------------------------------------//
	//----------------------------------------------------TEST INFORME HTML-------------------------------------------------//
	//----------------------------------------------------------------------------------------------------------------------//
	//----------------------------------------------------------------------------------------------------------------------//
	//----------------------------------------------------------------------------------------------------------------------//
	//----------------------------------------------------------------------------------------------------------------------//
	@Test
	public void testInformeHtmlZeroVehicle() {
			Client cliente = new Client("12345678g","Pepe","+34123456789");
			//System.out.println(cliente.informeHTML());
			assertEquals(cliente.informeHTML(),"<h1>Informe de lloguers</h1>\n" + 
					"<p>Informe de lloguers del client <em>Pepe </em> (<strong>12345678g</strong>)</p>\n" + 
					"<table>\n" + 
					"<tr><td><strong>Marca</strong></td><td><strong>Model</strong></td><td><strong>Import</strong></td></tr> </table>\n" + 
					"<p>Import a pagar: <em>0.0€</em></p>\n" + 
					"<p>Punts guanyats: <em>0</em></p>");
    }
	
	@Test
	public void testInformeHtmlUnVehicleBasic() {
		try {
			Vehicle vehicleBasic = new Vehicle("Tata", "Vista", Vehicle.BASIC);
			
			// demostració de construccuó d'un lloguer amb una data
			SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
			Date date;
			date = dateFormat.parse("2/8/2013");
			Lloguer lloguerBasic = new Lloguer(date, 2, vehicleBasic);
			
			Client cliente = new Client("12345678g","Pepe","+34123456789");
			cliente.afegeix(lloguerBasic);
			//System.out.println(cliente.informeHTML());
			assertEquals(cliente.informeHTML(),"<h1>Informe de lloguers</h1>\n" + 
					"<p>Informe de lloguers del client <em>Pepe </em> (<strong>12345678g</strong>)</p>\n" + 
					"<table>\n" + 
					"<tr><td><strong>Marca</strong></td><td><strong>Model</strong></td><td><strong>Import</strong></td></tr>     <tr><td>Tata</td><td>Vista</td><td>90.0€</td></tr>\n" + 
					"</table>\n" + 
					"<p>Import a pagar: <em>90.0€</em></p>\n" + 
					"<p>Punts guanyats: <em>1</em></p>");
		} catch (ParseException e) {
			e.printStackTrace();
		}
    }
	
	@Test
	public void testInformeHtmlDosVehicle() {
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
			//System.out.println(cliente.informeHTML());
			assertEquals(cliente.informeHTML(),"<h1>Informe de lloguers</h1>\n" + 
					"<p>Informe de lloguers del client <em>Pepe </em> (<strong>12345678g</strong>)</p>\n" + 
					"<table>\n" + 
					"<tr><td><strong>Marca</strong></td><td><strong>Model</strong></td><td><strong>Import</strong></td></tr>     <tr><td>Tata</td><td>Vista</td><td>90.0€</td></tr>\n" + 
					"    <tr><td>Tata2</td><td>Vista2</td><td>120.0€</td></tr>\n" + 
					"</table>\n" + 
					"<p>Import a pagar: <em>210.0€</em></p>\n" + 
					"<p>Punts guanyats: <em>2</em></p>");
		} catch (ParseException e) {
			e.printStackTrace();
		}
    }
	
	@Test
	public void testInformeHtmlTresVehicle() {
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
			//System.out.println(cliente.informeHTML());
			assertEquals(cliente.informeHTML(),"<h1>Informe de lloguers</h1>\n" + 
					"<p>Informe de lloguers del client <em>Pepe </em> (<strong>12345678g</strong>)</p>\n" + 
					"<table>\n" + 
					"<tr><td><strong>Marca</strong></td><td><strong>Model</strong></td><td><strong>Import</strong></td></tr>     <tr><td>Tata</td><td>Vista</td><td>90.0€</td></tr>\n" + 
					"    <tr><td>Tata2</td><td>Vista2</td><td>120.0€</td></tr>\n" + 
					"    <tr><td>Tata3</td><td>Vista3</td><td>360.0€</td></tr>\n" + 
					"</table>\n" + 
					"<p>Import a pagar: <em>570.0€</em></p>\n" + 
					"<p>Punts guanyats: <em>4</em></p>");
		} catch (ParseException e) {
			e.printStackTrace();
		}
    }
	@Test
	public void testInformeHtmlTresVehicleAmbDiesDiferent() {
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
			//System.out.println(cliente.informeHTML());
			assertEquals(cliente.informeHTML(),"<h1>Informe de lloguers</h1>\n" + 
					"<p>Informe de lloguers del client <em>Pepe </em> (<strong>12345678g</strong>)</p>\n" + 
					"<table>\n" + 
					"<tr><td><strong>Marca</strong></td><td><strong>Model</strong></td><td><strong>Import</strong></td></tr>     <tr><td>Tata</td><td>Vista</td><td>270.0€</td></tr>\n" + 
					"    <tr><td>Tata2</td><td>Vista2</td><td>345.0€</td></tr>\n" + 
					"    <tr><td>Tata3</td><td>Vista3</td><td>540.0€</td></tr>\n" + 
					"</table>\n" + 
					"<p>Import a pagar: <em>1155.0€</em></p>\n" + 
					"<p>Punts guanyats: <em>4</em></p>");
		} catch (ParseException e) {
			e.printStackTrace();
		}
    }
	@Test
	public void testInformeHtmlExercicio21() {
		try {
			Vehicle vehicleBasic = new Vehicle("Tata", "Vista", Vehicle.BASIC);
			Vehicle vehicleGeneral = new Vehicle("Wolswagen", "Passat", Vehicle.GENERAL);
			Vehicle vehicleLuxe = new Vehicle("Mercedes", "SLK 2.0", Vehicle.LUXE);
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
			Date date;
			date = dateFormat.parse("2/8/2013");
			Lloguer lloguerBasic = new Lloguer(date, 1, vehicleBasic);
			Lloguer lloguerGeneral = new Lloguer(date, 4, vehicleGeneral);
			Lloguer lloguerLuxe = new Lloguer(date, 2, vehicleLuxe);
			
			Client cliente = new Client("43092837A","Ken Robinson","+34123456789");
			cliente.afegeix(lloguerBasic);
			cliente.afegeix(lloguerGeneral);
			cliente.afegeix(lloguerLuxe);
			//System.out.println(cliente.informeHTML());
			assertEquals(cliente.informeHTML(),"<h1>Informe de lloguers</h1>\n" + 
					"<p>Informe de lloguers del client <em>Ken Robinson </em> (<strong>43092837A</strong>)</p>\n" + 
					"<table>\n" + 
					"<tr><td><strong>Marca</strong></td><td><strong>Model</strong></td><td><strong>Import</strong></td></tr>     <tr><td>Tata</td><td>Vista</td><td>90.0€</td></tr>\n" + 
					"    <tr><td>Wolswagen</td><td>Passat</td><td>270.0€</td></tr>\n" + 
					"    <tr><td>Mercedes</td><td>SLK 2.0</td><td>360.0€</td></tr>\n" + 
					"</table>\n" + 
					"<p>Import a pagar: <em>720.0€</em></p>\n" + 
					"<p>Punts guanyats: <em>4</em></p>");
		} catch (ParseException e) {
			e.printStackTrace();
		}
    }
	
	public static void main(String args[]) {
        org.junit.runner.JUnitCore.main("TestPunt");
    }

}
