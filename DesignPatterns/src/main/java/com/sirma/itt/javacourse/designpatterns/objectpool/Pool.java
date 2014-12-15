package com.sirma.itt.javacourse.designpatterns.objectpool;

import java.util.ArrayList;
import java.util.List;

/**
 * XXX: Why not make this generic so I can use your pool with whatever kind of
 * objects I want?
 * 
 * The class {@link Pool} contains methods for acquiring and releasing resources
 * to certain limit.
 */
public class Pool {
	private static final String NO_RESOURCES = "There are no available resourses!";
	private static final String ALL_REUSABLE_RELEASED = "All reusable are released!";
	private static int maxPoolSize;
	private List<Reusable> pool;

	/**
	 * Construct a new pool with a given size.
	 * 
	 * @param size
	 *            the size of the pool
	 */
	public Pool(int size) {
		this.pool = new ArrayList<Reusable>();
		maxPoolSize = size;
	}

	/**
	 * Acquires a new Resource.
	 * 
	 * @return the pool with the new resource acquired
	 * @throws NoAvailableResource
	 *             if the number of resources reaches the maximum assigned in
	 *             the constructor.
	 */
	public Reusable acquire() throws NoAvailableResource {
		if (pool.size() < maxPoolSize) {
			// XXX: why declare different class for this?
			Reusable reusable = Reusable.getInstance();
			pool.add(reusable);
			return reusable;
		} else {
			throw new NoAvailableResource(NO_RESOURCES, null);
		}
	}

	/**
	 * XXX: which element do you want to release? Why?
	 * 
	 * Releases a resource.
	 * 
	 * @throws AllReusableReleased
	 *             if there are no resources to release
	 */
	public void release() throws AllReusableReleased {
		if (pool.size() > 0) {
			pool.remove(0);
		} else {
			// XXX: Is there something to preserve?
			// COULD(AND SHOULD) I PRESERVE SOME STACK TRACE HERE?
			throw new AllReusableReleased(ALL_REUSABLE_RELEASED, null);
		}
	}

	/**
	 * Gets the pool.
	 *
	 * @return the pool
	 */
	public List<Reusable> getPool() {
		return pool;
	}

}
