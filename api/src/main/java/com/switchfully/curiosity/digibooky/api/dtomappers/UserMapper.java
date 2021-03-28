package com.switchfully.curiosity.digibooky.api.dtomappers;

import com.switchfully.curiosity.digibooky.api.dtos.CreateDtoUser;
import com.switchfully.curiosity.digibooky.api.dtos.DtoUser;
import com.switchfully.curiosity.digibooky.domain.entities.users.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User changeCreateDtoUserToUser(CreateDtoUser createDtoUser) {
        return new User(
                createDtoUser.getINSS(),
                createDtoUser.getLastName(),
                createDtoUser.getFirstName(),
                createDtoUser.getEmail(),
                createDtoUser.getAddress()
        );
    }

    public DtoUser changeUserToDtoUser(User user) {
        //BUILDER SETTERS ON (FLUENT API)
        return new DtoUser()
                .setId(user.getId())
                .setINSS(user.getInss())
                .setLastName(user.getLastname())
                .setFirstName(user.getFirstname())
                .setEmail(user.getEmail())
                .setAddress(user.getAddress());
        //NOT BUILDER SETTERS
//        DtoUser dtoUser = new DtoUser();
//        dtoUser.setId(user.getId());
//        dtoUser.setINSS(user.getInss());
//        dtoUser.setLastName(user.getLastname());
//        dtoUser.setFirstName(user.getFirstname());
//        dtoUser.setEmail(user.getEmail());
//        dtoUser.setAddress(user.getAddress());
//        return dtoUser;
    }
}



