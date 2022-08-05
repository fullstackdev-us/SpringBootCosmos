package com.example.sbcosmos.interfaces;

import com.example.sbcosmos.models.Item;

public interface IToDoService {
    public Item getItem(String id);
    public Iterable<Item> listItems();
    public Item createItem(Item item);
    public Item updateItem(Item item);
    public void deleteItem(String id);
}