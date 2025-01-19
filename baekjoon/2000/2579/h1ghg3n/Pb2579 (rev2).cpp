#include<iostream>
#include<algorithm>
using namespace std;

int sc[301];
int st[301];
int main(void)
{
	int n;
	cin >> n;
	for (int i = 1; i <= n; i++)
		cin >> st[i];

	sc[1] = st[1];
	sc[2] = st[1] + st[2];
	sc[3] = max(st[1] + st[3], st[2] + st[3]);

	for (int i = 4; i <= n; i++)
	{
		int a = sc[i - 2] + st[i];
		int b = sc[i - 3] + st[i - 1] + st[i];
		sc[i] = max(a, b);
	}
	cout << sc[n];
	return 0;
}