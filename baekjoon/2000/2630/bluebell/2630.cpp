#include <iostream>
#include <vector>

using namespace std;

int countblue = 0;
int countwhite = 0;

bool check(vector<vector<int>>& matrix, int n)  // 색종이가 모두 같은 색인지 체크하는 함수 
{
    int x = matrix[0][0];

    for(int i = 0; i < n; i ++)
    {
        for(int j = 0; j < n; j ++)
        {
            if(x != matrix[i][j])
            {
                return false;
            }
        }
    }

    if(x == 1)
    {
        countblue++;
    }
    else
    {
        countwhite++;
    }
    return true;
}

vector<vector<int>> slicematrix(vector<vector<int>>& matrix, int startRow, int startCol, int numRows, int numCols) 
// 만약 색종이가 다 같지 않으면 짜르는 함수
{
    vector<vector<int>> result(numRows, vector<int>(numCols));

    for (int i = 0; i < numRows; i++) {
        for (int j = 0; j < numCols; j++) {
            result[i][j] = matrix[startRow + i][startCol + j];
        }
    }
    
    return result;
}


void splitmatrix(vector<vector<int>>& matrix, int n)
{

    if(check(matrix, n))
    {
        return;
    }
    else
    {
        vector<vector<int>> m11 = slicematrix(matrix, 0, 0, n/2, n/2);
        vector<vector<int>> m12 = slicematrix(matrix, 0, n/2, n/2, n/2);
        vector<vector<int>> m21 = slicematrix(matrix, n/2, 0, n/2, n/2);
        vector<vector<int>> m22 = slicematrix(matrix, n/2, n/2, n/2, n/2);
        splitmatrix(m11, n/2);
        splitmatrix(m12, n/2);
        splitmatrix(m21, n/2);
        splitmatrix(m22, n/2);
    }

}


int main()
{
    int n;
    cin >> n;

    vector<vector<int>> matrix(n, vector<int>(n));  //이차원 배열 선언

    for(int i = 0; i < n; i ++)
    {
        for(int j = 0; j < n; j ++)
        {
            cin >> matrix[i][j];
        }
    }

    splitmatrix(matrix, n);

    cout << countwhite << '\n';
    cout << countblue;

    return 0;

}