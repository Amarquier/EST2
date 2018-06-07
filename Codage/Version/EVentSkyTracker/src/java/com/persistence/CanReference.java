/*
 * Fichier : CanReference.java
 * Description : Classe interface de la table canreference
 * Cette table stocke les demandes d'ajout d'images de référence
 * des utilisateurs de grade entre 3 et 4
 */

package com.persistence;

import com.metier.DiscoApplication;
import com.metier.ESTApplication;
import java.sql.*;
import java.util.*;

public class CanReference {
    private Timestamp   date;
    private String userPseudo;
    private String galaxieNom;
    private String galaxieRef;
    private String chemin;

    /**
     * Créer une nouvelle demande de nouvelle référence
     * @param con
     * @param galaxieNom
     * @param chemin
     * @param userPseudo
     * @return 
     * @ return  une demande de nouvelle référence si personne n'a candidate cette image sinon null
     * @throws SQLException   impossible d'accéder à la ConnexionMySQL
     */
    static public CanReference create(Connection con, String userPseudo, String galaxieNom, String chemin) throws Exception {
        CanReference candidate = new CanReference(userPseudo, galaxieNom, chemin);
        String queryString =
         "insert into canreference (`date`, `userPseudo`, `galaxieNom`, `chemin`) "
            + " values ("
                + Utils.toString(candidate.getDate()) + ","
                + Utils.toString(userPseudo) + "," 
                + Utils.toString(galaxieNom) + ","
                + Utils.toString(chemin) + ")";
        Statement lStat = con.createStatement();
        // System.out.println(queryString);
        lStat.executeUpdate(queryString, Statement.NO_GENERATED_KEYS);
        return candidate;
    }

    /**
     * suppression d'une demande de nouvelle référence dans la BD
     * @param con
     * @return 
     * @throws SQLException    impossible d'accéder à la ConnexionMySQL
     */
    public boolean delete(Connection con) throws Exception {
        String queryString = "delete from canreference "
                + " where userPseudo='" + userPseudo  + "'"
                    + " and chemin='" + chemin + "'";
        Statement lStat = con.createStatement();
        lStat.executeUpdate(queryString);
        return true;
    }
    
    /**
     * suppression (statique) d'une demande de nouvelle référence dans la BD
     * @param con
     * @param _userPseudo
     * @param _chemin
     * @return 
     * @throws SQLException    impossible d'accéder à la ConnexionMySQL
     */
    static public boolean delete(Connection con, String _userPseudo, String _chemin) throws Exception {
        String queryString = "delete from canreference "
                + " where userPseudo='" + _userPseudo  + "'"
                    + " and chemin='" + _chemin + "'";
        Statement lStat = con.createStatement();
        lStat.executeUpdate(queryString);
        return true;
    }
    
    /**
     * retourne l'élément i d'une demande de nouvelle référence pour une image 
     * ordonne par la date de découverte
     * @param con
     * @param chemin
     * @param user
     * @param  i       le nom de la personne courante
     * @return String la liste des nom des personnes inscrites
     * @throws java.lang.Exception
     */
    public static CanReference find(Connection con, String chemin, String user, int i) throws Exception {
        String queryString = "select * from canreference  where chemin='" + chemin 
                        + "' and userPseudo ='"+ user +"' order by `date` asc";
        Statement lStat = con.createStatement(
                            ResultSet.TYPE_SCROLL_INSENSITIVE, 
                            ResultSet.CONCUR_READ_ONLY);
        ResultSet lResult = lStat.executeQuery(queryString);
        if ((i > 0) && (lResult.absolute(i))) {
            Timestamp date    = lResult.getTimestamp("date");
            String userPseudo = lResult.getString("userPseudo");
            CanReference candidate = 
                    new CanReference(date, userPseudo, "", chemin);
            return candidate;
        }
        else 
            return null;
    }
    
