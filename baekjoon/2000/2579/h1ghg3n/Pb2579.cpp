#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <algorithm>

using namespace std;
int st[305] = {0};
int dp[305] = { 0 };


int main() {
	int n;
	int result = 0;
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		scanf("%d", &st[i]);
	}

	for (int i = 3; i <= n+3; i++) {
		dp[i] = max({ st[i - 3], st[i - 2], st[i - 1] })+st[i];
	}
	for (int i = 0; i < 304; i++) {
		if (result < dp[i]) {
			result = dp[i];
			printf("%d\n", i);
		}
	}
	printf("%d", result);
}

//#include<iostream>
//#include<algorithm>
//using namespace std;
//
//int score[301];
//int stair[301];
//int main(void)
//{
//	int n;
//	cin >> n;
//	for (int i = 1; i <= n; i++)
//		cin >> stair[i];
//
//	score[1] = stair[1];
//	score[2] = stair[1] + stair[2];
//	score[3] = max(stair[1] + stair[3], stair[2] + stair[3]);
//
//	for (int i = 4; i <= n; i++)
//	{
//		int a = score[i - 2] + stair[i];
//		int b = score[i - 3] + stair[i - 1] + stair[i];
//		score[i] = max(a, b);
//	}
//	cout << score[n];
//	return 0;
//}