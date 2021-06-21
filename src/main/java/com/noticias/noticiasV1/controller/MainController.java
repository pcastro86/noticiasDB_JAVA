package com.noticias.noticiasV1.controller;

import com.noticias.noticiasV1.models.*;
import com.noticias.noticiasV1.models.responses.*;
import com.noticias.noticiasV1.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping(path = "/noticiasdb/v1")


public class MainController {

    //* === Autowired == *//
    @Autowired
    private CanalRepository canalRepository;
    @Autowired
    private VeredictoRepository veredictoRepository;
    @Autowired
    private PartidoRepository partidoRepository;
    @Autowired
    private PersonajeRepository personajeRepository;
    @Autowired
    private FuenteRepository fuenteRepository;
    @Autowired
    private FraseRepository fraseRepository;
    @Autowired
    private NoticiaRepository noticiaRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private ResourceRepository resourceRepository;

    //* === GET == *//

    @GetMapping(path = "/canal/all")
    public @ResponseBody
    Iterable<Canal> getAllCanal(){
        return canalRepository.findAll();
    }


    @GetMapping(path = "/veredicto/all")
    public @ResponseBody
    Iterable<Veredicto> getAllVeredictos(){
        return veredictoRepository.findAll();
    }


    @GetMapping(path = "/partido/all")
    public @ResponseBody
    Iterable<Partido> getAllPartidos(){
        return partidoRepository.findAll();
    }


    @GetMapping(path = "/personaje/all")
    public @ResponseBody
    Iterable<Personaje> getAllPersonaje(){
        return personajeRepository.findAll();
    }


    @GetMapping(path = "/fuente/all")
    public @ResponseBody
    Iterable<Fuente> getAllFuente(){
        return fuenteRepository.findAll();
    }


    @GetMapping(path = "/frase/all")
    public @ResponseBody
    Iterable<Frase> getAllFrase(){
        return fraseRepository.findAll();
    }


    @GetMapping(path = "/noticia/all")
    public @ResponseBody
    Iterable<Noticia> getAllNoticia(){
        return noticiaRepository.findAll();
    }


    @GetMapping(path = "/role/all")
    public @ResponseBody
    Iterable<Role> getAllRole(){
        return roleRepository.findAll();
    }

    @GetMapping(path = "/resource/all")
    public @ResponseBody
    Iterable<Resource> getAllResource(){
        return resourceRepository.findAll();
    }



    //* === GET BY ID == *//

