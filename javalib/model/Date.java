//Fondamenti Di Informatica T-2
//Librerie di Achille Pisani

	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	//RELATIVI: � LocalDate: una data relativa (giorno/mese/anno)	2017-12-03
				� LocalTime: un orario relativo (ore/minuti/secondi)	10:15:30
				� LocalDateTime: una data + orario relativi		2017-12-03T10:15:30
				� Period: una durata relativa
				
	//ASSOLUTI: � Instant: un punto sulla linea del tempo espresso in nanosecondi
				� Duration: una durata in (nano)secondi fra due istanti di tempo
				� OffsetDateTime: una data assoluta sulla linea del tempo 
					espressa come data + orario + delta rispetto a Greenwich (UTC)	2017-12-03T10:15:30+01:00
				� ZonedDateTime: una data assoluta sulla linea del tempo 
					espressa come data + orario + fuso orario	2017-12-03T10:15:30+01:00 Europe/Rome

///////////////////////////////////////////////////////////////////////////////////////////////////////////////

//ENUM:	    	.getValue(); .of(int) 
	DayOfWeek 
	Month


//GETVALUE
	
	Month.OCTOBER.getValue()    = 10
	DayOfWeek.MONDAY.getValue()   = 1
	
	
//FACTORY (.of)
	
	LocalDate xmas = LocalDate.of(2020, 12, 25);
					   = LocalDate.of(2020, Month.DECEMBER, 25);
					   
	Month m = Month.of(10); 	    //ottobre: vanno da 1 a 12!!!
	DayOfWeek d = DayOfWeek.of(1); 		//luned�: vanno da 1 a 7
	Period p1 = Period.ofMonths(2);
	
	LocalTime noon = LocalTime.of(12, 0);
	LocalTime now = LocalTime.now();
	LocalDateTime xmasnoon = LocalDateTime.of(xmas,noon);
	LocalDateTime inizio =	LocalDateTime.of( 2021, 2, 17, 9, 0);
	
	OffsetDateTime offsInizio = OffsetDateTime.of(inizio, ZoneOffset.ofHours(1));
	ZonedDateTime zInizio = ZonedDateTime.of( inizio, ZoneId.of("CET"));
	ZonedDateTime departure = ZonedDateTime.of (2017, Month.OCTOBER.getValue(), 7, 20, 30, 10, 0, ZoneId.of("CET"));
	OffsetDateTime departure = OffsetDateTime.of(2017, 10, 7, 20, 30, 10, 0, ZoneOffset.ofHours(1));
	
		
//ACCESSOR + CONFRONTO:

	//DA LocalDate: il giorno del mese	(getDayOfMonth)
					il mese				(getMonth)
					l'anno				(getYear)
	//DA LocalTime: l'ora				(getHour)
					i minuti		(getMinute)
					i secondi		(getSecond)
					i nanosecondi	(getNano)
	//DA Period: 	il numero di giorni 	(getDays)
					il numero di mesi	 	(getMonths)
					il numero di anni		(getYears)
	//ALTRO:  il giorno dell�anno				(getDayOfYear)
			  il giorno della settimana 		(getDayOfWeek)
			  
			  verificare se � un anno bisestile	(isLeapYear)
			  
			  confronto tra istanze dello stesso tipo 	(isBefore, isAfter, isEqual)
	
	
//ARITMETICA:
	
	//PLUS:		.plusDays, 	plusMonths,	 plusWeeks,  plusYears,  plusHours,  plusMinutes
	//MINUS: 	.minusDays, minusMonths, minusWeeks, minusYears, minusHours, minusMinutes
	//WITH: 	.withDayOfMonth, withDayOfYear, withMonth, withYear, withHours, withMinutes, withSeconds   (per sostituire/cambiare)
	 
	 
//PERIOD, INSTANT, DURATION:
	
	Period p = Period.ofMonths(2);
	Period p = Period.between(xmas2016, xmas2017);
	LocalDate d1 = (LocalDate)	p .addTo(xmas2017);
	LocalDate d2 = (LocalDate)	p .subtractFrom(xmas2017);
	
	Instant adesso = Instant.now();
	
	Duration d = Duration.between(i1,i2);		(.of, .plus, .minus,...)
	//metodi per estrarre il numero totale di	� giorni 		toDays
												� ore 			toHours
												� minuti 		toMinutes
												� millisecondi 	toMillis

//CONVERTIRE

	� una data & orario assoluta in Instant 	toInstant
	� un OffsetDateTime in ZonedDateTime 		toZonedDateTime
	� un ZonedDateTime in OffsetDateTime 		toOffsetDateTime
	� un ZonedDateTime in LocalDateTime 		toLocalDateTime

	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////

//STRING TO DATE:

	java.util.Date = java.text.DateFormat.getDateInstance().parse(date String);
	
		//oppure
		
	SimpleDateFormat format = new SimpleDateFormat( "dd.MM.yyyy" );
	Date date = format.parse( myString );
	
	//DateTimeFormatter f = DateTimeFormatter.ofPattern("MMMM", Locale.ITALY);  	//MMMM per nome completo


///////////////////////////////////////////////////////////////////////////////////////////////////////////////

//INTERA SETTIMANA PARTENDO DA GIORNO COMPRESO AL SUO INTERNO:

	public List<Workout> getWeekWorkouts(LocalDate date) {
		List<Workout> response = new ArrayList<>();
		for(int i=0; i<workouts.size(); i++) {
			Workout wo = workouts.get(i);
		//ITERO LA SETTIMANA: 7 GG A PARTIRE DAL PRIMO GIORNO DELLA SETTIMANA
			for(int j=0; j<7; j++) {
				System.out.println(wo.getDate().toString() + " " + getFirstDayOfWeek(date.plusDays(j)));
				System.out.println(getFirstDayOfWeek(date.plusDays(j)));
				if(wo.getDate().equals(getFirstDayOfWeek(date).plusDays(j))) {
					response.add(wo);
				}
			}
		}
		return response;
	}
	
	//PRIMO GIORNO DELLA SETTIMANA A PARTIRE DA GIORNO QUALUNQUE:
		private LocalDate getFirstDayOfWeek(LocalDate date) {		//data qualunque
			int dayOW = date.getDayOfWeek().getValue();				//che giorno della settimana �
			return date.minusDays(dayOW);							//sottraggo il num e arrivo a lunedi
		}

	