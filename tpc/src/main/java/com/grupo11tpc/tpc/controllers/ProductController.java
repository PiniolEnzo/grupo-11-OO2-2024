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
		mAV.addObject("persons", productService.getAll());
		return mAV;
	}

	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PRODUCT_NEW);
		mAV.addObject("person", new ProductDTO());
		return mAV;
	}

	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("person") ProductDTO productDTO) {
		productService.insertOrUpdate(modelMapper.map(productDTO, Product.class));
		return new RedirectView(ViewRouteHelper.PRODUCT_ROOT);
	}

	@GetMapping("/{id}")
	public ModelAndView get(@PathVariable("id") int id) throws Exception {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PRODUCT_UPDATE);
		ProductDTO personDTO = modelMapper.map(productService.findById(id).get(), ProductDTO.class);
		mAV.addObject("person", personDTO);
		return mAV;
	}

//	@GetMapping("/partial/{id}")
//	public ModelAndView getPartial(@PathVariable("id") int id) throws Exception {
//		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PRODUCT_PARTIAL_VIEW);
//		ProductDTO personDTO = modelMapper.map(productService.findById(id).get(), ProductDTO.class);
//		mAV.addObject("person", personDTO);
//		return mAV;
//	}

	@GetMapping("/by_name/{name}")
	public ModelAndView getByName(@PathVariable("name") String name) throws Exception {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PRODUCT_UPDATE);
		ProductDTO personDTO = modelMapper.map(productService.findByName(name), ProductDTO.class);
		mAV.addObject("person", personDTO);
		return mAV;
	}

	@PostMapping("/update")
	public RedirectView update(@ModelAttribute("person") ProductDTO personDTO) throws Exception {
		Product personToUpdate = modelMapper.map(productService.findById(personDTO.getId()).get(), Product.class);
		if(personToUpdate != null ) {
			personToUpdate.setName(personDTO.getName());
			productService.insertOrUpdate(personToUpdate);
		}
		return new RedirectView(ViewRouteHelper.PRODUCT_ROOT);
	}

	@PostMapping("/delete/{id}")
	public RedirectView delete(@PathVariable("id") int id) {
		productService.remove(id);
		return new RedirectView(ViewRouteHelper.PRODUCT_ROOT);
	}
}
