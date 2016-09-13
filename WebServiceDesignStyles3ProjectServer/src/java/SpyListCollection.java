/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Bilei Huang 
 * This is the servlet that accepts requests from the client and can do operations in
 * the methods below 
 * 
 * 
 */


@WebServlet(name = "SpyListCollection", urlPatterns = {"/SpyListCollection/*"})

public class SpyListCollection extends HttpServlet {
     // the spy list 
    static SpyList sl = SpyList.getInstance();
    
     /**
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * 
     * process the operation of retrieving information of spy and send back to
     * client 
     * 
     * */
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        if (request.getPathInfo() != null) {
            String s = request.getPathInfo().substring(1);

            System.out.println(s);
            if (sl.ifexists(s)) {
                if (request.getHeader("Accept").equals("text/plain")) {
                    out.write("200 OK : " + "Name: " + sl.get(s).getName() + " Title:" + sl.get(s).getTitle() + " Location:"
                            + sl.get(s).getLocation() + " Password:" + sl.get(s).getPassword());
                    out.flush();
                    out.close();
                } else {
                    out.write("200 OK : " + sl.get(s).toXML());
                    out.flush();
                    out.close();
                }

            } else {

                out.write("404 Not Found");
                out.flush();
                out.close();

            }

        } else {
            
            if (request.getHeader("Accept").equals("text/plain")) {
                String outtoclient =sl.toString();
                out.write(outtoclient);
                out.flush();
                out.close();
                
            } else {
//                System.out.println(sl.toXML());
                String outtoclient = sl.toXML();
                out.write(outtoclient);
                out.flush();
                out.close();
            }
        }

    }

    /*
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * 
     *  Process the request and update the spy information 
     * 
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        ServletInputStream is = request.getInputStream();
//        out.println("Bytes available :"+is.available());

        byte[] buffer = new byte[800];
        int len = is.read(buffer);
        byte[] buf = new byte[len];

        for (int i = 0; i < len; i++) {
            buf[i] = buffer[i];
        }

        String Sspy = new String(buf);
//        System.out.println(Sspy);
        SpyMessage sm = new SpyMessage(Sspy);
        System.out.println(Sspy);
        Document spydoc = sm.getDoc();
        spydoc.getDocumentElement().normalize();

        Spy s = new Spy();

        s.setName(spydoc.getElementsByTagName("name").item(0).getTextContent());
        s.setTitle(spydoc.getElementsByTagName("spyTitle").item(0).getTextContent());
        s.setLocation(spydoc.getElementsByTagName("location").item(0).getTextContent());
        s.setPassword(spydoc.getElementsByTagName("password").item(0).getTextContent());
        System.out.println(s.toXML());
        if (sl.ifexists(s)) {
            sl.add(s);
            out.write("200 OK");
            out.flush();
            out.close();
        } else {
            out.write("404 not found");
            out.flush();
            out.close();

        }

    }

    /**
  
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * 
     * Process the request  and delete the spy 
     * */
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.print("I'm here");
        System.out.print(sl.toXML());
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String s = request.getPathInfo().substring(1);
        System.out.println(s);
        if (sl.ifexists(s)) {
            sl.delete(s);
            out.write("200 OK");
            out.flush();
            out.close();
        } else {

            out.write("404 Not found");
            out.flush();
            out.close();

        }

    }

    /**
     *
     * 
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * 
     * Process the request and add the spy information 
     * 
     * */
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        ServletInputStream is = request.getInputStream();
//        out.println("Bytes available :"+is.available());

        byte[] buffer = new byte[800];
        int len = is.read(buffer);
        byte[] buf = new byte[len];

        for(int i = 0; i < len; i++) {
            buf[i] = buffer[i];
        }

        String Sspy = new String(buf);

        SpyMessage sm = new SpyMessage(Sspy);
        System.out.println(Sspy);
        Document spydoc = sm.getDoc();
        spydoc.getDocumentElement().normalize();

        Spy s = new Spy();

        s.setName(spydoc.getElementsByTagName("name").item(0).getTextContent());
        s.setTitle(spydoc.getElementsByTagName("spyTitle").item(0).getTextContent());
        s.setLocation(spydoc.getElementsByTagName("location").item(0).getTextContent());
        s.setPassword(spydoc.getElementsByTagName("password").item(0).getTextContent());
        System.out.println(s.toXML());
        if (sl.ifexists(s)) {

            out.write("405 Method not allowed ");
            out.flush();
            out.close();

        } else {

            sl.add(s);
            out.write("201 Created");
            out.flush();
            out.close();

        }

    }

}
