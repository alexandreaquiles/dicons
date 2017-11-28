package br.com.dicons.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DiconsController {

	@RequestMapping("dicons")
	public String formularioPesquisa() {
		return "dicons/pesquisa";
	}

}
