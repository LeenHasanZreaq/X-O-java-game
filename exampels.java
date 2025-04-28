import java.util.*; 

public class Main {
    public static void main(String[] args) {
        Scanner inPut = new Scanner(System.in);
         char[][] Game = new char[3][3];
          

         int row , column ; 
        boolean GameOn = true ; 
        char Winner = '\u0000'; 

         System.out.println("  (0,0)  ,  (0,1)  ,  (0,2)  .");
         System.out.println("  (1,0)  ,  (1,1)  ,  (1,2)  .");
         System.out.println("  (2,0)  ,  (2,1)  ,  (2,2)  .");



         while (GameOn) {
            System.out.println("Enter the row: ");
            row = inPut.nextInt();
            System.out.println("Enter the column: ");
            column = inPut.nextInt();

            if (row >= 0 && row < 3 && column >= 0 && column < 3) {
                if (Game[row][column] == '\u0000') {
                    System.out.println("Enter the Letter (X or O): ");
                    char Letter = inPut.next().toUpperCase().charAt(0);

                    if (Letter == 'X' || Letter == 'O') {
                        Game[row][column] = Letter;
                    } else {
                        System.out.println("Invalid letter. Please enter X or O only.");
                        continue;
                    }
                } else {
                    System.out.println("The site is booked. Try another site.");
                    continue;
                }
            } else {
                System.out.println("Outside the limits of the game.");
                continue;
            }

            // طباعة اللوحة
            System.out.println("Current Board:");
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(Game[i][j] == '\u0000' ? "." : Game[i][j]);
                    System.out.print(" ");
                }
                System.out.println();
            }

            // التحقق من الفائز
            for (char player : new char[]{'X', 'O'}) {
                if (
                    (Game[0][0] == player && Game[0][1] == player && Game[0][2] == player) ||
                    (Game[1][0] == player && Game[1][1] == player && Game[1][2] == player) ||
                    (Game[2][0] == player && Game[2][1] == player && Game[2][2] == player) ||
                    (Game[0][0] == player && Game[1][0] == player && Game[2][0] == player) ||
                    (Game[0][1] == player && Game[1][1] == player && Game[2][1] == player) ||
                    (Game[0][2] == player && Game[1][2] == player && Game[2][2] == player) ||
                    (Game[0][0] == player && Game[1][1] == player && Game[2][2] == player) ||
                    (Game[0][2] == player && Game[1][1] == player && Game[2][0] == player)
                ) {
                    Winner = player;
                    GameOn = false;
                    break;
                }
            }

            // التحقق من امتلاء اللوحة
            boolean Full = true;
            for (int i = 0; i < 3 && Full; i++) {
                for (int j = 0; j < 3; j++) {
                    if (Game[i][j] == '\u0000') {
                        Full = false;
                        break;
                    }
                }
            }

            if (Full && Winner == '\u0000') {
                System.out.println("The game is a draw.");
                GameOn = false;
            }

            if (Winner != '\u0000') {
                System.out.println("Player " + Winner + " wins!");
            }
        }
    }
}
