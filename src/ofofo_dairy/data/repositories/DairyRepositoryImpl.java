package ofofo_dairy.data.repositories;

import ofofo_dairy.data.models.Dairy;

import java.util.ArrayList;
import java.util.List;

public class DairyRepositoryImpl implements DairyRepository{

    private static List<Dairy> dairies = new  ArrayList<>();
    private long count = 0;

    public DairyRepositoryImpl() {
        dairies = new ArrayList<>();
    }

    @Override
    public Dairy save(Dairy dairy) {
        dairies.add(dairy);
        count ++;
        return dairy;
    }

    @Override
    public List<Dairy> findByTitle(String tittle) {
        return List.of();
    }

    @Override
    public void delete(Dairy userName) {
        for(int count = 0; count < dairies.size(); count++) {
            if(dairies.get(count).equals(userName)) {
                dairies.remove(count);
            }
        }
        count --;
    }

    @Override
    public long count() {
        return count;
    }

    private List <Dairy> getDairy(long id) {
        return dairies;
    }

    @Override
    public String toString() {
        return dairies.toString();
    }

    @Override
    public Dairy findById(String userName) {
        for(Dairy dairy : dairies) {
            if(dairy.getUserName().equals(userName)) {
                return dairy;
            }
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return getSize() == - 1;
    }

    @Override
    public int getSize() {
        return dairies.size();
    }
}
