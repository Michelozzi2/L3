#include <stdio.h>
#include <stdlib.h>

#define pscanf(format,message,data) \
    printf(message); \
    scanf(format, data)

int main(int argc, char* argv[]) {
    int age = 0;
    pscanf("%d", "Quel est votre âge ? ", &age);
    printf("Vous avez entré : %d\n", age);
    return 0; 
}