package algorithms;

import main.SortArray;

public class MergeSort extends Sort {
    
    public MergeSort(SortArray data) {
        super(data);
    }


    void merge(int l, int m, int r)
    {
        int leftSize = m - l + 1;
        int rightSize = r - m;
 
        int leftArr[] = new int [leftSize];
        int rightArr[] = new int [rightSize];
 
        for (int i=0; i<leftSize; ++i)
            leftArr[i] = data.get(l + i);
        for (int j=0; j<rightSize; ++j)
            rightArr[j] = data.get(m + 1 + j);
 
         int i = 0, j = 0;
 
        int k = l;
        while (i < leftSize && j < rightSize)
        {
            if (leftArr[i] <= rightArr[j])
            {
                data.set(k, leftArr[i]);
                i++;
            }
            else
            {
                data.set(k, rightArr[j]);
                j++;
            }
            k++;
        }
 
        while (i < leftSize)
        {
            data.set(k, leftArr[i]);
            i++;
            k++;
        }
 
        while (j < rightSize)
        {
            data.set(k, rightArr[j]);
            j++;
            k++;
        }
    }
 
    void arrange(int l, int r)
    {
        if (l < r)
        {
            int m = (l+r)/2;
 
            arrange(l, m);
            arrange(m+1, r);
 
            merge(l, m, r);
        }
    }
 
    @Override
    public void sort() {
        if(data.isSorted()) {
            return;
        }

        arrange(0, data.length()-1);

        if(!data.isSorted()) {
            arrange(0, data.length()-1);
        }
    }

}

//Hello