package com.training.sbtrainingcatalog.services;

import com.training.sbtrainingcatalog.entities.Product;
import com.training.sbtrainingcatalog.exceptions.CatalogAlreadyExists;
import com.training.sbtrainingcatalog.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;


    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository.findProductById(id);
    }

    @Override
    public Product saveProduct(Product product) {
        Product productDB = productRepository.findByItemID(product.getItemID());
        if(productDB!=null){
            throw  new CatalogAlreadyExists();
        }
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product,Long id) {
        Product productDB = productRepository.findProductById(id);
        if(productDB==null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }

        Product productByNewExistInDB = productRepository.findByItemID(product.getItemID());
        if(productByNewExistInDB != null && productByNewExistInDB.getId()!=productDB.getId()){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Product already existed"
            );
        }

        productDB.setItemID(product.getItemID());
        productDB.setItemName(product.getItemName());
        productDB.setModifyDate(LocalDateTime.now());
        return productRepository.save(productDB);
    }

    @Override
    public Long removeProduct(Long id) {
        Product product = productRepository.findProductById(id);
        if(product==null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }
        productRepository.delete(product);
        return id;
    }
}
