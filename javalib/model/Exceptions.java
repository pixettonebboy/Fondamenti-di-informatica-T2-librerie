//Fondamenti Di Informatica T-2
//Librerie di Achille Pisani

	
////////////////////////////////////////////////////////////////////////////
//throw new IllegalArgumentException SE I PARAMETRI NON SONO VALIDI

	if (!amore.validaPerSegno(getSegnoZodiacale()) || !lavoro.validaPerSegno(getSegnoZodiacale()) || !salute.validaPerSegno(getSegnoZodiacale()))
			throw new IllegalArgumentException(
				"Errore nella creazione di un oggetto istanza della classe " + OroscopoMensile.class.getSimpleName() 
				+ ": una o piu' delle previsioni passate al costruttore risulta non applicabile per l'indicato segno zodiacale."
			);
			

//CONTROLLARE ARGOMENTI DI UN COSTRUTTORE:

public Previsione(String previsione, int valore, Set<SegnoZodiacale> segni) {
		
		if (previsione == null || previsione.isEmpty())
			throw new IllegalArgumentException("previsione");
		if (valore < 0)
			throw new IllegalArgumentException("valore");
		if (segni == null)
			throw new IllegalArgumentException("segni");

		this.previsione = previsione;
		this.valore = valore;
		this.segni = segni;
	}
/////////////////////////////////////////////////////////////////////

