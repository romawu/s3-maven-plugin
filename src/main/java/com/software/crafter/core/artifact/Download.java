package com.software.crafter.core.artifact;

/**
 *
 * @author Roman Zimnik
 * @version 1.0.0
 *
 */
public class Download extends Artifact {

    private boolean unzip;

    public boolean isUnzip() {
        return unzip;
    }

    public void setUnzip(boolean unzip) {
        this.unzip = unzip;
    }
}
