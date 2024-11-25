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
		jewels.push_back({ a,b }); // 무게, 가치 순으로 페어 만들어 저장
	}
	sort(jewels.begin(), jewels.end(), less<pair<int,int>>()); // 보석 정렬, 무게 기준 오름차순
	for (int i = 0; i < K; i++) {
		cin >> a;
		bag.push_back(a);
	}
	sort(bag.begin(), bag.end(), less<int>()); // 가방 정렬, 용량 기준 오름차순
	pair <int, int>temp;

	long long result = 0;
	b = 0; // 커서로서 초기화 (재활용)
	for (int i = 0; i < K; i++) {
		for (int j = b; j < N; j++) { // 첫번째 반복문에서 배낭에 들어갈 수 있는 무게의 보석까지 이동
			if (bag[i] >= jewels[j].first) {
				jewel_t.push(jewels[j].second);// 가방에 넣을 수 있는 보석이라면 넣는다.
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
			result += (long long)jewel_t.top(); // 최대 가치의 보석을 결과값에 더함
			jewel_t.pop();
		}
	}

	cout << result;

	return 0;
}









//int (*bag_P)[2] = bag; //배열 포인터 설정
//int temp_K, divide_N = 10; // 탐색 간격과  탐색시점 지정변수 설정
//int section_P; // 탐색 시점 변수
//
//while (!jewel_t.empty()) { // 보석함 큐가 빌때까지 가방 무게와 비교하면서 가방에 보석담기
//	section_P = 0;// 탐색 시점 초기화
//	temp = jewel_t.top(); //큐에서 보석 순차적으로 꺼내기
//	cout << temp.first << " " << temp.second << "\n";
//	jewel_t.pop();
//	temp_K = K; // 포인터 탐색값 지정을 위한 변수 --> 반복해야하는 가방 수를 전체 구간으로 잡고 N등분 하여 초기값만 비교
//
//	// temp_K가 루프 끝날 시 20 --> 2로 변화
//	while (temp_K > divide_N) { // 부분탐색 수 설정 --> 구분 수가 목표 범위 이상이면 탈출
//		for (int j = 0; j < divide_N; j++) { // 포인터 구간 탐색 --> 탈출 조건 : 구간 범위가 10미만
//			cout << **bag_P << "\n";
//			if (j != 0 && *(*(bag_P + section_P)) > temp.second) { // 보석 무게가 가방 용량보다 작으면서 시작지점이 아니면 
//				//bag_P = 포인터, section_P = 지시자
//				temp_K = temp_K / divide_N;
//				//temp_K = 포인터 +지시자를 탐색 기점으로 잡고 temp_K 갯수만큼의 가방을 탐색
//				break;
//			}
//			else if (j == 0 && *(*(bag_P + section_P)) >= temp.second) { //탐색 처음 가방의 무게보다 보석 무게가 작다면 즉시 반복문 탈출
//				temp_K = 1;
//				break;
//			}
//			else if ((j == divide_N - 1) && (*(*(bag_P + section_P)) < temp.second)) { //마지막 탐색에서 보석의 무게가 기준보다 무거우면 나눗셈의 나머지구간
//				temp_K = temp_K / divide_N + temp_K % divide_N;
//			}
//			section_P += temp_K / divide_N; // 포인터 시작지점 갱신
//
//		}
//	}
//	//보석 가치 비교는 필요가 없음
//	//1열 = 용량 2열 = 담긴 보석의 가치
//	cout << "작동중" << temp_K << " " << section_P << "\n";
//	while (section_P != K) { // 설정한 부분탐색 범위 내에서 탐색 
//		if (*(*(bag_P + section_P)) > temp.second && *(*(bag_P + section_P) + 1) == 0) { // [비교구문] 가방이 비어있고(보석의 가치는 점차 줄어들기 때문에 보석가치비교는 의미없음), 용량이 무게보다 크면
//			cout << section_P << "\n";
//			*(*(bag_P + section_P) + 1) = temp.first; // 가방에 보석의 가치 저장. bag[i][1]
//		}
//		section_P += 1;
//	}
//}
