package algorithms;

import main.SortArray;

public class MonkeySort extends Sort {
    
    public MonkeySort(SortArray data) {
        super(data);
    }

    @Override
    public void sort() {
        while(!data.isSorted()) {

            if(stop()) {
                return;
            }

            data.shuffle();
        }
        
    }
}
