package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.Connection;
import com.persistence.ConnexionMySQL;
import com.persistence.User;
import com.persistence.CandidateSN;
import com.metier.SmtpSend;

public final class candidate_005freq_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

    Connection con = (Connection) session.getAttribute("con");
    if (con == null)
        con = ConnexionMySQL.newConnexion();
    session.setAttribute("con", con);
    
    // retourne par Ajax les infos de la galaxie concernée
    String nomGalaxie = request.getParameter("nomGalaxie");
    String chemin = request.getParameter("chemin");
    int certitude = Integer.parseInt(request.getParameter("certitude"));
    int xPos = Integer.parseInt(request.getParameter("xPos"));
    int yPos = Integer.parseInt(request.getParameter("yPos"));
    
    com.metier.DiscoSession maSession = (com.metier.DiscoSession)session.getAttribute("maSession");
    if (maSession != null) {
        com.persistence.User user = maSession.getUser();
        String userPseudo = user.getPseudo();
        
        if (!CandidateSN.isCandidateExiste(con, userPseudo, nomGalaxie, chemin)) {
            // crée et sauve la candidate dans la BD
            CandidateSN.create(con, userPseudo, nomGalaxie, chemin, certitude, xPos, yPos, 0, 0);
            user.setNbCandidates(user.getNbCandidates() + 1);
            user.save(con);
            out.print("La candidate sur " + nomGalaxie + " sera vue par les experts");
            
            // après svgd ds la BD, on envoie le mail aux experts !
            String contenu = "Pseudo : " + userPseudo;
            contenu += "\nEMail : "      + user.getEmail();
            contenu += "\nGrade : "      + user.getGrade();
            contenu += "\nCertitude : "  + certitude;
            contenu += "\nNomGalaxie : " + nomGalaxie;
            contenu += "\nChemin : "     + chemin;
            contenu += "\nXPos : "       + xPos;
            contenu += "\nYPos : "       + yPos;
            contenu += "\nImage : 250x250";
            String titre = "Candidate sur " + chemin + nomGalaxie;
            // envoi du mail par gmail
            
            String to  = User.getByPseudo(con, "admin").getEmail();
            boolean ok = SmtpSend.sendMessage(titre, contenu, to);
            if (!ok) {
                out.print("Impossible de transmettre votre candidate !");
            }
        }
        else {
            // attente nécessaire pour que la popup marche et utile pour le user
            Thread.sleep(3000);
            out.print("Inutile de soumettre deux fois la candidate " + nomGalaxie + " !");
        }
    }

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
