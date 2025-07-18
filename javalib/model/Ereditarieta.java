//Fondamenti Di Informatica T-2
//Librerie di Achille Pisani

	

//PER CHIAMARE UN METODO DELLA CLASSE MADRE: super.nomeMetodo();

	protected void setCell(int row, int col, Cell cell) {
		super.setCell(row, col, cell);
		}
		
//PER CHIAMARE UN COSTRUTTORE CON DIVERSI ARGOMENTI:
	
	//NO:
	//	public RealMineField(int size) {
	//		super(size);
	//		mines = 10
	//		RealMineField rmf = new RealMineField(size, mines);
	//	}
	
	//SI:
	//	public RealMineField(int size) {
	//		this(size, 10);
	//	}
	
	//E INVOCO IL SUPER NEL SECONDO:
	
	public RealMineField(int size, int mines) {
		super(size);
		this.mines=mines;
	}
	