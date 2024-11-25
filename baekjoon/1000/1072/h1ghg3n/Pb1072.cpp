#include <iostream>
#include <algorithm>
#include <cmath>

using namespace std;

int main() {
	long long a, b;
	long long c, d;
	cin >> a >> b;
	
	c= (b*100) /a;
	d = c+1;
	if (c >= 99) {
		cout << -1;
		return 0;
	}
	long long i = 0;
	i = ceil((double(d * a - b*100)/(100-d)));

	cout << i;
	return 0;
}