#include <iostream>
#include <algorithm>

using namespace std;
int dp[100001] = { 1 };


int main() {
	
	int amount;
	cin >> amount;

	dp[0] = 0; dp[1] = 1;
	int money[4] = { 1,2,5,7 }; // ���� ���� ����
	for (int i = 2; i <= amount; i++) { // �־��� �ݾױ��� �ݺ�
		dp[i] = dp[i - 1] + 1; // �ּ�ġ ���� (������ ���� �ѹ��� �ؾ��ϴϱ�)
		cout << i << " " << dp[i] << "\n";
		for (int j = 0; j < 4; j++) { // �� �ݾױ� ������ ������ ���� �ݾ׿� ���� �ּ����ҹ�� ��
			if (i >= money[j]) {
				int temp = 1 + dp[i - money[j]];
				// cout << i - money[j] << "\n";
				if (temp < dp[i]) {
					dp[i] = temp;
				}
			}
		}
	}
		// cout << i << " ���� ������ " << dp[i] << "��\n";
	
	cout << dp[amount];
	return 0;
}