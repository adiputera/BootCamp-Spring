package com.xsis.batch137.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xsis.batch137.model.Customer;
import com.xsis.batch137.model.Order;
import com.xsis.batch137.service.CustomerService;
import com.xsis.batch137.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	OrderService os;
	
	@Autowired
	CustomerService cs;
	
	@RequestMapping
	public String index(@RequestParam("customer") String id, Model model) {
		Customer cust = cs.getCustomerById(id);
		List<Order> dataOrder = os.searchOrderByCustomer(cust);
		model.addAttribute("customer", cust);
		model.addAttribute("orders", dataOrder);
		float totalHarga = 0;
		int totalItem = 0;
		
		for(Order order : dataOrder) {
			float total = order.getBarang().getHarga() * order.getJumlahBeli();
			totalHarga = totalHarga + total;
			totalItem = totalItem+1;
		}
		model.addAttribute("totalHarga", totalHarga);
		model.addAttribute("totalItem", totalItem);
		return "daftar-order";
	}
}
