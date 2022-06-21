package algorithms;

import main.SortArray;

public class MergeSort extends Sort {

    private SortArray data;
    
    public MergeSort(SortArray data) {
        this.data = data;
    }

    public void merge(int mid, int left, int right) {
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

        while(in < sizeL && jn < sizeR) {
            if(leftArr[in] <= rightArr[jn]) {
                data.swap(k, left+in);
                in++;
            }
            else {
                data.swap(k, mid+jn+1);
                jn++;
            }
            k++;
        }

        while (in < sizeL) {
            data.swap(k, left+in);;
            in++;
            k++;
        }

        while (jn < sizeR) {
            data.swap(k, mid+jn+1);;
            jn++;
            k++;
        }

    }
    
    public void arrange(int left, int right) {
        System.out.println(left+", "+right);

        if(left == right) {
            return;
        }

        int mid = (left + right - 1)/2;

        arrange(left, mid);
        arrange(mid + 1, right);

        merge(mid, left, right);
    }

    @Override
    public void sort() {
        if(data.isSorted()) {
            return;
        }

        arrange(0, data.length()-1);

        // if(!data.isSorted()) {
        //     sort();
        // }
    }

}

//Hello