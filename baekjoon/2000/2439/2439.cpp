#include <iostream>

using namespace std;

int main()
{
    int n;
    cin >> n;

    for (int i = 0; i < n; i++)
    {
        int j = 0;
        for (j = 0; j < n-i-1; j++)
        {
            cout << " ";
        }
        for (int k = 0; k < n-j ;k++)
        {
            cout << "*";
        }

        cout << endl;
    }

    return 0;
}