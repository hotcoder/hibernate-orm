package org.hibernate.cache.infinispan.naturalid;

import org.hibernate.cache.CacheException;
import org.hibernate.cache.infinispan.access.PutFromLoadValidator;
import org.hibernate.cache.infinispan.impl.BaseTransactionalDataRegion;
import org.hibernate.cache.spi.CacheDataDescription;
import org.hibernate.cache.spi.NaturalIdRegion;
import org.hibernate.cache.spi.RegionFactory;
import org.hibernate.cache.spi.access.AccessType;
import org.hibernate.cache.spi.access.NaturalIdRegionAccessStrategy;
import org.infinispan.AdvancedCache;

/**
 * Natural ID cache region
 *
 * @author Strong Liu <stliu@hibernate.org>
 * @author Galder Zamarreño
 */
public class NaturalIdRegionImpl extends BaseTransactionalDataRegion
      implements NaturalIdRegion {

	public NaturalIdRegionImpl(AdvancedCache cache, String name,
         CacheDataDescription metadata, RegionFactory factory) {
		super(cache, name, metadata, factory);
	}

	@Override
	public NaturalIdRegionAccessStrategy buildAccessStrategy(AccessType accessType) throws CacheException {
		if (AccessType.READ_ONLY.equals(accessType)) {
			return new ReadOnlyAccess(this);
		} else if (AccessType.TRANSACTIONAL.equals(accessType)) {
			return new TransactionalAccess(this);
		}
		throw new CacheException("Unsupported access type [" + accessType.getExternalName() + "]");
	}

	public PutFromLoadValidator getPutFromLoadValidator() {
		return new PutFromLoadValidator(cache);
	}

}
