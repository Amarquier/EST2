/* Copyright LVH COLOMIERS */
package com.metier;


/**
 * DiscoApplication : classe métier d'accès aux données persistantes
 */
public class DiscoApplication {
    
    public DiscoApplication() { } 
    
    // info à modifier en fonction de la machine de déploiement
    static public String getPath() {
        return "/home/disco/Bureau/EventSkyTracker/Codage/jpeg/";
    }
    
}