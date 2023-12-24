package com.JDBCTemplate.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.JDBCTemplate.Model.Book;

@Repository
public interface BooksRepository extends JpaRepository<Book, Integer> {

     Book findByBookName(String bookName);
}
