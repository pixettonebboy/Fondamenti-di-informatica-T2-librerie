//Fondamenti Di Informatica T-2
//Librerie di Achille Pisani

	

////BUBBLESORT////////////////////////////////////////////////////////////////////////

public void bubbleSort(int [] array) {
    for(int i = 0; i < array.length; i++) {
        boolean flag = false;
        for(int j = 0; j < array.length-1; j++) {
        //Se l' elemento j e maggiore del successivo allora
        //scambiamo i valori
            if(array[j]>array[j+1]) {
                int k = array[j];
                array[j] = array[j+1];
                array[j+1] = k;
                flag=true; //Lo setto a true per indicare che � avvenuto uno scambio
            }
        }
        if(!flag) break; //Se flag=false allora vuol dire che nell' ultima iterazione
                         //non ci sono stati scambi, quindi il metodo pu� terminare
                         //poich� l' array risulta ordinato
    }
}
///////////////////////////////////////////////////////////////////////////////////////