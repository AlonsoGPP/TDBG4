package TDB.MsSeguridad.controller;

import java.util.List;
import java.util.Optional;

import TDB.MsSeguridad.dtos.UserRequest;
import TDB.MsSeguridad.dtos.UserResponse;
import TDB.MsSeguridad.jwt.JwtToken;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import TDB.MsSeguridad.services.AuthService;

import TDB.MsSeguridad.model.UsuarioModel;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    
    @Autowired
    private JwtToken jwtTokenCroos;

    @GetMapping("/users")
    public ResponseEntity<?> getAll() {
       try{
        return ResponseEntity.status(HttpStatus.OK).body(authService.getAll());
       }catch(Exception e){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erorr inesperado" + e);
       }
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<?> getById(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.OK).body(authService.getById(id));
    }

    @DeleteMapping("/users/{id}")
      public ResponseEntity<?> deleteById(@PathVariable int id){
        if(authService.deleteById(id)){
            return ResponseEntity.status(HttpStatus.OK).body("Borrado correcto");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erorr no se encontro el usuario");
        }

      }
      @PostMapping("/crear")
      public ResponseEntity<?> crearUsuario(@RequestBody UserRequest user) {

      try {

         return ResponseEntity.status(HttpStatus.CREATED).body(authService.crearUsuario(user));

      }catch(Exception e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error");
      }
      }
      
      //by Neil
      @PutMapping("/actualizar")
      public ResponseEntity<?> actualizarUsuario( @RequestBody UserRequest user){
         try {
             UserResponse userR=authService.actualizarUsuario(user);
             if(userR!=null){
             return  ResponseEntity.status(HttpStatus.OK).body(userR);
             }else{
                 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error No se encontro el usuario");
             }
         }catch (Exception e){
          return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error");}
      }


      @PostMapping()
      public ResponseEntity<?> post(@RequestBody UserRequest requestUsu) throws Exception{
          try {
              if (!authService.validarCredenciales(requestUsu.getUsername(), requestUsu.getPassword())) {
                  return new ResponseEntity<String>("INVALID_CREDENTIALS", HttpStatus.UNAUTHORIZED);
              }
  
              String token = jwtTokenCroos.generateToken(requestUsu);
              UserResponse response = new UserResponse(token, requestUsu.get(), "1d");
  
              return ResponseEntity.ok(response);
          } catch (Exception e) {
              // Manejo de la excepción
             //logger.error(MensajesParametrizados.MENSAJE_ERROR_AUTENTICACION, e.getMessage());
              return new ResponseEntity<String>("INTERNAL_SERVER_ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
          }
      }

}
