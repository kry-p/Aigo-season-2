#include <iostream>

using namespace std;

void pibo(int a, int m, int arr[]);

int c[1000005] = { 0 };

int main() {
	int a, n = 1;
	cin >> a;
	if (a<0)
		n= -1;

	pibo (a, n, c);

	return 0;
}

// 1 0 -1-2-3-4 -5 -6
// 1 0 1 -1 2 -3 5 -8
void pibo(int a, int m, int arr[]) {
	int c = a * m;
	arr[1] = 1;
	for (int i = 2; i < c+1; i++) {
		arr[i] = (arr[i - 1] + arr[i - 2]) %1000000000;
	}
	if (m == -1 && c % 2 == 0) {
		arr[c] = arr[c];
	}

	if (a<  0&& a%2 == 0)
		cout << -1 << "\n";
	else if (arr[c] ==0)
		cout << 0 << "\n";
	else
		cout << 1 << "\n";

	cout << arr[c];
}