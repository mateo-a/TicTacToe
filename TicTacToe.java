public class TicTacToe {
	static String[] board;
	static int turn;
	static int result = 4;
	static int n_turn = 0;
	static String[] jugada = {"2", "2", "2", "1", "2", "2", "2", "1", "2"};


	public static void main(String[] args){
		board = new String[9];
		EmptyBoard();
		turn = 1;
		while (result == 4) {
			board = jugada;
			n_turn ++;
			if (n_turn <= 8) {
				result = IsWinner();
				turn = TurnSwitch();
				System.out.println("---|---|---");
				ShowArray();
				if (result == 1) {
					System.out.println("Gano X");
					break;	
				}
				else if (result == 2) {
					System.out.println("Gano O");
					break;
				}
			}
			else {
				result = 3;
			}
		}
		if (result == 3) {
			System.out.println("empate");
		}
	}
	static int TurnSwitch() {
		if (turn == 1) {
			turn = 2;
		}
		else {
			turn = 1;
		}
		return turn;
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
			if (winner[a].equals("111")) {
				return 1;
			}
			else if (winner[a].equals("222")) {
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
