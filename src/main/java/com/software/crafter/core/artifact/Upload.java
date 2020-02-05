package com.software.crafter.core.artifact;

/**
 *
 * @author Roman Zimnik
 * @version 1.0.0
 *
 */
public class Upload extends Artifact {

    private boolean zip;

    public boolean isZip() {
        return zip;
    }

    public void setZip(boolean zip) {
        this.zip = zip;
    }
}
