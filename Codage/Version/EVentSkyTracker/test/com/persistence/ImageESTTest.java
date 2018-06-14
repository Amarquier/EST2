/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.persistence;

import java.sql.Connection;
import java.sql.Timestamp;
import java.util.ArrayList;
import junit.framework.TestCase;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

/**
 *
 * @author snir2g2
 */
public class ImageESTTest extends TestCase {
    
    public ImageESTTest(String testName) {
        super(testName);
    }



    /**
     * Test of getByImage method, of class ImageEST.
     */
    public void testGetByImage() throws Exception {
        System.out.println("getByImage");
        Connection con = ConnexionMySQL.newConnexion();
        String nomImage = "IC3900";
        String chemin = "/jpeg/images_SN/Tarot_Calern/20140319/";
        ArrayList<CandidateSN> result = CandidateSN.getByImage(con, nomImage, chemin);
        assertEquals(result.size(), 0);
    }

    /**
     * Test of find method, of class ImageEST.
     */
    public void testFind_4args() throws Exception {
        System.out.println("find");
        Connection con = ConnexionMySQL.newConnexion();
        String nomImage = "IC3900";
        String chemin = "/jpeg/images_SN/Tarot_Calern/20140319/";
        int i = 0;
        CandidateSN result = CandidateSN.find(con, nomImage, chemin, i);
        assertNull(result);
    }

    /**
     * Test of find method, of class ImageEST.
     */
    public void testFind_Connection_int() throws Exception {
        System.out.println("find");
        Connection con = ConnexionMySQL.newConnexion();
        int i = 0;
        CandidateSN result = CandidateSN.find(con, i);
        assertNull(result);
    }

    /**
     * Test of isCandidateExiste method, of class ImageEST.
     */
    public void testIsCandidateExiste() throws Exception {
        System.out.println("isCandidateExiste");
        Connection con = ConnexionMySQL.newConnexion();
        String userPseudo = "";
        String nomImage = "IC3900";
        String chemin = "/jpeg/images_SN/Tarot_Calern/20140319/";
        boolean result = CandidateSN.isCandidateExiste(con, userPseudo, nomImage, chemin);
        assertEquals(result, false);
    }

    /**
     * Test of usersPseudoForCandidate method, of class ImageEST.
     */
    public void testUsersPseudoForCandidate() throws Exception {
        System.out.println("usersPseudoForCandidate");
        Connection con = ConnexionMySQL.newConnexion();
        String nomImage = "IC3900";
        String chemin = "/jpeg/images_SN/Tarot_Calern/20140319/";
        ArrayList<String> result = CandidateSN.usersPseudoForCandidate(con, nomImage, chemin);
        assertEquals(result.size(), 0);
    }

    /**
     * Test of size method, of class ImageEST.
     */
    public void testSize() throws Exception {
        System.out.println("size");
        Connection con = ConnexionMySQL.newConnexion();
        int result = CandidateSN.size(con);
        assertEquals(result, 0);
    }

    /**
     * Test of getDate method, of class ImageEST.
     */
    public void testGetDate() throws Exception {
        System.out.println("getDate");
        Connection con = ConnexionMySQL.newConnexion();
        String nomImage = "IC3900";
        String chemin = "/jpeg/images_SN/Tarot_Calern/20140319/";
        ArrayList<CandidateSN> result = CandidateSN.getByImage(con, nomImage, chemin);
        // Test impossible car table CandidateSN vide
        assertEquals(result.size(), 0);
    }
    
    /**
     * Test of getCertitude method, of class ImageEST.
     */
    public void testGetCertitude() throws Exception {
        System.out.println("getCertitude");
        Connection con = ConnexionMySQL.newConnexion();
        String nomImage = "IC3900";
        String chemin = "/jpeg/images_SN/Tarot_Calern/20140319/";
        ArrayList<CandidateSN> result = CandidateSN.getByImage(con, nomImage, chemin);
        // Test impossible car table CandidateSN vide
        assertEquals(result.size(), 0);
    }

    /**
     * Test of getX method, of class ImageEST.
     */
    public void testGetX() throws Exception {
        System.out.println("getX");
        Connection con = ConnexionMySQL.newConnexion();
        String nomImage = "IC3900";
        String chemin = "/jpeg/images_SN/Tarot_Calern/20140319/";
        ArrayList<CandidateSN> result = CandidateSN.getByImage(con, nomImage, chemin);
        // Test impossible car table CandidateSN vide
        assertEquals(result.size(), 0);
    }

