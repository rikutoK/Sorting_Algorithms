public class MonkeySort {
    
    public MonkeySort(SortArray data) {
        while(!data.isSorted()) {
            data.shuffle();
        }
    }
}
