package algorithms;

import main.SortArray;

public abstract class Sort {
    private boolean stop = false;
    protected SortArray data;

    public Sort(SortArray data) {
        this.data = data;
    }

    public void setStop() {
        stop = true;
    }

    public boolean stop() {
        return stop;
    }

    abstract public void sort();
}
