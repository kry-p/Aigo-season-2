#include <iostream>
#include <algorithm>

using namespace std;
int fee[10001] = { 0 };
int dp[1001] = { 0 };

int main() {
	ios::sync_with_stdio(NULL);
	cin.tie(0);
	cout.tie(0);

	int n, p;
	cin >> n;
	for (int i = 1; i <= n; i++) {
		cin >> fee[i];
	}

	dp[0] = 0;

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= i; j++) {
			int temp = fee[j] + dp[i - j]; // 카드 금액 + 나머지 금액으로 살 수 있는 카드 의 최대 금액
			if (temp > dp[i]) {
				dp[i] = temp;
			}
		}
	}

	cout << dp[n];

	/*for (int i = 1; i <= n; i++) {
		cout << dp[i] <<" ";
	}*/
	return 0;
}