
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main() {
    int input;
    srand(time(0)); // Seed the random number generator

    while (1) {
        printf("0");

        if (scanf("%d", &input) == 1) {
            int randomCount = rand() % (input + 1);

            for (int i = 0; i < randomCount; i++) {
                printf("%c", input);
            }
        }
    }

    return 0;
}
/*
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#ifdef _WIN32
#include <conio.h>
#else
#include <unistd.h>
#include <termios.h>

char getch() {
    char buf = 0;
    struct termios old = {0};
    fflush(stdout);
    if(tcgetattr(0, &old) < 0)
        perror("tcsetattr()");
    old.c_lflag &= ~ICANON;
    old.c_lflag &= ~ECHO;
    old.c_cc[VMIN] = 1;
    old.c_cc[VTIME] = 0;
    if(tcsetattr(0, TCSANOW, &old) < 0)
        perror("tcsetattr ICANON");
    if(read(0, &buf, 1) < 0)
        perror("read()");
    old.c_lflag |= ICANON;
    old.c_lflag |= ECHO;
    if(tcsetattr(0, TCSADRAIN, &old) < 0)
        perror("tcsetattr ~ICANON");
    return buf;
 }

int kbhit(void)
{
    struct termios oldt, newt;
    int ch;
    int oldf;

    tcgetattr(STDIN_FILENO, &oldt);
    newt = oldt;
    newt.c_lflag &= ~(ICANON | ECHO);
    tcsetattr(STDIN_FILENO, TCSANOW, &newt);
    oldf = fcntl(STDIN_FILENO, F_GETFL, 0);
    fcntl(STDIN_FILENO, F_SETFL, oldf | O_NONBLOCK);

    ch = getchar();

    tcsetattr(STDIN_FILENO, TCSANOW, &oldt);
    fcntl(STDIN_FILENO, F_SETFL, oldf);

    if(ch != EOF)
    {
        ungetc(ch, stdin);
        return 1;
    }

    return 0;
}
#endif

int main() {
    srand(time(0)); // Seed the random number generator

    while (1) {
        printf("0");

        if (kbhit()) {
            int input = getch();
            int randomCount = rand() % (input + 1);

            for (int i = 0; i < randomCount; i++) {
                printf("%c", input);
            }
        }
    }

    return 0;
}
*/
