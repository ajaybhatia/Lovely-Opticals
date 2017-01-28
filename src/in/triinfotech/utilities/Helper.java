/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.triinfotech.utilities;

import in.triinfotech.entity.controller.CustomerJpaController;
import in.triinfotech.entity.controller.EyeSightJpaController;
import in.triinfotech.entity.controller.UserJpaController;
import java.awt.Component;
import javax.persistence.Persistence;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author ajay
 */
public class Helper {

    public static UserJpaController getUserControllerInstance() {
        return new UserJpaController(
            Persistence.createEntityManagerFactory("LovelyOpticalsPU")
        );
    }
    
    public static CustomerJpaController getCustomerControllerInstance() {
        return new CustomerJpaController(
            Persistence.createEntityManagerFactory("LovelyOpticalsPU")
        );
    }
    
    public static EyeSightJpaController getEyeSightControllerInstance() {
        return new EyeSightJpaController(
            Persistence.createEntityManagerFactory("LovelyOpticalsPU")
        );
    }
    
    public static void centerScreen(JFrame frame) {
        frame.setLocationRelativeTo(null);
    }
    
    public static void showSuccessMessage(Component component, String message) {
        JOptionPane.showMessageDialog(component, message, "Message", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void showErrorMessage(Component component, String message) {
        JOptionPane.showMessageDialog(component, message, "Message", JOptionPane.ERROR_MESSAGE);
    }
    
}
