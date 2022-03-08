import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        int[][] table = new int[4][4];
        makeRandomArray(table);

        Scanner reader = new Scanner(System.in);
        boolean endGame = false;

        int col = 0;
        int row = 0;

        print( table , row , col );

        while ( !endGame )
        {
            String ch = reader.next();

            switch (ch.charAt(0))
            {
                case 'w' :
                    move.onUpKeyPressed( col );
                    break;
                case 's' :
                    move.onDownKeyPressed( col );
                    break;
                case 'a' :
                    move.onRightKeyPressed( row );
                    break;
                case 'd' :
                    move.onLeftKeyPressed( row );
                case 'p' :
                    choose(table , row , col);
                    break;
                case 'e' :
                    return;
            }

            endGame = checkSort( table );
        }

        print( table , row , col );
        System.out.println("enter to exite.");

        return;
    }

    public class move
    {
        static void onLeftKeyPressed ( int row )
        {

        }

        static void onRightKeyPressed ( int row )
        {

        }

        static void onUpKeyPressed ( int column )
        {

        }

        static void onDownKeyPressed ( int column )
        {

        }
    }

    static void makeRandomArray ( int[][] table) {

    }

    static void choose (int[][] table , int row , int col) {

    }

    static void print (int[][] table , int cursorRow , int cursorCol) {

    }

    static boolean checkSort (int[][] tabe) {

    }
}
