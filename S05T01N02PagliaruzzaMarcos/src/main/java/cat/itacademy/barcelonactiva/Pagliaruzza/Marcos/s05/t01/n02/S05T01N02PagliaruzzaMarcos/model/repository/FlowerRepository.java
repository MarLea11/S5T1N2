package cat.itacademy.barcelonactiva.Pagliaruzza.Marcos.s05.t01.n02.S05T01N02PagliaruzzaMarcos.model.repository;

import cat.itacademy.barcelonactiva.Pagliaruzza.Marcos.s05.t01.n02.S05T01N02PagliaruzzaMarcos.model.domain.Flower;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlowerRepository extends JpaRepository<Flower, Integer> {
}
