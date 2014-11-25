import java.util.Random;
 
public class Deck {
       private Card[] card;
       private int total;     
       public Deck() {
              this(1,false);
       }
       public Deck(int decks, boolean shuf){           
              this.total =decks * 52;
              this.card = new Card[this.total];             
              int count =0;
              for(int x=0 ; x < decks; x++){
                     for (int y=0;y<4;y++){
                           for(int z= 1; z<=13; z++){
                                  this.card[count]= new Card(Suit.values()[y],z);
                                  count++;
                                  }
                     }
              }
                     if(shuf){
                           this.shuffleDeck();
              }
       }
        public void shuffleDeck() {
              Random x = new Random();
              Card n;
              int y;
              for(int i =0 ; i < this.total; i++){
                     y= x.nextInt(this.total);
                     n=this.card[i];
                     this.card[i] = this.card[y];
                     this.card[y] = n;
                     }
       }
       public Card nextDeal() {
              Card first = this.card[0];     
              for (int x = 1;x<this.total; x++){
                     this.card[x-1] = this.card[x];
                     }
              this.card[this.total-1] = null;
              this.total--;
              return first;
       }
       public void print(int number){     
              for(int c = 0; c < number; c++){
                     System.out.printf("%3d/%d %s\n", c+1, this.total, this.card[c].toString());
              }
              System.out.printf("\t[%d others]\n", this.total-number);
       }
}

