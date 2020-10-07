package common;

import java.util.HashMap;

public class PatientHashMap extends HashMap<String, NameDistance> {
    public void addPatient(Patient patient) {
        this.put(patient.getFileName(), new NameDistance(0.0, patient));
    }

    public void addPatient(Patient patient, Double distance) {
        this.put(patient.getFileName(), new NameDistance(distance, patient));
    }

    public void computeDistance(EarFeature feature) {
        for (String caseId : this.keySet()) {
            NameDistance tuple = this.get(caseId);
            double minDistance = Double.MAX_VALUE;
            for (EarFeature feature2 : tuple.patient.getFeatures()) {
                minDistance = Math.min(feature.distance(feature2), minDistance);
            }
            tuple.distance = minDistance;
        }
    }

}
