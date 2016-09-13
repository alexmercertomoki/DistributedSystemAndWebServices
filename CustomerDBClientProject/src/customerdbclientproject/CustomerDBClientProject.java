/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customerdbclientproject;

/**
 *
 * @author mac
 */
public class CustomerDBClientProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        NewJerseyClient client = new NewJerseyClient();
        
        String allXML = client.findAll_XML(String.class); 
       
        System.out.println(allXML);
        
        client.close();

        
    }
    
}
