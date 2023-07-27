#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;
// priority queue 으로 구현해보기

int main() {
	int N, tc, M;

	cin >> tc;
	for (int i = 0; i < tc; i++) {
		cin >> N >> M; // 문서의 갯수 N 현재 큐에서의 위치 M 0부터 시작
		int cur;
		priority_queue <int> imp;
		deque <pair<int,int>> info;
		for (int j = 0; j < N; j++) {
			cin >> cur;
			info.push_back(make_pair(j, cur));
			imp.push(cur);
		}
		int ans = 0;
		while (1) {
			int cur_idx = info.front().first;
			int cur_val = info.front().second;
			if (cur_val == imp.top()) {
				imp.pop();
				ans++;
				if (cur_idx == M) {
					break;

				}
			}

			info.pop_front();
			info.push_back(make_pair(cur_idx, cur_val));
		
		}
		cout << ans << "\n";

	}


}