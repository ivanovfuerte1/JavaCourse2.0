package com.sirma.itt.javacourse.designpatterns.objectpool;

import static org.junit.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

/**
 * The class {@link PoolTest} contains methods for testing the methods of the class {@link Pool}.
 */
public class PoolTest {

	private static final String EMPTY_POOL = "The pool is empty";
	private static final String NO_RESOURCES = "There are no available resourses!";
	private static final Logger LOGGER = LogManager.getLogger();
	private static final int MAX_POOL_SIZE = 10;
	private static int sampleResource = 6;

	/**
	 * Test the method release of the class {@link Pool}.
	 * 
	 * @throws AllReusableReleased
	 *             when the pool is empty
	 */
	@Test
	public void testAcquire() throws AllReusableReleased {
		Pool<Integer> pool = new Pool<>(MAX_POOL_SIZE);
		try {
			pool.release(sampleResource);
			pool.release(sampleResource);
		} catch (AllReusableReleased e) {
			LOGGER.info(NO_RESOURCES, e);
		}
		int expected = 2;
		int actual = pool.getPool().size();
		assertEquals(expected, actual);
	}

	/**
	 * Tests the exception when no resources are available.
	 *
	 * @throws AllReusableReleased
	 *             when the pool is empty
	 */
	@Test(expected = AllReusableReleased.class)
	public void testNoResources() throws AllReusableReleased {
		Pool<Integer> pool = new Pool<>(MAX_POOL_SIZE);
		pool.release(sampleResource);
		pool.release(sampleResource);
		pool.release(sampleResource);
		pool.release(sampleResource);
		pool.release(sampleResource);
		pool.release(sampleResource);
		pool.release(sampleResource);
		pool.release(sampleResource);
		pool.release(sampleResource);
		pool.release(sampleResource);
		pool.release(sampleResource);
	}

	/**
	 * Tests the size of the pool after acquiring and releasing the same number of resources.
	 *
	 * @throws NoAvailableResource
	 *             if no resources are available
	 * @throws AllReusableReleased
	 *             when the pool is empty
	 */
	@Test
	public void testSize() throws NoAvailableResource, AllReusableReleased {
		Pool<Integer> pool = new Pool<>(MAX_POOL_SIZE);
		pool.release(sampleResource);
		try {
			pool.acquire();
		} catch (NoAvailableResource e) {
			throw new AllReusableReleased(EMPTY_POOL);
		}
		int expected = 0;
		int actual = pool.getPool().size();
		assertEquals(expected, actual);
	}

	/**
	 * Tests the exception when the pool is empty.
	 *
	 * @throws NoAvailableResource
	 *             if no resources are available
	 * @throws AllReusableReleased
	 *             when the pool is empty
	 */
	@Test(expected = NoAvailableResource.class)
	public void testEmptyPool() throws NoAvailableResource, AllReusableReleased {
		Pool<Integer> pool = new Pool<>(MAX_POOL_SIZE);
		pool.release(sampleResource);
		pool.acquire();
		pool.acquire();
	}

}
