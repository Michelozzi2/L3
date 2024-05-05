CC=gcc

all: main_train

train.o: train.c train.h
	$(CC) -c train.c -o train.o

main_train.o: main_train.c train.h
	$(CC) -c main_train.c -o main_train.o

main_train: train.o main_train.o
	$(CC) train.o main_train.o -o main_train

clean:
	rm -f train.o main_train.o main_train