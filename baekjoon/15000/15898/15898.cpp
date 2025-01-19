#include <iostream>
#include <vector>


using namespace std;

int dx[] = {0, 1, 0, 1};
int dy[] = {0, 0, 1, 1};

int n;

//회전
template <typename T>
vector<vector<T>> rotate(vector<vector<T>> &array)
{
    vector<vector<T>> rotated(4, vector<T>(4));

    for(int i = 0; i < 4; i++)
    {
        for(int j = 0; j < 4; j++)
        {
            rotated[i][j] = array[4-1-j][i];    
        }
    }
    return rotated;
}

// 점수 결정
vector<vector<int>> put_in_score(vector<vector<int>> &board, vector<vector<int>> &input, int start_x, int start_y)
{
    vector<vector<int>> result = board;

    for(int i = 0; i < 4 ; i++)
    {
        for(int j = 0; j < 4 ; j++)
        {
            result[start_x + i][start_y + j] += input[i][j];

            if(result[start_x + i][start_y + j] > 9)
            {
                result[start_x + i][start_y + j] = 9;
            }
            if(result[start_x + i][start_y + j] < 0)
            {
                result[start_x + i][start_y + j] = 0;
            }
        }    
    }
    return result;
}

// 원소 색깔 결정 
vector<vector<char>> put_in_element(vector<vector<char>> &board, vector<vector<char>> &input, int start_x, int start_y)
{
    vector<vector<char>> result = board;

    for(int i = 0; i < 4 ; i++)
    {
        for(int j = 0; j < 4 ; j++)
        {
            if (input[i][j] != 'W') 
            {
                result[start_x + i][start_y + j] = input[i][j];
            }
        }    
    }
    return result;
}

// 결과 출력 
int calculate(vector<vector<int>> &gama_score, vector<vector<char>> &gama_element)
{
    int sumR = 0;
    int sumB = 0;
    int sumG = 0;
    int sumY = 0;
    
     for (int i = 0; i < 5; i++)
    {
        for (int j = 0; j < 5; j++)
        {
            if(gama_element[i][j] == 'R')
            {
                sumR += gama_score[i][j];
            }
            if(gama_element[i][j] == 'B')
            {
                sumB += gama_score[i][j];
            }
            if(gama_element[i][j] == 'G')
            {
                sumG += gama_score[i][j];
            }
            if(gama_element[i][j] == 'Y')
            {
                sumY += gama_score[i][j];
            }
        }
    }
    return sumR * 7 + sumB * 5 + sumG * 3 + sumY * 2;
}

int main()
{

    cin >> n;

    vector<vector<vector<int>>> score(n, vector<vector<int>>(4, vector<int>(4)));
    vector<vector<vector<char>>> element(n, vector<vector<char>>(4, vector<char>(4)));
 
    for(int i = 0; i < n; i++)
    {
        for(int j = 0; j < 4; j++)
        {
            for(int k = 0; k < 4; k++)
            {
                cin >> score[i][j][k];
            }   
        }

        for (int r = 0; r < 4; r++) 
        {
            for (int c = 0; c < 4; c++) 
            {
            char ch;
            cin >> ch;
            element[i][r][c] = ch;
        }
        }
    }

    int ans = 0;

    vector<vector <int>> gama_score(5, vector<int>(5, 0));
    vector<vector <char>> gama_element(5, vector<char>(5, 'W'));
    
    // n개의 재료 중 3개 뽑기
    for (int a = 0; a < n; a++)
    {
        for (int b = 0; b < n; b++)
        {
            if(b == a) continue;

            for (int c = 0; c < n; c++)
            {
                if(c == a || c == b) continue;

                vector<vector<vector<int>>> rotScoreA(4);
                vector<vector<vector<char>>> rotElemA(4);
                rotScoreA[0] = score[a];
                rotElemA[0] = element[a];
                
                for (int r = 1; r < 4; r++)
                {
                    rotScoreA[r] = rotate(rotScoreA[r-1]);
                    rotElemA[r] = rotate(rotElemA[r-1]);
                }
                
                vector<vector<vector<int>>> rotScoreB(4);
                vector<vector<vector<char>>> rotElemB(4);
                rotScoreB[0] = score[b];
                rotElemB[0] = element[b];

                for (int r = 1; r < 4; r++)
                {
                    rotScoreB[r] = rotate(rotScoreB[r-1]);
                    rotElemB[r] = rotate(rotElemB[r-1]);
                }
                
                vector<vector<vector<int>>> rotScoreC(4);
                vector<vector<vector<char>>> rotElemC(4);
                rotScoreC[0] = score[c];
                rotElemC[0] = element[c];
                
                for (int r = 1; r < 4; r++)
                {
                    rotScoreC[r] = rotate(rotScoreC[r-1]);
                    rotElemC[r] = rotate(rotElemC[r-1]);
                }
                // 여기까지 회전에 대한 정보 미리 저장해 둠

                for (int ra = 0; ra < 4; ra++)
                {
                    for (int posA = 0; posA < 4; posA++)
                    {
                        int ax = dx[posA], ay = dy[posA];
                        vector<vector<int>> boardScoreA = put_in_score(gama_score, rotScoreA[ra], ax, ay);
                        vector<vector<char>> boardElemA = put_in_element(gama_element, rotElemA[ra], ax, ay);

                        for (int rb = 0; rb < 4; rb++)
                        {
                            for (int posB = 0; posB < 4; posB++)
                            {
                                int bx = dx[posB], by = dy[posB];
                                vector<vector<int>> boardScoreB = put_in_score(boardScoreA, rotScoreB[rb], bx, by);
                                vector<vector<char>> boardElemB = put_in_element(boardElemA, rotElemB[rb], bx, by);
                                
                                for (int rc = 0; rc < 4; rc++)
                                {
                                    for (int posC = 0; posC < 4; posC++)
                                    {
                                        int cx = dx[posC], cy = dy[posC];
                                    
                                        vector<vector<int>> boardScoreC = put_in_score(boardScoreB, rotScoreC[rc], cx, cy);
                                        vector<vector<char>> boardElemC = put_in_element(boardElemB, rotElemC[rc], cx, cy);
                                        
                                        int quality = calculate(boardScoreC, boardElemC);
                                        ans = max(ans, quality);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }


    cout << ans << "\n";
    return 0;
}
