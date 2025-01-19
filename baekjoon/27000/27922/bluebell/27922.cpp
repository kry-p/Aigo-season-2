#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
    int n, k; 
    
    cin >> n >> k;

    vector<int> a(n);
    vector<int> b(n);
    vector<int> c(n);
    vector<int> sum_ab(n), sum_ac(n), sum_bc(n);

    for(int i=0 ; i< n ; i ++)
    {
        cin >> a[i] >> b[i] >> c[i];
        sum_ab[i] = a[i] + b[i];
        sum_bc[i] = b[i] + c[i];
        sum_ac[i] = a[i] + c[i];
    }

    sort(sum_ab.begin(), sum_ab.end(), greater<int>());
    sort(sum_bc.begin(), sum_bc.end(), greater<int>());
    sort(sum_ac.begin(), sum_ac.end(), greater<int>());

    int max_ab = 0, max_bc = 0, max_ac = 0;

    for(int i = 0; i < k; i ++)
    {
        max_ab += sum_ab[i];
        max_bc += sum_bc[i];
        max_ac += sum_ac[i];
    }

    int result = max(max_ab, max_bc);
    result = max(result, max_ac);

    cout << result;    

    return 0;
}