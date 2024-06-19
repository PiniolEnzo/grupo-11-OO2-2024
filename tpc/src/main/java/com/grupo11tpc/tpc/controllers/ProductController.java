package com.grupo11tpc.tpc.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.grupo11tpc.tpc.services.IProductService;
import com.grupo11tpc.tpc.dtos.ProductDTO;
import com.grupo11tpc.tpc.entities.Product;
import com.grupo11tpc.tpc.helpers.ViewRouteHelper;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	public IProductService productService;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	public ProductController(IProductService productService) {
		this.productService=productService;
	}
	
	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PRODUCT_INDEX);
		mAV.addObject("products", productService.getAll());
		return mAV;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PRODUCT_NEW);
		mAV.addObject("product", new Product());
		return mAV;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/create")
	public RedirectView create(Product product) {
		productService.insertOrUpdate(product);
		return new RedirectView(ViewRouteHelper.PRODUCT_ROOT);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/{id}")
	public ModelAndView get(@PathVariable("id") int id) throws Exception {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PRODUCT_UPDATE);
		Product product = productService.findById(id).get();
		mAV.addObject("product", product);
		return mAV;
	}

//	@GetMapping("/partial/{id}")
//	public ModelAndView getPartial(@PathVariable("id") int id) throws Exception {
//		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PRODUCT_PARTIAL_VIEW);
//		ProductDTO productDTO = modelMapper.map(productService.findById(id).get(), ProductDTO.class);
//		mAV.addObject("product", productDTO);
//		return mAV;
//	}

	@GetMapping("/by_name/{name}")
	public ModelAndView getByName(@PathVariable("name") String name) throws Exception {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PRODUCT_UPDATE);
		ProductDTO productDTO = modelMapper.map(productService.findByName(name), ProductDTO.class);
		mAV.addObject("product", productDTO);
		return mAV;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/update")
	public RedirectView update(Product product) throws Exception {
		Product productToUpdate = productService.findById(product.getId()).get();
		if(productToUpdate != null ) {
			productToUpdate.setName(product.getName());
			productToUpdate.setDescription(product.getDescription());
			productToUpdate.setAmount(product.getAmount());
			productToUpdate.setMinimalAmount(product.getMinimalAmount());
			productToUpdate.setPurchaseCost(product.getPurchaseCost());
			productToUpdate.setSalePrice(product.getSalePrice());
			productService.insertOrUpdate(productToUpdate);
		}
		return new RedirectView(ViewRouteHelper.PRODUCT_ROOT);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/delete/{id}")
	public RedirectView delete(@PathVariable("id") int id) {
		productService.remove(id);
		return new RedirectView(ViewRouteHelper.PRODUCT_ROOT);
	}
}
