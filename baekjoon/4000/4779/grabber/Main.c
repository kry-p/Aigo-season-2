// 칸토어 집합
// 0과 1사이의 실수로 이루어진 집합
// 각 구간을 3등분 하여 가운데 구간을 반복적으로 제외하는 방식
// #define _CRT_SECURE_NO_WARNINGS
//#pragma warning(disable: 4996)

#include <stdio.h>
#include <math.h>

void cantor(int n)
{
	int size = pow(3, n - 1);

	if (n == 0)
	{
		printf("-");
		return;
	}

	cantor(n - 1);
	for (int i = 0; i < size; i++)
	{
		printf(" ");
	}
	cantor(n - 1);
}

int main(void)
{
	int n;
    
	while (scanf("%d", &n) != EOF)
	{
		cantor(n);
		printf("\n");
	}

	return 0;
}