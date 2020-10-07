package common;

public class NameDistance implements Comparable<NameDistance> {
    public double distance  = 0.0;
    public Patient patient = null;

    public NameDistance(double distance, Patient patient) {
        this.set(distance, patient);
    }

    public void set(double distance, Patient patient) {
        this.distance = distance;
        this.patient = patient;
    }

    @Override
    public int compareTo(NameDistance nameDistance) {
        if (this.distance < nameDistance.distance) {
            return -1;
        } else if (this.distance == nameDistance.distance) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public String toString() {
        return this.distance+" "+this.patient.getFileName();
    }
}
