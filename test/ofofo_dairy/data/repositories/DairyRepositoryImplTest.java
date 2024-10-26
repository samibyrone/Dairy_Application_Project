package ofofo_dairy.data.repositories;

import ofofo_diary.data.models.Dairy;
import ofofo_diary.data.repositories.DairyRepositoryImpl;

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
        dairy.isEmpty();
        assertEquals(0, dairy.count());
    }

    @Test
    public void newRepository_countIs_notEmpty_andCountOneTest(){
        dairy.isEmpty();
        assertEquals(0, dairy.count());
        Dairy myDairy = new Dairy("Sammy", "passcode");
        dairy.save(new Dairy(myDairy));
        assertEquals(1, dairy.getSize());
        assertEquals(1, dairy.count());
    }

    @Test
    public void newRepository_count_addTwo_entries_toRepositoryTest(){
        dairy.isEmpty();
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
        dairy.isEmpty();
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
        dairy.isEmpty();
        assertEquals(0, dairy.count());
        Dairy myDairy = new Dairy("Samson", "CorrectGuy");
        dairy.save(myDairy);
        assertEquals(1, dairy.count());
        Dairy myDairy2 = new Dairy("Samiyrone", "CorrectBoy");
        dairy.save(myDairy2);
        assertEquals(2, dairy.count());
        Dairy searchForUser = dairy.findById("Samibyrone");
        System.out.println(searchForUser);
        assertEquals(myDairy, searchForUser);
        assertEquals(searchForUser.toString(), "Samibyrone");
        assertEquals(searchForUser.getUserName(), "Samibyrone");
        assertEquals(2, dairy.getSize());
    }

    @Test
    public void newRepository_canDelete_existingEntries_fromRepositoryTest(){
        dairy.isEmpty();
        assertEquals(0, dairy.count());
        Dairy myDairy = new Dairy("Samson", "CorrectGuy");
        dairy.save(myDairy);
        assertEquals(1, dairy.getSize());
        dairy.delete(myDairy);
        assertEquals(0, dairy.count());
        assertEquals(dairy.getSize(), 0);
    }
}
