package pe.store.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pe.store.model.Categoria;
import pe.store.service.GenericService;

import java.util.Collection;

@RestController
@RequestMapping("/categoria")
public class CategoriaRestController {

    @Autowired
    private GenericService<Categoria,Integer> categoriaService;

    @GetMapping("/listar")
    @ApiOperation(value = "Devuelve la lista de todas la categorias", httpMethod = "GET", nickname = "listaCategorias")
    public ResponseEntity<?> listar()
    {
        Collection<Categoria> itemsCategoria = categoriaService.findAll();
        return new ResponseEntity<>(itemsCategoria, HttpStatus.OK);
    }
    @GetMapping("/buscar/{id}")
    @ApiOperation(value = "Devuelve la lista de las Categorias por ID", httpMethod = "GET", nickname = "listaCategoriaByID")
    public ResponseEntity<?> buscar(@ApiParam(value = "Identificador del Categoria", required = true) @PathVariable(name = "id") Integer areaId)
    {
        Categoria area = categoriaService.findById(areaId);
        if (area == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria no encontrado");
        return new ResponseEntity<>(area, HttpStatus.OK);
    }
    @PostMapping("/agregar")
    @ApiOperation(value = "Registra una categoria", httpMethod = "POST", nickname = "RegistraCategoria")
    public ResponseEntity<?> agregar(@RequestBody Categoria categoria)
    {
        categoriaService.insert(categoria);
        String respuesta = "Categoria "+ categoria.getCateId()+" - " +categoria.getNombre() +" creado correctamente";
        return new ResponseEntity<>(respuesta,HttpStatus.CREATED);
    }
    @DeleteMapping("/borrar/{id}")
    @ApiOperation(value = "Elimina una Categoria por ID", httpMethod = "DELETE", nickname = "EliminaCategoria")
    public ResponseEntity<?> borrar(@ApiParam(value = "Identificador del Categoria", required = true) @PathVariable(name = "id")  Integer categoriaID)
    {
        Categoria categoria = categoriaService.findById(categoriaID);
        if (categoria == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria no encontrado");
        categoriaService.delete(categoriaID);
        String respuesta = "Categoria "+ categoria.getCateId()+" - " +categoria.getNombre() +" eliminado correctamente";
        return new ResponseEntity<>(respuesta,HttpStatus.ACCEPTED);
    }

    @PutMapping("/editar/{id}")
    @ApiOperation(value = "Actualiza una Categoria por ID", httpMethod = "PUT", nickname = "ActualizaCategoria")
    public ResponseEntity<?> actualizar(@ApiParam(value = "Identificador del Categoria", required = true) @PathVariable(name = "id")  Integer categoriaID,@RequestBody Categoria newCategoria)
    {
        Categoria categoria = categoriaService.findById(categoriaID);
        if (categoria == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria no encontrado");
        //actualizacion total!!!
        categoriaService.update(newCategoria);
        String respuesta = "Categoria "+ categoria.getCateId()+" - " +categoria.getNombre() +" actualizado correctamente";
        return new ResponseEntity<>(respuesta,HttpStatus.ACCEPTED);
    }
}
