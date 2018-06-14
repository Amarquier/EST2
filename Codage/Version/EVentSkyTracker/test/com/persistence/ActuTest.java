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
        Connection con = ConnexionMySQL.newConnexion();
        assertEquals("Mise en ligne du site", Actu.getById(con, 1).getTitre());
    }

    /**
     * Test of find method, of class Actu.
     */
    public void testFind() throws Exception {
        System.out.println("find");
        Connection con = ConnexionMySQL.newConnexion();
        assertEquals("Premiere Kilonova", Actu.find(con, 1).getTitre());
        assertEquals("Fusion d'applications", Actu.find(con, 3).getTitre());
    }

    /**
     * Test of size method, of class Actu.
     */
    public void testSize() throws Exception {
        System.out.println("size");
        Connection con = ConnexionMySQL.newConnexion();
        assertEquals(13, Actu.size(con));
    }



    

    /**
     * Test of getId method, of class Actu.
     */
    public void testGetId() throws Exception {
        System.out.println("getId");
        Connection con = ConnexionMySQL.newConnexion();        
        int expResult = 13;
        Actu result = Actu.find(con, 1);
        assertEquals(expResult, result.getId());

    }

    /**
     * Test of getDate method, of class Actu.
     */
    public void testGetDate() throws Exception {
        System.out.println("getDate");
        Connection con = ConnexionMySQL.newConnexion();                
        Actu result = Actu.find(con, 1);
        assertEquals("20180308", result.getDate());
    }

    /**
     * Test of setDate method, of class Actu.
     */
    public void testSetDate() throws Exception {
        System.out.println("setDate");
        Connection con = ConnexionMySQL.newConnexion();                
        String date = "20180308";
        Actu instance = Actu.find(con, 1);
        instance.setDate(date);
    }

    /**
     * Test of getTitre method, of class Actu.
     */
    public void testGetTitre() throws Exception {
        System.out.println("getTitre");
        Connection con = ConnexionMySQL.newConnexion();                
        String expResult = "Premiere Kilonova";
        Actu result = Actu.find(con, 1);
        assertEquals(expResult, result.getTitre());

    }

    /**
     * Test of setTitre method, of class Actu.
     */
    public void testSetTitre() throws Exception {
        System.out.println("setTitre");
        Connection con = ConnexionMySQL.newConnexion();                
        String titre = "Un astronome amateur capture par miracle une supernovae type 2b";
        Actu instance = Actu.find(con, 1);
        instance.setTitre(titre);

    }

    /**
     * Test of getContenu method, of class Actu.
     */
    public void testGetContenu() throws Exception {
        System.out.println("getContenu");
        Connection con = ConnexionMySQL.newConnexion();                
        String expResult = "GW170817 est le nom donné à la premiere kilonova observée par Ligo et Virgo.<br/>\n" +
"La détection du signal a été effectuée le 17 août 2017 à 12 h 41 UTC sur les trois sites, et a duré près de 100 s.<br/>\n" +
" L'analyse du signal indique le fusionnement de deux astres de 1,1 à 1,6 masses solaires (des masses typiques d'étoiles à neutrons).";
        Actu result = Actu.find(con, 1);
        assertEquals(expResult, result.getContenu());

    }

    /**
     * Test of setContenu method, of class Actu.
     */
    public void testSetContenu() throws Exception {
        System.out.println("setContenu");
        Connection con = ConnexionMySQL.newConnexion();   
        String contenu = "Baptisé SN2016gkg, a été observée \n" +
"dans la constellation du Sculpteur, visible dans l'hémisphère sud, et est située dans une galaxie distante d'environ 65 millions d'années-lumière de la Terre. \n" +
"<br/>\n" +
"L'astronome amateur argentin Victor Buso a fait une découverte extraordinaire. Le 20 septembre 2016 , \n" +
"il s'aperçoit qu'un point lumineux vient d'apparaître au sud de la galaxie spirale NGC 613. Après sa découverte, \n" +
"il a contacté le représentant en Argentine de l'AAVSO (Association américaine des observateurs d'étoiles variables), \n" +
"Sebastián Otero, pour écrire une alerte à toute la communauté astronomique, donnant les coordonnées et les caractéristiques de l'objet céleste.";
        Actu instance = Actu.find(con, 1);
        instance.setContenu(contenu);

    }
}
