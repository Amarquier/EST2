package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.persistence.Utils;
import com.persistence.Actu;
import com.persistence.ConnexionMySQL;
import java.sql.Connection;

public final class actu_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(4);
    _jspx_dependants.add("/includes/head.jspf");
    _jspx_dependants.add("/includes/session.jspf");
    _jspx_dependants.add("/includes/user.jspf");
    _jspx_dependants.add("/includes/footer.jspf");
  }

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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"fr\">\r\n");
      out.write("<head>\r\n");
      out.write("    <title>Actualités</title>\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, minimum-scale=1, maximum-scale=1\">\r\n");
      out.write("\r\n");
      out.write("<meta name=\"apple-mobile-web-app-capable\" content=\"yes\"/>\r\n");
      out.write("<meta name=\"apple-mobile-web-app-status-bar-style\" content=\"black\"/>\r\n");
      out.write("<link rel=\"apple-touch-icon\" href=\"images/apple-touch-icon-57x57.png\"/>\r\n");
      out.write("<link rel=\"apple-touch-icon\" sizes=\"72x72\" href=\"images/apple-touch-icon-72x72.png\"/>\r\n");
      out.write("<link rel=\"apple-touch-icon\" sizes=\"114x114\" href=\"images/apple-touch-icon-114x114.png\"/>\r\n");
      out.write("<link rel=\"icon\" href=\"images/apple-touch-icon-57x57.png\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"js/jquery.mobile/jquery.mobile-1.4.5.min.css\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/themes/EVT.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/themes/jquery.mobile.icons.min.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/EST1.css\">\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/jquery/jquery-1.11.2.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/jquery.mobile/jquery.mobile-1.4.5.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"page\" data-role=\"page\" id=\"actuPage\">\r\n");
      out.write("    <div class=\"header\" data-role=\"header\" data-id=\"main-header\" data-tap-toggle=\"false\" \r\n");
      out.write("        data-theme=\"a\" data-position=\"fixed\" data-fullscreen=\"true\">\r\n");
      out.write("        <h1>Actualités</h1>\r\n");
      out.write("        ");
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    ");

        Connection con = (Connection) session.getAttribute("con");
        if (con == null)
            con = ConnexionMySQL.newConnexion();
        session.setAttribute("con", con);
        com.metier.ESTSession maSession = (com.metier.ESTSession)session.getAttribute("maSession");
        com.persistence.User user = null;
        if (maSession != null) {
            user = maSession.getUser();
        }
        
    
      out.write("\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<center><div data-theme=\"a\">\r\n");
      out.write("    ");
     
        com.metier.ESTSession maSession1 = (com.metier.ESTSession)session.getAttribute("maSession");
        
        // user doit être déjà initialisé include session.jspf
        if (maSession1 != null) {
            com.persistence.User user1 = maSession1.getUser();
            out.println("<div id='divUser'>" + user1.getPseudo());
            for (int nb = 1; nb <= user1.getGrade(); nb++) {
                out.print(" <img src='images/star.gif'>");
            }
            out.println("</div>");
        }
        
    
      out.write("\r\n");
      out.write("</div></center>");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("    \r\n");
      out.write("    <div role=\"main\" class=\"ui-content\">\r\n");
      out.write("        <br/><br/><br/>\r\n");
      out.write("        <div data-role=\"collapsibleset\" data-corners=\"false\" data-theme=\"a\" \r\n");
      out.write("             data-content-theme=\"a\" data-mini=\"true\">\r\n");
      out.write("            ");

                int nbActus = Actu.size(con);
                for (int i = 1; i <= nbActus; i++) {
                    Actu actu = Actu.find(con, i);
                    out.println("<div data-role='collapsible' data-collapsed-icon='carat-d' "
                                       + "class='ui-alt-icon' data-expanded-icon='carat-u'>");
                    out.print("<h4>");
                    out.print(Utils.formatDate(actu.getDate()) + " - " + actu.getTitre());
                    out.println("</h4>");
                    out.print("<p>");
                    out.print(actu.getContenu());
                    out.println("</p>");
                    out.println("</div>");
                }
            
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"footer\" data-role=\"footer\" data-theme=\"a\" data-tap-toggle=\"false\"\r\n");
      out.write("            data-id=\"main-footer\" data-position=\"fixed\" data-fullscreen=\"true\">\r\n");
      out.write("    <div data-role=\"navbar\" data-grid=\"d\">\r\n");
      out.write("        <ul>\r\n");
      out.write("            <li><a  style=\"background-color: #015550\" href=\"index.jsp\" id=\"navbarhome\"  data-icon=\"home\" class=\"\">Accueil</a></li>\r\n");
      out.write("            <li><a  style=\"background-color: #015550\" href=\"qualifier.jsp\" id=\"navbarEST\" data-ajax=\"false\" data-icon=\"eye\" class=\"\">Images</a></li>\r\n");
      out.write("            <li><a  style=\"background-color: #015550\" href=\"tuto.jsp\" data-ajax=\"false\" id=\"navbartuto1\" data-icon=\"info\" class=\"\">Tutoriel</a></li>\r\n");
      out.write("            <li><a  style=\"background-color: #015550\" href=\"compte.jsp\" id=\"navbarcompte\" data-icon=\"user\" class=\"\">Compte</a></li>\r\n");
      out.write("            <li><a  style=\"background-color: #015550\" href=\"actu.jsp\" id=\"navbaractu\"  data-icon=\"comment\" class=\"\">Actu</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
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
