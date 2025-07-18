//Fondamenti Di Informatica T-2
//Librerie di Achille Pisani

	
///FRECCE UML:

	A - - - - - > B   //A dipende da (usa) B
	
	
	A ----------- B   //associazione generica
	
	
	NAVE ---------<> FLOTTA  //aggregazione: flotta composta di navi, ma 
							 //le navi esistono anche senza flotta
	USO: Flotta(Nave[] navi) {
			 this.navi = navi; }
	
	
	TRI ---------<@> VERTICI //triangolo composto di vertici, che 
	                         //esistono solo dentro al triangolo, tutti essenziali
	USO: Triangolo(Vertice[] vertici) {
			 this.vertici = Arrays.copyOf(vertici, vertici.length); }

			 