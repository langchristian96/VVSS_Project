package ro.ubb.vvss;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import ro.ubb.vvss.controller.MemberController;
import ro.ubb.vvss.exceptions.InvalidBudgetException;
import ro.ubb.vvss.exceptions.InvalidNameException;
import ro.ubb.vvss.model.Entry;
import ro.ubb.vvss.model.Member;
import ro.ubb.vvss.repository.MemberRepository;

import java.util.List;

/**
 * Created by langchristian96 on 5/2/2018.
 */
public class TopDownTest extends TestCase {


    private MemberRepository memberRepository;
    private MemberController memberController;

    public TopDownTest( String testName )
    {
        super( testName );
    }

    public static Test suite()
    {
        return new TestSuite( TopDownTest.class );
    }

    //a)
    public void test_tc1_addMember() throws InvalidNameException {
        memberRepository = new MemberRepository();
        memberController = new MemberController(memberRepository);
        int size = memberRepository.getAllMembers().size();
        Member member = new Member("name", "114");
        memberController.addMember(member);
        assertEquals(memberRepository.getAllMembers().size(), size+1);
    }

    //a) and b)
    public void test_tc2_integrationTestB() throws InvalidNameException, InvalidBudgetException {
        this.memberRepository = new MemberRepository("membersF.txt", "bla.txt");  //empty bla.txt => zero entries
        this.memberController = new MemberController(memberRepository);

        int size = memberRepository.getAllMembers().size();
        Member member = new Member("name", "114");
        memberController.addMember(member);
        assertEquals(memberRepository.getAllMembers().size(), size+1);


        Entry entry = new Entry("income", 12, 114);
        size = memberController.allEntries().size();
        memberController.addEntry(entry);
        assertEquals(memberController.allEntries().size(), size+1);
    }

    //a) and b) and c)
    public void test_tc3_integrationTestC() throws InvalidNameException, InvalidBudgetException {
        this.memberRepository = new MemberRepository("membersF.txt", "bla.txt");  //empty bla.txt => zero entries
        this.memberController = new MemberController(memberRepository);

        int size = memberRepository.getAllMembers().size();
        Member member = new Member("name", "114");
        memberController.addMember(member);
        assertEquals(memberRepository.getAllMembers().size(), size+1);


        Entry entry = new Entry("income", 12, 114);
        size = memberController.allEntries().size();
        memberController.addEntry(entry);
        assertEquals(memberController.allEntries().size(), size+1);

        List<Entry> entries = memberController.entriesForMember(114);
        assertTrue(entries.contains(entry));
    }
}
