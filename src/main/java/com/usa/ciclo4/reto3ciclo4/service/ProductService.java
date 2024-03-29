package com.usa.ciclo4.reto3ciclo4.service;

import com.usa.ciclo4.reto3ciclo4.model.Product;
import com.usa.ciclo4.reto3ciclo4.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.getAll();
    }

    public Optional<Product> getProduct(int id){
        return productRepository.getProduct(id);
    }

    public Product save(Product product){
        if (product.getId()== null){
            return product;
        }
        return productRepository.save(product);
    }

    public Product update(Product product){
        if (product.getId()!= null){
            Optional<Product> dbProduct = productRepository.getProduct(product.getId());
            if (!dbProduct.isEmpty()){
                if (product.getBrand()!= null){
                    dbProduct.get().setBrand(product.getBrand());
                }
                
                
                if (product.getDescription() != null){
                    dbProduct.get().setDescription(product.getDescription());
                }
                if (product.getName()!= null){
                    dbProduct.get().setName(product.getName());
                }
                if (product.getCategory()!= null){
                    dbProduct.get().setCategory(product.getCategory());
                }

                dbProduct.get().setAvailability(product.isAvailability());

                if (product.getPrice()!= 0.0){
                    dbProduct.get().setPrice(product.getPrice());
                }
                if (product.getQuantity()!= 0){
                    dbProduct.get().setQuantity(product.getQuantity());
                }
                if (product.getPhotography()!= null){
                    dbProduct.get().setPhotography(product.getPhotography());
                }
                productRepository.update(dbProduct.get());
                return dbProduct.get();
            } else {
                return product;
            }
        } else {
            return product;
        }
    }

    public boolean delete(int id){
        return getProduct(id).map(product -> {
            productRepository.delete(product);
            return true;
        }).orElse(false);
    }

    public List<Product> getByPrice(double price){
        return productRepository.getByPrice(price);
    }
/**
 * 
 * @param description
 * @return 
 */
    public List<Product> getByDescriptionContains(String description){
        return productRepository.getByDescriptionContains(description);
    }
}
