// 스위치 켜고 끄기
// 백준 1244
// on = 1, off = 0;  // 스위치 개수 <= 100 양의정수
// 변경 : 1 <-> 0 
// 남 _1 : 배수의 스위치 변경
/* 여 _2 : 숫자 중심으로 좌우 대칭이면서 가장 많은 
 스위치를 포함하는 구간 찾아 상태 변경  */
// 1) 스위치 변경 구간생각 (그 위치상태 변경)
// 2) 숫자 양쪽확인
#include <iostream>
using namespace std;

bool arr_Switch[101];

int main()
{
    int iSwitch_Num;
    cin >> iSwitch_Num;

    // 스위치 입력
    // ++i 한 이유
    for (int i = 1; i <= iSwitch_Num; ++i)
    {
       cin >> arr_Switch[i];    
    }

    // 학생 수 입력
    int Student_CheckNum;
    cin >> Student_CheckNum;

     // 스위치 변경
     for (int j = 1; j <= Student_CheckNum; j++)
     {
        // 성별, 스위치 위치
        int iGender , iPosition;
        cin >> iGender >> iPosition;
        
        // Man (배수의 스위치 변경)
        if(iGender == 1) 
        {
            // 배수의 스위치 변경  // k = k + position
            for (int k = iPosition; k <= iSwitch_Num; k+=iPosition)
            {
                arr_Switch[k] = !arr_Switch[k];
            }
        }

        // Girl
        // 1) 스위치 변경 구간생각 (그 위치상태 변경)
        // 2) 숫자 양쪽확인
        else if (iGender == 2)
        {
            // 대칭적으로 변경하기 위해 범위를 확장해 나가는 방식으로 동작
            // 대칭인 구간을 찾아 그 범위 내에서 스위치를 변경
            int start = iPosition, end = iPosition;

            while (start >=1 && end <= iSwitch_Num)
            {
                start--; end++; // 양쪽이동
                if (arr_Switch[start] != arr_Switch[end])
                {   
                    break;
                }
            }

            // 조건 이유? 전위 증가: ++i // 증가된 값으로 처리됨
            for (int k = start+1; k <= end-1; ++k)
            {
                arr_Switch[k] = !arr_Switch[k];
            }
        }
     }

    //기존 값을 사용한 후 증가됨
    for (int i = 1; i <= iSwitch_Num; i++)
    {
        cout << arr_Switch[i] << " ";
        
        if(i%20 == 0)// 20 배수일때 줄바꿈
            cout << "\n";
    }

}
