/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.triinfotech.utilities;

import in.triinfotech.entity.EyeSight;
import in.triinfotech.entity.controller.CustomerJpaController;
import in.triinfotech.entity.controller.EyeSightJpaController;
import in.triinfotech.entity.controller.UserJpaController;
import java.awt.Component;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    public static void closeAndOpen(JFrame toClose, JFrame toOpen) {
        toClose.dispose();
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                toOpen.setVisible(true);
            }
        });
    }
    
    public static void generateHTML(EyeSight eyeSight) {
        // File Name
        Long customerId = eyeSight.getCustomer().getId();
        Long eyeSightId = eyeSight.getId();
        String reportFileName = customerId + "-" + eyeSightId + ".html";
        // Customer Infprmation
        String customerName = eyeSight.getCustomer().toString();
        String dateOfBirth = 
            new SimpleDateFormat("dd/MM/yyyy")
                .format(eyeSight.getCustomer().getDateOfBirth());
        String phoneNumber = eyeSight.getCustomer().getPhoneNumber();
        String date = 
            new SimpleDateFormat("dd/MM/yyyy")
                .format(eyeSight.getCreatedAt());
        // Right Eye Test Results
        float reSph = eyeSight.getSphRightEye();
        float reCyl = eyeSight.getCylRightEye();
        float reAxis = eyeSight.getAxisRightEye();
        float reAdd = eyeSight.getAddRightEye();
        // Left Eye Test Results
        float leSph = eyeSight.getSphLeftEye();
        float leCyl = eyeSight.getCylLeftEye();
        float leAxis = eyeSight.getAxisLeftEye();
        float leAdd = eyeSight.getAddLeftEye();
        
        String htmlCode = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "	<title></title>\n" +
                "	<link rel='stylesheet' type='text/css' href='css/bootstrap.min.css'>\n" +
                "	<link rel=\"stylesheet\" type=\"text/css\" href=\"\">\n" +
                "	<style type=\"text/css\">\n" +
                "		.shop-name {\n" +
                "			font-size: 6.5em;\n" +
                "		}\n" +
                "\n" +
                "		th {\n" +
                "			background-color: #EBEBEB;\n" +
                "		}\n" +
                "\n" +
                "		th, td:nth-child(1), td:nth-child(3), td:nth-child(4) {\n" +
                "			text-align: center;\n" +
                "		}\n" +
                "\n" +
                "		td:nth-child(5), td:last-child {\n" +
                "			text-align: right;\n" +
                "		}\n" +
                "\n" +
                "		.bold {\n" +
                "			font-weight: bolder;\n" +
                "		}\n" +
                "\n" +
                "		td:first-child {\n" +
                "			width: 100px;\n" +
                "		}\n" +
                "\n" +
                "		td:nth-child(3) {\n" +
                "			width: 100px;\n" +
                "		}\n" +
                "		.container{border:2px solid gray;border-top:none;}\n" +
                "	</style>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<div class='container'>\n" +
                "	<div class='row'>\n" +
                "		<div class='col-md-8 col-md-offset-2'>\n" +
                "			<h1 class='text-center shop-name'>Lovely Opticals</h1>\n" +
                "		</div>\n" +
                "	</div>\n" +
                "	<div class='row'>\n" +
                "		<div class='col-md-8 col-md-offset-2'>\n" +
                "			<h4 class='text-center clearfix'>Deals in: Specs, Goggles, Contact Lens, Complete Computerized Eye Testing</h4>\n" +
                "		</div>\n" +
                "	</div>\n" +
                "	<div class='row'>\n" +
                "		<div class='col-md-8 col-md-offset-2'>\n" +
                "			<h4 class='text-center clearfix'>Opp. Dena Bank, Near Lovely Fast Food, Railway Road, Hoshiarpur.</h4>\n" +
                "		</div>\n" +
                "	</div>\n" +
                "    <div class='row'>\n" +
                "		<div class='col-md-8 col-md-offset-2'>\n" +
                "			<h4 class='text-center clearfix'>Ph.(S)01882-232322, 75080-20006 E-mail:lovely_optical@yahoo.com</h4>\n" +
                "		</div>\n" +
                "	</div>\n" +
                "\n" +
                "	<hr>\n" +
                "\n" +
                "	<div class='row'>\n" +
                "		<div class='col-md-6'>\n" +
                "                   <div class='col-md-3'>\n" +
                "			<span>Customer ID:</span>\n" +
                "                   </div>\n" +
                "                   <div class='col-md-3'>\n" +
                "			<span><b>" + customerId + "</b></span>\n" +
                "                   </div>\n" +                
                "		</div>\n" +
                "		<div class='col-md-6'>\n" +
                "			<span class='pull-right'>Date: <b>" + date + "</b></span>\n" +
                "		</div>\n" +
                "	</div>\n" +
                "\n" +
                "	<div class='row'>\n" +
                "		<div class='col-md-6'>\n" +
                "                   <div class='col-md-3'>\n" +
                "			<span>Customer Name:</span>\n" +
                "                   </div>\n" +
                "                   <div class='col-md-3'>\n" +
                "			<span><b>" + customerName + "</b></span>\n" +
                "                   </div>\n" +
                "		</div>\n" +
                "	</div>\n" +
                "\n" +
                "	<div class='row'>\n" +
                "		<div>\n" +
                "			<table class='table table-hover table-bordered'>\n" +
                "				<thead>\n" +
                "					<tr>\n" +
                "						<th style=\"width:8%;\"></th>\n" +
                "						<th style=\"width:10%;\">SPH</th>\n" +
                "						<th style=\"width:10%;\">CYL</th>\n" +
                "						<th style=\"width:10%;\">AXIS</th>\n" +
                "						<th style=\"width:10%;\">ADD</th>\n" +     
                "					</tr>\n" +
                "				</thead>\n" +
                "				<tbody>\n" +
            
                "<tr>\n" +
                "						<td>RE</td>\n" +
                "						<td class=\"text-center\"><b>" + reSph + "</b></td>\n" +
                "						<td class=\"text-center\"><b>" + reCyl + "</b></td>\n" +
                "						<td class=\"text-center\"><b>" + reAxis + "</b></td>\n" +
                "						<td class=\"text-center\"><b>" + reAdd + "</b></td>\n" +
                
                "					</tr>\n" +
                "					<tr>\n" +
                "						<td>LE</td>\n" +
                "						<td class=\"text-center\"><b>" + leSph + "</b></td>\n" +
                "						<td class=\"text-center\"><b>" + leCyl + "</b></td>\n" +
                "						<td class=\"text-center\"><b>" + leAxis + "</b></td>\n" +
                "						<td class=\"text-center\"><b>" + leAdd + "</b></td>\n" +
                "					</tr>\n" +
                "				</tbody>\n" +
                "			</table>\n" +
                "		</div>\n" +
                "	</div>\n" +
                "	<div class='row'>\n" +
                "		<div class='col-md-6'>\n" +
                "                   <div class='col-md-3'>\n" +
                "			<span>DOB:</span>\n" +
                "                   </div>\n" +
                "                   <div class='col-md-3'>\n" +
                "			<span><b>" + dateOfBirth + "</b></span>\n" +
                "                   </div>\n" +
                "		</div>\n" +
                "	</div>\n" +
                "\n" +
                "	<div class='row'>\n" +
                "		<div class='col-md-6'>\n" +
                "                   <div class='col-md-3'>\n" +
                "			<span>Phone Number:</span>\n" +
                "                   </div>\n" +
                "                   <div class='col-md-3'>\n" +
                "			<span><b>" + phoneNumber + "</b></span>\n" +
                "                   </div>\n" +
                "		</div>\n" +
                "	</div>\n" +
                "\n" +

                "</div>	\n" +
                "\n" +
                "</body>\n" +
                "</html>";
        
        try {
            PrintWriter pw = new PrintWriter(new File(reportFileName));
            pw.print(htmlCode);
            pw.close();
            Helper.showSuccessMessage(null, "Report with filename " + reportFileName + " created successfully!");
        } catch (IOException ex) {
            Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
