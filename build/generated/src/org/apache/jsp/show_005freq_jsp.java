package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class show_005freq_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<script type=\"text/javascript\" src=\"validate.js\"></script>\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"admin_pro.css\" />\n");
      out.write("<title>Admin</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    \n");
      out.write("    ");

            String display[][]=(String[][])session.getAttribute("table");
            String r=(String)session.getAttribute("row");
            int row=Integer.parseInt(r);
    
      out.write("\n");
      out.write("    \n");
      out.write("    \n");
      out.write("<form action=\"logout\" method=\"post\" align=\"right\">\n");
      out.write("<input type=\"submit\" value=\"Logout\">\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("\n");
      out.write("<table cellpadding=\"0\" width=\"70%\" align=\"center\" cellspacing=\"0\">\n");
      out.write("<th>\n");
      out.write("<td><form action=\"admin.jsp\" align=\"center\">\n");
      out.write("<input type=\"submit\" value=\"Profile\">\n");
      out.write("</form></td>\n");
      out.write("<td><form action=\"ViewMark\" align=\"center\">\n");
      out.write("<input type=\"submit\" value=\"View Marks\" name=\"btViewMark\">\n");
      out.write("</form></td>\n");
      out.write("<td><form action=\"setMark\" align=\"center\">\n");
      out.write("<input type=\"submit\" value=\"Submit Marks\" name=\"btSetMark\">\n");
      out.write("</form></td>\n");
      out.write("<td><form action=\"ResultViewAdmin\" align=\"center\">\n");
      out.write("<input type=\"submit\" value=\"View Result\" name=\"btResultYear\">\n");
      out.write("</form></td>\n");
      out.write("<td><form action=\"regDelete\" align=\"center\">\n");
      out.write("<input type=\"submit\" value=\"Delete Registration\" name=\"btDelete\">\n");
      out.write("</form></td>\n");
      out.write("<td><form action=\"form2.html\" align=\"center\">\n");
      out.write("<input type=\"submit\" value=\"Registration\">\n");
      out.write("</form></td>\n");
      out.write("</table>\n");
      out.write("\n");
      out.write("<table cellpadding=\"2\" width=\"70%\" height=\"100%\" align=\"center\" cellspacing=\"2\" class=\"main\">\n");
      out.write("\n");
      out.write("    <tr><td align=\"right\" colspan=\"4\"><form action=\"edit_admin.jsp\">\n");
      out.write("     <input type=\"submit\" value=\"Edit\">   \n");
      out.write(" </form></td></tr>\n");
      out.write("\n");
      out.write("<tr><td align=\"center\" colspan=\"3\"><font color=\"#D8D8D8\" size=\"10\">Welcome\n");
      out.write("        ");

            out.print(" "+display[0][1]);
        
      out.write("\n");
      out.write("        \n");
      out.write("</font></td></tr>\n");
      out.write("\n");
      out.write("    <tr><td><br></td></tr><tr><td><br></td></tr>\n");
      out.write("  \n");

for(int i=1;i<row;i++){


      out.write("    \n");
      out.write("    \n");
      out.write("<tr>\n");
      out.write("    <td align=\"center\" width=\"50%\"><font color=\"FFCC66\" size=\"5\">");
out.print(""+display[i][0]);
      out.write("</font></td>\n");
      out.write("    \n");
      out.write("    <td align=\"center\" width=\"50%\"><font color=\"FFCC66\" size=\"5\">\n");
      out.write("        ");

            out.print(""+display[i][1]);
        
      out.write("\n");
      out.write("        \n");
      out.write("    </font></td>\n");
      out.write("</tr>\n");
}
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("</table>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
