/*
 * Fichier : Image.java
 * Description : Classe interface de la table image
 * Cette table gère les images stockées dans les répertoires de candidates
 */
package com.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.*;

public class ImageEST {

    private int id;          // clef primaire sur la candidate
    private int canId;       // clef étrangère sur la candidate
    private String chemin;
    private Timestamp dateobs;  // Date de l'observation
    private double crpix1;
    private double crpix2;
    private double crval1;
    private double crval2;
    private double cdelt1;
    private double cdelt2;
    private double crota2;
    private double ra;
    private double dec;

    /**
     * Retourne une image par son id
     *
     * @param con
     * @param idImage
     * @return la Galaxie si elle existe null sinon
     * @throws java.lang.Exception
     */
    public static ImageEST getById(Connection con, int idImage) throws Exception {
        String queryString = "select * from imageEST where `id`='" + idImage + "'";
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
     * retourne l'image par son chemin
     *
     * @param con
     * @param chemin le chemin qui accède à cette image
     * @return
     * @throws java.lang.Exception
     */
    public static ImageEST getByChemin(Connection con, String chemin) throws Exception {
        String queryString = "select `id` from imageEST" + " where `chemin`='" + chemin + "'";
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

    /**
     * retourne la ième image de la liste des images pour une candidate donnée
     * et triée par date d'observation
     *
     * @param con
     * @param canId id du candidat concerné par cette image
     * @param i la position de l'objet courant, de 1 à N
     * @return Image la ieme image de cette journée
     * @throws java.lang.Exception
     */
    public static ImageEST getOneByCandidate(Connection con, int canId, int i) throws Exception {
        String queryString = "select * from imageEST "
                + "where `canId`='" + canId
                + "' order by dateobs";
        Statement lStat = con.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        ResultSet lResult = lStat.executeQuery(queryString);
        if ((i > 0) && lResult.absolute(i)) {
            return creerParRequete(lResult);
        } else {
            return null;
        }
    }

    /**
     * retourne toutes les images d'une candidate concernée
     *
     * @param con
     * @param canId id du candidat contenant ces images
     * @return une collection d'images
     * @throws java.lang.Exception
     */
    public static ArrayList<ImageEST> getByCandidate(Connection con, int canId) throws Exception {
        ArrayList<ImageEST> images = new ArrayList<ImageEST>();
        // 
        String queryString = "select * from imageEST "
                + "where `canId`='" + canId
                + "' order by dateobs";
        Statement lStat = con.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        ResultSet lResult = lStat.executeQuery(queryString);

        while (lResult.next()) {
            images.add(creerParRequete(lResult));
        }
        return images;
    }

    private static ImageEST creerParRequete(ResultSet result) throws Exception {
        int lId = result.getInt("id");
        int lCanId = result.getInt("canId");
        String lChemin = result.getString("chemin");
        Timestamp lDateobs = result.getTimestamp("dateobs");
        double lCrpix1 = result.getDouble("crpix1");
        double lCrpix2 = result.getDouble("crpix2");
        double lCrval1 = result.getDouble("crval1");
        double lCrval2 = result.getDouble("crval2");
        double lCdelt1 = result.getDouble("cdelt1");
        double lCdelt2 = result.getDouble("cdelt2");
        double lCrota2 = result.getDouble("crota2");
        double lRa = result.getDouble("ra");
        double lDec = result.getDouble("dec");
        return new ImageEST(lId, lCanId, lChemin, lDateobs,
                lCrpix1, lCrpix2, lCrval1, lCrval2,
                lCdelt1, lCdelt2, lCrota2, lRa, lDec);
    }

    /**
     * Indique le nb d'images d'une candidate donnée
     *
     * @param con
     * @param canId
     * @return le nombre d'images trouvées
     * @throws java.lang.Exception
     */
    public static int sizeByCandidate(Connection con, int canId) throws Exception {
        String queryString = "select count(*) as count from imageEST "
                + "where `canId`='" + canId;
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
     * Indique le nb d'images dans cette table
     *
     * @param con
     * @return le nombre d'images trouvées
     * @throws java.lang.Exception
     */
    public static int size(Connection con) throws Exception {
        String queryString = "select count(*) as count from imageEST";
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
     * Cree et initialise completement une image
     */
    private ImageEST(int id, int canId, String chemin, Timestamp dateobs,
            double crpix1, double crpix2, double crval1, double crval2,
            double cdelt1, double cdelt2, double crota2, double ra, double dec) {
        this.id = id;
        this.canId = canId;
        this.chemin = chemin;
        this.dateobs = (Timestamp) dateobs.clone();
        this.crpix1 = crpix1;
        this.crpix2 = crpix2;
        this.crval1 = crval1;
        this.crval2 = crval2;
        this.cdelt1 = cdelt1;
        this.cdelt2 = cdelt2;
        this.crota2 = crota2;
        this.ra = ra;
        this.dec = dec;
    }

    // ---------------- les getters (uniquement en lecture) --------------------
    public int getCanId() {
        return canId;
    }

    public Timestamp getDateObs() {
        return dateobs;
    }

    public String getChemin() {
        return chemin;
    }

    public Timestamp getDateobs() {
        return dateobs;
    }

    public double getCrpix1() {
        return crpix1;
    }

    public double getCrpix2() {
        return crpix2;
    }

    public double getCrval1() {
        return crval1;
    }

    public double getCrval2() {
        return crval2;
    }

    public double getCdelt1() {
        return cdelt1;
    }

    public double getCdelt2() {
        return cdelt2;
    }

    public double getCrota2() {
        return crota2;
    }

    public double getRa() {
        return ra;
    }

    public double getDec() {
        return dec;
    }

    /**
     * toString() surcharge de la méthode toString()
     *
     * @return la chaine retournée
     */
    @Override
    public String toString() {
        return " chemin =  " + Utils.toString(chemin) + "\t"
                + " dateobs = " + Utils.toString(dateobs) + "\t"
                + " crpix1 = " + Utils.toString(crpix1) + "\t"
                + " crpix2 = " + Utils.toString(crpix2) + "\t"
                + " crval1 = " + Utils.toString(crval1) + "\t"
                + " crval2 = " + Utils.toString(crval2) + "\t"
                + " cdelt1 = " + Utils.toString(cdelt1) + "\t"
                + " cdelt2 = " + Utils.toString(cdelt2) + "\t"
                + " crota2 = " + Utils.toString(crota2) + "\t"
                + " ra  = " + Utils.toString(ra)
                + " dec = " + Utils.toString(dec)
                + " ";
    }
}
