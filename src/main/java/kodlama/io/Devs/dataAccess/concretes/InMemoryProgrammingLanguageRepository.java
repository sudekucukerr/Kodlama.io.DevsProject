package kodlama.io.Devs.dataAccess.concretes;

import java.util.ArrayList;

import java.util.List;

import org.springframework.stereotype.Repository;

import kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Repository
public class InMemoryProgrammingLanguageRepository implements ProgrammingLanguageRepository {

	List<ProgrammingLanguage> languages;
	
	public InMemoryProgrammingLanguageRepository() {
		languages = new ArrayList<ProgrammingLanguage>();
		languages.add(new ProgrammingLanguage(1, "C#"));
		languages.add(new ProgrammingLanguage(2, "Java"));
		languages.add(new ProgrammingLanguage(3, "Python"));
		languages.add(new ProgrammingLanguage(4, "Javascript"));
		
		
	}
	
	
	@Override
	public List<ProgrammingLanguage> getAll() {
		return languages;
	} 

	@Override
	public ProgrammingLanguage getById(int id) {
		for(ProgrammingLanguage language : languages) {
			if(language.getId()== id) {
		
		return language;
			}
		}
		return null; 
	}
		

	@Override
	public void add(ProgrammingLanguage programmingLanguage) {
		languages.add(programmingLanguage);
		
	}
 
	@Override
	public void delete(int id) {
		languages.removeIf(language->language.getId()==id);
		
	}

	@Override
	public void update(ProgrammingLanguage programmingLanguage, int id) {
		ProgrammingLanguage programmingLanguage2 = getById(id); 
		programmingLanguage2.setName(programmingLanguage.getName());
	}
	
	

}
