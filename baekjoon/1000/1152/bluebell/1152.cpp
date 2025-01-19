#include <iostream>
#include <string>
#include <sstream>
#include <vector>

using namespace std;

int main()
{
    string str, check;
    stringstream ss;
    vector <string> buffer;

    getline(cin, str);

    ss.str(str);

    while(ss >> check) 
    {
        buffer.push_back(check);
    }

    cout << buffer.size();

    return 0;
}