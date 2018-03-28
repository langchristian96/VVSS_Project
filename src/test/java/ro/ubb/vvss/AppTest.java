package ro.ubb.vvss;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import ro.ubb.vvss.controller.MemberController;
import ro.ubb.vvss.exceptions.InvalidBudgetException;
import ro.ubb.vvss.exceptions.InvalidNameException;
import ro.ubb.vvss.model.Entry;
import ro.ubb.vvss.model.Member;
import ro.ubb.vvss.repository.MemberRepository;

/**
 * Created by langchristian96 on 3/14/2018.
 */
public class AppTest extends TestCase {

    private MemberRepository repository;
    private MemberController controller;


    public void test_tc_1() throws InvalidNameException {
        repository = new MemberRepository();
        controller = new MemberController(repository);
        Member member = new Member("bla", "111");
        controller.addMember(member);
    }
    public void test_tc_2() {
        try {
            repository = new MemberRepository();
            controller = new MemberController(repository);
            Member member = new Member("bla", "-1");
            controller.addMember(member);
            fail("Exception should have been thrown");
        }
        catch(RuntimeException e) {

        } catch (InvalidNameException e) {
            e.printStackTrace();
        }
    }

    public void test_tc_3() throws InvalidBudgetException {
        repository = new MemberRepository();
        controller = new MemberController(repository);
        Entry entry = new Entry("cost", 13, 1);
        int size = controller.allEntries().size();
        controller.addEntry(entry);
        assertEquals(controller.allEntries().size(), size+1);

    }
    public void test_tc_4() throws InvalidBudgetException {
        try {
            repository = new MemberRepository();
            controller = new MemberController(repository);
            Entry entry = new Entry("cost", -1, 1);
            int size = controller.allEntries().size();
            controller.addEntry(entry);
            fail("Exception should have been thrown");
        }
        catch(InvalidBudgetException e) {

        }
    }

    public void test_tc_5() throws InvalidBudgetException {
        repository = new MemberRepository();
        controller = new MemberController(repository);
        Entry entry = new Entry("cost", 1, 1);
        int size = controller.allEntries().size();
        controller.addEntry(entry);
        assertEquals(controller.allEntries().size(), size+1);

    }

    public void test_tc_6() throws InvalidBudgetException {
        repository = new MemberRepository();
        controller = new MemberController(repository);
        Entry entry = new Entry("income", 1, 1);
        int size = controller.allEntries().size();
        controller.addEntry(entry);
        assertEquals(controller.allEntries().size(), size+1);

    }


    public void test_tc_7() throws InvalidNameException {
        repository = new MemberRepository();
        controller = new MemberController(repository);
        Member member = new Member("bla", "13");
        controller.addMember(member);

    }

    public void test_tc_8() {
        try {
            repository = new MemberRepository();
            controller = new MemberController(repository);
            Member member = new Member("bla1", "13");
            controller.addMember(member);
            fail("Exception should have been thrown");
        }
        catch(RuntimeException | InvalidNameException e) {

        }
    }

    public void test_tc_9() throws InvalidBudgetException {
        try {
            repository = new MemberRepository();
            controller = new MemberController(repository);
            Entry entry = new Entry("qwe", 1, 1);
            int size = controller.allEntries().size();
            controller.addEntry(entry);
            fail("Exception should have been thrown");
        }
        catch(InvalidBudgetException e) {

        }
    }


    public void test_tc_10() {
        try {
            repository = new MemberRepository();
            controller = new MemberController(repository);
            Member member = new Member("bla", "0");
            controller.addMember(member);
            fail("Exception should have been thrown");
        }
        catch(RuntimeException | InvalidNameException e) {

        }
    }

    public void test_tc_11() throws InvalidNameException {
        repository = new MemberRepository();
        controller = new MemberController(repository);
        Member member = new Member("bla", "1");
        controller.addMember(member);
    }


