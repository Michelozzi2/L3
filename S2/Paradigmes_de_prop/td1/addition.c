#include <stdio.h>

void add(int a, int b, int* c) {
    *c = a + b;
}

int main() {
    int a = 5;
    int b = 3;
    int result;

    add(a, b, &result);

    printf("La somme entre %d et %d est %d\n", a, b, result);

    return 0;
}
