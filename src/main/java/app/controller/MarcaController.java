package app.controller;

import app.entity.Carro;
import app.entity.Marca;
import app.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/marca")
@CrossOrigin("*")
public class MarcaController {


    @Autowired
    private MarcaService marcaService;

    @PostMapping("/save")
    public ResponseEntity<String> salvarCarro(@RequestBody Marca marca){
        try {
            String message = marcaService.save(marca);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<String> alterarporId(@RequestBody Marca marca, @PathVariable Long id){
        try {
            String message = marcaService.update(marca,id);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        try{
            String message = marcaService.delete(id);
            return new ResponseEntity<>(message,HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping ("/findAll")
    public ResponseEntity<List<Marca>> findAll(){
        try{
            List<Marca> listaMarcas = marcaService.listAll();
            return new ResponseEntity<>(listaMarcas,HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Marca> findById(@PathVariable Long id){
        try{
            Marca marca = this.marcaService.findById(id);
            return new ResponseEntity<>(marca,HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }

    }
}
