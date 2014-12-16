package com.sirma.itt.javacourse.designpatterns.objectpool;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
	private static final Logger LOGGER = LogManager.getLogger(Pool.class);

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
	 * Acquires a new Resource.
	 * 
	 * @return the pool with the new resource acquired
	 * @throws NoAvailableResource
	 *             if the number of resources reaches the maximum assigned in the constructor.
	 */
	public T acquire() throws NoAvailableResource {
		if (pool.size() < maxPoolSize) {
			T t = null;
			// T t = new T();
			// T t = T.getInstance();
			pool.add(t);
			return t;
		} else {
			throw new NoAvailableResource(NO_RESOURCES);
		}
	}

	/**
	 * Releases a resource. This method can be used when choice of resource is irrelevant.
	 * 
	 * @throws AllReusableReleased
	 *             if there are no resources to release
	 */
	public void release() throws AllReusableReleased {
		if (pool.size() > 0) {
			pool.remove(0);
		} else {
			throw new AllReusableReleased(ALL_REUSABLE_RELEASED);
		}
	}

	/**
	 * Releases a resource assigned from the input.
	 * 
	 * @param t
	 *            the resource assigned from the input
	 */
	public void release(T t) {
		if (pool.contains(t)) {
			pool.remove(t);
		} else {
			LOGGER.error("The resoource is not in the pool");
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
