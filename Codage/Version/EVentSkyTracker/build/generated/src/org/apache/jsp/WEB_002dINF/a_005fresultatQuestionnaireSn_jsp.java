package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import com.metier.*;
import com.persistence.*;
import com.persistence.ConnexionMySQL;
import java.sql.Connection;

public final class a_005fresultatQuestionnaireSn_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(5);
    _jspx_dependants.add("/WEB-INF/../includes/a_head.jspf");
    _jspx_dependants.add("/WEB-INF/../includes/session.jspf");
    _jspx_dependants.add("/WEB-INF/../includes/a_user.jspf");
    _jspx_dependants.add("/WEB-INF/../includes/espace.jspf");
    _jspx_dependants.add("/WEB-INF/../includes/a_footer.jspf");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"fr\">\r\n");
      out.write("    <head>\r\n");
      out.write("        <title>Images</title>\r\n");
      out.write("        ");
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
      out.write("<link rel=\"stylesheet\" href=\"css/themes/ESTRed.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/themes/jquery.mobile.icons.min.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/EST1.css\">\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/jquery/jquery-1.11.2.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/jquery.mobile/jquery.mobile-1.4.5.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("        <div class=\"page\" data-role=\"page\" id=\"discoPage\" data-theme=\"a\">\r\n");
      out.write("            <div class=\"header\" data-role=\"header\" data-id=\"main-header\" data-tap-toggle=\"false\" \r\n");
      out.write("                data-theme=\"b\" data-position=\"fixed\" data-fullscreen=\"true\">\r\n");
      out.write("                <h1>Valider</h1>\r\n");
      out.write("                ");
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
      out.write("                ");
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("<div data-theme=\"b\">\r\n");
      out.write("    <center>\r\n");
      out.write("    ");

        com.metier.ESTSession maSessionA = (com.metier.ESTSession)session.getAttribute("maSession");
       
        if (maSessionA != null) {
            com.persistence.User userA = maSessionA.getUser();
            out.print(" " + userA.getPseudo());
            for (int nb = 1; nb <= userA.getGrade(); nb++) {
                out.print(" <img src='images/star.gif'>");
            }
        }
    
      out.write("\r\n");
      out.write("    </center>\r\n");
      out.write("</div>");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("        \r\n");
      out.write("\r\n");
      out.write("        <div role=\"main\" class=\"ui-content \">\r\n");
      out.write("            <script type=\"text/javascript\" src=\"js/a_candidates.js\"></script>\r\n");
      out.write("            ");

                int i=1;
                User userDisco = null;
                int totalSize = 0; 
                        
                String idMove = request.getParameter("idMove");
                if (idMove != null) {
                    i = Integer.parseInt(idMove);
                }
                CandidateSN can = CandidateSN.find(con, i);
                if (can == null) {
            
      out.write("\r\n");
      out.write("            ");
      out.write("\n");
      out.write("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
      out.write("\r\n");
      out.write("            <div>Pas de candidate</div>\r\n");
      out.write("            <br>\r\n");
      out.write("            <br>\r\n");
      out.write("            <center> Pas de candidate </center>\r\n");
      out.write("        </div>\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"footer\" data-role=\"footer\" data-theme=\"b\" data-tap-toggle=\"false\"\r\n");
      out.write("            data-id=\"main-footer\" data-position=\"fixed\" data-fullscreen=\"true\">\r\n");
      out.write("    <div data-role=\"navbar\" data-grid=\"c\">\r\n");
      out.write("        <ul>\r\n");
      out.write("            <li><a  style=\"background-color: #AD192B\" href=\"eventSkyTracker.jsp?action=a_resultatQuestionnaireAccueil\" data-ajax=\"false\" id=\"navbarhome\"  data-icon=\"check\">Qualifier</a></li>\r\n");
      out.write("            <li><a  style=\"background-color: #AD192B\" href=\"eventSkyTracker.jsp?action=a_gestion\" data-ajax=\"false\" id=\"navbartuto1\" data-icon=\"edit\">Gestion</a></li>\r\n");
      out.write("            <li><a  style=\"background-color: #AD192B\" href=\"eventSkyTracker.jsp?action=a_compte\" data-ajax=\"false\" id=\"navbarcompte\" data-icon=\"user\">Compte</a></li>\r\n");
      out.write("            <li><a  style=\"background-color: #AD192B\" href=\"eventSkyTracker.jsp?action=a_actu\" data-ajax=\"false\" id=\"navbaractu\"  data-icon=\"comment\">Actu</a></li>\r\n");
      out.write("            \r\n");
      out.write("        </ul>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("            ");

                }
                else {
                    userDisco = User.getByPseudo(con, can.getUserPseudo());
                    totalSize = CandidateSN.size(con);
            
      out.write("\r\n");
      out.write("            \r\n");
      out.write("            \r\n");
      out.write("            <input type=\"hidden\" id=\"i\" value=\"");
      out.print(i);
      out.write("\"/>\r\n");
      out.write("            <input type=\"hidden\" id=\"cX\" value=\"");
      out.print(can.getX());
      out.write("\"/>\r\n");
      out.write("            <input type=\"hidden\" id=\"cY\" value=\"");
      out.print(can.getY());
      out.write("\"/>\r\n");
      out.write("            <input type=\"hidden\" id=\"nomGal\" value=\"");
      out.print(can.getNomImage());
      out.write("\"/>\r\n");
      out.write("            ");
 String tabTele[] = can.getChemin().split("/");
      out.write("\r\n");
      out.write("            <input type=\"hidden\" id=\"nomTele\" value=\"");
      out.print(tabTele[2]);
      out.write("\"/>\r\n");
      out.write("            <br/><br/><br/>\r\n");
      out.write("            <div class=\"mesImages\" align=\"center\">\r\n");
      out.write("                <canvas style=\"position:absolute;\" id=\"canvasObs\" ></canvas>\r\n");
      out.write("                <img name=\"imgobs\" id=\"imgobs\" alt=\"erreur:image absente\" src=\"");
      out.print(can.getChemin()+can.getNomImage());
      out.write(".jpg\">\r\n");
      out.write("                <img id=\"imgref\" alt=\".... aucune référence ....\" sr  c=\"/jpeg/refgal/");
      out.print(can.getNomImage());
      out.write(".jpg\">\r\n");
      out.write("            </div>\r\n");
      out.write("            <table class=\"infosTable\">\r\n");
      out.write("                <td class=\"texteCentre\" id=\"dateImages\">");
      out.print(can.getDateDisco());
      out.write("</td>\r\n");
      out.write("                <td class=\"texteCentre\" id=\"numImages\" >(");
      out.print(i);
      out.write('/');
      out.print(CandidateSN.size(con));
      out.write(")</td>\r\n");
      out.write("                <td class=\"texteCentre\" id=\"nomGalaxie\">");
      out.print(can.getNomImage());
      out.write("</td>\r\n");
      out.write("            </table>\r\n");
      out.write("            <table class=\"infosTable\">\r\n");
      out.write("                <td class=\"texteCentre\" id=\"certitude\">Degré de certitude : ");
      out.print(can.getCertitude());
      out.write("/5</td>\r\n");
      out.write("            </table>\r\n");
      out.write("            \r\n");
      out.write("            <div align=\"center\">\r\n");
      out.write("                <div class=\"ui-grid-a\">\r\n");
      out.write("                    <div class=\"ui-block-a\">\r\n");
      out.write("                        ");

                        if(i>1){
                        
      out.write("\r\n");
      out.write("                        <a href=\"discovery.jsp?action=a_can&idMove=");
      out.print(i-1);
      out.write("\" data-ajax=\"false\" \r\n");
      out.write("                           id=\"btnPcdt\" data-icon=\"arrow-l\" data-iconpos=\"left\" data-role=\"button\">\r\n");
      out.write("                            Précédent\r\n");
      out.write("                        </a>\r\n");
      out.write("                        ");
}
                        else{
      out.write("\r\n");
      out.write("                        <a href=\"#\" id=\"btnPcdt\" data-icon=\"arrow-l\" data-iconpos=\"left\" \r\n");
      out.write("                           class=\"ui-state-disabled\" data-role=\"button\">\r\n");
      out.write("                            Précédent\r\n");
      out.write("                        </a>  \r\n");
      out.write("                        ");
}
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"ui-block-b\">\r\n");
      out.write("                        ");

                        if (i+1 > totalSize) { 
      out.write("\r\n");
      out.write("                        <a href=\"#\" id=\"btnSvt\" data-icon=\"arrow-r\" data-iconpos=\"right\" \r\n");
      out.write("                             class=\"ui-state-disabled\" data-role=\"button\">\r\n");
      out.write("                            Suivant\r\n");
      out.write("                        </a>\r\n");
      out.write("                        ");
}
                        else{
      out.write("\r\n");
      out.write("                        <a href=\"discovery.jsp?action=a_can&idMove=");
      out.print(i+1);
      out.write("\" data-ajax=\"false\" id=\"btnSvt\" data-icon=\"arrow-r\" data-iconpos=\"right\" \r\n");
      out.write("                             data-role=\"button\">\r\n");
      out.write("                            Suivant\r\n");
      out.write("                        </a>\r\n");
      out.write("                        ");
}
                        
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"ui-grid-a\">\r\n");
      out.write("                <div class=\"ui-block-a\">\r\n");
      out.write("                    <a onclick=\"afficheHisto()\" href=\"#popupHisto\" id=\"btnHisto\" data-rel=\"popup\" data-position-to=\"window\" \r\n");
      out.write("                    class=\"ui-btn ui-corner-all ui-shadow\">\r\n");
      out.write("                        Histo\r\n");
      out.write("                    </a>\r\n");
      out.write("                </div>   \r\n");
      out.write("                <div class=\"ui-block-b\">\r\n");
      out.write("                    <a onclick=\"afficheInfos()\" href=\"#popupInfos\" id=\"btnInfos\" data-rel=\"popup\" data-position-to=\"window\" \r\n");
      out.write("                    class=\"ui-btn ui-corner-all ui-shadow\">\r\n");
      out.write("                        Infos\r\n");
      out.write("                    </a>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"ui-grid-b\">\r\n");
      out.write("                    <div class=\"ui-block-a\" style=\"text-align:center;\">\r\n");
      out.write("                        Proposé par : ");
      out.print(can.getUserPseudo());
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"ui-block-b\" style=\"text-align:center;\">\r\n");
      out.write("                    ");

                        for (int nb = 1; nb <= user.getGrade(); nb++) {
                        out.print(" <img src='images/star.gif'>");
                        }
                    
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"ui-block-c\" style=\"text-align:center;\">\r\n");
      out.write("                        Le : ");

                            SimpleDateFormat type = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            java.util.Date date = type.parse(can.getDateDecouverte());
                            SimpleDateFormat convert = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                            String dateDisco = convert.format(date).toString();
                        
      out.write("    \r\n");
      out.write("                        ");
      out.print(dateDisco);
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <br/>\r\n");
      out.write("            <center>\r\n");
      out.write("\r\n");
      out.write("            </center> \r\n");
      out.write("            <br/>\r\n");
      out.write("            <div class=\"ui-grid-a\">\r\n");
      out.write("                <div class=\"ui-block-a\">               \r\n");
      out.write("                    <a href=\"#popupValider\" data-rel=\"popup\" data-position-to=\"window\"\r\n");
      out.write("                   data-role=\"button\"  data-transition=\"pop\">\r\n");
      out.write("                        Valider\r\n");
      out.write("                    </a>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"ui-block-b\">\r\n");
      out.write("                    <a href=\"#popupRefuser\" data-rel=\"popup\" data-position-to=\"window\"\r\n");
      out.write("                   data-role=\"button\"  data-transition=\"pop\">\r\n");
      out.write("                        Refuser\r\n");
      out.write("                    </a>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"footer\" data-role=\"footer\" data-theme=\"b\" data-tap-toggle=\"false\"\r\n");
      out.write("            data-id=\"main-footer\" data-position=\"fixed\" data-fullscreen=\"true\">\r\n");
      out.write("    <div data-role=\"navbar\" data-grid=\"c\">\r\n");
      out.write("        <ul>\r\n");
      out.write("            <li><a  style=\"background-color: #AD192B\" href=\"eventSkyTracker.jsp?action=a_resultatQuestionnaireAccueil\" data-ajax=\"false\" id=\"navbarhome\"  data-icon=\"check\">Qualifier</a></li>\r\n");
      out.write("            <li><a  style=\"background-color: #AD192B\" href=\"eventSkyTracker.jsp?action=a_gestion\" data-ajax=\"false\" id=\"navbartuto1\" data-icon=\"edit\">Gestion</a></li>\r\n");
      out.write("            <li><a  style=\"background-color: #AD192B\" href=\"eventSkyTracker.jsp?action=a_compte\" data-ajax=\"false\" id=\"navbarcompte\" data-icon=\"user\">Compte</a></li>\r\n");
      out.write("            <li><a  style=\"background-color: #AD192B\" href=\"eventSkyTracker.jsp?action=a_actu\" data-ajax=\"false\" id=\"navbaractu\"  data-icon=\"comment\">Actu</a></li>\r\n");
      out.write("            \r\n");
      out.write("        </ul>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <!-- POP UP-->\r\n");
      out.write("\r\n");
      out.write("        <!-- popup infos -->\r\n");
      out.write("        <div id=\"popupInfos\" data-role=\"popup\" data-theme=\"a\" data-overlay-theme=\"b\"\r\n");
      out.write("             class=\"ui-corner-all ui-alt-icon\" data-corners=\"true\" data-position-to=\"window\">\r\n");
      out.write("            <a href=\"#\" data-rel=\"back\" class=\"ui-btn ui-corner-all ui-shadow \r\n");
      out.write("                 ui-btn-a ui-icon-delete ui-btn-icon-notext ui-btn-right\">\r\n");
      out.write("                Fermer\r\n");
      out.write("            </a>\r\n");
      out.write("            <div class=\"mesPopups\">\r\n");
      out.write("                <h3 id=\"nomInfos\">Nom:</h3>\r\n");
      out.write("                <label id=\"catInfos\">Catégorie:</label>\r\n");
      out.write("                <label id=\"textInfos\">Informations:</label>\r\n");
      out.write("                <label id=\"nbNovInfos\">Supernovae découvertes:</label>\r\n");
      out.write("                <label id=\"adrInfos\">Ascension droite (degré):</label>\r\n");
      out.write("                <label id=\"decInfos\">Déclinaison (degré):</label>\r\n");
      out.write("                <label id=\"distInfos\">Distance (mal):</label>\r\n");
      out.write("                <label id=\"magInfos\">Magnitude:</label>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <!-- popup blink -->\r\n");
      out.write("        <div id=\"popupBlink\" data-role=\"popup\" data-theme=\"a\" data-overlay-theme=\"b\"\r\n");
      out.write("               class=\"ui-corner-all ui-alt-icon\" data-corners=\"true\" data-position-to=\"window\">\r\n");
      out.write("            <a href=\"#\" data-rel=\"back\" class=\"ui-btn ui-corner-all ui-shadow \r\n");
      out.write("                 ui-btn-a ui-icon-delete ui-btn-icon-notext ui-btn-right\">\r\n");
      out.write("                Fermer\r\n");
      out.write("            </a>\r\n");
      out.write("            <div class=\"mesPopups\">\r\n");
      out.write("                <h3 id=\"nomBlink\"></h3>\r\n");
      out.write("                <div>\r\n");
      out.write("                    <img id=\"imgBlink\" src=\"images/black.jpg\"/>\r\n");
      out.write("                </div>\r\n");
      out.write("                <br/>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <!-- popup Historique -->\r\n");
      out.write("        <div id=\"popupHisto\" data-role=\"popup\" data-theme=\"a\"\r\n");
      out.write("               class=\"ui-corner-all ui-alt-icon\" data-corners=\"true\" data-position-to=\"window\">\r\n");
      out.write("            <a href=\"#\" data-rel=\"back\" class=\"ui-btn ui-corner-all ui-shadow \r\n");
      out.write("                 ui-btn-a ui-icon-delete ui-btn-icon-notext ui-btn-right\">\r\n");
      out.write("                Fermer\r\n");
      out.write("            </a>\r\n");
      out.write("            <div>\r\n");
      out.write("                <h3 id=\"nomHisto\"></h3>\r\n");
      out.write("                <div id=\"imgHisto\">\r\n");
      out.write("                    <div>\r\n");
      out.write("                        <img id=\"imgHisto1\" src=\"images/black.jpg\"/>\r\n");
      out.write("                        <img id=\"imgHisto2\" src=\"images/black.jpg\"/>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div>\r\n");
      out.write("                        <img id=\"imgHisto3\" src=\"images/black.jpg\"/>\r\n");
      out.write("                        <img id=\"imgHisto4\" src=\"images/black.jpg\"/>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div>\r\n");
      out.write("                        <img id=\"imgHisto5\" src=\"images/black.jpg\"/>\r\n");
      out.write("                        <img id=\"imgHisto6\" src=\"images/black.jpg\"/>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <!-- popup valider -->\r\n");
      out.write("        <div id=\"popupValider\" data-role=\"popup\" data-theme=\"a\" data-overlay-theme=\"b\"\r\n");
      out.write("             class=\"ui-corner-all\" data-corners=\"true\" data-position-to=\"window\">\r\n");
      out.write("            <a href=\"#\" data-rel=\"back\" class=\"ui-btn ui-corner-all ui-shadow\r\n");
      out.write("               ui-btn-a ui-icon-delete ui-btn-icon-notext ui-btn-right\" style=\"background-color:black;\">\r\n");
      out.write("                Fermer\r\n");
      out.write("            </a>\r\n");
      out.write("            <div class=\"mesPopups\"> \r\n");
      out.write("                <center>\r\n");
      out.write("                    ");
      out.write("\n");
      out.write("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
      out.write("\r\n");
      out.write("                    <p><br/>Voulez-vous valider cette supernova ?<br/><strong>Cette action est irréversible</strong></p>\r\n");
      out.write("                </center>\r\n");
      out.write("                <form id=\"formValider\" method=\"post\" action=\"discovery.jsp?action=a_canValider_req\">\r\n");
      out.write("                    <input type=\"hidden\" name=\"userDisco\" id=\"userDisco\" value=\"");
      out.print(userDisco.getPseudo());
      out.write("\"/>\r\n");
      out.write("                    <input type=\"hidden\" name=\"nomImage\" id=\"nomImage\" value=\"");
      out.print(can.getNomImage());
      out.write("\"/>\r\n");
      out.write("                    <input type=\"hidden\" name=\"chemin\" id=\"chemin\" value=\"");
      out.print(can.getChemin());
      out.write("\"/>\r\n");
      out.write("                    <input type=\"hidden\" name=\"certitude\" id=\"certitude\" value=\"");
      out.print(can.getCertitude());
      out.write("\"/>\r\n");
      out.write("                    <input type=\"hidden\" name=\"x\" id=\"x\" value=\"");
      out.print(can.getX());
      out.write("\"/>\r\n");
      out.write("                    <input type=\"hidden\" name=\"y\" id=\"y\" value=\"");
      out.print(can.getY());
      out.write("\"/>\r\n");
      out.write("                    <input type=\"hidden\" name=\"dateDecouverte\" id=\"dateDecouverte\" value=\"");
      out.print(can.getDateDecouverte());
      out.write("\"/>\r\n");
      out.write("                    <div>\r\n");
      out.write("                        Changer le grade de l'utilisateur\r\n");
      out.write("                            <input type=\"range\" name=\"grade\" id=\"grade\" value=\"");
      out.print(userDisco.getGrade());
      out.write("\" min=\"1\" max=\"5\" step=\"1\" data-highlight=\"true\" />\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <br/>\r\n");
      out.write("                    Envoyer un mail à l'utilisateur\r\n");
      out.write("                    <br/><br/>\r\n");
      out.write("                    <strong>Objet:</strong>\r\n");
      out.write("                        <strong><textarea style=\"FONT-FAMILY: Verdana\" rows=1 name=\"objet\" id=\"objet\" placeholder=\"\">\r\n");
      out.write("Votre proposition du supernova a été validée !</textarea>\r\n");
      out.write("                    <br>\r\n");
      out.write("                    <strong>Contenu:</strong>\r\n");
      out.write("                        <textarea style=\"FONT-FAMILY: Verdana\" rows=5 name=\"contenu\" id=\"contenu\" placeholder=\"\">Bonjour,\r\n");
      out.write("\r\n");
      out.write("Félicitation vous êtes le premier a trouver cette supernova.\r\n");
      out.write("                        </textarea>\r\n");
      out.write("                    <div class=\"ui-grid-a\">\r\n");
      out.write("                        <div class=\"ui-block-a\">\r\n");
      out.write("                            <button id=\"btnConfirmCandidat\" class=\"ui-btn ui-corner-all\">Valider</button>\r\n");
      out.write("                   </div>\r\n");
      out.write("                </form>         \r\n");
      out.write("                        <div class=\"ui-block-b\">\r\n");
      out.write("                            <a href=\"#\" id=\"btnNon\" data-rel=\"back\" data-position-to=\"window\" \r\n");
      out.write("                               class=\"ui-btn ui-corner-all ui-shadow\" data-transition=\"pop\">\r\n");
      out.write("                                Annuler\r\n");
      out.write("                            </a>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <!-- popup refuser-->\r\n");
      out.write("        <div id=\"popupRefuser\" data-role=\"popup\" data-theme=\"a\" data-overlay-theme=\"b\"\r\n");
      out.write("             class=\"ui-corner-all\" data-corners=\"true\" data-position-to=\"window\">\r\n");
      out.write("            <a href=\"#\" data-rel=\"back\" class=\"ui-btn ui-corner-all ui-shadow\r\n");
      out.write("               ui-btn-a ui-icon-delete ui-btn-icon-notext ui-btn-right\" style=\"background-color:black;\">\r\n");
      out.write("                Fermer\r\n");
      out.write("            </a>\r\n");
      out.write("            <div class=\"mesPopups\">\r\n");
      out.write("                ");
      out.write("\n");
      out.write("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
      out.write("\r\n");
      out.write("                <form id=\"formRefuser\" method=\"post\" action=\"discovery.jsp?action=a_canRefuser_req\">\r\n");
      out.write("                    <input type=\"hidden\" name=\"userDisco\" id=\"userDisco\" value=\"");
      out.print(userDisco.getPseudo());
      out.write("\"/>\r\n");
      out.write("                    <input type=\"hidden\" name=\"nomImage\" id=\"nomImage\" value=\"");
      out.print(can.getNomImage());
      out.write("\"/>\r\n");
      out.write("                    <input type=\"hidden\" name=\"chemin\" id=\"chemin\" value=\"");
      out.print(can.getChemin());
      out.write("\"/>\r\n");
      out.write("                    <input type=\"hidden\" name=\"dateDecouverte\" id=\"dateDecouverte\" value=\"");
      out.print(can.getDateDecouverte());
      out.write("\"/>\r\n");
      out.write("                    <input type=\"hidden\" name=\"certitude\" id=\"certitude\" value=\"");
      out.print(can.getCertitude());
      out.write("\"/>\r\n");
      out.write("                    <center>\r\n");
      out.write("                        <p><br/>Voulez-vous refuser cette supernova ? <br/><strong>Cette action est irréversible</strong></p>\r\n");
      out.write("                    </center>\r\n");
      out.write("                    <br/>Envoyer un mail à l'utilisateur<br/><br/>\r\n");
      out.write("                    <strong>Objet:</strong>\r\n");
      out.write("                    <strong><textarea style=\"FONT-FAMILY: Verdana\" rows=1 name=\"objet\" id=\"objet\" placeholder=\"\">Votre proposition du supernova a été refusée !</textarea>\r\n");
      out.write("                    <br>Contenu: \r\n");
      out.write("                    <textarea style=\"FONT-FAMILY: Verdana\" rows=5 name=\"contenu\" id=\"contenu\" placeholder=\"\">Bonjour, désolé mais votre proposition de supernova n'est pas correcte. En effet...</textarea>\r\n");
      out.write("                    <div class=\"ui-grid-a\">\r\n");
      out.write("                        <div class=\"ui-block-a\">\r\n");
      out.write("                            <button id=\"btnRefuserCandidat\" class=\"ui-btn ui-corner-all\">Valider</button>\r\n");
      out.write("                        </div>     \r\n");
      out.write("                        <div class=\"ui-block-b\">\r\n");
      out.write("                            <!--  a vérifier ??? -->\r\n");
      out.write("                            <a href=\"#\" id=\"btnNon\" data-rel=\"back\" data-position-to=\"window\" \r\n");
      out.write("                                        class=\"ui-btn ui-corner-all ui-shadow\" data-transition=\"pop\">\r\n");
      out.write("                                Annuler\r\n");
      out.write("                            </a>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>   \r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("                    \r\n");
      out.write("        <!-- popup message en mode modal-->\r\n");
      out.write("        <div id=\"popupMsg\" data-role=\"popup\" data-theme=\"a\" data-overlay-theme=\"b\"\r\n");
      out.write("             class=\"ui-corner-all ui-alt-icon\" data-corners=\"true\" data-position-to=\"window\">\r\n");
      out.write("            <div class=\"mesPopups\" align=\"center\">\r\n");
      out.write("                <br/>\r\n");
      out.write("                <h3 id=\"popupTextMsg\">Attendez, je gère votre demande !</h3>\r\n");
      out.write("                <div class=\"progressBar\"><div></div></div>\r\n");
      out.write("                <br/>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        ");

            }
        
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
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
