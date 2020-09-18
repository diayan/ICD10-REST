package com.diayan.ICD10RESTProject.repository;

import com.diayan.ICD10RESTProject.entity.Diagnosis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DiagnosisRepository extends JpaRepository<Diagnosis, Long> {
}
