package algorithms;
import main.SortArray;

public class BubbleSort extends Sort {

    private SortArray data;

    public BubbleSort(SortArray data) {
        this.data = data;
    }

    @Override
    public void sort() {
        int max = data.length() - 1;

        while(!data.isSorted()) {

            if(stop()) {
                return;
            }

            for(int i = 0; i < max; i++) {
                if(data.get(i) > data.get(i+1)) {
                    data.swap(i, i+1);
                }
            }
            max--;
        }
        
    }
}
