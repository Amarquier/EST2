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
public class QualificationTest extends TestCase {
    
    public QualificationTest(String testName) {
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
     * Test of getByCandidate method, of class Qualification.
     */
    public void testGetByCandidate() throws Exception {
        System.out.println("getByCandidate");
        Connection con = null;
        int canId = 0;
        ArrayList<Qualification> expResult = null;
        ArrayList<Qualification> result = Qualification.getByCandidate(con, canId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getByPseudoAndCandidat method, of class Qualification.
     */
    public void testGetByPseudoAndCandidat() throws Exception {
        System.out.println("getByPseudoAndCandidat");
        Connection con = null;
        String userPseudo = "";
        int canId = 0;
        Qualification expResult = null;
        Qualification result = Qualification.getByPseudoAndCandidat(con, userPseudo, canId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class Qualification.
     */
    public void testFind() throws Exception {
        System.out.println("find");
        Connection con = null;
        int i = 0;
        Qualification expResult = null;
        Qualification result = Qualification.find(con, i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of size method, of class Qualification.
     */
    public void testSize() throws Exception {
        System.out.println("size");
        Connection con = null;
        int canId = 0;
        int expResult = 0;
        int result = Qualification.size(con, canId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nbByPseudo method, of class Qualification.
     */
    public void testNbByPseudo() throws Exception {
        System.out.println("nbByPseudo");
        Connection con = null;
        String userPseudo = "";
        int expResult = 0;
        int result = Qualification.nbByPseudo(con, userPseudo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listeByPseudo method, of class Qualification.
     */
    public void testListeByPseudo() throws Exception {
        System.out.println("listeByPseudo");
        Connection con = null;
        String userPseudo = "";
        ArrayList<Qualification> expResult = null;
        ArrayList<Qualification> result = Qualification.listeByPseudo(con, userPseudo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listeByEvent method, of class Qualification.
     */
    public void testListeByEvent() throws Exception {
        System.out.println("listeByEvent");
        Connection con = null;
        int eventId = 0;
        ArrayList<Qualification> expResult = null;
        ArrayList<Qualification> result = Qualification.listeByEvent(con, eventId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserPseudo method, of class Qualification.
     */
    public void testGetUserPseudo() {
        System.out.println("getUserPseudo");
        Qualification instance = null;
        String expResult = "";
        String result = instance.getUserPseudo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCanId method, of class Qualification.
     */
    public void testGetCanId() {
        System.out.println("getCanId");
        Qualification instance = null;
        int expResult = 0;
        int result = instance.getCanId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCanId method, of class Qualification.
     */
    public void testSetCanId() throws Exception {
        System.out.println("setCanId");
        int canId = 0;
        Qualification instance = null;
        instance.setCanId(canId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDate method, of class Qualification.
     */
    public void testGetDate() {
        System.out.println("getDate");
        Qualification instance = null;
        Timestamp expResult = null;
        Timestamp result = instance.getDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDate method, of class Qualification.
     */
    public void testSetDate() throws Exception {
        System.out.println("setDate");
        Timestamp date = null;
        Qualification instance = null;
        instance.setDate(date);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQuestionnaire method, of class Qualification.
     */
    public void testGetQuestionnaire() {
        System.out.println("getQuestionnaire");
        Qualification instance = null;
        String expResult = "";
        String result = instance.getQuestionnaire();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Qualification.
     */
    public void testToString() {
        System.out.println("toString");
        Qualification instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
