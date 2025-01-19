#include <iostream>
#include <queue>
#include <vector>

using namespace std;

int dx[] = {0, 0, -1, 1};
int dy[] = {1, -1, 0, 0};

void bfs(int x, int y, int w, int h, vector<vector<char>> &map, vector<vector<bool>> &visit)
{
    queue<pair<int, int>> q;
    q.push({x, y});
    visit[x][y] = true;

    while(!q.empty())
    {
        int cur_x = q.front().first;
        int cur_y = q.front().second;
        q.pop();

        for(int i = 0; i < 4; i ++)
        {
            int nx = cur_x + dx[i];
            int ny = cur_y + dy[i];

            if(nx >= 0 && nx < h && ny >= 0 && ny < w && map[nx][ny] == '#' && visit[nx][ny] == false)
            {
                q.push({nx, ny});
                visit[nx][ny] = true;
            }
        }

    }
}

int main()
{
    int t, h, w;

    cin >> t;

    for(int i = 0; i < t; i++)
    {   
        cin >> h >> w;

        vector<vector<char>> map(h, vector<char>(w));
        vector<vector<bool>> visit(h, vector<bool>(w, false));
        

        cin.ignore();

        for(int j = 0; j < h; j ++)
        {
            string line;
            getline(cin, line);

            for(int k = 0; k < w; k++)
            {
                map[j][k] = line[k];
            }
        }

            int sheep_count = 0;

        for(int i = 0; i < h; i ++)
        {
            for(int j = 0; j < w; j++)
            {
                if(map[i][j] == '#' && visit[i][j] == false)
                {
                    bfs(i, j, w, h, map, visit);
                    sheep_count++;
                }
            }
        }
        cout << sheep_count << endl;
    }


}