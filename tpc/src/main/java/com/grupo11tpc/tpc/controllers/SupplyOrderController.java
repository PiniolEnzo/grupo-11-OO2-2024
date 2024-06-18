package com.grupo11tpc.tpc.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.grupo11tpc.tpc.dtos.SupplyOrderDTO;
import com.grupo11tpc.tpc.helpers.ViewRouteHelper;
import com.grupo11tpc.tpc.services.IProductService;
import com.grupo11tpc.tpc.services.ISupplierService;
import com.grupo11tpc.tpc.services.ISupplyOrderService;


@Controller 
@RequestMapping("/supply-order") 
public class SupplyOrderController { 
	
	private ISupplyOrderService supplyOrderService;
	private IProductService productService; 
	private ISupplierService supplierService; 
	private ModelMapper modelMapper = new ModelMapper(); 
	
	public SupplyOrderController(ISupplyOrderService supplyOrderService, IProductService productService, ISupplierService supplierService) { 
		this.supplyOrderService = supplyOrderService; 
		this.productService = productService; 
		this.supplierService = supplierService; 
	} 
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/index") 
	public ModelAndView index() { 
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.SUPPLY_ORDER_INDEX); 
		mAV.addObject("supplyOrders", supplyOrderService.getAll()); 
		return mAV; 
	} 
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/new") 
	public ModelAndView create() { 
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.SUPPLY_ORDER_NEW); 
		mAV.addObject("supplyOrder", new SupplyOrderDTO()); 
		mAV.addObject("products", productService.getAll());
		mAV.addObject("suppliers",supplierService.getAll()); 
		return mAV; 
	}
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/create") 
	public RedirectView create(@ModelAttribute("supplyOrder") SupplyOrderDTO supplyOrderDto) { 
		supplyOrderService.insert(modelMapper.map(supplyOrderDto, SupplyOrderDTO.class)); 
		return new RedirectView(ViewRouteHelper.PRODUCT_ENTRY_INDEX); 
	} 
	
}
