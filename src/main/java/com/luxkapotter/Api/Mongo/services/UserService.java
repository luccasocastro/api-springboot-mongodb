package com.luxkapotter.Api.Mongo.services;

import com.luxkapotter.Api.Mongo.entities.User;
import com.luxkapotter.Api.Mongo.entities.UserRequestDTO;
import com.luxkapotter.Api.Mongo.repositories.UserRepository;
import com.luxkapotter.Api.Mongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public Optional<User> findById(String id){
        Optional<User> user = repository.findById(id);
        if(user.isEmpty()){
            throw new ObjectNotFoundException("User doesn't exists!");
        }
        return user;
    }

    public User insert(User obj){
        return repository.insert(obj);
    }

    public void delete(String id){
        findById(id);
        repository.deleteById(id);
    }

    public User update(User obj){
        Optional<User> newUser = repository.findById(obj.getId());
        updateData(newUser, obj);
        return repository.save(newUser.get());
    }

    public void updateData(Optional<User> newObj, User obj){
        newObj.get().setName(obj.getName());
        newObj.get().setEmail(obj.getEmail());
    }

    public User fromDTO(UserRequestDTO objDto){
        return new User(null, objDto.name(), objDto.email());
    }
}
