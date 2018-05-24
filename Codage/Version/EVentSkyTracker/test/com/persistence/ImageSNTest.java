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
public class ImageSNTest extends TestCase {
    
    public ImageSNTest(String testName) {
        super(testName);
    }
    
    /**
     * Test of getById method, of class ImageSN.
     */
    public void testGetById() throws Exception {
        System.out.println("getById");
        Connection con = ConnexionMySQL.newConnexion();
        ImageSN result = ImageSN.getById(con, 1);
        double result2 = result.getRa();
        assertEquals(149.684005737, result2);
    }

    /**
     * Test of getByChemin method, of class ImageSN.
     */
    public void testGetByChemin() throws Exception {
        System.out.println("getByChemin");
        Connection con = null;
        String telescope = "";
        String galaxie = "";
        String date = "";
        ImageSN expResult = null;
        ImageSN result = ImageSN.getByChemin(con, telescope, galaxie, date);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getByCandidat method, of class ImageSN.
     */
    public void testGetByCandidat() throws Exception {
        System.out.println("getByCandidat");
        Connection con = null;
        String chemin = "";
        String nomImage = "";
        ImageSN expResult = null;
        ImageSN result = ImageSN.getByCandidat(con, chemin, nomImage);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of existByDate method, of class ImageSN.
     */
    public void testExistByDate() throws Exception {
        System.out.println("existByDate");
        Connection con = null;
        String date = "";
        boolean expResult = false;
        boolean result = ImageSN.existByDate(con, date);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class ImageSN.
     */
    public void testFind() throws Exception {
        System.out.println("find");
        Connection con = null;
        String _dateobs = "";
        int i = 0;
        ImageSN expResult = null;
        ImageSN result = ImageSN.find(con, _dateobs, i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDerniersJours method, of class ImageSN.
     */
    public void testGetDerniersJours() throws Exception {
        System.out.println("getDerniersJours");
        Connection con = null;
        ArrayList<String> expResult = null;
        ArrayList<String> result = ImageSN.getDerniersJours(con);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getImagesDuJour method, of class ImageSN.
     */
    public void testGetImagesDuJour() throws Exception {
        System.out.println("getImagesDuJour");
        Connection con = null;
        String _dateobs = "";
        ArrayList<ImageSN> expResult = null;
        ArrayList<ImageSN> result = ImageSN.getImagesDuJour(con, _dateobs);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDernieresImages method, of class ImageSN.
     */
    public void testGetDernieresImages() throws Exception {
        System.out.println("getDernieresImages");
        Connection con = null;
        String _nomGalaxie = "";
        ArrayList<String> expResult = null;
        ArrayList<String> result = ImageSN.getDernieresImages(con, _nomGalaxie);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dernierJour method, of class ImageSN.
     */
    public void testDernierJour() throws Exception {
        System.out.println("dernierJour");
        Connection con = null;
        String expResult = "";
        String result = ImageSN.dernierJour(con);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dernierJourAvant method, of class ImageSN.
     */
    public void testDernierJourAvant() throws Exception {
        System.out.println("dernierJourAvant");
        Connection con = null;
        String _jour = "";
        String expResult = "";
        String result = ImageSN.dernierJourAvant(con, _jour);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nbImageDuJour method, of class ImageSN.
     */
    public void testNbImageDuJour() throws Exception {
        System.out.println("nbImageDuJour");
        Connection con = null;
        String _jour = "";
        int expResult = 0;
        int result = ImageSN.nbImageDuJour(con, _jour);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of size method, of class ImageSN.
     */
    public void testSize() throws Exception {
        System.out.println("size");
        Connection con = null;
        int expResult = 0;
        int result = ImageSN.size(con);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class ImageSN.
     */
    public void testGetId() {
        System.out.println("getId");
        ImageSN instance = null;
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGalaxieNom method, of class ImageSN.
     */
    public void testGetGalaxieNom() {
        System.out.println("getGalaxieNom");
        ImageSN instance = null;
        String expResult = "";
        String result = instance.getGalaxieNom();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGalaxieRef method, of class ImageSN.
     */
    public void testGetGalaxieRef() {
        System.out.println("getGalaxieRef");
        ImageSN instance = null;
        String expResult = "";
        String result = instance.getGalaxieRef();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changeGalaxieRef method, of class ImageSN.
     */
    public void testChangeGalaxieRef() {
        System.out.println("changeGalaxieRef");
        ImageSN instance = null;
        instance.changeGalaxieRef();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDate method, of class ImageSN.
     */
    public void testGetDate() {
        System.out.println("getDate");
        ImageSN instance = null;
        String expResult = "";
        String result = instance.getDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getChemin method, of class ImageSN.
     */
    public void testGetChemin() {
        System.out.println("getChemin");
        ImageSN instance = null;
        String expResult = "";
        String result = instance.getChemin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDateobs method, of class ImageSN.
     */
    public void testGetDateobs() {
        System.out.println("getDateobs");
        ImageSN instance = null;
        Timestamp expResult = null;
        Timestamp result = instance.getDateobs();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCrpix1 method, of class ImageSN.
     */
    public void testGetCrpix1() {
        System.out.println("getCrpix1");
        ImageSN instance = null;
        double expResult = 0.0;
        double result = instance.getCrpix1();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCrpix2 method, of class ImageSN.
     */
    public void testGetCrpix2() {
        System.out.println("getCrpix2");
        ImageSN instance = null;
        double expResult = 0.0;
        double result = instance.getCrpix2();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCrval1 method, of class ImageSN.
     */
    public void testGetCrval1() {
        System.out.println("getCrval1");
        ImageSN instance = null;
        double expResult = 0.0;
        double result = instance.getCrval1();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCrval2 method, of class ImageSN.
     */
    public void testGetCrval2() {
        System.out.println("getCrval2");
        ImageSN instance = null;
        double expResult = 0.0;
        double result = instance.getCrval2();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCdelt1 method, of class ImageSN.
     */
    public void testGetCdelt1() {
        System.out.println("getCdelt1");
        ImageSN instance = null;
        double expResult = 0.0;
        double result = instance.getCdelt1();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCdelt2 method, of class ImageSN.
     */
    public void testGetCdelt2() {
        System.out.println("getCdelt2");
        ImageSN instance = null;
        double expResult = 0.0;
        double result = instance.getCdelt2();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCrota2 method, of class ImageSN.
     */
    public void testGetCrota2() {
        System.out.println("getCrota2");
        ImageSN instance = null;
        double expResult = 0.0;
        double result = instance.getCrota2();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRa method, of class ImageSN.
     */
    public void testGetRa() {
        System.out.println("getRa");
        ImageSN instance = null;
        double expResult = 0.0;
        double result = instance.getRa();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDec method, of class ImageSN.
     */
    public void testGetDec() {
        System.out.println("getDec");
        ImageSN instance = null;
        double expResult = 0.0;
        double result = instance.getDec();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
