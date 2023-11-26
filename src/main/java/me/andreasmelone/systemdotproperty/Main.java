package me.andreasmelone.systemdotproperty;

import javax.swing.*;
import java.awt.*;

public class Main {
    JTextArea textArea;

    public static void main(String[] args) {
        new Main().run(args);
    }

    public void run(String[] args) {
        JFrame frame = new JFrame("SystemDotProperty");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        frame.add(textArea);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        JMenuItem getPropertyItem = new JMenuItem("Get property");
        getPropertyItem.addActionListener(e -> {
            String property = JOptionPane.showInputDialog(frame, "Enter property name");
            if (property != null) {
                String value = System.getProperty(property);
                if (value != null) {
                    textArea.append(property + ": " + value + "\n");
                } else {
                    textArea.append("Property " + property + " not found\n");
                }
            }
        });
        menu.add(getPropertyItem);

        JMenuItem clearItem = new JMenuItem("Clear");
        clearItem.addActionListener(e -> textArea.setText(""));
        menu.add(clearItem);

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        menu.add(exitItem);
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);

        frame.setVisible(true);
    }
}