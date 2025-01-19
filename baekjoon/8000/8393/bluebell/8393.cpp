#include <iostream>

using namespace std;

int main()
{
    int n;
    cin >> n;
    if (n < 1 || n > 10000)
    {
        cout << "number error";
    }
    else
    {
        int sum = 0;
        for (int i = 1; i < n+1; i++)
        {
            sum = sum + i;
        }
        cout << sum << endl; 
    }

    return 0;
}