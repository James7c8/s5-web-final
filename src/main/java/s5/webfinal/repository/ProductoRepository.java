package s5.webfinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import s5.webfinal.model.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
