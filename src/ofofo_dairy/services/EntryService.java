package ofofo_dairy.services;

import ofofo_dairy.data.models.Entry;

import java.util.List;

public interface EntryService{
    List<Entry> findAllEntryById(String username);

    Entry findEntryById(long id);

    long countNumberOfEntries(String dairyId);

    Entry createEntry(String dairyId, Entry entry);
}
