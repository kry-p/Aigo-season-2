#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

int n, m;
vector<vector<int>> graph;

vector<int> bfs(int start)
{
    vector<int> dist(n+1, -1);
    queue<int> q;

    dist[start] = 0;
    q.push(start);

    while(!q.empty())
    {
        int cur = q.front();
        q.pop();

        for(int i = 0; i < graph[cur].size(); i++)
        {   
            int next = graph[cur][i];
            
            if (dist[next] == -1) 
            { 
                dist[next] = dist[cur] + 1;
                q.push(next);
            }
        }
    }
    return dist;
}

void add_edge(int u, int v)
{
    if (find(graph[u].begin(), graph[u].end(), v) == graph[u].end()) 
    {
        graph[u].push_back(v);
        graph[v].push_back(u);
    }
}

void remove_edge(int u, int v) 
{
    graph[u].erase(remove(graph[u].begin(), graph[u].end(), v), graph[u].end());
    graph[v].erase(remove(graph[v].begin(), graph[v].end(), u), graph[v].end());
}

int main()
{
    cin >> n >> m;

    graph.resize(n+1);

    for(int i = 0; i < m; i++)
    {
        int u, v;

        cin >> u >> v;

        add_edge(u,v);
    }

    int q, u, v, type;

    cin >> q;

    for(int i = 0; i < q; i ++)
    {
        cin >> type;

        if(type == 1)
        {
            cin >> u >> v;
            add_edge(u, v);
        }
        else if(type == 2)
        {
            int u, v;
            cin >> u >> v;
            remove_edge(u,v);
        }

        vector<int> distances = bfs(1);

        for (int j = 1; j <= n; j++) {
            cout << distances[j] << " ";
        }
        cout << endl;
    }

    return 0;
}