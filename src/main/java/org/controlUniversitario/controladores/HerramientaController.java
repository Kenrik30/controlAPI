package org.controlUniversitario.controladores;


import org.controlUniversitario.dtos.herramienta.HerramientaGuardar;
import org.controlUniversitario.dtos.herramienta.HerramientaModificar;
import org.controlUniversitario.dtos.herramienta.HerramientaSalida;
import org.controlUniversitario.implementaciones.HerramientaService;
import org.controlUniversitario.interfaces.IHerramientaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/herramientas")
public class HerramientaController {

    @Autowired
    private IHerramientaService herramientaService;
    @GetMapping
    public ResponseEntity<Page<HerramientaSalida>> mostrarTodosPaginados(Pageable pageable){
        Page<HerramientaSalida> herramientas = herramientaService.obtenerTodosPaginados(pageable);
        if(herramientas.hasContent()){
            return ResponseEntity.ok(herramientas);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/lista")
    public ResponseEntity<List<HerramientaSalida>> mostrarTodos(){
        List<HerramientaSalida> herramientas = herramientaService.obtenerTodos();
        if(!herramientas.isEmpty()){
            return ResponseEntity.ok(herramientas);
        }

        return ResponseEntity.notFound().build();
    }


    @GetMapping("/{id}")
    public ResponseEntity<HerramientaSalida> buscarPorId(@PathVariable Integer id){
        HerramientaSalida herramienta = herramientaService.obtenerPorId(id);

        if(herramienta != null){
            return ResponseEntity.ok(herramienta);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<HerramientaSalida> crear(@RequestBody HerramientaGuardar herramientaGuardar){
        HerramientaSalida herramienta = herramientaService.crear(herramientaGuardar);
        return ResponseEntity.ok(herramienta);
    }
    @PutMapping("/{id}")
    public ResponseEntity<HerramientaSalida> editar(@PathVariable Integer id, @RequestBody HerramientaModificar herramientaModificar){
        HerramientaSalida herramienta = herramientaService.editar(herramientaModificar);
        return ResponseEntity.ok(herramienta);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Integer id){
        herramientaService.eliminarPorId(id);
        return ResponseEntity.ok("Herramienta eliminada correctamente");
    }
}
