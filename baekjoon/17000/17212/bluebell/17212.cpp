#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() 
{
    int n;
    cin >> n;

    vector<int> dp(n + 1, 1e9);      
    dp[n] = 0;  

    int coins[] = {1, 2, 5, 7};

    for(int i = n; i > 0; i--)
    {
        for(int coin : coins)
        {
            if(i - coin >= 0)
            {
                dp[i-coin] = min(dp[i-coin], dp[i]+1);
            }
        }
    }

    cout << dp[0] << endl;  
    return 0;
}