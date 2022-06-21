package main;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class SortArray extends JPanel {
    public final static int SCREEN_WIDTH = 1000;
    public final static int SCREEN_LENGTH = 700;

    public final static int GRID_SIZE = 100; //width of each rectangle

    private static int[] data;
    private static Color[] dataColor;

    private final static int TIME = 1; //delay time milli sec

    private JLabel txtRead_Count;
    private int read_count = 0;

    private JLabel txtSwap_Count;
    private int swap_count = 0;

    public SortArray() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_LENGTH));
        this.setBackground(Color.BLACK);

        this.setLayout(new FlowLayout(FlowLayout.LEFT));

        txtRead_Count = new JLabel("Number of Reads: "+read_count);
        txtRead_Count.setBackground(Color.BLACK);
        txtRead_Count.setForeground(Color.WHITE);
        txtRead_Count.setPreferredSize(new Dimension(200, 40));
        this.add(txtRead_Count);

        txtSwap_Count = new JLabel("Number of Swaps: "+swap_count);
        txtSwap_Count.setBackground(Color.BLACK);
        txtSwap_Count.setForeground(Color.WHITE);
        txtSwap_Count.setPreferredSize(new Dimension(200, 40));
        this.add(txtSwap_Count);

        data = new int[SCREEN_WIDTH/GRID_SIZE];
        dataColor = new Color[data.length];

        //set data and set the default color to white
        for(int i = 0; i < data.length; i++) {
            data[i] = i * SCREEN_LENGTH/data.length;
            dataColor[i] = Color.WHITE;
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //draws the bar graph with height as the value
        for(int i = 0; i < data.length; i++) {
            g.setColor(dataColor[i]);
            g.fillRect(i * GRID_SIZE, SCREEN_LENGTH - data[i], GRID_SIZE, data[i]);
        }

    }

    public void shuffle() {
        for(int i = 0; i < data.length; i++) {
            int randIndex = (int) Math.floor(Math.random() * data.length);
             swap(i, randIndex);
        }

        makeAll(Color.WHITE);
    }

    public void swap(int index1, int index2) {
        int temp = get(index1);
        data[index1] = get(index2);
        data[index2] = temp;

        incrementSwap();
    }

    public void set(int index, int value) {
        dataColor[index] = Color.GREEN;
        repaint();
        sleepFor(TIME);

        colorBrighter();

        incrementCount();

        data[index] = value;
    }

    public boolean isSorted() {
        for(int i = 0; i < data.length - 1; i++) {
            if(get(i) > get(i+1)) {
                return false;
            }
        }

        makeAll(Color.GREEN);

        return true;
    }

    public int length() {
        return data.length;
    }

    public int get(int index) {
        //set the bar graph to green
        dataColor[index] = Color.GREEN;
        repaint();
        sleepFor(TIME);

        colorBrighter();

        incrementCount();

        return data[index];
    }

    public void printArr() {
        for(int i : data) {
            System.out.print(i+", ");
        }
        System.out.println();
    }



    private void sleepFor(long milliseconds) {
        long timeElapsed;
        final long startTime = System.currentTimeMillis();

        do {
            timeElapsed = System.currentTimeMillis() - startTime;
        }
        while(timeElapsed < milliseconds);
    }

    private void colorBrighter() {
        for(int i = 0; i < dataColor.length; i++) {
            int r = dataColor[i].getRed();
            int g = dataColor[i].getGreen();
            int b = dataColor[i].getBlue();

            r += (255-r)/4;
            g += (255-g)/4; 
            b += (255-b)/4;
        
            dataColor[i] = new Color(r, g, b);
        }
    }

    public void makeAll(Color c) {
        for(int i = 0; i < dataColor.length; i++) {
            dataColor[i] = c;
        }

        repaint();
    }

    private void incrementCount() {
        read_count++;
        txtRead_Count.setText("Number of Reads: "+read_count);
    }

    private void incrementSwap() {
        swap_count++;
        txtSwap_Count.setText("Number of Swaps: "+swap_count);
    }

    public void resetCount() {
        read_count = 0;
        txtRead_Count.setText("Number of Reads: "+read_count);

        swap_count = 0;
        txtSwap_Count.setText("Number of Swaps: "+swap_count);
    }
}
