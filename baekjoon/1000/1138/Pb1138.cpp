#include <iostream>
#include <algorithm>
#include <stack>

using namespace std;
int arr[10] = { 0 };
stack<int> dq;
stack<int> dq_temp;

int main() {
	int N;
	cin >> N;
	for (int i = 0; i < N; i++) {
		cin >> arr[i];
	}
	int i = 0;
	int a = 0;
	for (i = N; i >0; i--) { // 각 사람에 대해
		//넣으려는 사람의 키보다 적은 사람이 앞에 있을경우 앞에서 빼기
		int priority = arr[i - 1];
		for (int j = 0; j < priority; j++) { // 정해진 횟수만큼 앞에서 빼기
			int temp = dq.top();
			dq_temp.push(temp);
			dq.pop();
		}

		dq.push(i); // 키 i인 사람 줄 세우기

		for (int j = 0; j < priority; j++) { // 앞에 다시 넣기
			int temp = dq_temp.top();
			dq.push(temp);
			dq_temp.pop();
		}
	}
	
	for (int i = 0; i < N; i++) {
		cout << dq.top() << " ";
		dq.pop();
	}
	return 0;
}



// 1번이 서는 자리 n --> 키가 큰 사람이 앞에 n-1명
// 2번이 서는 자리 o --> 1번이 2번 뒤면(n >o+1) o-1명, 2번 앞이면 o-1명
// 3번 ''         p --> 1번 2번이 (n > o+1 >p+2)