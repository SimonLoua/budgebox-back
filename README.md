# budgebox-back
Java Jdk 1.8

MySQL 5.7.28

Maven pour les dépendences.

Pour reprendre les données en BDD deux solutions : 
   1) Utiliser le fichier d'export sql  situé dans 'src/main/resources' 
		puis créer un utilisateur ayant les droits sur le schéma "CREATE USER 'budgetbox_user'@'localhost' IDENTIFIED BY 'budgetbox_password';"
	
   2) Ou refaire l'import complet à la main : récupérer les fichiers database-init.sql et generic-food.csv situé dans 'src/main/resources'.
	Déposer le fichier generic-food.csv dans le repertoire de partage MySQL (sous windows localisé dans 'C:/ProgramDate/MySQL/MySQL Server x.y/Uploads')		 	 Exécuter les commandes SQL du fichier database-init.sql.
												
Si vous ne souhaitez pas créer l'utilisateur "budgetbox_user" vous pouvez modifier les infos de connexions à la BDD dans le fichier "resources/application.properties"
