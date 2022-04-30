package com.example.lab8.service;

import com.example.lab8.model.Product;
import com.example.lab8.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProducts() {
        return this.productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return this.productRepository.findById(id);
    }

    public Product createProduct(Product product){
        return this.productRepository.save(product);
    }

    public Product updateProduct(Long id, Product product){
        Optional<Product> product1 = this.productRepository.findById(id);
        if(product1.isPresent()){
           Product _product = product1.get();
           _product.setAmount(product.getAmount());
           _product.setDescription(product.getDescription());
           _product.setName(product.getName());
           _product.setPrice(product.getPrice());
           return this.productRepository.save(_product);
        }
        else{
            return null;
        }
    }

    public void deleteProduct(Long id){
        this.productRepository.deleteById(id);
    }
}
