# Compiler les fichiers source en fichiers objet
michelozziListeInt.o: michelozziListeInt.c
	gcc -c michelozziListeInt.c -o michelozziListeInt.o

michelozziExo1.o: michelozziExo1.c
	gcc -c michelozziExo1.c -o michelozziExo1.o

# Lier les fichiers objet pour créer l'exécutable
michelozziExo1: michelozziListeInt.o michelozziExo1.o
	gcc michelozziListeInt.o michelozziExo1.o -o michelozziExo1

# Nettoyer le répertoire
clean:
	rm -f michelozziListeInt.o michelozziExo1.o michelozziExo1 savelist.bin