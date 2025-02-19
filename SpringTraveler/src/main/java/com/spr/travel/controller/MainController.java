package com.spr.travel.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spr.travel.domain.Product;
import com.spr.travel.service.ProductService;

@Controller
@RequestMapping("/main/*")
public class MainController {

	@Autowired
	private ProductService productService;
	
	
	@GetMapping("/main.do")
	public String main(Model model, HttpServletRequest request, HttpServletResponse response)throws Exception {
		
		List<Product> list = productService.getProductList();
		
		model.addAttribute("list", list);
		
		return "main/main";
	}

}
