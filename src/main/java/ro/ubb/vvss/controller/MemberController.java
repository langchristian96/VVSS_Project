package ro.ubb.vvss.controller;




import ro.ubb.vvss.exceptions.InvalidBudgetException;
import ro.ubb.vvss.exceptions.InvalidNameException;
import ro.ubb.vvss.model.Entry;
import ro.ubb.vvss.model.Member;
import ro.ubb.vvss.repository.MemberRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MemberController {
	
    private MemberRepository mr;
    
    public MemberController(MemberRepository newMr){    	
    	this.mr =newMr;    	
    }
    
    public void addMember(Member aMemebr) throws InvalidNameException {
        if(Integer.parseInt(aMemebr.getId())<=0) {
            throw new RuntimeException("Id must be positive");
        }

        if(!aMemebr.getName().chars().allMatch(Character::isLetter)) {
            throw new InvalidNameException();
        }

        mr.addMember(aMemebr);
    }

    public void addEntry(Entry oneEntry) throws InvalidBudgetException {
        if(!(oneEntry.getType().equals("income") || oneEntry.getType().equals("cost"))) {
            throw new InvalidBudgetException();
        }
        if(oneEntry.getIdMember()<=0) {
            throw new RuntimeException("Id must be positive");
        }
        if(oneEntry.getValue()<=0) {
            throw new InvalidBudgetException();
        }
        mr.addEntry(oneEntry);
    }

     public List<Entry> allEntries() {
        
    	
        List<Entry> allE= new ArrayList<>();
        allE = this.mr.getAllEntries();
        return allE;
    }

    public List<Entry> entriesForMember(int id) {
        if(id<=0) {
            throw new RuntimeException("Id must be positive");
        }
        return this.mr.getAllEntries().stream().filter(m-> m.getIdMember()==id).collect(Collectors.toList());
    }
} 