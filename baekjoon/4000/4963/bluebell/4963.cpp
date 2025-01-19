#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int dx[] = {0, 0, -1, 1, 1, 1, -1, -1};
int dy[] = {1, -1, 0, 0, 1, -1, 1, -1};

void bfs(int x, int y, int w, int h, vector<vector<int>>& map, vector<vector<bool>>& visit)
{
    queue<pair<int, int>> q;
    q.push({x, y});
    visit[x][y] = true;

    while(!q.empty())
    {
        int cur_x = q.front().first;
        int cur_y = q.front().second;
        q.pop();

        for(int i = 0; i < 8; i++)
        {
            int nx = cur_x + dx[i];
            int ny = cur_y + dy[i];

            if (nx >= 0 && nx < h && ny >= 0 && ny < w && map[nx][ny] == 1 && visit[nx][ny] == false) 
            {
                q.push({nx, ny});
                visit[nx][ny] = true;
            }

        }

    }
}

int main()
{
    int w, h;

    while(true)
    {
        cin >> w >> h;

        if(w==0 && h ==0)
        {
            break;
        }

        vector<vector<int>> map(h, vector<int>(w));
        vector<vector<bool>> visit(h, vector<bool>(w, false));

        for(int i = 0; i < h; i++)
        {
            for(int j = 0; j < w; j++)
            {
                cin >> map[i][j]; 
            }
        }

            int island_count = 0;

        for(int i = 0; i < h; i ++)
        {
            for(int j = 0; j < w; j++)
            {
                if(map[i][j] == 1 && visit[i][j] == false)
                {
                    bfs(i, j, w, h, map, visit);
                    island_count++;
                }
            }
        }

    cout << island_count << endl;  // 각 테스트 케이스의 결과 출력    

    }
}