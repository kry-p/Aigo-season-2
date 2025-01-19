#include <iostream>
#include <algorithm>
#include <cmath>

using namespace std;

long long end_x, end_y, w, s;
long long time1, time2, time3;

int main()
{
    time1 = 0;
    time2 = 0;
    time3 = 0;

    cin >> end_x >> end_y >> w >> s;

    time1 = (end_x + end_y) * w;

    if ((end_x + end_y) % 2 == 0) 
    {
        time2 = max(end_x, end_y) * s; 
    } else 
    {
        time2 = (max(end_x, end_y) - 1) * s + w; 
    }

    time3 = min(end_x, end_y) * s + (max(end_x,end_y) - min(end_x,end_y))*w;


    cout << min({time1, time2, time3});

} 