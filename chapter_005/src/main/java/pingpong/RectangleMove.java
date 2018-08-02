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
            if (this.rect.getX() == 300) {
                deltaX = -5;
            }
            if (this.rect.getX() == 0) {
                deltaX = 5;
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