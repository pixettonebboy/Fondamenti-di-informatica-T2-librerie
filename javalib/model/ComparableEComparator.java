//Fondamenti Di Informatica T-2
//Librerie di Achille Pisani

	
//////////////////////////////////////////////////////////////

	DEFAULT: string: ordine alfabetico = -1 se a precede b
			 interi: a.compare(b) = -1 se a<b
			 double: Double.compare(a,b) = -1 se a<b

ATTENZIONE: COMPARAZIONE DI TERMINI MA IN SENSO OPPOSTO (METTO IN FONDO ALLA LISTA I PI� PICCOLI, TENGO DAVANTI I PI� GRANDI)
(preso dall'esame delle elezioni, DA NOTARE LA PRESENZA DEL "-" DAVANTI A LONG!!!!!)
Comparator<Quoziente> cmp = (q1, q2) -> -Long.compare(q1.getQuoziente(), q2.getQuoziente());
	
//////////////////////////////////////////////////////////////
ATTENZIONE: se viene chiesto di comparare secondo un metodo che non � all'interno della classe che sto usando, ma fa parte di una classe che viene usata dalla classe con cui sto lavorando, creo una funzione (grazie alla lambda exprection) che dato in input il tipo della classe con cui lavoro (esame in questo caso) mi da come output il metodo di interesse che vado a prendere da un altra classe (in queston caso mi interessa il metodo getID, che prendo dalla classe AttivitaFormativa, che recupero dalla classe che sto usando tramite il metodo getAf(). Quindi far� una comparazione che ha come termini di confronto il risultato della mia funzione lambda exprection, ovvero l'id ricavato dall'attivita formativa ricavata a sua volta dall'esame corrente che sto trattando!!!!
cmp = Comparator.comparing(Esame::getDate).thenComparing((Esame e) -> e.getAf().getId());
//nota: non compaiono i metodi quando compongo la lambda exprection

	Collections.sort(playlist, comparing(Song::getTitle)
								.thenComparing(p1 -> p1.getDuration())
								.thenComparing(p1 -> p1.getArtist()) );

	Collections.sort(persone, Comparator.comparing(Persona :: getCognome())
									 .thenComparing(p->p.getNome())
									 .thenComparingInt(p->p.getEta()));
									 
	//pi� pulito:			  Comparator.comparing( Persona::getCognome ) 
										.thenComparing( Persona::getNome )
										.thenComparingInt( Persona::getEt� );
										
	//i tipi primitivi, richiedono un trattamento ad hoc:
	// comparingInt, comparingLong, comparingDouble
									 
	Arrays.sort(persone, Comparator.comparing( Persona::getCognome );
	
	Collections.sort(playlist, comparing(Song::getTitle).thenComparing(p1 -> p1.getDuration())
														.thenComparing(p1 -> p1.getArtist()) )
		
//////////////////////////////////////////////////////////////

//COMPARABLE: 

//compareTo A CASCATA CON COMPARABLE:

	public int compareTo(Persona that) {
	
		int confrontoCognomi = cognome.compareTo(that.cognome); //confronto prima i cognomi (stringhe comparable)
		
		return (confrontoCognomi!=0 ? //se sono diversi (ris diverso da 0) faccio il return, altrimenti
		confrontoCognomi : nome.compareTo(that.nome));   //... comparo i nomi (per cognomi uguali)
	}
	
	
//comapreTo SENZA COMPARABLE

	public int compareTo(Counter that) { 
		if (val < that.val) return -1;
		if (val > that.val) return +1;
		/* else */ return 0;
	}
	
////////////////////////////////////////////////////////////////

//COMPARATOR: uso la funzione compare e poi Arrays.sort

	class CognomeComparator implements Comparator<Persona> {
		public int compare(Persona p1, Persona p2){
			return p1.getCognome().compareTo(p2.getCognome());
		}
	}
	
	class NomeComparator implements Comparator<Persona> {
		public int compare(Persona p1, Persona p2){
			return p1.getNome().compareTo(p2.getNome());
		}
	}
	
	class EtaComparator implements Comparator<Persona> {
		public int compare(Persona p1, Persona p2){
			return Integer.compare(p1.getEt�(), p2.getEt�());
		}
	}
	
	Arrays.sort(persone, new CognomeComparator() );   //!!!!!!!!!!!!!!!!
	Arrays.sort(persone, new EtaComparator() );

///////////////////////////////////////////////////////////////////

	public static int compare(double d1, double d2)

Returns: the value 0 if d1 is numerically equal to d2; 
		a value less than 0 if d1 is numerically less than d2; 
		and a value greater than 0 if d1 is numerically greater than d2.
