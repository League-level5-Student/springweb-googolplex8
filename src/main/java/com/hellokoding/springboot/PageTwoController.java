package com.hellokoding.springboot;

import java.util.ArrayList;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageTwoController {
	@RequestMapping("/p2")
	public String thing(Model model,
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		String scrambleName = scramble(name);
		model.addAttribute("scrambleName", scrambleName);
		return "thing";
	}

	@RequestMapping("/p3")
	public String bing() {
		return "thing";
	}

	public String scramble(String input) {
		char[] nerd = input.toCharArray();
		ArrayList<Character> chars = new ArrayList<Character>();
		for (int i = 0; i < input.length(); i++) {
			chars.add(nerd[i]);
		}
		Random rand = new Random();
		String output = "";
		int len = chars.size();
		int r = rand.nextInt(len);
		for (int i = 0; i < nerd.length; i++) {
			len = chars.size();
			r = rand.nextInt(len);
			output += chars.get(r);
			chars.remove(r);
		}
		return output;
	}
}
