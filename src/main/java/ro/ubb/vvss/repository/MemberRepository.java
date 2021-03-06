package ro.ubb.vvss.repository;

import ro.ubb.vvss.model.Entry;
import ro.ubb.vvss.model.Member;

import java.io.BufferedReader;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class MemberRepository {
	private List<Member> members = new ArrayList<Member>();
	private List<Entry> entries = new ArrayList<Entry>();

	private static String filenameMember = "membersF.txt";
	private static String filenameBudget = "budgetF.txt";

	public MemberRepository(String filenameMember, String filenameBudget) {
		MemberRepository.filenameBudget = filenameBudget;
		MemberRepository.filenameMember = filenameMember;
		init();
	}

	public MemberRepository() {
		init();
	}

	private void init() {
		try{
            FileReader fileReader = null;
            BufferedReader bufferedReader = null;
            String currentLine = null;

            fileReader = new FileReader(filenameMember);
            bufferedReader = new BufferedReader(fileReader);

            while ((currentLine = bufferedReader.readLine()) != null) {
                String line[] = currentLine.split(";");
                Member m = new Member(line[0], line[1]);
                this.members.add(m);
            }
         }catch(Exception ex){
             System.err.println(ex.getMessage());
         }
		try{
            FileReader fileReaderEntry = null;
            BufferedReader bufferedReaderEntry = null;
            String currentLineEntry = null;

            fileReaderEntry = new FileReader(filenameBudget);
            bufferedReaderEntry = new BufferedReader(fileReaderEntry);

            while ((currentLineEntry = bufferedReaderEntry.readLine()) != null) {
                String line[] = currentLineEntry.split(";");
                int valueEntry = Integer.parseInt(line[1]);
                int idEntryMember = Integer.parseInt(line[2]);
                Entry e = new Entry(line[0],valueEntry,idEntryMember);
                this.entries.add(e);
            }
         }catch(Exception ex){
             System.err.println(ex.getMessage());
         }
	}

	public void addMember(Member m){
		 members.add(m);
		 try {
			 FileWriter fw = new FileWriter(filenameMember,true);
			 fw.write("\n");
			 fw.write(m.getName()+";"+m.getId());
			 fw.close();
		 } catch (IOException e) {
			 e.printStackTrace();
		 }
	 }
	 public void addEntry(Entry e){
		 entries.add(e);
		 try {
			 FileWriter fw = new FileWriter(filenameBudget,true);
			 fw.write("\n");
			 fw.write(e.getType()+";"+e.getValue()+";"+e.getIdMember());
			 fw.close();
		 } catch (IOException ee) {
			 ee.printStackTrace();
		 }
	 }
	 public List<Entry> getAllEntries(){
		 
		 return entries;
	 }

	 public List<Member> getAllMembers() {
	 	return this.members;
	 }
}
