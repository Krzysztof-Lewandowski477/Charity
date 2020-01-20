package pl.coderslab.charity.Rcontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.charity.domain.entities.Institution;
import pl.coderslab.charity.domain.repository.InstitutionRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/institutions")
public class InstitutionRestController {


    private final InstitutionRepository institutionRepository;

    public InstitutionRestController( InstitutionRepository institutionRepository) {

        this.institutionRepository = institutionRepository;
    }

    @GetMapping
    public ResponseEntity<List<Institution>> getAllInstitutions() {
        List<Institution> institutions = institutionRepository.findAll ();
        return new ResponseEntity<> (institutions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getInstitution(@PathVariable Long id) {
        Optional<Institution> institutionss = institutionRepository.findById(id);
        if (institutionss == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(institutionss, HttpStatus.OK);
    }
}
