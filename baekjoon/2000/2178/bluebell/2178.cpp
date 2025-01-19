#include <iostream>
#include <vector>
#include <queue>
#include <string>

using namespace std;


int dx[] = {0, 0, -1, 1};
int dy[] = {1, -1, 0, 0};

int bfs(int x, int y, int n, int m, vector<vector<int>> &map, vector<vector<bool>> &visit)
{
    queue<pair<int, int>> q;
    q.push({x, y});
    visit[x][y] = true;

    vector<vector<int>> distance(n, vector<int>(m, 0));
    distance[x][y] = 1;

    while(!q.empty())
    {
        int cur_x = q.front().first;
        int cur_y = q.front().second;

        q.pop();

        if (cur_x == n - 1 && cur_y == m - 1)
        {
            return distance[cur_x][cur_y];
        }

        for(int i = 0; i < 4; i++)
        {
            int nx = cur_x + dx[i];
            int ny = cur_y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < n && ny < m && visit[nx][ny] == false && map[nx][ny] != 0)
            {   
                q.push({nx, ny});
                visit[nx][ny] = true;
                distance[nx][ny] = distance[cur_x][cur_y] + 1;
            }

        }
        
    }
}

int main()
{
    int n, m;

    cin >> n >> m;

    vector<vector<int>> map(n, vector<int>(m));
    vector<vector<bool>> visit(n, vector<bool>(m, false));

    cin.ignore();

    for(int i = 0; i< n; i++)
    {
        string line;
        getline(cin, line);

        for(int j = 0; j < m; j++)
        {
            map[i][j] = line[j] - '0';
        }
    }

    cout << bfs(0, 0, n, m, map, visit);
}