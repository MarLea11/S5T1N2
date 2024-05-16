package cat.itacademy.barcelonactiva.Pagliaruzza.Marcos.s05.t01.n02.S05T01N02PagliaruzzaMarcos.controller;

import cat.itacademy.barcelonactiva.Pagliaruzza.Marcos.s05.t01.n02.S05T01N02PagliaruzzaMarcos.model.dto.FlowerDTO;
import cat.itacademy.barcelonactiva.Pagliaruzza.Marcos.s05.t01.n02.S05T01N02PagliaruzzaMarcos.model.services.FlowerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flower")
@Tag(name = "Flower Controller", description = "Endpoints for flowers management")
public class FlowerController {

    @Autowired
    private FlowerService flowerService;

    @PostMapping("/add")
    @Operation(summary = "Add a flower", description = "Adding a flower to the database")
    public ResponseEntity<FlowerDTO> addFlower(@RequestBody FlowerDTO flowerDTO) {
        FlowerDTO newFlower = flowerService.addFlower(flowerDTO);
        return new ResponseEntity<>(newFlower, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Update a flower", description = "Updating a flower in the database")
    public ResponseEntity<FlowerDTO> updateFlower(@RequestBody FlowerDTO flowerDTO, @PathVariable int id) {
        try {
            FlowerDTO updateFlower = flowerService.updateFlower(flowerDTO, id);
            return new ResponseEntity<>(updateFlower, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete a flower", description = "Deleting a flower in the database")
    public ResponseEntity<Void> deleteFlower(@PathVariable int id) {
        try {
            flowerService.deleteFlower(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getOne/{id}")
    @Operation(summary = "Selecting a flower", description = "Selecting a flower in the database")
    public ResponseEntity<FlowerDTO> getFlower(@PathVariable int id) {
        try {
            FlowerDTO flower = flowerService.getFlower(id);
            return new ResponseEntity<>(flower, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAll")
    @Operation(summary = "Selecting all flowers", description = "Selecting all flowers in the database")
    public ResponseEntity<List<FlowerDTO>> getFlowers() {
        List<FlowerDTO> flowers = flowerService.getAllFlowers();
        return new ResponseEntity<>(flowers, HttpStatus.OK);
    }

}
