# -----------------------------------------------------------------------
#    crée les autorisation du user local pour l'accés du serveur à la BD
#    création du 16 Mars 2017
# -----------------------------------------------------------------------

use skytracker;

# drop user skytracker@localhost;
create user skytracker@localhost identified by 'skytrackerNovae31';

# pour l'instant on ne modifie pas ces 3 tables
grant  select on skytracker.evenement to skytracker@localhost identified by 'skytrackerNovae31';
grant  select on skytracker.candidate to skytracker@localhost identified by 'skytrackerNovae31';
grant  select on skytracker.image to skytracker@localhost identified by 'skytrackerNovae31';

grant  select,insert,update,delete on skytracker.actu to skytracker@localhost identified by 'skytrackerNovae31';
grant  select,insert,update,delete on skytracker.user to skytracker@localhost identified by 'skytrackerNovae31';
grant  select,insert,update,delete on skytracker.qualification to skytracker@localhost identified by 'skytrackerNovae31';
