package com.grupo11tpc.tpc.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.grupo11tpc.tpc.dtos.ProductEntryDTO;
import com.grupo11tpc.tpc.helpers.ViewRouteHelper;
import com.grupo11tpc.tpc.services.IProductEntryService;
import com.grupo11tpc.tpc.services.IProductService;
import com.grupo11tpc.tpc.services.ISupplierService;

@Controller
@RequestMapping("/stock")
public class ProductEntryController {
	
	private IProductService productService;
	private IProductEntryService productEntryService;
	private ISupplierService supplierService;
	
	private ModelMapper modelMapper = new ModelMapper();
	

	public ProductEntryController(IProductService productService, IProductEntryService productEntryService,
			ISupplierService supplierService) {
		this.productService = productService;
		this.productEntryService = productEntryService;
		this.supplierService = supplierService;
	}

	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PRODUCT_ENTRY_INDEX);
		//Se envia el historico de altas de stock
		mAV.addObject("productEntries", productEntryService.getAll());
		return mAV;
	}
	
	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PRODUCT_ENTRY_NEW);
		mAV.addObject("stock", new ProductEntryDTO());
		mAV.addObject("products", productService.getAll());
		mAV.addObject("suppliers",supplierService.getAll());
		return mAV;
	}

	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("stock") ProductEntryDTO productEntryDto) {
		productEntryService.saveProductEntry(modelMapper.map(productEntryDto, ProductEntryDTO.class));
		return new RedirectView(ViewRouteHelper.PRODUCT_ENTRY_INDEX);
	}

}
