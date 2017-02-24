package fallstudie;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjektZugriff {
	public static void fuegeProjektEin(int nummer, String name, int maxMitarbeiter, String kunde) {
		DBHelfer.executeSQL("INSERT INTO Projekt VALUES (" + nummer + ", '"
				+ name + "','" + kunde + "'," + maxMitarbeiter + ")");
	}

	public static void aendereProjektnamen(int nummer, String neuerName) {
		DBHelfer.executeSQL("UPDATE Projekt SET PName='" + neuerName
				+  "' WHERE PNr= " + nummer);
	}
	
	public static void aendereProjektkunden(int Projektnummer, String neuerKunde) {
		DBHelfer.executeSQL("UPDATE Projekt SET Kunde='" + neuerKunde
				+  "' WHERE PNr= " + Projektnummer);
	}

	public static void loescheProjekt(int nummer) {
		DBHelfer.executeSQL("DELETE FROM Projekt WHERE PNr=" + nummer);
	}

	public static void gibAlleProjekteAus() {
		ResultSet rs = DBHelfer.executeSQLQuery("SELECT * FROM Mitarbeiter");
		try {
			while (rs.next()) {
				System.out.println("Projektnr. " + rs.getString(1) + ": "
						+ rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
