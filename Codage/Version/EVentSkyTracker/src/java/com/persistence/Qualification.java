/*
 * Fichier : Qualification.java
 * Description : Classe interface de la table qualification
 * Cette table stocke les questionnaires proposés par les user pour qualifier
 * une candidate
 * La réponse devrait au format XML ou JSON. A définir.
 */

package com.persistence;

import java.sql.*;
import java.util.*;

public class Qualification {
    private String      userPseudo;     // la clef primaire
    private int         canId;          // id de la candidate
    private Timestamp   date;           // la date de la qualification
    private int         x;              // position du visuel en x
    private int         y;              // position du visuel en y
    private String      questionnaire;        // qualification au format XML

    /**
     * Créer un nouvel objet de qualification 
     * @param con
     * @param userPseudo
     * @param canId
     * @param x
     * @param y
     * @param questionnaire
     * @return 
     * @ return  un objet qualification
     * @throws Exception    impossible d'accéder à la ConnexionMySQL
     *                      ou le pseudo est deja dans la BD
     */
    static public Qualification create(Connection con, String userPseudo, int canId, int x, int y, String questionnaire)  throws Exception {
        Qualification qualification = new Qualification(userPseudo, canId, x, y, questionnaire);
        
        String queryString =
         "insert into qualification (`userPseudo`,`canId`,`date`,`x`,`y` ,`questionnaire`) values ("
                + Utils.toString(userPseudo) + ", " 
                + Utils.toString(canId) + ", " 
                + Utils.toString(qualification.getDate()) + ", " 
                + Utils.toString(x) + ", " 
                + Utils.toString(y) + ", "
                + '"' + questionnaire + '"'
          + ")";
        Statement lStat = con.createStatement();
        lStat.executeUpdate(queryString, Statement.NO_GENERATED_KEYS);
        return qualification;
    }
    
    /**
     * update de l'objet courant dans la BD
     * @param con
     * @throws Exception    impossible d'accéder à la ConnexionMySQL
     */
    public void save(Connection con) throws Exception {
        String queryString =
         "update qualification set "
                + " `userPseudo` =" + Utils.toString(userPseudo) + "," 
                + " `canId` =" + Utils.toString(canId) + "," 
                + " `date` =" + Utils.toString(date) + "," 
                + " `x` =" + Utils.toString(x) + "," 
                + " `y` =" + Utils.toString(y) + ","
                + " `questionnaire` =" + Utils.toString(questionnaire)
                + " where userPseudo='" + userPseudo + "'"
                    + " and canId='" + Utils.toString(canId) + "'";
        Statement lStat = con.createStatement();
        lStat.executeUpdate(queryString, Statement.NO_GENERATED_KEYS);
    }
    
    /**
     * Retourne la qualification pour une candidate donnée
     * @param  con
     * @param  canId
     * @return la qualification trouvé par son id
     * @throws java.lang.Exception
     */
    public static ArrayList<Qualification> getByCandidate(Connection con, int canId) throws Exception {
        ArrayList<Qualification> qualification = new ArrayList<Qualification>();
        String queryString = "select * from qualification"
                                + " where canId='" + canId + "'";
        Statement lStat = con.createStatement(
                                ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                ResultSet.CONCUR_READ_ONLY);
        ResultSet lResult = lStat.executeQuery(queryString);
        // y en a t'il au moins un ?
        while (lResult.next()) {
            qualification.add(creerParRequete(lResult));
        }
            return qualification;
    }
    
    /**
     * Retourne la qualification trouvée par son id
     * @param  con
     * @param  userPseudo
     * @param  canId
     * @return la qualification trouvé par son id
     * @throws java.lang.Exception
     */
    public static Qualification getByPseudoAndCandidat(Connection con, 
                                String userPseudo, int canId) throws Exception {
        String queryString = "select * from qualification"
                                + " where userPseudo='" + userPseudo + "'"
                                    + " and canId='" + canId + "'";
        Statement lStat = con.createStatement(
                                ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                ResultSet.CONCUR_READ_ONLY);
        ResultSet lResult = lStat.executeQuery(queryString);
        // y en a t'il au moins un ?
        if (lResult.next()) {
            return creerParRequete(lResult);
        }
        else
            return null;
    }
    
    /**
     * retourne l'élément i trié par la date de la qualification
     * @param con
     * @param  i       le nom de la personne courante
     * @return String la liste des nom des personnes inscrites
     * @throws java.lang.Exception
     */
    public static Qualification find(Connection con, int i) throws Exception {
        String queryString = "select pseudo from qualification order by date";
        Statement lStat = con.createStatement(
                                            ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                            ResultSet.CONCUR_READ_ONLY);
        ResultSet lResult = lStat.executeQuery(queryString);
        if ((i > 0) && (lResult.absolute(i))) {
            return creerParRequete(lResult);
        }
        else 
            return null;
    }
    
