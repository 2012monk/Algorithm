#include <iostream>
#include <queue>

using namespace std;

int ans, n;
int dx[] = {1, -1, 0, 0};
int dy[] = {0, 0, 1, -1};
int board[401];
int v[401];

int is_invalid(int x, int dx, int dy) {
    dx += x / n;
    dy += x % n;
    return dx < 0 || dx >= n || dy < 0 || dy >= n;
}

int is_prior(int x, int next) {
    if (next == -1)
        return 1;
    if (v[x] == v[next])
        return x < next;
    return v[x] < v[next];
}

void clear_v(void) {
    for (int i=0;i<n*n;i++) v[i] = 0;
}

int travel_next(int s, int size) {
    queue<int> q;
    int next = -1;
    q.push(s);
    clear_v();
    v[s] = 1;

    while (!q.empty()) {
        int x = q.front();
        q.pop();
        for (int i=0;i<4;i++) {
            int nx = x + dx[i] * n + dy[i];
            if (is_invalid(x, dx[i], dy[i]))
                continue;
            if (board[nx] > size || v[nx])
                continue;
            v[nx] = v[x] + 1;
            q.push(nx);
            if (board[nx] && board[nx] < size && is_prior(nx, next))
                next = nx;
        }
    }
    if (next != -1)
        ans += v[next] - 1;
    return next;
}

void eat(int s) {
    int size = 2, st = 0, next;

    while ((next = travel_next(s, size)) != -1) {
        board[s = next] = 0;
        if (++st == size) {
            ++size;
            st = 0;
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int s;
    cin >> n;
    for (int i=0;i<n * n;i++) {
        cin >> board[i];
        if (board[i] == 9)
            s = i;
    }

    board[s] = 0;
    eat(s);
    cout << ans << '\n';
    return 0;
}
