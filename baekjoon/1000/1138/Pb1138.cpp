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
	for (i = N; i >0; i--) { // �� ����� ����
		//�������� ����� Ű���� ���� ����� �տ� ������� �տ��� ����
		int priority = arr[i - 1];
		for (int j = 0; j < priority; j++) { // ������ Ƚ����ŭ �տ��� ����
			int temp = dq.top();
			dq_temp.push(temp);
			dq.pop();
		}

		dq.push(i); // Ű i�� ��� �� �����

		for (int j = 0; j < priority; j++) { // �տ� �ٽ� �ֱ�
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



// 1���� ���� �ڸ� n --> Ű�� ū ����� �տ� n-1��
// 2���� ���� �ڸ� o --> 1���� 2�� �ڸ�(n >o+1) o-1��, 2�� ���̸� o-1��
// 3�� ''         p --> 1�� 2���� (n > o+1 >p+2)