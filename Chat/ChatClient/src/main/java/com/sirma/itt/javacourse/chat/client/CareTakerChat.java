package com.sirma.itt.javacourse.chat.client;

import java.util.ArrayList;
import java.util.List;

/**
 * The class {@link CareTakerChat} contains methods for adding and returning container classes to
 * its list of classes.
 */
public class CareTakerChat {
	private List<MementoChat> mementoList = new ArrayList<MementoChat>();

	/**
	 * Getter method for the list of containers.
	 *
	 * @return the mementoList
	 */
	public List<MementoChat> getMementoList() {
		return mementoList;
	}

	/**
	 * Adds a new container to its list of containers.
	 * 
	 * @param state
	 *            the new container to add to the list
	 */
	public void add(MementoChat state) {
		mementoList.add(state);
	}

	/**
	 * Returns a container by its index.
	 * 
	 * @param index
	 *            the index of the container to return
	 * @return the container having the index
	 */
	public MementoChat get(int index) {
		return mementoList.get(index);
	}
}
