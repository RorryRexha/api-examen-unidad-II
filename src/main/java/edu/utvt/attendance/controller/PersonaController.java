package edu.utvt.attendance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import edu.utvt.attendance.persistence.entities.Persona;
import edu.utvt.attendance.persistence.service.PersonaService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping
    public List<Persona> findAll() {
        return personaService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Persona> findById(@PathVariable UUID id) {
        return personaService.findById(id);
    }

    @GetMapping("/nombre/{nombre}")
    public List<Persona> findByNombre(@PathVariable String nombre) {
        return personaService.findByNombre(nombre);
    }

    @PostMapping
    public Persona save(@RequestBody Persona persona) {
        return personaService.save(persona);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        personaService.deleteById(id);
    }
}