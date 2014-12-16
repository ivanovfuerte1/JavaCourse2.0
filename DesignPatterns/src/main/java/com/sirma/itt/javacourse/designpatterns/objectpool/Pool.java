package com.sirma.itt.javacourse.designpatterns.objectpool;

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

	/**
	 * Constructs a new pool with a given size.
	 * 
	 * @param size
	 *            the size of the pool
	 */
	public Pool(int size) {
		this.pool = new ArrayList<T>();
		maxPoolSize = size;
	}

	/**
	 * Releases a new Resource.
	 * 
	 * @return the pool with the new resource acquired
	 * @param t
	 *            the resource from the input
	 * @throws AllReusableReleased
	 *             if there are no resources to release
	 */
	public T release(T t) throws AllReusableReleased {
		if (pool.size() < maxPoolSize) {
			pool.add(t);
			return t;
		} else {
			throw new AllReusableReleased(ALL_REUSABLE_RELEASED);
		}
	}

	/**
	 * Acquires a resource. This method can be used when choice of resource is irrelevant.
	 * 
	 * @throws NoAvailableResource
	 *             if the number of resources reaches the maximum assigned in the constructor.
	 */
	public void acquire() throws NoAvailableResource {
		if (pool.size() > 0) {
			pool.remove(0);
		} else {
			throw new NoAvailableResource(NO_RESOURCES);
		}
	}

	/**
	 * Acquires a resource assigned from the input.
	 * 
	 * @param t
	 *            the resource assigned from the input
	 * @throws NoAvailableResource
	 *             if the number of resources reaches the maximum assigned in the constructor.
	 */
	public void acquire(T t) throws NoAvailableResource {
		if (pool.contains(t)) {
			pool.remove(t);
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
