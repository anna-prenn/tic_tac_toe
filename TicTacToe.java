import java.util.*;
import java.lang.*;

public class TicTacToe {

	private static int mode;
	private static char[] board = new char[9];	
	private static boolean win1;
	private static boolean win2;
	private static boolean win3;
	private static boolean win4;
	private static boolean win5;
	private static boolean win6;
	private static boolean win7;
	private static boolean win8;
	private static boolean win;

	private static boolean tooManyMistakes = false;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter 1 for 2 players, 2 for playing against the CPU or 0 to quit. ");
		mode = input.nextInt();
		if (mode == 1) {
			Mode1();
		}
		if (mode == 2) {
			Mode2();
		}
	}
		
	public static void Mode1() {
		for (int i = 0; i <= 8; i++) {
			board[i] = (char)((i + 1) + '0');
		}

		win1 = (board[0] == board[1]) && (board[1] == board[2]);
		win2 = (board[3] == board[4]) && (board[4] == board[5]);
		win3 = (board[6] == board[7]) && (board[7] == board[8]);
		win4 = (board[0] == board[3]) && (board[3] == board[6]);
		win5 = (board[1] == board[4]) && (board[4] == board[7]);
		win6 = (board[2] == board[5]) && (board[5] == board[8]);
		win7 = (board[0] == board[4]) && (board[4] == board[8]);
		win8 = (board[2] == board[4]) && (board[4] == board[6]);
		win = win1||win2||win3||win4||win5||win6||win7||win8;
		Scanner input = new Scanner(System.in);
		int num_mistakes_pl1 = 0;
		int num_mistakes_pl2 = 0;
		int consec_mistakes_pl1 = 0;
		int consec_mistakes_pl2 = 0;
		int player_turn = 0;
		char player1_choice;
		char player2_choice;
		System.out.println("  " + board[0] + "  |  " + board[1] + "  |  " + board[2]);
		System.out.println("-----+-----+-----");
		System.out.println("  " + board[3] + "  |  " + board[4] + "  |  " + board[5]);
		System.out.println("-----+-----+-----");
		System.out.println("  " + board[6] + "  |  " + board[7] + "  |  " + board[8]);

		while (isOver() == false) {
			if (player_turn % 2 == 0) {
				System.out.print("player 1 turn: ");
				player1_choice = input.next().charAt(0);
				while (player1_choice != board[0] && player1_choice != board[1] && player1_choice != board[2] && player1_choice != board[3] && player1_choice != board[4] && player1_choice != board[5] && player1_choice != board[6] && player1_choice != board[7] && player1_choice != board[8]) {
					
					if (num_mistakes_pl1 == 4 || consec_mistakes_pl1 == 2) {
						System.out.println("Player1 forfeit the game due to reaching maximum incorrect entries");
						win = true;
						return;
					}
					
					System.out.print("incorrect entry, please try again: ");
					player1_choice = input.next().charAt(0);
					num_mistakes_pl1 += 1;
					consec_mistakes_pl1 += 1;



				}
				


				board[(int)(player1_choice) - 49] = 'X';
				consec_mistakes_pl1 = 0;
				
				if (isWin()) {
					System.out.println("Game Over! Player 1 Wins.");
					win = true;
				}
				else if (emptySpace() == 'A') {
					System.out.println("Game Over! It is tie.");
					win = true;
				}

			}
			else {
				System.out.print("player 2 turn: ");
				player2_choice = input.next().charAt(0);
				while (player2_choice != board[0] && player2_choice != board[1] && player2_choice != board[2] && player2_choice != board[3] && player2_choice != board[4] && player2_choice != board[5] && player2_choice != board[6] && player2_choice != board[7] && player2_choice != board[8]) {
					
					if (num_mistakes_pl2 == 4 || consec_mistakes_pl2 == 2) {
						System.out.println("Player2 forfeit the game due to reaching maximum incorrect entries");
						win = true;
						return;
					}
					
					System.out.print("incorrect entry, please try again: ");
					player2_choice = input.next().charAt(0);
					num_mistakes_pl2 += 1;
					consec_mistakes_pl2 += 1;

				}

				//System.out.print("The index of board: ");
				System.out.println((int)(player2_choice) - 49);
				board[(int)(player2_choice) - 49] = 'O';
				consec_mistakes_pl2 = 0;

				if (isWin()) {
					System.out.println("Game Over! Player 2 Wins.");
					win = true;
				}
				else if (emptySpace() == 'A') {
					System.out.println("Game Over! It is tie.");
					win = true;
				}

			}

			if (isOver() == false) {
				System.out.println("  " + board[0] + "  |  " + board[1] + "  |  " + board[2]);
				System.out.println("-----+-----+-----");
				System.out.println("  " + board[3] + "  |  " + board[4] + "  |  " + board[5]);
				System.out.println("-----+-----+-----");
				System.out.println("  " + board[6] + "  |  " + board[7] + "  |  " + board[8]);
			

			}
			player_turn++;

		}

		input.close();
	}
	
	

	public static void Mode2() {
		for (int i = 0; i <= 8; i++) {
			board[i] = (char)((i + 1) + '0');
		}	
		win1 = (board[0] == board[1]) && (board[1] == board[2]);
		win2 = (board[3] == board[4]) && (board[4] == board[5]);
		win3 = (board[6] == board[7]) && (board[7] == board[8]);
		win4 = (board[0] == board[3]) && (board[3] == board[6]);
		win5 = (board[1] == board[4]) && (board[4] == board[7]);
		win6 = (board[2] == board[5]) && (board[5] == board[8]);
		win7 = (board[0] == board[4]) && (board[4] == board[8]);
		win8 = (board[2] == board[4]) && (board[4] == board[6]);
		win = win1||win2||win3||win4||win5||win6||win7||win8;
		Scanner input = new Scanner(System.in);
		int num_mistakes_pl1 = 0;
		int num_mistakes_pl2 = 0;
		int consec_mistakes_pl1 = 0;
		int consec_mistakes_pl2 = 0;
		int player_turn = 0;
		char player1_choice;
		char player2_choice;
		System.out.println("  " + board[0] + "  |  " + board[1] + "  |  " + board[2]);
		System.out.println("-----+-----+-----");
		System.out.println("  " + board[3] + "  |  " + board[4] + "  |  " + board[5]);
		System.out.println("-----+-----+-----");
		System.out.println("  " + board[6] + "  |  " + board[7] + "  |  " + board[8]);
		while (isOver() == false) {
			if (player_turn % 2 == 0) {
				System.out.print("player 1 turn: ");
				player1_choice = input.next().charAt(0);
				while (player1_choice != board[0] && player1_choice != board[1] && player1_choice != board[2] && player1_choice != board[3] && player1_choice != board[4] && player1_choice != board[5] && player1_choice != board[6] && player1_choice != board[7] && player1_choice != board[8]) {
					
					if (num_mistakes_pl1 == 4 || consec_mistakes_pl1 == 2) {
						System.out.println("Player1 forfeit the game due to reaching maximum incorrect entries");
						return;
					}
					
					System.out.print("incorrect entry, please try again: ");
					player1_choice = input.next().charAt(0);

					num_mistakes_pl1 += 1;
					consec_mistakes_pl1 += 1;

				}
				
				board[(int)(player1_choice) - 49] = 'X';
				consec_mistakes_pl1 = 0;

				if (isWin()) {
					System.out.println("Game Over! Player 1 Wins.");
					win = true;
				}
				else if (emptySpace() == 'A') {
					System.out.println("Game Over! It is tie.");
					win = true;
				}

			}
			//computer's go
			else {
				if (Character.isDigit(TwoRow())) {
					//to win
					board[(int)(TwoRow()) - 48] = 'O';
					System.out.println("Game Over! CPU wins");
					System.out.println("  " + board[0] + "  |  " + board[1] + "  |  " + board[2]);
					System.out.println("-----+-----+-----");
					System.out.println("  " + board[3] + "  |  " + board[4] + "  |  " + board[5]);
					System.out.println("-----+-----+-----");
					System.out.println("  " + board[6] + "  |  " + board[7] + "  |  " + board[8]);
					win = true;
				} else if (Character.isDigit(theirWin())) {
					//to block if they have 2 in a row
					board[(int)(theirWin()) - 48] = 'O';
				} else if (Character.isDigit(potentialWin())) {
					//test for if you have one down already with 2 slots next to it
					board[(int)(potentialWin()) - 48] = 'O';
				} else if (Character.isDigit(emptyRow())) {
					//test for if there is an empty row
					board[(int)(emptyRow()) - 48] = 'O';
				} else if (Character.isDigit(emptySpace())) {
					//test if there are any empty spaces
					board[(int)(emptySpace()) - 48] = 'O';
				} else {
					//stalemate
					System.out.println("Game Over! It is tie");
					win = true;
				}
				if (isOver() == false) {
					System.out.println("  " + board[0] + "  |  " + board[1] + "  |  " + board[2]);
					System.out.println("-----+-----+-----");
					System.out.println("  " + board[3] + "  |  " + board[4] + "  |  " + board[5]);
					System.out.println("-----+-----+-----");
					System.out.println("  " + board[6] + "  |  " + board[7] + "  |  " + board[8]);
				}
		
			}
			player_turn++;
		}
		input.close();

	}

	public static char TwoRow() {
		char[] row1 = {1,2,3};
		char[] row2 = {4,5,6};
		char[] row3 = {7,8,9};
		char[] col1 = {1,4,7};
		char[] col2 = {2,5,8};
		char[] col3 = {3,6,9};
		char[] diag1 = {1,5,9};
		char[] diag2 = {3,5,7};
		char[][] combos = {row1,row2,row3,col1,col2,col3,diag1,diag2};
		for (int j = 0; j < 8; j++) {
			int y = 0;
			int x = 0;
			for (int i = 0; i < 3; i++) {
				if (board[(int) (combos[j][i] - 1)] == 'O') {
					y++;
				}
				if (Character.isDigit(board[(int) (combos[j][i] - 1)])) {
					x++;
				}
			}
			if ((y == 2) && (x == 1)) {
				for (int i = 0; i < 3; i++) {
					if (Character.isDigit(board[(int) (combos[j][i] - 1)])) {
						char emptySlotIndex = ((char) (combos[j][i] + 47));
						return emptySlotIndex;
					}
				}
			}
		}
		return 'A';
	}

	public static char theirWin() {


		char[] row1 = {1,2,3};
		char[] row2 = {4,5,6};
		char[] row3 = {7,8,9};
		char[] col1 = {1,4,7};
		char[] col2 = {2,5,8};
		char[] col3 = {3,6,9};
		char[] diag1 = {1,5,9};
		char[] diag2 = {3,5,7};
		char[][] combos = {row1,row2,row3,col1,col2,col3,diag1,diag2};
		for (int j = 0; j < 8; j++) {
			int y = 0;
			int x = 0;
			for (int i = 0; i < 3; i++) {
				if (board[(int) (combos[j][i] - 1)] == 'X') {
					y++;
				}
				if (Character.isDigit(board[(int) (combos[j][i] - 1)])) {
					x++;
				}
			}
			if ((y == 2) && (x == 1)) {
				for (int i = 0; i < 3; i++) {
					if (Character.isDigit(board[(int) (combos[j][i] - 1)])) {
						char emptySlotIndex = ((char) (combos[j][i] + 47));
						return emptySlotIndex;
					}
				}
			}
		}
		return 'A';
	}


	public static char potentialWin() {
		char[] row1 = {1,2,3};
		char[] row2 = {4,5,6};
		char[] row3 = {7,8,9};
		char[] col1 = {1,4,7};
		char[] col2 = {2,5,8};
		char[] col3 = {3,6,9};
		char[] diag1 = {1,5,9};
		char[] diag2 = {3,5,7};
		char[][] combos = {row1,row2,row3,col1,col2,col3,diag1,diag2};
		for (int j = 0; j < 8; j++) {
			int y = 0;
			int x = 0;
			for (int i = 0; i < 3; i++) {
				if (board[(int) (combos[j][i] - 1)] == 'O') {
					y++;
				}
				if (Character.isDigit(board[(int) (combos[j][i] - 1)])) {
					x++;
				}
			}
			if ((y == 1) && (x == 2)) {
				for (int i = 0; i < 3; i++) {
					if (Character.isDigit(board[(int) (combos[j][i] - 1)])) {
						char emptySlotIndex = ((char) (combos[j][i] + 47));
						return emptySlotIndex;
					}
				}
			}
		}
		return 'A';
	}



	public static char emptyRow() {
		char[] row1 = {1,2,3};
		char[] row2 = {4,5,6};
		char[] row3 = {7,8,9};
		char[] col1 = {1,4,7};
		char[] col2 = {2,5,8};
		char[] col3 = {3,6,9};
		char[] diag1 = {1,5,9};
		char[] diag2 = {3,5,7};
		char[][] combos = {row1,row2,row3,col1,col2,col3,diag1,diag2};
		for (int j = 0; j < 8; j++) {
			int y = 0;
			int x = 0;
			for (int i = 0; i < 3; i++) {
				if (Character.isDigit(board[(int) (combos[j][i] - 1)])) {
					x++;
				}
			}
			if (x == 3) {
				for (int i = 0; i < 3; i++) {
					if (Character.isDigit(board[(int) (combos[j][i] - 1)])) {
						char emptySlotIndex = ((char) (combos[j][i] + 47));
						return emptySlotIndex;
					}
				}
			}
		}
		return 'A';
	}



	public static char emptySpace() {


		for (int i = 0; i < 9; i++) {
			if (Character.isDigit(board[i])) {
				char emptySlotIndex = board[i];
				return emptySlotIndex;
			}
		}

		return 'A';


	}



	public static boolean isOver() {
		win1 = (board[0] == board[1]) && (board[1] == board[2]);
		win2 = (board[3] == board[4]) && (board[4] == board[5]);
		win3 = (board[6] == board[7]) && (board[7] == board[8]);
		win4 = (board[0] == board[3]) && (board[3] == board[6]);
		win5 = (board[1] == board[4]) && (board[4] == board[7]);
		win6 = (board[2] == board[5]) && (board[5] == board[8]);
		win7 = (board[0] == board[4]) && (board[4] == board[8]);
		win8 = (board[2] == board[4]) && (board[4] == board[6]);
		win = win1||win2||win3||win4||win5||win6||win7||win8;

		if (win) {
			return true;
		} else if (emptySpace() == 'A') {
			return true;
		}
		else if (getTooManyMistakes()) {
			return true;
		}
		else {
			return false;
		}
	}


	public static boolean isWin() {
		win1 = (board[0] == board[1]) && (board[1] == board[2]);
		win2 = (board[3] == board[4]) && (board[4] == board[5]);
		win3 = (board[6] == board[7]) && (board[7] == board[8]);
		win4 = (board[0] == board[3]) && (board[3] == board[6]);
		win5 = (board[1] == board[4]) && (board[4] == board[7]);
		win6 = (board[2] == board[5]) && (board[5] == board[8]);
		win7 = (board[0] == board[4]) && (board[4] == board[8]);
		win8 = (board[2] == board[4]) && (board[4] == board[6]);
		win = win1||win2||win3||win4||win5||win6||win7||win8;

		if (win) {
			return true;
		} else {
			return false;
		}
	}


	
	public static void setTooManyMistakes(boolean newTooManyMistakes) {
		tooManyMistakes = newTooManyMistakes;
	}

	public static boolean getTooManyMistakes() {
		return tooManyMistakes;
	}
	



}