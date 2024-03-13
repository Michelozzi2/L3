#include "util_rand.h"
#include <time.h>

// Initialize the random number generator
void init_rand() {
    srand(time(NULL));
}

// Generate a random integer up to RAND_MAX
int random_max() {
    return rand();
}

// Generate a random integer between 0 and high
int random_up_to(int high) {
    return rand() % (high + 1);
}

// Generate a random integer between low and high
int random_between(int low, int high) {
    return low + rand() % (high - low + 1);
}

// Generate a random double between 0 and 1
double random_double() {
    return (double)rand() / (double)RAND_MAX;
}

// Generate a random double between low and high with two decimal places
double random_double_between(double low, double high) {
    double scale = rand() / (double) RAND_MAX; /* [0, 1.0] */
    double range = high - low;
    double scaled = scale * range;
    double shifted = scaled + low;
    return shifted;
}