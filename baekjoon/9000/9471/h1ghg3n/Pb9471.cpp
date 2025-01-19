#include <iostream>
#include <algorithm>

using namespace std;


int moduler(int n) {
	if (n == 2)
		return 3;
	int i = 0,  f = 1, g = 1, h;
	while(true) {
		h = (f + g ) % n;
		f = g;
		g = h;
		if (f == 1 && g == 1)
			return i+1;
		i++;
	}
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);

	int a, b, c, n;
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> a >> b;
		c = moduler(b);
		cout << a << " " << c << "\n";
	}
}
