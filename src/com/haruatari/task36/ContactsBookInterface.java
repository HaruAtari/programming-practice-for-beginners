package com.haruatari.task36;

import java.util.List;

public interface ContactsBookInterface {
    public void add(ContactInterface contact);

    public void remove(int contactId);

    public List<ContactInterface> getAll();

    public List<ContactInterface> searchByName();

    public List<ContactInterface> searchByPhoneNumber();
}
