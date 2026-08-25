#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, m, k;
    if (!(cin >> n >> m >> k)) return 0;

    vector<int> b(n);
    for (int i = 0; i < n; ++i) {
        cin >> b[i];
    }

    // If we can use n or more pieces, just cover each segment individually
    if (k >= n) {
        cout << n << "\n";
        return 0;
    }

    vector<int> diffs(n - 1);
    for (int i = 0; i < n - 1; ++i) {
        diffs[i] = b[i+1] - b[i];
    }

    // Sort the gaps in ascending order
    sort(diffs.begin(), diffs.end());

    // Add the smallest (n - k) gaps to ans + k
    long long ans = k;
    for (int i = 0; i < n - k; ++i) {
        ans += diffs[i];
    }

    cout << ans << "\n";
    return 0;
}