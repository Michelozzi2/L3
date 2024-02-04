#include <stdio.h>
#include <stdlib.h>
#include <string.h>


/*
int main() {
    int *pt_int;
    int un_int = 5;
    printf("un_int = %d\n", un_int);
    pt_int = NULL;
    printf("pt_int = %p\n", pt_int);
    pt_int = &un_int;
    printf("Verification du fait que la val de pt_int %p et l'adresse de un_int %p sont les mêmes\n", pt_int, &un_int);
    printf("Verification du fait que la val un_int %i et la valeur de l'objet pointé par pt_int %i sont les mêmes\n", un_int, *pt_int);
    *pt_int = 2;
    printf("Verification du fait que la val de un_int %i et donc de l'objet pointé par pt_int %i ont bien été modifiés\n", un_int, *pt_int);
    
}
*/

/*
int main() {
    int i=3;
    int* pi;
    pi = &i;
    printf("i = %d\n", i);
    printf("&i = %p\n", &i);
    printf("pi = %p\n", pi);
    printf("&pi = %p\n", &pi);
    
}
*/

int main(int argc, char *argv[]) {
    int *pt_int = NULL;
    pt_int = (int *)malloc(sizeof(int));
    *pt_int = 10;
    printf("pt_int = %p\n", pt_int);
    printf("*pt_int = %d\n", *pt_int);
    free(pt_int);
    return 0;
}

