package application;

import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor {

    private ArrayList<Sensor> sensors = new ArrayList<>();
    private List<Integer> integerList = new ArrayList<>();

    @Override
    public boolean isOn() {
        for(Sensor sensor : sensors) {
            if(sensor.isOn() == false) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void setOn() {
//        for(Sensor sensor : sensors) {
//            sensor.setOn();
//        }

        sensors.forEach(Sensor::setOn);
    }

    @Override
    public void setOff() {
//        for(Sensor sensor : sensors) {
//            sensor.setOff();
//        }

        sensors.forEach(Sensor::setOff);
    }

    @Override
    public int read() {
        if(!isOn() || sensors.isEmpty()) {
            throw new IllegalStateException();
        }

        int average = (int) sensors.stream().mapToInt(a -> a.read()).average().orElse(0);

        integerList.add(average);

        return average;
    }

    public void addSensor(Sensor toAdd) {
        sensors.add(toAdd);
    }

    public List<Integer> readings() {
        return integerList;
    }
}
