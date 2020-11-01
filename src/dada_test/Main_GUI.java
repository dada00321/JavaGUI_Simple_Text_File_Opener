package dada_test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;

public class Main_GUI {
	public static void main(String[] args) {
		Simple_TextFile_Opener frame = new Simple_TextFile_Opener();
        frame.setVisible(true);
        frame.setSize(1000, 600);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}