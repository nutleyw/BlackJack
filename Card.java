public class Card {
       private Suit suit;
       private int val;
       public Card(Suit x, int y){
              this.suit = x;    
              if(y>= 1 && y <= 13){
                     this.val = y;
              } else {
                     System.out.println("Error: Invalid number");
              }
       }
       public int getVal() {
              return val;
       }
       public String toString(){ 
              String face;
              switch(this.val){
              case 2:
                     face = "Two";
                     break;
              case 3:
                     face = "Three";
                     break;
              case 4:
                     face = "Four";
                     break;
              case 5:
                     face = "Five";
                     break;
              case 6:
                     face = "Six";
                     break;
              case 7:
                     face = "Seven";
                     break;
              case 8:
                     face = "Eight";
                     break;
              case 9:
                     face = "Nine";
                     break;
              case 10:
                     face = "Ten";
                     break;
              case 11:
                     face = "Jack";
                     break;
              case 12:
                     face = "Queen";
                     break;
              case 13:
                     face = "King";
                     break;
              case 1:
                     face= "Ace";
                     break;
              default:
                     face ="Error";
              }
              return face + " of " + suit.toString();
       }
}

