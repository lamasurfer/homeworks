package org.example.task2.entity.client.pet;

import java.util.ArrayList;
import java.util.List;

public class HealthCard {

    private List<String> notes = new ArrayList<>();

    public HealthCard() {
    }

    public List<String> getNotes() {
        return notes;
    }

    public void setNotes(List<String> notes) {
        this.notes = notes;
    }

    public void addNotes(String note) {
        notes.add(note);
    }

    @Override
    public String toString() {
        return notes.toString();
    }
}
