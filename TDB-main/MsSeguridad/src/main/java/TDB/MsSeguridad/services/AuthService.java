package TDB.MsSeguridad.services;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import TDB.MsSeguridad.dtos.UserMapper;
import TDB.MsSeguridad.dtos.UserRequest;
import TDB.MsSeguridad.dtos.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import TDB.MsSeguridad.repository.IAuthRepository;
import TDB.MsSeguridad.model.UsuarioModel;

@Service
public class AuthService {
    
    @Autowired
    IAuthRepository authRepository;

    public List<UserResponse> getAll() {
        List<UsuarioModel> usuarios= (List<UsuarioModel>) authRepository.findAll();
        List<UserResponse> userResponses=usuarios.stream().map(
                usuario-> UserMapper.mapper.userToUserResponse(usuario)).collect(Collectors.toList()); ////


        return userResponses;
    }
    public UserResponse getById(int id){

          UsuarioModel usuarioModel=authRepository.findById(id).orElse(null);//
          return UserMapper.mapper.userToUserResponse(usuarioModel);
    }

    public boolean deleteById(int id){
        try {
            UsuarioModel mo=authRepository.findById(id).orElseThrow();//
            authRepository.delete(mo);
            return true;
        }catch (Exception e ){
            return false;
        }

    }

    public UserResponse crearUsuario(UserRequest user){
        UsuarioModel usuarioModel= UserMapper.mapper.userRequestToUser(user);
            usuarioModel.setCreatedAt(getCurrentDate());
        return UserMapper.mapper.userToUserResponse(authRepository.save(usuarioModel));//
    }
//actualizar by Neil

public UserResponse actualizarUsuario(UserRequest userRQ){
    UsuarioModel user=UserMapper.mapper.userRequestToUser(userRQ);
    user.setUpdatedAt(getCurrentDate());

    UsuarioModel tmpUser=authRepository.findById(user.getIdUsuario()).orElse(null);
    if(tmpUser!=null){
        if(user.getUsername()==null){
            user.setUsername(tmpUser.getUsername());
        }
        if(user.getPassword()==null){
        user.setPassword(tmpUser.getPassword());
        }
        user.setCreatedAt(tmpUser.getCreatedAt());
        user.setUpdatedAt(getCurrentDate());
        return UserMapper.mapper.userToUserResponse(authRepository.save(user));
    }


    return null;
}

    public Date getCurrentDate(){
        return  java.util.Date
                .from(LocalDateTime.now().atZone(java.time.ZoneId.systemDefault())
                        .toInstant());
    }
}
