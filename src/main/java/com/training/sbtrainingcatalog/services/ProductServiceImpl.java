package com.training.sbtrainingcatalog.services;

import com.training.sbtrainingcatalog.entities.Product;
import com.training.sbtrainingcatalog.exceptions.ResourceIsAlreadyTakenException;
import com.training.sbtrainingcatalog.exceptions.ResourceNotFoundException;
import com.training.sbtrainingcatalog.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;


    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("item","id",id));

        return product;
    }

    @Override
    public Product getProductByItemID(String itemID) {
        Product product = productRepository.findByItemID(itemID);
        if(product==null){
            throw new ResourceNotFoundException("item", "item ID", itemID);
        }
        return product;
    }


    @Transactional
    @Override
    public Product saveProduct(Product product) {
        Product productDB = productRepository.findByItemID(product.getItemID());
        if(productDB!=null){
            throw new ResourceIsAlreadyTakenException("item", "item ID", product.getItemID());
        }

        return productRepository.save(product);
    }

    @Override
    @Transactional
    public Product updateProduct(Product product,Long id) {
        Product productDB = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("item","id",id));

        Product productByNewExistInDB = productRepository.findByItemID(product.getItemID());
        if(productByNewExistInDB != null && productByNewExistInDB.getId()!=productDB.getId()){
            throw  new ResourceIsAlreadyTakenException("item", "item ID", product.getItemID());
        }

        productDB.setItemID(product.getItemID());
        productDB.setItemName(product.getItemName());
        productDB.setQuantity(product.getQuantity());
        productDB.setModifyDate(LocalDateTime.now());
        return productRepository.save(productDB);
    }
    @Transactional
    @Override
    public Long removeProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("item","id",id));
        productRepository.delete(product);
        return id;
    }
}
