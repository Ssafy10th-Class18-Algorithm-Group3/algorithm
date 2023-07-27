#include <iostream>
#include <vector>
#include <algorithm>
#include<queue>
using namespace std;

int main() {
	int N;
	cin >> N;
	vector < pair<int, int >> first;
	deque < pair<int, int>> save;
	for (int i = 0; i < N; i++) {
		int num;
		cin >> num;
		save.push_back(make_pair(i + 1, num));
	}
	vector <int >ans;
	while (1) {
		int cur_idx = save.front().first;
		int cur_val = save.front().second;
		save.pop_front();
		ans.push_back(cur_idx);
		if (save.empty()) {
			break;
		}
		if (ans.size() == N) {
			break;
		}
		if (cur_val > 0) {
			cur_val--;
			while (1) {
				if (cur_val == 0) {
					break;
				}
				pair<int, int> tmp = save.front();
				save.pop_front();
				save.push_back(tmp);
				cur_val--;
			}
		}
		else {
			cur_val =-1*cur_val;
			while (1) {
				if (cur_val == 0) {
					break;
				}
				pair<int, int> tmp = save.back();
				save.pop_back();
				save.push_front(tmp);
				cur_val--;
			}
		}
	}
	for (auto iter : ans) {
		cout << iter << " ";
	}

}