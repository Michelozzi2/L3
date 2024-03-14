/* Inclusion des librairies ========== */
#include <stdlib.h>

#include "util_rand.h"

/* Fonction secondaires =============== */

int randint()
{
    return rand();
}

int randint_max(int max)
{
    return (rand() / ((double) RAND_MAX + 1)) * max;
}

int randint_range(int min, int max)
{
    return (int) (min + (rand() / ((double) RAND_MAX + 1)) * (max - min));
}

float randfloat_01()
{
    return rand() / ((float) RAND_MAX + 1);
}

float randfloat_range(float min, float max)
{
    return min + (rand() / ((double) RAND_MAX + 1)) * (max - min);
}


