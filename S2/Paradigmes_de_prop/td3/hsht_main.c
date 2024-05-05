#include <stdio.h>
#include "hashtable.h"

int main()
{
    // Création d'une nouvelle table de hachage
    ht_hash_table *tab = hsht_new(10);

    // Insertion de quelques paires clé-valeur
    hsht_insert(tab, "clé1", "valeur1");
    hsht_insert(tab, "clé2", "valeur2");
    hsht_insert(tab, "clé3", "valeur3");

    for (int i = 0; i < tab->size; i++)
    {
        hsht_key_value_pair *item = tab->kv_items[i];
        if (item != NULL)
        {
            printf("Clé : %s, Valeur : %s\n", item->key, item->value);
        }
    }
    printf("\nLa valeur rechercher est :%s\n", hsht_search(tab, "clé1"));
    hsht_delete(tab, "clé1");

    for (int i = 0; i < tab->size; i++)
    {
        hsht_key_value_pair *item = tab->kv_items[i];
        if (item != NULL)
        {
            printf("Clé : %s, Valeur : %s\n", item->key, item->value);
        }
    }

    // Suppression de la table de hachage
    hsht_del(tab);

    return 0;
}