package fallstudie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hilfsmethoden zum Zugriff auf die Fallstudien-Datenbank
 * 
 * @author sauer
 */
public class DBHelfer {

	private static Connection conn;

	public static void stelleVerbindungHer() {
		try {
			conn = (DriverManager.getConnection("jdbc:h2:~/test", "sa", ""));
			System.out.println("DB-Verbindung aufgebaut.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void beendeVerbindung() {
		try {
			conn.close();
			System.out.println("DB-Verbindung beendet.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void executeSQL(String sql) {
		try {
			conn.createStatement().execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static ResultSet executeSQLQuery(String sql) {
		ResultSet ergebnis = null;
		try {
			ergebnis = conn.createStatement().executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ergebnis;
	}

	public static void legeTabellenAn() {
		try {
			Statement stmt = conn.createStatement();
			stmt.execute("CREATE TABLE Mitarbeiter (MNr int PRIMARY KEY"
					+ ", MName varchar)");
			stmt.execute("CREATE TABLE Projekt (PNr int PRIMARY KEY,"
					+ "PName varchar, Kunde varchar, MaxMitarbeiter int)");
			stmt.execute("CREATE TABLE Faehigkeit (FName varchar, MNr varchar,"
					+ "PRIMARY KEY (FName, MNr), "
					+ "FOREIGN KEY (MNr) REFERENCES Mitarbeiter (MNr) )");
			stmt.execute("CREATE TABLE Projektarbeit (PNr varchar, MNr varchar, "
					+ "FName varchar, PRIMARY KEY (PNr, MNr, FName), "
					+ "FOREIGN KEY (PNr) REFERENCES Projekt (PNr), "
					+ "FOREIGN KEY (MNr) REFERENCES Mitarbeiter (MNr), "
					+ "FOREIGN KEY (FName) REFERENCES Faehigkeit (FName) )");
			stmt.close();
			System.out.println("Tabellen angelegt.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void befuelleTabellen() {
		try {
			Statement stmt = conn.createStatement();
			stmt.execute("INSERT INTO Mitarbeiter VALUES (100, 'Meier')");
			stmt.execute("INSERT INTO Mitarbeiter VALUES (101, 'Schulze')");
			stmt.execute("INSERT INTO Mitarbeiter VALUES (102, 'Schmidt')");

			stmt.execute("INSERT INTO Projekt VALUES (542, 'Studierendengebuehren', 'Ministerium', 10)");

			stmt.execute("INSERT INTO Faehigkeit VALUES ('Projektleiter', 100)");
			stmt.execute("INSERT INTO Faehigkeit VALUES ('Softwareentwickler', 100)");
			stmt.execute("INSERT INTO Faehigkeit VALUES ('Projektleiter', 101)");
			stmt.execute("INSERT INTO Faehigkeit VALUES ('Softwarearchitekt', 101)");
			stmt.execute("INSERT INTO Faehigkeit VALUES ('Berater', 102)");

			stmt.execute("INSERT INTO Projektarbeit VALUES (542, 100, 'Projektleiter')");
			stmt.execute("INSERT INTO Projektarbeit VALUES (542, 100, 'Softwareentwickler')");
			stmt.execute("INSERT INTO Projektarbeit VALUES (542, 101, 'Softwarearchitekt')");
			stmt.execute("INSERT INTO Projektarbeit VALUES (542, 102, 'Berater')");
			stmt.close();

			System.out.println("Tabellen befüllt.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}