//Fondamenti Di Informatica T-2
//Librerie di Achille Pisani

	
//ARRAY:

	il linguaggio consente da sempre di definire array di uno specifico tipo:
	
	� dai tipi primitivi� 		int[] v = new int[4];		(non � neppure necessario ricorrere ai tipi-wrapper)
	
	� �ai tipi-riferimento: 	Frazione[] w = new Frazione[7];
	
	int[] response = new int[DIM];
	
	
//ITERARE ARRAY DI ENUM:

	SegnoZodiacale[] sz = SegnoZodiacale.values();
		SegnoZodiacale segno = null;
		for(int i=0; i<SegnoZodiacale.values().length; i++) {
			if(sz[i].contains(dataNascita)) segno = sz[i];
		}	
	
//MATRICE:
	
	board = new OptionalInt[DIM][DIM];
	int[] numValues = new int[DIM];
	
	board[row][col] = OptionalInt.of(numValues[col]);	
	
///////////////////////////////////////////////////////////////////////////////

//CICLO DO WHILE:

	do { previsione = previsioni.get(r.nextInt(0, previsioni.size() - 1)); } 
	while (!previsione.validaPerSegno(segno));
	
//SWITCH:

	//tipi primiti:		switch(Integer.valueOf(this.anni))
	
	switch(bill.getBillingFrequency()) {
			case ANNUAL:  computeAnnualCost(bill); break;
			case MONTHLY: computeMonthlyCost(bill); break;
		}

///////////////////////////////////////////////////////////////////////////////

//CLASSI WRAPPER

	Object -> Number (astratta), Boolean, Character
	Number -> Byte, Short, Integer, Long, Float, Double 
	
	Integer i = Integer.valueOf(22);
	Double d = Double.valueOf(3.14);