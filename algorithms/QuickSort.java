package algorithms;

import main.SortArray;

import java.util.Random;

public class QuickSort extends Sort {

    public QuickSort(SortArray data) {
        super(data);
    }

    @Override
    public void sort() {
        if(data.isSorted()) {
            return;
        }

        quickSort(0, data.length()-1);

        if(!data.isSorted()) {
            sort();
        }
    }

    private void quickSort(int low, int high) {
        if(low < high + 1){
            int p = partition(low, high);
            quickSort(low, p-1);
            quickSort(p+1, high);
        }
    }

    private int getPivot(int low, int high) {
        Random rand = new Random();
        return rand.nextInt((high - low) + 1) + low;
    }

    private int partition(int low, int high) {
        data.swap(low, getPivot(low, high));
        int border = low + 1;
        for(int i = border; i <= high; i++){
            if(data.get(i) < data.get(low)){
                data.swap(i, border++);
            }
        }
        data.swap(low, border - 1);
        return border-1;
    }

}