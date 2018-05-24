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

/**
 *
 * @author snir2g2
 */
public class CandidateSNTest extends TestCase {
    
    public CandidateSNTest(String testName) {
        super(testName);
    }



    /**
     * Test of getByImage method, of class CandidateSN.
     */
    public void testGetByImage() throws Exception {
        System.out.println("getByImage");
        Connection con = ConnexionMySQL.newConnexion();;
        String nomImage = "IC3900";
        String chemin = "/jpeg/images_SN/Tarot_Calern/20140319/";
        ArrayList<CandidateSN> result = CandidateSN.getByImage(con, nomImage, chemin);
        assertEquals("[ date =  '2018/05/16 16:30:41'	 certitude = 3 x = 136 y = 139 ra = 0.0 dec = 0.0 userPseudo = 'user1' nomImage = 'IC3900' chemin = '/jpeg/images_SN/Tarot_Calern/20140319/' ]", result);
    }

    /**
     * Test of find method, of class CandidateSN.
     */
    public void testFind_4args() throws Exception {
        System.out.println("find");
        Connection con = null;
        String nomImage = "";
        String chemin = "";
        int i = 0;
        CandidateSN expResult = null;
        CandidateSN result = CandidateSN.find(con, nomImage, chemin, i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class CandidateSN.
     */
    public void testFind_Connection_int() throws Exception {
        System.out.println("find");
        Connection con = ConnexionMySQL.newConnexion();;
        int i = 0;
        CandidateSN result = CandidateSN.find(con, i);
        assertEquals(null, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of isCandidateExiste method, of class CandidateSN.
     */
    public void testIsCandidateExiste() throws Exception {
        System.out.println("isCandidateExiste");
        Connection con = null;
        String userPseudo = "";
        String nomImage = "";
        String chemin = "";
        boolean expResult = false;
        boolean result = CandidateSN.isCandidateExiste(con, userPseudo, nomImage, chemin);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of usersPseudoForCandidate method, of class CandidateSN.
     */
    public void testUsersPseudoForCandidate() throws Exception {
        System.out.println("usersPseudoForCandidate");
        Connection con = null;
        String nomImage = "";
        String chemin = "";
        ArrayList<String> expResult = null;
        ArrayList<String> result = CandidateSN.usersPseudoForCandidate(con, nomImage, chemin);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of size method, of class CandidateSN.
     */
    public void testSize() throws Exception {
        System.out.println("size");
        Connection con = null;
        int expResult = 0;
        int result = CandidateSN.size(con);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDate method, of class CandidateSN.
     */
    public void testGetDate() {
        System.out.println("getDate");
        CandidateSN instance = null;
        Timestamp expResult = null;
        Timestamp result = instance.getDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDate method, of class CandidateSN.
     */
    public void testSetDate() {
        System.out.println("setDate");
        Timestamp date = null;
        CandidateSN instance = null;
        instance.setDate(date);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCertitude method, of class CandidateSN.
     */
    public void testGetCertitude() {
        System.out.println("getCertitude");
        CandidateSN instance = null;
        int expResult = 0;
        int result = instance.getCertitude();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCertitude method, of class CandidateSN.
     */
    public void testSetCertitude() {
        System.out.println("setCertitude");
        int certitude = 0;
        CandidateSN instance = null;
        instance.setCertitude(certitude);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getX method, of class CandidateSN.
     */
    public void testGetX() {
        System.out.println("getX");
        CandidateSN instance = null;
        int expResult = 0;
        int result = instance.getX();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setX method, of class CandidateSN.
     */
    public void testSetX() {
        System.out.println("setX");
        int x = 0;
        CandidateSN instance = null;
        instance.setX(x);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getY method, of class CandidateSN.
     */
    public void testGetY() {
        System.out.println("getY");
        CandidateSN instance = null;
        int expResult = 0;
        int result = instance.getY();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setY method, of class CandidateSN.
     */
    public void testSetY() {
        System.out.println("setY");
        int y = 0;
        CandidateSN instance = null;
        instance.setY(y);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRa method, of class CandidateSN.
     */
    public void testGetRa() {
        System.out.println("getRa");
        CandidateSN instance = null;
        Double expResult = null;
        Double result = instance.getRa();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRa method, of class CandidateSN.
     */
    public void testSetRa() {
        System.out.println("setRa");
        Double ra = null;
        CandidateSN instance = null;
        instance.setRa(ra);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDec method, of class CandidateSN.
     */
    public void testGetDec() {
        System.out.println("getDec");
        CandidateSN instance = null;
        Double expResult = null;
        Double result = instance.getDec();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDec method, of class CandidateSN.
     */
    public void testSetDec() {
        System.out.println("setDec");
        Double dec = null;
        CandidateSN instance = null;
        instance.setDec(dec);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserPseudo method, of class CandidateSN.
     */
    public void testGetUserPseudo() {
        System.out.println("getUserPseudo");
        CandidateSN instance = null;
        String expResult = "";
        String result = instance.getUserPseudo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserPseudo method, of class CandidateSN.
     */
    public void testSetUserPseudo() {
        System.out.println("setUserPseudo");
        String userPseudo = "";
        CandidateSN instance = null;
        instance.setUserPseudo(userPseudo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNomImage method, of class CandidateSN.
     */
    public void testGetNomImage() {
        System.out.println("getNomImage");
        CandidateSN instance = null;
        String expResult = "";
        String result = instance.getNomImage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNomImage method, of class CandidateSN.
     */
    public void testSetNomImage() {
        System.out.println("setNomImage");
        String nomImage = "";
        CandidateSN instance = null;
        instance.setNomImage(nomImage);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getChemin method, of class CandidateSN.
     */
    public void testGetChemin() {
        System.out.println("getChemin");
        CandidateSN instance = null;
        String expResult = "";
        String result = instance.getChemin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getnomImage method, of class CandidateSN.
     */
    public void testGetnomImage() {
        System.out.println("getnomImage");
        CandidateSN instance = null;
        String expResult = "";
        String result = instance.getnomImage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDateDisco method, of class CandidateSN.
     */
    public void testGetDateDisco() throws Exception {
        System.out.println("getDateDisco");
        CandidateSN instance = null;
        String expResult = "";
        String result = instance.getDateDisco();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDateDecouverte method, of class CandidateSN.
     */
    public void testGetDateDecouverte() {
        System.out.println("getDateDecouverte");
        CandidateSN instance = null;
        String expResult = "";
        String result = instance.getDateDecouverte();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class CandidateSN.
     */
    public void testToString() {
        System.out.println("toString");
        CandidateSN instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
