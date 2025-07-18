//Fondamenti Di Informatica T-2
//Librerie di Achille Pisani

	

	slider.valueProperty().addListener( (changed, oldval, newval) -> 
		txt1.setText("Valore corrente: " + formatter.format(newval)
		+ " (era: " + formatter.format(oldval) + ")");
		
		

Inizializzazione di uno slider, copiare tutto che in mezzo ci sono commenti


	Slider slider = new Slider(0, 10, 0);
		/**
		 * Il primo parametro 0 rappresenta il valore minimo del Slider.
		 * In questo caso, il valore minimo è impostato a 0.
		 * Il secondo parametro 10 rappresenta il valore massimo del
		 * Slider. In questo caso, il valore massimo è impostato a 10.
		 * Il terzo parametro 0 rappresenta il valore iniziale del Slider.
		 * In questo caso, il valore iniziale è impostato a 0.
		 */
		sbarramento.setPrefWidth(300); //larghezza di 300 pixel
		sbarramento.setShowTickMarks(true);
		sbarramento.setShowTickLabels(true);
		sbarramento.setMajorTickUnit(1);
		sbarramento.setSnapToTicks(true);
		sbarramento.setBlockIncrement(0.5);
		/**
		 * setShowTickMarks(true): mostra le marche dei tick sul Slider.
		 * setShowTickLabels(true): mostra le etichette dei tick sul Slider.
		 * setMajorTickUnit(1): imposta l'unità di incremento principale dello
		 * Slider su 1, ovvero ogni tick rappresenta un incremento di 1!!
		 * setSnapToTicks(true): imposta il Slider in modo da scorrere solo sui tick.
		 * setBlockIncrement(0.5): imposta l'incremento dei blocchi del Slider
		 * su 0.5, ovvero quando l'utente trascina il cursore del Slider, il valore 
		 * aumenta o diminuisce di 0.5.
		 */