/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordmanager;

import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Matthew
 */
public class PasswordManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        data data = new data();
        MainGui passwordGui = new MainGui();
        NewPassGui newPass = new NewPassGui();
        
        //Todo: Check for encrypted password file.
        // If there is decrypt and read.
        // If there is not promt if they want to create a new one.
        passwordGui.setVisible(true);
        File passwordFile = new File("data.epf");
        if (!passwordFile.exists() && !passwordFile.isDirectory()) {
            Object[] options = {"Yes", "No"};
            int r = JOptionPane.showOptionDialog(
                    passwordGui, 
                    "Could not find password file \n Do you want to create one", 
                    "Do you want to create a password file", 
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.WARNING_MESSAGE, 
                    null, 
                    options, 
                    options[1]);
            
            if (r == 0) {
                char[] tempPass = newPass.newPass();
                System.out.println(tempPass);
                //passwordFile.createNewFile();
            }
            else{
                System.exit(0);
            }
        }
        
            
    }
    
}