    @GetMapping(path = "/canal/{id}")
    public @ResponseBody
    ResponseEntity<CanalResponse> getCanalById(@PathVariable("id") int id) {
        CanalResponse response = new CanalResponse();
        try {
            response.setCanal(canalRepository.findById(id).get());
            response.setMessage("OK!");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.setMessage("ID no encontrado :" + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping(path = "/frase/{id}")
    public @ResponseBody
    ResponseEntity<FraseResponse> getFraseById(@PathVariable("id") int id) {
        FraseResponse response = new FraseResponse();
        try {
            response.setFrase(fraseRepository.findById(id).get());
            response.setMessage("OK!");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.setMessage("ID no encontrado :" + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping(path = "/fuente/{id}")
    public @ResponseBody
    ResponseEntity<FuenteResponse> getFuenteById(@PathVariable("id") int id) {
        FuenteResponse response = new FuenteResponse();
        try {
            response.setFuente(fuenteRepository.findById(id).get());
            response.setMessage("OK!");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.setMessage("ID no encontrado :" + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping(path = "/noticia/{id}")
    public @ResponseBody
    ResponseEntity<NoticiaResponse> getNoticiaById(@PathVariable("id") int id) {
        NoticiaResponse response = new NoticiaResponse();
        try {
            response.setNoticia(noticiaRepository.findById(id).get());
            response.setMessage("OK!");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.setMessage("ID no encontrado : " + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping(path = "/partido/{id}")
    public @ResponseBody
    ResponseEntity<PartidoResponse> getPartidoById(@PathVariable("id") int id) {
        PartidoResponse response = new PartidoResponse();
        try {
            response.setPartido(partidoRepository.findById(id).get());
            response.setMessage("OK!");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.setMessage("ID no encontrado : " + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping(path = "/personaje/{id}")
    public @ResponseBody
    ResponseEntity<PersonajeResponse> getPersonajeById(@PathVariable("id") int id) {
        PersonajeResponse response = new PersonajeResponse();
        try {
            response.setPersonaje(personajeRepository.findById(id).get());
            response.setMessage("OK!");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.setMessage("ID no encontrado : " + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping(path = "/veredicto/{id}")
    public @ResponseBody
    ResponseEntity<VeredictoResponse> getVeredictoById(@PathVariable("id") int id) {
        VeredictoResponse response = new VeredictoResponse();
        try {
            response.setVeredicto(veredictoRepository.findById(id).get());
            response.setMessage("OK!");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.setMessage("ID no encontrado : " + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping(path = "/user/{id}")
    public @ResponseBody
    Optional<User> getUserById(@PathVariable("id") int id) {
        return userRepository.findById(id);
    }

    @GetMapping(path = "/role/{id}")
    public @ResponseBody
    Optional<Role> getRoleById(@PathVariable("id") int id) {
        return roleRepository.findById(id);
    }


    @GetMapping(path = "/resource/{id}")
    public @ResponseBody
    Optional<Resource> getResourceById(@PathVariable("id") int id) {
        return resourceRepository.findById(id);
    }


    //* === GET ROLES BY ID == *//

    @GetMapping(path = "/role/all/user/{userId}")
    public @ResponseBody
    Collection<Role> getRoleByUserId(@PathVariable("userId") String userId) {
        return roleRepository.getRolesByUserId(userId);
    }


    /* PUT */

    @PutMapping(path = "user/{id_user}/personaje/update", consumes = "application/json", produces = "application/json")
    public @ResponseBody
    ResponseEntity<GeneralResponse> updatePersonajeByRole(@PathVariable("id_user") String id_user,@RequestBody Personaje personajeactualizada ) {
        GeneralResponse response = new GeneralResponse();

        try {
            Collection<Role> rolesByUser = roleRepository.getRolesByUserId(id_user);
            for (Role r : rolesByUser) {
                if(r.getName().equals("admin")){
                    personajeRepository.save(personajeactualizada);
                    response.setCode(HttpStatus.OK.value());
                    response.setMessage("El registro : " + personajeactualizada.getName() + " fue modificado con exito");
                    return ResponseEntity.ok(response);
                }
            }
            response.setCode(HttpStatus.UNAUTHORIZED.value());
            response.setMessage("Acceso denegado!. Usuario no autorizado para realizar esta accion");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.setCode(500);
            response.setMessage("Se produjo un error: " + " - " + e.getLocalizedMessage());
            return ResponseEntity.ok(response);
        }
    }

    @PutMapping(path = "user/{id_user}/fuente/update", consumes = "application/json", produces = "application/json")
    public @ResponseBody
    ResponseEntity<GeneralResponse> updateFuenteByRole(@PathVariable("id_user") String id_user,@RequestBody Fuente fuenteactualizada ) {
        GeneralResponse response = new GeneralResponse();

        try {
            Collection<Role> rolesByUser = roleRepository.getRolesByUserId(id_user);
            for (Role r : rolesByUser) {
                if(r.getName().equals("admin")){
                    fuenteRepository.save(fuenteactualizada);
                    response.setCode(HttpStatus.OK.value());
                    response.setMessage("El registro : " + fuenteactualizada.getName() + " fue modificado con exito");
                    return ResponseEntity.ok(response);
                }
            }
            response.setCode(HttpStatus.UNAUTHORIZED.value());
            response.setMessage("Acceso denegado!. Usuario no autorizado para realizar esta accion");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.setCode(500);
            response.setMessage("Se produjo un error: " + " - " + e.getLocalizedMessage());
            return ResponseEntity.ok(response);
        }
    }


    @PutMapping(path = "user/{id_user}/canal/update", consumes = "application/json", produces = "application/json")
    public @ResponseBody
    ResponseEntity<GeneralResponse> updateCanalByRole(@PathVariable("id_user") String id_user,@RequestBody Canal canalactualizada ) {
        GeneralResponse response = new GeneralResponse();

        try {
            Collection<Role> rolesByUser = roleRepository.getRolesByUserId(id_user);
            for (Role r : rolesByUser) {
                if(r.getName().equals("admin")){
                    canalRepository.save(canalactualizada);
                    response.setCode(HttpStatus.OK.value());
                    response.setMessage("El registro : " + canalactualizada.getName() + " fue modificado con exito");
                    return ResponseEntity.ok(response);
                }
            }
            response.setCode(HttpStatus.UNAUTHORIZED.value());
            response.setMessage("Acceso denegado!. Usuario no autorizado para realizar esta accion");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.setCode(500);
            response.setMessage("Se produjo un error: " + " - " + e.getLocalizedMessage());
            return ResponseEntity.ok(response);
        }
    }

    @PutMapping(path = "user/{id_user}/frase/update", consumes = "application/json", produces = "application/json")
    public @ResponseBody
    ResponseEntity<GeneralResponse> updateFraseByRole(@PathVariable("id_user") String id_user,@RequestBody Frase fraseactualizada ) {
        GeneralResponse response = new GeneralResponse();

        try {
            Collection<Role> rolesByUser = roleRepository.getRolesByUserId(id_user);
            for (Role r : rolesByUser) {
                if(r.getName().equals("admin")){
                    fraseRepository.save(fraseactualizada);
                    response.setCode(HttpStatus.OK.value());
                    response.setMessage("El registro con la frase: " + fraseactualizada.getFrase() + " fue modificado con exito");
                    return ResponseEntity.ok(response);
                }
            }
            response.setCode(HttpStatus.UNAUTHORIZED.value());
            response.setMessage("Acceso denegado!. Usuario no autorizado para realizar esta accion");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.setCode(500);
            response.setMessage("Se produjo un error: " + " - " + e.getLocalizedMessage());
            return ResponseEntity.ok(response);
        }
    }

    @PutMapping(path = "user/{id_user}/noticia/update", consumes = "application/json", produces = "application/json")
    public @ResponseBody
    ResponseEntity<GeneralResponse> updateNoticiaByRole(@PathVariable("id_user") String id_user,@RequestBody Noticia noticiaactualizada ) {
        GeneralResponse response = new GeneralResponse();

        try {
            Collection<Role> rolesByUser = roleRepository.getRolesByUserId(id_user);
            for (Role r : rolesByUser) {
                if(r.getName().equals("admin")){
                    noticiaRepository.save(noticiaactualizada);
                    response.setCode(HttpStatus.OK.value());
                    response.setMessage("El registro con id: " + noticiaactualizada.getId_noticia() + " fue modificado con exito");
                    return ResponseEntity.ok(response);
                }
            }
            response.setCode(HttpStatus.UNAUTHORIZED.value());
            response.setMessage("Acceso denegado!. Usuario no autorizado para realizar esta accion");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.setCode(500);
            response.setMessage("Se produjo un error: " + " - " + e.getLocalizedMessage());
            return ResponseEntity.ok(response);
        }
    }


    @PutMapping(path = "user/{id_user}/partido/update", consumes = "application/json", produces = "application/json")
    public @ResponseBody
    ResponseEntity<GeneralResponse> updatePartidoByRole(@PathVariable("id_user") String id_user,@RequestBody Partido partidoactualizado ) {
        GeneralResponse response = new GeneralResponse();

        try {
            Collection<Role> rolesByUser = roleRepository.getRolesByUserId(id_user);
            for (Role r : rolesByUser) {
                if(r.getName().equals("admin")){
                    partidoRepository.save(partidoactualizado);
                    response.setCode(HttpStatus.OK.value());
                    response.setMessage("El registro " + partidoactualizado.getName() + " fue modificado con exito");
                    return ResponseEntity.ok(response);
                }
            }
            response.setCode(HttpStatus.UNAUTHORIZED.value());
            response.setMessage("Acceso denegado!. Usuario no autorizado para realizar esta accion");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.setCode(500);
            response.setMessage("Se produjo un error: " + " - " + e.getLocalizedMessage());
            return ResponseEntity.ok(response);
        }
    }

    @PutMapping(path = "user/{id_user}/veredicto/update", consumes = "application/json", produces = "application/json")
    public @ResponseBody
    ResponseEntity<GeneralResponse> updateVeredictoByRole(@PathVariable("id_user") String id_user,@RequestBody Veredicto veredictoactualizado ) {
        GeneralResponse response = new GeneralResponse();

        try {
            Collection<Role> rolesByUser = roleRepository.getRolesByUserId(id_user);
            for (Role r : rolesByUser) {
                if(r.getName().equals("admin")){
                    veredictoRepository.save(veredictoactualizado);
                    response.setCode(HttpStatus.OK.value());
                    response.setMessage("El registro " + veredictoactualizado.getVeredicto() + " fue modificado con exito");
                    return ResponseEntity.ok(response);
                }
            }
            response.setCode(HttpStatus.UNAUTHORIZED.value());
            response.setMessage("Acceso denegado!. Usuario no autorizado para realizar esta accion");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.setCode(500);
            response.setMessage("Se produjo un error: " + " - " + e.getLocalizedMessage());
            return ResponseEntity.ok(response);
        }
    }



    //* == POST  == //

    @PostMapping(path = "user/{id_user}/fuente/add", consumes = "application/json", produces = "application/json")
    public @ResponseBody
    ResponseEntity<GeneralResponse> postFuenteByRole(@PathVariable("id_user") String id_user,@RequestBody Fuente fuentecreada ) {
        GeneralResponse response = new GeneralResponse();

        try {
            Collection<Role> rolesByUser = roleRepository.getRolesByUserId(id_user);
            for (Role r : rolesByUser) {
                if(r.getName().equals("admin")){
                    fuenteRepository.save(fuentecreada);
                    response.setCode(HttpStatus.OK.value());
                    response.setMessage("El registro fue agregado con exito");
                    return ResponseEntity.ok(response);
                }
            }
            response.setCode(HttpStatus.UNAUTHORIZED.value());
            response.setMessage("Usuario no autorizado para realizar esta accion");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.setCode(500);
            response.setMessage("Se produjo un error: " + " - " + e.getMessage());
            return ResponseEntity.ok(response);
        }
    }

    @PostMapping(path = "user/{id_user}/canal/add", consumes = "application/json", produces = "application/json")
    public @ResponseBody
    ResponseEntity<GeneralResponse> postCanalByRole(@PathVariable("id_user") String id_user,@RequestBody Canal canalcreado ) {
        GeneralResponse response = new GeneralResponse();

        try {
            Collection<Role> rolesByUser = roleRepository.getRolesByUserId(id_user);
            for (Role r : rolesByUser) {
                if(r.getName().equals("admin")){
                    canalRepository.save(canalcreado);
                    response.setCode(HttpStatus.OK.value());
                    response.setMessage("El registro fue agregado con exito");
                    return ResponseEntity.ok(response);
                }
            }
            response.setCode(HttpStatus.UNAUTHORIZED.value());
            response.setMessage("Usuario no autorizado para realizar esta accion");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.setCode(500);
            response.setMessage("Se produjo un error: " + " - " + e.getMessage());
            return ResponseEntity.ok(response);
        }
    }

    @PostMapping(path = "user/{id_user}/frase/add", consumes = "application/json", produces = "application/json")
    public @ResponseBody
    ResponseEntity<GeneralResponse> postFraseByRole(@PathVariable("id_user") String id_user,@RequestBody Frase frasecreada ) {
        GeneralResponse response = new GeneralResponse();

        try {
            Collection<Role> rolesByUser = roleRepository.getRolesByUserId(id_user);
            for (Role r : rolesByUser) {
                if(r.getName().equals("admin")){
                    fraseRepository.save(frasecreada);
                    response.setCode(HttpStatus.OK.value());
                    response.setMessage("El registro fue agregado con exito");
                    return ResponseEntity.ok(response);
                }
            }
            response.setCode(HttpStatus.UNAUTHORIZED.value());
            response.setMessage("Usuario no autorizado para realizar esta accion");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.setCode(500);
            response.setMessage("Se produjo un error: " + " - " + e.getMessage());
            return ResponseEntity.ok(response);
        }
    }

    @PostMapping(path = "user/{id_user}/partido/add", consumes = "application/json", produces = "application/json")
    public @ResponseBody
    ResponseEntity<GeneralResponse> postPartidoByRole(@PathVariable("id_user") String id_user,@RequestBody Partido partidocreado ) {
        GeneralResponse response = new GeneralResponse();

        try {
            Collection<Role> rolesByUser = roleRepository.getRolesByUserId(id_user);
            for (Role r : rolesByUser) {
                if(r.getName().equals("admin")){
                    partidoRepository.save(partidocreado);
                    response.setCode(HttpStatus.OK.value());
                    response.setMessage("El registro fue agregado con exito");
                    return ResponseEntity.ok(response);
                }
            }
            response.setCode(HttpStatus.UNAUTHORIZED.value());
            response.setMessage("Usuario no autorizado para realizar esta accion");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.setCode(500);
            response.setMessage("Se produjo un error: " + " - " + e.getMessage());
            return ResponseEntity.ok(response);
        }
    }


    @PostMapping(path = "user/{id_user}/personaje/add", consumes = "application/json", produces = "application/json")
    public @ResponseBody
    ResponseEntity<GeneralResponse> postPersonajeByRole(@PathVariable("id_user") String id_user,@RequestBody Personaje personajecreado ) {
        GeneralResponse response = new GeneralResponse();

        try {
            Collection<Role> rolesByUser = roleRepository.getRolesByUserId(id_user);
            for (Role r : rolesByUser) {
                if(r.getName().equals("admin")){
                    personajeRepository.save(personajecreado);
                    response.setCode(HttpStatus.OK.value());
                    response.setMessage("El registro fue agregado con exito");
                    return ResponseEntity.ok(response);
                }
            }
            response.setCode(HttpStatus.UNAUTHORIZED.value());
            response.setMessage("Usuario no autorizado para realizar esta accion");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.setCode(500);
            response.setMessage("Se produjo un error: " + " - " + e.getMessage());
            return ResponseEntity.ok(response);
        }
    }

    @PostMapping(path = "user/{id_user}/veredicto/add", consumes = "application/json", produces = "application/json")
    public @ResponseBody
    ResponseEntity<GeneralResponse> postVeredictoByRole(@PathVariable("id_user") String id_user,@RequestBody Veredicto veredictocreado ) {
        GeneralResponse response = new GeneralResponse();

        try {
            Collection<Role> rolesByUser = roleRepository.getRolesByUserId(id_user);
            for (Role r : rolesByUser) {
                if(r.getName().equals("admin")){
                    veredictoRepository.save(veredictocreado);
                    response.setCode(HttpStatus.OK.value());
                    response.setMessage("El registro fue agregado con exito");
                    return ResponseEntity.ok(response);
                }
            }
            response.setCode(HttpStatus.UNAUTHORIZED.value());
            response.setMessage("Usuario no autorizado para realizar esta accion");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.setCode(500);
            response.setMessage("Se produjo un error: " + " - " + e.getMessage());
            return ResponseEntity.ok(response);
        }
    }

    @PostMapping(path = "user/{id_user}/noticia/add", consumes = "application/json", produces = "application/json")
    public @ResponseBody
    ResponseEntity<GeneralResponse> postNoticiaByRole(@PathVariable("id_user") String id_user,@RequestBody Noticia noticiacreado ) {
        GeneralResponse response = new GeneralResponse();
        try {
            Collection<Role> rolesByUser = roleRepository.getRolesByUserId(id_user);
            for (Role r : rolesByUser) {
                if(r.getName().equals("admin")){
                    noticiaRepository.save(noticiacreado);
                    response.setCode(HttpStatus.OK.value());
                    response.setMessage("El registro fue agregado con exito");
                    return ResponseEntity.ok(response);
                }
            }
            response.setCode(HttpStatus.UNAUTHORIZED.value());
            response.setMessage("Usuario no autorizado para realizar esta accion");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.setCode(500);
            response.setMessage("Se produjo un error: " + " - " + e.getMessage());
            return ResponseEntity.ok(response);
        }
    }


    //* === DELETE  == *//


    @DeleteMapping(path = "user/{id_user}/noticia/delete/{id_noticia}")
    public @ResponseBody
    ResponseEntity<GeneralResponse> deleteNoticiaByRole(@PathVariable("id_user") String id_user, @PathVariable("id_noticia") int id_noticia ) {
        GeneralResponse response = new GeneralResponse();
        Collection<Role> rolesByUser = roleRepository.getRolesByUserId(id_user);
        for (Role r : rolesByUser) {
            if(r.getName().equals("admin")){
                noticiaRepository.deleteById(id_noticia);
                response.setCode(HttpStatus.OK.value());
                response.setMessage("La noticia fue eliminada id : " + id_noticia);
                return ResponseEntity.ok(response);
            }
        }
        response.setCode(HttpStatus.UNAUTHORIZED.value());
        response.setMessage("Usuario no autorizado para realizar esta accion");
        return ResponseEntity.ok(response);
    }



    @DeleteMapping(path = "user/{id_user}/fuente/delete/{id_fuente}")
    public @ResponseBody
    ResponseEntity<GeneralResponse> deleteFuenteByRole(@PathVariable("id_user") String id_user, @PathVariable("id_fuente") int id_fuente ) {
       GeneralResponse response = new GeneralResponse();

        try {
            Collection<Role> rolesByUser = roleRepository.getRolesByUserId(id_user);
            for (Role r : rolesByUser) {
                if(r.getName().equals("admin")){
                    fuenteRepository.deleteById(id_fuente);
                    response.setCode(HttpStatus.OK.value());
                    response.setMessage("La fuente fue eliminado id : " + id_fuente);
                    return ResponseEntity.ok(response);
                }
            }
            response.setCode(HttpStatus.UNAUTHORIZED.value());
            response.setMessage("Usuario no autorizado para realizar esta accion");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.setCode(HttpStatus.CONFLICT.value());
            response.setMessage("No se puede eliminar ya que esta entidad esta asociada a otra" + " - " + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }



    @DeleteMapping(path = "user/{id_user}/canal/delete/{id_canal}")
    public @ResponseBody
    ResponseEntity<GeneralResponse> deleteCanalByRole(@PathVariable("id_user") String id_user, @PathVariable("id_canal") int id_canal ) {
        GeneralResponse response = new GeneralResponse();

        try {
            Collection<Role> rolesByUser = roleRepository.getRolesByUserId(id_user);
            for (Role r : rolesByUser) {
                if(r.getName().equals("admin")){
                    canalRepository.deleteById(id_canal);
                    response.setCode(HttpStatus.OK.value());
                    response.setMessage("El registro fue eliminado id : " + id_canal);
                    return ResponseEntity.ok(response);
                }
            }
            response.setCode(HttpStatus.UNAUTHORIZED.value());
            response.setMessage("Usuario no autorizado para realizar esta accion");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.setCode(HttpStatus.CONFLICT.value());
            response.setMessage("No se puede eliminar ya que esta entidad esta asociada a otra" + " - " + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }


    @DeleteMapping(path = "user/{id_user}/frase/delete/{id_frase}")
    public @ResponseBody
    ResponseEntity<GeneralResponse> deleteFraseByRole(@PathVariable("id_user") String id_user, @PathVariable("id_frase") int id_frase ) {
        GeneralResponse response = new GeneralResponse();

        try {
            Collection<Role> rolesByUser = roleRepository.getRolesByUserId(id_user);
            for (Role r : rolesByUser) {
                if(r.getName().equals("admin")){
                    fraseRepository.deleteById(id_frase);
                    response.setCode(HttpStatus.OK.value());
                    response.setMessage("El registro fue eliminado id : " + id_frase);
                    return ResponseEntity.ok(response);
                }
            }
            response.setCode(HttpStatus.UNAUTHORIZED.value());
            response.setMessage("Usuario no autorizado para realizar esta accion");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.setCode(HttpStatus.CONFLICT.value());
            response.setMessage("No se puede eliminar ya que esta entidad esta asociada a otra" + " - " + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }


    @DeleteMapping(path = "user/{id_user}/partido/delete/{id_partido}")
    public @ResponseBody
    ResponseEntity<GeneralResponse> deletePartidoByRole(@PathVariable("id_user") String id_user, @PathVariable("id_partido") int id_partido ) {
        GeneralResponse response = new GeneralResponse();

        try {
            Collection<Role> rolesByUser = roleRepository.getRolesByUserId(id_user);
            for (Role r : rolesByUser) {
                if(r.getName().equals("admin")){
                    partidoRepository.deleteById(id_partido);
                    response.setCode(HttpStatus.OK.value());
                    response.setMessage("El registro fue eliminado id : " + id_partido);
                    return ResponseEntity.ok(response);
                }
            }
            response.setCode(HttpStatus.UNAUTHORIZED.value());
            response.setMessage("Usuario no autorizado para realizar esta accion");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.setCode(HttpStatus.CONFLICT.value());
            response.setMessage("No se puede eliminar ya que esta entidad esta asociada a otra" + " - " + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }


    @DeleteMapping(path = "user/{id_user}/personaje/delete/{id_personaje}")
    public @ResponseBody
    ResponseEntity<GeneralResponse> deletePersonajeByRole(@PathVariable("id_user") String id_user, @PathVariable("id_personaje") int id_personaje ) {
        GeneralResponse response = new GeneralResponse();

        try {
            Collection<Role> rolesByUser = roleRepository.getRolesByUserId(id_user);
            for (Role r : rolesByUser) {
                if(r.getName().equals("admin")){
                    personajeRepository.deleteById(id_personaje);
                    response.setCode(HttpStatus.OK.value());
                    response.setMessage("El registro fue eliminado id : " + id_personaje);
                    return ResponseEntity.ok(response);
                }
            }
            response.setCode(HttpStatus.UNAUTHORIZED.value());
            response.setMessage("Usuario no autorizado para realizar esta accion");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.setCode(HttpStatus.CONFLICT.value());
            response.setMessage("No se puede eliminar ya que esta entidad esta asociada a otra" + " - " + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }


    @DeleteMapping(path = "user/{id_user}/veredicto/delete/{id_veredicto}")
    public @ResponseBody
    ResponseEntity<GeneralResponse> deleteVeredictoByRole(@PathVariable("id_user") String id_user, @PathVariable("id_veredicto") int id_veredicto ) {
        GeneralResponse response = new GeneralResponse();

        try {
            Collection<Role> rolesByUser = roleRepository.getRolesByUserId(id_user);
            for (Role r : rolesByUser) {
                if(r.getName().equals("admin")){
                    veredictoRepository.deleteById(id_veredicto);
                    response.setCode(HttpStatus.OK.value());
                    response.setMessage("El registro fue eliminado id : " + id_veredicto);
                    return ResponseEntity.ok(response);
                }
            }
            response.setCode(HttpStatus.UNAUTHORIZED.value());
            response.setMessage("Usuario no autorizado para realizar esta accion");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.setCode(HttpStatus.CONFLICT.value());
            response.setMessage("No se puede eliminar ya que esta entidad esta asociada a otra" + " - " + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

}
