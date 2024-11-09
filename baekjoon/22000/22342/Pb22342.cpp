#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <algorithm>

using namespace std;
int s[2002][2002] = { 0 };

int main() {

	int m,n;
	scanf("%d %d",&m ,&n);

	for (int i = 1; i <= m; i++) {
		for (int j = 1; j <= n; j++) {
			// "%1d" »ç¿ë
			scanf("%1d", &s[i][j]);
		}
	}


	for (int j = 1; j < n; j++) {
		for (int i = 1; i <= m; i++) {
			s[i][j] = max({ s[i - 1][j - 1], s[i][j - 1], s[i+1][j - 1] }) + s[i][j];	
		}
	}


	int result = 0;
	for (int i = 1; i <= m; i++) {
		if (result < s[i][n-1])
			result = s[i][n-1];
	}

	printf("%d", result);

	return 0;
}