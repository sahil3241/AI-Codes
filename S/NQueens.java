import java.util.Scanner;
public class NQueens {
    static int count;
    public static void printArr(char[][] arr) {
        System.out.println("\n---------------Chess Board---------------");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j]+"  ");
            }
            System.out.println();
        }
    }
    public static void takeInput(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = 'x';
            }
        }
    }
    public static boolean QueenIsSafe(char[][] board, int row, int col){
        for (int i = 0; i < row; i++) {
            if(board[i][col] == 'Q'){
                return false;
            }
        }
        int i = row, j = col;
        while(i > -1 && j > -1){
            if(board[i][j] == 'Q'){
                return false;
            }
            i--; j--;
        }
        i = row; j = col;
        while (i > -1 && j < board.length){
            if(board[i][j] == 'Q'){
                return false;
            }
            i--; j++;
        }
        i = row; j = col;
        while (i < board.length && j > -1) {
            if(board[i][j] == 'Q'){
                return false;
            }
            i++; j--;
        }
        i = row; j = col;
        while(i < board.length && j < board.length){
            if(board[i][j] == 'Q'){
                return false;
            }
            i++; j++;
        }
        return true;
    }
    // // To print all solutions or to count total no. of solutions
    // public static void nQueens(char[][] board, int i){
    //     if(i == board.length){
    //         // printArr(board);
    //         count++;
    //         return;
    //     }
    //     for (int j = 0; j < board.length; j++) {
    //         if(QueenIsSafe(board, i, j)){
    //             board[i][j] = 'Q';
    //             nQueens(board, i+1);
    //             board[i][j] = 'x';
    //         }
    //     }
    // }
    // To print one solution if it exists
    public static boolean nQueens(char[][] board, int i){
        if(i == board.length){
            // printArr(board);
            count++;
            return true;
        }
        for (int j = 0; j < board.length; j++) {
            if(QueenIsSafe(board, i, j)){
                board[i][j] = 'Q';
                if(nQueens(board, i+1)){
                    return true;
                }
                board[i][j] = 'x';
            }
        }
        return false;
    }
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("\nEnter the value of n : ");
        int n = sc.nextInt();
        char Board[][] = new char[n][n];
        takeInput(Board);
        printArr(Board);
        // // To print all solutions or to count total no. of solutions
        // nQueens(Board, 0);
        // System.out.println("\nThere are total "+count+" no. of solutions.");

        // To print one solution if it exists
        if(nQueens(Board, 0)){
            printArr(Board);
        }else{
            System.out.println("\nNo possible Solution exists.");
        }
    }
}