#include <stdio.h>
#include <stdlib.h>


/**
 * La fonction de chiffrement prend un mot et une clé en entrée et décale chaque lettre du mot du
 * montant de la clé pour le chiffrer.
 * 
 * @param word Pointeur vers un tableau de caractères représentant le mot à chiffrer.
 * @param key Le paramètre clé est un entier qui représente le degré de décalage à appliquer à chaque
 * caractère du mot.
 */
/*
void encrypt(char *word, int key) {
    int i = 0;
    while (word[i] != '\0') {
        if (word[i] >= 'a' && word[i] <= 'z') {
            word[i] = (word[i] - 'a' + key) % 26 + 'a';
        } else if (word[i] >= 'A' && word[i] <= 'Z') {
            word[i] = (word[i] - 'A' + key) % 26 + 'A';
        }
        i++;
    }
}*/

/**
 * La fonction « decrypt » prend une chaîne et une clé en entrée et déchiffre la chaîne à l'aide d'un
 * algorithme de chiffrement César.
 * 
 * @param word Le paramètre « mot » est un pointeur vers un tableau de caractères, qui représente le
 * mot à déchiffrer.
 * @param key La clé est une valeur entière qui détermine le nombre de déplacements à effectuer pendant
 * le processus de décryptage.
 */

/*
void decrypt(char *word, int key) {
    int i = 0;
    while (word[i] != '\0') {
        if (word[i] >= 'a' && word[i] <= 'z') {
            word[i] = (word[i] - 'a' - key + 26) % 26 + 'a';
        } else if (word[i] >= 'A' && word[i] <= 'Z') {
            word[i] = (word[i] - 'A' - key + 26) % 26 + 'A';
        }
        i++;
    }
}

int main() {
    char word[100];
    int key;

    printf("Enter a word: ");
    scanf("%s", word);

    printf("Enter a key: ");
    scanf("%d", &key);

    encrypt(word, key);
    printf("Encrypted word: %s\n", word);

    decrypt(word, key);
    printf("Decrypted word: %s\n", word);

    return 0;
}
*/

//#include <curses.h>

void encrypt(char *word, int key) {
    int i = 0;
    while (word[i] != '\0') {
        if (word[i] >= 'a' && word[i] <= 'z') {
            word[i] = (word[i] - 'a' + key) % 26 + 'a';
        } else if (word[i] >= 'A' && word[i] <= 'Z') {
            word[i] = (word[i] - 'A' + key) % 26 + 'A';
        }
        i++;
    }
}

int main() {
    char word[100];
    int key;
    int ch;

    initscr(); // start curses mode
    cbreak(); // Line buffering disabled, Pass on everything to me
    //keypad(stdscr, TRUE); // I need that nifty F1
    noecho(); // Don't echo() while we do getch

    printw("Enter a key: ");
    scanw("%d", &key);

    printw("Enter a word: ");
    refresh();

    int i = 0;
    while ((ch = getch()) != '\n') {
        word[i] = ch;
        word[i+1] = '\0';
        encrypt(word, key);
        move(0, 0);
        printw("Encrypted word: %s", word);
        move(1, 12+i);
        i++;
    }

    endwin(); // End curses mode

    return 0;
}