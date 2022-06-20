package algorithms;

import main.SortArray;

public class CocktailSort extends Sort {

    public CocktailSort(SortArray data) {
        super(data);
    }

    @Override
    public void sort() {
        boolean swapped = true;

        int min = 0;
        int max = data.length() - 1;

        if(data.isSorted()) {
            return;
        }

        while(swapped) {

            swapped = false;
            
            for(int j = min; j < max; j++) {
                if(stop()) {
                    return;
                }

                if(data.get(j) > data.get(j+1)) {
                    data.swap(j, j+1);
                    swapped = true;
                }
            }
            max--;

            if(!swapped) {
                break;
            }

            for(int j = max; j > min; j--) {
                if(stop()) {
                    return;
                }

                if(data.get(j-1) > data.get(j)) {
                    data.swap(j-1, j);
                }
            }
            min++;
        }

        if(!data.isSorted()) {
            sort();
        }
        
    }
    
}
