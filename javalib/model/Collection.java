//Fondamenti Di Informatica T-2
//Librerie di Achille Pisani

	
//IMPLEMENTARE UN'INTERFACCIA COLLECTION

	Set<T> segniApplicabili = new TreeSet<>();   //creare un TreeSet vuoto
	Set<T> segniApplicabili = new TreeSet<>(List<T> lista);  //creare un TreeSet da una Collection

//COLLECTION ORDINATE E NON:

	Ordinate:	TreeMap e TreeSet (da sotto-interfacce SortedMap e SortedSet)
	Non ordinate: 	HashMap e HashSet
	Ordine precidibile di iterazione:	LinkedHashMap e LinkedHashSet
	Se K/V enumerativi:		EnumMap e EnumSet

	Implementazioni fondamentali (modificabili):
	- per Set: HashSet, TreeSet, LinkedHashSet, EnumSet
	- per List: ArrayList, LinkedList
	- per Map: HashMap, TreeMap, LinkedHashMap, EnumMap
	
	
//ITERARE SET:

	Set<String> keys = m.keySet();
	for (String key: keys) {
		
	}


//ITERARE MAPPA:

	private Map<String, Flat> flats;
	for (String flat : flats.keySet()) { 
		flats.get(flat);
	}
	
	////
	
	for (Intervista iv : listaInterviste){
		String key = iv.getNome();
			List<Intervista> value = mappa.get(key);
			if (value == null) {
				value = new ArrayList<>();
				mappa.put(key, value);
			}
			value.add(iv);
			totaleIntervistati++;
		}
		
		
//ITERARE MAPPA DA SUPERCLASSE: usare getIscritti()

	//nella superclasse:	private Map<String,Persona> iscritti;
							[...costruttore...] this.iscritti = iscritti;
							protected Collection<Persona> getIscritti() {return iscritti.values();}
	//nella sottoclasse:    [...costruttore...] super() [non aggiungo altro]
							[NON METTO NESSUN private]
							all'interno del metodo in cui mi serve uso il getter:
		for (Persona iscritto : getIscritti()) { 
				if(iscritto.getSesso().equals(pPref.getSesso())) 
					response.add(calcolaCorrispondenza(iscritto, pPref, pName));		
			}
		
		
//ITERARE LISTA:

	for(int i=0; i<listaEsami.size(); i++) {
			Esame esameLista = listaEsami.get(i);
	}
	
	
//ORDINARE UNA COLLECTION

	for (Partito p : elezioni.getPartiti()) {
			for (int i=1; i<=seggiDaAssegnare; i++) {
				long votiPartito = elezioni.getVoti(p);
				Quoziente q = new Quoziente(p, (long) Math.floor(votiPartito/i));
				quozienti.add(q);
			}
		}  	    //quozienti implementa comparable!
		
	Collections.sort(quozienti);  //!!!!!!!!!!!!!!!
	