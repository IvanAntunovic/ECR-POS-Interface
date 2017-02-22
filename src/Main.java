/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.protocol;
import com.mycompany.protocol.Message;
import com.mycompany.protocol.Test;
import com.mycompany.protocol.TestController;
import com.mycompany.protocol.TestReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.UnexpectedException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.ini4j.Ini;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author A661517
 */
public class Main 
{
    public static void main(String[] args) throws IOException
    {
        Scanner input = new Scanner(System.in);
        Message[] messages = new Message[100];
        Test test = new Test();
        
        File file = null;
        try {
            file = new File("C:\\Users\\a661517\\Documents\\POS\\testFile.ini");
        } catch (Exception e) 
        {
            System.err.println("ERROR opening file: " + e);
        }
        
        Ini ini = null;
        
        try {
            ini = new Ini(file);
        } catch (IOException ex)
        {
            System.err.println("ERROR: " + ex);
        }
        
        try {
            ini.load(new FileReader(file));
        } catch (FileNotFoundException ex) 
        {
           System.err.println("ERROR: " + ex);
        }
        
        TestReader testReader = new TestReader(ini);
        TestController testController = new TestController(testReader);
        
        boolean isIDCorrect = false;
        do{
            System.out.print("Enter ID: ");
            int id = input.nextInt();
            if(id < 0)
                throw(new UnexpectedException(Integer.toString(id)));
            isIDCorrect = true;
        }while(!isIDCorrect);

        test = testController.getTest("71");
        System.out.println(test.getMessages());
        
        
    }
}