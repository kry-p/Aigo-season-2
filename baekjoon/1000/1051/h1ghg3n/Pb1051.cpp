#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;

int main()
{
    int n, m;
    int i, j, l, p;
    string s;
    ios_base::sync_with_stdio(NULL);

    cin >> n >> m;
    vector<vector<int>>v(n);
    for (i = 0; i < n; i++) {
        cin >> s;
        j = 0;
        while (s[j] > 0) {
            v[i].push_back(-1);
            v[i][j] = s[j] - '0';
            // cout << v[i][j] << " ";
            j++;
        }
    }
    i = 0;
    j = 0;
    p = 1;
    l = p;
    for (i = 0;  i + p < n; i++) {
        for (j = 0; j + p < m; j++) {
            for (l = p; i + l < n && j + l < m; l++) { // 정사각형이 배열 범위 내 일때
                if (v[i][j] == v[i + l][j + l] && v[i + l][j + l] == v[i + l][j] && v[i][j] == v[i][j + l]) // 귀퉁이가 같으면 , 좌상 = 우하, 우하= 좌하, 좌상 = 우상
                {
                    p = l + 1;
                    //std::cout << i << j << " " << l << "\n";
                }
            }
        }
    }
    std::cout << p * p;
    return 0;
}