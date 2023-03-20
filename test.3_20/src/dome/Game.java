package dome;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Game {

    private static final String[] suits = {"♥","♦","♠","♣"};

    public List<poker> buyPoker(){
        List<poker> pokers = new ArrayList<>();

        for (int i = 0; i <4 ; i++) {
            for (int j = 1; j <= 13; j++) {
                poker poker = new poker(suits[i],j);

                pokers.add(poker);
            }
        }
        return pokers;
    }
    public void shuffle(List<poker> pokers){

        for (int i = pokers.size()-1; i >0 ; i--) {
            Random random = new Random();
            int index = random.nextInt(i);
            swap(pokers,i,index);
        }
    }
    private void swap(List<poker> pokers,int i, int j){
        poker tmp = pokers.get(i);
        pokers.set(i,pokers.get(j));
        pokers.set(j,tmp);
    }
    public List<List<poker>> game(List<poker> pokers){
        List<List<poker>> hand = new ArrayList<>();

        List<poker> hand1 = new ArrayList<>();
        List<poker> hand2 = new ArrayList<>();
        List<poker> hand3 = new ArrayList<>();

        hand.add(hand1);
        hand.add(hand2);
        hand.add(hand3);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3 ; j++) {
                poker removePoker = pokers.remove(0);
                hand.get(j).add(removePoker);
            }
            
        }
        return hand;
    }


}
