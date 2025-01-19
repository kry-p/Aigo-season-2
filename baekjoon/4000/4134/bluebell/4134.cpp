#include <iostream>
#include <cmath>
#include <vector>

using namespace std;

unsigned long long find(unsigned long long x)
{
    unsigned long long test = x;

    while(1)
    { 
        if (test <= 2)
        {
            return 2;
        }
        if (test % 2 == 0)
        {
            test++;
        }
        else
        {
            
            bool prime = true;

            if (test == 1)
            {
                prime = false;
            }
            for(unsigned long long n = 3; n*n <= test; n = n+2)
            {
                if (test%n == 0)
                {
                    prime = false;
                    break;
                }
            }

            if(prime)
            {
                return test;
            }
            else
            {
                test = test+2;
            }

        }

    }
}

int main()
{
    int t;
    cin >> t;

    vector <unsigned long long> n(t);

    for(int i = 0; i < t; i++)
    {
        cin >> n[i]; 
    }
    
    for(int i = 0; i < t; i++)
    {
        cout << find(n[i]) << endl;
    }
    return 0;
}