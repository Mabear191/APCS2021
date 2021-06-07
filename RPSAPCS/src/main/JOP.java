package main;

import java.awt.Component;
import javax.swing.JOptionPane;
public class JOP {
    public JOP() {
    }

    public static void msg(String msg) {
        JOptionPane.showMessageDialog((Component)null, msg);
    }

    public static String in(String msg) {
        return JOptionPane.showInputDialog(msg);
    }
}