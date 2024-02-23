CC = gcc
CFLAGS = -Wall -pedantic -g
all: exo5
%.o: %.c %.h
	$(CC) $(CFLAGS) -c -o $@ $^
exo5: exo5.o
	$(CC) $(CFLAGS) -o $@ $^
clean:
	rm -f *.o exo5