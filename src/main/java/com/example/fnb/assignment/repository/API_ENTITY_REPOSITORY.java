package com.example.fnb.assignment.repository;


import com.example.fnb.assignment.entity.API_ENTITY;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface API_ENTITY_REPOSITORY extends CrudRepository<API_ENTITY, Long> {
}
