/*
 * Projet  : eventSkyTracker
 * Fichier : User.java
 * Description : Classe interface de la table user
 * Cette table stocke les infos sur les utilisateurs connus du logiciel
 */

package com.persistence;

import java.sql.*;
import java.util.*;

public class User {
    private String    pseudo;           // la clef primaire
    private String    username;
    private String    email;            // son mail (unique)
    private String    password;         
    private String    mailconfirme;
    private int       lastCan;          // le dernier candidat qualifié
    private int       grade;            // son grade de 1 à 5
    private boolean   blocked;          // si on l'a interdit d'accès
    private Timestamp registerDate;     // la date de son inscription
    private Timestamp lastVisitDate;    // la date de sa dernière visite
    private int       nbQualifications; // le nb de qualifications faites
    private int       nbConnexions;     // le nb de connexion depuis son inscription
    
    /**
     * Créer un nouvel objet persistant 
     * @param con
     * @param pseudo
     * @param username
     * @param email
     * @param password
     * @param mailconfirme
     * @return 
     * @ return  un user si le pseudo est unique sinon null
     * @throws Exception    impossible d'accéder à la ConnexionMySQL
     *                      ou le pseudo est deja dans la BD
     * 
     */
    static public User create(Connection con, String pseudo, String username, String email, 
                                          String password, String mailconfirme)  throws Exception {
        User user = new User(pseudo, username, email, password, mailconfirme);
        
        String queryString =
         "insert into user (`pseudo`, `username`, `email`, `password`,`mailconfirme` , `grade`,"
          + " `blocked`, `registerDate`, `lastVisitDate`, `nbQualifications`, `nbConnexions`) values ("
                + Utils.toString(pseudo) + ", " 
                + Utils.toString(username) + ", " 
                + Utils.toString(email) + ", " 
                + Utils.toString(password) + ", " 
                + Utils.toString(mailconfirme) + ", "
                + Utils.toString(user.getGrade()) + ", " 
                + Utils.toString(user.isBlocked()) + ", " 
                + Utils.toString(user.getRegisterDate()) + ", " 
                + Utils.toString(user.getLastVisitDate()) + ", " 
                + Utils.toString(user.getNbQualifications()) + ", "  
                + Utils.toString(user.getNbConnexions())
          + ")";
        Statement lStat = con.createStatement();
        lStat.executeUpdate(queryString, Statement.NO_GENERATED_KEYS);
        return user;
    }
    
    /**
     * update de l'objet user dans la ConnexionMySQL
     * @param con
     * @throws Exception    impossible d'accéder à la ConnexionMySQL
     */
    public void save(Connection con) throws Exception {
        String queryString =
         "update user set "
                + " `username` =" + Utils.toString(username) + "," 
                + " `email` =" + Utils.toString(email) + "," 
                + " `password` =" + Utils.toString(password) + "," 
                + " `mailconfirme` =" + Utils.toString(mailconfirme) + "," 
                + " `grade` =" + Utils.toString(grade) + "," 
                + " `blocked` =" + Utils.toString(blocked) + ","
                + " `lastCan` =" + Utils.toString(lastCan) + ","
                + " `registerDate` =" + Utils.toString(registerDate) + "," 
                + " `lastVisitDate` =" + Utils.toString(lastVisitDate)  + "," 
                + " `nbQualifications` =" + Utils.toString(nbQualifications)  + ","
                + " `nbConnexions` =" + Utils.toString(nbConnexions)
                + " where pseudo='" + pseudo + "'";
        Statement lStat = con.createStatement();
        lStat.executeUpdate(queryString, Statement.NO_GENERATED_KEYS);
    }

    /**
     * suppression de l'objet user dans la BD
     * @param con
     * @return 
     * @throws SQLException    impossible d'accéder à la ConnexionMySQL
     */
    public boolean delete(Connection con) throws Exception {
        String queryString = "delete from user where pseudo='" + pseudo + "'";
        Statement lStat = con.createStatement();
        lStat.executeUpdate(queryString);
        return true;
    }
    
