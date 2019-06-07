// tag::join[]
// tag::async[]
package example

import io.micronaut.data.annotation.*
import io.micronaut.data.repository.CrudRepository
import java.util.concurrent.CompletableFuture

@Repository
interface ProductRepository : CrudRepository<Product, Long> {
// end::join[]
// end::async[]

    // tag::join[]
    fun save(manufacturer: Manufacturer) : Manufacturer

    @JoinSpec("manufacturer") // <1>
    fun list(): List<Product>
    // end::join[]

    // tag::async[]
    fun findByNameContains(str: String): CompletableFuture<Product>

    fun countByManufacturerName(name: String): CompletableFuture<Long>
    // end::async[]
// tag::join[]
// tag::async[]
}
// end::join[]
// end::async[]
