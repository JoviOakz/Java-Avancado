import javax.swing.JFrame;

import Files.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);

        // Graph graph = new Graph();
        // graph.setSize(600, 600);
        Star stars = new Star();

        frame.add(stars);
        frame.setVisible(true);
    }
}