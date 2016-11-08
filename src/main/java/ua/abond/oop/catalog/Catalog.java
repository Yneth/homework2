package ua.abond.oop.catalog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Catalog {
    private final List<Record> records;

    public Catalog() {
        this(new ArrayList<>());
    }

    public Catalog(List<Record> records) {
        this.records = records;
    }

    public void addRecord(Record record) {
        records.add(record);
    }
    public void removeRecord(Record record) {
        records.remove(record);
    }

    public List<Record> getRecords() {
        return Collections.unmodifiableList(records);
    }

    public static class Record {
        private final Date dateAdded;
        private final String userName;

        public Record(Date dateAdded, String userName) {
            this.dateAdded = dateAdded;
            this.userName = userName;
        }

        public Date getDateAdded() {
            return dateAdded;
        }

        public String getUserName() {
            return userName;
        }
    }
}
