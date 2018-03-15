/*
 * Classe de session pour chaque user connecté au serveur Tomcat
 */

package com.metier;

import com.persistence.*;
import java.sql.*;
import java.util.Calendar;

/**
 * Application : classe métier d'accès aux données persistantes
 */
public class ESTSession {
    /** * keep the Singleton instance */
    private Connection con;
    private boolean newConnexion;       // vrai au moment de la connexion 
    private User user;
    private Timestamp lastVisitDate;
    private boolean modeExpert;
    
    // empèche l'instanciation publique par défaut
    private ESTSession() throws Exception { }
        
    /**
     * L'objet session pour un utilisateur connecté
     * @param con
     * @param user      l'utilisateur connecté
     */
    public ESTSession(Connection con, User user) {
        try {
            this.con = con;
            this.newConnexion = true;
            this.user = user;
            this.lastVisitDate = user.getLastVisitDate();
            
            Timestamp currentTimestamp = 
             new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
            // la date courante est rangée dans la BD du user
            user.setLastVisitDate(currentTimestamp);
            user.setNbConnexions(user.getNbConnexions() + 1);
            // svgd ds la BD
            user.save(con);
            modeExpert = false;
        } catch (Exception ex) { }
    }

    public User getUser() {
        return user;
    }
    
    public boolean isNewConnexion() {
        return newConnexion;
    }
    
    public void setNewConnexion(boolean newConnexion) {
        this.newConnexion = newConnexion;
    }

    public Timestamp getLastVisitDate() {
        return lastVisitDate;
    }
    
    public boolean isModeExpert() {
        return modeExpert;
    }
    
    public void setModeExpert(boolean mode) {
        modeExpert = mode;
    }
}


