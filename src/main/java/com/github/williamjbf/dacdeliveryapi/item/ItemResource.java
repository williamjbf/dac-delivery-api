package com.github.williamjbf.dacdeliveryapi.item;

import com.github.williamjbf.dacdeliveryapi.item.model.Item;
import com.github.williamjbf.dacdeliveryapi.item.model.Item;
import com.github.williamjbf.dacdeliveryapi.item.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/itens")
public class ItemResource {
    
    @Autowired
    ItemRepository repository;

    @GetMapping("/{id}")
    public ResponseEntity<Item> find(@PathVariable("id") Long id){
        Optional<Item> item = repository.findById(id);
        return item.map(value -> ResponseEntity.status(HttpStatus.OK).body(value)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping
    public List<Item> listAll(){
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Item> create(@RequestBody Item item){
        final Item ItemSalvo = repository.save(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(ItemSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> update(@RequestBody Item item, @PathVariable("id") Long id){
        if(repository.findById(id).isPresent()){
            item.setId(id);
            final Item itemAtualizado = repository.save(item);
            return ResponseEntity.status(HttpStatus.OK).body(itemAtualizado);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        if(repository.findById(id).isPresent()){
            repository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();}

}
