/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.bhuang;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 *
 * @author mac
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "JMS/MyQueue"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})


public class MyQueueListener implements MessageListener {
    
     // Lookup the ConnectionFactory using resource injection and assign to cf
    @Resource(lookup = "JMI/MyConnectionFactory")
    private ConnectionFactory cf;
    // lookup the Queue using resource injection and assign to q
    @Resource(lookup = "jms/myQueueThree")
    private Queue q;

    
    public MyQueueListener() {
        
        
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
                String tmt = tm.getText();
//                System.out.println("MyQueueListener received: " + tmt);
                
                
                
                // With the ConnectionFactory, establish a Connection, and then a Session on that Connection
            Connection con = cf.createConnection();
            Session session = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
 
            /*
             * You send and receive messages to/from the queue via a session. We
             * want to send, making us a MessageProducer Therefore create a
             * MessageProducer for the session
             */
            MessageProducer writer = session.createProducer(q);
                
            TextMessage msg = session.createTextMessage();
            msg.setText(tmt+" Third  one  haha");
 
            // Send the message to the destination Queue
            writer.send(msg);
 
            // Close the connection
            con.close();     
             
            
            
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
