package com.software.crafter.core.artifact;

public class Upload extends Artifact {

    private boolean zip;

    public boolean isZip() {
        return zip;
    }

    public void setZip(boolean zip) {
        this.zip = zip;
    }
}
