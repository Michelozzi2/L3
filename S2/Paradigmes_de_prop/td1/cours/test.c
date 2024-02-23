#include <stdio.h>
#include <stdlib.h>

int main(int argc, char* argv[]) {
    int a = 10;
    int b = 20;

    void* ptr = NULL;
    void* ptr2 = NULL;
    void* ptr3 = NULL;

    ptr = &a;
    ptr2 = &b;
    ptr3 = (int*) malloc(sizeof(int));

    *(int*)ptr3 = *(int*)ptr;
    *(int*)ptr = *(int*)ptr2;
    *(int*)ptr2 = *(int*)ptr3;

    printf("ptr = %p, ptr2 = %p\n", ptr, ptr2);
    printf("a = %d, b = %d\n", a, b);

    free(ptr3);

    return 0;

}