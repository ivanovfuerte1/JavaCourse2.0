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

	/**
	 * Test the method acquire of the class {@link Pool}.
	 * 
	 * @throws NoAvailableResource
	 *             when no resources are available
	 */
	@Test
	public void testAcquire() throws NoAvailableResource {
		Pool<?> pool = new Pool<>(MAX_POOL_SIZE);
		try {
			pool.acquire();
			pool.acquire();
		} catch (NoAvailableResource e) {
			LOGGER.info(NO_RESOURCES, e);
		}
		int expected = 2;
		int actual = pool.getPool().size();
		assertEquals(expected, actual);
	}

	/**
	 * Tests the exception when no resources are available.
	 * 
	 * @throws NoAvailableResource
	 *             if no resources are available
	 */
	@Test(expected = NoAvailableResource.class)
	public void testNoResources() throws NoAvailableResource {
		Pool<?> pool = new Pool<>(MAX_POOL_SIZE);
		pool.acquire();
		pool.acquire();
		pool.acquire();
		pool.acquire();
		pool.acquire();
		pool.acquire();
		pool.acquire();
		pool.acquire();
		pool.acquire();
		pool.acquire();
		pool.acquire();
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
		Pool<?> pool = new Pool<>(MAX_POOL_SIZE);
		pool.acquire();
		try {
			pool.release();
		} catch (AllReusableReleased e) {
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
	@Test(expected = AllReusableReleased.class)
	public void testEmptyPool() throws NoAvailableResource, AllReusableReleased {
		Pool<?> pool = new Pool<>(MAX_POOL_SIZE);
		pool.acquire();
		pool.release();
		pool.release();
	}

}
