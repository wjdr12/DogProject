package ni.devotion.catfactsapp.room

import ni.devotion.catfactsapp.model.Cat
import ni.devotion.catfactsapp.utils.EntityMapper
import javax.inject.Inject

class CacheMapper
@Inject
constructor():
    EntityMapper<CatCacheEntity, Cat> {
    override fun mapFromEntity(entity: CatCacheEntity): Cat {
        return Cat(
            id = entity.id,
            url = entity.url,
            height = entity.height,
            width = entity.width
        )
    }

    override fun mapToEntity(domainModel: Cat): CatCacheEntity {
        return CatCacheEntity(
            id = domainModel.id,
            url = domainModel.url,
            height = domainModel.height,
            width = domainModel.width
        )
    }
}
