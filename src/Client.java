import java.util.Vector;

public class Client {
    private static final double EUROS_PER_UNITAT_DE_COST = 30;
    private String nif;
    private String nom;
    private String telefon;
    private Vector<Lloguer> lloguers;

    public Client(String nif, String nom, String telefon) {
        this.nif = nif;
        this.nom = nom;
        this.telefon = telefon;
        this.lloguers = new Vector<Lloguer>();
    }

    public String getNif()     { return nif;     }
    public String getNom()     { return nom;     }
    public String getTelefon() { return telefon; }

    public void setNif(String nif) { this.nif = nif; }
    public void setNom(String nom) { this.nom = nom; }
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
    public void afegeix(Lloguer lloguer) {
        if (! lloguers.contains(lloguer) ) {
            lloguers.add(lloguer);
        }
    }
    public void elimina(Lloguer lloguer) {
        if (lloguers.contains(lloguer) ) {
            lloguers.remove(lloguer);
        }
    }
    public boolean conte(Lloguer lloguer) {
        return lloguers.contains(lloguer);
    }

    public String informe() {
        String resultat = "Informe de lloguers del client " +
            getNom() +
            " (" + getNif() + ")\n";
        for (Lloguer lloguer: lloguers) {
            // composa els resultats d'aquest lloguer
            resultat += "\t" +
                lloguer.getVehicle().getMarca() +
                " " +
                lloguer.getVehicle().getModel() + ": " +
                (lloguer.getPrecio() * EUROS_PER_UNITAT_DE_COST) + "€" + "\n";
        }

        // afegeix informació final
        resultat += "Import a pagar: " + importTotal() + "€\n" +
            "Punts guanyats: " + bonificacionsTotals() + "\n";
        return resultat;
    }
    public double importTotal() {
        double total = 0;
        for (Lloguer lloguer: lloguers) {
            total += lloguer.getPrecio() * EUROS_PER_UNITAT_DE_COST;
        }
        return total;
    }
    public int bonificacionsTotals() {
        int bonificacions = 0;
        for (Lloguer lloguer: lloguers) {
            bonificacions +=lloguer.bonificacions();
        }
        return bonificacions;
    }
    public String informeHTML() {
         String resultat = "<h1>Informe de lloguers</h1>\n" + 
                "<p>Informe de lloguers del client <em>"+getNom()+" </em> (<strong>"+getNif()+"</strong>)</p>\n" + 
                "<table>\n" + 
                "<tr><td><strong>Marca</strong></td><td><strong>Model</strong></td><td><strong>Import</strong></td></tr> ";
         for (Lloguer lloguer: lloguers) {
             resultat += "    <tr><td>"+lloguer.getVehicle().getMarca()+
                     "</td><td>"+lloguer.getVehicle().getModel()+
                     "</td><td>"+lloguer.getPrecio() * EUROS_PER_UNITAT_DE_COST+"€</td></tr>\n";
         }
         resultat+="</table>\n" + 
                "<p>Import a pagar: <em>" + importTotal() + "€</em></p>\n" + 
                "<p>Punts guanyats: <em>" + bonificacionsTotals() + "</em></p>";
         return resultat;
    }
}