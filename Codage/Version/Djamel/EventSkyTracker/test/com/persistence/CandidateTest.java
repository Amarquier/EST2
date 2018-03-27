/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.persistence;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import junit.framework.TestCase;

/**
 *
 * @author IRISINSTALL
 */
public class CandidateTest extends TestCase {
    
    Connection con;
    
    public CandidateTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        con = ConnexionMySQL.newConnexion();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of getById method, of class Candidate.
     * 
     * Retourne une candidate par son id
     * @param con
     * @param id
     * @return la candidate si elle existe null sinon
     * @throws java.lang.Exception
     */
    public void testGetById() throws Exception {
        System.out.println("getById");
        int id = 1;
        String expResult = "/Tarot_Calern/G268556_20170409T123000/13563070m0425155";
        Candidate result = Candidate.getById(con, id);
        assertEquals(expResult, result.getChemin());
        expResult = "1";
        result = Candidate.getById(con, id);
        assertEquals(expResult, result.getId());
    }

    /**
     * Retourne la liste des candidates pour un évènement donné par son ID
     *
     * @param con
     * @param eventId id de l'évènement concerné
     * @return la liste des candidates pour un évènement donné
     * @throws java.lang.Exception
     */
    public void testGetByEvenement() throws Exception {
        System.out.println("getByEvenement");
        int eventId = 1;
        ArrayList<Candidate> expResult = null;
        ArrayList<Candidate> result = Candidate.getByEvenement(con, eventId);
        assertEquals(expResult, result);
    }

    /**
     * Test of getByEvenementAndUser method, of class Candidate.
     */
    public void testGetByEvenementAndUser() throws Exception {
        System.out.println("getByEvenementAndUser");
        Connection con = null;
        int eventId = 0;
        String pseudo = "";
        ArrayList<Candidate> expResult = null;
        ArrayList<Candidate> result = Candidate.getByEvenementAndUser(con, eventId, pseudo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class Candidate.
     */
    public void testFind_3args() throws Exception {
        System.out.println("find");
        Connection con = null;
        int eventId = 0;
        int i = 0;
        Candidate expResult = null;
        Candidate result = Candidate.find(con, eventId, i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class Candidate.
     */
    public void testFind_Connection_int() throws Exception {
        System.out.println("find");
        Connection con = null;
        int i = 0;
        Candidate expResult = null;
        Candidate result = Candidate.find(con, i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of size method, of class Candidate.
     */
    public void testSize() throws Exception {
        System.out.println("size");
        int expResult = 12;
        int result = Candidate.size(con);
        assertEquals(expResult, result);
    }
    
}
