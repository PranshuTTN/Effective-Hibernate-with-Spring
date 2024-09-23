package com.entitytransitions.practice.service;

import com.entitytransitions.practice.entity.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
public class ProductService {
    private static final Logger LOG = LoggerFactory.getLogger(ProductService.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Product find(int id) {
        return entityManager.find(Product.class, id);
    }

    @Transactional
    public void decrementStock(int id) {
        Product product = entityManager.find(Product.class, id);
        product.setStock(product.getStock() - 1);
    }

    @Transactional
    public void create(int id, int stock) {
        Product product = new Product();
        product.setId(id).setStock(stock);
        entityManager.persist(product);
    }
}
