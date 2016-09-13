package HackLab;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "HackLab", urlPatterns = {"/HackLab"})
public class HackLab extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ComputeHashes</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ComputeHashes at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get username and password supplied by the user
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        String view = "index.jsp";

        // If no username or password was entered, return an error message                                                                                                                            
        if (username.isEmpty() || password.isEmpty()) {
            request.setAttribute("error", "Error! Both fields are required");
            dispatchView(request, response, view);
            return;
        }

        
        // Create the model 
        HackLabModel model = new HackLabModel(username, password);

        // Set the login message to be sent to the vie
        if (model.errorOccured()) {
            request.setAttribute("error", model.getLoginError());
        } else {
            view = "home.jsp";
        }

        // Dispatch View
        dispatchView(request, response, view);
    }

    /**
     * function to dispatch the view
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void dispatchView(HttpServletRequest request, HttpServletResponse response, String viewPage) throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher(viewPage);
        view.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        dispatchView(request, response, "index.jsp");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
