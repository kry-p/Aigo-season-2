#include <iostream>
#include <algorithm>

using namespace std;

int s[504][504] = { 0 };
int dp[504][504] = { 0 };
int result = -1;

int main() {
    int n;
    cin >> n;
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= i; j++) {
            cin >> s[i][j];
        }
    } //입력

    dp[1][1] = s[1][1]; // 첫번째 같음
    for (int i = 2; i <= n; i++) {
        for (int j = 1; j <= i; j++) {
            dp[i][j] = max(dp[i - 1][j - 1], dp[i - 1][j]) + s[i][j];
        }
    } // 최종층 = 그 전 층수까지의 경로의 최댓값 + 자신의(원소값) = 그 층(최종층) 경로 총합
    for (int i = 1; i <= n; i++) {
        if (result < dp[n][i])
            result = dp[n][i];
    } // 
    cout << result;
    return 0;
}
