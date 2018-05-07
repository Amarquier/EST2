/*
 * Fichier : Candidate.java
 * Description : Classe interface de la table candidate
 * Cette table stocke les zones candidates pour chaque évènement
 */
package com.persistence;

import java.sql.*;
import java.util.*;

/**
 * C'est un répertoire sur le disque (dans un répertoire evenement) Qui
 * correspond à un point géométrique de l'espace (ra, dec) Ce répertoire
 * contient toutes les images de cette zone de l'espace pour un évènement donné
 *
 * hhmmssssSddmmsss S = [p|m] ex : 13564567m0328127 ra = 13h56m45.67s dec =
 * -03d28m12.7s
 */
public class CandidateEST {

    private int id;          // la clef primaire
    private String chemin;
    private double ra;
    private double dec;
    private int eventId;    // la clef étrangère

    /**
     * Retourne une actu par son id
     *
     * @param con
     * @param id
     * @return l'actu si elle existe null sinon
     * @throws java.lang.Exception
     */
    public static CandidateEST getById(Connection con, int id) throws Exception {
        String queryString = "select * from candidate where `id`=" + id;
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
     * Retourne la liste des candidates pour un évènement donné par son ID
     *
     * @param con
     * @param eventId id de l'évènement concerné
     * @return la liste des candidates pour un évènement donné
     * @throws java.lang.Exception
     */
    public static ArrayList<CandidateEST> getByEvenement(Connection con, int eventId)
            throws Exception {
        ArrayList<CandidateEST> candidates = new ArrayList<CandidateEST>();
        String queryString = "select * from candidateEST where (select count(*) as count from imageEST where imageEST.canId = candidateEST.id) >= 3 and eventId='" + eventId + "' order by ra";
        Statement lStat = con.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        ResultSet lResult = lStat.executeQuery(queryString);
        // y en a t'il au moins un ?
        while (lResult.next()) {
            candidates.add(creerParRequete(lResult));
        }
        return candidates;
    }

    /**
     * Retourne la liste des candidates pour un évènement donné par son ID
     *
     * @param con
     * @param pseudo
     * @param eventId id de l'évènement concerné
     * @return la liste des candidates pour un évènement donné
     * @throws java.lang.Exception
     */
    public static ArrayList<CandidateEST> getByEvenementAndUser(Connection con, int eventId, String pseudo)
            throws Exception {
        ArrayList<CandidateEST> candidates = new ArrayList<CandidateEST>();
        String queryString = "select * from candidateEST where"
                + " (select count(*) from qualification"
                + " where qualification.canId = candidateEST.id and userPseudo = '" + pseudo + "' ) =0"
                + " and (select count(*) from imageEST "
                + " where imageEST.canId = candidateEST.id) >= 3 "
                + " and eventId='" + eventId + "' order by ra";
        Statement lStat = con.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        ResultSet lResult = lStat.executeQuery(queryString);
        // y en a t'il au moins un ?
        while (lResult.next()) {
            candidates.add(creerParRequete(lResult));
        }
        return candidates;
    }

    /**
     * retourne l'élément i d'une zone candidate pour un évent donné
     *
     * @param con
     * @param eventId pour l'évènement concerné
     * @param i l'indice de la candidate courante
     * @return Candidate l'élément i d'une zone candidate
     * @throws java.lang.Exception
     */
    public static CandidateEST find(Connection con, int eventId, int i) throws Exception {
        String queryString = "select * from candidateEST "
                + "where eventId='" + eventId + "'";
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
     * retourne l'élément i de la table des candidate
     *
     * @param con
     * @param i l'indice de la candidate courante
     * @return Candidate l'élément i d'une zone candidate
     * @throws java.lang.Exception
     */
    public static CandidateEST find(Connection con, int i) throws Exception {
        String queryString = "select * from candidateEST";
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

    private static CandidateEST creerParRequete(ResultSet result) throws Exception {
        int lId = result.getInt("id");
        String lChemin = result.getString("chemin");
        double lRa = result.getDouble("ra");
        double lDec = result.getDouble("dec");
        int lEventId = result.getInt("eventId");
        return new CandidateEST(lId, lChemin, lRa, lDec, lEventId);
    }

    /**
     * Indique le nb de candidates dans la base de données
     *
     * @param con
     * @return le nombre de candidates
     * @throws java.lang.Exception
     */
    public static int size(Connection con) throws Exception {
        String queryString = "select count(*) as count from candidateEST";
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
     * Cree et initialise completement Candidate
     */
    private CandidateEST(int id, String chemin, double ra, double dec, int eventId) {
        this.id = id;
        this.chemin = chemin;
        this.ra = ra;
        this.dec = dec;
        this.eventId = eventId;
    }

    // --------------------- les assesseurs ----------------------------
    public int getId() {
        return id;
    }

    public String getChemin() {
        return chemin;
    }

    public Double getRa() {
        return ra;
    }

    public void setRa(Double ra) {
        this.ra = ra;
    }

    public Double getDec() {
        return dec;
    }

    public void setDec(Double dec) {
        this.dec = dec;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    /**
     * toString() surcharge d'opérateur
     *
     * @return la chaine retournée
     */
    @Override
    public String toString() {
        return " chemin =  " + Utils.toString(chemin) + "\t"
                + " ra = " + Utils.toString(ra)
                + " dec = " + Utils.toString(dec)
                + " ";
    }
}
