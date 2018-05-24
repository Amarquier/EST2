# ---------------------------------------------------------------------
#    crée le user local pour l'accés du serveur à la BD
#    modification du 8 Mars 2018 (v3.0
# ---------------------------------------------------------------------

use skytracker2;

drop user skytracker2@localhost;
create user skytracker2@localhost identified by 'skytrackerNovae31';
grant  select,insert,update,delete on skytracker2.actu to skytracker2@localhost identified by 'skytrackerNovae31';
grant  select,insert,update,delete on skytracker2.galaxie to skytracker2@localhost identified by 'skytrackerNovae31';
grant  select,insert,update,delete on skytracker2.imageSN to skytracker2@localhost identified by 'skytrackerNovae31';
grant  select,insert,update,delete on skytracker2.skyobjects to skytracker2@localhost identified by 'skytrackerNovae31';  # inutilisée
grant  select,insert,update,delete on skytracker2.evenement to skytracker2@localhost identified by 'skytrackerNovae31';
grant  select,insert,update,delete on skytracker2.candidateEST to skytracker2@localhost identified by 'skytrackerNovae31';
grant  select,insert,update,delete on skytracker2.imageEST to skytracker2@localhost identified by 'skytrackerNovae31';
grant  select,insert,update,delete on skytracker2.user to skytracker2@localhost identified by 'skytrackerNovae31';
grant  select,insert,update,delete on skytracker2.candidateSN to skytracker2@localhost identified by 'skytrackerNovae31';
grant  select,insert,update,delete on skytracker2.decouverte to skytracker2@localhost identified by 'skytrackerNovae31';
grant  select,insert,update,delete on skytracker2.canreference to skytracker2@localhost identified by 'skytrackerNovae31';
grant  select,insert,update,delete on skytracker2.qualification to skytracker2@localhost identified by 'skytrackerNovae31';