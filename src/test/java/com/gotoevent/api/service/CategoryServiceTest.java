package com.gotoevent.api.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gotoevent.api.entity.Category;
import com.gotoevent.api.repository.CategoryRepository;

@RunWith(SpringJUnit4ClassRunner.class)
public class CategoryServiceTest {
	
	@Mock
	private CategoryRepository categoryRepository;
	
	@InjectMocks
	private CategoryService categoryService;
	
	Category category = new Category(1, "CategoriaTest");
	
	@Test
    public void addTest()throws Exception {
        when(this.categoryRepository.save(this.category)).thenReturn(this.category);
        
        Category testCategory = this.categoryService.newObject(this.category);
        assertEquals(1,testCategory.getId());
        assertEquals("CategoriaTest", testCategory.getName());
        
    }
	
	@Test
    public void getByIdTest()throws Exception {
        when(this.categoryRepository.findById(this.category.getId())).thenReturn(java.util.Optional.ofNullable(this.category));
        
        Category testCategory =this.categoryService.getById(this.category.getId());        
        assertEquals(1, testCategory.getId());
        assertEquals("CategoriaTest", testCategory.getName());
 
    }	

}
