package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class qcm_005freq_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    // retourne par Ajax les infos de la galaxie concernée
    String trame = request.getParameter("reponses");
    String reps[] = trame.split("\\|", -1);
    int nbBonnesReponses = 0;
    // les bonnes réponses                       |
    int[] bonnesReponses = {2,3,3,1,2,3,1,2,3,1,3,2,2,2,3,1,1,2,2,2,3,2};
    for (int i = 0; i < bonnesReponses.length; i++) {
        if (Integer.parseInt(reps[i]) == bonnesReponses[i])
            nbBonnesReponses++;
    }
    // au max 3 erreurs possibles
    if (nbBonnesReponses >= bonnesReponses.length - 3) {
            com.metier.ESTSession maSession = (com.metier.ESTSession)session.getAttribute("maSession");
            if (maSession == null)
                out.println("oui");
            else
                out.println("inscrit");
    }
    else
        out.println("non");

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
