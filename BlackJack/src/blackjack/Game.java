package blackjack;
import java.util.Random;
import java.util.Scanner;


public class Game {
    public Player players[]=new Player[4];
    public Card [] cards=new Card[52];
    public int highScore ;
    
    
    public String name;
    public int repeat;
    public int repeat1;
    
    
    
    public Card[] GenerateCards()
    {
        Card card;
        int suit =0;
        int index = 0;
        while(index<=51)
        {
            for(int i=0;i<13;i++)
            {
                if(i<9)
                {
                    card =new Card (suit,i,i+1);
                }
                else 
                {
                    card = new Card(suit,i,10); 
                }
                cards[index]=card;
                index++;
            }
            suit++;
        }
        return cards;
    }
    
    
    
    
    Random rand = new Random();
    public Card drawcard()
    {
        int i=0;
        Card card;
        Player player = new Player();
        int randomChoice = rand.nextInt(52);
        while(true)
        {
            if(cards[randomChoice] == null)
            {
                randomChoice = rand.nextInt(52);
                continue;
            }
            else
            {
                card = cards[randomChoice];
                cards[randomChoice] = null;
            }
           return card;
        }
    }
    
    
    
    public void informationOfPLayers()
    {
        int i =0;
        for(int j = 0;j<4;j++)
        {
            Player player = new Player(); 
            Scanner scanner = new Scanner(System.in);
            String N = scanner.next();
            player.Name = N;
            for(i =0;i<2;i++)
            {
                player.cards[i] = drawcard();
            }
            player.Score = player.cards[0].value + player.cards[1].value;
            players[j] = player;
        }
    }
    
    
   
    public int maxscore()
    {
        String name ;
        int highScore =0;
        for(int i =0;i<4;i++)
        {
            if(players[i].Score > highScore && players[i].Score<=21)
            {
                highScore = players[i].Score;
                name = players[i].Name;
                this.name = name;
            }
            else if (players[i].Score == highScore && players[i].Score<=21)
            {
                int repeat = -1;
                repeat = i;
                repeat1++;
                this.repeat = repeat;
                this.repeat1 = repeat1;
            }
        }
        return this.highScore = highScore;
    }
    
    
    
    
    public void updateScore(int i,int j)
    {
        players[i].cards[j] = drawcard();
        players[i].Score = players[i].Score + players[i].cards[j].value;
    }
}
