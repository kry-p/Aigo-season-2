#include <iostream>
#include <vector>
#include <queue>
#include <climits>

using namespace std;

int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};

int dijkstra(vector<vector<int>> map, int n)
{
    vector<vector <int>> cost(n, vector<int>(n, INT_MAX));
    cost[0][0] = map[0][0];

    priority_queue<pair<int, pair<int, int>>, vector<pair<int, pair<int, int>>>, greater<>> pq;
    pq.push({map[0][0], {0, 0}});

    while(!pq.empty())
    {
        int current_cost = pq.top().first;
        int x = pq.top().second.first;
        int y = pq.top().second.second;
        pq.pop();

        if(current_cost > cost[x][y])
        {
            continue;
        }
            
        for(int i = 0; i < 4; i ++)
        {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < n && ny >= 0 && ny < n)
            {
                int new_cost = current_cost + map[nx][ny];

                if (new_cost < cost[nx][ny])
                {
                    cost[nx][ny] = new_cost;
                    pq.push({new_cost, {nx, ny}});
                }
            }
        }
        

    }

    return cost[n-1][n-1];
}

int main()
{        
    int index = 1;

    for(int i = 0; i <= 123; i++)
    {   
        int n;
        cin >> n;

        if (n == 0)
        {
            break;
        }
        else
        {
            vector<vector <int>> map(n, vector<int>(n, 0));
            for(int j = 0; j < n; j ++)
            {
                for(int x = 0; x < n; x ++)
                {
                    cin >> map[j][x];
                }
            }
            cout << "Problem " << index << ": " << dijkstra(map, n) << "\n";
            index++;
        }
    }
}
