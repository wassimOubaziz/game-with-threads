package app.dacproject.classes;

import java.util.concurrent.Semaphore;

public class Ball {
    int ballOwner;
    String teamName;
    Semaphore sema0 = new Semaphore(1);
    Semaphore sema1 = new Semaphore(0);
    Semaphore sema2 = new Semaphore(0);

    BallG ballg;

    int score = 0;

    double state= 0;

    public Ball(String teamName, BallG ballg){
        this.teamName = teamName;
        this.ballg = ballg;
    }
}
