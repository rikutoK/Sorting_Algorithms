package algorithms;

import main.SortArray;

public class MonkeySort extends Sort {

    private SortArray data;
    
    public MonkeySort(SortArray data) {
        this.data = data;
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
