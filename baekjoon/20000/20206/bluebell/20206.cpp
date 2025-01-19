#include <iostream>

using namespace std;


int main()
{
    
    double a, b, c;
    double x1, x2, y1, y2;

    cin >> a >> b >> c;
    cin >> x1 >> x2 >> y1 >> y2;

    double temp1 = a* x1 + b*y1 + c;
    double temp2 = a* x2 + b*y1 + c;

    double temp3 = a* x1 + b*y2 + c;
    double temp4 = a* x2 + b*y2 + c;

    if((temp1 >= 0 && temp2 >= 0 && temp3 >= 0 && temp4 >= 0)|| (temp1 <= 0 && temp2 <= 0 && temp3 <= 0 && temp4 <= 0))
    {
        cout << "Lucky";
    }
    else
    {
        cout << "Poor";
    }
}