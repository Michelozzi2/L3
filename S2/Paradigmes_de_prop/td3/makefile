hashtable.o: hashtable.c hashtable.h
	gcc -c hashtable.c -o hashtable.o

hsht_main.o: hsht_main.c hashtable.h
	gcc -c hsht_main.c -o hsht_main.o

hsht_main: hashtable.o hsht_main.o
	gcc hashtable.o hsht_main.o -o hsht_main

clean:
	rm -f hashtable.o hsht_main.o hsht_main