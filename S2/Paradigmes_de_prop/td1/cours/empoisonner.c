#include <stdio.h>
#include <stdlib.h>

int empoisonner(int* point_de_vie, int* poison);
   
int main(int argc, char* argv[]) {
    int point_de_vie = 100;
    int poison = 10;

    empoisonner(&point_de_vie, &poison);
    printf("point_de_vie = %d, poison = %d\n", point_de_vie, poison);

    return 0;
}

int empoisonner(int* point_de_vie, int* poison ) {
    *point_de_vie = *point_de_vie - *poison;
    *poison = *poison - 1;

    if (*poison <= 0) {
        *poison = (rand() % 20) + 1;
        
    }
   
}