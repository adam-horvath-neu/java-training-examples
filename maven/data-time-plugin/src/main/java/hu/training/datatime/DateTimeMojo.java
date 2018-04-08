package hu.training.datatime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

@Mojo(name = "date")
public class DateTimeMojo extends AbstractMojo {

	@Parameter(property = "date.message", defaultValue = "Default message: ")
	private String message;

	public void execute() throws MojoExecutionException, MojoFailureException {
		System.out.println(
				message + "\nActual date: " + LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
	}

}
