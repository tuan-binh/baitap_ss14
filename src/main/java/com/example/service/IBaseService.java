package com.example.service;

import java.util.List;

public interface IBaseService<T,E> {
	List<T> getList();
	void save(T element);
	void delete(E id);
	T findById(E id);
}
