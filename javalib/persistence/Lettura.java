//Fondamenti Di Informatica T-2
//Librerie di Achille Pisani

	
//CREAZIONE READER (MAIN)
	Reader reader = new FileReader("FrasiOroscopo.txt")

public static void main(String[] args) throws IOException {
		//prendo il nome del file da leggere dal metodo nella classe interfaccia
		Optional<List<String>> filenames = RailwayLineReader.getAllLineNames(Paths.get("."));
		MyRailwayLineReader rdr = new MyRailwayLineReader();
		for (String filename: filenames.get()) {
		//per ogni nome preso dal metodo, faccio una lettura del file con quel nome
			RailwayLine line = rdr.getRailwayLine(new FileReader(filename));
			System.out.println(line);
		}
		
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//INIZIO LETTURA:

	if(reader==null) throw new IllegalArgumentException("Il reader passato in ingresso � nullo.");
		
	BufferedReader bufferedReader = new BufferedReader(reader);  
	String line = null;                                      
	while ( (line = bufferedReader.readLine()) != null) {        
		if (line.isBlank()) continue;                           
		String[] items = line.trim().split("(\\s)+");
	}


//SE DEVO LEGGERE UN FILE IN CUI DEVO USARE UNA FUNZIONE PRIVATE PERCH� LE RIGHE NON SONO TUTTE UGUALI MA DEL TIPO : INIZIO--CICLO DI LETTURA--FINE
	public Map<String,Tariffa> leggiTariffe(Reader reader) throws IOException, BadFileFormatException{
		BufferedReader rdr = new BufferedReader (reader);
		Map<String,Tariffa> map = new TreeMap <>();
		Tariffa t;
		while((t = leggiTariffa(rdr)) != null) {
			map.put(t.getNomeTariffa(),t);
		}
		return map;
	}
	
	private Tariffa leggiTariffa(BufferedReader reader) throws IOException, BadFileFormatException {
		String nome;
		//specificare che se devo dare indietro un NULL se mi accorgo che il primo readLine() � nullo!!!
		if((nome = reader.readLine()) == null) {
			return null;
		}
		else {
			nome = nome.replace("Tariffa", "").trim();
		}

//UTILI:

	if(items.length!=LENGHT) throw new BadFileFormatException(
		"La riga deve contenere nnnnn campi separati da ");
	if(items[0].isEmpty() || items[i].isEmpty()) throw new BadFileFormatException("Uno o pi� campi della riga sono vuoti");
	
	String id = items[i].trim();	
	
	throw new BadFileFormatException();
	
	//SPLIT WITH MULTIPLE ITEMS: uso |
	String[] itemsCal = calorie.split("(\\s)+|(\t)+");
		

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//LETTURA DA COSTRUTTORE:///////////////////////////////////////////////////////////////////////////////////////////////////

	public class TextFileOroscopoRepository implements OroscopoRepository {

		private Map<String, List<Previsione>> data;
		private static final String FINE = "FINE";
		private static final String SEPARATORS = "\t";   //definisco qui i separtori: nel caso specifico solo tab
	
	
//COSTRUTTORE: in argomento il reader (passato dal main), throws exceptions

	public TextFileOroscopoRepository (Reader baseReader) throws IOException, BadFileFormatException {  //Reader creato!!!!!!!!!!
		
		if (baseReader == null)
			throw new IllegalArgumentException(
				"Errore di persistenza: al costruttore e' stato passato un reader nullo."
			);
		
		//"Errore di persistenza: al costruttore della classe " + TextFileOroscopoRepository.class.getSimpleName() + " e' stato passato un " + Reader.class.getSimpleName() + " nullo."
			
		data = new HashMap<String, List<Previsione>>();


//LETTURA DA FILE: BUFFERED READER ////////////////////////////////////////////////////////////////////////////////////////////7
		
		if(reader==null) throw new IllegalArgumentException("Il reader passato in ingresso � nullo.");
		BufferedReader bufferedReader = new BufferedReader(reader);  
		String line = null;                                      
		while ( (line = bufferedReader.readLine()) != null) {        
			if (line.isBlank()) continue;                           
			String[] items = line.trim().split("(\\s)+");
		}	
			
			
	/// con commenti:
			
		BufferedReader bufferedReader = new BufferedReader(baseReader);  //BufferedReader creato dal reader di prima!!!!!!!!!!!!!
		String line = null;                                      //inizializzo una linea nulla
		while ( (line = bufferedReader.readLine()) != null) {        //finch� il file non finisce (riga nulla)
			if (line.isBlank()) continue;                            //se la riga � vuota (solo spazi o tab) passo al prossimo ciclo del while
			String settore = line.trim().toUpperCase();              //trim della linea e upper case
			
 /****CONTROLLI SPECIFICI*************			
  *			if (!settore.chars().allMatch(ci -> "QWERTYUIOPLKJHGFDSAZXCVBNM0123456789".contains(((char) ci) + "")))   //controllo che sia una stringa alfanumerica
  *				throw new BadFileFormatException(
  *					"Errore di formattazione: il file deve contenere diversi gruppi relativi a diversi settori" +
  *					" dove la prima riga di ogni gruppo deve essere il nome del settore come stringa senza alcuno spazio o simili (tabulatori, ecc...)."
  *				);
  *			if (data.containsKey(settore)) throw new BadFileFormatException( "Il file di testo contiene piu' di una sola volta indicazioni per il settore " + settore + ".");
  ************************************/	
  			data.put(settore, caricaPrevisioni(bufferedReader, settore));   //chiamo una funzione che usa bufferedReader: lettura
    	} 
  	}

 
 //USO BUFFEREDREADER: READLINE E STRING TOKENIZER   + try&catch //////////////////////////////////////////////////////////////777
 
 private List<Previsione> caricaPrevisioni (BufferedReader bufferedReader, String settore) throws IOException, BadFileFormatException {
		                                   //BufferedReader creato prima passato in argomento
		String line = null;
		ArrayList<Previsione> response = new ArrayList<Previsione>();  (      //creo
		
		while ( (line = bufferedReader.readLine()) != null) {
			if (line.isBlank()) continue;
			if (line.trim().toUpperCase().equals(FINE)) break;    //Indica la fine del settore
			
			StringTokenizer stringTokenizer = new StringTokenizer(line, SEPARATORS);       //separatori definiti in alto (tab)
			
			if (stringTokenizer.countTokens() != 2 && stringTokenizer.countTokens() != 3)    //devono esserci sempre 2 o 3 token (file specifico)
				 throw new BadFileFormatException("Errore di formattazione in una delle righe descrittive di una previsione del settore " + settore + ".");
			
			String descrizione = stringTokenizer.nextToken().trim();     //il primo token � sempre la descrizione
			
			int fortuna = -1;
			
			try {
				 fortuna = Integer.parseInt(stringTokenizer.nextToken().trim());
				if (fortuna < 0) throw new NumberFormatException();
			} catch (NumberFormatException e) {
				throw new BadFileFormatException(
					"Errore di formattazione in una delle righe descrittive di una previsione del settore " + settore + ": il valore di fortuna non e' un intero positivo o nullo."
				);
			}
			
			Previsione previsione = null;
			
			if (stringTokenizer.hasMoreTokens()) {     //non sempre ce ne sono 3
				try {
					String s = stringTokenizer.nextToken();
					Set<SegnoZodiacale> szs = new TreeSet<>(Arrays.stream(s.trim().split(",")).map((String sz) -> SegnoZodiacale.valueOf(sz)).toList());
					previsione = new Previsione(descrizione, fortuna, szs);
				} catch (IllegalArgumentException e) {
					throw new BadFileFormatException(
						"Errore di formattazione in una delle righe descrittive di una previsione del settore " + settore + ": sono indicati dei segni zodiacali non accettabili."
					);
				}
				
			} else previsione = new Previsione(descrizione, fortuna);
			response.add(previsione);
		}
		
		if (response.size() == 0) throw new BadFileFormatException("Il settore " + settore + " pare non contenga alcuna previsione.");
		return response;
	}
 
 
 
 
 
 