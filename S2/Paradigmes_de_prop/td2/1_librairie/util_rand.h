#ifndef RANDLIB_H

#define _DEFAULT_SOURCE

// random number
int randint();

// random number between 0 and max
int randint_max(int max);

// random number between min and max
int randint_range(int min, int max);

// random float between 0 and 1
float randfloat_01();

// random float between min and max
float randfloat_range(float min, float max);

#endif