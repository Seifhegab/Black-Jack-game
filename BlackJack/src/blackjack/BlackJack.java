package blackjack;
import java.util.Scanner;

public class BlackJack {

    
    public static void main(String[] args) {
        
        GUI gui = new GUI();
        
        Game game = new Game();
        game.GenerateCards();
        System.out.println("PLease enter players name :");
        game.informationOfPLayers();
        
        gui.runGUI( game.cards, game.players[0].cards, game.players[1].cards, game.players[2].cards, game.players[3].cards );
        
        
        for(int i = 0;i<3;i++)
        {
            int j =2;
            boolean check = true;
            System.out.println("                           ");
            System.out.println("                           ");
            System.out.println("                           ");
            System.out.println(game.players[i].Name+" turn");
            while(check == true)
            {
                System.out.println("Your score now is " + game.players[i].Score);
                System.out.println("Enter your choice :");
                System.out.println("Press 1 for hit");
                System.out.println("Press 2 for stand");
                Scanner scanner = new Scanner(System.in);
                int num = scanner.nextInt();
                if(num == 1)
                {
                    game.updateScore(i, j);
                    
                    gui.updatePlayerHand(game.players[i].cards[j],i);

                }
                else if(num == 2)
                {
                    check = false;
                }
                if(game.players[i].Score > 21)
                {
                    System.out.println("Your score now is " + game.players[i].Score);
                    System.out.println("you are busted");
                    check = false;
                }
                j++;
            }  
        }
        
        
        
        
        
        game.maxscore();
        
        
        
        boolean d = true,z = true;
        int k = 2;
        System.out.println("                           ");
        System.out.println("                           ");
        System.out.println("                           ");
        System.out.println("Dealer is drawing cards");
        while(d == true)
        {
            if(game.players[3].Score<=game.highScore)
            {
                game.updateScore(3, k);
                
                gui.updateDealerHand(game.players[3].cards[k], game.cards);
                
                k++;
            }
            else
            {
                d = false;
                z = false;
            }
            if(game.players[3].Score>21)
            {
                System.out.println("Dealer score now is " + game.players[3].Score);
                System.out.println(game.players[3].Name+" the Dealer is busted");
                d = false;
            }
        }
        if(z == false)
        {
            System.out.println("dealer score now is " + game.players[3].Score);
        }
        
        
        
        game.maxscore();
        
        
        
        System.out.println("                           ");
        System.out.println("                           ");
        System.out.println("                           ");
        if(game.highScore == game.players[game.repeat].Score && game.repeat1 > 0)
        {
            System.out.println("it is tie");
        }
        else
        {
            System.out.println("highest score is " + game.highScore);
            if (game.highScore == 21)
            {
                System.out.println(game.name + " is win by blackjack(21)"); 
            }
            else
            {
                System.out.println(game.name + " is win");
            }
        }
    }
}
