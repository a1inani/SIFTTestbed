package common;

import java.util.List;

public class TopMatchesList {
    private EarFeature currentFeature;
    private List<NameDistance> top;

    public EarFeature getCurrentFeature() {
        return currentFeature;
    }

    public void setCurrentFeature(EarFeature currentFeature) {
        this.currentFeature = currentFeature;
    }

    public List<NameDistance> getTop() {
        return top;
    }

    public void setTop(List<NameDistance> top) {
        this.top = top;
    }

    public boolean find(Patient patient) {
        for(NameDistance nd : top) {
            if(patient.getFileName().equals(nd.patient.getFileName())) {
                return true;
            }
        }
        return false;
    }

}
