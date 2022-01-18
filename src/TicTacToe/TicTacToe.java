/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TicTacToe;

import java.util.Scanner;

/**
 *
 * @author aliro
 */
public class TicTacToe {
    private int board[][]= new int[3][3];
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        TicTacToeBot bot = new TicTacToeBot(game.board);
        Scanner in = new Scanner(System.in);
        game.play(0, 1);
        bot.play();
        game.parint();
        game.play(in.nextInt(), 1);
        bot.play();
        game.parint();
        game.play(in.nextInt(), 1);
        bot.play();
        game.parint();
                
        
        
   }
    public int whoWin(){
        //check cata
        if(Math.abs(this.board[0][0]+this.board[1][1]+this.board[2][2])==3 ||
           Math.abs(this.board[0][2]+this.board[1][1]+this.board[2][0])==3 ){
            return this.board[1][1];
        }
        for (int block = 0; block < this.board.length; block++) {
            if(Math.abs(this.board[block][0]+this.board[block][1]+this.board[block][2])==3 ||
               Math.abs(this.board[0][block]+this.board[1][block]+this.board[2][block])==3){
                return this.board[block][block];
            }
        }
        return 0;
    }

    public int[][] getBoard() {
        return this.board;
    }
    public void play(int position,int player){
        this.board[(int)(position/3)][position%3]=player;
    }
    public void parint(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(this.board[i][j]+" ");
            }
                System.out.println();
        }
    }
    public void newGame(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.board[i][j]=0;
            }
        }
    }
}
