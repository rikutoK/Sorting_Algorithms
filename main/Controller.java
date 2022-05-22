package main;
import java.awt.FlowLayout;
import java.awt.Dimension;

import javax.swing.*;

import algorithms.*;

public class Controller extends JFrame {
    public final static int SCREEN_WIDTH = 200;
    public final static int SCREEN_LENGTH = 300;

    private SortArray data;

    private JButton shuffle;
    private JButton sort;
    private JButton stop;

    private Sort algorithm = null;

    private JComboBox cb;
    private final String[] algorithms = {
        "Bubble Sort",
        "Cocktail Sort",
        "Monkey Sort",
        "Selection Sort",
        "Insertion Sort",
        // "Merge Sort",
        "Quick Sort"
    };

    private Thread thread = new Thread();
    
    public Controller(SortArray data) {
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

        stop = new JButton("Stop");
        stop.addActionListener(e -> stop());
        this.add(stop);
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
                algorithm = new BubbleSort(data);
                break;
            case "Monkey Sort":
                algorithm = new MonkeySort(data);
                break;
            case "Selection Sort":
                algorithm = new SelectionSort(data);
                break;
            case "Insertion Sort":
                algorithm = new InsertionSort(data);
                break;
            case "Cocktail Sort":
                algorithm = new CocktailSort(data);
                break;
            case "Quick Sort":
                algorithm = new QuickSort(data);
                break;
            default:
                return;
        }

        algorithm.sort();
    }

    private void stop() {
        if(algorithm == null) {
            return;
        }

        algorithm.setStop();
    }
    
}
