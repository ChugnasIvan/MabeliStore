package pe.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pe.store.model.Distrito;
import pe.store.model.TipoDocumento;
import pe.store.service.GenericService;

import java.util.Collection;

@RestController
@RequestMapping("/tipoDoc")
public class TipoDocRestController {

    @Autowired
    private GenericService<TipoDocumento,Integer> tdocService;

    @GetMapping("/listar")
    public ResponseEntity<?> listar()
    {
        Collection<TipoDocumento> itemsTdoc = tdocService.findAll();
        return new ResponseEntity<>(itemsTdoc, HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscar(@PathVariable(name = "id") Integer tdocId)
    {
        TipoDocumento tdoc = (TipoDocumento) tdocService.findById(tdocId);
        if (tdoc == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tipo Documento no encontrado");
        return new ResponseEntity<>(tdoc, HttpStatus.OK);
    }

    @PostMapping("/agregar")
    public ResponseEntity<?> agregar(@RequestBody TipoDocumento tdoc)
    {
        tdocService.insert(tdoc);
        String respuesta = "Tipo Documento "+ tdoc.getId_tipoDoc()+" - " +tdoc.getDescripcion() +" creado correctamente";
        return new ResponseEntity<>(respuesta,HttpStatus.CREATED);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> borrar(@PathVariable(name = "id") Integer tdocID)
    {
        TipoDocumento tdoc = tdocService.findById(tdocID);
        if (tdoc == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tipo Documento no encontrado");
        tdocService.delete(tdocID);
        String respuesta = "Tipo Documento "+ tdoc.getId_tipoDoc()+" - " +tdoc.getDescripcion() +" eliminado correctamente";
        return new ResponseEntity<>(respuesta,HttpStatus.ACCEPTED);
    }


    @PutMapping("/editar/{id}")
    public ResponseEntity<?> actualizar(@PathVariable(name = "id") Integer distritoID,@RequestBody TipoDocumento newTdoc)
    {
        TipoDocumento tdoc = tdocService.findById(distritoID);
        if (tdoc == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tipo Documento no encontrado");
        //actualizacion total!!!
        tdocService.update(newTdoc);
        String respuesta = "Tipo Documento  "+ tdoc.getId_tipoDoc()+" - " +tdoc.getDescripcion() +" eliminado correctamente";
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
