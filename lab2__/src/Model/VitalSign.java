/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author barryzhu
 */
public class VitalSign {
    
    String date;
    float temperature;
    double bloodPressure;
    int pulse;
    boolean isConscious; // 注意拼写，推荐用 isConscious 而不是 isConcious

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public double getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(double bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public int getPulse() {
        return pulse;
    }

    public void setPulse(int pulse) {
        this.pulse = pulse;
    }

    public boolean isConscious() {
        return isConscious;
    }

    public void setConscious(boolean isConscious) {
        this.isConscious = isConscious;
        
    }
    @Override
public String toString() {
    return getDate();
}

}

    
