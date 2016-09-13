/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texttest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author mac
 */
public class TextTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
          BufferedWriter bw = new BufferedWriter(new FileWriter("SecretAgents.kml")); 
          bw.write("asfsdafsrqwerqwrqwrqweçvzvzzvc");
    }
    
}
