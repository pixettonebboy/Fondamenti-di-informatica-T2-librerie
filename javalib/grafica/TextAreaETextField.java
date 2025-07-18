//Fondamenti Di Informatica T-2
//Librerie di Achille Pisani

	

//TEXTAREA:
	electionTable = new TextArea();
		electionTable.setEditable(false);
		electionTable.setPrefWidth(500);
		electionTable.setFont(Font.font("Courier New", FontWeight.BOLD, 12));
		electionTable.setText("");
		
	percentageTable = new TextArea();
		percentageTable.setEditable(false);
		percentageTable.setPrefWidth(500);
		//SCELTA DEL FONT
		percentageTable.setFont(Font.font("Courier New", FontWeight.BOLD, 12));
		percentageTable.setText("");
	
	txtArea.clear();
	txtArea.setStyle("-fx-background-color: lightcoral;");	
	
	//STREAM DA SORTEDSET
	SortedSet<Percorso> percorsi = controller.cercaPercorsi(da, a, maxDurata);
	if(percorsi.isEmpty()) {
			output.appendText("Nessun percorso trovato"); 
		} else { 
			percorsi.stream().forEach(p -> output.appendText(p.toString() + System.lineSeparator()));
		}
	
		
//TEXTFIELD: 		

	txtMediaPesata.setEditable(false);
	txtMediaPesata.setFont(Font.font("Courier New", FontWeight.BOLD, 11));
	txtMediaPesata.setAlignment(Pos.BASELINE_RIGHT);	//!!!!!!!	
		
		
//TEXTFIELD PARTICOLARI:	
	CurrencyTextField reddito = new CurrencyTextField();
	redditoValore = formatter.parse(reddito.getText()).doubleValue();