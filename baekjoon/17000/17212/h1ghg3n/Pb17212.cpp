#include <iostream>
#include <algorithm>

using namespace std;
int dp[100001] = { 1 };


int main() {
	
	int amount;
	cin >> amount;

	dp[0] = 0; dp[1] = 1;
	int money[4] = { 1,2,5,7 }; // 코인 가격 설정
	for (int i = 2; i <= amount; i++) { // 주어진 금액까지 반복
		dp[i] = dp[i - 1] + 1; // 최소치 설정 (무조건 지불 한번은 해야하니까)
		cout << i << " " << dp[i] << "\n";
		for (int j = 0; j < 4; j++) { // 각 금액권 지불을 했을때 남은 금액에 대한 최소지불방법 비교
			if (i >= money[j]) {
				int temp = 1 + dp[i - money[j]];
				// cout << i - money[j] << "\n";
				if (temp < dp[i]) {
					dp[i] = temp;
				}
			}
		}
	}
		// cout << i << " 원의 지불은 " << dp[i] << "개\n";
	
	cout << dp[amount];
	return 0;
}