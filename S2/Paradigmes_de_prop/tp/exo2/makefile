# Compiler les fichiers source en fichiers objet
pile.o: pile.c pile.h
	gcc -c pile.c -o pile.o

mainPile.o: mainPile.c pile.h
	gcc -c mainPile.c -o mainPile.o

# Lier les fichiers objet pour créer l'exécutable
mainPile: pile.o mainPile.o
	gcc pile.o mainPile.o -o mainPile

# Nettoyer le répertoire
clean:
	rm -f pile.o mainPile.o mainPile