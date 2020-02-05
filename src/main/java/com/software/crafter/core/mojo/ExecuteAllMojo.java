package com.software.crafter.core.mojo;

import com.software.crafter.util.MojoExecutorHelper;
import org.apache.maven.execution.MavenSession;
import org.apache.maven.plugin.BuildPluginManager;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Component;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.twdata.maven.mojoexecutor.MojoExecutor;

import static org.twdata.maven.mojoexecutor.MojoExecutor.*;

/**
 * This mojo executes both download goal and upload goal.
 * Generally just a wrapper, which calls both other two mojos.
 * @see com.software.crafter.core.mojo.DownloadMojo
 * @see com.software.crafter.core.mojo.UploadMojo
 *
 * @author Roman Zimnik
 * @version 1.0.0
 *
 */
@Mojo( name = "execute-all" )
public class ExecuteAllMojo extends AbstractCustomMojo {

    @Component
    private BuildPluginManager pluginManager;

    /**
     * The current Maven session.
     */
    @Parameter( defaultValue = "${session}", readonly = true )
    private MavenSession mavenSession;

    @Override
    public void execute() throws MojoExecutionException {

        executeDownloads();
        executeUploads();

    }

    private void executeDownloads() throws MojoExecutionException {

        MojoExecutor.executeMojo(
                plugin(
                        groupId("com.software.crafter"),
                        artifactId("s3-maven-plugin"),
                        version("1.0.0")
                ),
                goal("download"),
                configuration(
                        element("accessKey", this.accessKey),
                        element("secretKey", this.secretKey),
                        MojoExecutorHelper.getDownloadsElement(downloads)
                ),
                executionEnvironment(
                        this.mavenSession,
                        this.pluginManager
                ));
    }

    private void executeUploads() throws MojoExecutionException {

        MojoExecutor.executeMojo(
                plugin(
                        groupId("com.software.crafter"),
                        artifactId("s3-maven-plugin"),
                        version("1.0.0")
                ),
                goal("upload"),
                configuration(
                        element("accessKey", this.accessKey),
                        element("secretKey", this.secretKey),
                        MojoExecutorHelper.getUploadsElement(uploads)
                ),
                executionEnvironment(
                        this.mavenSession,
                        this.pluginManager
                ));
    }
}
