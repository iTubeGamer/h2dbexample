package fallstudie;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Methoden zum Zugriff auf die Projektarbeit-Tabelle
 * 
 * @author kroner
 */
public class ProjektarbeitZugriff {
	public static void fuegeProjektarbeitEin(int projektnr, int mitarbeiternr, String Fname) {
		DBHelfer.executeSQL("INSERT INTO Projektarbeit VALUES (" + projektnr + ", '" + mitarbeiternr + "', '" + Fname + "')");
	}

	public static void aendereProjektarbeit(int nummer, String neuerName) {
		DBHelfer.executeSQL("UPDATE Projektarbeit SET PName='" + neuerName + "' WHERE PNr= " + nummer);
	}

	public static void loescheProjektarbeit(int nummer) {
		DBHelfer.executeSQL("DELETE FROM Projektarbeit WHERE PNr=" + nummer);
	}

	public static void gibAlleProjektarbeitAus() {
		ResultSet rs = DBHelfer.executeSQLQuery("SELECT * FROM Projektarbeit");
		try {
			while (rs.next()) {
				System.out.println("Projektarbeitnr. " + rs.getString(1) + ": " + rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}