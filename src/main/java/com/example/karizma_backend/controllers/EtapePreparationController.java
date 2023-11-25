import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/etapespreparation")
public class EtapePreparationController {

    @Autowired
    private EtapePreparationService etapePreparationService;

    @GetMapping
    public List<EtapePreparation> getAllEtapesPreparation() {
        return etapePreparationService.getAllEtapesPreparation();
    }

    @GetMapping("/{id}")
    public EtapePreparation getEtapePreparationById(@PathVariable Long id) {
        return etapePreparationService.getEtapePreparationById(id);
    }

    @PostMapping
    public EtapePreparation createEtapePreparation(@RequestBody EtapePreparation etapePreparation) {
        return etapePreparationService.createEtapePreparation(etapePreparation);
    }

    @PutMapping("/{id}")
    public EtapePreparation updateEtapePreparation(@PathVariable Long id, @RequestBody EtapePreparation etapePreparation) {
        return etapePreparationService.updateEtapePreparation(id, etapePreparation);
    }

    @DeleteMapping("/{id}")
    public void deleteEtapePreparation(@PathVariable Long id) {
        etapePreparationService.deleteEtapePreparation(id);
    }
}
