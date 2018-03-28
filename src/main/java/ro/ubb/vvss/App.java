package ro.ubb.vvss;

import ro.ubb.vvss.controller.MemberController;
import ro.ubb.vvss.exceptions.InvalidBudgetException;
import ro.ubb.vvss.exceptions.InvalidNameException;
import ro.ubb.vvss.repository.MemberRepository;
import ro.ubb.vvss.ui.MemberUI;

import java.io.BufferedWriter;

public class App {
	public static void main(String[] args) throws InvalidNameException, InvalidBudgetException {
		
			MemberRepository repo = new MemberRepository();
		
			MemberController ctrl = new MemberController(repo);
		
			MemberUI console = new MemberUI(ctrl);
			console.Run();
		
	}
}
