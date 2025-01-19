#include <iostream>
#include <string>

using namespace std;

int main()
{
    float a, b, result;
    int n;
    cin >> a >> b >> n;

    result = a / b;

    string buff = to_string(result);

    for(int i = 0; i <= buff.length()-1; i++)
    {
        if (buff[i] == '.')
        {
            if (i + n < buff.length())  
            {
                cout << buff[i + n] << endl;
            }

        }

    }

    return 0;
}