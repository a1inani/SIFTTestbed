package common;

import java.util.ArrayList;

public class Patient {
    private String filename;

    private String gender;

    private ArrayList<EarFeature> features = new ArrayList<EarFeature>();

    public String getFileName() {
        return filename;
    }

    public String getGender() {
        return gender;
    }

    public void setFileName(String filename) {
        this.filename = filename;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void addFeature(EarFeature feature) {
        this.features.add(feature);
    }

    public ArrayList<EarFeature> getFeatures() {
        return this.features;
    }
}
