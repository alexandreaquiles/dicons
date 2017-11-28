package br.com.dicons.service;

import java.io.File;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Dirs {

	private File diconsDir;
	private File diconsZipsDir;

	public Dirs() {
		String usuarioDirName = System.getProperty("user.home");
		this.diconsDir = new File(usuarioDirName + File.separator + "dicons");
		this.diconsZipsDir = new File(usuarioDirName + File.separator + "dicons-zips");
		if (!this.diconsZipsDir.exists()) {
			System.out.println("Criando diretório: " + this.diconsZipsDir.getPath());
			this.diconsZipsDir.mkdirs();
		}
	}

	@Bean(name = "diconsDir")
	public File getDiconsDir() {
		return diconsDir;
	}

	@Bean(name = "diconsZipsDir")
	public File getDiconsZipsDir() {
		return diconsZipsDir;
	}

}
