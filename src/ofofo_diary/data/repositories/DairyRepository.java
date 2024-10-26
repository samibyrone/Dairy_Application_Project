package ofofo_diary.data.repositories;

import ofofo_diary.data.models.Dairy;

import java.util.List;

public interface DairyRepository {

    Dairy save(Dairy dairy);
    List<Dairy> findByTitle(String title);
    void delete(Dairy dairy);
    long count();
    Dairy findById(String userName);
    boolean isEmpty();
    int getSize();
}
