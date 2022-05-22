package algorithms;
import main.SortArray;

public class BubbleSort extends Sort {

    private SortArray data;

    public BubbleSort(SortArray data) {
        this.data = data;
    }

    @Override
    public void sort() {
        boolean swapped = true;

        int max = data.length() - 1;

        while(swapped) {

            swapped = false;

            for(int j = 0; j < max; j++) {

                if(stop()) {
                    return;
                }

                if(data.get(j) > data.get(j+1)) {
                    data.swap(j, j+1);
                    swapped = true;
                }
            }
            
            max--;
        }

        if(!data.isSorted()) {
            sort();
        }
        
    }
}
