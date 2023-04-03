package com.haruatari.task37;

import java.util.List;

public interface TodoListInterface {
    public void add(BusinessInterface business);

    public void remove(int businessId);

    public void complete(int businessId);

    public List<BusinessInterface> getAll();

    public List<BusinessInterface> getUncompleted();
}