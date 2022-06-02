package algorithms;

import main.SortArray;

public class MergeSort extends Sort {

    private SortArray data;
    
    public MergeSort(SortArray data) {
        this.data = data;
    }

    // public void merge(int mid, int left, int right) {
    //     int in = 0;
    //     int jn = 0;
    //     int k = 1;

    //     int sizeL = mid - left + 1;
    //     int sizeR = right - mid;

    //     int[] leftArr = new int[sizeL];
    //     int[] rightArr = new int[sizeR];

    //     for(int i = 0; i < sizeL; i++) {
    //         leftArr[i] = data.get(left + i);
    //     }

    //     for(int i = 0; i < sizeR; i++) {
    //         rightArr[i] = data.get(mid + i + 1);
    //     }

    //     while(in < sizeL && jn < sizeR) {
    //         if(leftArr[in] <= rightArr[jn]) {
    //             data.set(leftArr[in], k);
    //             in++;
    //         }
    //         else {
    //             data.set(rightArr[jn], k);
    //             jn++;
    //         }
    //         k++;
    //     }

    //     while (in < sizeL) {
    //         data.set(leftArr[in], k);;
    //         in++;
    //         k++;
    //     }

    //     while (jn < sizeR) {
    //         data.set(rightArr[jn], k);;
    //         jn++;
    //         k++;
    //     }

    // }
    
    // public void arrange(int left, int right) {
    //     System.out.println(left+", "+right);

    //     if(left < right) {

    //         int mid = (left + right - 1)/2;

    //         arrange(left, mid);
    //         arrange(mid + 1, right);

    //         merge(mid, left, right);

    //     }
    // }

    void merge(SortArray arr, int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
 
        /* Create temp arrays */
        int L[] = new int [n1];
        int R[] = new int [n2];
 
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = arr.get(l + i);
        for (int j=0; j<n2; ++j)
            R[j] = arr.get(m + 1 + j);
 
 
        /* Merge the temp arrays */
 
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
 
        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr.set(k, L[i]);
                i++;
            }
            else
            {
                arr.set(k, R[j]);
                j++;
            }
            k++;
        }
 
        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr.set(k, L[i]);
            i++;
            k++;
        }
 
        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr.set(k, R[j]);
            j++;
            k++;
        }
    }
 
    // Main function that sorts arr[l..r] using
    // merge()
    void arrange(SortArray arr, int l, int r)
    {
        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;
 
            // Sort first and second halves
            arrange(arr, l, m);
            arrange(arr , m+1, r);
 
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
 

    @Override
    public void sort() {
        if(data.isSorted()) {
            return;
        }

        arrange(data, 0, data.length()-1);

        if(!data.isSorted()) {
            arrange(data, 0, data.length()-1);
        }
    }

}