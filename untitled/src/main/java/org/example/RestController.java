package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    private Repository repository;

    @GetMapping("/search/{word}")
    public ResponseEntity<Object> search(@PathVariable String word){
        List<Book> found = repository.find(word);
        if (found.isEmpty()) {
            repository.saveSuggestion(word);
            return new ResponseEntity<>("not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(found, HttpStatus.OK);
    }
}