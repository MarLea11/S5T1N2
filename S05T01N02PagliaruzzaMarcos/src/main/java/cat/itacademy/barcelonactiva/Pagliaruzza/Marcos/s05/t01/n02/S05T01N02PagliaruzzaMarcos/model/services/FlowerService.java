package cat.itacademy.barcelonactiva.Pagliaruzza.Marcos.s05.t01.n02.S05T01N02PagliaruzzaMarcos.model.services;

import cat.itacademy.barcelonactiva.Pagliaruzza.Marcos.s05.t01.n02.S05T01N02PagliaruzzaMarcos.model.domain.Flower;
import cat.itacademy.barcelonactiva.Pagliaruzza.Marcos.s05.t01.n02.S05T01N02PagliaruzzaMarcos.model.dto.FlowerDTO;
import cat.itacademy.barcelonactiva.Pagliaruzza.Marcos.s05.t01.n02.S05T01N02PagliaruzzaMarcos.model.repository.FlowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FlowerService {

    @Autowired
    private FlowerRepository flowerRepository;

    public FlowerDTO addFlower(FlowerDTO flowerDTO) {
        Flower flower = new Flower();
        flower.setNameFlower(flowerDTO.getNameFlower());
        flower.setCountryFlower(flowerDTO.getCountryFlower());
        flowerDTO.determinateFlowerType();
        flower = flowerRepository.save(flower);

        return convertToDTO(flower);
    }

    public FlowerDTO updateFlower(FlowerDTO flowerDTO, int id) {
        Optional<Flower> optionalFlower = flowerRepository.findById(id);
        if(optionalFlower.isPresent()) {
            Flower flower = optionalFlower.get();
            flower.setNameFlower(flowerDTO.getNameFlower());
            flower.setCountryFlower(flowerDTO.getCountryFlower());
            flower = flowerRepository.save(flower);
            return convertToDTO(flower);
        }
        throw new RuntimeException("Flower not found by id" + id);
    }

    public void deleteFlower(int id) {
        Optional<Flower> optionalFlower = flowerRepository.findById(id);
        if(optionalFlower.isPresent()) {
            flowerRepository.deleteById(id);
        }
        throw new RuntimeException("Flower not found by id" + id);
    }

    public FlowerDTO getFlower(int id) {
        Optional<Flower> optionalFlower = flowerRepository.findById(id);
        if(optionalFlower.isPresent()) {
            return convertToDTO(optionalFlower.get());
        }
        throw new RuntimeException("Flower not found by id" + id);
    }

    public List<FlowerDTO> getAllFlowers() {
        List<Flower> flowers = flowerRepository.findAll();
        return flowers.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public FlowerDTO convertToDTO(Flower flower) {
        FlowerDTO flowerDTO = new FlowerDTO();
        flowerDTO.setPk_FlowerId(flower.getPk_FlowerId());
        flowerDTO.setNameFlower(flower.getNameFlower());
        flowerDTO.setCountryFlower(flower.getCountryFlower());
        flowerDTO.setTypeFlower(flowerDTO.determinateFlowerType());

        return flowerDTO;
    }

}
