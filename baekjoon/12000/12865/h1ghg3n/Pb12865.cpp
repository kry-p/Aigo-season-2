// c[k] = max{c[k-n] +b(n)}
#include <iostream>
#include <algorithm>

using namespace std;
int n[101][2] = { 0 };
int dp[102][100002] = {0};


int main() {
	ios::sync_with_stdio(NULL);
	cin.tie(NULL);
	cout.tie(NULL);

	int p, w; // 갯수, 무게
	cin >> p >> w;
	for (int i = 1; i <= p; i++) {
		cin >> n[i][0] >> n[i][1];
	}
	for (int j =1; j <= w; j++) { // dp [w] = dp[w-n] + max(a[n]--> 무게차에 맞는 최대 가치 n = )
		for (int i = 1; i <= p; i++) {
			if (n[i][0] <= j) {
				dp[i][j] = max(dp[i - 1][j], n[i][1] + dp[i - 1][j - n[i][0]]); // i번째 물건을 포함하여 생각했을때 j 무게까지의 최대 가치 = max (i-1번째 j무게까지의 최댓값, i번째 물건의 가치 + j
			}
			else {
				dp[i][j] = dp[i - 1][j];
			}
		}
	}

	for (int i = 0; i <= p; i++) {
		for (int j = 0; j <= w; j++) {
			cout << "dp" << i << "행" << j << "열: " << dp[i][j] << "\n";
		}
	}

	cout << dp[p][w];
	return 0;
}