    /**
     * Retourne un user trouve par son pseudo, saved is true
     * @param con
     * @param  pseudo le pseudo à trouver
     * @return the user trouve par pseudo
     * @throws java.lang.Exception
     */
    public static User getByPseudo(Connection con, String pseudo) throws Exception {
        String queryString = "select * from user where pseudo='" + pseudo + "'";
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
     * Retourne le pseudo trouvé par le mail
     * @param con
     * @param  eMail le eMail à trouver
     * @return le pseudo trouvé par le mail
     * @throws java.lang.Exception
     */
    public static String getPseudoByMail(Connection con, String eMail) throws Exception {
        String queryString = "select * from user where email='" + eMail + "'";
        Statement lStat = con.createStatement(
                                ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                ResultSet.CONCUR_READ_ONLY);
        ResultSet lResult = lStat.executeQuery(queryString);
        // y en a t'il au moins un ?
        if (lResult.next()) {
            String    lPseudo  = lResult.getString("pseudo");
            return lPseudo;
        }
        else
            return null;
    }
    
    /**
     * retourne l'élément i trié par le nom, saved is true
     * @param con
     * @param  i       le nom de la personne courante
     * @return String la liste des nom des personnes inscrites
     * @throws java.lang.Exception
     */
    public static User find(Connection con, int i) throws Exception {
        String queryString = "select pseudo from user order by pseudo";
        Statement lStat = con.createStatement(
                                            ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                            ResultSet.CONCUR_READ_ONLY);
        ResultSet lResult = lStat.executeQuery(queryString);
        if ((i > 0) && (lResult.absolute(i))) {
            String pseudoFound = lResult.getString("pseudo");
            return User.getByPseudo(con, pseudoFound);
        }
        else 
            return null;
    }
    
        /**
     * retourne le premier pseudo qui commence par i, saved is true
     * @param con
     * @param  i       ce que contient la recherche
     * @return String la liste des nom des personnes inscrites
     * @throws java.lang.Exception
     */
    public static User findByPseudo(Connection con, int i, String j) throws Exception {
        String queryString = "select pseudo from user where pseudo LIKE '%"+j+"%'order by pseudo";
        Statement lStat = con.createStatement(
                                            ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                            ResultSet.CONCUR_READ_ONLY);
        ResultSet lResult = lStat.executeQuery(queryString);
        if ((i > 0) && (lResult.absolute(i))) {
            String pseudoFound = lResult.getString("pseudo");
            return User.getByPseudo(con, pseudoFound);
        }
        else 
            return null;
    }
    
    private static User creerParRequete(ResultSet result) throws Exception {
            String    lPseudo  = result.getString("pseudo");
            String    lUsername = result.getString("username");
            String    lEmail = result.getString("email");
            String    lPassword = result.getString("password");
            String    lMailConfirme = result.getString("mailconfirme");
            int       lGrade = result.getInt("grade");
            boolean   lBlocked = result.getBoolean("blocked");
            int       llastCan = result.getInt("lastCan");
            Timestamp lRegisterDate = result.getTimestamp("registerDate");
            Timestamp lLastVisitDate = result.getTimestamp("lastVisitDate");
            int       lNbQualifications = result.getInt("nbQualifications");
            int       lNbConnexions = result.getInt("nbConnexions");
            return    new User(lPseudo,lUsername,lEmail,lPassword,lMailConfirme,
                                lGrade, lBlocked, llastCan, lRegisterDate, 
                                lLastVisitDate, lNbQualifications, lNbConnexions);
    }
    
    /**
     * Indique si le nom d'une personne existe déjà ou non ?
     * Pour unicité du nom
     * @param con
     * @param  pseudo le nom à trouver
     * @return true si le nom existe déjà
     * @throws java.lang.Exception
     */
    public static boolean isPseudoUsed(Connection con, String pseudo) throws Exception {
        String queryString = "select pseudo from user where pseudo='" + pseudo + "'";
        Statement lStat = con.createStatement(
                                ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                ResultSet.CONCUR_READ_ONLY);
        ResultSet lResult = lStat.executeQuery(queryString);
        // y en a t'il au moins un ?
        return lResult.next();
    }
    
    /**
     * Indique si le email d'une personne existe déjà ou non ?
     * Pour unicité du email
     * @param con
     * @param  email le mail à trouver
     * @return true si le email existe déjà
     * @throws java.lang.Exception
     */
    public static boolean isMailUsed(Connection con, String email) throws Exception {
        String queryString = "select `email` from user where `email`='" + email + "'";
        Statement lStat = con.createStatement(
                                ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                ResultSet.CONCUR_READ_ONLY);
        ResultSet lResult = lStat.executeQuery(queryString);
        // y en a t'il au moins un ?
        return lResult.next();
    }
    
    /**
     * Indique le nb de users dans la base de données
     * @param con
     * @return lenombre de users
     * @throws java.lang.Exception
     */
    public static int size(Connection con) throws Exception {
        String queryString = "select count(*) as count from user";
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
     * Indique le nb de users dans la base de données
     * @param con
     * @param recherche
     * @return lenombre de users
     * @throws java.lang.Exception
     */
    public static int sizeRecherche(Connection con, String recherche) throws Exception {
        int size = User.size(con);
        int sizeRecherche=0;
        for(int i=1;i<size;i++){
            if(User.findByPseudo(con, i, recherche)!=null){
                sizeRecherche = sizeRecherche + 1;
            }
        }
        return sizeRecherche;
    }
    
    /**
     * Cree et initialise completement User
     */
    private User(String pseudo, String username, String email, String password, 
            String mailconfirme, int grade, boolean blocked, int lastCan, 
            Timestamp registerDate, Timestamp lastVisitDate, int nbQualifications, 
            int nbConnexions) {
        this.pseudo = pseudo;
        this.username = username;
        this.email = email;
        this.password = password;
        this.mailconfirme = mailconfirme;
        this.grade = grade;
        this.blocked = blocked;
        this.lastCan = lastCan;
        this.registerDate = (Timestamp)registerDate.clone();
        this.lastVisitDate = (Timestamp)lastVisitDate.clone();
        this.nbQualifications = nbQualifications;
        this.nbConnexions = nbConnexions;
    }
    
    /**
     * Cree un nouvel objet user
     */
    private User(String pseudo, String username, String email, String password, 
            String mailconfirme) {
        Timestamp currentTimestamp = 
            new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
        this.grade = 1;
        this.blocked = false;
        this.lastCan = -1;
        this.nbQualifications = 0;
        this.nbConnexions = 1;
        this.pseudo = pseudo;
        this.username = username;
        this.email = email;
        this.password = password;
        this.mailconfirme = mailconfirme;
        this.registerDate = currentTimestamp;
        this.lastVisitDate = (Timestamp)currentTimestamp.clone(); 
    }
    
    // --------------------- les assesseurs ----------------------------
    public String getPseudo() {
        return pseudo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) throws Exception {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws Exception {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws Exception {
        this.password = password;
    }
    
    public String getMailConfirme() {
        return mailconfirme;
    }

    public void setMailConfirme(String mailconfirme) throws Exception {
        this.mailconfirme = mailconfirme;
    }
    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) throws Exception {
        this.grade = grade;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) throws Exception {
        this.blocked = blocked;
    }
   
    public int getlastCan() {
        return lastCan;
    }

    public Timestamp getRegisterDate() {
        return (Timestamp)registerDate.clone();
    }

    public void setRegisterDate(Timestamp registerDate) throws Exception {
        this.registerDate = registerDate;
    }

    public int getNbQualifications() {
        return nbQualifications;
    }

    public void setNbQualifications(int nbQualifications) throws Exception {
        this.nbQualifications = nbQualifications;
    }
    
    public int getNbConnexions() {
        return nbConnexions;
    }

    public void setNbConnexions(int nbConnexions) {
        this.nbConnexions = nbConnexions;
    }

    public Timestamp getLastVisitDate() {
        return (Timestamp)lastVisitDate.clone();
    }

    public void setLastVisitDate(Timestamp lastVisitDate) throws Exception {
        this.lastVisitDate = lastVisitDate;
    }
    
    /**
     * toString() operator overload
     * @return   the result string
     */
    @Override
    public String toString() {
        return  " pseudo =  " + pseudo + "\t" +
                " username = " + Utils.toString(username) +
                " email = " + Utils.toString(email) +
                " password = " + Utils.toString(password) + 
                " mailconfirme = " + Utils.toString(mailconfirme) + 
                " lastCan = " + Utils.toString(lastCan) +
                " grade = " + Utils.toString(grade) + 
                " blocked = " + Utils.toString(blocked) + 
                " registerDate = " + Utils.toString(registerDate) +
                " lastVisitDate = " + Utils.toString(lastVisitDate) +
                " nbQualifications = " + Utils.toString(nbQualifications) + 
                " nbConnexions = " + Utils.toString(nbConnexions)
                + " ";
    }
}