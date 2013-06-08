/**
 * From http://programmers.stackexchange.com/questions/131232/do-coding-puzzles-make-good-interview-questions
 * 
 * What is the output of the program?
 * What is the output of the program if the break is removed?
 */

#include <stdio.h>

int main() {
    int i = 0;
    for (i = 1; i < 10; i++) {
        if (i % 3 == 0) i++; break;
        if (i % 2 == 0) i++;
    }
    printf("%d\n", i);
    return 0;
}

