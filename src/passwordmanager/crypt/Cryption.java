/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordmanager.crypt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Matthew
 */
public class Cryption {
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES";
    
    public static void encrypt(char[] key, File inputFile, File outputFile) throws CryptoException, InvalidKeyException { 
        crypt(Cipher.ENCRYPT_MODE, key, inputFile, outputFile);
    }
    
    public static void decrypt(char[] key, File inputFile, File outputFile) throws CryptoException, InvalidKeyException{
        crypt(Cipher.DECRYPT_MODE, key, inputFile, outputFile);
    }
    
    public static void crypt(int cipherMode, 
            char[] key, 
            File inputFile, 
            File outputFile) throws CryptoException, InvalidKeyException {
         try {
             Key secretKey = new SecretKeySpec(Arrays.toString(key).getBytes(), ALGORITHM);
             Cipher cipher = Cipher.getInstance(TRANSFORMATION);
             cipher.init(cipherMode, secretKey);
             
             FileInputStream inputStream = new FileInputStream(inputFile);
             byte[] inputBytes = new byte[(int) inputFile.length()];
             inputStream.read(inputBytes);
             inputStream.close();
             System.out.println(Arrays.toString(inputBytes));
             
             byte[] outputBytes = cipher.doFinal(inputBytes);
             
             FileOutputStream outputStream = new FileOutputStream(outputFile);
             outputStream.write(outputBytes);
             
             
             outputStream.close();

         } catch (InvalidKeyException ex) {
             throw ex;
         }
         catch (NoSuchPaddingException | 
                 NoSuchAlgorithmException | 
                 BadPaddingException |
                 IllegalBlockSizeException |
                 IOException ex) {
             throw new CryptoException("Error encrypting/decrypting file", ex);
         }
    }
    
}


