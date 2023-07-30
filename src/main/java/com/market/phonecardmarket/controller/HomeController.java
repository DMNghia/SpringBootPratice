package com.market.phonecardmarket.controller;

import com.market.phonecardmarket.dto.ProductDTO;
import com.market.phonecardmarket.dto.SupplierDTO;
import com.market.phonecardmarket.service.IProductService;
import com.market.phonecardmarket.service.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class HomeController {

    private final ISupplierService supplierService;
    private final IProductService productService;
    @Autowired
    public HomeController(ISupplierService supplierService, IProductService productService) {
        this.supplierService = supplierService;
        this.productService = productService;
    }


    @GetMapping("/home")
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView("/home");
        List<SupplierDTO> listSupplier = supplierService.getAllSupplier();
        List<ProductDTO> listProduct = productService.getAllProductBySupplier(1);

        mav.addObject("listSupplier", listSupplier);
        mav.addObject("listProduct", listProduct);

        return mav;
    }
}
