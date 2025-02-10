#include <iostream>
#include <vector>
using namespace std;

int dx[5] = {0, 0, 0, -1, 1};
int dy[5] = {0, 1, -1, 0, 0};
int dice[7] = {0,0,0,0,0,0,0};

void rolleast() 
{
    int tmp = dice[1];
    dice[1] = dice[4];
    dice[4] = dice[6];
    dice[6] = dice[3];
    dice[3] = tmp;
}

void rollwest() 
{
    int tmp = dice[1];
    dice[1] = dice[3];
    dice[3] = dice[6];
    dice[6] = dice[4];
    dice[4] = tmp;
}

void rollnorth() 
{
    int tmp = dice[1];
    dice[1] = dice[5];
    dice[5] = dice[6];
    dice[6] = dice[2];
    dice[2] = tmp;
}

void rollsouth() 
{
    int tmp = dice[1];
    dice[1] = dice[2];
    dice[2] = dice[6];
    dice[6] = dice[5];
    dice[5] = tmp;
}

int main()
{

    int n, m, x, y, k;
    cin >> n >> m >> x >> y >> k;
    
    vector<vector<int>> map(n, vector<int>(m));

    for(int i = 0; i < n; i++)
    {
        for(int j = 0; j < m; j++)
        {
            cin >> map[i][j];
        }
    }
    
    vector<int> commands(k);

    for(int i = 0; i < k; i++)
    {
        cin >> commands[i];
    }
    
    for (int i = 0; i < k; i++)
    {
        int cmd = commands[i];
        int nx = x + dx[cmd];
        int ny = y + dy[cmd];

        if(nx < 0 || nx >= n || ny < 0 || ny >= m)
        {
            continue;
        } 

        x = nx;
        y = ny;

        if(cmd == 1)      rolleast();
        else if(cmd == 2) rollwest();
        else if(cmd == 3) rollnorth();
        else if(cmd == 4) rollsouth();


        if(map[x][y] == 0)
        {
            map[x][y] = dice[6];
        } 
        else 
        {
            dice[6] = map[x][y];
            map[x][y] = 0;
        }
        
        cout << dice[1] << "\n";
    }
    
    return 0;
}
