#include <string.h>
#include <stdio.h>


/**
 * A straightforward in-place reverse in C.
 */
int str_reverse(char* input, int len) {
    char tmp;
    char* front = &input[0];
    char* back = &input[len - 1];

    if (len <= 0) {
        return 1;
    }

    while (front < back) {
        tmp = *front;
        *front = *back;
        *back = tmp;
        front++;
        back--;
    }   

    return 0;
}

/** Stack overflow has a nice and nasty XOR swap technique.
 */
void swap(char* p) {
    char *q = p;
    *p = *p ^ *q;
    *q = *p ^ *q;
    *p = *p ^ *q;
}

int main() {
    char original[255] = "This is my original string.";

    char string1[5] = "Boo";

    printf("%s\n", original);
    str_reverse(original, strlen(original));
    printf("%s\n", original);

    printf("%s\n", string1);

    return 0;
}

