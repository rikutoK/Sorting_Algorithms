package algorithms;

import main.SortArray;

public class MergeSort extends Sort {

    private SortArray data;
    
    public MergeSort(SortArray data) {
        this.data = data;
    }

    public void merge(SortArray data, int mid, int left, int right) {
        int in = 0;
        int jn = 0;
        int k = 1;

        int sizeL = mid - left + 1;
        int sizeR = right - mid;

        int[] leftArr = new int[sizeL];
        int[] rightArr = new int[sizeR];

        for(int i = 0; i < sizeL; i++) {
            leftArr[i] = data.get(left + i);
        }
        for(int i = 0; i < sizeR; i++) {
            rightArr[i] = data.get(mid + i + 1);
        }


    }
    
    public void arrange(SortArray data, int left, int right) {
        if (left < right) {
            int mid = left + (right - 1)/2;
  
            arrange(data, left, mid);
            arrange(data, mid + 1, right);
  
            merge(data, mid, left, right);
        }
    }

    @Override
    public void sort() {
        // TODO Auto-generated method stub
        
    }

}