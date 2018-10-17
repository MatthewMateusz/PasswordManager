/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordmanager;

/**
 *
 * @author Matthew
 */
public class PasswordManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MainGui passwordGui = new MainGui();
        
        //Todo: Check for encrypted password file.
        // If there is decrypt and read.
        // If there is not promt if they want to create a new one.
        
        passwordGui.setVisible(true);
    }
    
}
