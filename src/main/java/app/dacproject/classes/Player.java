package app.dacproject.classes;

public class Player extends Thread{

    int playerId;
    Ball ball;
    public static boolean gameOverOver= false;



    public Player(int playerId, Ball ball) {
        this.playerId = playerId;
        this.ball = ball;
    }


    @Override
    public void run(){
        //boolean gameOver = false;
        while(!gameOverOver) {
            if (playerId == 0) {
                try {

                    ball.sema0.acquire();
                    ball.ballOwner = 0;
                    System.out.println(ball.teamName + " " + playerId + " has the ball");
                    sleep(1000);
                    ball.state = Math.random();
                    if (ball.state < 0.2) {
                        System.out.println(ball.teamName + " " + playerId + " lost the ball");
                        ball.ballOwner = 3;
                        sleep(1000);
                        ball.sema0.release();
                        continue;
                    }
                    ball.sema1.release();
                    ball.sema0.acquire();
                    if (ball.state < 0.2) {
                        ball.sema0.release();
                        continue;
                    }
                    ball.ballOwner = 0;
                    System.out.println(ball.teamName + " " + playerId + " has and shot the ball");
                    sleep(1000);
                    ball.ballOwner = 4;
                    sleep(1000);
                    ball.score++;
                    if (ball.score == 10) {
                        gameOverOver = true;
                        break;
                    }
                    System.out.println(ball.teamName + " scored a goal " + ball.score);
                    ball.sema0.release();

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else if (playerId == 1) {
                try {
                    ball.sema1.acquire();
                    ball.ballOwner = 1;
                    System.out.println(ball.teamName + " " + playerId + " has the ball");
                    if(ball.teamName.contains("PlayerA")){
                        while(ball.ballg.getX() < 335 || ball.ballg.getY() < 237){
                            if(ball.ballg.getX() < 335){
                                ball.ballg.setX(ball.ballg.getX() + 1);
                            }

                            if(ball.ballg.getY() < 237){
                                ball.ballg.setY(ball.ballg.getY() + 0.5);
                            }
                            sleep(4);
                        }
                    }else{
                        sleep(150);
                    }
                    sleep(1000);
                    ball.state = Math.random();
                    if (ball.state < 0.2) {
                        System.out.println(ball.teamName + " " + playerId + " lost the ball");
                        ball.ballOwner = 3;
                        sleep(1000);
                        ball.sema0.release();
                        continue;
                    }
                    ball.sema2.release();
                    ball.sema1.acquire();
                    if (ball.state < 0.2) {
                        ball.sema0.release();
                        continue;
                    }
                    ball.ballOwner = 1;
                    if(ball.teamName.contains("PlayerA")){
                        ball.ballg.setX(335);
                        ball.ballg.setY(237);
                    }
                    System.out.println(ball.teamName + " " + playerId + " has the ball");
                    sleep(1000);
                    ball.sema0.release();

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else if (playerId == 2) {
                try {
                    ball.sema2.acquire();
                    ball.ballOwner = 2;
                    System.out.println(ball.teamName + " " + playerId + " has the ball");
                    sleep(1000);
                    ball.state = Math.random();
                    if (ball.state < 0.2) {
                        System.out.println(ball.teamName + " " + playerId + " lost the ball");
                        ball.ballOwner = 3;
                        sleep(1000);
                        ball.sema1.release();
                        continue;
                    }
                    ball.sema1.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
//
        ball.sema0.release(2);
        ball.sema1.release(2);
        ball.sema2.release(1);
    }
}

