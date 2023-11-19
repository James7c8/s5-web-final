package s5.webfinal.service;

import s5.webfinal.model.dto.ProductoDtoSinId;
import s5.webfinal.model.dto.ProductoDto;

import java.util.List;

public interface ProductoService {
    ProductoDto crearProducto(ProductoDtoSinId productoDtoSinId);
    ProductoDto getProductoById(Long id);
    List<ProductoDto> getAllProducto();
    ProductoDto actualizarProducto(Long id, ProductoDtoSinId productoDtoSinId);
    void eliminarProducto(Long id);
}
