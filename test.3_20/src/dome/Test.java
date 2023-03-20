package dome;

import java.util.List;

public class Test {

    public static void main(String[] args) {
        Game game = new Game();
        List<poker> pokers = game.buyPoker();
        System.out.println(pokers);

        game.shuffle(pokers);//洗牌
        System.out.println(pokers);

        List<List<poker>> hand = game.game(pokers);
        for (int i = 0; i <hand.size() ; i++) {
            System.out.println("第"+(i+1)+"个人"+hand.get(i));
        }
        System.out.println("剩下的牌");
        System.out.println(pokers);
    }
}
