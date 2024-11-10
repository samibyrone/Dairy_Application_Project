package ofofo_dairy.data.repositories;

import ofofo_dairy.data.models.Dairy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DairyRepositoryImplTest {

    private DairyRepositoryImpl dairy;

    @BeforeEach
    public void setUp(){
        dairy = new DairyRepositoryImpl();
    }

    @Test
    public void newRepository_countIs_IsEmpty_orZeroTest(){
        assertEquals(0, dairy.count());
    }

    @Test
    public void newRepository_countIs_notEmpty_andCountOneTest(){
        assertEquals(0, dairy.count());
        Dairy myDairy = new Dairy("Sammy", "passcode");
        dairy.save(new Dairy(myDairy));
        assertEquals(1, dairy.getSize());
        assertEquals(1, dairy.count());
    }

    @Test
    public void newRepository_count_addTwo_entries_toRepositoryTest(){
        assertEquals(0, dairy.count());
        Dairy myDairy = new Dairy("Samson", "CorrectGuy");
        dairy.save(myDairy);
        assertEquals(1, dairy.count());
        Dairy myDairy2 = new Dairy("Samibyrone", "CorrectBoy");
        dairy.save(myDairy2);
        assertEquals(2, dairy.count());
        assertEquals(2, dairy.getSize());
    }

    @Test
    public void newRepository_count_addTwo_andDelete_One_Entries_fromRepositoryTest(){
        assertEquals(0, dairy.count());
        Dairy myDairy = new Dairy("Samson", "CorrectGuy");
        dairy.save(myDairy);
        assertEquals(1, dairy.count());
        Dairy myDairy2 = new Dairy("Samibyrone", "CorrectBoy");
        dairy.save(myDairy2);
        assertEquals(2, dairy.count());
        dairy.delete(myDairy);
        assertEquals(1, dairy.count());
        assertEquals(1, dairy.getSize());
    }

    @Test

    public void newRepository_count_addTwo_andFindEntriesById_inRepositoryTest(){
        assertEquals(0, dairy.count());
        Dairy myDairy = new Dairy("Samson", "CorrectGuy");
        dairy.save(myDairy);
        assertEquals(1, dairy.count());
        Dairy myDairy2 = new Dairy("Sammy", "password");
        dairy.save(myDairy2);
        Dairy myDairy3 = new Dairy("Sami_byron", "coderMan");
        dairy.save(myDairy3);
        assertEquals(3, dairy.count());
        Dairy searchForUser = dairy.findById("Sammy");
        System.out.println(searchForUser);
        assertEquals(searchForUser, myDairy2);
        assertEquals(searchForUser.toString(), myDairy2.toString());
        assertEquals("Sammy",searchForUser.getUserName());
        assertEquals(3, dairy.count());
        assertEquals(3, dairy.getSize());
    }

    @Test
    public void newRepository_canDelete_existingEntries_fromRepositoryTest(){
        assertEquals(0, dairy.count());
        Dairy myDairy = new Dairy("Samson", "CorrectGuy");
        dairy.save(myDairy);
        assertEquals(1, dairy.getSize());
        dairy.delete(myDairy);
        assertEquals(0, dairy.count());
        assertEquals(dairy.getSize(), 0);
    }

    @Test
    public void newRepository_canFindByTitle_fromExisting_repositoryTest(){
        assertEquals(0, dairy.count());
        Dairy myDairy = new Dairy("Sam", "CorrectGuy");
        dairy.save(myDairy);
        dairy.findById("Sam");
        assertEquals(1, dairy.getSize());
        assertEquals(1, dairy.count());
    }

//    @Test
//    public void new
}
