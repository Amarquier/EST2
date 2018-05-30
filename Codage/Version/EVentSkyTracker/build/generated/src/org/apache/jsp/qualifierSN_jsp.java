package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import com.metier.*;
import com.persistence.*;
import com.persistence.ConnexionMySQL;
import java.sql.Connection;

public final class qualifierSN_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("div");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"fr\">\n");
      out.write("<head>\n");
      out.write("    <title>Images</title>\n");
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
      out.write("\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<div class=\"page\" data-role=\"page\" id=\"discoPage\" data-theme=\"b\">\n");
      out.write("    ");
      out.write("\n");
      out.write("    <script type=\"text/javascript\" src=\"js/disco.js\"></script>\n");
      out.write("\n");
      out.write("    <div class=\"header\" data-role=\"header\" data-id=\"main-header\" data-tap-toggle=\"false\" \n");
      out.write("        data-theme=\"b\" data-position=\"fixed\" data-fullscreen=\"true\">\n");
      out.write("        <h1>Découvrir</h1>\n");
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
    
      out.write("\n");
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
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("        <script type=\"text/javascript\">  \n");
      out.write("            ");

                /*
                    On peut appeler "disco.jsp" ou "disco.jsp?date=20140418".
                    Si il n'y a pas de paramètre de date, c'est la date du dernier
                    jour dans la BD.
                */
                String dateObservation = request.getParameter("date");
                String paramPos = request.getParameter("pos");
                if (dateObservation == null) {
                    dateObservation = ImageSN.dernierJour(con);
                }
                
                int newPos = 1;
                boolean reprise = false;
                ImageSN img1 = null;

                img1 = ImageSN.find(con, dateObservation, 1);
                if ((maSession != null) && (user != null)) {
                    int imgPos = user.getlastImgPos();
                    String lastImgDate = user.getlastImgDate();
                    // uniquement sur une nouvelle connexion, plus après !
                    if ((imgPos != 0) && maSession.isNewConnexion()) {
                        // je récupère la dernière image observée par ce user
                        if (ImageSN.existByDate(con, user.getlastImgDate())){
                            img1 = ImageSN.getByChemin(con, user.getlastImg(),
                                        user.getlastImgGalaxie(),user.getlastImgDate());
                            reprise = true;
                            newPos = imgPos;
                            dateObservation = lastImgDate;
                        }
                    }
                    else if (paramPos != null) {
                        newPos = Integer.parseInt(paramPos);
                    }
                    maSession.setNewConnexion(false);
                }

                /*  initialise le tableau des noms des images d'observation
                    au format "F O nom.jpg" ou "C N nom.jpg" (pour France ou Chili) 
                    de la date par défaut ou celle passée en paramètre.
                    O/N suivant que le fichier de ref existe.
                 */
                /* Il reste a decouper le chemin en plusieur variable pour initialiser correctement le script */
                ArrayList<ImageSN> images = ImageSN.getImagesDuJour(con, dateObservation);
                out.print("imagesNoms = new Array(");
                for (int i = 0; i < images.size(); i++) {
                    ImageSN img = images.get(i);
                    char car = DiscoApplication.isRefFileExist(img.getGalaxieNom()) ? 'O':'N';
                    if (img.getChemin().equals("Tarot_Calern"))
                        out.print("'F " + car + ' ' + img.getGalaxieNom() + "'");
                    else 
                        out.print("'C " + car + ' ' + img.getGalaxieNom() + "'");
                    if (i < images.size() - 1)
                        out.print(",");
                }
                out.println(");");
                // initialise le chemin d'accès aux images d'observation
                out.print("cheminCalern = ");
                ImageSN img = images.get(0);
                out.println("'/jpeg/images_SN/Tarot_Calern/" + img.getDate() + "/';");
                out.print("cheminChili = ");
                out.println("'/jpeg/images_SN/Tarot_Chili/" + img.getDate() + "/';");
                out.print("cheminRef = '/jpeg/images_SN/refgal/';");
                out.println("'/jpeg/images_SN/Tarot_Chili/" + img.getDate() + "/';");
                out.print("dateCrt = " + img.getDate());
            
      out.write("\n");
      out.write("            nouvelleImage(");
      out.print(newPos );
      out.write(");\n");
      out.write("        </script>\n");
      out.write("        <a href=\"#panelCalendar\" \n");
      out.write("           class=\"ui-btn ui-btn-icon-notext ui-corner-all ui-icon-calendar ui-btn-left\">\n");
      out.write("        </a>\n");
      out.write("        <a href=\"#panelGalaxies\" \n");
      out.write("           class=\"ui-btn ui-btn-icon-notext ui-corner-all ui-icon-navigation ui-btn-right\">\n");
      out.write("        </a>\n");
      out.write("        \n");
      out.write("    </div>\n");
      out.write("        <br/><br/>\n");
      out.write("        <div class=\"mesImages\" align=\"center\">\n");
      out.write("            <br/>\n");
      out.write("            ");
      out.write("\n");
      out.write("            <a href='#popupZoomLeft' id='clicZoomLeft' data-rel='popup'>\n");
      out.write("                <img id='imgobs' alt='erreur:image absente' src='/jpeg/images_SN/");
      out.print(img1.getChemin());
      out.write('/');
      out.print(img1.getDate());
      out.write('/');
      out.print(img1.getGalaxieNom());
      out.write(".jpg'/>\n");
      out.write("            </a>\n");
      out.write("            <a href='#popupZoomRight' id='clicZoomRight' data-rel='popup'>\n");
      out.write("                <img id='imgref' alt='.... aucune référence ....' src='/jpeg/images_SN/refgal/");
      out.print(img1.getGalaxieRef());
      out.write(".jpg'/>\n");
      out.write("            </a>\n");
      out.write("        </div>\n");
      out.write("        <table class=\"infosTable\">\n");
      out.write("            <td class=\"texteCentre\" id=\"dateImages\">");
      out.print( Utils.formatDate(img1.getDate()));
      out.write("</td>\n");
      out.write("            ");

            if(!reprise){
            
      out.write("\n");
      out.write("            <td class=\"texteCentre\" id=\"numImages\" >(1/");
      out.print( images.size());
      out.write(")</td>\n");
      out.write("            ");

            }
            else{
            
      out.write("\n");
      out.write("            <td class=\"texteCentre\" id=\"numImages\" >(");
      out.print(user.getlastImgPos());
      out.write('/');
      out.print( images.size());
      out.write(")</td>\n");
      out.write("            ");

            }
            
      out.write("\n");
      out.write("            <td class=\"texteCentre\" id=\"nomGalaxie\">");
      out.print( img1.getGalaxieNom());
      out.write("</td>\n");
      out.write("        </table>\n");
      out.write("        <div align=\"center\">\n");
      out.write("            <div class=\"ui-grid-a\">\n");
      out.write("                <div class=\"ui-block-a\">\n");
      out.write("                    ");
