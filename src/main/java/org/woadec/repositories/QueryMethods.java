package org.woadec.repositories;

import java.util.List;

import org.woadec.entities.RegisterClient;

public interface QueryMethods<Model> {

	void insert(Model model);

	void insert(String values);

	void update(String set);

	List<Model> retreiveAll();

	Model findById(int id);

}
