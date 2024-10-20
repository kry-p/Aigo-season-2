// 마법사 상어와 파이어볼
// 20056
// 제한시간을 둔다.
#include <iostream>
#include <vector>

using namespace std;

struct fireball
{
  int x, y; // 좌표
  int m;   // 질량 
  int d;   // 방향
  int s;   // 속력
};

vector<fireball> map[51][51];
vector<fireball> fireballs; 
// fireball 정보를 따로 관리하는 것이 좋음.

int N, M, K; // K번 이동 명령
int r, c, m, d, s; // (r, c), 질량, 방향, 속력
int ans = 0;

// 격자 방향
int dx[8] = {-1, -1, 0, 1, 1, 1, 0, -1};
int dy[8] = {0, 1, 1, 1, 0, -1, -1, -1};

// 모든 파이어볼 이동
void move()
{
  // map 초기화
  for(int i = 1; i <= N; i++)
  {
    for(int j = 1; j <= N; j++)
    {
      map[i][j].clear();
    }
  }

  // 모든 파이어볼 이동 수행 및 맵에 저장
  for(int i = 0; i < fireballs.size(); i++)
  {
    fireball fb = fireballs[i];
    int cm = fb.m, cd = fb.d, cs = fb.s;
    int nx = fb.x, ny = fb.y;
    int cx = fb.x, cy = fb.y;
    
    // 속력만큼 이동 해당 방향으로 이동
    for(int j = 0; j < cs; j++)
    {
      nx += dx[cd];
      ny += dy[cd];

      // 이렇게 특정 조건이면 값 변해야할 때 else if 사용이
      // 아닌 모두 if문을 따로 사용해서 모든 조건을 체크하는 것이 옳다.
      if(nx < 1)
      {
        nx = N;
      }
      if(ny < 1)
      {
        ny = N;
      }
      if(nx > N)
      {
        nx = 1;
      }
      if(ny > N)
      {
        ny = 1;
      }
    }

    map[nx][ny].push_back({nx, ny, cm, cd, cs});
  }
}

// 이동이 모두 끝난 뒤, 2개 이상의 파이어볼이 있는 칸에서는 다음과 
// 같은 일이 일어난다.
void split()
{
  // 임시로 파이어볼 이동한 위치 저장하는 벡터
  vector<fireball> temp;

  for(int i = 1; i <= N; i++)
  {
    for(int j = 1; j <= N; j++)
    {
      // 변수 여기에 선언해야 모든 경우에 자동 초기화
      int msum = 0, ssum = 0;
      bool evenFlag = false, oddFlag = false;
      
      // 파이어볼 하나만 존재(분할x)
      if(map[i][j].size() == 1)
      {
        temp.push_back(map[i][j][0]); // 이렇게 그대로 넣어줄 수 있음. 변수 안 빼도 됨
      } 
      
      else if(map[i][j].size() >= 2)
      {
        for(int k = 0; k < map[i][j].size(); k++)
        {
          msum += map[i][j][k].m; // 질량합
          ssum += map[i][j][k].s; // 속력합

          // 방향 짝홀 탐색
          if(map[i][j][k].d % 2 == 0)
          {
            evenFlag = true;
          } 
          else 
          {
            oddFlag = true;
          }
        }

        msum /= 5;
        ssum = ssum / map[i][j].size();

        // 질량이 0인 파이어볼은 소멸되어 없어진다.
        if(msum == 0)
        {
          continue;
        }

        // 모두 홀수이거나 짝수
        if((evenFlag && !oddFlag) || (!evenFlag && oddFlag))
        {
          temp.push_back({i, j, msum, 0, ssum});
          temp.push_back({i, j, msum, 2, ssum});
          temp.push_back({i, j, msum, 4, ssum});
          temp.push_back({i, j, msum, 6, ssum});
        } 
        else 
        {
          temp.push_back({i, j, msum, 1, ssum});
          temp.push_back({i, j, msum, 3, ssum});
          temp.push_back({i, j, msum, 5, ssum});
          temp.push_back({i, j, msum, 7, ssum});
        }
      }
    }  
  }
  fireballs = temp; // 새로운 파이어볼 정보 저장
}

int main()
{
  scanf("%d %d %d", &N, &M, &K);

  for(int i = 0; i < M; i++)
  {
    scanf("%d %d %d %d %d", &r, &c, &m, &s, &d); // 설명의 r, c, m, d, s 아님!
    fireballs.push_back({r, c, m, d, s}); // 파이어볼 정보 저장
  }

  // K번 이동
  for(int j = 0; j < K; j++)
  {
    move();
    // 움직이고 나누고 반복 - 다 움직이고 난 다음에 split 하는 것 아님.
    split();
  }

  // 마지막 남아있는 파이어볼 질량의 합
  for(int i = 0; i < fireballs.size(); i++) 
  {
    ans += fireballs[i].m;
  }

  printf("%d", ans);

  return 0;
}
