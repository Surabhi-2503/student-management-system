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
public class upddept extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
           
            out.println("<style>");
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
                out.println(".aa input[type=\"text\"]{");
                    out.println("width:200px;");
                    out.println(" height: 35px;");
                    out.println("border: 0;");
                    out.println("border-radius: 5px;");
                    out.println("padding-left: 5px;");
                    out.println("-webkit-border-radius: 5px;");
                    out.println(" -o-border-radius:5px;");
                    out.println("-moz-border-radius:5px;");
                    out.println("box-shadow: inset 1px -1px black;");
                out.println("}");
                
                
                out.println(".aa input[type=\"submit\"]{");
                  out.println("display: block;");
                  out.println("padding: 12px 30px;");
                  out.println("color:black;");
                  out.println("font-size:15px;");
                  out.println("font-weight: bold;");
                  out.println("border:3px solid transparent;");
                  out.println("border-radius:30px;");
                  out.println("background: linear-gradient(rgba(255,0,0,0.8), rgba(255,0,0,0.5)),radial-gradient(circle at top LEFT,blue,red);");
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
                out.println("background:linear-gradient(#073,#0fa); ");
                out.println(" }");
                 
                
	
            
            
            out.println("</style>");                  
            out.println("</head>");
            
            out.println(" <body style=\"background-image:url(https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTO_q7RpZUd3cyLxk0ZvTnbiY1TTN33_6Os1NQ5LoeqyloeQ1zkAA&s);background-size:cover;\">");
            out.println("<p class=\"heading\"><strong>COLLEGE MANAGEMENT SYSTEM</strong></p>");

            out.println("<ul>");
            out.println("<li><a href=\"admpage\"><font color=\"black\">HOME</font></a></li>");
            out.println("<li class=\"dropdown\">");
            out.println("<a class=\"dropbtn\"><font color=\"black\">ADMINISTRATION</font></a>");
            out.println("<div class=\"dropdown-content\">");
            out.println("  <a href=\"addacc\">ADD ACCOUNTANT</a>");
            out.println(" <a href=\"adddept\">ADD DEPARTMENT</a>");
            out.println(" <a href=\"addcourse\">ADD COURSE</a>");
            out.println("</div>");
            out.println(" </li>");
            out.println("<li class=\"dropdown\">");
            out.println("<a class=\"dropbtn\"><font color=\"black\">DETAILS</font></a>");
            out.println("<div class=\"dropdown-content\">");
            out.println("  <a href=\"viac\">VIEW ACCOUNTANT</a>");
            out.println(" <a href=\"vidpt\">VIEW DEPARTMENT</a>");
            out.println(" <a href=\"vicour\">VIEW COURSE</a>");
            out.println("</div>");
            out.println(" </li>");
            out.println("<li class=\"logout\">");
            out.println(" <a href=\"logout\"><font color=\"black\">LOGOUT</font></a>");
            out.println(" </li>");
            out.println("</ul>");
            
            String AID2=null;
            AID2=request.getParameter("id");
                    if(!AID2.equals(null)&&!AID2.equals("")) 
                    {
                        Class.forName("oracle.jdbc.driver.OracleDriver");
                        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "manager"); 
                        Statement stmt=con.createStatement();
                        ResultSet rs=stmt.executeQuery("select * from Department where dept_id='"+AID2+"' ");
                        while(rs.next())
                        {
                            String DID2=rs.getString("dept_id");
                            String DCODE2=rs.getString("dept_name");
                            String DNAME2=rs.getString("dept_desc");
                            out.println("<p class=\"heading1\">UPDATE DEPARTMENT</p>");
                            out.println("<div class=\"aa\">");
                            out.println("<form method=\"post\">");
                                //out.println("DEPARTMENT ID:<br><input type =\"number\" name=\"deid\" value="+DID2+" required><br>");
                                out.println("DEPARTMENT CODE:<br><input type =\"text\" name=\"dcode\" value="+DCODE2+" required><br>");
                                out.println("DEPARTMENT NAME:<br><textarea rows=\"4\" cols=\"45\" name=\"dname\" required>"+DNAME2+"</textarea><br>");
                                out.println("<br><input type=\"submit\" value=\"UPDATE DEPARTMENT\">");
                            out.println("</form>");           
                            out.println("</div>");
                       
                        //String DID1=request.getParameter("deid");
                        String DCODE=request.getParameter("dcode");
                        String DNAME=request.getParameter("dname");
                        if(!DNAME.equals(null)&&!DNAME.equals("")&&!DCODE.equals(null)&&!DCODE.equals(""))
                        {
                            HttpSession s=request.getSession();
                            s.setAttribute("DID",DID2);
                            s.setAttribute("DCODE1",DCODE);
                            s.setAttribute("DNAME1",DNAME);
                            response.sendRedirect("udptdb");

                        }
                        else{
                                out.println("<script>alert(\"FILL THE DETAILS PROPERLY\")</script>");

                            }
                        
                    con.close();
                    } 
            out.println("</body>");
            out.println("</html>");
        }else{
             out.println("<script>alert(\"no change in the data\")</script>");

                }
        }catch(Exception e){
           // out.println(e);
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
            Logger.getLogger(upddept.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(upddept.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(upddept.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(upddept.class.getName()).log(Level.SEVERE, null, ex);
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
