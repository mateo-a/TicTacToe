public class TicTacToe {
	static String[] board;
	static int turn;

	public static void main(String[] args){
		board = new String[9];
		turn = 1;
		EmptyBoard();
		ShowArray();
		IsWinner();

	}
	static int IsWinner() {
		String op1 = board[0] + board[1] + board[2];
		String op2 = board[3] + board[4] + board[5];
		String op3 = board[6] + board[7] + board[8];
		String op4 = board[0] + board[3] + board[6];
		String op5 = board[1] + board[4] + board[7];
		String op6 = board[2] + board[5] + board[8];
		String op7 = board[0] + board[4] + board[8];
		String op8 = board[2] + board[4] + board[6];
		String[] winner = {op1, op2, op3, op4, op5, op6, op7, op8};
		for (int a = 0; a < 8; a++) {
			if (winner[a] == "111") {
				return 1;
			}
			else if (winner[a] == "222") {
				return 2;
			}
		}
		return 4;
	}
	static void ShowArray(){
        int i = 0;
        while(i < 9){
        System.out.println(board[i]);
        i++;
        }
    }
	static void EmptyBoard() {
		for (int a = 0; a < 9; a++) {
			board[a] = String.valueOf(0);
		}
	}
}
