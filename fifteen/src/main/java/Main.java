import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        int[][] table = new int[4][4];
        makeRandomArray(table);

        String [][] uniCodeTable = new String[17][33];
        makeUniCodeTable( uniCodeTable );


        Scanner reader = new Scanner(System.in);
        boolean endGame = false;

        int col = 0;
        int row = 0;

        print( table , uniCodeTable , row , col );

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

        print( table , uniCodeTable , row , col );
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

    static void makeRandomArray ( int[][] table)
    {
        List<Integer> mylist = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15);
        Collections.shuffle(mylist);
        int x = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                table[i][j] = mylist.get(x++);
                if (x == 15) {
                    break;
                }
            }
        }
    }

    static void makeUniCodeTable ( String[][] tMat )
    {
        int c = 4 ;
        int n = 4 ;
        int a = 2*c ;
        n = n * c + 1 ;
        int N = n*2 -1 ;

        for (int i = 0 ; i < n ; i++ )
        {
            for (int j = 0 ; j < (N) ; j++ )
            {
                if (i % c == 0 )
                {
                    if ( i == 0)
                    {
                        if (j == 0)
                        {
                            tMat[i][i] = "\u250c" ;
                        }
                        else if (j == (N-1) )
                        {
                            tMat[i][j] = "\u2510" ;
                        }
                        else if (j % a == 0 )
                        {
                            tMat[i][j] = "\u252c" ;
                        }
                        else
                        {
                            tMat[i][j] = "\u2500" ;
                        }
                    }

                    else if (i == (n-1) )
                    {
                        if (j == 0)
                        {
                            tMat[i][j] = "\u2514" ;
                        }
                        else if (j == (N-1) )
                        {
                            tMat[n-1][N-1] = "\u2518" ;
                        }
                        else if (j % a == 0 )
                        {
                            tMat[i][j] = "\u2534" ;
                        }
                        else
                        {
                            tMat[i][j] = "\u2500" ;
                        }
                    }
                    else
                    {
                        if (j == 0 )
                        {
                            tMat[i][j] = "\u251c" ;
                        }
                        else if(j == (N-1) )
                        {
                            tMat[i][j] = "\u2524" ;
                        }
                        else if (j % a == 0 )
                        {
                            tMat[i][j] = "\u253c" ;
                        }
                        else
                        {
                            tMat[i][j] = "\u2500" ;
                        }
                    }
                }

                else if (j % a == 0 )
                {
                    if ( j == 0 )
                    {
                        if(i == 0 || i == (n-1))
                        {
                            continue ;
                        }
                        else if ( i % c == 0 )
                        {
                            tMat[i][j] = "\u251c" ;
                        }
                        else
                        {
                            tMat[i][j] = "\u2502" ;
                        }
                    }
                    else if (j == (N-1) )
                    {
                        if (i==0 || i == (n-1) )
                        {
                            continue ;
                        }
                        else if( i%c == 0 )
                        {
                            tMat[i][j] = "\u2524" ;
                        }
                        else
                        {
                            tMat[i][j] = "\u2502" ;
                        }
                    }
                    else
                    {
                        if(i%c == 0 )
                        {
                            continue;
                        }
                        else
                        {
                            tMat[i][j] = "\u2502" ;
                        }
                    }
                }
                else
                {
                    tMat[i][j] = " " ;
                }
            }

        }
    }

    static void choose (int[][] table , int row , int col) {

    }

    static void print (int[][] table , String[][] uniTable , int cursorRow , int cursorCol) {

    }

    static boolean checkSort (int[][] tabe) {
        return false;
    }

}
