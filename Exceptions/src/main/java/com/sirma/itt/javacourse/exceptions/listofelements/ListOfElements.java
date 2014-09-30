package com.sirma.itt.javacourse.exceptions.listofelements;

/**
 * The class ListOfElements contains methods for adding new elements to a list, removing the last
 * element of the list and printing all the elements to the screen.
 * 
 * @author Svetlosar Kovatchev
 */
public final class ListOfElements {
	private static final int CAPACITY = 2;
	private Object[] array;
	private int count;

	/**
	 * Default constructor.
	 */
	protected ListOfElements() {
		array = new Object[CAPACITY];
		count = 0;
	}

	/**
	 * Adds an element to the end of the list.
	 * 
	 * @param item
	 *            the element to add
	 * @throws FullListException
	 *             whenever the list is full
	 */
	public void add(Object item) throws FullListException {
		add(count, item);
	}

	/**
	 * Adds an element at the specified position.
	 * 
	 * @param index
	 *            the position where the element is to be added
	 * @param item
	 *            the element to add
	 * @throws FullListException
	 *             whenever the list is full
	 */
	private void add(int index, Object item) throws FullListException {
		try {
			array[index] = item;
		} catch (ArrayIndexOutOfBoundsException e) {
			// e.printStackTrace();
			throw new FullListException("The list is full");
		}
		count++;

	}

	/**
	 * Removes the last element of the array.
	 * 
	 * @throws EmptyListException
	 *             whenever the list is empty
	 */
	public void remove() throws EmptyListException {
		try {
			array[--count] = null;
		} catch (ArrayIndexOutOfBoundsException e) {
			// e.printStackTrace();
			throw new EmptyListException("The list is empty");
		}
	}

	/**
	 * Displays the elements to the screen.
	 */
	@SuppressWarnings("unused")
	private void print() {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

	// public static void main(String... args) throws FullListException, EmptyListException {
	// ListOfElements listOfElements = new ListOfElements();
	// // listOfElements.add(2);
	// // listOfElements.add(3);
	// // listOfElements.add(3);
	// listOfElements.remove();
	// listOfElements.print();
	// }

}
