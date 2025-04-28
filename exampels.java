import  java.util.*;
public class exampels {
public static  void main(String[] args) {
 

Scanner inPut = new Scanner(System.in) ;
 boolean GameOn = true ;
 char winner = '\u0000';


    int row , col ;
    
    System.out.println("  (0,0)  ,  (0,1)  ,  (0,2)  .");
    System.out.println("  (1,0)  ,  (1,1)  ,  (1,2)  .");
    System.out.println("  (2,0)  ,  (2,1)  ,  (2,2)  .");


    char [][]Game = new char[3][3] ; 
    
  while(GameOn){  
     System.out.println(" Enter the location : \n Enter the row :  ") ; 
      row = inPut.nextInt();
      System.out.println(" Enter the col : ");
      col = inPut.nextInt();
 

   
    System.out.println("Enter the Letter : ");
    char Letter = inPut.next().charAt(0) ;

    Game[row][col] = Letter ; 
       
   

// التحقق من الحدود واذا ضمن الحدود بطبع الحرف . ا

     if(row >= 0 && row < 3 && col >= 0 && col < 3){
      if(Game[row][col] == '\u0000') {
        System.out.println("The site is booked. Try another site.");
      }else{
        Game[row][col] = Letter ; 
      }
     }else{
      System.out.println("The site is out of bounds .");
     }
       // التحقق من ان المكان ممتلئ 
     boolean Full = true ;
     for(int i = 0 ; i<3 ; i++){
       for(int j = 0 ; j<3 ; j++){
       if (Game[i][j] == '\u0000'){
        Full = false ;
        break ;
       }
     }
    }



    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
          System.out.print(Game[i][j] == '\u0000' ? "." : Game[i][j] );
          System.out.print("  ");
      }
      System.out.println();
  }

      if(Full){
        System.out.println("The Game is ended  .");
        GameOn = false ;
      }


   





    for (int i = 0; i < 3; i++) {
      if (Game[i][0] != '\u0000' &&
          Game[i][0] == Game[i][1] &&
          Game[i][1] == Game[i][2]) {
          winner = Game[i][0];
          GameOn = false;
      }
  }


  for (int j = 0; j < 3; j++) {
    if (Game[0][j] != '\u0000' &&
        Game[0][j] == Game[1][j] &&
        Game[1][j] == Game[2][j]) {
        winner = Game[0][j];
        GameOn = false;
    }
} 



if (Game[0][0] != '\u0000' &&
    Game[0][0] == Game[1][1] &&
    Game[1][1] == Game[2][2]) {
    winner = Game[0][0];
    GameOn = false;
}
 


if (Game[0][2] != '\u0000' &&
    Game[0][2] == Game[1][1] &&
    Game[1][1] == Game[2][0]) {
    winner = Game[0][2];
    GameOn = false;
}


if (!GameOn && winner != '\u0000') {
  System.out.println("Player " + winner + " wins!");
}













}




    inPut.close(); 
  } 
}

 

