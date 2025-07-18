//Fondamenti Di Informatica T-2
//Librerie di Achille Pisani

	

//SELEZIONA DEFAULT: 
	combo.getSelectionModel().selectFirst();
		//creo la combobox passandogli gli elementi = una lista di T dati dal controller
	ComboBox<T> combo = new ComboBox<>(FXCollections.observableArrayList(controller.getNomiFermate()));
		//OPPURE: 			
	combo = new ComboBox<>();
	combo.setItems(FXCollections.observableArrayList(controller.getNomiFermate()));

	
	combo.setValue(ShipItem.SEA); //valore iniziale

	afCombo.getSelectionModel().selectFirst(); //primo della lista selezionato di default
	
	cb.setOnAction(event -> txtArea.setText(
				abstractController.generaOroscopoCasuale(cb.getValue()).toString())); 
				
				
//TOOLTIP: 
	carriereCombo.setTooltip(new Tooltip("Scegliere la carriera da visualizzare"));		
	
	
	
//HINT (es. "Seleziona il tipo") 

	combotipi.setPromptText("Scegli il tipo");
	
	
	
//ACTIONEVENT: 

	carriereCombo.setOnAction(ev-> myHandle(ev));		
	combo.setOnAction(ev -> grid.updateGridStatus());

NOTA: SE VIENE CHIESTO DI VERIFICARE CHE SIA STATO SCELTO UN OGGETTO DALLA COMBO, FARE IF(COMBO.GETVALUE() == NULL)....
	
	
	
//AGGIUNGERE UN ELEMENTO ALLA LISTA E IMPOSTARLO COME DEFAULT 

	comboIscritti = new ComboBox<>();
	ObservableList<String> lista = this.controller.getNomiIscritti();
	lista.add("NON ISCRITTO");
	comboIscritti.setItems(lista);
	comboIscritti.setValue(lista.get(lista.size()-1));
	
	