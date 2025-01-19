#include <iostream>
#include <string>
#include <cmath>
#include <vector>

using namespace std;

string katoer(string result)
{
    int size = result.size();

    if (size == 1)
    {
        return result;
    }
        
    int start = size/3;
    int end = 2*size/3;

    for (int i = start; i < end; i++)
    {
        result[i] = ' ';
    }

    string left = katoer(result.substr(0, start));          // 왼쪽 부분에 재귀 적용
    string right = katoer(result.substr(end));              // 오른쪽 부분에 재귀 적용

    return left +result.substr(start, end-start) + right;   // 함수가 적용된 왼쪽, 가운데 공백, 함수가 적용된 오른쪽 합쳐서 return 
}


string makestring(int n)
{
    int size = pow(3, n);
    string result(size, '-');  
   return katoer(result);
}


int main()
{
    int n;

    while (cin >> n)    
    {
        cout << makestring(n) << '\n';
    }
    
    return 0;    
}