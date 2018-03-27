package ro.ubb.vvss;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import ro.ubb.vvss.controller.MemberController;
import ro.ubb.vvss.model.Entry;
import ro.ubb.vvss.repository.MemberRepository;

/**
 * Created by langchristian96 on 3/14/2018.
 */
public class AppTest extends TestCase {

    private MemberRepository repository;
    private MemberController controller;

    public void test_tc_1_addEntryNegativeIdd() {
        repository = new MemberRepository();
        controller = new MemberController(repository);
        Entry entry = new Entry("income",123,-1);
        int size = controller.allEntries().size();
        controller.addEntry(entry);
        assertEquals(controller.allEntries().size(), size);
    }

    public void test_tc_2_addRandomTypeEntryy() {
        repository = new MemberRepository();
        controller = new MemberController(repository);
        Entry entry = new Entry("qwe",123,-1);
        int size = controller.allEntries().size();
        controller.addEntry(entry);
        assertEquals(controller.allEntries().size(), size);
    }
    public void test_tc_3_empty() {

    }

    public AppTest( String testName )
    {
        super( testName );
    }


    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

}
