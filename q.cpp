#include <iostream>
#include <string>
#include <vector>

using namespace std;

void solve() {
    string s;
    cin >> s;

    int count[2] = {0, 0};
    for (char c : s) {
        count[c - '0']++;
    }
    
    for (int i = 0; i < s.length(); ++i) {

        int required_char = 1 - (s[i] - '0'); 
        
        if (count[required_char] > 0) {
            count[required_char]--;
        } else {

            cout << s.length() - i << "\n";
            return;
        }
    }

    cout << 0 << "\n";
}

int main() {

    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    int t;
    cin >> t;
    while (t--) {
        solve();
    }
    
    return 0;
}