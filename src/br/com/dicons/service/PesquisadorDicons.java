package br.com.dicons.service;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.com.dicons.dominio.Dicon;

@Service
public class PesquisadorDicons {
	
	private File diconsDir;

	@Autowired
	public PesquisadorDicons(@Qualifier("diconsDir") File diconsDir) {
		this.diconsDir = diconsDir;
	}

	public List<Dicon> pesquisa(String numeroAtendimento) {
		FiltroDeArquivosPorAtendimento filtro = new FiltroDeArquivosPorAtendimento(numeroAtendimento);
		List<Dicon> listaDicons = new ArrayList<Dicon>();
		File[] listFiles = diconsDir.listFiles(filtro);
		for (File file : listFiles) {
			String cliente = file.getName().replaceAll("\\d", "");
			String diretorio = file.getName();
			listaDicons.add(new Dicon(numeroAtendimento, cliente, diretorio));
		}
		return listaDicons;
	}

}

class FiltroDeArquivosPorAtendimento implements FileFilter {

	private String numeroAtendimento;

	public FiltroDeArquivosPorAtendimento(String numeroAtendimento) {
		this.numeroAtendimento = numeroAtendimento;
	}

	@Override
	public boolean accept(File file) {
		return file.isDirectory() && file.getName().contains(numeroAtendimento);
	}
}
