package app.controller;

import app.entity.Acessorio;
import app.entity.Marca;
import app.service.AcessorioService;
import app.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RequestMapping("api/acessorio")
@RestController
public class AcessorioController {

    @Autowired
    private AcessorioService acessorioService;

    @PostMapping("/save")
    public ResponseEntity<String> salvarCarro(@RequestBody Acessorio acessorio){
        try {
            String message = acessorioService.save(acessorio);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<String> alterarporId(@RequestBody Acessorio acessorio, @PathVariable Long id){
        try {
            String message = acessorioService.update(acessorio,id);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        try{
            String message = acessorioService.delete(id);
            return new ResponseEntity<>(message,HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping ("/findAll")
    public ResponseEntity<List<Acessorio>> findAll(){
        try{
            List<Acessorio> listaAcessorios = acessorioService.listAll();
            return new ResponseEntity<>(listaAcessorios,HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Acessorio> findById(@PathVariable Long id){
        try{
            Acessorio acessorio = this.acessorioService.findById(id);
            return new ResponseEntity<>(acessorio,HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }

    }
}
