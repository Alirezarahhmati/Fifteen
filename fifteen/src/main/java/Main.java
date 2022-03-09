import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        int[][] table = new int[4][4];
        makeRandomArray(table);

        char[][] uniCodeTable = new char[10][10];
        makeUniCodeTable( uniCodeTable );


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
                    Move.onUpKeyPressed( col );
                    break;
                case 's' :
                    Move.onDownKeyPressed( col );
                    break;
                case 'a' :
                    Move.onRightKeyPressed( row );
                    break;
                case 'd' :
                    Move.onLeftKeyPressed( row );
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

    public class Move
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
    static void makeUniCodeTable ( char[][] table ) {

    }

    static void choose (int[][] table , int row , int col) {

    }

    static void print (int[][] table , int cursorRow , int cursorCol)
    {
    }

    static boolean checkSort (int[][] tabe) {
        return false;
    }

}
