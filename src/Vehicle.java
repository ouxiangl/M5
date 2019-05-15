public class Vehicle {
	public static final int BASIC = 1;
	public static final int GENERAL = 2;
	public static final int LUXE = 3;
	private String modelo;
	private String marca;
	private int categoria;
	Vehicle(String marca,String modelo,int cat){
		this.modelo = modelo;
		this.marca = marca;
		this.categoria = cat;
	}
	public int getCategoria() {
		/*switch (this.categoria) {
			case BASIC:
				return "Basico";
				break;
		}*/
		return this.categoria;
	}
	public String getMarca() {
		return this.marca;
	}
	public String getModel() {
		return this.modelo;
	}
}