    public void test_tc_12() throws InvalidBudgetException {
        try {
            repository = new MemberRepository();
            controller = new MemberController(repository);
            Entry entry = new Entry("cost", 0, 1);
            int size = controller.allEntries().size();
            controller.addEntry(entry);
            fail("Exception should have been thrown");
        }
        catch(InvalidBudgetException e) {

        }
    }

    public void test_tc_13() throws InvalidBudgetException {
        repository = new MemberRepository();
        controller = new MemberController(repository);
        Entry entry = new Entry("cost", 1, 13);
        int size = controller.allEntries().size();
        controller.addEntry(entry);
        assertEquals(controller.allEntries().size(), size+1);

    }


    public void test_tc_14() throws InvalidBudgetException {
        repository = new MemberRepository();
        controller = new MemberController(repository);
        Entry entry = new Entry("income", 1, 13);
        int size = controller.allEntries().size();
        controller.addEntry(entry);
        assertEquals(controller.allEntries().size(), size+1);

    }




//    public void test_tc_1_addEntryNegativeIdd() throws InvalidBudgetException {
//        try {
//            repository = new MemberRepository();
//            controller = new MemberController(repository);
//            Entry entry = new Entry("income", 123, -1);
//            int size = controller.allEntries().size();
//            controller.addEntry(entry);
//            assertEquals(controller.allEntries().size(), size + 1);
//            fail();
//        }
//        catch(RuntimeException e) {
//
//        }
//    }
//
//    public void test_tc_2_addRandomTypeEntryy() throws InvalidBudgetException {
//        try {
//            repository = new MemberRepository();
//            controller = new MemberController(repository);
//            Entry entry = new Entry("qwe", 123, -1);
//            int size = controller.allEntries().size();
//            controller.addEntry(entry);
//            fail();
//        }
//        catch(InvalidBudgetException e) {
//
//        }
//    }
//
//    public void test_tc_3_addMemberNegativeId() {
//        try {
//            repository = new MemberRepository();
//            controller = new MemberController(repository);
//            Member member = new Member("bla", "-1");
//            controller.addMember(member);
//            fail("Exception should have been thrown");
//        }
//        catch(RuntimeException e) {
//
//        } catch (InvalidNameException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void test_tc_4_addMemberPositiveId() throws InvalidNameException {
//        repository = new MemberRepository();
//        controller = new MemberController(repository);
//        Member member = new Member("bla", "111");
//        controller.addMember(member);
//
//    }
//
//
//    public void test_tc_5_addMemberInCorrectName() {
//        try {
//            repository = new MemberRepository();
//            controller = new MemberController(repository);
//            Member member = new Member("bla1", "13");
//            controller.addMember(member);
//            fail("Exception should have been thrown");
//        }
//        catch (InvalidNameException e) {
//        }
//    }
//
//    public void test_tc_6_addMemberCorrectName() throws InvalidNameException {
//        repository = new MemberRepository();
//        controller = new MemberController(repository);
//        Member member = new Member("bla", "13");
//        controller.addMember(member);
//    }
//
//
//    public void test_tc_7_addEntryNegativeValue() throws InvalidBudgetException {
//        try {
//            repository = new MemberRepository();
//            controller = new MemberController(repository);
//            Entry entry = new Entry("income", -1, 1);
//            int size = controller.allEntries().size();
//            controller.addEntry(entry);
//            fail("Exception should have been thrown");
//        }
//        catch(InvalidBudgetException e) {
//
//        }
//    }
//
//    public void test_tc_8_addEntryPositiveValue() throws InvalidBudgetException {
//        repository = new MemberRepository();
//        controller = new MemberController(repository);
//        Entry entry = new Entry("cost", 13, 1);
//        int size = controller.allEntries().size();
//        controller.addEntry(entry);
//        assertEquals(controller.allEntries().size(), size+1);
//
//    }

    public AppTest( String testName )
    {
        super( testName );
    }


    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

}
