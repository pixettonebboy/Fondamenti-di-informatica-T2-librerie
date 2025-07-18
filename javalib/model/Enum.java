//Fondamenti Di Informatica T-2
//Librerie di Achille Pisani

	
//Creare un enumerativo:

public enum SegnoZodiacale {
	
	ARIETE, TORO, GEMELLI, CANCRO, LEONE, VERGINE, BILANCIA, SCORPIONE, SAGITTARIO, CAPRICORNO, ACQUARIO, PESCI;
	
}
////////////////////////////////////////////////////////////

//da costante dell'enum a String:   String nomeSegnoZodiacale = segnoZodiacale.toString();

//da String a costante dell'enum:   SegnoZodiacale segnoZodiacale = SegnoZodiacale.valueOf(nomeSegnoZodiacale);


////////////////////////////////////////////////////////////

//ITERARE ENUM (ARRAY):
	
	SegnoZodiacale[] sz = SegnoZodiacale.values();
		SegnoZodiacale segno = null;
		for(int i=0; i<SegnoZodiacale.values().length; i++) {
			if(sz[i].contains(dataNascita)) segno = sz[i];
		}	


////////////////////////////////////////////////////////////

//SEGNOZODIACALE: APPLICABILE A LOCALDATE

	public boolean contains(LocalDate date) {
		LocalDate dataIniziale = this.getDataIniziale().withYear(date.getYear());
		LocalDate dataFinale   = this.getDataFinale().withYear(date.getYear());
		// Capricorno � a cavallo del 31 dicembre, va trattato a parte
		if (this!=CAPRICORNO) {
			return  (dataIniziale.isBefore(date) || dataIniziale.isEqual(date)) 
					&& (dataFinale.isAfter(date) || dataFinale.isEqual(date));
		} else {
			LocalDate fineAnno = LocalDate.of(date.getYear(), 12, 31);
			LocalDate capodanno = LocalDate.of(date.getYear(), 1, 1);
			//System.out.println("data " + date); 
			//System.out.println("iniziale " + dataIniziale +", finale " + dataFinale +", fine anno " + fineAnno + ", capodanno " + capodanno);
			return  (dataIniziale.isBefore(date) || dataIniziale.isEqual(date)) && (fineAnno.isAfter(date) || fineAnno.isEqual(date))
					||
					(capodanno.isBefore(date) || capodanno.isEqual(date)) && (dataFinale.isAfter(date) || dataFinale.isEqual(date));
		}
	}

////////////////////////////////////////////////////////////

//ENUM COMPLESSI:

/* L�enumerativo ShipItem (fornito) definisce gli otto tipi possibili di elementi, di cui 6 elementi di nave pi� il
 * mare e il caso della casella vuota. Ognuno � caratterizzato da varie propriet�, in particolare
 * la stringa (singolo carattere) corrispondente, recuperabile tramite il metodo getValue
 * l�immagine associata, recuperabile tramite il metodo getImage
 * la descrizione testuale corrispondente, restituita da toString
 * Anche in questo caso una coppia di metodi factory of consente di ottenere l�enumerativo �giusto� a
 * partire dal carattere dato (uno degli otto possibili).
*/
	
	public enum ShipItem {
		LEFT("<", "sinistra.jpg", "Elemento SINISTRO"), RIGHT(">", "destra.jpg", "Elemento DESTRO"), 
		UP("^", "su.jpg", "Elemento SUPERIORE"), DOWN("v", "giu.jpg", "Elemento INFERIORE"), 
		CENTRE("x", "centro.jpg", "Elemento CENTRALE"), SINGLE("o", "singolo.jpg", "Elemento SINGOLO"),
		SEA("~", "mare.jpg", "MARE"), EMPTY("#", "vuoto.jpg", "Elemento VUOTO");
	
	ShipItem(String ch, String imageFileName, String descrizione) {
		if(ch.length()!=1) throw new IllegalArgumentException("Unexpected string length: " + ch);
		this.value=ch;
		this.descrizione=descrizione;
		try {
			// OPPURE: new Image(new FileInputStream("src/battleship/model/sinistra.jpg"));
			this.image=Optional.of(new Image(ShipItem.class.getResource(imageFileName).toString()));
		} catch (/* NullPointerException | IllegalArgumentException |*/ RuntimeException e) {
			// The real exceptions to be caught should be the above one, but
			// JUnit does fire RuntimeException during testing, due to JavaFX not yet initialised
			// So we catch RuntimeException, which is a superclass of the two others.  
			this.image=Optional.empty();
		} 
	}
	
	public String getValue() {
		return value;
	}

	public Optional<Image> getImage() {
		return image;
	}

	private String value, descrizione;
	private Optional<Image> image;
	
	public static ShipItem of(char ch) {
		// System.out.println("CHECK: |" + ch + "|");
		return switch(ch) {
			case '<' -> LEFT;
			case '>' -> RIGHT;
			case '^' -> UP;
			case 'v' -> DOWN;
			case 'x' -> CENTRE;
			case 'o' -> SINGLE;
			case '~' -> SEA;
			case '#' -> EMPTY;
			default -> throw new IllegalArgumentException("Unexpected value: " + ch);
		};
	}
	
	public static ShipItem of(String ch) {
		if (ch.length()!=1) throw new IllegalArgumentException("Unexpected value: " + ch);
		return of(ch.charAt(0));
	}
	
	@Override
	public String toString() {
		return descrizione;
	}