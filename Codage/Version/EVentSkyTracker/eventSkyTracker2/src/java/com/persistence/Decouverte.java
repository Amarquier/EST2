/*
 * Fichier : Decouverte.java
 * Description : Classe interface de la table decouverte
 * Cette table stocke les decouvertes des utilisateurs
 */

package com.persistence;

import java.sql.*;

/**
 *
 * @author IRISINSTALL
 */
public class Decouverte {
    
    static public boolean exist(Connection con, String userPseudo, String nomImage, String chemin) throws Exception {
        String queryString =
         "select * from decouverte where userPseudo='" + userPseudo 
                       + "' and nomImage='"+nomImage+"' and chemin='" + chemin +"'";
        Statement lStat = con.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE, 
                ResultSet.CONCUR_READ_ONLY);
        ResultSet lResult = lStat.executeQuery(queryString);
        // y en a t'il au moins un ?
        return lResult.next();
    }
    
    static public boolean ajouter(Connection con, String userPseudo, String nomImage, String chemin, String dateDecouverte, int x, int y) throws Exception {
        // ajout decouverte dans BDD
        String queryString =
         "insert into `decouverte` (`userPseudo`, `nomImage`, `chemin`, `date`, `x`, `y`) "
         + "values ("+Utils.toString(userPseudo)+","
                + ""+Utils.toString(nomImage) +","
                + ""+Utils.toString(chemin) +","
                + ""+Utils.toString(dateDecouverte)+","
                + ""+Utils.toString(x)+","
                + ""+Utils.toString(y)+")";
        Statement lStat = con.createStatement();
        lStat.executeUpdate(queryString, Statement.NO_GENERATED_KEYS);
        return true;
    }
}
