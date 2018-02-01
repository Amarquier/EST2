package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.persistence.ConnexionMySQL;
import java.sql.Connection;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(3);
    _jspx_dependants.add("/includes/head.jspf");
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"fr\">\n");
      out.write("<head>\n");
      out.write("    <title>Acceuil</title>\n");
      out.write("    ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<meta charset=\"utf-8\">\n");
      out.write("\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, minimum-scale=1, maximum-scale=1\">\n");
      out.write("\n");
      out.write("<meta name=\"apple-mobile-web-app-capable\" content=\"yes\"/>\n");
      out.write("<meta name=\"apple-mobile-web-app-status-bar-style\" content=\"black\"/>\n");
      out.write("<link rel=\"apple-touch-icon\" href=\"images/apple-touch-icon-57x57.png\"/>\n");
      out.write("<link rel=\"apple-touch-icon\" sizes=\"72x72\" href=\"images/apple-touch-icon-72x72.png\"/>\n");
      out.write("<link rel=\"apple-touch-icon\" sizes=\"114x114\" href=\"images/apple-touch-icon-114x114.png\"/>\n");
      out.write("<link rel=\"icon\" href=\"images/apple-touch-icon-57x57.png\" />\n");
      out.write("<link rel=\"stylesheet\" href=\"js/jquery.mobile/jquery.mobile-1.4.5.min.css\">\n");
      out.write("\n");
      out.write("\n");
      out.write("<link rel=\"stylesheet\" href=\"css/themes/discoBlue.css\" />\n");
      out.write("<link rel=\"stylesheet\" href=\"css/themes/themeBlue.min.css\" />\n");
      out.write("<link rel=\"stylesheet\" href=\"css/themes/jquery.mobile.icons.min.css\" />\n");
      out.write("<link rel=\"stylesheet\" href=\"css/disco1.css\">\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\" src=\"js/jquery/jquery-1.11.2.min.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"js/jquery.mobile/jquery.mobile-1.4.5.min.js\"></script>\n");

    Connection con = (Connection) session.getAttribute("con");
    if (con == null)
        con = ConnexionMySQL.newConnexion();
    session.setAttribute("con", con);

      out.write('\n');
      out.write("\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("<div class=\"page\" data-role=\"page\" id=\"homePage\">\n");
      out.write("    <div class=\"header\" data-role=\"header\" data-id=\"main-header\" data-tap-toggle=\"false\" data-theme=\"b\"\n");
      out.write("        data-position=\"fixed\" data-fullscreen=\"true\" style=\"background-color: #4e6c97;\">\n");
      out.write("        <h1>Accueil</h1>\n");
      out.write("        ");
      out.write("<center>\n");
      out.write("    <div data-theme=\"b\">\n");
      out.write("    ");

        com.metier.DiscoSession maSession = (com.metier.DiscoSession)session.getAttribute("maSession");
        
        com.persistence.User user = null;
       
        if (maSession != null) {
            user = maSession.getUser();
            out.print(" " + user.getPseudo());
            for (int nb = 1; nb <= user.getGrade(); nb++) {
                out.print(" <img src='images/star.gif'>");
            }
        }
    
      out.write("\n");
      out.write("</div></center>");
      out.write("\n");
      out.write("    </div>           \n");
      out.write("    <div role=\"main\" class=\"ui-content\">\n");
      out.write("        \n");
      out.write("        <br/><br/>\n");
      out.write("        <h4>Cette application de science participative (crowdsourcing science) va  \n");
      out.write("            vous permettre de découvrir des supernovae.</h4>\n");
      out.write("        <center><div class=\"mesImages\">\n");
      out.write("            <img style=\"border-radius: 8px;  \" \n");
      out.write("                 src=\"images/tuto01.jpg\"/>\n");
      out.write("            <img style=\"border-radius: 8px; padding: 2px;\" \n");
      out.write("                 src=\"images/tuto02.jpg\"/>\n");
      out.write("            </div></center>\n");
      out.write("        <br/>\n");
      out.write("        <p>Si vous en trouvez une, votre nom accompagnera cette découverte !</p>\n");
      out.write("        <p>Si vous êtes novice, nous vous proposons un tutoriel. Car pour vous inscrire, vous devez passer un QCM.</p>\n");
      out.write("        <br/>\n");
      out.write("        <p>AIDE :</p>\n");
      out.write("        <ol>\n");
      out.write("            <li>En tournant votre téléphone à l'horizontale, l'observation des images sera plus facile.</li>\n");
      out.write("            <li>Pour cacher la barre de navigation du navigateur :<br/>\n");
      out.write("            <ul>\n");
      out.write("                <li>Sur IPhone, mettre un signet (bookmark) de ce site sur le bureau.</li>\n");
      out.write("                <li>Sur Androïd, créer un signet (bookmark) du site, puis créer un\n");
      out.write("            raccourci sur l'écran d'accueil par un appui long sur ce signet.</li>\n");
      out.write("            </ul>\n");
      out.write("            </li>\n");
      out.write("        </ol>\n");
      out.write("        <br/>\n");
      out.write("        <center><br/><br/><br/>\n");
      out.write("            <p class=\"mini\">V2.12 - 28 Juin 2016<br/>Développement : BTS SNIR Lycée V. Hugo Colomiers 31\n");
      out.write("            </p>\n");
      out.write("        </center>\n");
      out.write("    </div>\n");
      out.write("    \n");
      out.write("    ");
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"footer\" data-role=\"footer\" data-theme=\"b\" data-tap-toggle=\"false\"\n");
      out.write("            data-id=\"main-footer\" data-position=\"fixed\" data-fullscreen=\"true\">\n");
      out.write("    <div data-role=\"navbar\" data-grid=\"d\">\n");
      out.write("        <ul>\n");
      out.write("            <li><a  style=\"background-color: #4e6c97\" href=\"index.jsp\" id=\"navbarhome\"  data-icon=\"home\" class=\"\">Accueil</a></li>\n");
      out.write("            <li><a  style=\"background-color: #4e6c97\" href=\"disco.jsp\" id=\"navbardisco\" data-icon=\"eye\" class=\"\">Images</a></li>\n");
      out.write("            <li><a  style=\"background-color: #4e6c97\" href=\"tuto1.jsp\" id=\"navbartuto1\" data-icon=\"info\" class=\"\">Tutoriel</a></li>\n");
      out.write("            <li><a  style=\"background-color: #4e6c97\" href=\"compte.jsp\" id=\"navbarcompte\" data-icon=\"user\" class=\"\">Compte</a></li>\n");
      out.write("            <li><a  style=\"background-color: #4e6c97\" href=\"actu.jsp\" id=\"navbaractu\"  data-icon=\"comment\" class=\"\">Actu</a></li>\n");
      out.write("        </ul>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("</div>\n");
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
