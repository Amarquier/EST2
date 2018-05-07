/* Copyright LVH COLOMIERS */
package com.metier;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * ESTApplication : classe métier d'accès aux données persistantes
 */
public class ESTApplication {
    
    public ESTApplication() { } 
    
    // info à modifier en fonction de la machine de déploiement
    static public String getPath() {
        return "/home/snir2g2/Bureau/jpeg/";
    }
    
    // ne pas toucher
    // dépend de getPath()
    static public String getRefPath() {
        return getPath() + "/refgal";
    }
    
    // retourne si l'image de reference existe ou non 
    static public boolean isRefFileExist(String refName) {
        String filePathString = ESTApplication.getRefPath() + "/" + refName + ".jpg";
        File f = new File(filePathString);
        return (f.exists() && !f.isDirectory());
    }
    
        /**
     * Remplace ou ajoute un fichier de référence 
     * @param source
     * @param destination
     * @return
     * @throws IOException
     */
    static public boolean remplacer(String source, String destination) throws IOException {
        Path psource = Paths.get(source);
        Path pdestination = Paths.get(destination);
        Files.copy(psource, pdestination, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.COPY_ATTRIBUTES);
        return true;
    }
}