# -----------------------------------------------------------------------------
# -----------------------------------------------------------------------------
#             init des tables
# -----------------------------------------------------------------------------
# Mots de passe cryptés des users :
#   24C9E15E52AFC47C225B757E7BEE1F9D  pwd : user1
#   7E58D63B60197CEB55A1C487989A3720  pwd : user2
#   92877AF7A45FD6A2ED7FE81E1236B78   pwd : user3
#
# Mots de passe des mails des users prédéfinis :
#       mail : user1ESTracker@gmail.com pwd : user1snDisco31, 
#       mail : user2ESTracker@gmail.com pwd : user2snDisco31
#       mail : user3ESTracker@gmail.com pwd : user3snDisco31
# -----------------------------------------------------------------------------

use skytracker;

insert into `user` 
(pseudo, username, email, password, mailconfirme, lastCan, grade, blocked, registerDate, lastVisitDate, nbQualifications, nbConnexions) 
values 
('admin','evtdadmin','adminESTracker@gmail.com','79EBE7D403E9F1AB9EB1E7629AA7DE','ok',1,5,false,'2017/03/01 16:30:00','2017/03/01 16:31:00',0,1),
('user1','user1','user1ESTracker@iris.com','24C9E15E52AFC47C225B757E7BEE1F9D','ok',1,5,false,'2017/03/01 16:32:00','2017/03/01 16:33:00',0,1),
('user2','user2','user2ESTracker@iris.com','7E58D63B60197CEB55A1C487989A3720','ok',1,1,false,'2017/03/01 16:34:00','2017/03/01 16:35:00',0,1),
('user3','user3','user3ESTracker@iris.com','92877AF7A45FD6A2ED7FE81E1236B78','ok',1,3,true,'2017/03/01 16:36:00','2017/03/01 16:37:00',0,1);
