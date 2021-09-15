package com.hut.stastic;

public class ChildGame {
    public static void main(String[] args) {
        game game = new game("pig");
        game.join();
        game game2 = new game("dog");
        game2.join();
        game game3 = new game("dog");
        game3.join();
        System.out.println(game.count);
    }

}

class game{
    private String name;
    public int count;

    public game(String name) {
        this.name = name;

    }

    public void join(){
        System.out.println(this.name + "加入了游戏");
        count++;
    }
}
