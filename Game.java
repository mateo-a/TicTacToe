import java.util.*;

public class Game {

   static ArrayList<Integer> playPos = new ArrayList<Integer>();
   static ArrayList<Integer> CPUPos = new ArrayList<Integer>();
    public static void main(String[] args) {
      char[][] theboard = {{' ', '|', ' ', '|', ' '},
                  {'-', '+', '-', '+', '-'},
                  {' ', '|', ' ', '|', ' '},
                  {'-', '+', '-', '+', '-'},
                  {' ', '|', ' ', '|', ' '}};
      PrintBoard(theboard);

      while(true){
         Scanner scan = new Scanner(System.in);
         System.out.println("Enter your placement (1-9):");
         int player_pos = scan.nextInt();
         while(playPos.contains(player_pos) || CPUPos.contains(player_pos)){
           System.out. println("The position has been used yet. Select other position!") ;
           player_pos = scan.nextInt(); 
         }
      
         piece(theboard, player_pos, "player");
         String result = check_win();
         if(result.length() > 0){
            System.out.println(result);
            break;
         }
         
         Random rand = new Random();
         int cpuPos = rand.nextInt(9) + 1;
         while(playPos.contains(cpuPos) || CPUPos.contains(cpuPos)){
            cpuPos = rand.nextInt(9) + 1;
         }
         piece(theboard, cpuPos, "cpu");
   
         PrintBoard(theboard);

         result = check_win();
         if(result.length()  > 0){
            System.out.println(result);
            break;
         }
      }
    }

    public static void PrintBoard(char[][] theboard){
       for(char[] row : theboard){
          for(char c : row){
             System.out.print(c);
          }
          System.out.println();
       }
    }
    public static void piece(char[][] theboard, int pos, String user){
      char symbol = ' ';

      if(user.equals("player")){
         symbol = 'X';
         playPos.add(pos); 
      } else if(user.equals("cpu")){
         symbol = 'O';
         CPUPos.add(pos); 
      }
      
      switch(pos) {
         case 1:
            theboard[0][0] = symbol;
            break;
         case 2:
            theboard[0][2] = symbol;
            break;
         case 3:
            theboard[0][4] = symbol;
            break;
         case 4:
            theboard[2][0] = symbol;
            break;
         case 5:
            theboard[2][2] = symbol;
            break;
         case 6:
            theboard[2][4] = symbol;
            break;
         case 7:
            theboard[4][0] = symbol;
            break;
         case 8:
            theboard[4][2] = symbol;
            break;
         case 9:
            theboard[4][4] = symbol;
            break;
         default:
            break; 
         }
    }

   public static String check_win(){
      List row_top = Arrays.asList(1, 2, 3);
      List row_mid = Arrays.asList(4, 5, 6);
      List row_bot = Arrays.asList(7, 8, 9);
      List col_left = Arrays.asList(1, 4, 7);
      List col_mid = Arrays.asList(2, 5, 8);
      List col_right = Arrays.asList(3, 6, 9);
      List crossA = Arrays.asList(1, 5, 9);
      List crossB = Arrays.asList(7, 5, 3);
    
      List<List> winning = new ArrayList<List>();
      winning.add(row_top);
      winning.add(row_mid);
      winning.add(row_bot);
      winning.add(col_left);
      winning.add(col_mid);
      winning.add(col_right);
      winning.add(crossA);
      winning.add(crossB);

      for(List l : winning){
         if (playPos.containsAll(l)){
            return "You Won!";
         } else if (CPUPos.contains(l)){
            return "You Lose!";
         } else if(playPos.size() + CPUPos.size() == 9){
            return "Draw!";
         }
      }
      return "";
   }

   }