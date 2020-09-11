/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Surabhi
 */
public class Studentpage extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try  {
            /* TODO output your page here. You may use following sample code. */
             HttpSession p=request.getSession();
            String STUMAIL=(String)p.getAttribute("SID");
          String secsem=(String)p.getAttribute("semsec");

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println(" <style>");
            out.println("p.heading{");
                out.println("text-align:center;");
                out.println("text-shadow:15px 15px 50px blue;");
                out.println("font-weight:bold;");
                out.println("font-family:eGill Sans Extrabold, sans-serif; ");
                out.println("font-size:40px;");
                out.println("font-style:italic;");
                out.println("color:red;");
                out.println("padding-top:5px;");
            out.println("}");
            
             out.println("ul {");
                out.println("list-style-type: none;");
                out.println("margin: 0;");
                out.println(" padding:0;");
                out.println("overflow: hidden;");
                out.println("background-color:rgba(30,144,255,0.2);");
            out.println("}"); 
            out.println("li {");
                out.println("float:left;");
                out.println("}");
                out.println("li a,.dropbtn {");
                out.println("display: inline-block;");
                out.println("text-shadow:2px 2px 5px black;");
                out.println("text-align: center;");
                out.println("padding: 14px 16px;");
                out.println("text-decoration: none;");
                out.println("cursor:pointer;");
            out.println("}");
            out.println("li a:hover, .dropdown:hover .dropbtn {");
                out.println(" background-color:white;");
            out.println("}");
            out.println("li.dropdown {");
                out.println("display: inline-block;");
            out.println("}");
            out.println(".dropdown-content {");
                out.println("display: none;");
                out.println("position: absolute;");
                out.println(" background-color:white;");
                out.println(" min-width: 160px;");
                out.println("box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);");
                out.println(" z-index: 1;");
            out.println("}");
            out.println(".dropdown-content a {");
                out.println("color: black;");
                out.println("padding: 12px 16px;");
                out.println("text-decoration: none;");
                out.println(" display: block;");
                out.println("text-align: left;");
            out.println("}");
            out.println(".dropdown-content a:hover {background-color:rgba(0,0,0,0.5);}");
                out.println(".dropdown:hover .dropdown-content {");
                out.println(" display: block;");
            out.println("}");
            out.println("li.logout{");
                out.println("float:right;");
            out.println("}");
            out.println("li a,.dropbtn {");
                out.println("display: inline-block;");
                out.println("color:white;");
                out.println("text-shadow:2px 2px 5px white;");
                out.println("text-align: center;");
                out.println("padding: 14px 16px;");
                out.println("text-decoration: none;");
             out.println("}");
            out.println(".addacct{");
               
                out.println("margin:25px;");
                out.println("padding:10px;");
                out.println("overflow: hidden;");
                out.println("text-align: center;");
                out.println("border-radius:12px;");                
                //out.println("border-width:medium;");
                

                out.println("text-size:30px;");
                out.println("box-shadow:inset 0 0 10px 0 rgba(0,0,253,0.6);");

            out.println("}");
             out.println(".addacct a{");
                out.println("color:black;");
                out.println("font-size:20px;");
                out.println("text-align: center;");
                out.println("text-shadow:0.5px 0.5px 1px black;");
            out.println("}");
            out.println("</style>"); 
            
            out.println("</head>");
          //  out.println(" <body style=\"background-image:url(data:image/jpeg;base64,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);background-size:cover;\">");
            
 out.println(" <body style=\"background-image:url(https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTO_q7RpZUd3cyLxk0ZvTnbiY1TTN33_6Os1NQ5LoeqyloeQ1zkAA&s);background-size:cover;\">");
 out.println("<p class=\"heading\"><strong>STUDENT MANAGEMENT SYSTEM</strong></p>");
                String STUName=null;
               String STUName1=null;
               String STUName2=null;
               String name=null;
               Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "manager"); 
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from STUDENT11 where SEmail='"+STUMAIL+"' and section_id='"+secsem+"'");
            while(rs.next())
            {
                STUName=rs.getString("First_name");
                STUName1=rs.getString("last_name");
                STUName2=rs.getString("Init");
                 name=STUName+"   "+STUName2+"   "+STUName1;  
            }
            con.close();
                        out.println("<ul>");
                        out.println("<li><a href=\"Studentpage\"><font color=\"black\">HOME</font></a></li>");
                        out.println("<li class=\"dropdown\">");
                            out.println("<a class=\"dropbtn\"><font color=\"black\">ACADEMIC DETAILS</font></a>");
                    out.println("<div class=\"dropdown-content\">");
                            out.println("  <a href=\"viewstuatten\">VIEW ATTENDANCE</a>");
                            out.println(" <a href=\"viewstumarks\">VIEW INTERNAL MARKS</a>");
                           

                    out.println("</div>");
                        out.println(" </li>");
                        out.println("<li class=\"dropdown\">");
                        out.println("<a class=\"dropbtn\"><font color=\"black\">PERSONAL DETAILS</font></a>");
                        out.println("<div class=\"dropdown-content\">");
                            out.println("  <a href=\"viewstusub\">SUBJECT DETAILS </a>");
                            out.println(" <a href=\"viewprsnl\">PERSONL DETAILS</a>");
                            

                            out.println("</div>");
                        out.println(" </li>");
                        out.println("<li class=\"dropdown\">");
                        out.println("<a class=\"dropbtn\"><font color=\"black\">PASSWORD</font></a>");
                        out.println("<div class=\"dropdown-content\">");
                            out.println("  <a href=\"stupasswdchange\">Change Password</a>");
                            out.println("</div>");
                        out.println(" </li>");
                        
                        
                        
                        out.println("<li class=\"logout\">");
                            out.println(" <a href=\"logout\"><font color=\"black\">LOGOUT</font></a>");
                        out.println(" </li>");
                    out.println("</ul>");
                        out.println("<b><h3>WELCOME  "+name+".....!</h3></b>");

 out.println("<div class=\"addacct\">");
    out.println("  <a href=\"viewstuatten\">VIEW ATTENDANCE</a>");
 out.println("</div>");

 out.println("<div class=\"addacct\">");
        out.println(" <a href=\"viewstumarks\">VIEW INTERNAL MARKS</a>");
 out.println("</div>");

 out.println("<div class=\"addacct\">");
    out.println(" <a href=\"viewstusub\">SUBJECT DETAILS </a>");
 out.println("</div>");
 out.println("<div class=\"addacct\">");
        out.println(" <a href=\"viewprsnl\">PERSONL DETAILS</a>");
 out.println("</div>");
 
            out.println("</body>");
            out.println("</html>");
        }catch(Exception e){
        out.println(e);
        
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Studentpage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Studentpage.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Studentpage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Studentpage.class.getName()).log(Level.SEVERE, null, ex);
        }
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
