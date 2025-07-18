//Fondamenti Di Informatica T-2
//Librerie di Achille Pisani

	
////////////////////////////////////////////////////////////////////////////////////
//DIVERSI FORMATTER:
NumberFormat fN = NumberFormat.getNumberInstance(Locale.ITALY);   //NUMERI
NumberFormat fP = NumberFormat.getPercentInstance(Locale.ITALY);  //PERCENTUALI
NumberFormat fV = NumberFormat.getCurrencyInstance(Locale.ITALY)  //VALUTE
DecimalFormat formatter = new DecimalFormat("� #,##0.##"); //formattatore personalizzato per poter scrivere "� 2.973,88" (da verificare)


//ESEMPI CON LOCALE:
	
	NumberFormat fN = NumberFormat.getNumberInstance(Locale.ITALY);
	//mi trasforma il numero in double quando � scritto nel Locale italiano (11.453,09) -> (11453.09)
	//!!!!!!!!!!!ATTENZIONE!! SE IL NUMERO � NEGATIVO,TOGLIERE LO SPAZIO SE C'� TRA IL MENO E IL NUMERO!!!!!!!!!!!!!!!!!!!
	
	NumberFormat fN = NumberFormat.getNumberInstance(Locale.CANADA_FRENCH);
	
	
//SHORT,MEDIUM...
	
	DateTimeFormatter formatterShort = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
	� SHORT 	gg/MM/aa 				18/03/15
	� MEDIUM 	gg siglamese aaaa 		18 mar 2015
	� LONG 		gg mese aaaa 			18 marzo 2015
	� FULL 		giorno gg mese aaaa 	mercoled� 18 marzo 2015
	
	//il mese quando si fa il parse deve essere in minuscolo se espresso in lettere


	DateTimeFormatter formatterShort = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
	� SHORT 	hh:mm 		18:37
	� MEDIUM 	hh:mm:ss 	18:37:24
	� LONG e FULL NON sono supportati: se usati, causano errore
	
	LocalDate d = LocalDate.now();
	String data = d.format(formatterShort));

////////////////////////////////////////////////////////////////////////////////////

//DA Number n (double,int,float) A STRINGA FROMATTATA: 		fN.format(n)

//DA STRING A VALORE DELLA CLASSE Number:	 	fV.parse("$123.56")	
		//estraibile come double, float,int: 	fV.parse("$123.56").doubleValue()

////////////////////////////////////////////////////////////////////////////////////

PARSE CORRETTO: 	ParsePosition position = new ParsePosition(0);
					Number n = f.parse("10-10", position);
			//!!!	if (position.getIndex() != str.length()) { } //se non � arrivato fino in fondo...

////////////////////////////////////////////////////////////////////////////////////

//DA STRING A LOCALDATE:

	final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy").withLocale(Locale.ITALY);
	LocalDate localDate = LocalDate.parse(date, formatter);

1. Caratteri di formattazione per il giorno: 
- "d": rappresenta il giorno del mese con un solo o due cifre (1-31). (legge sia il giorno espresso come 1 che 01)
- "dd": rappresenta il giorno del mese con due cifre (01-31).
- "D": rappresenta il giorno dell'anno con uno o due cifre (1-365).
- "DD": rappresenta il giorno dell'anno con due cifre (01-365).
- "E": rappresenta il giorno della settimana in formato breve (ad esempio "Mon", "Tue", ecc.).
- "EEEE": rappresenta il giorno della settimana in formato completo (ad esempio "Monday", "Tuesday", ecc.). (attenzione in italiano bisogna scrivere il giorno della settimana tutto in minuscolo)

2. Caratteri di formattazione per il mese: 
- "M": rappresenta il mese dell'anno con uno o due cifre (1-12).
- "MM": rappresenta il mese dell'anno con due cifre (01-12).
- "MMM": rappresenta il mese dell'anno in formato breve (ad esempio "Jan", "Feb", ecc.).
- "MMMM": rappresenta il mese dell'anno in formato completo (ad esempio "January", "February", ecc.).

3. Caratteri di formattazione per l'anno: 
- "yy": rappresenta l'anno con due cifre (ad esempio "21" per il 2021).
- "yyyy": rappresenta l'anno con quattro cifre (ad esempio "2021").

4. Caratteri di formattazione per l'ora: 
- "H": rappresenta l'ora del giorno in formato 24 ore con uno o due cifre (0-23).
- "HH": rappresenta l'ora del giorno in formato 24 ore con due cifre (00-23).
- "h": rappresenta l'ora del giorno in formato 12 ore con uno o due cifre (1-12).
- "hh": rappresenta l'ora del giorno in formato 12 ore con due cifre (01-12).
- "a": rappresenta l'indicatore AM / PM (ad esempio "AM" o "PM").

5. Caratteri di formattazione per i minuti e i secondi: 
- "m": rappresenta i minuti con uno o due cifre (0-59).
- "mm": rappresenta i minuti con due cifre (00-59).
- "s": rappresenta i secondi con uno o due cifre (0-59).
- "ss": rappresenta i secondi con due cifre (00-59).

Spero che queste informazioni ti siano utili per formattare correttamente le date in Java.
		

//DA STRING (F: ITA) A ENUM:

	//Come risalire alla costante enumerativa mese partendo dal nome del mese stesso:
    	//(ad esempio, come ottenere Month.MAY partendo da "May")  
	//Se il nome del mese � in INGLESE, basta: 		Month.valueOf 	; ALTRIMENTI:

	//Per Enum da NOME COMPLETO DEL MESE (IN ITALIANO):

		public static int getMonth(String s, Locale l){    //Enum da stringa (mese) e locale (Italia)
	
			DateTimeFormatter f = DateTimeFormatter.ofPattern("MMMM", l);  /formattatore con nome intero (MMMM)
			java.time.temporal.TemporalAccessor t = f.parse(s.toLowerCase());   //lo riconosce solo in minuscolo
			return  t .get( java.time.temporal.ChronoField .MONTH_OF_YEAR );  
			}
			
////////////////////////////////////////////////////////////////////////////////////

//DA ENUM A STRING(F: ITA)

	Month month; 		//enum
	DateTimeFormatter f = DateTimeFormatter.ofPattern("MMMM", Locale.ITALY);  	//creo il formatter: MMMM per nome completo
		return f.format(month);

////////////////////////////////////////////////////////////////////////////////////

//NUMERO CIFRE DECIMALI:

	NumberFormat numbF = NumberFormat.getNumberInstance();
	numbF.setMaximumFractionDigits(2);
	double numConCifreDec = numbF.format(diff);
	
	
		