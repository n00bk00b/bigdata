package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class BigMama extends Application {

	int zeilenAnzahl = -1;
	int spaltenAnzahl = 0;

	String[] einzelStrings;
	String[] zeilen;
	String[] spalten;
	BufferedReader buf;
	int countNamen;
	String[] arrNamen;
	int countVornamen;
	String[] arrVornamen;
	String[] kartenInstitut;
	String[] arrIban;
	long[] arrTelNr;
	String[] emailEndungen;
	String[] emailAnfang;
	int countWiederholungName;
	int countWiederholungVorname;
	String[] emailAnbieter;
	Vector<Integer> ausgewählt = new Vector<Integer>();

	Stage primaryStage;

	@Override
	public void start(Stage primaryStage) {

		this.primaryStage = primaryStage;
		Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getClassLoader().getResource("bigdati.fxml"));
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
		primaryStage.setResizable(false);

	}

	int globalCounter = 1;

	@FXML
	TextArea textArea;
	@FXML
	Label labelID;
	Vector<String> vektorAusgewählt = new Vector<String>();
	boolean id;

	@FXML
	private void handleId(ActionEvent event) {
		id = !id;
		if (id) {
			labelID.setText("" + globalCounter);
			globalCounter++;

			ausgewählt.add(0);
			vektorAusgewählt.add("1,");
			String tmp = "";
			for (int i = 0; i < vektorAusgewählt.size(); i++) {
				tmp += vektorAusgewählt.get(i);
			}
			textArea.setText(tmp);
			spaltenAnzahl++;

		}
		else {
			ausgewählt.remove(new Integer(0));
			labelID.setText("0");
			globalCounter--;
			vektorAusgewählt.remove("1,");
			String tmp = "";
			for (int i = 0; i < vektorAusgewählt.size(); i++) {
				tmp += vektorAusgewählt.get(0);
			}
			textArea.setText(tmp);

			spaltenAnzahl--;
		}
	}

	@FXML
	Label labelVorname;
	boolean vorname;

	@FXML
	private void handleVorname(ActionEvent event) {
		vorname = !vorname;
		if (vorname) {
			labelVorname.setText("" + globalCounter);
			globalCounter++;
			ausgewählt.add(1);
			vektorAusgewählt.add("Max,");
			String tmp = "";
			for (int i = 0; i < vektorAusgewählt.size(); i++) {
				tmp += vektorAusgewählt.get(i);
			}
			textArea.setText(tmp);
			spaltenAnzahl++;
		}
		else {
			ausgewählt.remove(new Integer(1));

			labelVorname.setText("0");
			globalCounter--;
			vektorAusgewählt.remove("Max,");
			String tmp = "";
			for (int i = 0; i < vektorAusgewählt.size(); i++) {
				tmp += vektorAusgewählt.get(i);
			}
			textArea.setText(tmp);
			spaltenAnzahl--;
		}
	}

	@FXML
	Label labelNachname;
	boolean nachname;

	@FXML
	private void handleNachname(ActionEvent event) {
		// Ändern
		nachname = !nachname;
		// Ändern
		if (nachname) {
			// Ändern
			labelNachname.setText("" + globalCounter);
			globalCounter++;
			// Ändern +1
			ausgewählt.add(2);
			// Ändern
			vektorAusgewählt.add("Mustermann,");
			String tmp = "";
			for (int i = 0; i < vektorAusgewählt.size(); i++) {
				tmp += vektorAusgewählt.get(i);
			}
			textArea.setText(tmp);
			spaltenAnzahl++;
		}
		else {
			ausgewählt.remove(new Integer(2));

			// Ändern
			labelNachname.setText("0");
			globalCounter--;
			// Ändern
			vektorAusgewählt.remove("Mustermann,");
			String tmp = "";
			for (int i = 0; i < vektorAusgewählt.size(); i++) {
				tmp += vektorAusgewählt.get(i);
			}
			textArea.setText(tmp);
			spaltenAnzahl--;
		}
	}

	@FXML
	Label labelIban;
	boolean iban;

	@FXML
	private void handleIban(ActionEvent event) {
		// Ändern
		iban = !iban;
		// Ändern
		if (iban) {
			// Ändern
			labelIban.setText("" + globalCounter);
			globalCounter++;
			// Ändern +1
			ausgewählt.add(3);
			// Ändern
			vektorAusgewählt.add("DE27100777770209299700,");
			String tmp = "";
			for (int i = 0; i < vektorAusgewählt.size(); i++) {
				tmp += vektorAusgewählt.get(i);
			}
			textArea.setText(tmp);
			spaltenAnzahl++;
		}
		else {

			ausgewählt.remove(new Integer(3));

			// Ändern label*
			labelIban.setText("0");
			globalCounter--;
			// Ändern
			vektorAusgewählt.remove("DE27100777770209299700,");
			String tmp = "";
			for (int i = 0; i < vektorAusgewählt.size(); i++) {
				tmp += vektorAusgewählt.get(i);
			}
			textArea.setText(tmp);
			spaltenAnzahl--;
		}
	}

	@FXML
	Label labelLandcode;
	boolean landcode;

	@FXML
	private void handleLandcode(ActionEvent event) {
		// Ändern
		landcode = !landcode;
		// Ändern
		if (landcode) {
			// Ändern
			labelLandcode.setText("" + globalCounter);
			globalCounter++;
			// Ändern +1
			ausgewählt.add(4);
			// Ändern
			vektorAusgewählt.add("DE,");
			String tmp = "";
			for (int i = 0; i < vektorAusgewählt.size(); i++) {
				tmp += vektorAusgewählt.get(i);
			}
			textArea.setText(tmp);
			spaltenAnzahl++;
		}
		else {

			ausgewählt.remove(new Integer(4));

			// Ändern label*
			labelLandcode.setText("0");
			globalCounter--;
			// Ändern
			vektorAusgewählt.remove("DE,");
			String tmp = "";
			for (int i = 0; i < vektorAusgewählt.size(); i++) {
				tmp += vektorAusgewählt.get(i);
			}
			textArea.setText(tmp);
			spaltenAnzahl--;
		}
	}

	@FXML
	Label labelLand;
	boolean land;

	@FXML
	private void handleLand(ActionEvent event) {
		// Ändern
		land = !land;
		// Ändern
		if (land) {
			// Ändern
			labelLand.setText("" + globalCounter);
			globalCounter++;
			// Ändern +1
			ausgewählt.add(5);
			// Ändern
			vektorAusgewählt.add("Deutschland,");
			String tmp = "";
			for (int i = 0; i < vektorAusgewählt.size(); i++) {
				tmp += vektorAusgewählt.get(i);
			}
			textArea.setText(tmp);
			spaltenAnzahl++;
		}
		else {
			ausgewählt.remove(new Integer(5));

			// Ändern label*
			labelLand.setText("0");
			globalCounter--;
			// Ändern
			vektorAusgewählt.remove("Deutschland,");
			String tmp = "";
			for (int i = 0; i < vektorAusgewählt.size(); i++) {
				tmp += vektorAusgewählt.get(i);
			}
			textArea.setText(tmp);
			spaltenAnzahl--;
		}
	}

	@FXML
	Label labelAbreisedatum;
	boolean abreise;

	@FXML
	private void handleAbreisedatum(ActionEvent event) {
		// Ändern
		abreise = !abreise;
		// Ändern
		if (abreise) {
			// Ändern
			labelAbreisedatum.setText("" + globalCounter);
			globalCounter++;
			// Ändern +1
			ausgewählt.add(6);
			// Ändern
			vektorAusgewählt.add("04.01.1991,");
			String tmp = "";
			for (int i = 0; i < vektorAusgewählt.size(); i++) {
				tmp += vektorAusgewählt.get(i);
			}
			textArea.setText(tmp);
			spaltenAnzahl++;
		}
		else {
			// ändern
			ausgewählt.remove(new Integer(6));

			// Ändern label*
			labelAbreisedatum.setText("0");
			globalCounter--;
			// Ändern
			vektorAusgewählt.remove("04.01.1991,");
			String tmp = "";
			for (int i = 0; i < vektorAusgewählt.size(); i++) {
				tmp += vektorAusgewählt.get(i);
			}
			textArea.setText(tmp);
			spaltenAnzahl--;
		}
	}

	@FXML
	Label labelRückreisedatum;
	boolean rückreise;

	@FXML
	private void handleRückreisedatum(ActionEvent event) {
		// Ändern
		rückreise = !rückreise;
		// Ändern
		if (rückreise) {
			// Ändern
			labelRückreisedatum.setText("" + globalCounter);
			globalCounter++;
			// Ändern +1
			ausgewählt.add(7);
			// Ändern
			vektorAusgewählt.add("14.01.1991,");
			String tmp = "";
			for (int i = 0; i < vektorAusgewählt.size(); i++) {
				tmp += vektorAusgewählt.get(i);
			}
			textArea.setText(tmp);
			spaltenAnzahl++;
		}
		else {
			// ändern
			ausgewählt.remove(new Integer(7));

			// Ändern label*
			labelRückreisedatum.setText("0");
			globalCounter--;
			// Ändern
			vektorAusgewählt.remove("14.01.1991,");
			String tmp = "";
			for (int i = 0; i < vektorAusgewählt.size(); i++) {
				tmp += vektorAusgewählt.get(i);
			}
			textArea.setText(tmp);
			spaltenAnzahl--;
		}
	}

	@FXML
	Label labelUrlaubstage;
	boolean urlaubstage;

	@FXML
	private void handleUrlaubstage(ActionEvent event) {
		// Ändern
		urlaubstage = !urlaubstage;
		// Ändern
		if (urlaubstage) {
			// Ändern
			labelUrlaubstage.setText("" + globalCounter);
			globalCounter++;
			// Ändern +1
			ausgewählt.add(8);
			// Ändern
			vektorAusgewählt.add("10,");
			String tmp = "";
			for (int i = 0; i < vektorAusgewählt.size(); i++) {
				tmp += vektorAusgewählt.get(i);
			}
			textArea.setText(tmp);
			spaltenAnzahl++;
		}
		else {
			// ändern
			ausgewählt.remove(new Integer(8));

			// Ändern label*
			labelUrlaubstage.setText("0");
			globalCounter--;
			// Ändern
			vektorAusgewählt.remove("10,");
			String tmp = "";
			for (int i = 0; i < vektorAusgewählt.size(); i++) {
				tmp += vektorAusgewählt.get(i);
			}
			textArea.setText(tmp);
			spaltenAnzahl--;
		}
	}

	@FXML
	Label labelStorno;
	boolean stor;

	@FXML
	private void handleStorno(ActionEvent event) {
		// Ändern
		stor = !stor;
		// Ändern
		if (stor) {
			// Ändern
			labelStorno.setText("" + globalCounter);
			globalCounter++;
			// Ändern +1
			ausgewählt.add(9);
			// Ändern
			vektorAusgewählt.add("nicht storniert,");
			String tmp = "";
			for (int i = 0; i < vektorAusgewählt.size(); i++) {
				tmp += vektorAusgewählt.get(i);
			}
			textArea.setText(tmp);
			spaltenAnzahl++;
		}
		else {
			// ändern
			ausgewählt.remove(new Integer(9));

			// Ändern label*
			labelStorno.setText("0");
			globalCounter--;
			// Ändern
			vektorAusgewählt.remove("nicht storniert,");
			String tmp = "";
			for (int i = 0; i < vektorAusgewählt.size(); i++) {
				tmp += vektorAusgewählt.get(i);
			}
			textArea.setText(tmp);
			spaltenAnzahl--;
		}
	}

	@FXML
	Label labelBewertungen;
	boolean bewe;

	@FXML
	private void handleBewertung(ActionEvent event) {
		// Ändern
		bewe = !bewe;
		// Ändern
		if (bewe) {
			// Ändern
			labelBewertungen.setText("" + globalCounter);
			globalCounter++;
			// Ändern +1
			ausgewählt.add(10);
			// Ändern
			vektorAusgewählt.add("5,");
			String tmp = "";
			for (int i = 0; i < vektorAusgewählt.size(); i++) {
				tmp += vektorAusgewählt.get(i);
			}
			textArea.setText(tmp);
			spaltenAnzahl++;
		}
		else {
			// ändern
			ausgewählt.remove(new Integer(10));

			// Ändern label*
			labelBewertungen.setText("0");
			globalCounter--;
			// Ändern
			vektorAusgewählt.remove("5,");
			String tmp = "";
			for (int i = 0; i < vektorAusgewählt.size(); i++) {
				tmp += vektorAusgewählt.get(i);
			}
			textArea.setText(tmp);
			spaltenAnzahl--;
		}
	}

	@FXML
	Label labelEmail;
	boolean email;

	@FXML
	private void handleEmail(ActionEvent event) {
		// Ändern
		email = !email;
		// Ändern
		if (email) {
			// Ändern
			labelEmail.setText("" + globalCounter);
			globalCounter++;
			// Ändern +1
			ausgewählt.add(11);
			// Ändern
			vektorAusgewählt.add("maxmusterman@email.de,");
			String tmp = "";
			for (int i = 0; i < vektorAusgewählt.size(); i++) {
				tmp += vektorAusgewählt.get(i);
			}
			textArea.setText(tmp);
			spaltenAnzahl++;
		}
		else {
			// ändern
			ausgewählt.remove(new Integer(11));

			// Ändern label*
			labelEmail.setText("0");
			globalCounter--;
			// Ändern
			vektorAusgewählt.remove("maxmusterman@email.de,");
			String tmp = "";
			for (int i = 0; i < vektorAusgewählt.size(); i++) {
				tmp += vektorAusgewählt.get(i);
			}
			textArea.setText(tmp);
			spaltenAnzahl--;
		}
	}

	@FXML
	Label labelHandyNr;
	boolean hn;

	@FXML
	private void handleHandyNr(ActionEvent event) {
		// Ändern
		hn = !hn;
		// Ändern
		if (hn) {
			// Ändern
			labelHandyNr.setText("" + globalCounter);
			globalCounter++;
			// Ändern +1
			ausgewählt.add(12);
			// Ändern
			vektorAusgewählt.add("01512232323,");
			String tmp = "";
			for (int i = 0; i < vektorAusgewählt.size(); i++) {
				tmp += vektorAusgewählt.get(i);
			}
			textArea.setText(tmp);
			spaltenAnzahl++;
		}
		else {
			// ändern
			ausgewählt.remove(new Integer(12));

			// Ändern label*
			labelHandyNr.setText("0");
			globalCounter--;
			// Ändern
			vektorAusgewählt.remove("01512232323,");
			String tmp = "";
			for (int i = 0; i < vektorAusgewählt.size(); i++) {
				tmp += vektorAusgewählt.get(i);
			}
			textArea.setText(tmp);
			spaltenAnzahl--;
		}
	}

	@FXML
	Label labelKartentyp;
	boolean kt;

	@FXML
	private void handleKartentyp(ActionEvent event) {
		// Ändern
		kt = !kt;
		// Ändern
		if (kt) {
			// Ändern
			labelKartentyp.setText("" + globalCounter);
			globalCounter++;
			// Ändern +1
			ausgewählt.add(13);
			// Ändern
			vektorAusgewählt.add("Master,");
			String tmp = "";
			for (int i = 0; i < vektorAusgewählt.size(); i++) {
				tmp += vektorAusgewählt.get(i);
			}
			textArea.setText(tmp);
			spaltenAnzahl++;
		}
		else {
			// ändern
			ausgewählt.remove(new Integer(13));
			// Ändern label*
			labelKartentyp.setText("0");
			globalCounter--;
			// Ändern
			vektorAusgewählt.remove("Master,");
			String tmp = "";
			for (int i = 0; i < vektorAusgewählt.size(); i++) {
				tmp += vektorAusgewählt.get(i);
			}
			textArea.setText(tmp);
			spaltenAnzahl--;
		}
	}

	@FXML
	Label labelGeburtsdatum;
	boolean gb;

	@FXML
	private void handleGeburtsdatum(ActionEvent event) {
		// Ändern
		gb = !gb;
		// Ändern
		if (gb) {
			// Ändern
			labelGeburtsdatum.setText("" + globalCounter);
			globalCounter++;
			// Ändern +1
			ausgewählt.add(14);
			// Ändern
			vektorAusgewählt.add("02.01.1950,");
			String tmp = "";
			for (int i = 0; i < vektorAusgewählt.size(); i++) {
				tmp += vektorAusgewählt.get(i);
			}
			textArea.setText(tmp);
			spaltenAnzahl++;
		}
		else {
			// ändern
			ausgewählt.remove(new Integer(14));
			// Ändern label*
			labelGeburtsdatum.setText("0");
			globalCounter--;
			// Ändern
			vektorAusgewählt.remove("02.01.1950,");
			String tmp = "";
			for (int i = 0; i < vektorAusgewählt.size(); i++) {
				tmp += vektorAusgewählt.get(i);
			}
			textArea.setText(tmp);
			spaltenAnzahl--;
		}
	}

	@FXML
	Label labelKundennr;
	boolean kundennr;

	@FXML
	private void handleKundennr(ActionEvent event) {
		// Ändern
		kundennr = !kundennr;
		// Ändern
		if (kundennr) {
			// Ändern
			labelKundennr.setText("" + globalCounter);
			globalCounter++;
			// Ändern +1
			ausgewählt.add(15);
			// Ändern
			vektorAusgewählt.add("100,");
			String tmp = "";
			for (int i = 0; i < vektorAusgewählt.size(); i++) {
				tmp += vektorAusgewählt.get(i);
			}
			textArea.setText(tmp);
			spaltenAnzahl++;
		}
		else {
			// ändern
			ausgewählt.remove(new Integer(15));
			// Ändern label*
			labelKundennr.setText("0");
			globalCounter--;
			// Ändern
			vektorAusgewählt.remove("100,");
			String tmp = "";
			for (int i = 0; i < vektorAusgewählt.size(); i++) {
				tmp += vektorAusgewählt.get(i);
			}
			textArea.setText(tmp);
			spaltenAnzahl--;
		}
	}

	String zahl = "";

	@FXML
	private void anzahlKeyTyped(KeyEvent event) {

	}

	@FXML
	TextField anzahlFeldAwesome;

	@FXML
	private void anzahlKeyPressed(KeyEvent event) {
	}

	@FXML
	private void delimiterKeyTyped(KeyEvent event) {
	}

	@FXML
	private void beenden(ActionEvent event) {
		System.exit(0);
	}

	@FXML
	TextField delimiter;

	@FXML
	private void zeilendelimiter(KeyEvent event) {
	}

	int countLandCode;
	String[] arrLandCode;
	int countLand;
	int reiseZeit;
	int speicherVar;
	String[] arrLand;

	@FXML
	public void generate() {

		try {
			zeilenAnzahl = Integer.valueOf(anzahlFeldAwesome.getText());
		}
		catch (Exception e) {

		}

		if (zeilenAnzahl == -1 || spaltenAnzahl == 0) {
			Alert alert = new Alert(AlertType.ERROR);
			String s = "Anzahl überprüfen oder Elemente ;)";
			alert.setContentText(s);
			alert.showAndWait();

		}
		else {

			emailAnfang = new String[zeilenAnzahl];
			einzelStrings = new String[zeilenAnzahl * spaltenAnzahl];
			emailEndungen = new String[] { "de", "com" };
			arrTelNr = new long[zeilenAnzahl];
			arrIban = new String[zeilenAnzahl];
			kartenInstitut = new String[] { "Visa", "MasterCard", "Maestro" };
			emailAnbieter = new String[] { "fake.email", "hello.world", "world" };
			zeilen = new String[zeilenAnzahl];
			spalten = new String[spaltenAnzahl];

			System.out.println("Working Directory = " + System.getProperty("user.dir"));
			// namen einlesen
			try {
				try {

					// buf =
					// Files.newBufferedReader(Paths.get("TabellenGenerator/namen.txt"));
					buf = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/res/namen.txt")));

					// buf =
					// Files.newBufferedReader(Paths.get("TabellenGenerator/namen.txt"));
				}
				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				while (buf.readLine() != null) {
					countNamen++;
				}
				arrNamen = new String[countNamen];
				buf = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/res/namen.txt")));
				for (int i = 0; i < arrNamen.length; i++) {
					arrNamen[i] = buf.readLine();
				}
			}
			catch (IOException e) {
				e.printStackTrace();
			}

			// vornamen einlesen
			try {
				buf = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/res/vornamen.txt")));

				while (buf.readLine() != null) {
					countVornamen++;
				}
				arrVornamen = new String[countVornamen];
				buf = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/res/vornamen.txt")));

				for (int i = 0; i < arrVornamen.length; i++) {
					arrVornamen[i] = buf.readLine();
				}
			}
			catch (IOException e) {
				e.printStackTrace();
			}

			try {
				buf = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/res/reisezielCode.txt")));

				while (buf.readLine() != null) {
					countLandCode++;
				}
				arrLandCode = new String[countLandCode];
				buf = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/res/reisezielCode.txt")));

				for (int i = 0; i < arrLandCode.length; i++) {
					arrLandCode[i] = buf.readLine();
				}
			}
			catch (IOException e) {
				e.printStackTrace();
			}

			// reiseziele einlesen
			try {
				buf = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/res/reiseziele.txt")));

				while (buf.readLine() != null) {
					countLand++;
				}
				arrLand = new String[countLand];
				buf = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/res/reiseziele.txt")));

				for (int i = 0; i < arrLand.length; i++) {
					arrLand[i] = buf.readLine();
				}
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			String sDelimiter = delimiter.getText();
			// Hauptgeschehen
			for (int i = 0; i < zeilen.length; i++) {
				// einzelStrings[i] = "" + (i + 1);
				// zeilen[i] = einzelStrings[i] + ",";

				zeilen[i] = "";
				for (int x = 0; x < ausgewählt.size(); x++) {
					int j = ausgewählt.get(x);
					if (j == 0) {
						einzelStrings[x] = "" + i + sDelimiter;
						zeilen[i] += "" + i + sDelimiter;
					}
					else if (j == 1) {
						einzelStrings[x] = vornamenChoiser();
						zeilen[i] += einzelStrings[x] + sDelimiter;
					}
					else if (j == 2) {
						einzelStrings[x] = nameChoiser();
						zeilen[i] += einzelStrings[x] + sDelimiter;
					}
					else if (j == 3) {
						einzelStrings[x] = "DE724866012000" + ibanGenerator2(i);
						zeilen[i] += einzelStrings[x] + sDelimiter;
					}
					else if (j == 4) {
						einzelStrings[x] = reisezielCodeChoiser();
						zeilen[i] += einzelStrings[x] + sDelimiter;
					}

					else if (j == 5) {
						einzelStrings[x] = reisezielChoiser();
						zeilen[i] += einzelStrings[x] + sDelimiter;
					}
					else if (j == 6) {
						einzelStrings[x] = reiseChoicer();
						zeilen[i] += einzelStrings[x] + sDelimiter;
					}

					else if (j == 7) {
						einzelStrings[x] = reiseChoicerRück();
						zeilen[i] += einzelStrings[x] + sDelimiter;
					}
					else if (j == 8) {
						einzelStrings[x] = "" + reiseZeit;
						zeilen[i] += einzelStrings[x] + sDelimiter;
					}
					else if (j == 9) {
						int r = (int) (Math.random() * 10);
						einzelStrings[x] = "" + (r > 6 ? "storniert" : "nicht storniert");
						zeilen[i] += einzelStrings[x] + sDelimiter;
					}
					else if (j == 10) {
						int r = (int) (Math.random() * 5 + 1);
						einzelStrings[x] = "" + r;
						zeilen[i] += einzelStrings[x] + sDelimiter;
					}

					else if (j == 11) {
						einzelStrings[x] = "" + getSaltString() + "@gmail.com";
						zeilen[i] += einzelStrings[x] + sDelimiter;
					}

					else if (j == 12) {
						einzelStrings[x] = "01" + telNrGenerator(i);
						zeilen[i] += einzelStrings[x] + sDelimiter;
					}

					else if (j == 13) {
						einzelStrings[x] = kartenInstitut[(int) (Math.random() * kartenInstitut.length)];
						zeilen[i] += einzelStrings[x] + sDelimiter;
					}

					else if (j == 14) {
						einzelStrings[x] = gebDatumGenerator2();
						zeilen[i] += einzelStrings[x] + sDelimiter;
					}
					else if (j == 15) {
						einzelStrings[x] = "" + (int) (Math.random() * 100000);
						zeilen[i] += einzelStrings[x] + sDelimiter;
					}

				}

			}
			FileChooser fileChooser = new FileChooser();
			FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
			fileChooser.getExtensionFilters().add(extFilter);
			File fileC = fileChooser.showSaveDialog(primaryStage);
			if (fileC != null) {

				Path file = Paths.get(fileC.getAbsolutePath());
				try {
					Files.write(file, Arrays.asList(zeilen), Charset.forName("UTF-8"), StandardOpenOption.CREATE);
				}
				catch (IOException e) {
					e.printStackTrace();
				}

				for (int i = 0; i < zeilen.length; i++) {
					System.out.println(zeilen[i]);
				}
			}
			System.exit(0);
		}

	}

	private String emailGenerator(int indexJ, int index) {
		int countVersuch = 1;
		String wort = emailHilfsmethode(countVersuch, indexJ);
		// if(index != 0)
		// {
		// for (int i = 0; i < index; i++) {
		// if(!emailAnfang[i].equals(wort))
		// {
		// if(i == index - 1)
		// {
		// countWiederholungName = 0;
		// countWiederholungVorname = 0;
		// return emailAnfang[i + 1] = wort;
		// }
		// }
		// else
		// {
		// wort = emailHilfsmethode(countVersuch++, indexJ);
		// i = 0;
		// }
		// }
		// }
		// else
		// {
		return /* emailAnfang[0] = */wort;
		// }
		// return null;
	}

	String rückreisee = "";

	private String reiseChoicerRück() {
		if (rückreisee == "") {
			ZonedDateTime hinflug = null;
			boolean validDate = false;
			while (!validDate)
				try {
					hinflug = ZonedDateTime.of(LocalDateTime.of(LocalDate.of(1950 + (int) (Math.random() * 68), 1 + (int) (Math.random() * 12), 1 + (int) (Math.random() * 31)), LocalTime.now()), ZoneId.of("Z"));
					validDate = true;
				}
				catch (Exception e) {
					System.err.print("Ups, falsches Datum");
				}
			reiseZeit = 1 + (int) (Math.random() * 30);
			// Jahr Monat Tag
			ZonedDateTime rückflug = hinflug.plus(Period.of(0, 0, reiseZeit));
			rückreisee = +rückflug.getYear() + "." + rückflug.getMonth().getValue() + "." + rückflug.getDayOfMonth();
		}
		return rückreisee;
	}

	private String reiseChoicer() {
		ZonedDateTime hinflug = null;
		boolean validDate = false;
		while (!validDate)
			try {
				hinflug = ZonedDateTime.of(LocalDateTime.of(LocalDate.of(1950 + (int) (Math.random() * 68), 1 + (int) (Math.random() * 12), 1 + (int) (Math.random() * 31)), LocalTime.now()), ZoneId.of("Z"));
				validDate = true;
			}
			catch (Exception e) {
				System.err.print("Ups, falsches Datum");
			}
		reiseZeit = 1 + (int) (Math.random() * 30);
		// Jahr Monat Tag
		ZonedDateTime rückflug = hinflug.plus(Period.of(0, 0, reiseZeit));
		rückreisee = +rückflug.getYear() + "." + rückflug.getMonth().getValue() + "." + rückflug.getDayOfMonth();
		return "" + hinflug.getYear() + "." + hinflug.getMonth().getValue() + "." + hinflug.getDayOfMonth();

	}

	private String reisezielCodeChoiser() {
		return arrLandCode[speicherVar];
	}

	private String reisezielChoiser() {
		return arrLand[speicherVar = (int) (Math.random() * countLand)];
	}

	private String emailHilfsmethode(int count, int indexJ) {
		String wort = "";
		if (einzelStrings[indexJ - 6].length() > count) {
			wort = einzelStrings[indexJ - 6].substring(0, count);
		}
		else {
			countWiederholungName++;
			wort = einzelStrings[indexJ - 6].substring(0, count);
			for (int i = 0; i < countWiederholungName; i++) {
				wort = einzelStrings[indexJ - 6].substring(0, 1);
			}
		}
		if (einzelStrings[indexJ - 5].length() > count) {
			wort += einzelStrings[indexJ - 5].substring(0, count);
		}
		else {
			countWiederholungVorname++;
			wort = einzelStrings[indexJ - 5].substring(0, count);
			for (int i = 0; i < countWiederholungVorname; i++) {
				wort = einzelStrings[indexJ - 5].substring(0, 1);
			}
		}
		wort += einzelStrings[indexJ - 4];
		return wort + "@" + emailAnbieter[(int) (Math.random() * emailAnbieter.length)] + "." + emailEndungen[(int) (Math.random() * emailEndungen.length)];
	}

	protected String getSaltString() {
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 10) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr.toLowerCase();

	}

	private String telNrGenerator(int index) {
		return "" + teleNrHilfsmethode2();
	}

	int telecounter = 0;

	private long teleNrHilfsmethode2() {

		StringBuffer tele = new StringBuffer("04000000");
		String gen = String.valueOf(telecounter);
		for (int i = tele.length() - 1; i > tele.length() - 1 - gen.length(); i--) {
			tele.setCharAt(i, gen.charAt((gen.length() - 1 + i) - (tele.length() - 1)));

		}
		telecounter++;
		return Long.valueOf(tele.toString());

	}

	private long telNrHilfsmethode() {
		long telNr = -1;
		int TELNRZAHLENANZAHL = 10;
		for (int i = 0; i < TELNRZAHLENANZAHL; i++) {
			if (telNr == -1) {
				int r = (int) (Math.random() * 10);
				while (r == 0)
					r = (int) (Math.random() * 10);
				telNr = r;
			}
			else {
				int r = (int) (Math.random() * 10);
				telNr *= 10;
				telNr += r;
			}
		}
		return telNr;
	}

	private String ibanGenerator(int index) {
		return ibanHilfsmethode2();
	}

	private String ibanGenerator2(int index) {
		index += 1;
		String tmp = "" + index;
		int laenge = tmp.length();
		String s = "";
		int bis = 8 - laenge;
		while (bis != 0) {
			s += "0";
			bis--;
		}
		s += "" + index;
		return s;
	}

	// Max ca 100 Million Iban Numbers
	int wordcounter;

	private String ibanHilfsmethode2() {
		StringBuffer iban = new StringBuffer("72486601200000000000");
		String gen = String.valueOf(wordcounter);
		for (int i = iban.length() - 1; i > iban.length() - 1 - gen.length(); i--) {
			iban.setCharAt(i, gen.charAt((gen.length() - 1 + i) - (iban.length() - 1)));
		}
		wordcounter++;
		return iban.toString();
	}

	private String ibanHilfsmethode() {
		String iban = "-1";
		int IBANZAHLENANZAHL = 20;
		for (int i = 0; i < IBANZAHLENANZAHL; i++) {
			if (iban.equals("-1")) {
				int r = (int) (Math.random() * 10);
				while (r == 0)
					r = (int) (Math.random() * 10);
				iban = "" + r;
			}
			else {
				int r = (int) (Math.random() * 10);
				iban += "" + r;
			}
		}
		return iban;
	}

	private String gebDatumGenerator() {
		int tag;
		int monat;
		int jahr;
		tag = (int) (Math.random() * 30) + 1;
		monat = (int) (Math.random() * 11) + 1;

		while (monat <= 7 && monat % 2 == 0 && tag > 30 ^ monat > 7 && monat % 2 == 1 && tag > 30)
			tag = (int) (Math.random() * 30) + 1;

		int maxAlter = 99;
		// plus minus 18 Jahre
		int minAlter = 18;
		int abDemJahr = Integer.valueOf(new SimpleDateFormat("yyyy").format(new Date())) - maxAlter;
		int jahrZahl = (int) (Math.random() * maxAlter) + 1;
		jahr = abDemJahr + jahrZahl;
		while ((jahr < (Integer.valueOf(new SimpleDateFormat("yyyy").format(new Date())) - maxAlter)) || (jahr > (Integer.valueOf(new SimpleDateFormat("yyyy").format(new Date())) - minAlter))) {
			jahrZahl = (int) (Math.random() * maxAlter);
			jahr = abDemJahr + jahrZahl;
		}

		// pruefung auf schaltjahr
		if (jahr % 400 == 0 && monat == 2) {
			while (tag > 29)
				tag = (int) (Math.random() * 30) + 1;
		}

		else if (jahr % 100 == 0 && monat == 2) {
			while (tag > 28)
				tag = (int) (Math.random() * 30) + 1;
		}

		else if (jahr % 4 == 0 && monat == 2) {
			while (tag > 29)
				tag = (int) (Math.random() * 30) + 1;
		}

		else
			while (tag > 28)
				tag = (int) (Math.random() * 30) + 1;

		String tagString = "" + tag;
		if (tag / 10 == 0)
			tagString = "0" + tag;

		String monatString = "" + monat;
		if (monat / 10 == 0)
			monatString = "0" + monat;

		return tagString + monatString + jahr;
	}

	private String vornamenChoiser() {
		return arrVornamen[(int) (Math.random() * countVornamen)];
	}

	private String nameChoiser() {
		return arrNamen[(int) (Math.random() * countNamen)];
	}

	private String gebDatumGenerator2() {
		ZonedDateTime hinflug = null;
		boolean validDate = false;
		while (!validDate)
			try {
				hinflug = ZonedDateTime.of(LocalDateTime.of(LocalDate.of(1920 + (int) (Math.random() * 79), 1 + (int) (Math.random() * 12), 1 + (int) (Math.random() * 31)), LocalTime.now()), ZoneId.of("Z"));
				validDate = true;
			}
			catch (Exception e) {
				// System.err.print("Ups, falsches Datum");
			}

		return "" + hinflug.getYear() + "." + hinflug.getMonth().getValue() + "." + hinflug.getDayOfMonth();

	}

	public static void main(String[] args) {

		launch(args);
	}
}