    /**
     * Test of getY method, of class ImageEST.
     */
    public void testGetY() throws Exception {
        System.out.println("getY");
        Connection con = ConnexionMySQL.newConnexion();
        String nomImage = "IC3900";
        String chemin = "/jpeg/images_SN/Tarot_Calern/20140319/";
        ArrayList<CandidateSN> result = CandidateSN.getByImage(con, nomImage, chemin);
        // Test impossible car table CandidateSN vide
        assertEquals(result.size(), 0);
    }

    /**
     * Test of getRa method, of class ImageEST.
     */
    public void testGetRa() throws Exception {
        System.out.println("getRa");
        Connection con = ConnexionMySQL.newConnexion();
        String nomImage = "IC3900";
        String chemin = "/jpeg/images_SN/Tarot_Calern/20140319/";
        ArrayList<CandidateSN> result = CandidateSN.getByImage(con, nomImage, chemin);
        // Test impossible car table CandidateSN vide
        assertEquals(result.size(), 0);
    }

    /**
     * Test of getDec method, of class ImageEST.
     */
    public void testGetDec() throws Exception {
        System.out.println("getDec");
        Connection con = ConnexionMySQL.newConnexion();
        String nomImage = "IC3900";
        String chemin = "/jpeg/images_SN/Tarot_Calern/20140319/";
        ArrayList<CandidateSN> result = CandidateSN.getByImage(con, nomImage, chemin);
        // Test impossible car table CandidateSN vide
        assertEquals(result.size(), 0);
    }

    /**
     * Test of getUserPseudo method, of class ImageEST.
     */
    public void testGetUserPseudo() throws Exception {
        System.out.println("getUserPseudo");
        Connection con = ConnexionMySQL.newConnexion();
        String nomImage = "IC3900";
        String chemin = "/jpeg/images_SN/Tarot_Calern/20140319/";
        ArrayList<CandidateSN> result = CandidateSN.getByImage(con, nomImage, chemin);
        // Test impossible car table CandidateSN vide
        assertEquals(result.size(), 0);
    }

    /**
     * Test of getNomImage method, of class ImageEST.
     */
    public void testGetNomImage() throws Exception {
        System.out.println("getNomImage");
        Connection con = ConnexionMySQL.newConnexion();
        String nomImage = "IC3900";
        String chemin = "/jpeg/images_SN/Tarot_Calern/20140319/";
        ArrayList<CandidateSN> result = CandidateSN.getByImage(con, nomImage, chemin);
        // Test impossible car table CandidateSN vide
        assertEquals(result.size(), 0);
    }

    /**
     * Test of getChemin method, of class ImageEST.
     */
    public void testGetChemin() throws Exception {
        System.out.println("getChemin");
        Connection con = ConnexionMySQL.newConnexion();
        String nomImage = "IC3900";
        String chemin = "/jpeg/images_SN/Tarot_Calern/20140319/";
        ArrayList<CandidateSN> result = CandidateSN.getByImage(con, nomImage, chemin);
        // Test impossible car table CandidateSN vide
        assertEquals(result.size(), 0);
    }

    /**
     * Test of getnomImage method, of class ImageEST.
     */
    public void testGetnomImage() throws Exception {
        System.out.println("getnomImage");
        Connection con = ConnexionMySQL.newConnexion();
        String nomImage = "IC3900";
        String chemin = "/jpeg/images_SN/Tarot_Calern/20140319/";
        ArrayList<CandidateSN> result = CandidateSN.getByImage(con, nomImage, chemin);
        // Test impossible car table CandidateSN vide
        assertEquals(result.size(), 0);
    }

    /**
     * Test of getDateDisco method, of class ImageEST.
     */
    public void testGetDateDisco() throws Exception {
        System.out.println("getDateDisco");
        Connection con = ConnexionMySQL.newConnexion();
        String nomImage = "IC3900";
        String chemin = "/jpeg/images_SN/Tarot_Calern/20140319/";
        ArrayList<CandidateSN> result = CandidateSN.getByImage(con, nomImage, chemin);
        // Test impossible car table CandidateSN vide
        assertEquals(result.size(), 0);
    }

    /**
     * Test of getDateDecouverte method, of class ImageEST.
     */
    public void testGetDateDecouverte() throws Exception {
        System.out.println("getDateDecouverte");
        Connection con = ConnexionMySQL.newConnexion();
        String nomImage = "IC3900";
        String chemin = "/jpeg/images_SN/Tarot_Calern/20140319/";
        ArrayList<CandidateSN> result = CandidateSN.getByImage(con, nomImage, chemin);
        // Test impossible car table CandidateSN vide
        assertEquals(result.size(), 0);
    }    
}
