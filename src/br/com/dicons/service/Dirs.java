package br.com.dicons.service;

import java.io.File;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Dirs {

	private File diconsDir;

	public Dirs() {
		String usuarioDirName = System.getProperty("user.home");
		this.diconsDir = new File(usuarioDirName + File.separator + "dicons");
	}

	@Bean(name = "diconsDir")
	public File getDiconsDir() {
		return diconsDir;
	}

}
