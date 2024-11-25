#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>

using namespace std;
priority_queue<int, vector<int>> jewel_t;
vector<pair<int, int>> jewels;
vector<int> bag;
int N, K;
int a, b;

int main() {
	ios::sync_with_stdio(NULL);
	cin.tie(0);
	cout.tie(0);

	cin >> N >> K;

	for (int i = 0; i < N; i++) {
		cin >> a >> b;
		jewels.push_back({ a,b }); // ����, ��ġ ������ ��� ����� ����
	}
	sort(jewels.begin(), jewels.end(), less<pair<int,int>>()); // ���� ����, ���� ���� ��������
	for (int i = 0; i < K; i++) {
		cin >> a;
		bag.push_back(a);
	}
	sort(bag.begin(), bag.end(), less<int>()); // ���� ����, �뷮 ���� ��������
	pair <int, int>temp;

	long long result = 0;
	b = 0; // Ŀ���μ� �ʱ�ȭ (��Ȱ��)
	for (int i = 0; i < K; i++) {
		for (int j = b; j < N; j++) { // ù��° �ݺ������� �賶�� �� �� �ִ� ������ �������� �̵�
			if (bag[i] >= jewels[j].first) {
				jewel_t.push(jewels[j].second);// ���濡 ���� �� �ִ� �����̶�� �ִ´�.
			}
			else if (bag[i] < jewels[j].first) {
				b = j;
				break;
			}

			if (j == N - 1) {
				b = N;
			}
		}
		if (!jewel_t.empty()) {
			result += (long long)jewel_t.top(); // �ִ� ��ġ�� ������ ������� ����
			jewel_t.pop();
		}
	}

	cout << result;

	return 0;
}









//int (*bag_P)[2] = bag; //�迭 ������ ����
//int temp_K, divide_N = 10; // Ž�� ���ݰ�  Ž������ �������� ����
//int section_P; // Ž�� ���� ����
//
//while (!jewel_t.empty()) { // ������ ť�� �������� ���� ���Կ� ���ϸ鼭 ���濡 �������
//	section_P = 0;// Ž�� ���� �ʱ�ȭ
//	temp = jewel_t.top(); //ť���� ���� ���������� ������
//	cout << temp.first << " " << temp.second << "\n";
//	jewel_t.pop();
//	temp_K = K; // ������ Ž���� ������ ���� ���� --> �ݺ��ؾ��ϴ� ���� ���� ��ü �������� ��� N��� �Ͽ� �ʱⰪ�� ��
//
//	// temp_K�� ���� ���� �� 20 --> 2�� ��ȭ
//	while (temp_K > divide_N) { // �κ�Ž�� �� ���� --> ���� ���� ��ǥ ���� �̻��̸� Ż��
//		for (int j = 0; j < divide_N; j++) { // ������ ���� Ž�� --> Ż�� ���� : ���� ������ 10�̸�
//			cout << **bag_P << "\n";
//			if (j != 0 && *(*(bag_P + section_P)) > temp.second) { // ���� ���԰� ���� �뷮���� �����鼭 ���������� �ƴϸ� 
//				//bag_P = ������, section_P = ������
//				temp_K = temp_K / divide_N;
//				//temp_K = ������ +�����ڸ� Ž�� �������� ��� temp_K ������ŭ�� ������ Ž��
//				break;
//			}
//			else if (j == 0 && *(*(bag_P + section_P)) >= temp.second) { //Ž�� ó�� ������ ���Ժ��� ���� ���԰� �۴ٸ� ��� �ݺ��� Ż��
//				temp_K = 1;
//				break;
//			}
//			else if ((j == divide_N - 1) && (*(*(bag_P + section_P)) < temp.second)) { //������ Ž������ ������ ���԰� ���غ��� ���ſ�� �������� ����������
//				temp_K = temp_K / divide_N + temp_K % divide_N;
//			}
//			section_P += temp_K / divide_N; // ������ �������� ����
//
//		}
//	}
//	//���� ��ġ �񱳴� �ʿ䰡 ����
//	//1�� = �뷮 2�� = ��� ������ ��ġ
//	cout << "�۵���" << temp_K << " " << section_P << "\n";
//	while (section_P != K) { // ������ �κ�Ž�� ���� ������ Ž�� 
//		if (*(*(bag_P + section_P)) > temp.second && *(*(bag_P + section_P) + 1) == 0) { // [�񱳱���] ������ ����ְ�(������ ��ġ�� ���� �پ��� ������ ������ġ�񱳴� �ǹ̾���), �뷮�� ���Ժ��� ũ��
//			cout << section_P << "\n";
//			*(*(bag_P + section_P) + 1) = temp.first; // ���濡 ������ ��ġ ����. bag[i][1]
//		}
//		section_P += 1;
//	}
//}
