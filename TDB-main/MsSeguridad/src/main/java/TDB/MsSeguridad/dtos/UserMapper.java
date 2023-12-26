package TDB.MsSeguridad.dtos;

import TDB.MsSeguridad.model.UsuarioModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper mapper1 = Mappers.getMapper(UserMapper.class);

    UserResponse userToUserResponse(UsuarioModel usuarioModel);

    UsuarioModel userRequestToUser( UserRequest userRequest);

}
