//Fondamenti Di Informatica T-2
//Librerie di Achille Pisani

	
per incapsulare un valore: 		Optional.of
� per esprimere il "nessun valore": 	Optional.empty
� per accertare la presenza/assenza: 	isPresent / isEmpty
� per estrarre il valore (se presente): 	get / getOrElse

//RIEMPIRE OPTIONAL

	Optional<Month> meseO = Optional.empty();  //prima lo inizializzo vuoto
	 
	RadioButton rb = (RadioButton) radioGroup.getSelectedToggle();
	String s = rb.getText();
	BillingFrequency statoRB = null;
	if(s.equals("Annuale")) {
		 statoRB = BillingFrequency.ANNUAL;}
		else {statoRB = BillingFrequency.MONTHLY;
		
		meseO = Optional.of(pickerMonth.getValue().getMonth());   //poi lo riempio all'interno dell'if3t
		
//ARRAY DI OPTIONAL

	private OptionalInt[][] board;
	board = new OptionalInt[DIM][DIM];   