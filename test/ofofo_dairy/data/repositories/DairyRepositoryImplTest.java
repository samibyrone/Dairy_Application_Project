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
    public void newRepository_countIs_IsEmpty_orZero(){
        assertEquals(0, dairy.count());
    }

    @Test
    public void newRepository_countIs_IsNotEmpty_andCountOne(){
        assertEquals(0, dairy.count());
        dairy.save(new Dairy());
        assertEquals(1, dairy.count());
    }
}
