/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.bhuang;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author mac
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/myQueueTwo"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})

public class MyQueueListener2 implements MessageListener {
    
    public MyQueueListener2() {
        
        
    }
    
    @Override
    /*
     * When a message is available in jms/myQueue, then onMessage is
     * is called with that message.  In other words, onMessage is a 
     * jms/myQueue listener.
     */
    public void onMessage(Message message) {
        try {
            /*
             * There can be different types of Messages, 
             * so make sure this is the right type.
             */
            if (message instanceof TextMessage) {
                // Cast it to the right type of message
                TextMessage tm = (TextMessage) message;
                // Get the text from the received message
                String tmt2 = tm.getText();
                
                System.out.println("MyQueueListener received2 : " + tmt2);
                
            } else {
                System.out.println("I don't handle messages of this type");
            }
        } catch (JMSException e) {
            System.out.println("JMS Exception thrown" + e);
        } catch (Throwable e) {
            System.out.println("Throwable thrown" + e);
        }
    }  
    
    
    
}
