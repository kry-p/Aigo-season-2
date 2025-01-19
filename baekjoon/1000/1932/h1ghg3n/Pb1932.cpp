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
    } //�Է�

    dp[1][1] = s[1][1]; // ù��° ����
    for (int i = 2; i <= n; i++) {
        for (int j = 1; j <= i; j++) {
            dp[i][j] = max(dp[i - 1][j - 1], dp[i - 1][j]) + s[i][j];
        }
    } // ������ = �� �� ���������� ����� �ִ� + �ڽ���(���Ұ�) = �� ��(������) ��� ����
    for (int i = 1; i <= n; i++) {
        if (result < dp[n][i])
            result = dp[n][i];
    } // 
    cout << result;
    return 0;
}
