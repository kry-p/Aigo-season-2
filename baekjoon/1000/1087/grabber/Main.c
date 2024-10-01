#include <stdio.h>
 
int factory(int n) {
    if (n > 1)
        return n * factory(n - 1);
    else return 1;
}
 
int main() {
    int N;
    scanf("%d", &N);
    printf("%d\n", factory(N));
    return 0;
}