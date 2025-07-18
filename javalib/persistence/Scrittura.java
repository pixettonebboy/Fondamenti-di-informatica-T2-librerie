//Fondamenti Di Informatica T-2
//Librerie di Achille Pisani

	
//ALERT

	try {
			Writer fw = new FileWriter("StockGiornaliero.txt");
			stockWriter.printStock(fw, ice);
		} catch (IOException e) {
		
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Attenzione");
			alert.setHeaderText("Impossibile aprire file \"StockGiornaliero.txt\"");
			alert.setContentText("");
			alert.showAndWait();
			
		}


//FUNZIONE CHE ESEGUE LA SCRITTURA SU FILE
private void myHandle(ActionEvent e) {
		try (PrintWriter pw = new PrintWriter("OroscopoAnnuale.txt")) {
			//apro un try and catch dichiarando che voglio scrivere sul txt OroscopoAnnuale
			int fortuna = 0;

			if (segniZodiacali.getValue() == null) {
				output.setText("nessun segno selezionato");
				return;
			}

			SegnoZodiacale segnoSelezionato = segniZodiacali.getValue();
			//scrivo la prima riga con il nome del segno selezionato
			pw.println(segnoSelezionato);
			for (int i = 0; i < segnoSelezionato.toString().length(); i++)
				pw.print("-");
			//metto tanti "-" quante sono le lettere della parola 
			pw.println();

			Oroscopo[] annuale = controller.generaOroscopoAnnuale(segnoSelezionato, fortunaMin);

			for (int i = 0; i < Mese.values().length; i++) {
				pw.println(Mese.values()[i]);
				//scrivo il nome del mese
				pw.println(annuale[i]);
				//scrivo l'oroscopo
				fortuna += annuale[i].getFortuna();
			}

			pw.println("GRADO DI FORTUNA:\t" + fortuna / 12);
			//scrivo il grado di fortuna nell'ultima riga

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

	}





//SCRITTURA SU FILE

private String outputFileName;
	
	public MySeggiWriter(String nomeFile) {
		outputFileName = nomeFile;
	}

	@Override
	public void stampaSeggi(Elezioni elezioni, String msg) throws IOException {
		
		PrintWriter pw = new PrintWriter(outputFileName);
		
		DateTimeFormatter f = DateTimeFormatter.ofLocalizedDateTime(
								FormatStyle.FULL,FormatStyle.MEDIUM);
				
		pw.println(LocalDateTime.now().format(f)); 	//stampo data e ora locali
				
		pw.println(msg);  		//stampo il messaggio ricevuto in ingresso
		pw.println(elezioni);  	//stampo le elezioni
		
		pw.close();  		//chiudo il file !!!!!!!
		
	}
	
/////////////////////////////////////////////////////////////////////////

	public class MyGameSaver implements GameSaver {
	
		private PrintWriter pw; 
	
		public MyGameSaver(PrintWriter pw) {
			this.pw=pw;
		}

		@Override
		public void print(Game game) {
			pw.println(game);
			pw.flush();
		}

		@Override
		public void close() {
			pw.close();
		}	
	
	}
	
/////////////////////////////////////////////////////////////////////////
	
	public class MyReportWriter implements ReportWriter {

	private static final int DAYSOFWEEK = DayOfWeek.values().length;

	private DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).withLocale(Locale.ITALY);

	public void printReport(Writer writer, LocalDate date, FitnessDiary diary) {
		PrintWriter pw = new PrintWriter(writer);
		
		int totMinSett = diary.getWeekWorkoutMinutes(date);
		int totCalSett = diary.getWeekWorkoutCalories(date);
		pw.println("Totali settimana del " + date.format(formatter));
		pw.println("minuti totali allenamento " + totMinSett + ", calorie totali bruciate " + totCalSett);
		pw.println("minuti medi di allenamento " + totMinSett / DAYSOFWEEK + ", calorie medie bruciate " + totCalSett / DAYSOFWEEK + " ");

	}

}