package kakaoblock1;

public class Solution {

	public int solution(int m, int n, String[] board) {
		int count = 0;

		String tmp = "";
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				tmp += board[j].charAt(i);
			}

		}



		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
