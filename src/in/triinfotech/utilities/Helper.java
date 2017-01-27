/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.triinfotech.utilities;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author ajay
 */
public class Helper {

    public static void showSuccessMessage(Component component, String message) {
        JOptionPane.showMessageDialog(component, message, "Message", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void showErrorMessage(Component component, String message) {
        JOptionPane.showMessageDialog(component, message, "Message", JOptionPane.ERROR_MESSAGE);
    }
    
}
