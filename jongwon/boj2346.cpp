#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	int N;
	cin >> N;
	int *info = new int[N];
	bool *check = new bool[N];
	for (int i = 0; i < N; i++) {
		cin >> info[i];
	}
	fill(check, check + N, false);
	vector <int >ans;
	int idx = 0;
	int target;
	while (1) {
		target = info[idx];
		ans.push_back(idx + 1);
		check[idx] = true;
		if (ans.size() == N) {
			break;
		}
		if (target > 0) {
			int cur = 0;
			while (1) {
				idx++;
				if (idx >= N) {
					idx = idx - N;
				}
				if (!check[idx]) {
					cur++;
				}
				if (cur == target) {
					break;
				}
			}
		}
		else {
			int cur = 0;
			while (1) {
				idx--;
				if (idx < 0) {
					idx = N + idx;
				}
				if (!check[idx]) {
					cur--;
				}
				if (cur == target) {
					break;
				}
			}
		}
	}
	for (auto iter : ans) {
		cout << iter << " ";
	}

}