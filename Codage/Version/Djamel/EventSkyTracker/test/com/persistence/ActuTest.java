/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.persistence;

import java.sql.Connection;
import junit.framework.TestCase;

/**
 *
 * @author IRISINSTALL
 */
public class ActuTest extends TestCase {
    
    public ActuTest(String testName) {
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
     * Test of getById method, of class Actu.
     */
    public void testGetById() throws Exception {
        System.out.println("getById");
        Connection con = null;
        int idActu = 0;
        Actu expResult = null;
        Actu result = Actu.getById(con, idActu);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class Actu.
     */
    public void testFind() throws Exception {
        System.out.println("find");
        Connection con = null;
        int i = 0;
        Actu expResult = null;
        Actu result = Actu.find(con, i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of size method, of class Actu.
     */
    public void testSize() throws Exception {
        System.out.println("size");
        Connection con = null;
        int expResult = 0;
        int result = Actu.size(con);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
