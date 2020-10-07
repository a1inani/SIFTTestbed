package common;

import org.opencv.core.Mat;
import org.opencv.core.MatOfKeyPoint;
import org.opencv.core.Size;
import org.opencv.features2d.DescriptorExtractor;
import org.opencv.features2d.FeatureDetector;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;
import static org.opencv.imgproc.Imgproc.INTER_AREA;

public class EarIdentifier {
    private PatientHashMap database;

    public EarIdentifier(PatientHashMap _database) {
        this.database = _database;
    }

    public void setDatabase(PatientHashMap _database) {
        this.database = _database;
    }

    /**
     * Do the ear identification process.
     * @param feature The result of the identification.
     * @return
     */
    public TopMatchesList identify(EarFeature feature) {
        return null;
    }


    public EarFeature computePathFeatures(String path) {
        Mat image1;
        Mat descriptors1 = new Mat();
        MatOfKeyPoint keypoints1 = new MatOfKeyPoint();
        image1 = Highgui.imread(path, Highgui.IMREAD_GRAYSCALE);
        Imgproc.resize(image1, image1, new Size(0,0), (double)150/image1.width(), (double)150/image1.width(), INTER_AREA);
        Imgproc.equalizeHist(image1, image1);
        FeatureDetector detector = FeatureDetector.create(FeatureDetector.SIFT);
        detector.detect(image1, keypoints1);
        DescriptorExtractor extractor = DescriptorExtractor.create(DescriptorExtractor.SIFT);
        extractor.compute(image1, keypoints1, descriptors1);
        return new EarFeature(descriptors1);
    }

    static {
        System.loadLibrary("opencv_java");
        System.loadLibrary("nonfree");
    }
}
