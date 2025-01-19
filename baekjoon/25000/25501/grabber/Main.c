#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>

// baek-joon 25501 재귀의 귀재
// 팰린드롬 : 팰린드롬이란, 앞에서부터 읽었을 때와 뒤에서부터 읽었을때가 같은 문자열을 말한다.
// ABBA, ABABA, ACACA ...
int cnt = 0;

int recursion(const char *s, int l, int r)
{
    cnt++;
    if(l>=r) return 1;
    else if (s[l] != s[r]) return 0;
    else return recursion(s,l+1,r-1);
}

// 함수를 이용하여 어떤 문자열이 팰린드롬인지 여부 판단
int isPalindrome(const char *s){
    cnt = 0;
    return recursion(s, 0, strlen(s)-1);
}

int main()
{  
    int iWord, pal, i;
    scanf("%d", &iWord);
    char S[1001];

    for (i = 0; i < iWord; i++) 
    {
        cnt = 0;
        scanf("%s", S);
        pal = isPalindrome(S);
        printf("%d %d\n", pal, cnt);
    }

    return 0;
}
