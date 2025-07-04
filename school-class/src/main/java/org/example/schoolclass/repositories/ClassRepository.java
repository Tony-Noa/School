package org.example.schoolclass.repositories;

import org.example.schoolclass.models.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClassRepository extends JpaRepository<Class, UUID> {

}
