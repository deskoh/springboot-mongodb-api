# SpringBoot MongoDB API

Application implements API using same MongoDB collection `itemDto` but returns JSON with renamed fields.

## Model / Entity

* A `type` field is present during JSON deserialization to distinguish the Item type (`DigitalItem` or `PhysicalItem`).

* `@JsonTypeInfo` attribute `visible` is by default `false` so that MongoDB does not store the `type` field as `_class`
field is already present. 

* `@JsonTypeInfo` specifies a `defaultImpl` to allow `type` field to be absent during deserialization (e.g. for 
backwards compatibility).

* A `@CompoundIndex` is specified to index `_class` field to retrieve Item by type efficiently.

* [TBD] For DTO, `defaultImpl` is not specified to make the `type` field required during deserialization.

## Repository

* `ItemRepository` is is the only Repository for `Item`.

* Note that using another repository of v2 model with `@TypeAlias` is not possible as the mapping of `_class` is unique.  

## Service

* `IItemService` is an interface class that specifies all methods to be used by controller.

* `ItemV1Service` and `ItemV2Service` extends from `IItemService`.

* `ItemV2Service` uses the mapper to map to new DTO. 

## Controller

* `ItemController` is an abstract class that implements the API.

* `ItemV1Controller` and `ItemV1Controller` extends the abstract controller with concrete types `Item` and `ItemDto`
respectively. Both are also annotated with `@RestController`.