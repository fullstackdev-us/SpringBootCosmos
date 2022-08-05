package com.example.sbcosmos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.sbcosmos.interfaces.IToDoService;
import com.example.sbcosmos.models.Item;

@RestController
public class ToDoController {
    @Autowired
    private IToDoService todoService;

    @GetMapping("/todo")
    public @ResponseBody Iterable<Item> get() {
        return todoService.listItems();
    }

    @PostMapping("/todo")
    public @ResponseBody Item post(@RequestBody Item item) {
        return todoService.createItem(item);
    }

    @PutMapping("/todo")
    public @ResponseBody Item put(@RequestBody Item item) {
        return todoService.updateItem(item);
    }

    @DeleteMapping("/todo")
    public @ResponseBody void delete(@RequestParam String id) {
        this.todoService.deleteItem(id);
    }
}
