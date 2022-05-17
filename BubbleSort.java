public class BubbleSort {

    public BubbleSort(SortArray data) {
        int max = data.length() - 1;

        while(!data.isSorted()) {
            for(int i = 0; i < max; i++) {
                if(data.get(i) > data.get(i+1)) {
                    data.swap(i, i+1);
                }
            }
            max--;
        }
    }
}
