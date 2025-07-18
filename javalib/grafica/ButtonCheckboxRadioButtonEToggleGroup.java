//Fondamenti Di Informatica T-2
//Librerie di Achille Pisani

	

//cio che vale per button vale anche per checkbox

	button.setOnAction(this::calcolaSeggi);
	
	private void calcolaSeggi(ActionEvent actionEvent) {
		-------
	}
	
	//OPPURE: 
	
	carriereCombo.setOnAction(ev-> myHandle(ev));
	
	
//FONT:
	
	txtMediaPesata.setFont(Font.font("Courier New", FontWeight.BOLD, 11));

	//da indietro la stringa con il nome che abbiamo dato al button
	button.getId()
	//cambia Id del button
	button.setText("...")
	//per abilitare o disabilitare button
	button.setDisable(false)
	button.setDisable(true)



	per dire che il button è stato premuto e quindi deve partite un'azione:
	"Object source = ev.getSource();
	 if (source==inserisci) controller.inserisci(af, t);
	 else if (source==rimuovi) controller.rimuovi(af, t);"
	 dove inserisci e rimuovi sono due button

	
	//TOGGLEGROUP = INSIEME DI PIù RADIOBUTTON
	tg = new ToggleGroup(); //creo toggleGroup
	coinButton.setToggleGroup(tg); //aggiungo i due radioButton al toggleGroup
	currencyButton.setToggleGroup(tg);		
	tg.selectToggle(coinButton); //seleziono un radioButton di default
	coinButton.setOnAction(this::coinButtonHandle);
	currencyButton.setOnAction(this::currencyButtonHandle);

	tg.getSelectedToggle() //da indietro il radioButton selezionato
	if(tg.getSelectedToggle() == button) //se il button premuto è...
	
	con checkbox si puo usare sia:
	Object source = ev.getSource(); -> if(source == checkBox) che 
	checkbox.isSelected():