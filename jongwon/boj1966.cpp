#include <iostream>
#include <deque>
#include <algorithm>
using namespace std;



int main() {
	int N, tc, M;
	cin >> tc;
	for (int i = 0; i < tc; i++) {
		cin >> N >> M; // 문서의 갯수 N 현재 큐에서의 위치 M 0부터 시작
		int cur;
		deque <int> imp;
		int target;
		for (int j = 0; j < N; j++) {
			cin >> cur;
			imp.push_back(cur);
		}
		int ans = 0;
		int cur_num;
		while (1) {
			cur_num = imp.front();
			if (cur_num == *max_element(imp.begin(), imp.end())) {
				imp.pop_front();
				ans++;
				if (M == 0) {
					break;
				}
				M--;
			}
			else {
				imp.pop_front();
				imp.push_back(cur_num);
				M--;
				if (M < 0) {
					M = imp.size() - 1;
				}
			}


		}
		cout << ans << "\n";

	}


}