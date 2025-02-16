#include <iostream>
#include <string>
#include <vector>

using namespace std;


string pandok(string x, string boom)
{  
    string stack;

    for (int i = 0; i < x.length(); i ++)
    {
        char c = x[i];
        stack.push_back(c);


        if(stack.size() >= boom.length() && stack.substr(stack.size()-boom.length()) == boom)
        {
            stack.erase(stack.size() - boom.length());
        }
    }
    
    if (stack.empty())
    {
        return "FRULA";
    }
    else
    {
        return stack;
    }

}

int main()
{
    string moonza, boom;

    cin >> moonza;
    cin >> boom;

    cout << pandok(moonza, boom);
}