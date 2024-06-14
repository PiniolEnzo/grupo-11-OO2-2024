package com.grupo11tpc.tpc.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.grupo11tpc.tpc.dtos.ProductDTO;
import com.grupo11tpc.tpc.dtos.ProductEntryDTO;
import com.grupo11tpc.tpc.helpers.ViewRouteHelper;
import com.grupo11tpc.tpc.services.IProductEntryService;
import com.grupo11tpc.tpc.services.IProductService;

@Controller
@RequestMapping("/stock")
public class ProductEntryController {
	
	private IProductService productService;
	private IProductEntryService productEntryService;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	public ProductEntryController(IProductService productService, IProductEntryService productEntryService) {
		super();
		this.productService = productService;
		this.productEntryService = productEntryService;
	}

	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PRODUCT_ENTRY_INDEX);
		//Se envian todos los productos para dar a elegir sobre cual hacer el alta de stock
		mAV.addObject("products", productService.getAll());
		return mAV;
	}

	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("stock") ProductEntryDTO productEntryDto) {
		productEntryService.saveProductEntry(modelMapper.map(productEntryDto, ProductEntryDTO.class));
		return new RedirectView(ViewRouteHelper.ROUTE);
	}

}
