package com.policysystem.springboot.service;

import com.policysystem.springboot.entity.Policy;
import com.policysystem.springboot.exceptions.PolicyNotFoundException;
import com.policysystem.springboot.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PolicyService {

    @Autowired
    PolicyRepository policyRepository;

    public Policy createPolicy(Policy policy){

        if(policy.getStartDate().isAfter(policy.getEndDate())){
            throw new IllegalArgumentException("The 'start date' cannot be older than the 'end date'.");
        }
        return policyRepository.save(policy);
    }

    public List<Policy> getAllPolicies(){
        return policyRepository.findAll();
    }

    public Optional<Policy> findById(Long id) throws PolicyNotFoundException {

        if (id == null){
            throw new IllegalArgumentException("The policy 'id' cannot be null.");
        }

        if(policyRepository.findById(id).isEmpty()){
            throw new PolicyNotFoundException("Policy not found.");
        }

        return policyRepository.findById(id);
    }

    public List<Policy> findByOp(Integer op) throws PolicyNotFoundException {

        if(policyRepository.findByOp(op).isEmpty()){
            throw new PolicyNotFoundException("Policy not found.");
        }

        return policyRepository.findByOp(op);
    }

    public void deletePolicy(Long id) throws Exception {
        Policy policy = policyRepository.findById(id).orElseThrow(() -> new Exception("It's not possible delete the policy specified."));
        policyRepository.deleteById(id);
    }

    public Policy updatePolicy(Policy policy){
        Optional<Policy> optionalPolicy = policyRepository.findById(policy.getId());
        if (optionalPolicy.isPresent()) {
            Policy policyFound = optionalPolicy.get();
            policyFound.setPolicyNumber(policy.getPolicyNumber());
            policyFound.setStartDate(policy.getStartDate());
            policyFound.setEndDate(policy.getEndDate());
            policyFound.setAmount(policy.getAmount());
            policyFound.setFolder(policy.getFolder());
            policyFound.setOp(policy.getOp());
            policyFound.setInsuranceCompany(policy.getInsuranceCompany());
            return policyRepository.save(policyFound);
        } else {
            throw new PolicyNotFoundException("Policy not found.");
        }
    }

}
