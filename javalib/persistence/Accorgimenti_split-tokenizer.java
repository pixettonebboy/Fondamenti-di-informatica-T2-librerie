//Fondamenti Di Informatica T-2
//Librerie di Achille Pisani

	
//Se il separatore � un carattere speciale all'interno dei pattern avrebbe un suo significato particolare,
//perci� se scrivessimo readFromString(fintoFile1, "$") essa NON funzionerebbe come previsto ($ significa "a capo")
//ergo, � necessario neutralizzare il significato speciale del $ anteponendo una barra inversa (escaping):

	readFromString(fintoFile1, "\\$");
NOTA: la "(" � un carattere speciale, mentre ")" non lo �.
NOTA: IN CONTAINS NON CI SONO CARATTERI SPECIALI, NELLO SPLIT SI!

caratteri speciali che hanno bisogno dell'escape:
"\" (il carattere di escape stesso)
""" (il carattere di apertura e chiusura delle virgolette doppie)
"'" (il carattere di apertura e chiusura delle virgolette singole)
"\n" (il carattere di nuova riga)
"\t" (il carattere di tabulazione)
"\r" (il carattere di ritorno a capo)
"\b" (il carattere di backspace)
"\f" (il carattere di feed avanzamento pagina)
"(" (la parentesi tonda aperta)
")" (la parentesi tonda chiusa)
"[" (la parentesi quadra aperta)
"]" (la parentesi quadra chiusa)
"{" (la parentesi graffa aperta)
"}" (la parentesi graffa chiusa)
";" (il punto e virgola)
"," (la virgola)
"." (il punto)


//SPLIT:
	String[] items = line.split("(\\s||PIANO||CODICE)+");
	
	String[] items = line.trim().split("(\t)+");
	
	per dire che splitto se ci sono almeno due o pi� caratteri consecutivi: "\\s{2,}"


In Java, i caratteri speciali per la funzione split di una stringa sono i seguenti:

. (punto): rappresenta qualsiasi carattere, tranne il carattere di nuova linea (\n).
* (asterisco): rappresenta zero o pi� occorrenze del carattere precedente.
+ (pi�): rappresenta una o pi� occorrenze del carattere precedente.
? (punto interrogativo): rappresenta zero o una occorrenza del carattere precedente.
\ (backslash): utilizzato come carattere di escape per rappresentare i caratteri speciali \, ., *, + e ?.
| (barra verticale): utilizzata per separare alternative.


//verificare che in una stringa ci siano cifre:
if(string.matches(".*\\d+.*")) 

matches permette di verificare che la stringa rispetti cio che inserisco nell'argomento, in questo caso d+ sta per le cifre