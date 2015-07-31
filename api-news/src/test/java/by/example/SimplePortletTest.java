package by.example;

import by.example.simpleportlet.dao.domain.Category;
import by.example.simpleportlet.dao.jpa.CategoryRepository;
import by.example.simpleportlet.dao.jpa.LinkRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = by.example.simpleportlet.config.PersistenceConfig.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
public class SimplePortletTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void test1() {
        categoryRepository.save(new Category());
    }

}
