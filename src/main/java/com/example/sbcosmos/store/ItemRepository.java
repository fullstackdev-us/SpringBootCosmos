package com.example.sbcosmos.store;

import com.azure.spring.data.cosmos.repository.ReactiveCosmosRepository;
import com.example.sbcosmos.models.Item;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends ReactiveCosmosRepository<Item, String> {

}