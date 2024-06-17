package com.grupo11tpc.tpc.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.grupo11tpc.tpc.dtos.ProductEntryDTO;
import com.grupo11tpc.tpc.dtos.ProductSaleDTO;
import com.grupo11tpc.tpc.helpers.ViewRouteHelper;
import com.grupo11tpc.tpc.services.IProductEntryService;
import com.grupo11tpc.tpc.services.IProductSaleService;
import com.grupo11tpc.tpc.services.IProductService;
import com.grupo11tpc.tpc.services.ISupplierService;

@Controller
@RequestMapping("/sale")
public class ProductSaleController {
	
	private IProductService productService;
	private IProductSaleService productSaleService;
	
	private ModelMapper modelMapper = new ModelMapper();


	public ProductSaleController(IProductService productService, IProductSaleService productSaleService) {
		super();
		this.productService = productService;
		this.productSaleService = productSaleService;
	}

	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PRODUCT_SALE_INDEX);
		mAV.addObject("products", productService.getAll());
		return mAV;
	}
	
	@GetMapping("/new/{productId}")
	public ModelAndView create(@PathVariable int productId) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PRODUCT_SALE_NEW);
		ProductSaleDTO ps = new ProductSaleDTO();
		ps.setProductId(productId);
		mAV.addObject("productSaleDto",ps);
		return mAV;
	}

	//Generar compra de productos
	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("productSaleDto") ProductSaleDTO productSaleDto) {
		try {
			System.out.println(productSaleDto.getProductId() + " " +productSaleDto.getAmount() );
			productSaleService.sale(productSaleDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new RedirectView(ViewRouteHelper.PRODUCT_SALE_INDEX);
	}
	
}
