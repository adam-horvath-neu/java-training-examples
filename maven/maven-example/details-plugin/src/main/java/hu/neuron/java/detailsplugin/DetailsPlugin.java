package hu.neuron.java.detailsplugin;

/*
 * Copyright 2001-2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.logging.Log;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.codehaus.plexus.util.FileUtils;

@Mojo(name = "details", defaultPhase = LifecyclePhase.PROCESS_SOURCES)
public class DetailsPlugin extends AbstractMojo {

	@Parameter(property = "project.build.directory", required = true)
	private File outputDirectory;

	@Parameter(property = "project.build.sourceDirectory", required = true)
	private File sourceDirectory;

	@Parameter(property = "details.dateFormat", defaultValue = "yyyy.MM.dd hh:mm")
	private String dateFormat;

	private final Log log;

	public DetailsPlugin() {
		log = getLog();
	}

	@SuppressWarnings("unchecked")
	public void execute() throws MojoExecutionException {
		File f = outputDirectory;

		if (!f.exists()) {
			f.mkdirs();
		}

		File touch = new File(f, "deatils.txt");

		FileWriter w = null;
		try {

			List<String> fileNames = FileUtils.getFileNames(sourceDirectory,
					"**", null, true);
			if (fileNames != null && !fileNames.isEmpty()) {
				log.info("Founded " + fileNames.size() + " source file");
			} else {
				log.info("Not founded source file");
			}

			w = new FileWriter(touch);

			SimpleDateFormat dateFormatter = new SimpleDateFormat(dateFormat);
			w.write("Generated: " + dateFormatter.format(new Date()) + "\n");

			for (String fileName : fileNames) {
				w.write(FileUtils.normalize(fileName) + "\n");
			}

			log.info("Creating a file to " + touch.getAbsolutePath());
		} catch (IOException e) {
			throw new MojoExecutionException("Error creating file " + touch, e);
		} finally {
			if (w != null) {
				try {
					w.close();
				} catch (IOException e) {
					// ignore
				}
			}
		}
	}
}
