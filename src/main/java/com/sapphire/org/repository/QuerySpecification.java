package com.sapphire.org.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.sapphire.org.model.Vendor;

public final class QuerySpecification {
	
	private QuerySpecification(){}
	
	public static Specification<Vendor> searchByVendorCriteria(Vendor _vendor) {
	
		return new Specification<Vendor>() {
				@Override
				public Predicate toPredicate(Root<Vendor> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
					// TODO Auto-generated method stub
				        if (_vendor == null && _vendor.getVname() == null && _vendor.getVname().isEmpty()) {
				          throw new IllegalStateException("Check Vendor Details");
				        }
				        List<Predicate> predicates = new ArrayList<Predicate>();
				      //  System.out.println(_VendorStaticModel.vname.getName());
				        predicates.add(builder.like(root.get("vname"), getContainsLikePattern(_vendor.getVname())));				    
				        Predicate[] predicatesArray = new Predicate[predicates.size()];
				        return builder.and(predicates.toArray(predicatesArray));
		
					}
			};
	
	}
	
	
	private static String getContainsLikePattern(String searchTerm) {
        if (searchTerm == null || searchTerm.isEmpty()) {
            return "%";
        }
        else {
            return "%" + searchTerm.toLowerCase() + "%";
        }
    }

}
