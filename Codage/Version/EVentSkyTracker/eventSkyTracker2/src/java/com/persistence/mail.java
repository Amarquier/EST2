package com.persistence;

import com.metier.SmtpSend;
import com.persistence.Evenement;
import com.persistence.ConnexionMySQL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.*;
import com.sun.mail.smtp.*;

/**
 *
 * @author snir2g2
 */
public class mail {

    public static Connection con;

    /**
     * Automatisation de l'envoi de mail
     *
     * @param args
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        TimerTask tt = new unThread(0, 300000);
        for (int i = 0; i <= 30; i++) {
            System.out.println("Main");
            attendre(2000);
        }
    }

    private static class unThread extends TimerTask {

        private unThread(int delai, int periode) {
            new java.util.Timer().schedule(this, delai, periode);
        }
        @Override
        public void run() {
            System.out.println("unThread");
            try {
                if (Evenement.getNew() == true) {
                    mail.autoMail();
                    Evenement.cocherNew();

                } else {
                }
            } catch (Exception ex) {
                Logger.getLogger(mail.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private static void attendre(long duree) {
        try {
            Thread.sleep(duree);
        } catch (InterruptedException ex) {
        }
    }

    public static void autoMail() throws Exception {
        // 0->Récupération email depuis la base de donnée
        System.out.println("autoMail");
        con = ConnexionMySQL.newConnexion();
        String sql = "select email FROM `user`";
        Statement lStat = con.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        ResultSet lResult = lStat.executeQuery(sql);
        while (lResult.next()) {
            String email = lResult.getString(1);
            // 1 -> Création de la session
            Properties properties = new Properties();
            properties.setProperty("mail.transport.protocol", "smtp");
            properties.setProperty("mail.smtp.host", "smtp.gmail.com");
            properties.setProperty("mail.smtp.user", "eventskytracker");
            properties.setProperty("mail.from", "eventskytracker@gmail.com");
            properties.setProperty("mail.smtp.starttls.enable", "true");
            Session session = Session.getInstance(properties);
            // 2 -> Création du message
            MimeMessage message = new MimeMessage(session);
            try {
                message.setText("Un nouvel événement a été découvert  venez voir !!! ");
                message.setSubject("Nouvel événement ");
                message.addRecipients(Message.RecipientType.TO, email);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
            // 3 -> Envoi du message
            Transport transport = null;
            try {
                transport = session.getTransport("smtp");
                transport.connect("eventskytracker", "EVTEventSkyTracker31");
                transport.sendMessage(message, new Address[]{new InternetAddress(email),});
            } catch (MessagingException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (transport != null) {
                        transport.close();
                    }
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
