package br.com.dicons.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CompactadorDicons {

	private File diconsDir;
	private File diconsZipsDir;

	@Autowired
	public CompactadorDicons(@Qualifier("diconsDir") File diconsDir,
			@Qualifier("diconsZipsDir") File diconsZipsDir) {
		this.diconsDir = diconsDir;
		this.diconsZipsDir = diconsZipsDir;
	}

	public File compacta(String diretorio) {

		try {
			File entradaDir = new File(diconsDir, diretorio);
			File zipSaidaFile = new File(diconsZipsDir, diretorio + ".zip");
			try (FileOutputStream zipOS = new FileOutputStream(zipSaidaFile);
					ZipOutputStream zipSaida = new ZipOutputStream(zipOS)) {
				if (!entradaDir.isDirectory()) {
					throw new RuntimeException("Deveria ser diretório: " + entradaDir);
				}
				File[] arquivos = entradaDir.listFiles();
				for (File arquivo : arquivos) {
					try (FileInputStream arquivoIS = new FileInputStream(arquivo);) {
						ZipEntry zipEntry = new ZipEntry(arquivo.getName());
						zipSaida.putNextEntry(zipEntry);
						byte[] bytes = new byte[1024];
						int length;
						while ((length = arquivoIS.read(bytes)) >= 0) {
							zipSaida.write(bytes, 0, length);
						}
					}
				}
			}
			return zipSaidaFile;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
