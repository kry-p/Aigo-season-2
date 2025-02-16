#include <iostream>
#include <vector>
#include <algorithm>
#include <string>

using namespace std;

int main(){
    
    string s;
    int m,n;
    getline(cin, s);

    if (s.substr(0,2) == "PA" || s.substr(s.length()-2) == "PP"){
        cout << "NP" << "\n";
        return 0;
    }

    while( s.length() > 4){ // 4글자 이하가 될때까지 PPAP 소거하는 반복문
        size_t posV = s.find("PPAP"); // 오름차순 기준 첫 PPAP 문자의 판별

        if (posV == string::npos){ // 발견 못했을 시, npos 반환
            cout << "NP" << "\n";
            return 0;
        }
        s.replace(posV, 4, "P"); // 발견했을 경우, PPAP --> P로 치환
    }
    if (s == "PPAP"){ // 4글자 이하의 문자열이 PPAP 인 경우
        cout << "PPAP" << "\n";
    }
    else {
        cout << "NP" << "\n";
    }

    return 0;
}