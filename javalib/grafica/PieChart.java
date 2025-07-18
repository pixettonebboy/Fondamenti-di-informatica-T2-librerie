//Fondamenti Di Informatica T-2
//Librerie di Achille Pisani

	

	//inizializzo i dati
	ObservableList<PieChart.Data> dati = FXCollections.observableArrayList(
	
		new PieChart.Data("Mele", 30),
		new PieChart.Data("Pere", 15),
		new PieChart.Data("Arance", 50)
		);
	//inizializzo il grafico con i dati appena definiti
	PieChart chart = new PieChart(dati);




//se ho gia un PIE CHART e voglio aggiornarlo con nuovi valori:
	chart.setData(FXCollections.observableArrayList(
			new PieChart.Data("Accrediti", controller.getTotale(dataCorrente, Tipologia.ACCREDITO)),
			new PieChart.Data("Addebiti", controller.getTotale(dataCorrente, Tipologia.ADDEBITO))
		));
	
	rightPane.getChildren().remove(chart);
	chart = new PieChart(dati);
	chart.setLabelsVisible(false);
	chart.setTitle("Distribuizione seggi");
	chart.setPrefWidth(60);
	rightPane.getChildren().add(chart);


/////SETTARE I DATI DI UN CHART CON UN CICLO
Set<Partito> partiti = elezioni.getPartiti();
		ObservableList<PieChart.Data> dati =FXCollections.observableArrayList();
		for(Partito partito : partiti) {
			dati.add(new PieChart.Data(partito.getNome(),elezioni.getRisultato().getSeggi(partito)));
		}

//AGGIORNAMENTO DEI DATI DI UN PIE CHART (SET DATA)
chart.setData(FXCollections.observableArrayList(
				new PieChart.Data("Accrediti", accrediti),
				new PieChart.Data("Addebiti", -addebiti)
			));



//in questo esempio si sta aggiornando un chart, quindi questi passaggi da seguire sono obbligatori nel caso si voglia aggiornare il chart
		rightPane.getChildren().remove(chart); //rimuovo quello vecchio
		chart = new PieChart(dati);	       //ne creo uno nuovo con i dati aggiornati
		chart.setLabelsVisible(false);	       //disabilita la visibilità delle etichetta ma non è importante
		chart.setTitle("Distribuizione seggi");//set del titolo
		chart.setPrefWidth(60);		       //selezione della dimensione(IMPORTANTE), si rischia se no di avere un grafico troppo grande rispetto alla finestra grafica
		rightPane.getChildren().add(chart);    //AGGIUNGERE IL CHART ALLA HBOX O VBOX, PASSAGGIO PIù IMPORTNATE!!