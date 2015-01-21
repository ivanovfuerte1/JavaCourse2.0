package com.sirma.itt.javacourse.chat.server;

import java.util.ArrayList;
import java.util.List;

/**
 * The class {@link Pool} contains methods for acquiring and releasing resources to certain limit.
 * 
 * @param <T>
 *            the type of objects in the pool
 */
public class Pool<T> {
	private static final String NO_RESOURCES = "There are no available resourses!";
	private static final String ALL_REUSABLE_RELEASED = "All reusable are released!";
	private static int maxPoolSize;
	private List<T> pool;
	private T t;

	/**
	 * Constructs a new pool with a given size.
	 * 
	 * @param size
	 *            the size of the pool
	 */
	public Pool(int size) {
		maxPoolSize = size;
		this.pool = new ArrayList<T>(maxPoolSize);
		for (int i = 0; i < maxPoolSize; i++) {
			pool.add(t);
		}
	}

	/**
	 * Releases a new Resource.
	 * 
	 * @return the pool with the new resource acquired
	 * @param object
	 *            the resource from the input
	 * @throws AllReusableReleased
	 *             if there are no resources to release
	 */
	public T release(T object) throws AllReusableReleased {
		if (pool.size() < maxPoolSize) {
			pool.add(object);
			return object;
		} else {
			throw new AllReusableReleased(ALL_REUSABLE_RELEASED);
		}
	}

	/**
	 * Acquires a resource. This method can be used when choice of resource is irrelevant.
	 * 
	 * @return the resource acquired
	 * @throws NoAvailableResource
	 *             if the number of resources reaches the maximum assigned in the constructor
	 */
	public T acquire() throws NoAvailableResource {
		T t = null;
		if (pool.size() > 0) {
			t = pool.remove(0);
			return t;
		} else {
			System.out.println("No available resources FROM POOL");
			throw new NoAvailableResource(NO_RESOURCES);
		}
	}

	/**
	 * Acquires a resource assigned from the input.
	 * 
	 * @param object
	 *            the resource assigned from the input
	 * @throws NoAvailableResource
	 *             if the number of resources reaches the maximum assigned in the constructor.
	 */
	public void acquire(T object) throws NoAvailableResource {
		if (pool.contains(object)) {
			pool.remove(object);
		} else {
			throw new NoAvailableResource(NO_RESOURCES);
		}
	}

	/**
	 * Gets the pool.
	 *
	 * @return the pool
	 */
	public List<T> getPool() {
		return pool;
	}

}
