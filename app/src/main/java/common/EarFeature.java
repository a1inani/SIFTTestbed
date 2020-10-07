package common;

import android.util.Log;

import com.google.gson.Gson;

import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfDMatch;
import org.opencv.features2d.DMatch;
import org.opencv.features2d.DescriptorMatcher;

import java.util.ArrayList;

public class EarFeature {
    private static DescriptorMatcher matcher;

    private String features;
    private transient Mat _features = null;

    static {
        System.loadLibrary("opencv_java");
        System.loadLibrary("nonfree");
        matcher = DescriptorMatcher.create(DescriptorMatcher.BRUTEFORCE);
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(Mat _features) {
        this._features = _features;
        this.features = this.serializeFeatures();
    }

    public void setFeatures(String features) {
        this.features = features;
        this._features = null;
    }

    public EarFeature(String features) {
        this.setFeatures(features);
    }

    public EarFeature(Mat _features) {
        this.setFeatures(_features);
    }

    public String serializeFeatures() {
        Mat mFeatures = this._getFeatures();

        ArrayList<ArrayList<Integer>> features = new ArrayList<>();
        for (int i=0;i<mFeatures.rows();++i) {
            ArrayList<Integer> feature = new ArrayList<>();
            for (int j=0;j<mFeatures.cols();++j) {
                feature.add((int)mFeatures.get(i, j)[0]);
            }
            features.add(feature);
        }
        Gson gson = new Gson();
        return gson.toJson(features);
    }

    public ArrayList<ArrayList<Integer>> getFeat() {
        Mat mFeatures = this._getFeatures();

        ArrayList<ArrayList<Integer>> features = new ArrayList<>();
        for (int i=0;i<mFeatures.rows();++i) {
            ArrayList<Integer> feature = new ArrayList<>();
            for (int j=0;j<mFeatures.cols();++j) {
                feature.add((int)mFeatures.get(i, j)[0]);
            }
            features.add(feature);
        }

        return features;
    }

    public double distance(EarFeature feature2) {
        assert this._getFeatures().type() == feature2._getFeatures().type();

        MatOfDMatch matches = new MatOfDMatch();
        Mat features1 = this._getFeatures();
        Mat features2 = feature2._getFeatures();

        if (features1 == null || features2 == null) {
            return Double.MAX_VALUE;
        }

        matcher.match(features1, features2, matches);
        DMatch[] aMatches = matches.toArray();

        double total_distance = 0, average_distance;
        for (int i=0;i<aMatches.length;++i) {
            total_distance += aMatches[i].distance;
        }

        if(aMatches.length > 0) {
            average_distance = total_distance / aMatches.length;
        } else {
            average_distance = 1000;
        }
        return average_distance;
    }

    public double distance(Mat features2) {

        MatOfDMatch matches = new MatOfDMatch();
        Mat features1 = this._getFeatures();
        //Mat features2 = feature2._getFeatures();

        if (features1 == null || features2 == null) {
            return Double.MAX_VALUE;
        }

        matcher.match(features1, features2, matches);
        DMatch[] aMatches = matches.toArray();

        double distance = 0;
        double count = 0;
        for (int i=0;i<aMatches.length;++i) {
            distance += aMatches[i].distance;
            count++;
        }
        Log.d("Avg_distance", Double.toString(distance/count));

        //return average distance
        return distance/count;
    }

    public Mat unserialize(String featuresString) {
        final int kFeatureSize = 128;
        Gson gson = new Gson();
        ArrayList<ArrayList<Double>> features = new ArrayList<>();
        features = gson.fromJson(featuresString, features.getClass());

        Mat mFeatures = new Mat();
        if (features == null || features.size() == 0) {
            return null;
        }

        mFeatures.create(features.size(), kFeatureSize, CvType.CV_32F);

        float buffer[] = new float[1];
        for (int i=0;i<features.size();++i) {
            ArrayList<Double> feature = features.get(i);
            if (feature == null || feature.size() != kFeatureSize) {
                return null;
            }
            for (int j=0;j<feature.size();++j) {
                buffer[0] = feature.get(j).floatValue();
                mFeatures.put(i, j, buffer);
            }
        }

        return mFeatures;
    }

    private Mat _getFeatures() {
        if (this._features == null && this.features != null) {
            this._features = this.unserialize(this.features);
        }
        return this._features;
    }
}
