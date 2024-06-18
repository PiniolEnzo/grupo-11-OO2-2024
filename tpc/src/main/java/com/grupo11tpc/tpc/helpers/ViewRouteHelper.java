package com.grupo11tpc.tpc.helpers;

public class ViewRouteHelper {
	/**** Views ****/
	//PRODUCTO
	public final static String PRODUCT_INDEX = "product/index";
	public final static String PRODUCT_NEW = "product/new";
	public final static String PRODUCT_UPDATE = "product/update";
	public final static String PRODUCT_REPORT = "product/report";
	
	//STOCK
	public final static String PRODUCT_ENTRY_INDEX = "/stock/index";
	public final static String PRODUCT_ENTRY_NEW = "/stock/new";

	//VENTA
	public final static String PRODUCT_SALE_INDEX = "/sale/index";
	public final static String PRODUCT_SALE_NEW  = "/sale/new";
	
	//LOGIN
	public final static String USER_LOGIN  = "/login/";

	//PEDIDO DE APROVISIONAMIENTO
	public final static String SUPPLY_ORDER_INDEX = "/supply_order/index";
	public final static String SUPPLY_ORDER_NEW = "/supply_order/new";
	
	/**** Redirects ****/
	public final static String ROUTE = "/index";
	public final static String PRODUCT_ROOT = "/product";
}