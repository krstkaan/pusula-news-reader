package com.example.pusula.Repository;

import com.example.pusula.DTO.CategoryDTO;
import com.example.pusula.Entity.Category;
import com.example.pusula.Entity.User;

public interface CategoryDAO   {
    Category findById(int id);
    void createCategory(Category category);
    void updateCategory(Category category);

}
