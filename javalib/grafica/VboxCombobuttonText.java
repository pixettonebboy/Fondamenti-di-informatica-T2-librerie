//Fondamenti Di Informatica T-2
//Librerie di Achille Pisani

	
//Layout con diversi elementi uno sopra all'altro (in verticale) -> Vbox
//Sequenza (dall'alto): label + combo + label + text area + button

public class MainPane extends VBox {		//extends il tipo di pannello scelto
		
	public MainPane(AbstractController abstractController, int gradoFortunaMin) {
		
		
	//DEFINIZIONE DELLA STRUTTURA: creo i diversi componenti e li riempio
		
		//ComboBox e label:
		
		ComboBox<SegnoZodiacale> cb = new 
			ComboBox<>(FXCollections.observableArrayList(abstractController.getSegni()));
			//creo la combobox passandogli gli elementi = una lista di SZ dati dal controller
			
		getChildren().addAll(  //aggiungo alla Vbox le due label e la comboBox
				new Label("Segno zodiacale:"),
				cb,
				new Label("Oroscopo mensile del segno:")
				);
		
		//Text area:
		TextArea txtArea = new TextArea();  //textField = su una riga, textArea = su pi� righe
		txtArea.setEditable(false);   // area di testo non modificabile dall'utente
		getChildren().add(txtArea);   //aggiungo alla vbox anche la text area
		
		//Button:
		
		Button b = new Button("Stampa annuale:");
		getChildren().add(b);  //aggiungo alla vbox anche il button
		
		
	//DEFINIZIONE DEGLI ASCOLTATORI: come i diversi componenti rispondono agli eventi
		
		cb.setOnAction(event -> txtArea.setText(
				abstractController.generaOroscopoCasuale(cb.getValue()).toString())); 
		//quando cambio la cb, genero il nuovo oroscopo mensile con il SZ della comboBox, lo trasformo in stringa e setto la textArea su quella stringa)
		
		b.setOnAction(event -> {
			Oroscopo[] oroscopoAnnuale = abstractController.generaOroscopoAnnuale(cb.getValue(), gradoFortunaMin);
			StringBuilder sb = new StringBuilder(cb.getValue().toString().toUpperCase());  //inizio = nome segno
			sb.append("\n-------\n");  //sepaaratore come da esempio nel file
			for (int i =0; i<12; i++) {
				sb.append(Month.of(i+1).toString().toUpperCase());      //mese in maiuscolo
				sb.append("\nAmore:	 ").append(oroscopoAnnuale[i].getPrevisioneAmore());   //amore
				sb.append("\nLavoro: ").append(oroscopoAnnuale[i].getPrevisioneLavoro());  //lavoro
				sb.append("\nSalute: ").append(oroscopoAnnuale[i].getPrevisioneSalute());  //salute
				sb.append(System.lineSeparator());
			}
			System.out.println(sb.toString()); 
			}); 
		//quando spingio il button, genero l'oroscopo annuale, con il layout desiderato
	
		
	//DEFINIZIONE DI POSIZIONI ED ESTETICA
		
		setPadding(new Insets(10, 5, 5, 5));
		VBox.setMargin(cb, new Insets(4, 0, 10, 0));
		VBox.setMargin(txtArea, new Insets(4, 0, 0, 0));
		VBox.setMargin(b, new Insets(20, 0, 0, 0));
		cb.getSelectionModel().selectFirst(); /* Setting placeholder */
		cb.fireEvent(new ActionEvent()); /* Simulating a mouse click */
	}
	

}

/////////////////////////////////////////////////////////////
//esempio di testo stampato (stampa annuale):

	GEMELLI
	-------
	GENNAIO
	Amore:	divertimento nello stare insieme
	Lavoro:	non sopravvalutate chi vi e' intorno
	Salute:	non affaticate la cistifellea
	
/////////////////////////////////////////////////////////////