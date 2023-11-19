package s5.webfinal.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import s5.webfinal.exception.EntityNotFoundException;
import s5.webfinal.model.entity.Producto;
import s5.webfinal.model.dto.ProductoDto;
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
    public ProductoDto crearProducto(ProductoDto productoDto) {
        Producto producto = ProductoMapper.INSTANCE.mapToEntity(productoDto);
        return ProductoMapper.INSTANCE.mapToDto(productoRepo.save(producto));
    }

    @Override
    public ProductoDto getProductoById(Long id) {
        Producto producto = productoRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Producto.class));
        return ProductoMapper.INSTANCE.mapToDto(producto);
    }

    @Override
    public List<ProductoDto> getProductos() {
        List<Producto> productos = productoRepo.findAll();
        return productos.stream()
                .map(producto -> ProductoMapper.INSTANCE.mapToDto(producto))
                .collect(Collectors.toList());
    }

    @Override
    public ProductoDto actualizarProducto(ProductoDto productoDto) {
        Producto producto = productoRepo.findById(productoDto.getId())
                .orElseThrow(() -> new EntityNotFoundException(Producto.class));

        // TODO: Mejor manera de hacer esto?
        producto.setDescripcion(productoDto.getDescripcion());
        producto.setExistencia(productoDto.getExistencia());
        producto.setPrecio(productoDto.getPrecio());
        producto.setFechaUltIngreso(productoDto.getFechaUltIngreso());
        producto.setDisponible(productoDto.isDisponible());
        producto.setCategoria(productoDto.getCategoria());

        return ProductoMapper.INSTANCE.mapToDto(productoRepo.save(producto));
    }

    @Override
    public void eliminarProducto(Long id) {
        if (!productoRepo.existsById(id)) throw new EntityNotFoundException(Producto.class);
        productoRepo.deleteById(id);
    }
}
