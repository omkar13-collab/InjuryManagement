package com.Safety.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Safety.Model.Injury;
import com.Safety.Repository.InjuryRepository;

@Service
public class InjuryService {
   
	@Autowired
	InjuryRepository repo;
	
	
	public Injury addInjury(Injury injury) {
		
			// TODO Auto-generated method stub
			Injury inj=repo.save(injury);
			return inj;
		}


	public List<Injury> findallInjury() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}


	public Optional<Injury> findByInjuryId(int injuryId) {
		// TODO Auto-generated method stub
		return repo.findById(injuryId);
	}


	public Injury updateInjury(Injury injury) {
		// TODO Auto-generated method stub
		return repo.save(injury);
	}



		
	}