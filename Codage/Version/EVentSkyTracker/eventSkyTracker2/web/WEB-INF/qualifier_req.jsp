
<%-- 
    Document   : qualifier_req
    Description : Enjoie ajax qui renvoie les chemins des images et les délais
    Created on : 18 avr. 2017, 09:52:52
    Author     : Sanson
--%>


<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.Random"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.persistence.*"%>
<%@page import="com.metier.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../includes/session.jspf" %>

<%   
    /*Liste des images , évènement et candidate*/
    
    ArrayList<ImageEST> listImg = null;
    ArrayList<String> cheminImages = new ArrayList<String>();
    ArrayList<String> NomImage = new ArrayList<String>();
    ArrayList<Integer> listDelai = new ArrayList<Integer>();
    ArrayList<Evenement> tabEvent = null;
    ArrayList<CandidateEST> tabCand = null;
    String img = "";
    String trame = "--";
    /*Heure, minute,seconde de l'évènement*/
    double HEvent;
    double MEvent;
    double SEvent;
    /*Heure, minute,seconde de l'image*/
    double HImg;
    double MImg;
    double SImg;
    /*Heure de l'évènement et de l'image en minute*/
    double heureEvent;
    double heureImg;
    /*Heure cumuler*/
    int heureC = 0;
    /*Mois et année de décalage*/
    int decalage = 0;
    /*Heure J cumuler*/
    int heureJ = 0;
    /*Nom de l'évènement*/
    String NomEvent;
    int annee;
    int jour = 0;
    int moisun;
    int nbjourmois = 0;
    int jourEvt;
    /*Récupération numéro candidate et évènement*/
    int cand = Integer.parseInt(request.getParameter("candidate"));
    int evenement = Integer.parseInt(request.getParameter("event"));
    /*Liste des évènement*/
    tabEvent = Evenement.liste(con);
    /*Récupération uniquement des evènement qui contienne des candidates*/
    
    for (int i = tabEvent.size() ; i >= 1; i--) {
        /*Récupération des candidates selon si l'utilisateur est connecté ou non*/
        if (user != null) {
            tabCand = CandidateEST.getByEvenementAndUser(con, tabEvent.get(evenement).getId(), user.getPseudo());
        }
        else {
            /*Récupération des candidates de l'évènement choisi*/
            tabCand = CandidateEST.getByEvenement(con, tabEvent.get(evenement).getId());
            if(tabCand.size() <= 0)
                evenement++;
            else
                break;
        }
    }
    /*Si la variable evenement est inférieur au nombre d'évènement dans le tableau*/    
    if (evenement < tabEvent.size()) {
        /*Récupération des images de la candidate choisis*/
        listImg = ImageEST.getByCandidate(con, tabCand.get(cand).getId());
        /*Récupération du chemin de l'évènement*/
        String debutEvent = tabEvent.get(evenement).getChemin();
        /*Récupération des chemins d'images pour le slide*/
        for (int i = 0; i < listImg.size(); i++) {
            cheminImages.add(i, listImg.get(i).getChemin());
        }
        /*Récupération des chemins d'images pour le calculs des délais*/
        for (int i = 0; i < listImg.size(); i++) {
            if (i == 0) 
                img = (String) listImg.get(i).getChemin() + "|";
             else 
                img += (String) listImg.get(i).getChemin() + "|";
        }
        /*Séparation des différents caractères*/
        String[] parts = img.split("\\|");
        /*Récupération de l'heure,minute,seconde de l'évènement*/
        NomEvent = debutEvent.substring(debutEvent.length() - 6, debutEvent.length());
        /*Récupération de l'heure,minute,seconde de chaque images*/
        for (int i = 0; i < parts.length; i++) {
            NomImage.add(i, parts[i].substring(parts[i].length() - 6, parts[i].length()));
        }
        /*Calcul des delais*/
        for (int i = 0; i <= (NomImage.size() - 1); i++) {
            int mois;
            /*Vérification du dhangement de mois*/
            moisun = Integer.parseInt(debutEvent.substring(debutEvent.length() - 11, debutEvent.length() - 9));
            jourEvt = Integer.parseInt(debutEvent.substring(debutEvent.length() - 9, debutEvent.length() - 7));
            mois =  (Integer.parseInt(cheminImages.get(i).substring(cheminImages.get(i).length() - 11, cheminImages.get(i).length() - 9)) -
                    Integer.parseInt(debutEvent.substring(debutEvent.length() - 11, debutEvent.length() - 9)));
            /*Si il y a changement d'année (12-1)*/
            if(mois<0)
                mois += 12;
            /*Si il y a un changement de mois alors */
            if (mois >= 1) {
                decalage = 0;
                for(int j = 0 ; j < mois; j++){
                    /*calcule du mois*/
                    int moisdecalage = moisun + j; 
                if ((moisdecalage == 1) ||(moisdecalage== 3) || (moisdecalage== 5) || (moisdecalage == 7) || (moisdecalage == 8) || (moisdecalage == 10) || (moisdecalage == 12))
                    nbjourmois = 31;
                if ((moisdecalage == 4) ||(moisdecalage== 6) || (moisdecalage == 9) || (moisdecalage == 11))
                    nbjourmois = 30;
                if ((moisdecalage == 2))
                    nbjourmois = 28;          
                /*si il y a plus de 1 mois d'écart on ajoute les nombres de jour dans le mois*/
                if (j != 0)
                    decalage +=nbjourmois;
                /*sinon si on est le premier mois on fait la différence entre le jour actuel et le nombre de jour dans le mois*/
                else
                    decalage += nbjourmois - jourEvt;
                /*on compte le nombre de jour*/
                jour =  Integer.parseInt(cheminImages.get(i).substring(cheminImages.get(i).length() - 9, cheminImages.get(i).length() - 7));
                /*Calcul du décalage entre jour et mois*/
                //jour += decalage;

                }
                /*on ajoute le jour actuel au décalage total des jours*/
                jour = jour + decalage;
            }
            else
                /*Sinon on compte le nombre de jour entre l'image actuel et le debut de l'évènement*/
                jour =  (Integer.parseInt(cheminImages.get(i).substring(cheminImages.get(i).length() - 9, cheminImages.get(i).length() - 7)) - 
                         Integer.parseInt(debutEvent.substring(debutEvent.length() - 9, debutEvent.length() - 7)));
            /*Séparation heure,minute,seconde de l'évènement*/
            HEvent = Double.parseDouble(NomEvent.substring(0, 2)) * 60;
            MEvent = Double.parseDouble(NomEvent.substring(2, 4));
            SEvent = Double.parseDouble(NomEvent.substring(4, 6)) / 60;
            /*Addition de l'heure en minute*/
            heureEvent = HEvent + MEvent + SEvent;
            /*Si il y a un décalage d'un jour ou +. Calcul à partir de l'heure de l'évènement jusqu'a 0h00*/
            if (jour >= 1) {
                /*24 heure * 60 pour avoir 24h en minute(peut etre remplacer par 1440)*/
                heureC = 24*60;
                /*différence entre l'heure de l'évènement et minuit de la meme journée */
                heureJ = (int)Math.round((heureC - heureEvent));
                /*on met l'heure de l'évènement à 0h*/
                heureEvent = 0;
                /*on ajoute 1440 par jour en + si le décalage est supérieur à 1 jour*/
                heureJ = heureJ + ((24*60)*(jour-1));
            }
            /*Séparation heure,minute,seconde de l'image*/
            HImg = (Double.parseDouble(NomImage.get(i).substring(0, 2))) * 60;
            MImg = Double.parseDouble(NomImage.get(i).substring(2, 4));
            SImg = Double.parseDouble(NomImage.get(i).substring(4, 6)) / 60;
             /*Addition de l'heure en minute*/
            heureImg = HImg + MImg + SImg;
            /*Calculs différence d'heure entre l'évènement et heure de l'image*/
            heureC = (int)Math.round((heureImg - heureEvent));
            /*Ajout dans un tableau list delais*/
            listDelai.add(i, (heureC+heureJ));
        }
        /*Création d'une trame qui contient chemin des images , liste des delais , Id de la candidate , et les élèments à ajouter dans la zone de texte*/
        for (int i = 0; i < cheminImages.size(); i++) {
            if (i != cheminImages.size() - 1) {
                trame += cheminImages.get(i) + "|";
            } else {
                trame += cheminImages.get(i);
            }
        }
        trame += "--"; //Séparation des deux éléments
        for (int i = 0; i < listDelai.size(); i++) {
            if (i != listDelai.size() - 1) {
                trame += listDelai.get(i) + "|";
            } else {
                trame += listDelai.get(i);
            }

        }
        trame += "--";
        trame += "-1";//A prévoir l'année prochaine du projet
        trame += "--";
        trame += "-1";//A prévoir l'année prochaine du projet
        trame += "--";
        trame += tabCand.get(cand).getId();
        trame += "--";
        trame += "Id Evènement : " + tabEvent.get(evenement).getId() + "  id Officiel : " + tabEvent.get(evenement).getIdOfficiel() + "  date et heure du commencement :" + tabEvent.get(evenement).getDate()
                + "  Numéro candidate : " + tabCand.get(cand).getId() + "  Id Evènement de la candidate : " + tabCand.get(cand).getEventId() + "  Nom des images : " + NomImage;
        trame += "--" + tabCand.size();
        out.print(trame);
    }
    else{
         out.print("aucunEvent");
    }
%>