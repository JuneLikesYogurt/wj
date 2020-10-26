package com.jun1.wj.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jun1.wj.dto.Category;

public interface CategoryDAO extends JpaRepository<Category, Integer>{
}
