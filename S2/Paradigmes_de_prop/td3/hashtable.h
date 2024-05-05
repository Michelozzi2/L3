#ifndef HASHTABLE_H
#define HASHTABLE_H

typedef struct hsht_key_value_pair
{
    char * key;
    char * value;

} hsht_key_value_pair;

typedef struct ht_hash_table
{
    int size;
    int amount;
    hsht_key_value_pair ** kv_items;

}ht_hash_table;

/* initialisation d’un couple clé, valeur */
hsht_key_value_pair * hsht_new_key_value_pair(const char * key, const char * value);

/* suppression d’un item */
void hsht_del_key_value_pair(hsht_key_value_pair * element);

/* initialisation d’une nouvelle table */
ht_hash_table * hsht_new(const int size);

/* suppression d'une table */
void hsht_del(ht_hash_table * tab);

double hsht_hash(const char * value, double nbr_premier, int taille_tab);

int hsht_give_hash(const char* S, const int M, const int attempt, 
                       const int alpha_1, const int alpha_2);

void hsht_insert(ht_hash_table * tab, char * key, char* value);

char* hsht_search(ht_hash_table* tab, char* key);

void hsht_delete(ht_hash_table *tab, char *key);

#endif