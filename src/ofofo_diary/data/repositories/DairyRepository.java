package ofofo_diary.data.repositories;

import ofofo_diary.data.models.Dairy;

import java.util.List;

public interface DairyRepository {

    Dairy save(Dairy dairy);
    List<Dairy> findByTittle(String tittle);
    void delete(int id);
    void delete(Dairy dairy);
    long count();
    Dairy findById();
}
