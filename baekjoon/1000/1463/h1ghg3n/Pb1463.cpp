#include<stdio.h>

int main() {
    int a, b, result;
    scanf("%d", &a);
    getchar();
    for (int i = 0; i < a; i++) {
        scanf("%1d", &b);
        result += b;
    }
    printf("%d", result);
    return 0;
}