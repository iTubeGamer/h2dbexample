package fallstudie;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Methoden zum Zugriff auf die Mitarbeiter-Tabelle
 * 
 * @author sauer
 */
public class MitarbeiterZugriff {
	public static void fuegeMitarbeiterEin(int nummer, String name) {
		DBHelfer.executeSQL("INSERT INTO Mitarbeiter VALUES (" + nummer + ", '"
				+ name + "')");
	}

	public static void aendereMitarbeiter(int nummer, String neuerName) {
		DBHelfer.executeSQL("UPDATE Mitarbeiter SET MName='" + neuerName
				+ "' WHERE MNr= " + nummer);
	}

	public static void loescheMitarbeiter(int nummer) {
		DBHelfer.executeSQL("DELETE FROM Mitarbeiter WHERE MNr=" + nummer);
	}

	public static void gibAlleMitarbeiterAus() {
		ResultSet rs = DBHelfer.executeSQLQuery("SELECT * FROM Mitarbeiter");
		try {
			while (rs.next()) {
				System.out.println("Mitarbeiternr. " + rs.getString(1) + ": "
						+ rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}