//Fondamenti Di Informatica T-2
//Librerie di Achille Pisani

	
//STREAM E SET:

	String segni = stringTokenizer.nextToken().trim().toUpperCase();  //ho una stringa
	String[] segniApplicabiliStr = segni.split(",");                  //creo un array di stringhe con split
	
	List<SegnoZodiacale> szs = Arrays.stream(segniApplicabiliStr).map (s->SegnoZodiacale.valueOf(s)) .toList();  //creo una lista di SZ
		
		//creo uno stream: mappo ogni stringa dell'array nel suo valore enum SZ e aggiungo questo risultato alla lista
	
	Set<SegnoZodiacale> segniApplicabili = new TreeSet<>(szs);        //creo un treeset da una collection (lista)
	
	///GENERICO:  List<T> lista = Arrays .stream(String[] str) .map ( s-> f(s) ) .toList();