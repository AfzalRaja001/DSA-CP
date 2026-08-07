#include <iostream>
#include <vector>
#include <numeric>
#include <unordered_map>
#include <algorithm>

using namespace std;

void solve() {
    int n;
    cin >> n;
    
    vector<long long> a(n);
    unordered_map<long long, int> freq;
    long long total_sum = 0;
    int max_freq = 0;
    long long max_val = 0;

    for (int i = 0; i < n; ++i) {
        cin >> a[i];
        total_sum += a[i];
        freq[a[i]]++;
        if (freq[a[i]] > max_freq) {
            max_freq = freq[a[i]];
            max_val = a[i];
        }
    }

    int O = n - max_freq; // count of non-majority gap elements

    if (max_freq <= O + 1) {
        cout << total_sum << "\n";
    } else {
        long long non_majority_sum = total_sum - (long long)max_freq * max_val;
        long long max_damage = non_majority_sum + (long long)(O + 2) * max_val;
        cout << max_damage << "\n";
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    int t;
    cin >> t;
    while (t--) {
        int n;
    cin >> n;
    
    vector<long long> a(n);
    unordered_map<long long, int> freq;
    long long total_sum = 0;
    int max_freq = 0;
    long long max_val = 0;

    for (int i = 0; i < n; ++i) {
        cin >> a[i];
        total_sum += a[i];
        freq[a[i]]++;
        if (freq[a[i]] > max_freq) {
            max_freq = freq[a[i]];
            max_val = a[i];
        }
    }

    int O = n - max_freq; // count of non-majority gap elements

    if (max_freq <= O + 1) {
        cout << total_sum << "\n";
    } else {
        long long non_majority_sum = total_sum - (long long)max_freq * max_val;
        long long max_damage = non_majority_sum + (long long)(O + 2) * max_val;
        cout << max_damage << "\n";
    }
    }
    return 0;
}