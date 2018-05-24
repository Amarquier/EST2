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
public class ImageESTTest extends TestCase {
    
    public ImageESTTest(String testName) {
        super(testName);
    }

    /**
     * Test of getById method, of class ImageEST.
     */
    public void testGetById() throws Exception {
        System.out.println("getById");
        Connection con = ConnexionMySQL.newConnexion();
        ImageEST result = ImageEST.getById(con,1);
        Double result2 = result.getRa();
        assertEquals(209.1279167, result2);
    }

    /**
     * Test of getByChemin method, of class ImageEST.
     */
    public void testGetByChemin() throws Exception {
        System.out.println("getByChemin");
        Connection con = null;
        String chemin = "";
        ImageEST expResult = null;
        ImageEST result = ImageEST.getByChemin(con, chemin);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOneByCandidate method, of class ImageEST.
     */
    public void testGetOneByCandidate() throws Exception {
        System.out.println("getOneByCandidate");
        Connection con = null;
        int canId = 0;
        int i = 0;
        ImageEST expResult = null;
        ImageEST result = ImageEST.getOneByCandidate(con, canId, i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getByCandidate method, of class ImageEST.
     */
    public void testGetByCandidate() throws Exception {
        System.out.println("getByCandidate");
        Connection con = null;
        int canId = 0;
        ArrayList<ImageEST> expResult = null;
        ArrayList<ImageEST> result = ImageEST.getByCandidate(con, canId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sizeByCandidate method, of class ImageEST.
     */
    public void testSizeByCandidate() throws Exception {
        System.out.println("sizeByCandidate");
        Connection con = null;
        int canId = 0;
        int expResult = 0;
        int result = ImageEST.sizeByCandidate(con, canId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of size method, of class ImageEST.
     */
    public void testSize() throws Exception {
        System.out.println("size");
        Connection con = null;
        int expResult = 0;
        int result = ImageEST.size(con);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCanId method, of class ImageEST.
     */
    public void testGetCanId() {
        System.out.println("getCanId");
        ImageEST instance = null;
        int expResult = 0;
        int result = instance.getCanId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDateObs method, of class ImageEST.
     */
    public void testGetDateObs() {
        System.out.println("getDateObs");
        ImageEST instance = null;
        Timestamp expResult = null;
        Timestamp result = instance.getDateObs();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getChemin method, of class ImageEST.
     */
    public void testGetChemin() {
        System.out.println("getChemin");
        ImageEST instance = null;
        String expResult = "";
        String result = instance.getChemin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDateobs method, of class ImageEST.
     */
    public void testGetDateobs() {
        System.out.println("getDateobs");
        ImageEST instance = null;
        Timestamp expResult = null;
        Timestamp result = instance.getDateobs();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCrpix1 method, of class ImageEST.
     */
    public void testGetCrpix1() {
        System.out.println("getCrpix1");
        ImageEST instance = null;
        double expResult = 0.0;
        double result = instance.getCrpix1();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCrpix2 method, of class ImageEST.
     */
    public void testGetCrpix2() {
        System.out.println("getCrpix2");
        ImageEST instance = null;
        double expResult = 0.0;
        double result = instance.getCrpix2();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCrval1 method, of class ImageEST.
     */
    public void testGetCrval1() {
        System.out.println("getCrval1");
        ImageEST instance = null;
        double expResult = 0.0;
        double result = instance.getCrval1();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCrval2 method, of class ImageEST.
     */
    public void testGetCrval2() {
        System.out.println("getCrval2");
        ImageEST instance = null;
        double expResult = 0.0;
        double result = instance.getCrval2();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCdelt1 method, of class ImageEST.
     */
    public void testGetCdelt1() {
        System.out.println("getCdelt1");
        ImageEST instance = null;
        double expResult = 0.0;
        double result = instance.getCdelt1();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCdelt2 method, of class ImageEST.
     */
    public void testGetCdelt2() {
        System.out.println("getCdelt2");
        ImageEST instance = null;
        double expResult = 0.0;
        double result = instance.getCdelt2();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCrota2 method, of class ImageEST.
     */
    public void testGetCrota2() {
        System.out.println("getCrota2");
        ImageEST instance = null;
        double expResult = 0.0;
        double result = instance.getCrota2();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRa method, of class ImageEST.
     */
    public void testGetRa() {
        System.out.println("getRa");
        ImageEST instance = null;
        double expResult = 0.0;
        double result = instance.getRa();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDec method, of class ImageEST.
     */
    public void testGetDec() {
        System.out.println("getDec");
        ImageEST instance = null;
        double expResult = 0.0;
        double result = instance.getDec();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class ImageEST.
     */
    public void testToString() {
        System.out.println("toString");
        ImageEST instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
