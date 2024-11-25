#include <iostream>
#include <queue>
#include <algorithm>

using namespace std;
int arr[100000][3];
priority_queue<int> A, B, C;


int main() {
	int a, b, c,n;
	cin >> a >> n;
	for (int i = 0; i < a; i++) { // 역량 각각 저장
		cin >> arr[i][0] >> arr[i][1] >> arr[i][2];
	}
	for (int i = 0; i < a; i++) { // 각 과목의 두가지 역량 합 우선순위 큐에 삽입
		A.push(arr[i][0] + arr[i][1]);
		B.push(arr[i][1] + arr[i][2]);
		C.push(arr[i][2] + arr[i][0]);
	}
	a = 0; b = 0; c = 0;
	for (int i = 0; i < n; i++) { //K개 강의 수강시의 최댓값 계산
		a += A.top();
		b += B.top();
		c += C.top();
		A.pop(); B.pop(); C.pop();
	}

	cout << max({ a,b,c });
	return 0;
}