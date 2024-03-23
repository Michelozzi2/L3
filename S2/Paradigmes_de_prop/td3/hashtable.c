#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "hashtable.h"


/**
 * Crée une nouvelle paire clé-valeur pour la table de hachage.
 *
 * @param key La clé à stocker dans la paire. La fonction crée une copie de cette chaîne.
 * @param value La valeur à stocker dans la paire. La fonction crée une copie de cette chaîne.
 * @return Un pointeur vers la nouvelle paire clé-valeur. La mémoire pour la paire et pour les chaînes est allouée dynamiquement, donc elle doit être libérée lorsque vous avez fini de l'utiliser.
 */
hsht_key_value_pair* hsht_new_key_value_pair(const char* key, const char* value) {
    hsht_key_value_pair* pair = malloc(sizeof(hsht_key_value_pair));
    pair->key = strdup(key);
    pair->value = strdup(value);

    return pair;

}



/**
 * Supprime une paire clé-valeur et libère toute la mémoire associée.
 *
 * @param kv La paire clé-valeur à supprimer. Cette fonction libère la mémoire pour la clé, la valeur, et la structure de la paire clé-valeur elle-même.
 */
void hsht_del_key_value_pair(hsht_key_value_pair* kv) {
    free(kv->key);
    free(kv->value);
    free(kv);

}


ht_hash_table* hsht_new(const int size) {
    ht_hash_table* ht = malloc(sizeof(ht_hash_table));
    if (ht == NULL) {
        return NULL;  // malloc a échoué
    }

    if(size == 0) {
        ht->size = 53;
    } else {
        ht->size = size;
    }
    ht->kv_items = calloc(ht->size, sizeof(hsht_key_value_pair*));
    if (ht->kv_items == NULL) {
        free(ht);  // calloc a échoué, libérez la mémoire allouée par malloc
        return NULL;
    }


    return ht;

}

/**
 * Supprime une table de hachage et libère toute la mémoire associée.
 *
 * @param ht La table de hachage à supprimer. Cette fonction libère la mémoire pour chaque item dans la table, le tableau d'items lui-même, 
 * et la structure de la table de hachage.
 */
void hsht_del(ht_hash_table* ht){
    for(int i = 0; i < ht->size; i++) {
        if(ht-> kv_items[i] != NULL) {
            printf("Deleting key: %s\n", ht->kv_items[i]->key);
            hsht_del_key_value_pair(ht->kv_items[i]);
        }
    }
    printf("Deleting kv_items\n");
    free(ht->kv_items);
    printf("Deleting ht\n");
    free(ht);

}