    private static Qualification creerParRequete(ResultSet result) throws Exception {
            String lUserPseudo  = result.getString("userPseudo");
            int lCanId = result.getInt("canId");
            Timestamp lDate = result.getTimestamp("date");
            int lX = result.getInt("x");
            int lY = result.getInt("y");
            String lquestionnaire  = result.getString("questionnaire");
            return new Qualification(lUserPseudo, lCanId, lDate, lX, lY, lquestionnaire);
    }
    
    /**
     * Indique le nb de qualification par candidat dans la BD
     * @param con       la connexion
     * @param canId     id du candidat concerné
     * @return lenombre de users
     * @throws java.lang.Exception
     */
    public static int size(Connection con, int canId) throws Exception {
        String queryString = "select count(*) as count from qualification"
                                + " where canId='" + canId + "'";
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
     * Indique le nb de qualification par user dans la BD
     * @param con       la connexion
     * @param userPseudo le user concerné
     * @return lenombre de users
     * @throws java.lang.Exception
     */
    public static int nbByPseudo(Connection con, String userPseudo) throws Exception {
        String queryString = "select count(*) as count from qualification"
                                + " where userPseudo='" + userPseudo + "'";
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
     * Retourne la liste de toutes les qualifications d'un user
     *
     * @param con
     * @param userPseudo
     * @return la liste des qualifications
     * @throws java.lang.Exception
     */
    public static ArrayList<Qualification> listeByPseudo(Connection con, String userPseudo) throws Exception {
        ArrayList<Qualification> qualifications = new ArrayList<Qualification>();
        String queryString = "select * from qualification, candidateEST, evenement"
                                + " where userPseudo='" + userPseudo + "'"
                                + " and canId = candidateEST.id and eventId = evenement.id"
                                + " order by evenement.date desc";
        Statement lStat = con.createStatement(
                                ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                ResultSet.CONCUR_READ_ONLY);
        ResultSet lResult = lStat.executeQuery(queryString);
        // y en a t'il au moins un ?
        while (lResult.next()) {
            qualifications.add(creerParRequete(lResult));
        }
        return qualifications;
    }
    
    /**
     * Retourne la liste de toutes les qualifications ordonnées par la date de qualification
     *
     * @param con
     * @param eventId
     * @return la liste des qualifications
     * @throws java.lang.Exception
     */
    public static ArrayList<Qualification> listeByEvent(Connection con, int eventId) throws Exception {
        ArrayList<Qualification> qualifications = new ArrayList<Qualification>();
        String queryString = "select * from qualification, candidateEST, evenement"
                                + " where evenement.id = " + eventId 
                                + " and canId = candidateEST.id and candidateEST.eventId = evenement.id"
                                + " order by evenement.date desc";
        Statement lStat = con.createStatement(
                                ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                ResultSet.CONCUR_READ_ONLY);
        ResultSet lResult = lStat.executeQuery(queryString);
        // y en a t'il au moins un ?
        while (lResult.next()) {
            qualifications.add(creerParRequete(lResult));
        }
        return qualifications;
    }
        public static int taille(Connection con) throws Exception {
        String queryString = "select count(*) as count from qualification";
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
     * Cree et initialise completement User
     */
    private Qualification(String userPseudo, int canId, Timestamp date, 
                                             int x, int y, String questionnaire) {
        this.userPseudo = userPseudo;
        this.canId = canId;
        this.date = date;
        this.x = x;
        this.y = y;
        this.questionnaire = questionnaire;
    }
    
    /**
     * Cree un nouvel objet user
     */
    private Qualification(String userPseudo, int canId, 
                                             int x, int y, String questionnaire) {
        this.userPseudo = userPseudo;
        this.canId = canId;
        this.date = 
            new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
        this.x = x;
        this.y = y;
        this.questionnaire = questionnaire;
    }
    
    // --------------------- les assesseurs ----------------------------
    public String getUserPseudo() {
        return userPseudo;
    }

    public int getCanId() {
        return canId;
    }

    public void setCanId(int canId) throws Exception {
        this.canId = canId;
    }

    public Timestamp getDate() {
        return (Timestamp)date.clone();
    }

    public void setDate(Timestamp date) throws Exception {
        this.date = (Timestamp)date.clone();
    }
    
    public String getQuestionnaire() {
        return questionnaire;
    }
    /**
     * toString() surcharge d'opérateur
     * @return   la chaine complète
     */
    @Override
    public String toString() {
        return  " userPseudo =  " + userPseudo + "\t" +
                " canId = " + Utils.toString(canId) +
                " date = " + Utils.toString(date) +
                " x = " + Utils.toString(x) +
                " y = " + Utils.toString(y) + 
                " questionnaire = " + Utils.toString(questionnaire);
    }
}