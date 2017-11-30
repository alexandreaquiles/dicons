package br.com.dicons.service;

import java.io.File;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Dirs {

	private static final Logger logger = Logger.getLogger(Dirs.class);

	private File diconsDir;
	private File diconsZipsDir;

	@Autowired
	public Dirs(@Value("${diconsDir}") String diconsDirName, @Value("${diconsZipDir}") String diconsZipDirName) {
		this.diconsDir = new File(diconsDirName);
		this.diconsZipsDir = new File(diconsZipDirName);
		if (!this.diconsZipsDir.exists()) {
			logger.warn("Criando diretório: " + this.diconsZipsDir.getPath());
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
