package com.driver.repositories;

import com.driver.RequestDto.AuthorRequestDto;
import com.driver.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
