package algorithms;

public abstract class Sort {
    private boolean stop = false;

    public void setStop() {
        stop = true;
    }

    public boolean stop() {
        return stop;
    }

    abstract public void sort();
}
