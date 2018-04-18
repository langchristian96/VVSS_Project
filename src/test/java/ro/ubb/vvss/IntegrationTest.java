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

import static org.junit.Assert.assertThat;

/**
 * Created by langchristian96 on 4/18/2018.
 */
public class IntegrationTest extends TestCase {

    private MemberRepository memberRepository;
    private MemberController memberController;

    public IntegrationTest( String testName )
    {
        super( testName );
    }

    //first test for c)
    public void test_tc1_getEntriesForMember() {
        this.memberRepository = new MemberRepository("C:\\work\\ssvv\\VVSS\\membersF.txt", "bla.txt");  //empty bla.txt => zero entries
        this.memberController = new MemberController(memberRepository);
        List<Entry> entries = memberController.entriesForMember(1);
        assertEquals(entries.size(), 0);
    }

    //a)
    public void test_tc2_addMember() throws InvalidNameException {
        memberRepository = new MemberRepository();
        memberController = new MemberController(memberRepository);
        int size = memberRepository.getAllMembers().size();
        Member member = new Member("bla", "111");
        memberController.addMember(member);
        assertEquals(memberRepository.getAllMembers().size(), size+1);
    }

    //b)
    public void test_tc3_addEntry() throws InvalidBudgetException {
        memberRepository = new MemberRepository();
        memberController = new MemberController(memberRepository);
        Entry entry = new Entry("income", 12, 11);
        int size = memberController.allEntries().size();
        memberController.addEntry(entry);
        assertEquals(memberController.allEntries().size(), size+1);
    }

    //final test
    public void test_tc4_final() throws InvalidNameException, InvalidBudgetException {
        this.memberRepository = new MemberRepository("C:\\work\\ssvv\\VVSS\\membersF.txt", "bla.txt");  //empty bla.txt => zero entries
        this.memberController = new MemberController(memberRepository);

        int size = memberRepository.getAllMembers().size();
        Member member = new Member("blaa", "112");
        memberController.addMember(member);
        assertEquals(memberRepository.getAllMembers().size(), size+1);


        Entry entry = new Entry("income", 12, 112);
        size = memberController.allEntries().size();
        memberController.addEntry(entry);
        assertEquals(memberController.allEntries().size(), size+1);

        List<Entry> entries = memberController.entriesForMember(112);
        assertTrue(entries.contains(entry));
    }

    public static Test suite()
    {
        return new TestSuite( WhiteboxTest.class );
    }
}
