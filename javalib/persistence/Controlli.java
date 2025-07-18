//Fondamenti Di Informatica T-2
//Librerie di Achille Pisani

	
//CONTROLLO CHE UNA STRINGA SIA ALFANUMERICA (no spazi)

	if (!settore.chars().allMatch(ci -> "QWERTYUIOPLKJHGFDSAZXCVBNM0123456789".contains(((char) ci) + "")))  
											//controllo che sia una stringa alfanumerica
		throw new BadFileFormatException(
					"Errore di formattazione: la prima riga deve essere una stringa senza alcuno spazio o simili (tabulatori, ecc...)."
 			);
 			
///////////////////////////////////////////////////////////////////////////////////////////////////////////////