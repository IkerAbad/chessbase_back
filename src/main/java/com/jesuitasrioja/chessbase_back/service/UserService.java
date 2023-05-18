package com.jesuitasrioja.chessbase_back.service;

import com.jesuitasrioja.chessbase_back.exceptions.ChessbaseExceptions;
import com.jesuitasrioja.chessbase_back.mapper.UserInDTOtoUser;
import com.jesuitasrioja.chessbase_back.persistence.entity.User;
import com.jesuitasrioja.chessbase_back.persistence.repository.UserRepository;
import com.jesuitasrioja.chessbase_back.service.dto.UserInDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;
    private final UserInDTOtoUser mapper;

    public UserService(UserRepository repository, UserInDTOtoUser mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public User createUser(UserInDTO userInDTO){
        User user = mapper.map(userInDTO);
        return this.repository.save(user);
    }

    public List<User> findAll(){
        return this.repository.findAll();
    }

    public void deleteById(Long id){
        Optional<User> optionalTask = this.repository.findById(id);
        if(optionalTask.isEmpty()){
            throw new ChessbaseExceptions("Task not found", HttpStatus.NOT_FOUND);
        }
        this.repository.deleteById(id);
    }

    public User updateUserById(User idUser) {
        Optional<User> user= null;
        try{
            user= repository.findById(user.get().getId());
            if (user.isPresent()){
                repository.save(idUser);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user.get();
    }
}
