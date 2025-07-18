//Fondamenti Di Informatica T-2
//Librerie di Achille Pisani

	
//SET ON ACTION:

	button.setOnAction(this::calcolaSeggi);
	
		//OPPURE
		
	carriereCombo.setOnAction(ev-> myHandle(ev));


	private void myHandler(ActionEvent e) {
	
	}


//	l’aggancio alla ListView dell’opportuno listener incapsulato nel metodo ausiliario myHandler
		listView.getSelectionModel().selectedItemProperty().addListener((obj, oldMov, newMov) -> myHandler(newMov));

il metodo MyHandler: Movimento è un tipo che si utilizzava in questo esame, quindi in ingresso a MyHandler ci va un oggetto prelevato da uno degli strumenti di grafica (combo, listView in questo caso ecc ecc..)

private void myHandler(Movimento newMov) {
		......
		......
	}		