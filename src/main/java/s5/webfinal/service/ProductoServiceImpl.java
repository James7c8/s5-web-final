package s5.webfinal.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import s5.webfinal.exception.EntityNotFoundException;
import s5.webfinal.model.entity.Producto;
import s5.webfinal.model.dto.ProductoDto;
import s5.webfinal.model.dto.ProductoDtoSinId;
import s5.webfinal.model.mapper.ProductoMapper;
import s5.webfinal.repository.ProductoRepository;

import java.util.List;
import java.util.stream.Collectors;

/*
 * Mientras en una aplicación tan sencilla no hay necesidad de usar un mapper o diferentes DTO, quería la práctica.
 */

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepo;

    @Override
    public ProductoDto crearProducto(ProductoDtoSinId productoDtoSinId) {
        Producto producto = ProductoMapper.INSTANCE.mapToEntity(productoDtoSinId);
        return ProductoMapper.INSTANCE.mapToDto(productoRepo.save(producto));
    }

    @Override
    public ProductoDto getProductoById(Long id) {
        return null;
    }

    @Override
    public List<ProductoDto> getAllProducto() {
        List<Producto> productos = productoRepo.findAll();
        return productos.stream()
                .map(producto -> ProductoMapper.INSTANCE.mapToDto(producto))
                .collect(Collectors.toList());
    }

    @Override
    public ProductoDto actualizarProducto(Long id, ProductoDtoSinId productoDtoSinId) {
        Producto producto = productoRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Producto.class));

        // TODO: Mejor manera de hacer esto?
        producto.setDescripcion(productoDtoSinId.getDescripcion());
        producto.setExistencia(productoDtoSinId.getExistencia());
        producto.setPrecio(productoDtoSinId.getPrecio());
        producto.setFechaUltIngreso(productoDtoSinId.getFechaUltIngreso());
        producto.setDisponible(productoDtoSinId.isDisponible());
        producto.setCategoria(productoDtoSinId.getCategoria());

        return ProductoMapper.INSTANCE.mapToDto(productoRepo.save(producto));
    }

    @Override
    public void eliminarProducto(Long id) {
        if (!productoRepo.existsById(id)) throw new EntityNotFoundException(Producto.class);
        productoRepo.deleteById(id);
    }
}
