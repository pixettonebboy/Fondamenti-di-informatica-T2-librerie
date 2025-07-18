//Fondamenti Di Informatica T-2
//Librerie di Achille Pisani

	
ARROTONDARE UN NUMERO
double numero = 3.14;
int arrotondatoPerEccesso = (int) Math.ceil(numero);

double numero = 3.14;
int arrotondatoPerDifetto = (int) Math.floor(numero);

double numero = 3.6;
int arrotondato = (int) Math.round(numero);
//arrotondamento al valore pi� vicino

///////////////////////////////////////////////////////////////////////////////

Partire sempre dall'UML!!!!!!!!

///////////////////////////////////////////////////////////////////////////////

PER EVITARE NullPointerException: inizializzare le variabili (array) cos�:
	Oroscopo[] response = new OroscopoMensile[12];    		
	E NON:   Oroscopo[] response = null;
	
///////////////////////////////////////////////////////////////////////////////

PER USARE UN METODO DI UNA CLASSE all'esterno di tale classe, in generale 
bisogna creare un oggetto istanza di quella classe e poi chiamare il metodo 
desiderato su tale oggetto.
	ES. classe Random:

	Random r = new Random();    //prima creo un generatore di numeri random
	int i = r.nextInt();        //poi posso creare un numero intero random da r

Anche se la classe non ha un costruttore, posso anche usare l'interfaccia che 
la classe implementa

	ES. StrategiaSelezione selezione;


///////////////////////////////////////////////////////////////////////////////