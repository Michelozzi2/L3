#include <stdio.h>

void recursiveFunction() {
    recursiveFunction(); 
}

int main() {
    recursiveFunction(); 
    return 0;
}
