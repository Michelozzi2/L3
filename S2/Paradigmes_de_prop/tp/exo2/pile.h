#ifndef PILE_H
#define PILE_H


typedef struct Node {
    int value;
    struct Node* next;
} Node;

typedef struct Stack {
    Node* top;
} Stack;

int is_empty(Stack* stack);
void push(Stack* stack, int value);
int peek(Stack* stack);
int pop(Stack* stack);
Stack* init_stack();
void free_stack(Stack* stack);

#endif
