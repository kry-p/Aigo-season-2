#include <string>
#include <iostream>

using namespace std;

int main() {
	string s;
	int n,a;
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> a;
		cin >> s;
		for (int j = 0; j < s.size(); j++) {
			for (int k = 0; k < a; k++) {
				cout << s[j];
			}
		}
		cout << "\n";
	}
	return 0;
}