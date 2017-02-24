package fallstudie;

/**
 * Legt die Datenbank an und bef�llt sie mit Testdaten
 * 
 * @author sauer
 */
public class DBAnlegen {

	public static void main(String[] args) {
		DBHelfer.stelleVerbindungHer();

		DBHelfer.legeTabellenAn();
		DBHelfer.befuelleTabellen();

		DBHelfer.beendeVerbindung();
	}
}
