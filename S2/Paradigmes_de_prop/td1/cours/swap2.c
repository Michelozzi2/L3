#include <stdio.h>
#include <stdlib.h>

int swap(int* a, int* b) {
    int tmp = *a;
    *a = *b;
    *b = tmp;
}

int main(int argc, char* argv[]) {
    int a = 10;
    int b = 20;

    swap(&a, &b);

    printf("a = %d, b = %d\n", a, b);

    return 0;
}