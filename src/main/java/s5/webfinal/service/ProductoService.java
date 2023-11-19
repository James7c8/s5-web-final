package s5.webfinal.service;

import s5.webfinal.model.dto.ProductoDto;

import java.util.List;

public interface ProductoService {
    ProductoDto crearProducto(ProductoDto productoDto);
    ProductoDto getProductoById(Long id);
    List<ProductoDto> getProductos();
    ProductoDto actualizarProducto(ProductoDto productoDto);
    void eliminarProducto(Long id);
}
