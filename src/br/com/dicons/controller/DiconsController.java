package br.com.dicons.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.dicons.dominio.Dicon;
import br.com.dicons.service.PesquisadorDicons;

@Controller
public class DiconsController {

	@Autowired
	private PesquisadorDicons pesquisador;

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

}
