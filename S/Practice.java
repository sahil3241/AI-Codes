import java.util.*;

public class Practice {

    public static boolean isSafe (char [][] board , int row , int col)
    {
        for(int i=row ,j=col ; i>=0 && j>=0; i--,j--)
        {
            if(board[i][j]=='Q')
            {
                return false;
            }
        }

        for(int i=row , j=col ; i>=0 && j< board.length; i-- , j++)
        {
            if(board[i][j]=='Q')
            {
                return false;
            }
        }

        for(int i=row ; i>=0; i--)
        {
            if(board[i][col]=='Q')
            {
                return false;
            }
        }

        return true;
    }
    static int count =0;
    public static void nQueen (char [][] board , int row )
    {
        if(row==board.length)
        {
            System.out.println("----------------");
            printBoard(board);
            count++;
            return;
        }

        for(int i=0; i<board.length;i++)
        {
            if(isSafe(board , row , i))
            {
                board[row][i]='Q';
                nQueen(board , row+1);
                board[row][i]='x';

            }
        }
    }

    public static void printBoard(char [][] board)
    {
        for(int i=0; i<board.length;i++)
        {
            for(int j=0;j<board.length;j++) 
            {
               System.out.print(board[i][j]+" ");
            }
            System.out.println();  
        }   
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of baord: ");
        int n = sc.nextInt();
        // int n=4;
        char [][] board = new char [n][n];

        for(int i=0; i<board.length;i++)
        {
            for(int j=0;j<board.length;j++) 
            {
                board[i][j]='x';
            }  
        }

        nQueen(board , 0);
        sc.close();
    }
    
}
