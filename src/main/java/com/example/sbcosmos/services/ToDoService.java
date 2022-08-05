package com.example.sbcosmos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sbcosmos.exceptions.ItemNotFoundException;
import com.example.sbcosmos.interfaces.IToDoService;
import com.example.sbcosmos.models.Item;
import com.example.sbcosmos.store.ItemRepository;

@Service
public class ToDoService implements IToDoService {
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Item getItem(String id) {
        return itemRepository.findById(id).block();
    }

    @Override
    public Iterable<Item> listItems() {
        return itemRepository.findAll().toIterable();
    }

    @Override
    public Item createItem(Item item) {
        Item newItem = new Item(item);

        return itemRepository.save(newItem).block();
    }

    @Override
    public Item updateItem(Item item) throws RuntimeException {
        boolean exists = itemRepository.existsById(item.getId().toString()).block();

        if (!exists) {
            throw new ItemNotFoundException("Item does not exist. Check the id.");
        }

        return itemRepository.save(item).block();
    }

    @Override
    public void deleteItem(String id) {
        boolean exists = itemRepository.existsById(id).block();

        if (!exists) {
            throw new ItemNotFoundException("Item does not exist. Check the id.");
        }

        itemRepository.deleteById(id);
    }
}
