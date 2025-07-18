//Fondamenti Di Informatica T-2
//Librerie di Achille Pisani

	

// SE HO MainPane EXTENDS BORDERPANE: /////////////////////////
	
	public MainPane (Controller controller, Stage stage) {
		this.setLeft(vBox);
	... }
	
	//INVECE CHE: 
		BorderPane borderPane = new BorderPane();
		borderPane.setLeft(vBox)
		
		
// CENTRARE COMPONENTE SINGOLO: SOLO DENTRO HBOX/VBOX

	HBox bottomPanel = new HBox();
	bottomPanel.getChildren().add(button);
	this.setBottom(bottomPanel); 
	bottomPanel.setAlignment(Pos.CENTER);  //NON: button.setAlignment(Pos.CENTER)
	
////////////////////////////////////////////////////////////////	
	
//INSETS:
	
	Insets insets = new Insets(20);
	
	VBox.setMargin(combo, insets);
	VBox.setMargin(button, insets);
	BorderPane.setMargin(vBox, insets);
	BorderPane.setMargin(grid, insets);	
	
//SPACING DENTRO LA HBOX:
	
	HBox rigaSuperiore = new HBox();
	rigaSuperiore.setSpacing(10);
	
//COLORE (bordo area di testo e panel):

	txtArea.setStyle("-fx-background-color: lightcoral;");
	this.setStyle("-fx-background-color: oldlace;");
	/COLORI CHIARI: snow, ivory, floralwhite, ghostwhite, linen, cornsilk, antiquewhite, 
	//aliceblue, azure, mintcream
	
	//BACKGROUND
	
	Background back1 = new Background(new BackgroundFill(Color.LAVENDER, new CornerRadii(0, false), new Insets (0, 0 ,0, 0))); 
	Background back2 = new Background(new BackgroundFill(Color.LIGHTGREEN, new CornerRadii(0, false), new Insets (0, 0 ,0, 0)));
	Background back3 = new Background(new BackgroundFill(Color.LIGHTCYAN, new CornerRadii(0, false), new Insets (0, 0 ,0, 0))); 
	Background back4 = new Background(new BackgroundFill(Color.LIGHTGOLDENRODYELLOW, new CornerRadii(0, false), new Insets (0, 0 ,0, 0)));

	setBackground(back1);
	
////////////////////////////////////////////////////////////////	
	
	 BorderPane borderPane = new BorderPane();
	 
     	ToolBar toolbar = new ToolBar();
    	HBox statusbar = new HBox();
     	Node appContent = new AppContentNode();
     	
     borderPane.setTop(toolbar);
     borderPane.setCenter(appContent);
     borderPane.setBottom(statusbar);
     
     //OPPURE:
     
     VBox outputPane = new VBox();
	 outputPane.setAlignment(Pos.CENTER_LEFT);
	 this.setRight(rightPane);