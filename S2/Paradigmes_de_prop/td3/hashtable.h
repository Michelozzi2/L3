#ifndef HASHTABLE_H
#define HASHTABLE_H

typedef struct hsht_key_value_pair {
    char* key;
    char* value;
}hsht_key_value_pair;

typedef struct ht_hash_table {
    int size;
    int amount;
    hsht_key_value_pair** kv_items;
}ht_hash_table;

hsht_key_value_pair* hsht_new_key_value_pair(const char* key, const char* value);
void hsht_del_key_value_pair(hsht_key_value_pair* kv);
ht_hash_table* hsht_new(const int size);
void hsht_del(ht_hash_table* ht);



#endif