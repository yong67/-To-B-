package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Order;
import com.example.demo.entity.Product;
import com.example.demo.service.OrderService;
import com.example.demo.service.ProductService;


@Controller
public class ProductController {
	private ProductService productService;
	private OrderService orderService;
	
	public ProductController(ProductService productService, OrderService orderService) {
		super();
		this.productService = productService;
		this.orderService = orderService;
		inventoryInit();
	}
	
	private void inventoryInit() {
		if (!productService.existsByProductName("firewall")) {
	        Product product1 = new Product(1, "firewall", "500", 1);
	        productService.saveProduct(product1);
	    }

	    if (!productService.existsByProductName("security_cloud_service")) {
	        Product product3 = new Product(2, "security_cloud_service", "1000", 1);
	        productService.saveProduct(product3);
	    }

	    if (!productService.existsByProductName("Intrusion prevention systems")) {
	        Product product2 = new Product(3, "Intrusion prevention systems", "3000", 1);
	        productService.saveProduct(product2);
	    }

	    if (!productService.existsByProductName("DDoS attack defense")) {
	        Product product4 = new Product(4, "DDoS attack defense", "3000", 1);
	        productService.saveProduct(product4);
	    }
	}
	

	
	@GetMapping("/admin")
	public String listProducts(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		model.addAttribute("orders", orderService.getAllOrders());
		return "admin";
	}
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}
	
	
	@GetMapping("/feedback")
	public String feedback() {
		return "feedback";
	}
	
	@GetMapping("/pay_success")
	public String pay_success() {
		return "pay_success";
	}
	
	@GetMapping("/pay_fail")
	public String pay_fail() {
		return "pay_fail";
	}
	
	@GetMapping("/products")
	public String products() {
		return "products";
	}
	
	
	
	@GetMapping("/admin/DDOS")
	public String toDDOS(Model model) {
		Product product = productService.getProductByProductName("DDoS attack defense");
        model.addAttribute("product", product);
		return "DDOS";
	}
	
	@GetMapping("/admin/firewall")
	public String tofirewall(Model model) {
		Product product = productService.getProductByProductName("firewall");
        model.addAttribute("product", product);
		return "firewall";
	}
	
	@GetMapping("/admin/instrution_prevention")
	public String toinstruction_prevention(Model model) {
		Product product = productService.getProductByProductName("Intrusion prevention systems");
        model.addAttribute("product", product);
        return "instrution_prevention";
	}
	
	@GetMapping("/admin/security_cloud_service")
	public String tosecurity_cloud(Model model) {
		Product product = productService.getProductByProductName("security_cloud_service");
        model.addAttribute("product", product);
        return "security_cloud_service";
	}
	
	
	
	@GetMapping("/admin/edit/{id}")
	public String editProductForm(@PathVariable("id") Long id, Model model) {
		model.addAttribute("product", productService.getProductById(id));
		return "edit_product";
	}
	
	
	
	
	@GetMapping("/admin/firewall/payment/{name}")
	public String fpayment(@PathVariable("name") String name, Model model) {
		Order order = new Order();
		Product product= productService.getProductByProductName(name);
		model.addAttribute("product", product);
		order.setProductName(name);
		model.addAttribute("order", order);
		return "payment";
	}
	
	@GetMapping("/admin/DDOS/payment/{name}")
	public String dpayment(@PathVariable("name") String name, Model model) {
		Product product= productService.getProductByProductName(name);
		model.addAttribute("product", product);
		Order order = new Order();
		order.setProductName(name);
		model.addAttribute("order", order);
		return "payment";
	}
	@GetMapping("/admin/instrution_prevention/payment/{name}")
	public String ipayment(@PathVariable("name") String name, Model model) {
		Product product= productService.getProductByProductName(name);
		model.addAttribute("product", product);
		Order order = new Order();
		order.setProductName(name);
		model.addAttribute("order", order);
		return "payment";
	}
	@GetMapping("/admin/security_cloud_service/payment/{name}")
	public String spayment(@PathVariable("name") String name, Model model) {
		Product product= productService.getProductByProductName(name);
		model.addAttribute("product", product);
		Order order = new Order();
		order.setProductName(name);
		model.addAttribute("order", order);
		return "payment";
	}
	
	
	
	
	@PostMapping("/admin/{id}")
	public String updateProduct(@PathVariable("id") Long id,
			@ModelAttribute("product") Product product,
			Model model) {
		Product existingProduct = productService.getProductById(id);
		
		existingProduct.setPrice(product.getPrice());
		existingProduct.setQuantity(product.getQuantity());
		
		productService.updateProduct(existingProduct);
		return "redirect:/admin";
	}
	
	@PostMapping("/admin")
	public String saveOrder(@ModelAttribute("order") Order order, Model model)
	{
		Product existingProduct=productService.getProductByProductName(order.getProductName());
		if(existingProduct.getQuantity() >= order.getProductQuantity())
		{
			Long amount = existingProduct.getQuantity();
			amount = existingProduct.getQuantity()-order.getProductQuantity();
			existingProduct.setQuantity(amount);
			productService.saveProduct(existingProduct);
			orderService.saveOrder(order);
			model.addAttribute("order", order);
			return "pay_success";
		}
		
		return "pay_fail";
	}
}
