
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <math.h>
#include "hashtable.h"

hsht_key_value_pair deleted_pair = {NULL, NULL};
hsht_key_value_pair *HSHT_DELETED_PAIR = &deleted_pair;

hsht_key_value_pair *hsht_new_key_value_pair(const char *key, const char *value)
{

    hsht_key_value_pair *element_paire = (hsht_key_value_pair *)malloc(sizeof(hsht_key_value_pair));
    element_paire->key = strdup(key);
    element_paire->value = strdup(value);

    return element_paire;
}

ht_hash_table *hsht_new(const int size)
{

    ht_hash_table *new_table = (ht_hash_table *)malloc(sizeof(ht_hash_table));
    if (size == 0)
    {
        new_table->size = 53;
    }
    else
    {
        new_table->size = size;
    }

    new_table->kv_items = (hsht_key_value_pair **)calloc(new_table->size, sizeof(hsht_key_value_pair *));
    new_table->amount = 0;

    return new_table;
}

void hsht_del_key_value_pair(hsht_key_value_pair *element)
{
    free(element->key);
    free(element->value);
    free(element);
}

void hsht_del(ht_hash_table *tab)
{
    for (int i = 0; i < tab->size; i++)
    {
        if (tab->kv_items[i] != NULL)
        {
            printf("Suppression de l'élément avec la clé : %s\n", tab->kv_items[i]->key);
            hsht_del_key_value_pair(tab->kv_items[i]);
        }
    }
    printf("\nSuppression de la table de hachage\n");
    free(tab->kv_items);
    free(tab);
}

double hsht_hash(const char *value, double nbr_premier, int taille_tab)
{
    int ascii = 0;
    double equ = 0;
    int taille_value = strlen(value);
    for (int i = 0; i < taille_value; i++)
    {
        ascii = value[i];
        equ = equ + pow(nbr_premier, i) * ascii;
    }
    equ = fmod(equ, taille_tab);
    return equ;
}

int hsht_give_hash(const char *S, const int M, const int attempt,
                   const int alpha_1, const int alpha_2)
{

    const int hash_a = hsht_hash(S, alpha_1, M);
    const int hash_b = hsht_hash(S, alpha_2, M);

    return (hash_a + (attempt * (hash_b + 1))) % M;
}

void hsht_insert(ht_hash_table *tab, char *key, char *value)
{
    int position = hsht_give_hash(key, tab->size, 0, 397, 40);
    printf("%d\n", position);
    hsht_key_value_pair *kv_pairs = hsht_new_key_value_pair(key, value);
    tab->kv_items[position] = kv_pairs;
}

char *hsht_search(ht_hash_table *tab, char *key)
{
    int position = hsht_give_hash(key, tab->size, 0, 397, 40);
    hsht_key_value_pair *kv_pairs = tab->kv_items[position];

    if (kv_pairs != NULL)
    {
        return kv_pairs->value;
    }
    else
    {
        return NULL;
    }
}

void hsht_delete(ht_hash_table *tab, char *key)
{
    char *value = hsht_search(tab, key);
    int position = hsht_give_hash(key, tab->size, 0, 397, 40);
    if (value != NULL)
    {
        tab->kv_items[position] = HSHT_DELETED_PAIR;
    }
}
