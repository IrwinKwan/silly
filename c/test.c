/**
 * Working with arrays in C
 */

#include <stdio.h>
#include <string.h>
#include "test.h"

void print_array(char* name, int* array, size_t n) {
    int i = 0;

    printf("%s: ", name); 
    for (i = 0; i < n; i++) {
        printf("%d ", array[i]);
    }
    printf("\n");
}

int main(int argc, char** argv) {
    char a[A_SIZE];

    strncat(a, HELLO, A_SIZE);
    printf("%s\n", a);

    int integer_array[10] = {1, 2, 3, 4, 6, 7, 8, 9};

    print_array("integer array", integer_array, sizeof(integer_array)/sizeof(integer_array[0]));

    return 1;
}
