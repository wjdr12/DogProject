package ni.devotion.catfactsapp.retrofit

import ni.devotion.catfactsapp.model.Cat
import ni.devotion.catfactsapp.utils.EntityMapper
import javax.inject.Inject

class NetworkMapper
@Inject
constructor(): EntityMapper<CatNetworkEntity, Cat> {
    override fun mapFromEntity(entity: CatNetworkEntity): Cat {
        return Cat(
            id = entity.id,
            url = entity.url,
            height = entity.height,
            width = entity.width
        )
    }


    override fun mapToEntity(domainModel: Cat): CatNetworkEntity {
        return CatNetworkEntity(
            id = domainModel.id,
            url = domainModel.url,
            height = domainModel.height,
            width = domainModel.width
        )
    }
}