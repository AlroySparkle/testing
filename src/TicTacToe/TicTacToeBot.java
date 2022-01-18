/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TicTacToe;

/**
 *
 * @author aliro
 */
public class TicTacToeBot {
    private int board[][]= new int[3][3];
    private int pc=-1,player=1;
    public TicTacToeBot(int board[][]) {
    this.board = board;
    }
    
    public void play(){
        int place=couldFinish(false);
        if(place==0){
            place=couldFinish(true);
        }
        if(place==0){
            place=randomPlay();
        }
        this.board[(int)(place/3)][place%3]=-1;
    }
    
    private int randomPlay(){
        int place;
        while(true){
            place=(int)(Math.random()*9);
            if(this.board[(int)(place/3)][place%3]==0){
                return place;
            }
        }
    }
    
    private int whereToPlay(int first, int second, int third){
        return (this.board[(int)(first/3)][first%3]==0)?first:
               (this.board[(int)(second/3)][second%3]==0)?second:third;
    }
    
    private int couldFinish(boolean player){
        int compare=(player)?2:-2;
        if(this.board[0][0]+this.board[1][1]+this.board[2][2]==compare){
            return whereToPlay(0, 4, 8);
        }
        else if(this.board[0][2]+this.board[1][1]+this.board[2][0]==compare){
            return whereToPlay(2, 4, 6);
        }
        for(int i = 0; i < 3; i++){
            if(this.board[0][i]+this.board[1][i]+this.board[2][i]==compare){
            return whereToPlay(i, i+3, i+6);
            }
         else if(this.board[i][0]+this.board[i][1]+this.board[i][2]==compare){
            return whereToPlay(i*3, i*3+1, i*3+2);
            }
        }
        return 0;
    }
}
    
