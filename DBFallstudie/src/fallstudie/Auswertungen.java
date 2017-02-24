package fallstudie;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Auswertungen über Projekte, Mitarbeiter und Fähigkeiten
 * 
 * @author sauer
 * 
 */
public class Auswertungen {
	public static void alleMitarbeiter() {
		ResultSet rsMitarbeiter =
				DBHelfer.executeSQLQuery("SELECT * FROM Mitarbeiter");
		try {
			while (rsMitarbeiter.next()) {
				String mnr = rsMitarbeiter.getString(1);
				ResultSet rsFaehigkeiten =
						DBHelfer.executeSQLQuery("SELECT * FROM Faehigkeit WHERE MNr="
								+ mnr);
				ResultSet rsProjekte =
						DBHelfer.executeSQLQuery("SELECT * FROM Projektarbeit WHERE MNr="
								+ mnr);

				System.out.println("Mitarbeiter " + mnr + " ("
						+ rsMitarbeiter.getString(2) + "):");
				System.out.print("  Fähigkeiten: ");
				while (rsFaehigkeiten.next()) {
					System.out.print(rsFaehigkeiten.getString(1) + "; ");
				}
				System.out.println();
				System.out.print("  Projekte: ");
				while (rsProjekte.next()) {
					System.out.print(rsProjekte.getString(1) + "("
							+ rsProjekte.getString(3) + "); ");
				}
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}