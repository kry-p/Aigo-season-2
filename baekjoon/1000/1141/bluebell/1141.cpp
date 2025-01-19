#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

int main()
{
    int n;
    cin >> n ;

    vector<string> data(n);
    vector<string> result;

    for(int i = 0; i< n ; i ++)
    {
        cin >> data[i];
    }

    sort(data.begin(), data.end());

    int count = 0;      
    for (int i = 0; i < n; i++) 
    {
        
        if (i == n - 1 || data[i + 1].find(data[i]) != 0) 
        {
            count++;
        }
    }

    cout << count << endl;

    return 0;
}