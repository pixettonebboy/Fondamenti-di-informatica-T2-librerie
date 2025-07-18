//Fondamenti Di Informatica T-2
//Librerie di Achille Pisani

	
	int n = -1;
	try {
		n = Double.parseDouble(items[]);
		if(n<0) throw new NumberFormatException();
		}
		catch(NumberFormatException e)
		{
			throw new BadFileFormatException("La riga non contiene un numero maggiore o uguale a zero.");
		}
		
//FORMATTER NUMERI:

	NumberFormat fN = NumberFormat.getNumberInstance(Locale.ITALY);
	double val = -1;
	try {
		val = fN.parse(valS).doubleValue();
		if(val<0) throw new ParseException(valS, 0);
		}
		catch(ParseException e)
		{
			throw new BadFileFormatException("La riga non contiene un numero maggiore o uguale a zero.");
		}
		
	fN.parse("123.56").doubleValue();
	
	
//FORMATTER LOCALDATE:

	final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy").withLocale(Locale.ITALY);
	LocalDate localDate = LocalDate.parse(date, formatter);