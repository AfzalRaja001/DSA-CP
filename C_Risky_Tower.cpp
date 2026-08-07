#include <iostream>
#include <vector>
#include <queue>

using namespace std;

void solve() {
    int n, m;
    cin >> n >> m;

    vector<long long> v(n);
    for (int i = 0; i < n; i++) {
        cin >> v[i];
    }

    vector<vector<long long>> a(n, vector<long long>(m));
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> a[i][j];
        }
    }

    // Condition 2: The maximum operations we'd ever need is m (clearing a single row)
    int min_ops = m; 
    priority_queue<long long> pq;

    // Bottom-Up Traversal
    for (int i = n - 1; i >= 0; i--) {
        
        // Add all elements of the current row to our available pool
        for (int j = 0; j < m; j++) {
            pq.push(a[i][j]);
        }

        long long current_sum = 0;
        int ops = 0;
        vector<long long> temp; // To hold elements temporarily

        // Greedily take the largest available elements to destabilize row i
        while (!pq.empty() && current_sum < v[i]) {
            long long val = pq.top();
            pq.pop();
            
            current_sum += val;
            ops++;
            temp.push_back(val);

            // Optimization: Stop if we already equal/exceed the best known answer
            if (ops >= min_ops) {
                break;
            }
        }

        // If we successfully met Condition 1 for this row, update the answer
        if (current_sum >= v[i]) {
            min_ops = min(min_ops, ops);
        }

        // Restore the popped elements back into the priority queue for the next rows
        for (long long val : temp) {
            pq.push(val);
        }
    }

    cout << min_ops << "\n";
}

int main() {
    // Fast I/O for performance
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    int t;
    cin >> t;
    while (t--) {
        solve();
    }
    
    return 0;
}