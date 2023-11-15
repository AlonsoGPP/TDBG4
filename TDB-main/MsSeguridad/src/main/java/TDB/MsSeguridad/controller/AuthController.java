package TDB.MsSeguridad.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import TDB.MsSeguridad.services.AuthService;

import TDB.MsSeguridad.model.UsuarioModel;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @GetMapping("/getallusers")
    public List<UsuarioModel> getAll() {
        return authService.getAll();
    }
    @GetMapping("/finduserbyid/{id}")
    public Optional<UsuarioModel> getById(@PathVariable int id){
        return authService.getById(id);
    }

    @DeleteMapping("/eliminar/{id}")
      public ResponseEntity<UsuarioModel> deleteById(@PathVariable int id){
        authService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
      @PostMapping("/crear")
      public ResponseEntity<UsuarioModel> crearUsuario(@RequestBody UsuarioModel user) {
      UsuarioModel newUser= authService.crearUsuario(user);
          return new ResponseEntity<>(user, HttpStatus.CREATED);
      }
    }