if(!reprise){
      out.write("\n");
      out.write("                    <a href=\"#\" id=\"btnPcdt\" data-icon=\"arrow-l\" data-iconpos=\"left\" \n");
      out.write("                                    class=\"ui-state-disabled\"\n");
      out.write("                                    data-role=\"button\">Précédent</a>\n");
      out.write("                    ");

                    }
                    else{
      out.write("\n");
      out.write("                    <a href=\"#\" id=\"btnPcdt\" data-icon=\"arrow-l\" data-iconpos=\"left\" \n");
      out.write("                                    data-role=\"button\">Précédent</a>\n");
      out.write("                    ");
}
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <div class=\"ui-block-b\">\n");
      out.write("                    ");
if (images.size() <= 1) {
      out.write("\n");
      out.write("                    <a href=\"#\" id=\"btnSvt\" data-icon=\"arrow-r\" data-iconpos=\"right\" \n");
      out.write("                                class=\"ui-state-disabled\"\n");
      out.write("                                data-role=\"button\">Suivant</a>\n");
      out.write("                    ");

                    }
                    else{
      out.write("\n");
      out.write("                    <a href=\"#\" id=\"btnSvt\" data-icon=\"arrow-r\" data-iconpos=\"right\" \n");
      out.write("                                data-role=\"button\">Suivant</a>\n");
      out.write("                    ");
}
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"ui-grid-b\">\n");
      out.write("            <div class=\"ui-block-a\">\n");
      out.write("                <a href=\"#popupHisto\" id=\"btnHisto\" data-rel=\"popup\" data-position-to=\"window\" \n");
      out.write("                class=\"ui-btn ui-corner-all ui-shadow\">Histo</a>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"ui-block-b\">\n");
      out.write("                <a href=\"#popupInfos\" id=\"btnInfos\" data-rel=\"popup\" data-position-to=\"window\" \n");
      out.write("                class=\"ui-btn ui-corner-all ui-shadow\">Infos</a>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"ui-block-c\">\n");
      out.write("                <a href=\"#popupBlink\" id=\"btnBlink\" data-rel=\"popup\" data-position-to=\"window\" \n");
      out.write("                class=\"ui-btn ui-corner-all ui-shadow\">Blink</a>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"ui-grid-a\">\n");
      out.write("            <div class=\"ui-block-a\">\n");
      out.write("               ");

                    if (user != null) {
      out.write("\n");
      out.write("                         <a href=\"#popupCandidat\" id=\"btnCandidat\" data-rel=\"popup\" data-position-to=\"window\" \n");
      out.write("                            class=\"ui-btn ui-corner-all ui-shadow\" data-transition=\"pop\">Disco</a>\n");
      out.write("                    ");
}
                
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <div class=\"ui-block-b\">\n");
      out.write("               ");

                    if (user != null) {
                        if(user.getGrade() >= 3){ 
      out.write("\n");
      out.write("                         <a href=\"#popupNewRef\" id=\"btnNewRef\" data-rel=\"popup\" data-position-to=\"window\" \n");
      out.write("                            class=\"ui-btn ui-corner-all ui-shadow\" data-transition=\"pop\">Référence</a>\n");
      out.write("                    ");
}
                    }
                
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    \n");
      out.write("\n");
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
      out.write("\n");
      out.write("    \n");
      out.write("    <!-- panel de calendar -->\n");
      out.write("    <div id=\"panelCalendar\" data-role=\"panel\" data-position=\"left\"  \n");
      out.write("             data-position-fixed=\"true\" data-display=\"push\" data-theme=\"a\">\n");
      out.write("        <ul data-role=\"listview\" data-icon=\"false\" class=\"ui-alt-icon\">\n");
      out.write("            <li data-role=\"list-divider\">Choisir un jour :</li>\n");
      out.write("            \n");
      out.write("            ");

                ArrayList<String> dates = ImageSN.getDerniersJours(con);
                for (String date : dates) {
                    /* out.println("<li><a href='disco.jsp?date=" + date + "'>" 
                                        + Utils.formatDate(date) + "</a></li>");*/
                    
                    out.println("<li><a href='#' onclick='nouvelleDate(" + date + ");'>" 
                                   + Utils.formatDate(date) + "</a></li>");
                }
            
      out.write("\n");
      out.write("            <li data-icon=\"delete\"><a href=\"#\" data-rel=\"close\">Close</a></li>\n");
      out.write("        </ul>\n");
      out.write("    </div>\n");
      out.write("    \n");
      out.write("    <!-- panel de galaxies -->\n");
      out.write("    <div id=\"panelGalaxies\" data-role=\"panel\" data-position=\"right\"  \n");
      out.write("             data-position-fixed=\"true\" data-display=\"push\" data-theme=\"a\">\n");
      out.write("        <ul data-role=\"listview\" data-icon=\"false\" class=\"ui-alt-icon\">\n");
      out.write("            <li data-role=\"list-divider\">Offset sur les images :</li>\n");
      out.write("            <li><a href=\"#\" data-rel=\"close\" onclick=\"nouvelleImage(1);\">Première</a></li>\n");
      out.write("            <li><a href=\"#\" data-rel=\"close\" onclick=\"nouvelleImage(offset(-200));\">-200</a></li>\n");
      out.write("            <li><a href=\"#\" data-rel=\"close\" onclick=\"nouvelleImage(offset(-100));\">-100</a></li>\n");
      out.write("            <li><a href=\"#\" data-rel=\"close\" onclick=\"nouvelleImage(offset(-50));\">-50</a></li>\n");
      out.write("            <li><a href=\"#\" data-rel=\"close\" onclick=\"nouvelleImage(offset(-10));\">-10</a></li>\n");
      out.write("            <li><a href=\"#\" data-rel=\"close\" onclick=\"nouvelleImage(offset(10));\">+10</a></li>\n");
      out.write("            <li><a href=\"#\" data-rel=\"close\" onclick=\"nouvelleImage(offset(50));\">+50</a></li>\n");
      out.write("            <li><a href=\"#\" data-rel=\"close\" onclick=\"nouvelleImage(offset(100));\">+100</a></li>\n");
      out.write("            <li><a href=\"#\" data-rel=\"close\" onclick=\"nouvelleImage(offset(200));\">+200</a></li>\n");
      out.write("            <li><a href=\"#\" data-rel=\"close\" onclick=\"nouvelleImage(");
      out.print( images.size());
      out.write(");\">Dernière</a></li>\n");
      out.write("            <li data-icon=\"delete\">\n");
      out.write("                <a href=\"#\" data-rel=\"close\">Close</a>\n");
      out.write("            </li>\n");
      out.write("        </ul>\n");
      out.write("    </div>\n");
      out.write("    \n");
      out.write("    <!-- popup candidat -->\n");
      out.write("    <div id=\"popupCandidat\" data-role=\"popup\" data-theme=\"a\" data-overlay-theme=\"b\"\n");
      out.write("         class=\"ui-corner-all ui-alt-icon\" data-corners=\"true\" data-position-to=\"window\">\n");
      out.write("        <a href=\"#\" data-rel=\"back\" class=\"ui-btn ui-corner-all ui-shadow \n");
      out.write("             ui-btn-a ui-icon-delete ui-btn-icon-notext ui-btn-right\">Close</a>\n");
      out.write("        <div id=\"divCandidat\" class=\"ui-alt-icon\">\n");
      out.write("            <h3 id=\"nomCandidat\">Proposition de candidat sur IC500</h3>\n");
      out.write("            <h4>Pointez la supernova !!!</h4>\n");
      out.write("            <canvas id=\"mon_canvas\" width=\"250\" height=\"250\" ></canvas>\n");
      out.write("            <form id=\"formCandidat\">\n");
      out.write("                <fieldset data-role=\"controlgroup\" data-type=\"horizontal\">\n");
      out.write("                    <legend>Choisir le degré de certitude :<br/>\n");
      out.write("                            (1 : peu sûr, 5 : certain)\n");
      out.write("                    </legend>\n");
      out.write("                    <input type=\"radio\" name=\"rdoCertitude\" id=\"radio-choice-h-2a\" value=\"1\" checked=\"checked\">\n");
      out.write("                    <label for=\"radio-choice-h-2a\">1</label>\n");
      out.write("                    <input type=\"radio\" name=\"rdoCertitude\" id=\"radio-choice-h-2b\" value=\"2\">\n");
      out.write("                    <label for=\"radio-choice-h-2b\">2</label>\n");
      out.write("                    <input type=\"radio\" name=\"rdoCertitude\" id=\"radio-choice-h-2c\" value=\"3\">\n");
      out.write("                    <label for=\"radio-choice-h-2c\">3</label>\n");
      out.write("                    <input type=\"radio\" name=\"rdoCertitude\" id=\"radio-choice-h-2d\" value=\"4\">\n");
      out.write("                    <label for=\"radio-choice-h-2d\">4</label>\n");
      out.write("                    <input type=\"radio\" name=\"rdoCertitude\" id=\"radio-choice-h-2e\" value=\"5\">\n");
      out.write("                    <label for=\"radio-choice-h-2e\">5</label>\n");
      out.write("                </fieldset>\n");
      out.write("                <br/>\n");
      out.write("                <button id=\"btnConfirmCandidat\" class=\"ui-btn ui-corner-all\">Confirmation</button>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    \n");
      out.write("    ");
