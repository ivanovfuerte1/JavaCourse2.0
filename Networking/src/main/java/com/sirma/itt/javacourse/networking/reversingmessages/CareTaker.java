package com.sirma.itt.javacourse.networking.reversingmessages;

import java.util.ArrayList;
import java.util.List;

/**
 * The class {@link CareTaker} contains methods for adding and returning container classes to its
 * list of classes.
 */
public class CareTaker {
	private List<Memento> mementoList = new ArrayList<Memento>();

	/**
	 * Getter method for the list of containers.
	 *
	 * @return the mementoList
	 */
	public List<Memento> getMementoList() {
		return mementoList;
	}

	/**
	 * Adds a new container to its list of containers.
	 * 
	 * @param state
	 *            the new container to add to the list
	 */
	public void add(Memento state) {
		mementoList.add(state);
	}

	/**
	 * Returns a container by its index.
	 * 
	 * @param index
	 *            the index of the container to return
	 * @return the container having the index
	 */
	public Memento get(int index) {
		return mementoList.get(index);
	}
}
