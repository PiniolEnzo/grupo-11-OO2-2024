package com.grupo11tpc.tpc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.grupo11tpc.tpc.entities.Supplier;
import com.grupo11tpc.tpc.helpers.ViewRouteHelper;
import com.grupo11tpc.tpc.services.ISupplierService;

@Controller
@RequestMapping("/supplier")
public class SupplierController {
	public ISupplierService supplierService; 
	
	public SupplierController(ISupplierService supplierService) {
		this.supplierService = supplierService;
	}
	
	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.SUPPLIER_INDEX);
		mAV.addObject("suppliers", supplierService.getAll());
		return mAV;
	}
	
	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.SUPPLIER_NEW);
		mAV.addObject("supplier", new Supplier());
		return mAV;
	}

	@PostMapping("/create")
	public RedirectView create(Supplier supplier) {
		supplierService.insertOrUpdate(supplier);
		return new RedirectView(ViewRouteHelper.SUPPLIER_ROOT);
	}
	
	@PostMapping("/update")
	public RedirectView update(Supplier supplier) throws Exception {
		Supplier supplierToUpdate = supplierService.findById((int) supplier.getId()).get();
		if(supplierToUpdate != null ) {
			supplierToUpdate.setName(supplier.getName());
			supplierToUpdate.setLastname(supplier.getLastname());
			supplierToUpdate.setPhoneNumber(supplier.getPhoneNumber());
			supplierService.insertOrUpdate(supplierToUpdate);
		}
		return new RedirectView(ViewRouteHelper.SUPPLIER_ROOT);
	}

	@PostMapping("/delete/{id}")
	public RedirectView delete(@PathVariable("id") int id) {
		supplierService.remove(id);
		return new RedirectView(ViewRouteHelper.SUPPLIER_ROOT);
	}
	
}
