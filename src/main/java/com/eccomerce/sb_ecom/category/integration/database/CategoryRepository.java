package com.eccomerce.sb_ecom.category.integration.database;

import com.eccomerce.sb_ecom.category.dto.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
