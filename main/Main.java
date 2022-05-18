package main;
import javax.swing.JFrame;

public class Main extends JFrame{

    private SortArray data;

    public Main() {
        data = new SortArray();
        this.add(data);

        this.setTitle("Sorting Algorithms");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        new Controller(data);
    }

    public static void main(String[] args) {
        new Main();
    }
}