#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
    int n;
    cin >> n;

    vector<vector<int>> triangle(n, vector<int>(n, 0));
    vector<vector<int>> dp(n, vector<int>(n, 0));

    for(int i = 0; i < n ; i ++)
    {
        for(int j = 0; j <= i; j ++)
        {
            cin >> triangle[i][j];
        }
    }

    dp[0][0] = triangle[0][0];

    for(int i = 1; i < n; i ++)
    {
        for(int j = 0; j <= i; j ++)
        {
            if(j == 0)
            {
                dp[i][j] = dp[i-1][j] + triangle[i][j];
            }
            else if(j == i)
            {
                dp[i][j] = dp[i-1][j-1] + triangle[i][j];
            }
            else
            {   
                dp[i][j] = max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
            }
        }
    }

    int result = *max_element(dp[n-1].begin(), dp[n - 1].begin()+n);

    cout << result;

    return 0;

}