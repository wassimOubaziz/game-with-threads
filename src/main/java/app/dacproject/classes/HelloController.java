package app.dacproject.classes;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import static app.dacproject.utiles.Images.*;
public class HelloController {
    @FXML
    private Pane  board;
    @FXML
    private Text score1;

    @FXML
    private Text score2;


    private BallG ballG1;
    private BallG ballG2;

    private Gamer playerA1;
    private Gamer playerA2;
    private Gamer playerA3;

    private Gamer playerB1;
    private Gamer playerB2;
    private Gamer playerB3;

    private boolean inited = false;

    public HelloController(){

    }
    @FXML
    public void start() {
        if(inited){
            Player.gameOverOver = false;
            Ball ball1 = new Ball("PlayerA",ballG1);
            (new Player(0, ball1)).start();
            (new Player(1, ball1)).start();
            (new Player(2, ball1)).start();

            Ball ball2 = new Ball("PlayerB",ballG2);
            (new Player(0, ball2)).start();
            (new Player(1, ball2)).start();
            (new Player(2, ball2)).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while(true)  {
                        if(ball1.ballOwner == 0){
                            ballG1.setX(162);
                            ballG1.setY(149);
                        }else if(ball1.ballOwner == 1){
                            //will comment this
//                            ballG1.setX(335);
//                            ballG1.setY(237);
                        }else if(ball1.ballOwner == 2){
                            ballG1.setX(510);
                            ballG1.setY(149);
                        }else if(ball1.ballOwner == 3){
                            ballG1.setX(0);
                            ballG1.setY(0);
                        }else if(ball1.ballOwner == 4){
                            ballG1.setX(335);
                            ballG1.setY(0);
                        }

                        score1.setText("" + ball1.score);


                        if(ball2.ballOwner == 0){
                            ballG2.setX(162);
                            ballG2.setY(523);
                        }else if(ball2.ballOwner == 1){
                            ballG2.setX(335);
                            ballG2.setY(439);
                        }else if(ball2.ballOwner == 2){
                            ballG2.setX(510);
                            ballG2.setY(523);
                        }else if(ball2.ballOwner == 3){
                            ballG2.setX(0);
                            ballG2.setY(660);
                        }else if(ball2.ballOwner == 4){
                            ballG2.setX(335);
                            ballG2.setY(660);
                        }
                        score2.setText("" + ball2.score);

                        if(Player.gameOverOver){
                            break;
                        }

                    }
                }
            }).start();
        }
    }
    @FXML
    public void reset() {
        board.getChildren().clear();
        Player.gameOverOver = true;
        inited = false;
    }


    @FXML
    private void init() {
            inited = true;
            board.getChildren().removeAll(playerA1, playerA2, playerA3, ballG1);
            board.getChildren().removeAll(playerB1, playerB2, playerB3, ballG2);
            playerA1 = new Gamer(121 , 134, 0 , GreenPLAYER);
            playerA2 = new Gamer(330 , 253, 270 , GreenPLAYER);
            playerA3 = new Gamer(538 , 134, 180 , GreenPLAYER);
            ballG1 = new BallG(162, 149, 0, BALL);
            board.getChildren().addAll(ballG1,playerA1,playerA2,playerA3);

            playerB1 = new Gamer(121 , 508, 0 , RedPLAYER);
            playerB2 = new Gamer(330 , 388, 90 , RedPLAYER);
            playerB3 = new Gamer(538 , 508, 180 , RedPLAYER);
            ballG2 = new BallG(162, 523, 0, BALL);
            board.getChildren().addAll(ballG2,playerB1,playerB2,playerB3);


    }
}