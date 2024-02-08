package org.example;

import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Resolver implements GraphQLQueryResolver {

    @Autowired
    Repository repository;

    public Book bookByName(String bookName){
        Book found = repository.findByName(bookName);
        if (found == null) {
            repository.saveSuggestion(bookName);
            return null;
        }
        return found;
    }
}
