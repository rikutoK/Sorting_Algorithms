package main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class SortArray extends JPanel {
    public final static int SCREEN_WIDTH = 1000;
    public final static int SCREEN_LENGTH = 700;

    public final static int GRID_SIZE = 10; //width of each rectangle

    private static int[] data;
    private static Color[] dataColor;

    private final static int TIME = 1; //delay time milli sec

    public SortArray() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_LENGTH));
        this.setBackground(Color.BLACK);

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
    }

    public void set(int index, int value) {
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
}
