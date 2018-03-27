/*
 * Fichier : Evenement.java
 * Description : Classe interface de la table evenement
 * Cette table stocke les evenements de variations d'onde gravitationnelles
 *
 * format du répertoire évènement : IdOfficiel_yyyyMMDDThhmmss
 *      IdOfficiel : code officiel de l'évènement
 *      yyyy : l'année de l'évènement
 *      MM : le mois de l'évènement
 *      DD : le jour de l'évènement
 *      hh : l'heure de l'évènement
 *      mm : les minutes de l'évènement
 *      ss : les secondes de l'évènement
 */
package com.persistence;

import java.sql.*;
import java.util.ArrayList;

public class Evenement {

    private int id;
    private String idOfficiel;
    private String telescope;
    private String chemin;
    private String type;
    private Timestamp date;
    private boolean nouveau;

    /**
     * Retourne une actu par son id
     *
     * @param con
     * @param id
     * @return l'actu si elle existe null sinon
     * @throws java.lang.Exception
     */
    public static Evenement getById(Connection con, int id) throws Exception {
        String queryString = "select * from evenement where `id`=" + id;
        Statement lStat = con.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        ResultSet lResult = lStat.executeQuery(queryString);
        // y en a t'il au moins un ?
        if (lResult.next()) {
            return creerParRequete(lResult);
        } else {
            return null;
        }
    }

    /**
     * retourne l'élément i de la liste des evenements ordonné par la date
     * d'occurence
     *
     * @param con la connexion
     * @param i le numéro de l'événement
     * @return Evenement l'événement trouvé
     * @throws java.lang.Exception
     */
    public static Evenement find(Connection con, int i) throws Exception {
        String queryString = "select * from evenement order by `date`";
        Statement lStat = con.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        ResultSet lResult = lStat.executeQuery(queryString);
        if ((i > 0) && (lResult.absolute(i))) {
            return creerParRequete(lResult);
        } else {
            return null;
        }
    }

    /**
     * retourne l'élément i de la liste des evenements ordonné par la date
     * d'occurence pour un idOfficiel et une date donnée
     *
     * @param con la connexion
     * @param idOfficiel identificateur officiel
     * @return Evenement l'événement trouvé
     * @throws java.lang.Exception
     */
    public static Evenement find(Connection con, String idOfficiel) throws Exception {
        String queryString = "select * from evenement "
                + "where idOfficiel='" + idOfficiel + "' ";
        Statement lStat = con.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        ResultSet lResult = lStat.executeQuery(queryString);
        if (lResult.next()) {
            return creerParRequete(lResult);
        } else {
            return null;
        }
    }

    private static Evenement creerParRequete(ResultSet result) throws Exception {
        int lId = result.getInt("id");
        String lIdOfficiel = result.getString("idOfficiel");
        String lTelescope = result.getString("telescope");
        String lChemin = result.getString("chemin");
        String lType = result.getString("type");
        Timestamp lDate = result.getTimestamp("date");
        boolean lNouveau = result.getBoolean("nouveau");
        return new Evenement(lId, lIdOfficiel, lTelescope, lChemin, lType, lDate, lNouveau);
    }

    /**
     * Indique le nb d'evenements dans la base de données
     *
     * @param con
     * @return le nombre d'evenements
     * @throws java.lang.Exception
     */
    public static int size(Connection con) throws Exception {
        String queryString = "select count(*) as count from evenement";
        Statement lStat = con.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        ResultSet lResult = lStat.executeQuery(queryString);
        if (lResult.next()) {
            return (lResult.getInt("count"));
        } else {
            return 0;
        }
    }

    /**
     * Retourne la liste de tous les evements
     *
     * @param con
     * @return la liste des evements
     * @throws java.lang.Exception
     */
    public static ArrayList<Evenement> liste(Connection con) throws Exception {
        ArrayList<Evenement> evenements = new ArrayList<Evenement>();
        String queryString = "select * from evenement order by date desc";
        Statement lStat = con.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        ResultSet lResult = lStat.executeQuery(queryString);
        // y en a t'il au moins un ?
        while (lResult.next()) {
            evenements.add(creerParRequete(lResult));
        }
        return evenements;
    }

    /**
     * Cree et initialise completement un événement
     */
    private Evenement(int id, String idOfficiel, String telescope, String chemin,
            String type, Timestamp date, boolean nouveau) {
        this.id = id;
        this.idOfficiel = idOfficiel;
        this.telescope = telescope;
        this.chemin = chemin;
        this.type = type;
        this.date = (Timestamp) date.clone();
        this.nouveau = nouveau;
    }

    // --------------------- les assesseurs ----------------------------
    public String getIdOfficiel() {
        return idOfficiel;
    }

    public void setIdOfficiel(String idOfficiel) {
        this.idOfficiel = idOfficiel;
    }

    public String getTelescope() {
        return telescope;
    }

    public void setTelescope(String telescope) {
        this.telescope = telescope;
    }

    public String getChemin() {
        return chemin;
    }

    public void setChemin(String chemin) {
        this.chemin = chemin;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public boolean isNouveau() {
        return nouveau;
    }

    public void setNouveau(boolean nouveau) throws Exception {
        this.nouveau = nouveau;
    }

    public int getId() {
        return id;
    }

    /**
     * toString() surcharge de la méthode toString()
     *
     * @return la chaine retournée
     */
    @Override
    public String toString() {
        return " idOfficiel =  " + Utils.toString(idOfficiel) + "\t"
                + " telescope = " + Utils.toString(telescope)
                + " chemin = " + Utils.toString(chemin)
                + " type = " + Utils.toString(type)
                + " date = " + Utils.toString(date)
                + " ";
    }
}
