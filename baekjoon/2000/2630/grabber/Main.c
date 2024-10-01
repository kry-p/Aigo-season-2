#include <stdio.h>

// 백준 2630번
// 색종이 만들기 
// 종이의 한 변의 길이가 항상 2*k 이므로 
// 핵심은 n * n  이차원 배열안의 원소 동일여부 _ 0,1

int arr[128+1][128+1];
int num;
int zero,one;

// size: 정사각형 한변길이 // 시작 x, y
void check(int size, int startX, int startY)
{
    int target = arr[startX][startY];

    for (int x = startX; x < startX + size; x++)
    {
        for (int y = startY; y < startY + size; y++)
        {
            if(arr[x][y] != target)  //다른 색
            {
                check(size/2, startX, startY);  // left top
                check(size/2, startX + size/2, startY); // left botton
                check(size/2, startX, startY+ size/2);  // right top
                check(size/2, startX+ size/2, startY+ size/2); // right bottom
                return;
            }
        }
    }

    if(target == 0) zero++;
    else one++;
}


int main()
{
    scanf("%d", &num);
    for (int i = 0; i < num; i++)
    {
        for (int j = 0; j < num; j++)
        {
            scanf("%d",&arr[i][j]);
        }
    }

    check(num,0,0);

    printf("%d %d",zero ,one);
    return 0;
}