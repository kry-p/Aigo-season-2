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

	int p, w; // ����, ����
	cin >> p >> w;
	for (int i = 1; i <= p; i++) {
		cin >> n[i][0] >> n[i][1];
	}
	for (int j =1; j <= w; j++) { // dp [w] = dp[w-n] + max(a[n]--> �������� �´� �ִ� ��ġ n = )
		for (int i = 1; i <= p; i++) {
			if (n[i][0] <= j) {
				dp[i][j] = max(dp[i - 1][j], n[i][1] + dp[i - 1][j - n[i][0]]); // i��° ������ �����Ͽ� ���������� j ���Ա����� �ִ� ��ġ = max (i-1��° j���Ա����� �ִ�, i��° ������ ��ġ + j
			}
			else {
				dp[i][j] = dp[i - 1][j];
			}
		}
	}

	for (int i = 0; i <= p; i++) {
		for (int j = 0; j <= w; j++) {
			cout << "dp" << i << "��" << j << "��: " << dp[i][j] << "\n";
		}
	}

	cout << dp[p][w];
	return 0;
}