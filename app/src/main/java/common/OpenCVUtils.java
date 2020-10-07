package common;

import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

import static org.opencv.imgproc.Imgproc.INTER_AREA;

public class OpenCVUtils {
    public static void resizeMat(Mat image, double maxWidth, double maxHeight) {
        if (image.width() <= maxWidth && image.height() <= maxHeight) {
            return;
        }

        double ratio = (double)image.width() / (double)image.height();
        double width, height;
        if (ratio > 1) {
            width = maxWidth;
            height = maxWidth * ((double)image.height()/(double)image.width());
        } else {
            height = maxHeight;
            width = maxHeight* ratio;
        }
        Imgproc.resize(image, image, new Size(width, height), 0, 0, INTER_AREA);
    }


    private OpenCVUtils() {

    }
}
