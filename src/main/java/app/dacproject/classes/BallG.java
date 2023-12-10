package app.dacproject.classes;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BallG extends ImageView {

    public BallG(double x, double y, double z, Image image) {
        setX(x);
        setY(y);
        setRotate(z);
        setImage(image);
    }

    public void move(int x, int y){
        while(getX() < x && getY() < y){
            setX(getX() + 1);
            setY(getY() + 1);
        }
    }

}
