package com.haruatari.task35;

abstract public class Device {
    abstract protected int getBatteryPercentage();

    abstract protected String getName();

    public String getFullInfo() {
        return null; // TODO: Remove this line and put your code here.
    }

    public boolean needCharging() {
        return false; // TODO: Remove this line and put your code here.
    }
}
