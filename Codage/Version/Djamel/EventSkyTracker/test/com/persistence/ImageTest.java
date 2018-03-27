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
 * @author IRISINSTALL
 */
public class ImageTest extends TestCase {
    
    public ImageTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of getById method, of class Image.
     */
    public void testGetById() throws Exception {
        System.out.println("getById");
        Connection con = null;
        int idImage = 0;
        Image expResult = null;
        Image result = Image.getById(con, idImage);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getByChemin method, of class Image.
     */
    public void testGetByChemin() throws Exception {
        System.out.println("getByChemin");
        Connection con = null;
        String chemin = "";
        Image expResult = null;
        Image result = Image.getByChemin(con, chemin);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOneByCandidate method, of class Image.
     */
    public void testGetOneByCandidate() throws Exception {
        System.out.println("getOneByCandidate");
        Connection con = null;
        int canId = 0;
        int i = 0;
        Image expResult = null;
        Image result = Image.getOneByCandidate(con, canId, i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getByCandidate method, of class Image.
     */
    public void testGetByCandidate() throws Exception {
        System.out.println("getByCandidate");
        Connection con = null;
        int canId = 0;
        ArrayList<Image> expResult = null;
        ArrayList<Image> result = Image.getByCandidate(con, canId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sizeByCandidate method, of class Image.
     */
    public void testSizeByCandidate() throws Exception {
        System.out.println("sizeByCandidate");
        Connection con = null;
        int canId = 0;
        int expResult = 0;
        int result = Image.sizeByCandidate(con, canId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of size method, of class Image.
     */
    public void testSize() throws Exception {
        System.out.println("size");
        Connection con = null;
        int expResult = 0;
        int result = Image.size(con);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
