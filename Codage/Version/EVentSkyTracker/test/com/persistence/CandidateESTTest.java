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
public class CandidateESTTest extends TestCase {
    
    Connection con;
    
    public CandidateESTTest(String testName) {
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
        String expResult = "/Tarot_Calern/G268556_20170409T123000/13563070m0425155";
        CandidateEST result = CandidateEST.getById(con, 1);
        assertEquals(expResult, result.getChemin());
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
        ArrayList<CandidateEST> result = CandidateEST.getByEvenement(con, eventId);
        assertEquals(result.size(), 2);
        assertEquals("/Tarot_Calern/G268556_20170409T123000/13564567m0328127", result.get(1).getChemin());
    }

    /**
     * Test of getByEvenementAndUser method, of class Candidate.
     */
    public void testGetByEvenementAndUser() throws Exception {
        System.out.println("getByEvenementAndUser");
        Connection con = ConnexionMySQL.newConnexion();
        int eventId = 1;
        String pseudo = "user1";
        ArrayList<CandidateEST> result = CandidateEST.getByEvenementAndUser(con, eventId, pseudo);
        assertEquals("/Tarot_Calern/G268556_20170409T123000/13563070m0425155", result.get(0).getChemin());

    }

    /**
     * Test of find method, of class Candidate.
     */
    public void testFind_3args() throws Exception {
        System.out.println("find");
        Connection con = ConnexionMySQL.newConnexion();
        int eventId = 1;
        int i = 2;
        String expResult = "/Tarot_Calern/G268556_20170409T123000/13564567m0328127";
        CandidateEST result = CandidateEST.find(con, eventId, i);
        assertEquals(expResult, result.getChemin());
    }

    /**
     * Test of find method, of class Candidate.
     */
    public void testFind_Connection_int() throws Exception {
        System.out.println("find");
        Connection con = ConnexionMySQL.newConnexion();
        int i = 1;
        CandidateEST result = CandidateEST.find(con, i);
        assertEquals("/Tarot_Calern/G268556_20170409T123000/13563070m0425155", result.getChemin());
    }

    /**
     * Test of size method, of class Candidate.
     */
    public void testSize() throws Exception {
        System.out.println("size");
        int expResult = 12;
        int result = CandidateEST.size(con);
        assertEquals(expResult, result);
    }
    
}
