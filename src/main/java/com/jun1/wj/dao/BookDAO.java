package com.jun1.wj.dao;

import com.jun1.wj.dto.Book;
import com.jun1.wj.dto.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/* JPA 提供了包括增删改查等在内的常用功能，且易于扩展
*  JPA 让我们解脱了 DAO 层的操作，基本上所有 CRUD 都可以依赖于它来实现*/

public interface BookDAO extends JpaRepository<Book,Integer>{
    List<Book> findAllByCategory(Category category);
    List<Book> findAllByTitleLikeOrAuthorLike(String keyword1, String keyword2);
}
