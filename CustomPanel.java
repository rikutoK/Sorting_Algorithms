import java.awt.FlowLayout;
import java.awt.Dimension;

import javax.swing.*;

public class CustomPanel extends JFrame {
    public final static int SCREEN_WIDTH = 200;
    public final static int SCREEN_LENGTH = 300;

    private SortArray data;

    private JButton shuffle;
    private JButton sort;

    private JComboBox cb;
    private final String[] algorithms = {
        "Bubble Sort",
        "Monkey Sort"
    };

    private Thread thread = new Thread();
    
    public CustomPanel(SortArray data) {
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        initComponents();

        this.setTitle("Sorting Algorithms");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(SCREEN_WIDTH, SCREEN_LENGTH));
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        this.data = data;
    }


    private void initComponents() {
        shuffle = new JButton("Shuffle");
        shuffle.addActionListener(e -> shuffle());
        this.add(shuffle);

        cb = new JComboBox(algorithms);
        cb.setEditable(false);
        this.add(cb);

        sort = new JButton("Sort");
        sort.addActionListener(e -> sort());
        this.add(sort);
    }

    private void shuffle() {
        if(thread.isAlive()) {
            return;
        }

        thread = new Thread(() -> data.shuffle());
        thread.start();
    }

    private void sort() {
        if(thread.isAlive()) {
            return;
        }
        
        thread = new Thread(() -> runAlgorithms());
        thread.start();
    }

    private void runAlgorithms() {
        switch((String) cb.getSelectedItem()) {
            case "Bubble Sort":
                new BubbleSort(data);
                break;
            case "Monkey Sort":
                new MonkeySort(data);
                break;
        }
    }
}
