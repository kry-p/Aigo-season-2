#include <iostream>
#include <vector>

using namespace std;

int factorial(int n)
{
    int result = 1;

    for (int i = 1; i <= n; i++)
    {
        result = result * i;
    }
    
    return result;
}

int combination(int n, int m)
{
    int result = 1;

    if(n > m - n)
    {
        n = m - n;
    }   

    for(int i = 1; i <= n; ++i)
    {
        result = result * (m - i + 1) / i;
    }
    return result;
}


int main()
{
    int t;
    cin >> t;

    vector <int> n(t);
    vector <int> m(t);

    for(int i = 0; i < t; i++)
    {
        cin >> n[i] >> m[i]; 
    }
    
    for(int i = 0; i < t; i++)
    {
        cout << combination(n[i], m[i]) << endl;
    }
    return 0;
}