if (user != null) { 
      out.write("\n");
      out.write("    \n");
      out.write("    <!-- popup nouvelleReference -->\n");
      out.write("    <div id=\"popupNewRef\" data-role=\"popup\" data-theme=\"a\" data-overlay-theme=\"b\"\n");
      out.write("         class=\"ui-corner-all ui-alt-icon\" data-corners=\"true\" data-position-to=\"window\">\n");
      out.write("        <a href=\"#\" data-rel=\"back\" class=\"ui-btn ui-corner-all ui-shadow \n");
      out.write("             ui-btn-a ui-icon-delete ui-btn-icon-notext ui-btn-right\">Close</a>\n");
      out.write("        <div id=\"divCandidat\" class=\"ui-alt-icon\" align=\"center\">\n");
      out.write("            <h3  id=\"nomCandidat\">Proposition de référence</h3>\n");
      out.write("            <img id=\"imgNewRef\" alt=\"erreur:image absente\" src=\"\"/>\n");
      out.write("            <h2>\n");
      out.write("                <div id=\"popupNewRefMsg\">\n");
      out.write("                    Confirmez vous cette image comme nouvelle image de référence ?\n");
      out.write("                </div>\n");
      out.write("            </h2>\n");
      out.write("            <a href=\"#\" id=\"btnDmdNewRef\" data-role=\"button\">Confirmation</a>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    ");
}
      out.write("\n");
      out.write("    \n");
      out.write("    <!-- popup message en mode modal-->\n");
      out.write("    <div id=\"popupSendMail\" data-role=\"popup\" data-theme=\"a\" data-overlay-theme=\"b\"\n");
      out.write("         class=\"ui-corner-all ui-alt-icon\" data-corners=\"true\" data-position-to=\"window\" data-dismissible=\"false\">\n");
      out.write("        <div class=\"mesPopups\" align=\"center\">\n");
      out.write("            <br/>\n");
      out.write("            <h3 id=\"popupTextSendMail\">Attendez, je transmets votre candidate !</h3>\n");
      out.write("            <div class=\"progressBar\"><div></div></div>\n");
      out.write("            <br/>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    \n");
      out.write("    <!-- popup message -->\n");
      out.write("    <div id=\"popupMsg\" data-role=\"popup\" data-theme=\"a\" data-overlay-theme=\"b\"\n");
      out.write("         class=\"ui-corner-all ui-alt-icon\" data-corners=\"true\" data-position-to=\"window\">\n");
      out.write("        <a href=\"#\" data-rel=\"back\" class=\"ui-btn ui-corner-all ui-shadow \n");
      out.write("             ui-btn-a ui-icon-delete ui-btn-icon-notext ui-btn-right\">Close</a>\n");
      out.write("        <div class=\"mesPopups\" align=\"center\">\n");
      out.write("            <h3 id=\"popupTextMsg\">Bien !</h3>\n");
      out.write("            <br/><br/><br/>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    \n");
      out.write("    <!-- popup infos -->\n");
      out.write("    <div id=\"popupInfos\" data-role=\"popup\" data-theme=\"a\" data-overlay-theme=\"b\"\n");
      out.write("         class=\"ui-corner-all ui-alt-icon\" data-corners=\"true\" data-position-to=\"window\">\n");
      out.write("        <a href=\"#\" data-rel=\"back\" class=\"ui-btn ui-corner-all ui-shadow \n");
      out.write("             ui-btn-a ui-icon-delete ui-btn-icon-notext ui-btn-right\">Close</a>\n");
      out.write("        <div class=\"mesPopups\">\n");
      out.write("            <h3    id=\"nomInfos\">Nom:</h3>\n");
      out.write("            <label id=\"catInfos\">Catégorie:</label>\n");
      out.write("            <label id=\"textInfos\">Informations:</label>\n");
      out.write("            <label id=\"nbNovInfos\">Supernovae découvertes:</label>\n");
      out.write("            <label id=\"adrInfos\">Ascension droite (degré):</label>\n");
      out.write("            <label id=\"decInfos\">Déclinaison (degré):</label>\n");
      out.write("            <label id=\"distInfos\">Distance (mal):</label>\n");
      out.write("            <label id=\"magInfos\">Magnitude:</label>\n");
      out.write("            <label id=\"magTelescope\">Télescope:</label>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <!-- popup blink -->\n");
      out.write("    <div id=\"popupBlink\" data-role=\"popup\" data-theme=\"a\" data-overlay-theme=\"b\"\n");
      out.write("           class=\"ui-corner-all ui-alt-icon\" data-corners=\"true\" data-position-to=\"window\">\n");
      out.write("        <a href=\"#\" data-rel=\"back\" class=\"ui-btn ui-corner-all ui-shadow \n");
      out.write("             ui-btn-a ui-icon-delete ui-btn-icon-notext ui-btn-right\">Close</a>\n");
      out.write("        <div class=\"mesPopups\">\n");
      out.write("            <h3 id=\"nomBlink\"></h3>\n");
      out.write("            <div><img id=\"imgBlink\" src=\"images/black.jpg\"/></div>\n");
      out.write("            <br/>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    \n");
      out.write("    <!-- popup ZoomLeft -->\n");
      out.write("    <div id=\"popupZoomLeft\" data-role=\"popup\" data-theme=\"a\" data-overlay-theme=\"b\"\n");
      out.write("           class=\"ui-corner-all ui-alt-icon\" data-corners=\"true\" data-position-to=\"window\">\n");
      out.write("        <a href=\"#\" data-rel=\"back\" class=\"ui-btn ui-corner-all ui-shadow \n");
      out.write("             ui-btn-a ui-icon-delete ui-btn-icon-notext ui-btn-right\">Close</a>\n");
      out.write("        <div class=\"mesPopups\">\n");
      out.write("            <h3 id=\"nomZoomLeft\"></h3>\n");
      out.write("            <div><img id=\"imgZoomLeft\" src=\"images/black.jpg\"/></div>\n");
      out.write("            <br/>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    \n");
      out.write("    <!-- popup ZoomRight -->\n");
      out.write("    <div id=\"popupZoomRight\" data-role=\"popup\" data-theme=\"a\" data-overlay-theme=\"b\"\n");
      out.write("           class=\"ui-corner-all ui-alt-icon\" data-corners=\"true\" data-position-to=\"window\">\n");
      out.write("        <a href=\"#\" data-rel=\"back\" class=\"ui-btn ui-corner-all ui-shadow \n");
      out.write("             ui-btn-a ui-icon-delete ui-btn-icon-notext ui-btn-right\">Close</a>\n");
      out.write("        <div class=\"mesPopups\">\n");
      out.write("            <h3 id=\"nomZoomRight\"></h3>\n");
      out.write("            <div><img id=\"imgZoomRight\" src=\"images/black.jpg\"/></div>\n");
      out.write("            <br/>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    \n");
      out.write("        <!-- popup Historique -->\n");
      out.write("    <div id=\"popupHisto\" data-role=\"popup\" data-theme=\"a\"\n");
      out.write("           class=\"ui-corner-all ui-alt-icon\" data-corners=\"true\" data-position-to=\"window\">\n");
      out.write("        <a href=\"#\" data-rel=\"back\" class=\"ui-btn ui-corner-all ui-shadow \n");
      out.write("             ui-btn-a ui-icon-delete ui-btn-icon-notext ui-btn-right\">Close</a>\n");
      out.write("        <div>\n");
      out.write("            <h3 id=\"nomHisto\"></h3>\n");
      out.write("            <div id=\"imgHisto\">\n");
      out.write("                <div>\n");
      out.write("                    <img id=\"imgHisto1\" src=\"images/pasImageCeJour.jpg\"/>\n");
      out.write("                    <img id=\"imgHisto2\" src=\"images/pasImageCeJour.jpg\"/>\n");
      out.write("                </div>\n");
      out.write("                <div>\n");
      out.write("                    <img id=\"imgHisto3\" src=\"images/pasImageCeJour.jpg\"/>\n");
      out.write("                    <img id=\"imgHisto4\" src=\"images/pasImageCeJour.jpg\"/>\n");
      out.write("                </div>\n");
      out.write("                <div>\n");
      out.write("                    <img id=\"imgHisto5\" src=\"images/pasImageCeJour.jpg\"/>\n");
      out.write("                    <img id=\"imgHisto6\" src=\"images/pasImageCeJour.jpg\"/>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("\n");
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
