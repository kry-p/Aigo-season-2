#include <iostream>
#include <vector>
#include <queue>
#include <climits>
#include <tuple>

using namespace std;

int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};

int leftdir[4]  = {2, 3, 1, 0};
int rightdir[4] = {3, 2, 0, 1};

int m, n;

int start_x, start_y, start_dir;
int finish_x, finish_y, finish_dir;

int convertDir(int d) 
{
    int conv[5] = {0, 3, 2, 1, 0}; 
    return conv[d];
}


int bfs(vector<vector<int>> &map)
{
    vector<vector<vector<int>>> cost(m, vector<vector<int>>(n, vector<int>(4, INT_MAX)));
    
    queue<tuple<int, int, int>> q;
    cost[start_x][start_y][start_dir] = 0;
    q.push({start_x, start_y, start_dir});

    while(!q.empty())
    {
        int x, y, dir;
        tie(x, y, dir) = q.front();
        q.pop();
        int current_cost = cost[x][y][dir];
        
        if (x == finish_x && y == finish_y && dir == finish_dir)
        {
            return current_cost;
        }
            
        int nd = leftdir[dir];

        if (current_cost + 1 < cost[x][y][nd]) 
        {
            cost[x][y][nd] = current_cost + 1;
            q.push({x, y, nd});
        }
        nd = rightdir[dir];
        if (current_cost + 1 < cost[x][y][nd]) 
        {
            cost[x][y][nd] = current_cost + 1;
            q.push({x, y, nd});
        }
            
        for(int k = 1; k <= 3; k ++)
        {
            int nx = x + dx[dir] * k;
            int ny = y + dy[dir] * k;

            if(nx >= 0 && nx < m && ny >= 0 && ny < n)
            {
                 if (map[nx][ny] == 0) {
                    if (current_cost + 1 < cost[nx][ny][dir]) {
                        cost[nx][ny][dir] = current_cost + 1;
                        q.push({nx, ny, dir});
                    }
                }
                else 
                {
                    break;
                }
            }
                else 
                {
                    break;
                }
        }
    }
}

int main()
{
    cin >> m >> n;

    vector<vector <int>> map(m, vector<int>(n, 0));

    for(int i = 0; i < m; i ++)
    {
        for(int j = 0; j < n; j ++)
        {
            cin >> map[i][j];
        }
    }

    cin >> start_x >> start_y >> start_dir;
    cin >> finish_x >> finish_y >> finish_dir;

    start_x--;
    start_y--;
    finish_x--;
    finish_y--;

    start_dir = convertDir(start_dir);
    finish_dir = convertDir(finish_dir);
    
    cout << bfs(map) << "\n";
    return 0;
}
