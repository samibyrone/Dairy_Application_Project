package ofofo_diary.data.repositories;

import ofofo_diary.data.models.Dairy;

import java.util.ArrayList;
import java.util.List;

public class DairyRepositoryImpl implements DairyRepository {

    private static List<Dairy> entries = new ArrayList<>();

    @Override
    public Dairy save(Dairy dairy) {
        entries.add(dairy);
        return dairy;
    }

    @Override
    public List<Dairy> findByTittle(String tittle) {
        return List.of();
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void delete(Dairy dairy) {

    }

    @Override
    public long count() {
        return entries.size();
    }

    @Override
    public Dairy findById() {
        return null;
    }
}
