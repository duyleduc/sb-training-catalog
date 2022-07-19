package com.training.sbtrainingcatalog.controllers;

import com.training.sbtrainingcatalog.entities.Catalog;
import com.training.sbtrainingcatalog.entities.Product;
import com.training.sbtrainingcatalog.models.ProductDto;
import com.training.sbtrainingcatalog.services.CatalogService;
import com.training.sbtrainingcatalog.services.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/protected/products")
@RequiredArgsConstructor
@Slf4j
public class ProductController {
    private final ProductService productService;
    private final CatalogService catalogService;
    private final ModelMapper modelMapper;

    @GetMapping
    public List<ProductDto> getProducts(){
        List<Product> products = productService.getProducts();

        return products.stream().map(product -> modelMapper.map(product,ProductDto.class)).collect(Collectors.toList());
    }

    @GetMapping("{itemID}")
    public ProductDto getProduct(@PathVariable String itemID){
        Product product = productService.getProduct(itemID);
        return modelMapper.map(product,ProductDto.class);
    }

    @PostMapping
    public ProductDto saveProduct(@RequestBody ProductDto productDto){
        List<String> catalogID = catalogService.getCatalogIDs();

        if(!catalogID.contains(productDto.getCatalogID())){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }

        Product product = modelMapper.map(productDto,Product.class);


        Catalog catalog = catalogService.getCatalog(productDto.getCatalogID());
        product.setCatalog(catalog);

        Product productRes = productService.saveProduct(product);
        ProductDto productDtoRes = modelMapper.map(productRes,ProductDto.class);

        return productDtoRes;
    }

    @PutMapping("{itemID}")
    public ProductDto updateProduct(@RequestBody ProductDto productDto,@PathVariable String itemID){
        List<String> catalogID = catalogService.getCatalogIDs();

        if(!catalogID.contains(productDto.getCatalogID())){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }

        Product product = modelMapper.map(productDto,Product.class);
        product.setItemID(itemID);

        Product productRes = productService.updateProduct(product);
        ProductDto productDtoRes = modelMapper.map(productRes,ProductDto.class);

        return productDtoRes;
    }

    @DeleteMapping("{itemID}")
    public String removeProduct(@PathVariable String itemID){
        return productService.removeProduct(itemID);
    }
}
