package pingpong;

import javafx.scene.shape.Rectangle;

public class RectangleMove implements Runnable {
    private final Rectangle rect;

    public RectangleMove(Rectangle rect) {
        this.rect = rect;
    }

    @Override
    public void run() {
        int deltaX = 5;
        while (true) {
            if (this.rect.getX() < 5 || this.rect.getX() > 295) {
                deltaX *= -1;
            }
            this.rect.setX(this.rect.getX() + deltaX);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}