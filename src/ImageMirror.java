import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.nio.Buffer;
import javax.imageio.ImageIO;
public class ImageMirror{
    public BufferedImage flip(BufferedImage image){
        // Get source image dimension
        int width = image.getWidth();
        int height = image.getHeight();

        // BufferedImage for mirror image
        BufferedImage mimg = new BufferedImage(
                width, height, BufferedImage.TYPE_INT_ARGB);

        // Create mirror image pixel by pixel
        for (int y = 0; y < height; y++) {
            for (int lx = 0, rx = width - 1; lx < width; lx++, rx--) {

                // lx starts from the left side of the image
                // rx starts from the right side of the
                // image lx is used since we are getting
                // pixel from left side rx is used to set
                // from right side get source pixel value
                int p = image.getRGB(lx, y);

                // set mirror image pixel value
                mimg.setRGB(rx, y, p);
            }
        }
        return mimg;
    }

}