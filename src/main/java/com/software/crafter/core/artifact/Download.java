package com.software.crafter.core.artifact;

public class Download extends Artifact {

    private boolean unzip;

    public boolean isUnzip() {
        return unzip;
    }

    public void setUnzip(boolean unzip) {
        this.unzip = unzip;
    }
}
