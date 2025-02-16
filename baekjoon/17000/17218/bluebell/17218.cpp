#include <iostream>
#include <string>
#include <vector>

using namespace std;

string LCS (string x, string y)
{
    int xlen = x.length();
    int ylen = y.length();

    vector<vector<int>> dp(xlen+1, vector<int>(ylen+1, 0));
    string result;

    for(int i = 1; i <= xlen; i++)
    {
        for(int j = 1; j <= ylen; j++)
        {
            if(x[i-1] == y[j-1])
            {
                dp[i][j] = dp[i-1][j-1]+1;
            }
            else
            {
                dp[i][j] = max(dp[i-1][j], dp[i][j-1]);
            }

        }
    }

    int i = xlen;
    int j = ylen;

    while (i > 0 && j > 0) 
    {
        if (x[i - 1] == y[j - 1]) 
        {
            result = x[i - 1] + result; 
            i--;
            j--;
        } 
        else if (dp[i - 1][j] > dp[i][j - 1]) 
        {
            i--;
        } 
        else 
        {
            j--;
        }
    }
    return result;
}


int main()
{
    string x, y;
    cin >> x;
    cin >> y;

    cout << LCS(x,y);
}