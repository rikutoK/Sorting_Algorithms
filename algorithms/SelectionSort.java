package algorithms;

import main.SortArray;

public class SelectionSort extends Sort {

    public SelectionSort(SortArray data) {
        super(data);
    }

    @Override
    public void sort() {

        if(data.isSorted()) {
            return;
        }

        for(int i = 0; i < data.length() - 1; i++) {
          
            int min_index = i;

            for(int j = i+1; j < data.length(); j++){

                if(stop()) {
                    return;
                }

                if(data.get(j) < data.get(min_index)){
                    min_index = j;
                }
            }

            data.swap(i, min_index);
        }

        if(!data.isSorted()) {
            sort();
        }
        
    }
    
}
