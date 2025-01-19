#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int dx[] = {0, 0, -1, 1};
int dy[] = {1, -1, 0, 0};

pair<int,int> bfs(int x, int y, int r, int c, vector<vector<char>> &map, vector<vector<bool>> &visit)
{
    queue<pair<int, int>> q;
    q.push({x,y});
    visit[x][y] = true;

    int sheep = 0;
    int wolf = 0;

    if(map[x][y] == 'o')
    {
        sheep++;
    }
    if(map[x][y] == 'v')
    {
        wolf++;
    }


    while(!q.empty())
    {
        int cur_x = q.front().first;
        int cur_y = q.front().second;

        q.pop();

        for(int i = 0; i < 4; i++)
        {
            int nx = cur_x + dx[i];
            int ny = cur_y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < r && ny < c && visit[nx][ny] == false && map[nx][ny] != '#')
            {   
                q.push({nx, ny});
                visit[nx][ny] = true;
                
                if(map[nx][ny] == 'o')
                {
                    sheep++;
                }
                else if(map[nx][ny] == 'v')
                {
                    wolf++;
                }
            }

        }
        
    }
    return{sheep, wolf};
}

int main()
{
    int r, c;

    cin >> r >> c;

    vector<vector<char>> map(r, vector<char>(c));
    vector<vector<bool>> visit(r, vector<bool>(c));
    
    cin.ignore();

    for(int i = 0; i< r; i++)
    {
        string line;
        getline(cin, line);

        for(int j = 0; j < c; j++)
        {
            map[i][j] = line[j];
        }
    }

    int total_sheep, total_wolf = 0;

    for(int i = 0; i < r; i ++)
    {
        for(int j = 0; j < c; j++)
        {
            if(map[i][j] == '#' && visit[i][j] == false)
            {
                pair<int, int> result = bfs(i, j, r, c, map, visit);
                int sheep = result.first;
                int wolf = result.second;
    
                if (sheep > wolf)
                total_sheep += sheep;
                else
                total_wolf += wolf;
            }
        }
    }
    cout << total_sheep << ' ' << total_wolf;
}