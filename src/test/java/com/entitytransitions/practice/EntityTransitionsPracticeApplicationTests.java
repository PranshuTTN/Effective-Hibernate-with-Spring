package com.entitytransitions.practice;

import com.entitytransitions.practice.entity.Product;
import com.entitytransitions.practice.service.ProductService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EntityTransitionsPracticeApplicationTests {
	private static final Logger LOG = LoggerFactory.getLogger(EntityTransitionsPracticeApplicationTests.class);

	@Autowired
	ProductService productService;

	@Test
	void testUpdateMerging() {
		LOG.info("Decrementing the stock value");
		productService.decrementStock(1);
		LOG.info("Loading product again");
		Product productAgain = productService.find(1);
		LOG.info("Product stock is {}",productAgain.getStock());
	}

	@Test
	void testInsertMerging() {
		productService.create(2,10);
	}

}