    public static CanReference find(Connection con, int i) throws Exception {
        String queryString = "select * from canreference order by `date`";
        Statement lStat = con.createStatement(
                            ResultSet.TYPE_SCROLL_INSENSITIVE, 
                            ResultSet.CONCUR_READ_ONLY);
        ResultSet lResult = lStat.executeQuery(queryString);
        if ((i > 0) && (lResult.absolute(i))) {
            Timestamp date    = lResult.getTimestamp("date");
            String userPseudo = lResult.getString("userPseudo");
            String galaxieNom = lResult.getString("galaxieNom");
            String chemin = lResult.getString("chemin");
            CanReference candidate = 
                    new CanReference(date,userPseudo,galaxieNom,chemin);
            return candidate;
        }
        else{
            return null;
        }
    }
    
    /**
     * Indique si demande de nouvelle référence existe déjà ou non ?
     * Pour unicité du nom
     * @param con
     * @param userPseudo
     * @param galaxieNom
     * @param chemin
     * @return true si la demande de nouvelle référence
     * @throws java.lang.Exception
     */
    public static boolean isCandidateExiste(Connection con, String userPseudo, String galaxieNom, 
                                              String chemin) throws Exception {
        String queryString = "select * from canreference "
                                    + " where userPseudo='" + userPseudo  + "'"
                                    + " and galaxieNom='" + galaxieNom + "'"
                                    + " and chemin='" + chemin + "'";
        Statement lStat = con.createStatement(
                            ResultSet.TYPE_SCROLL_INSENSITIVE, 
                            ResultSet.CONCUR_READ_ONLY);
        ResultSet lResult = lStat.executeQuery(queryString);
        // y en a t'il au moins un ?
        return lResult.next();
    }
        
    /**
     * Indique le nb de demendes de nouvelles références dans la base de données
     * @param con
     * @return le nombre de nouvelles références
     * @throws java.lang.Exception
     */
    public static int size(Connection con) throws Exception {
        String queryString = "select count(*) as count from canreference";
        Statement lStat = con.createStatement(
                            ResultSet.TYPE_SCROLL_INSENSITIVE, 
                            ResultSet.CONCUR_READ_ONLY);
        ResultSet lResult = lStat.executeQuery(queryString);
        if (lResult.next())
            return (lResult.getInt("count"));
        else 
            return 0;
    }
    
    /**
     * Cree et initialise complètement une nouvelle référence
     */
    private CanReference(Timestamp date, String userPseudo, String galaxieNom, String chemin) {
        this.date = (Timestamp)date.clone();
        this.userPseudo = userPseudo;
        this.galaxieNom = galaxieNom;
        this.chemin = chemin;
        this.galaxieRef = (DiscoApplication.isRefFileExist(galaxieNom)? galaxieNom : "_pasdImage");
    }
    
    /**
     * Cree un nouvel objet pour une nouvelle référence
     */
    private CanReference(String userPseudo, String galaxieNom, String chemin) {
        Timestamp currentTimestamp = 
            new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
        this.date = currentTimestamp;
        this.userPseudo = userPseudo;
        this.galaxieNom = galaxieNom;
        this.chemin = chemin;
        this.galaxieRef = (DiscoApplication.isRefFileExist(galaxieNom)? galaxieNom : "_pasdImage");
    }
        
    // --------------------- les assesseurs ----------------------------
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getUserPseudo() {
        return userPseudo;
    }

    public void setUserPseudo(String userPseudo) {
        this.userPseudo = userPseudo;
    }

    public String getGalaxieNom() {
        return galaxieNom;
    }

    public void setGalaxieNom(String galaxieNom) {
        this.galaxieNom = galaxieNom;
    }

    public String getGalaxieRef() {
        return galaxieRef;
    }

    public void changeGalaxieRef() {
        this.galaxieRef = (DiscoApplication.isRefFileExist(galaxieNom)? galaxieNom : "_pasdImage");
    }
    
    public String getChemin(){
        return chemin;
    }
    
    public void setChemin(String chemin){
        this.chemin = chemin;
    }
    
    public String getDateDecouverte(){
        return Utils.toString(date);
    }
    
    /**
     * toString() operator overload
     * @return   the result string
     */
    @Override
    public String toString() {
        return  " date =  " + Utils.toString(date) + "\t" +
                " userPseudo = " + Utils.toString(userPseudo) + 
                " nomImage = " + Utils.toString(galaxieNom) + 
                " chemin = " + Utils.toString(chemin) 
                + " ";
    }
}