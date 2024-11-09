#include <iostream>

using namespace std;

int v[1025][1025];
int mirror[1025][1025];

int main() {
	ios::sync_with_stdio(0); // <<-- 시간을 제대로 단축하려면 tie(0)과 함께 쓸 것.
	cin.tie(NULL);
	cout.tie(NULL);

	int n, m;
	cin >> n >> m;
	

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			cin >> v[i][j];
			mirror[i][j] = v[i][j] + mirror[i-1][j] + mirror[i][j-1] - mirror[i-1][j-1];
		}
	}
	int x1, y1, x2, y2;

	for (int k = 0; k < m; k++) {
		cin >> x1 >> y1 >> x2 >> y2;
		cout << mirror[x2][y2] - mirror[x1 - 1][y2] - mirror[x2][y1 - 1] + mirror[x1 - 1][y1 - 1] << '\n';
	}

	return 0;
}