package com.training.sbtrainingcatalog.controllers;

import com.training.sbtrainingcatalog.entities.Catalog;
import com.training.sbtrainingcatalog.entities.Product;
import com.training.sbtrainingcatalog.exceptions.ResourceNotFoundException;
import com.training.sbtrainingcatalog.models.ProductDto;
import com.training.sbtrainingcatalog.services.CatalogService;
import com.training.sbtrainingcatalog.services.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
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

    @GetMapping("{id}")
    public ProductDto getProduct(@PathVariable Long id){
        Product product = productService.getProduct(id);
        return modelMapper.map(product,ProductDto.class);
    }

    @PostMapping
    public ProductDto saveProduct(@RequestBody @Valid ProductDto productDto){
        List<Long> catalogIds = catalogService.getCatalogIds();

        if(!catalogIds.contains(productDto.getCatalogId())){
            throw new ResourceNotFoundException("Catalog","id",productDto.getCatalogId());
        }

        Product product = modelMapper.map(productDto,Product.class);


        Catalog catalog = catalogService.getCatalog(productDto.getCatalogId());
        product.setCatalog(catalog);

        Product productRes = productService.saveProduct(product);
        ProductDto productDtoRes = modelMapper.map(productRes,ProductDto.class);

        return productDtoRes;
    }

    @PutMapping("{id}")
    public ProductDto updateProduct(@RequestBody @Valid ProductDto productDto, @PathVariable Long id){
        List<Long> catalogIds = catalogService.getCatalogIds();

        if(!catalogIds.contains(productDto.getCatalogId())){
            throw new ResourceNotFoundException("Catalog","id",productDto.getCatalogId());
        }

        Product product = modelMapper.map(productDto,Product.class);

        Product productRes = productService.updateProduct(product,id);
        ProductDto productDtoRes = modelMapper.map(productRes,ProductDto.class);

        return productDtoRes;
    }

    @DeleteMapping("{id}")
    public Long removeProduct(@PathVariable Long id){
        return productService.removeProduct(id);
    }
}
