package ma.zaatari.controle.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.zaatari.controle.entities.Servicee;
import ma.zaatari.controle.services.ServiceeService;

@RestController
@RequestMapping("/api/Service")
public class ServiceeController {
    @Autowired
    private ServiceeService ServiceSer;

    @PostMapping("/save")
    public Servicee ajouterService(@RequestBody Servicee Service) {
        Service.setId(0);
        return ServiceSer.create(Service);
    }

    @GetMapping("/all")
    public List<Servicee> getAllService() {
        return ServiceSer.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findServiceById(@PathVariable long id) {
        Servicee Service = ServiceSer.findById(id);
        if (Service == null) {
            return new ResponseEntity<Object>("la Service avec id " + id + " n'esxiste pas", HttpStatus.BAD_REQUEST);

        } else {
            return ResponseEntity.ok(Service);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateService(@PathVariable long id, @RequestBody Servicee Service) {
        Servicee oldService = ServiceSer.findById(id);
        if (oldService == null) {
            return new ResponseEntity<Object>("Service avec id " + id + " n'exsiste pas", HttpStatus.BAD_REQUEST);
        } else {
            Service.setId(id);
            return ResponseEntity.ok(ServiceSer.update(Service));
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteService(@PathVariable long id) {
        Servicee Service = ServiceSer.findById(id);
        if (Service == null) {
            return new ResponseEntity<Object>("Service avec id " + id + " n'exsiste pas ", HttpStatus.BAD_REQUEST);
        } else {
            ServiceSer.delete(Service);
            return ResponseEntity.ok("Service supprimé");

        }

    }

}
