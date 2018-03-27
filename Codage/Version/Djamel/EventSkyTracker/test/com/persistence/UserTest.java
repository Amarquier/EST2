/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.persistence;

import java.sql.Connection;
import java.sql.Timestamp;
import junit.framework.TestCase;

/**
 *
 * @author IRISINSTALL
 */
public class UserTest extends TestCase {
    
    public UserTest(String testName) {
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
     * Test of getByPseudo method, of class User.
     */
    public void testGetByPseudo() throws Exception {
        System.out.println("getByPseudo");
        Connection con = null;
        String pseudo = "";
        User expResult = null;
        User result = User.getByPseudo(con, pseudo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPseudoByMail method, of class User.
     */
    public void testGetPseudoByMail() throws Exception {
        System.out.println("getPseudoByMail");
        Connection con = null;
        String eMail = "";
        String expResult = "";
        String result = User.getPseudoByMail(con, eMail);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class User.
     */
    public void testFind() throws Exception {
        System.out.println("find");
        Connection con = null;
        int i = 0;
        User expResult = null;
        User result = User.find(con, i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByPseudo method, of class User.
     */
    public void testFindByPseudo() throws Exception {
        System.out.println("findByPseudo");
        Connection con = null;
        int i = 0;
        String j = "";
        User expResult = null;
        User result = User.findByPseudo(con, i, j);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isPseudoUsed method, of class User.
     */
    public void testIsPseudoUsed() throws Exception {
        System.out.println("isPseudoUsed");
        Connection con = null;
        String pseudo = "";
        boolean expResult = false;
        boolean result = User.isPseudoUsed(con, pseudo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isMailUsed method, of class User.
     */
    public void testIsMailUsed() throws Exception {
        System.out.println("isMailUsed");
        Connection con = null;
        String email = "";
        boolean expResult = false;
        boolean result = User.isMailUsed(con, email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of size method, of class User.
     */
    public void testSize() throws Exception {
        System.out.println("size");
        Connection con = null;
        int expResult = 0;
        int result = User.size(con);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sizeRecherche method, of class User.
     */
    public void testSizeRecherche() throws Exception {
        System.out.println("sizeRecherche");
        Connection con = null;
        String recherche = "";
        int expResult = 0;
        int result = User.sizeRecherche(con, recherche);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
