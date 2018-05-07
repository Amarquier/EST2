/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.persistence;

import com.metier.SmtpSend;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import junit.framework.TestCase;
import java.sql.*;

/**
 *
 * @author IRISINSTALL
 */
public class EvenementTest extends TestCase {
    
    Connection con;
    
    public EvenementTest(String testName) {
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
     * Retourne 
     *
     * @param con
     * @param id
     * @return 
     * @throws java.lang.Exception
   
    public void  testGetById() throws Exception {
        System.out.println("getById");
        int id = 1;
        String expResult = "/Tarot_Calern/G268556_20170409T123000";
        Evenement result = Evenement.getById(con, id);
        assertEquals(expResult, result.getChemin());
        expResult = "G268556";
        result = Evenement.getById(con, id);
        assertEquals(expResult, result.getIdOfficiel());
        // autre id
        id = 3;
        expResult = "/Tarot_Calern/H789456_20170430T235012";
        result = Evenement.getById(con, id);
        assertEquals(expResult, result.getChemin());
        expResult = "H789456";
        result = Evenement.getById(con, id);
        assertEquals(expResult, result.getIdOfficiel());
    } */

    /**
     * Test of find method, of class Evenement.
     * @throws java.lang.Exception
     */
    public void testFind_Connection_int() throws Exception {
        System.out.println("find");
        int position = 3;
        String expResult = "H789456";
        Evenement result = Evenement.find(con, position);
        assertEquals(expResult, result.getIdOfficiel());
        // autre test
        position = 2;
        expResult = "J789632";
        result = Evenement.find(con, position);
        assertEquals(expResult, result.getIdOfficiel());
    }

    /**
     * retourne l'élément i de la liste des evenements ordonné par la date
     * d'occurence pour un idOfficiel et une date donnée
     * 
     * Test of find method, of class Evenement.
     * @throws java.lang.Exception
     *
    */
    public void testFind_2args() throws Exception {
        System.out.println("find");
        String idOfficiel = "G268556";
        String expResult = "/Tarot_Calern/G268556_20170409T123000";
        Evenement result = Evenement.find(con, idOfficiel);
        assertEquals(expResult, result.getChemin());
        // autre test
        idOfficiel = "W265622";
        expResult = "/Tarot_Chili/W265622_20170510T221206";
        result = Evenement.find(con, idOfficiel);
        assertEquals(expResult, result.getChemin());
    }
    
    /**
     * Indique le nb d'evenements dans la base de données
     *
     * @param con
     * @return le nombre d'evenements
     * @throws java.lang.Exception
     */
    public void testSize() throws Exception {
        System.out.println("size");
        int expResult = 4;
        int result = Evenement.size(con);
        assertEquals(expResult, result);
    }

    /**
     * retourne l'élément i de la liste des evenements ordonné par la date
     * d'occurence
     *
     * @param con la connexion
     * @param i le numéro de l'événement
     * @return Evenement l'événement trouvé
     * @throws java.lang.Exception
     */
    public void testListe() throws Exception {
        System.out.println("liste");
        ArrayList<Evenement> result = Evenement.liste(con);
        // test du nombre d'evenements
        assertEquals(4, result.size());
        // test : l'événement arrivé en dernier sort en 1er position
        assertEquals("W265622", result.get(0).getIdOfficiel());
        assertEquals("H789456", result.get(1).getIdOfficiel());
    }
        public static void autoMail (Connection con) throws Exception {
        System.out.println("autoMail");           

        }
}
