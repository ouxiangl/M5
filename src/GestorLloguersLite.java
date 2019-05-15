import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GestorLloguersLite {

	public static void main(String[] args) {
		// demostració de construcció d'un vehicle de categoria BASIC
		Vehicle vehicleBasic = new Vehicle("Tata", "Vista", Vehicle.BASIC);

		// demostració de construccuó d'un lloguer amb una data
		SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
		Date date;
		try {
			date = dateFormat.parse("2/8/2013");
			Lloguer lloguerBasic = new Lloguer(date, 2, vehicleBasic);

			// demostració de formatat d'una data
			System.out.println(dateFormat.format(lloguerBasic.getData()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	public String inf (Client client) {
		String text = "";
		text = "Client:"+client.getNom()+"\n";
		text += "Client:"+client.getNif()+"\n";
		text += "Client:"+client.getNom()+"\n";
		System.out.println(text);
		return text;
	}

}
