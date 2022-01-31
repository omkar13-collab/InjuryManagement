package com.Safety.Controller;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Safety.Exception.RecordNotFoundException;
import com.Safety.Model.Injury;
import com.Safety.Service.InjuryService;


@RestController
@RequestMapping("/injury")
public class InjuryRestController {
	
	
	@Autowired
	InjuryService injuryService;
	
	@PostMapping("/addinjury")
	
		
		public ResponseEntity<Injury> addInjury(@Validated @RequestBody Injury injury)
		{
			Injury e= injuryService.addInjury(injury);
//				System.out.println(e);
//		return ResponseEntity<>.ok.body("new employee added sucessfully");
			return new ResponseEntity<Injury>(e,HttpStatus.OK);
}
	
	@GetMapping
	public ResponseEntity<List<Injury>> fetchAllInjury(){
		List<Injury> injury=injuryService.findallInjury();
		return ResponseEntity.ok().body(injury);
	}
	@GetMapping("/{injuryId}")
	public ResponseEntity<List<Injury>> getInjuryById(@PathVariable int injuryId){
		
		Optional<Injury> injury = injuryService.findByInjuryId(injuryId);
		if(injury.isPresent()) {
			return new ResponseEntity(injury.get(), HttpStatus.OK);
		}
		else {
			throw new RecordNotFoundException("Record not found...");
		}
	}
	@PutMapping("/{injuryId}")
	public ResponseEntity<Injury> updateInjury(@PathVariable int injuryId, @RequestBody Injury injury){
		Injury e=injuryService.updateInjury(injury);
		return new ResponseEntity<Injury>(e,HttpStatus.OK);
	}


}