package kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService{

	private ProgrammingLanguageRepository programmingLanguageRepository;
	
	List<ProgrammingLanguage> language;
	
	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository)
	{
		this.programmingLanguageRepository = programmingLanguageRepository;
	}
	
	@Override
	public List<ProgrammingLanguage> getAll() {
		return programmingLanguageRepository.getAll();
	}

	@Override
	public void add(ProgrammingLanguage programmingLanguage) throws Exception {
       
       if(isNameExist(programmingLanguage.getName())) {
    	   
    	   throw new Exception("This name is already exist.");
    	   
       }
        programmingLanguageRepository.add(programmingLanguage);
    } 
	

	
	@Override
	public ProgrammingLanguage getById(int id) throws Exception {
		if(!isIdExist(id)) {
			throw new Exception("Id cannot found");
		}
		return programmingLanguageRepository.getById(id);
	}	

	@Override
	public void delete(int id) throws Exception {
		if(!isIdExist(id)) {
			throw new Exception("Id cannot found");
		}
		programmingLanguageRepository.delete(id);
		
	}

	@Override
	public void update(ProgrammingLanguage programmingLanguage, int id) throws Exception {
		if(!isIdExist(id)) {
			throw new Exception("Id cannot found");
		} 
		 if(isNameExist(programmingLanguage.getName())) {
	    	   
	    	   throw new Exception("This name is already exist.");
	    	   
	       }
		programmingLanguageRepository.update(programmingLanguage, id);
		
	}
	
	private boolean isIdExist(int id) {
		for(ProgrammingLanguage programmingLanguage : getAll()) {
			if(programmingLanguage.getId() == id ) {
				return true;
			}
		}
		return false;
		
	}
	
	private boolean isNameExist(String name) throws Exception {
        for(ProgrammingLanguage programmingLanguage : getAll()) {
            if(programmingLanguage.getName().equals(name) ) {
                return true;
            }
           
        }
        if(name.isEmpty()) {
            throw new Exception("You have to write a name");  
            
        }

        return false;
    }

	

}
