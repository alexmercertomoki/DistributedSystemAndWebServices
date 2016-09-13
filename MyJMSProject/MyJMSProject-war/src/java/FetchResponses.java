/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mac
 */
@WebServlet(urlPatterns = {"/FetchResponses"})
public class FetchResponses extends HttpServlet {
// Lookup the ConnectionFactory using resource injection and assign to cf

    @Resource(lookup = "JMI/MyConnectionFactory")
    private ConnectionFactory cf;
// lookup the Queue using resource injection and assign to q
    @Resource(lookup = "jms/myQueueThree")
    private Queue q;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // With the ConnectionFactory, establish a Connection, and then a Session on that Connection
        Connection con = null;
        try {
            con = cf.createConnection();
        } catch (JMSException ex) {
            Logger.getLogger(FetchResponses.class.getName()).log(Level.SEVERE, null, ex);
        }
        Session session = null;
        try {
            session = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
        } catch (JMSException ex) {
            Logger.getLogger(FetchResponses.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con.start(); // Be sure to start to connection!
        } catch (JMSException ex) {
            Logger.getLogger(FetchResponses.class.getName()).log(Level.SEVERE, null, ex);
        }
        MessageConsumer reader = null;
        try {
            reader = session.createConsumer(q);
        } catch (JMSException ex) {
            Logger.getLogger(FetchResponses.class.getName()).log(Level.SEVERE, null, ex);
        }
        TextMessage tm = null;
        try {
            while ((tm = (TextMessage) reader.receive(1000)) != null) {
                // Do something with tm.getText()
                PrintWriter out = response.getWriter();
//                System.out.println();
                out.print("Message "+tm.getText()+" got");
            }
        } catch (JMSException ex) {
            Logger.getLogger(FetchResponses.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            // Close the connection
            con.close();
        } catch (JMSException ex) {
            Logger.getLogger(FetchResponses.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}