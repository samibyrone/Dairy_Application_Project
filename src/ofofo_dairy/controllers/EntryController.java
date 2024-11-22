package ofofo_dairy.controllers;

import ofofo_dairy.data.models.Entry;
import ofofo_dairy.services.EntryService;
import ofofo_dairy.services.EntryServiceImpl;

import java.util.List;

public class EntryController {
    private final EntryService entryService = new EntryServiceImpl();

    public List<Entry> findEnteriesBelongingTo(String username) {
        return entryService.findAllEntryById(username);
    }

    public Entry findEntryById(long id, String username) {
        return entryService.findEntryById(id);
    }
}
