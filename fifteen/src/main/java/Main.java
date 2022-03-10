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
                    row = Move.onUpKeyPressed( row );
                    break;
                case 's' :
                    row = Move.onDownKeyPressed( row );
                    break;
                case 'd' :
                    col = Move.onRightKeyPressed( col );
                    break;
                case 'a' :
                    col = Move.onLeftKeyPressed( col );
                    break;
                case 'p' :
                    choose(table , row , col);
                    break;
                case 'e' :
                    return;
            }
            System.out.println("row : " + row + " column : " + col);

            endGame = checkSort( table );
        }

        print( table , uniCodeTable , row , col );
        System.out.println("enter to exite.");

        return;
    }

    public class Move
    {
        static int onLeftKeyPressed ( int column )
        {
            if ( column == 0 ) {
                column = 3;
            } else {
                column--;
            }
            return column;
        }

        static int onRightKeyPressed ( int column )
        {
            if ( column == 3 ) {
                column = 0;
            } else {
                column++;
            }
            return column;
        }

        static int onUpKeyPressed ( int row )
        {
            if ( row == 0 ) {
                row = 3;
            } else {
                row--;
            }
            return row;
        }

        static int onDownKeyPressed ( int row )
        {
            if ( row == 3 ) {
                row = 0;
            } else {
                row++;
            }
            return row;
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

    static void choose (int[][] table , int row , int col)
    {
        Scanner reader = new Scanner(System.in);
        String ch = reader.next();

        int newRow = row;
        int newCol = col;

        switch (ch.charAt(0)) {
            case 'w' :
                newRow = Move.onUpKeyPressed( row );
                break;
            case 's' :
                newRow = Move.onDownKeyPressed( row );
                break;
            case 'd' :
                newCol = Move.onRightKeyPressed( col );
                break;
            case 'a' :
                newCol = Move.onLeftKeyPressed( col );
                break;
        }

        int x = table[newRow][newCol];
        table[newRow][newCol] = table[row][col];
        table[row][col] = x;
    }

    static void print (int[][] table , String[][] uniTable , int cursorRow , int cursorCol) {

    }

    static boolean checkSort (int[][] tabe) {
        return false;
    }

}
