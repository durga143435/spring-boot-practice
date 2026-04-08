package com.example.unit_test_practice.repositories;

import com.codewithmosh.store.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Byte> {
}