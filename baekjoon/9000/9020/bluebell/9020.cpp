#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
    int t;
    int max = 10000;

    cin >> t;

    vector<int> n(t);
    vector<bool> num(max+1, true);

    num[0] = 0;
    num[1] = 0;

    for(int i = 2; i * i <= max; i ++)
    {
        if(num[i])
        {
            for (int k = i * i; k <= max; k = k + i) 
            {
                num[k] = false;
            }
        }
    }
        
    for(int i = 0; i < t; i++)
    {
        cin >> n[i];
    }

     for (int i = 0; i < t; i++)
    {
        int target = n[i];
        int a = 0, b = 0;

        for (int j = 2; j <= target / 2; j++)
        {
            if (num[j] && num[target - j])
            {
                a = j;
                b = target - j;
            }
        }

        cout << a << " " << b << endl;
    }


    return 0;
}