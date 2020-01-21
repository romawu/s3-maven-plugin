package com.software.crafter.core.artifact;

import com.software.crafter.core.artifact.Artifact;

public class Download extends Artifact {

    private boolean unzip;

    public boolean isUnzip() {
        return unzip;
    }

    public void setUnzip(boolean unzip) {
        this.unzip = unzip;
    }
}
