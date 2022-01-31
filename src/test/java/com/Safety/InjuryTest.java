package com.Safety;

	import java.lang.Package;
	import static org.junit.jupiter.api.Assertions.assertEquals;
	import static org.mockito.Mockito.when;

	import java.util.Date;
	import java.util.List;
	import java.util.stream.Collectors;
	import java.util.stream.Stream;

	import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.stubbing.OngoingStubbing;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.test.context.SpringBootTest;
	import org.springframework.boot.test.mock.mockito.MockBean;
	import org.springframework.test.context.junit4.SpringRunner;

import com.Safety.Model.Injury;
import com.Safety.Repository.InjuryRepository;
import com.Safety.Service.InjuryService;


	@RunWith(SpringRunner.class)
	@SpringBootTest
	public class InjuryTest {
		@MockBean
		InjuryRepository repository;
		
		@Autowired
		InjuryService service;

		@Test
		 public void getAllInjuryTest() {
			
			
		
			OngoingStubbing<List<Injury>> thenReturn = when(repository.findAll()).thenReturn
					(Stream.of( new Injury(1, "collapse")).collect(Collectors.toList()));       
			assertEquals(1,service.findallInjury().size());
		}
		
		@Test
		public void saveInjury() {
			Injury injury =new Injury(1, "collapse");
			when(repository.save(injury)).thenReturn(injury);
			assertEquals(injury,service.addInjury(injury));
		}

}