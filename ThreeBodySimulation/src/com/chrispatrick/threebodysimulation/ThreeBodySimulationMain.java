package com.chrispatrick.threebodysimulation;

import javax.swing.*;

public class ThreeBodySimulationMain {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Three-Body Simulation");
        SimulationPanel panel = new SimulationPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
