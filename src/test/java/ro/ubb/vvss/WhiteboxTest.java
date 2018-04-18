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

/**
 * Created by langchristian96 on 3/28/2018.
 */
public class WhiteboxTest extends TestCase {

    private MemberRepository repository;
    private MemberController controller;


    public void test_tc_1_addEntryValid_income() throws InvalidBudgetException {

        repository = new MemberRepository();
        controller = new MemberController(repository);
        Entry entry = new Entry("income", 12, 11);
        int size = controller.allEntries().size();
        controller.addEntry(entry);
        assertEquals(controller.allEntries().size(), size+1);
    }

    public void test_tc_2_addEntryWrongType() throws InvalidBudgetException {
        int size=0;

        try {
            repository = new MemberRepository();
            controller = new MemberController(repository);
            Entry entry = new Entry("qwe", 1, 1);
            size = controller.allEntries().size();
            controller.addEntry(entry);
            fail("Exception should have been thrown");
        }
        catch(InvalidBudgetException e) {

            assertEquals(controller.allEntries().size(), size);
        }
    }


    public void test_tc_3_addEntryNegativeId() throws InvalidBudgetException {
        int size=0;

        try {
            repository = new MemberRepository();
            controller = new MemberController(repository);
            Entry entry = new Entry("cost", 1, -1);
            size = controller.allEntries().size();
            controller.addEntry(entry);
            fail("Exception should have been thrown");
        }
        catch(RuntimeException e) {

            assertEquals(controller.allEntries().size(), size);
        }
    }

    public void test_tc_4_addEntryValid_cost() throws InvalidBudgetException {

        repository = new MemberRepository();
        controller = new MemberController(repository);
        Entry entry = new Entry("cost", 12, 11);
        int size = controller.allEntries().size();
        controller.addEntry(entry);
        assertEquals(controller.allEntries().size(), size+1);
    }


    public void test_tc_5_addEntryNegativeValue() throws InvalidBudgetException {
        int size=0;

        try {
            repository = new MemberRepository();
            controller = new MemberController(repository);
            Entry entry = new Entry("cost", -1, 1);
            size = controller.allEntries().size();
            controller.addEntry(entry);
            fail("Exception should have been thrown");
        }
        catch(InvalidBudgetException e) {

            assertEquals(controller.allEntries().size(), size);
        }
    }

    public WhiteboxTest( String testName )
    {
        super( testName );
    }


    public static Test suite()
    {
        return new TestSuite( WhiteboxTest.class );
    }

}
