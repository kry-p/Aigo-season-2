#include <iostream>
#include <string>
#include <vector>

using namespace std;


string pandok(string x)
{  
    string stack;

    for (int i = 0; i < x.length(); i ++)
    {
        char c = x[i];
        stack.push_back(c);


        if(stack.size() >= 4 && stack.substr(stack.size()-4) =="PPAP")
        {
            stack.erase(stack.size() - 4);
            stack.push_back('P');
        }
    }
    
    if (stack == "P")
    {
        return "PPAP";
    }
    else
    {
        return "NP";
    }

}

int main()
{
    string moonza;

    cin >> moonza;

    cout << pandok(moonza);
}