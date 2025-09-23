package org.controlUniversitario.controladores;

import org.controlUniversitario.dtos.proveedor.ProveedorGuardar;
import org.controlUniversitario.dtos.proveedor.ProveedorModificar;
import org.controlUniversitario.dtos.proveedor.ProveedorSalida;
import org.controlUniversitario.interfaces.IProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedorController {
@Autowired
    private IProveedorService proveedorService;

    @GetMapping
    public ResponseEntity<Page<ProveedorSalida>> mostrarTodosPaginados(Pageable pageable){
        Page<ProveedorSalida> proveedores = proveedorService.obtenerTodosPaginados(pageable);
        if(proveedores.hasContent()){
            return ResponseEntity.ok(proveedores);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/lista")
    public ResponseEntity<List<ProveedorSalida>> mostrarTodos(){
        List<ProveedorSalida> proveedores = proveedorService.obtenerTodos();
        if(!proveedores.isEmpty()){
            return ResponseEntity.ok(proveedores);
        }

        return ResponseEntity.notFound().build();
    }


    @GetMapping("/{id}")
    public ResponseEntity<ProveedorSalida> buscarPorId(@PathVariable Integer id){
        ProveedorSalida proveedor = proveedorService.obtenerPorId(id);

        if(proveedor != null){
            return ResponseEntity.ok(proveedor);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ProveedorSalida> crear(@RequestBody ProveedorGuardar proveedorGuardar){
        ProveedorSalida proveedor = proveedorService.crear(proveedorGuardar);
        return ResponseEntity.ok(proveedor);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProveedorSalida> editar(@PathVariable Integer id, @RequestBody ProveedorModificar proveedorModificar){
        ProveedorSalida proveedor = proveedorService.editar(proveedorModificar);
        return ResponseEntity.ok(proveedor);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Integer id){
        proveedorService.eliminarPorId(id);
        return ResponseEntity.ok("Categoría eliminada correctamente");
    }
}
