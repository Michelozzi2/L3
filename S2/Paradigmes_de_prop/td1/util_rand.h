#ifndef UTIL_RAND_H
#define UTIL_RAND_H

#include <stdlib.h>

int random_max();
int random_up_to(int high);
int random_between(int low, int high);
double random_double();
double random_double_between(double low, double high);

#endif