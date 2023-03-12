package com.policysystem.springboot.controller;


import com.policysystem.springboot.entity.Policy;
import com.policysystem.springboot.repository.PolicyRepository;
import com.policysystem.springboot.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/policies")
@CrossOrigin(origins = "http://localhost:8080")
public class PolicyController {

    @Autowired
    private PolicyService policyService;

    @PostMapping
    public ResponseEntity<?> createPolicy(@RequestBody Policy policy){
        policyService.createPolicy(policy);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(policy.getId())
                .toUri();
        return ResponseEntity.created(location).body(policy);
    }

    @GetMapping
    public ResponseEntity<?> getAllPolicies(){
        return ResponseEntity.ok(policyService.getAllPolicies());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(policyService.findById(id));
    }


    @GetMapping("/op/{op}")
    public ResponseEntity<?> findByOp(@PathVariable Integer op){
        return ResponseEntity.ok(policyService.findByOp(op));
    }

    @PutMapping
    public ResponseEntity<?> updatePolicy(@RequestBody Policy policy){
        return ResponseEntity.ok(policyService.updatePolicy(policy));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePolicy(@PathVariable Long id) throws Exception {
        policyService.deletePolicy(id);
        return ResponseEntity.noContent().build();
    }

}
