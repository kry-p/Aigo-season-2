#include <iostream>
#include <vector>
#include <cmath>
#include <algorithm>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    
    int m, n;

    cin >> m >> n;
    cin.ignore();
    
    vector<vector<int>> add(m, vector<int>(n));
    vector<vector<int>> save(m, vector<int>(n));
    vector<vector<int>> out(m, vector<int>(n));

    for(int i = 0; i < m; i ++)
    {
        string line;
        getline(cin, line);

        for(int j = 0; j < n; j++)
        {
            add[i][j] = line[j] - '0';
        }
    }

    for(int i = 0; i < m; i++)
    {
        out[i][0] = add[i][0];
    }

    for(int j = 1; j < n; j++) //첫 번째 열은 이미 초기화가 완료되었기 때문에, index를 1부터 시작한다.
    {
        for(int i = 0; i < m; i++)  
        {
            int max_data = out[i][j-1];
            
            if(i > 0)
            {
                max_data = max(max_data, out[i - 1][j - 1]);
            }

            if(i < m-1)
            {
                max_data =  max(max_data, out[i + 1][j -1]);
            }

            save[i][j] = max_data;
            out[i][j] = save[i][j] + add[i][j];
        }
    }

    int result = 0;

    for (int j = 0; j < n; j++) {
        for (int i = 0; i < m; i++) 
        {
            result = max(result, save[i][j]);
        }
    }

    cout << result;
    return 0;
}
