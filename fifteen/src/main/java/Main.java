
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

        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("\n\n\n");
        System.out.print("" +
                         "\thelp :\n" +
                         "\tfor move use 'w'/'s'/'d'/'a'\n" +
                         "\tfor put and move a number use 'p' + 'w'/'s'/'a'/'d'\n" +
                              "\tfor example pa move number to up.\n" +
                         "\tand for exite the game use 'e' \n\n" +
                "\tpress 'c' and enter to continue.");
        reader.next();

        System.out.print("\033[H\033[2J");
        System.out.flush();

        print( table , uniCodeTable , row , col );

        while ( !endGame )
        {
            String ch = reader.next();

            switch (ch.charAt(0))
            {
                case 'w' :
                    row = onUpKeyPressed( row );
                    break;
                case 's' :
                    row = onDownKeyPressed( row );
                    break;
                case 'd' :
                    col = onRightKeyPressed( col );
                    break;
                case 'a' :
                    col = onLeftKeyPressed( col );
                    break;
                case 'p' :
                    if (ch.length() != 1) {
                        choose(table, row, col , ch.charAt(1));
                    }
                    break;
                case 'e' :
                    return;
            }
            System.out.print("\033[H\033[2J");
            System.out.flush();
            makeUniCodeTable( uniCodeTable );
            print( table , uniCodeTable , row , col );


            endGame = checkSort( table );
        }

        print( table , uniCodeTable , row , col );
        System.out.println("\n\n   **********************************");
        System.out.println("   **    congratulation you win.    **");
        System.out.println("   ***********************************");
        System.out.println("\n\n\n  press e and enter to exite.");
        reader.next();

    }
    ///// Move class
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
                        if(i != n - 1)
                        {
                            tMat[i][j] = "\u2502" ;
                        }
                    }
                    else if (j == (N-1) )
                    {
                        tMat[i][j] = "\u2502" ;
                    }
                    else
                    {
                        tMat[i][j] = "\u2502" ;
                    }
                }
                else
                {
                    tMat[i][j] = " " ;
                }
            }

        }
    }

    static void choose (int[][] table , int row , int col , char ch)
    {
        int newRow = row;
        int newCol = col;

        switch (ch) {
            case 'w' :
                if (row != 0) {
                    newRow = row - 1;
                }
                break;
            case 's' :
                if (row != 3) {
                    newRow = row + 1;
                }
                break;
            case 'd' :
                if (col != 3) {
                    newCol = col + 1;
                }
                break;
            case 'a' :
                if (col != 0) {
                    newCol = col - 1;
                }
                break;
        }

        if (table[newRow][newCol] == 0) {
            int x = table[newRow][newCol];
            table[newRow][newCol] = table[row][col];
            table[row][col] = x;
        }
    }

    static void print (int[][] table , String[][] uniTable , int cursorRow , int cursorCol)
    {
        int x = 0 , y = 0;
        for (int i = 2; i < 17; i += 4) {
            for (int j = 4; j < 33; j += 8) {
                int num = table[x][y++];
                if (num != 0) {
                    uniTable[i][j] = Integer.toString(num);
                }
                if (num / 10 >= 1) {
                    uniTable[i][j+1] = "";
                }
            }
            y = 0;
            x++;
        }

        x = cursorRow * 4;
        y = cursorCol * 8;
        uniTable[x+1][y+2] = "\u256D";
        uniTable[x+1][y+6] = "\u256E";
        uniTable[x+3][y+2] = "\u2570";
        uniTable[x+3][y+6] = "\u256F";

        for (int i = 0; i < 17; i++) {
            for (int i1 = 0; i1 < 33; i1++) {
                System.out.print(uniTable[i][i1]);
            }
            System.out.println();
        }

        uniTable[x+1][y+2] = " ";
        uniTable[x+1][y+6] = " ";
        uniTable[x+3][y+2] = " ";
        uniTable[x+3][y+6] = " ";
    }

    static boolean checkSort (int[][] tabe)
    {
        int x = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (x != tabe[i][j]) {
                    return false;
                }
                if (x == 15 ) {
                    x = 0;
                }else {
                    x++;
                }
            }
        }
        return true;
    }

}
