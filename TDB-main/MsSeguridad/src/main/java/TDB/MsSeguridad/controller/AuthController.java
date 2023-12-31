package TDB.MsSeguridad.controller;

import java.util.List;
import java.util.Optional;

import TDB.MsSeguridad.dtos.UserRequest;
import TDB.MsSeguridad.dtos.UserResponse;
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

    @GetMapping("/getallusers")
    public ResponseEntity<?> getAll() {
       try{
        return ResponseEntity.status(HttpStatus.OK).body(authService.getAll());
       }catch(Exception e){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erorr inesperado");
       }
    }
    @GetMapping("/finduserbyid/{id}")
    public ResponseEntity<?> getById(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.OK).body(authService.getById(id));
    }

    @DeleteMapping("/eliminar/{id}")
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
}
