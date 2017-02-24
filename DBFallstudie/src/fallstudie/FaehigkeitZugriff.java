package fallstudie;


import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Methoden zum Zugriff auf die Faehigkeit-Tabelle
 * 
 * @author kroner
 */
public class FaehigkeitZugriff {
	public static void fuegeFaehigkeitEin(int nummer, String name) {
		DBHelfer.executeSQL("INSERT INTO Faehigkeit VALUES ('"+name+"',"+nummer+")");
	}

	public static void aendereFaehigkeit(int nummer, String neuerName) {
		DBHelfer.executeSQL("UPDATE Faehigkeit SET FName='" + neuerName + "' WHERE MNr= " + nummer);
	}

	public static void loescheFaehigkeit(int nummer) {
		DBHelfer.executeSQL("DELETE FROM Faehigkeit WHERE MNr=" + nummer);
	}

	public static void gibAlleFaehigkeitAus() {
		ResultSet rs = DBHelfer.executeSQLQuery("SELECT * FROM Faehigkeit");
		try {
			while (rs.next()) {
				System.out.println("Faehigkeitnr. " + rs.getString(1) + ": " + rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}