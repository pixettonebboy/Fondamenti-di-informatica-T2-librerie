//Fondamenti Di Informatica T-2
//Librerie di Achille Pisani

	
//Usare un generatore randomico:

public class MyStrategiaSelezione implements StrategiaSelezione {

	private Random r;
	
	public MyStrategiaSelezione () { r = new Random(); }
	
	@Override
	public Previsione seleziona(List<Previsione> previsioni, SegnoZodiacale segno) {
		
		Previsione previsione = null;
		do { previsione = previsioni.get(r.nextInt(0, previsioni.size() - 1)); } while (!previsione.validaPerSegno(segno));
		return previsione;
	}
}
///////////////////////////////////////////////////////////////////////////////


