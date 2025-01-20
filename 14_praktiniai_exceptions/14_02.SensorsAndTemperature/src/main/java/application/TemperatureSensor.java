package application;

import java.util.Random;

public class TemperatureSensor implements Sensor {

    private boolean state = false;

    @Override
    public boolean isOn() {
        if(state == false) {
            return false;
        }
        return true;
    }

    @Override
    public void setOn() {
        state = true;
    }

    @Override
    public void setOff() {
        state = false;
    }

    @Override
    public int read() {
        if(state == false) {
            throw new IllegalStateException();
        }
        return new Random().nextInt(61) - 30;
    }
}
