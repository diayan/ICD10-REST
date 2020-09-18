package com.diayan.ICD10RESTProject.web;

import com.diayan.ICD10RESTProject.entity.Diagnosis;
import com.diayan.ICD10RESTProject.repository.DiagnosisRepository;
import com.diayan.ICD10RESTProject.exception.CodeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class DiagnosisController {

    @Autowired
    DiagnosisRepository repository;

    @GetMapping("/diagnosisCodes")
    public List<Diagnosis> getAllCodes() {
        return repository.findAll();
    }

    @GetMapping("/diagnosisCode/{id}")
    ResponseEntity<Diagnosis> getDiagnosisCodeById(@PathVariable(value = "id") Long codeId)
            throws CodeNotFoundException {

        Diagnosis diagnosis = repository.findById(codeId)
                .orElseThrow(() -> new CodeNotFoundException("Diagnosis code not found for id:: " + codeId));

        return ResponseEntity.ok().body(diagnosis);
    }

    @PostMapping("/diagnosisCode")
    public Diagnosis createDiagnosisCode(@Valid @RequestBody Diagnosis diagnosis) {
        return repository.save(diagnosis);
    }

    @PutMapping("/diagnosisCode/{id}")
    public ResponseEntity<Diagnosis> updateDiagnosisCode(
            @PathVariable(value = "id") Long codeId,
            @Valid @RequestBody Diagnosis diagnosisDetails)
            throws CodeNotFoundException {

        Diagnosis diagnosisCode = repository.findById(codeId)
                .orElseThrow(() -> new CodeNotFoundException("Diagnosis code not found for id:: " + codeId));

        diagnosisCode.setId(diagnosisDetails.getId());
        diagnosisCode.setCode(diagnosisDetails.getCode());
        diagnosisCode.setTitle(diagnosisDetails.getTitle());
        final Diagnosis updateDiagnosisCode = repository.save(diagnosisCode);
        return ResponseEntity.ok(updateDiagnosisCode);
    }


    @DeleteMapping("/diagnosisCode/{id}")
    public Map<String, Boolean> deleteDiagnosisCode(@PathVariable(value = "id") Long codeId)
            throws CodeNotFoundException {
        Diagnosis diagnosisCode = repository.findById(codeId)
                .orElseThrow(() -> new CodeNotFoundException("Diagnosis code not found for id:: " + codeId));
        repository.delete(diagnosisCode);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
