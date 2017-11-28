package br.com.dicons.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.dicons.dominio.Dicon;
import br.com.dicons.service.CompactadorDicons;
import br.com.dicons.service.PesquisadorDicons;

@Controller
public class DiconsController {

	@Autowired
	private PesquisadorDicons pesquisador;

	@Autowired
	private CompactadorDicons compactador;

	@RequestMapping("dicons")
	public String formularioPesquisa() {
		return "dicons/pesquisa";
	}

	@RequestMapping("dicons/pesquisa")
	public String pesquisaDicons(@RequestParam("numeroAtendimento") String numeroAtendimento, Model model) {
		List<Dicon> lista = pesquisador.pesquisa(numeroAtendimento);
		model.addAttribute("dicons", lista);
		return "dicons/lista";
	}

	@RequestMapping(value = "dicons/download", produces = "application/zip")
	public HttpEntity<FileSystemResource> pesquisaDicons(@RequestParam("diretorio") String diretorio) {
		File zip = compactador.compacta(diretorio);
		HttpHeaders header = new HttpHeaders();
		header.setContentDispositionFormData("attachment", zip.getName().replace(" ", "_"));
		return new HttpEntity<FileSystemResource>(new FileSystemResource(zip), header);
	}

}
