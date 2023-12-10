package app.dacproject.classes;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Gamer extends ImageView {

    public Gamer(double x, double y, double z, Image image) {
        setX(x);
        setY(y);
        setRotate(z);
        setImage(image);
    }
}
