package com.software.crafter.mojo.all;

import com.software.crafter.mojo.common.AbstractCustomMojo;
import com.software.crafter.mojo.download.Download;
import com.software.crafter.mojo.upload.Upload;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.util.List;

@Mojo( name = "execute-all" )
public class TotalMojo extends AbstractCustomMojo {

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        for(Download d : super.getDownloads()) {
            System.out.println(d.isExtract() + ", " + d.getFileName() + ", " + d.getBucketName() + ", " + d.getDownloadPath());
        }

        for(Upload u : super.getUploads()) {
            System.out.println(u.getFileName() + ", " + u.getBucketName() + ", " + u.getDownloadPath());
        }
    }
}
