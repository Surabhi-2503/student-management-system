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
public class stuviewmarks extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
             out.println("<style>");
           
             
            
            out.println("table.label {");
                out.println("margin:0 auto;"); 
                out.println("font-family: verdana,arial,sans-serif;");
                out.println("font-size:15px;");
                out.println("color:solid black;");
                out.println("border-width: 3px;");
                out.println("border-collapse: collapse;");
            out.println("}");
            out.println("table.label th {");
                out.println("border-width:2px;");
                out.println("padding:15px;");
                out.println("border-style:dashed;");
                out.println("border-color: blue;");
                out.println("background-color: pink;");
            out.println("}");
            out.println(" table.label td {");
                out.println("border-width: 2px;");
                out.println("padding: 8px;");
                out.println("border-style: solid;");
                out.println("border-color: #666666;");
                out.println("background-color: #ffffff;");
            out.println("}");
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
             out.println("p.heading1{");
                out.println("text-align:center;");
                out.println("text-shadow:15px 15px 50px black;");
                out.println("font-weight:bold;");
                out.println("font-family:eGill Sans Extrabold, sans-serif; ");
                out.println("font-size:30px;");
                out.println("font-style:italic;");
                out.println("color:blue;");
                out.println("padding-top:2px;");
            out.println("}");
            out.println(".aa input[type=\"text\"]{");
                   out.println("width:200px;");
                    out.println(" height: 35px;");
                    out.println("border: 0;");
                    out.println("border-radius: 5px;");
                    out.println("padding-left: 5px;");
                    out.println("padding-top:5px;");
                    out.println("-webkit-border-radius: 5px;");
                    out.println(" -o-border-radius:5px;");
                    out.println("-moz-border-radius:5px;");
                out.println("}");
                 out.println(".aa input[type=\"password\"]{");
                   out.println("width:200px;");
                    out.println(" height: 35px;");
                    out.println("border: 0;");
                    out.println("border-radius: 5px;");
                    out.println("padding-left: 5px;");
                    out.println("padding-top:5px;");
                    out.println("-webkit-border-radius: 5px;");
                    out.println(" -o-border-radius:5px;");
                    out.println("-moz-border-radius:5px;");
                out.println("}");
            
            out.println(".aa{"); 
                out.println("  width:450px;"); 
                out.println(" height:auto;"); 
                out.println("background-color:rgba(30,144,255,0.2);"); 
                out.println("margin:0 auto;"); 
                out.println("margin-top:20px;"); 
                out.println("padding-top: 20px;"); 
                out.println("padding-left: 50px;");
                out.println("padding-bottom: 40px;");
                out.println("border-radius: 15px;");
                out.println(" border:2px  transparent;");
                out.println("border-style:dotted;");
                out.println("-o-border-radius:30px;");
                out.println(" -moz-border-radius:30px;");
                out.println("color:black;");
                out.println("text-shadow:1px 1px 0.5px black;");
                out.println("font-weight:bold;");
                out.println("font-size: 18px;");
                out.println("box-shadow: inset 4px  -4px black;");
            out.println("}"); 
                  out.println("select {");
                out.println("width:200px;");
                out.println("padding:15px;");
                out.println("margin-top:5px;");
                out.println("font-family:eGill Sans Extrabold, sans-serif; ");
                out.println("line-height:1;");
                out.println("border-radius:8px;");
                out.println("background-color:white;");
                out.println("color:black;");
                out.println("font-size:18px;");
                out.println("-webkit-appearance:none;");
                out.println("box-shadow:inset 0 0 10px 0 rgba(0,0,253,0.6);");
            out.println("}");
            out.println("select:hover {");
                out.println("color:black");
            out.println("}");
                        out.println(".aa input[type=\"submit\"]{");
                  out.println("display: block;");
                  out.println("padding: 12px 30px;");
                  out.println("color:white;");
                  out.println("font-size:15px;");
                  out.println("font-weight: bold;");
                  out.println("border:3px solid transparent;");
                  out.println("border-radius:30px;");
                  out.println("background: linear-gradient(rgba(0,0,255,0.3), rgba(0,0,255,0.5)),radial-gradient(circle at top LEFT,red,green);");
                  out.println("background-origin: border-box;");
            
                  out.println("box-shadow: inset 0px 1px 4px -2px #333;;");
                out.println(" }");
                
                out.println(".aa input[type=\"submit\"]:after{");
	out.println("content: '';");
	out.println("position: absolute;");
	out.println("top: 2px;");
	out.println("left: 2px;");
	out.println("width: calc(100% - 4px);");
	out.println("height: 50%;");
	
         out.println(" }");       
               out.println(".aa input[type=\"submit\"]:hover{");
                out.println("background:linear-gradient(#00bfff,#00ff80); ");
                out.println(" }");
           out.println(".aaa{");
                out.println("padding-top:5px;");
                out.println("color:red;");
                out.println("text-shadow:2px 2px 4px blue;");
                out.println("font-weight:bold;");
                out.println("font-size: 18px;");

           out.println("}");
            out.println("</style>");
            out.println("</head>");
            out.println(" <body style=\"background-image:url(https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTO_q7RpZUd3cyLxk0ZvTnbiY1TTN33_6Os1NQ5LoeqyloeQ1zkAA&s);background-size:cover;\">");
                out.println("<p class=\"heading\"><strong>STUDENT MANAGEMENT SYSTEM</strong></p>");
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

             out.println("<p class=\"heading1\">VIEW ATTENDANCE</p>");
                out.println("<div class=\"aa\">");
                    out.println("<form method=\"post\">");
                            out.println("USN:<br><input type =\"text\" name=\"SUSNS\" placeholder=\"eg:1PM23CS908\" required><br>");
                              Class.forName("oracle.jdbc.driver.OracleDriver");
            
            Connection con2=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "manager"); 
                        Statement stmt2=con2.createStatement();
                        ResultSet rs2=stmt2.executeQuery("select * from section order by id1");
                        out.println(" <br>SECTION<br><select name=\"sec\" required>");
                        while(rs2.next())
                        {
                            out.println("<option value="+rs2.getString("secid")+">"+rs2.getString("secid")+"</option>");
                        }
                        out.println("</select><br>");
                        con2.close();
                      out.println("USN:<br><input type =\"password\" name=\"Spass\" placeholder=\"eg:1P123\" required><br>");


                        out.println("<br><input type=\"submit\" value=\"CHECK ATTENDANCE\">");
                    out.println("</form>");           
                out.println("</div>");
            String ssusn=request.getParameter("SUSNS");
            String semsec1=request.getParameter("sec");
            String spasswd=request.getParameter("Spass");

                        if(!semsec1.equals(null)&&!semsec1.equals("")&&!ssusn.equals(null)&&!ssusn.equals(""))
                        {
                            HttpSession s=request.getSession();
                            s.setAttribute("usns",ssusn);
                            s.setAttribute("sems",semsec1);
                            s.setAttribute("psd",spasswd);

                            response.sendRedirect("viewstumarks");

                        }else{
                     out.println("<script>alert(\"FILL THE DETAILS PROPERLY\")</script>");

                        }
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(stuviewmarks.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(stuviewmarks.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(stuviewmarks.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(stuviewmarks.class.getName()).log(Level.SEVERE, null, ex);
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
