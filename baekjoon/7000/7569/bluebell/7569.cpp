#include <iostream>
#include <vector>
#include <queue>
#include <tuple>

using namespace std;


int dx[] = {0, 0, -1, 1, 0, 0};
int dy[] = {1, -1, 0, 0, 0, 0};
int dz[] = {0, 0, 0, 0, -1, 1};

int time(vector<vector <vector<int>>> &tomato, int m, int n, int h)
{
    queue<tuple<int, int, int>> q;
    vector<vector <vector<bool>>> visit(h, vector<vector <bool>>(n, vector<bool>(m, 0)));
    int days = 0;

    for(int z = 0; z < h; z ++)
    {
        for(int y = 0; y < n; y ++)
        {
            for(int x = 0; x < m; x++)
            {
                if(tomato[z][y][x] == 1)
                {
                    q.push({z,y,x});
                    visit[z][y][x] = true;
                }
            }
        }
    }

    while(!q.empty())
    {

        int size = q.size();
        bool updated = false;

        for(int i = 0; i < size; i ++)
        {
            auto cur = q.front();
            int cur_z = get<0>(cur);
            int cur_y = get<1>(cur);
            int cur_x = get<2>(cur);
        
            q.pop();

            for(int i = 0; i < 6; i ++)
            {
                int nx = cur_x + dx[i];
                int ny = cur_y + dy[i];
                int nz = cur_z + dz[i];

                if (nz >= 0 && nz < h && ny >= 0 && ny < n && nx >= 0 && nx < m && tomato[nz][ny][nx] == 0 && !visit[nz][ny][nx]) 
                    {
                        tomato[nz][ny][nx] = 1; 
                        visit[nz][ny][nx] = true;
                        q.push({nz, ny, nx});
                        updated = true;
                    }
            }
        }
     
        if (updated == true)
        {
            days++;
        } 

    }
    
    for(int z = 0; z < h; z ++)
    {
        for(int y = 0; y < n; y ++)
        {
            for(int x = 0; x < m; x++)
            {
                if(tomato[z][y][x] == 0)
                {
                    return -1;
                }
            }
        }
    }

    return days;
}

int main()
{
    int m , n , h;
    cin >> m >> n >> h;

    vector<vector <vector<int>>> tomato(h, vector<vector <int>>(n, vector<int>(m, 0)));

    for(int k = 0; k < h; k ++)
    {
        for(int i = 0; i < n; i ++)
        {
            for(int j = 0; j < m; j ++)
            {
                cin >> tomato[k][i][j];
            }
        }
    }

    cout << time(tomato, m, n, h);
    return 0;
}