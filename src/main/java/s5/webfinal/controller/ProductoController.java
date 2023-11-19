package s5.webfinal.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import s5.webfinal.model.dto.ProductoDto;
import s5.webfinal.service.ProductoService;

@RequiredArgsConstructor
@Controller
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService productoService;

    @GetMapping
    public String getProductos(Model model) {
        model.addAttribute("productos", productoService.getProductos());
        return "listado";
    }

    @GetMapping("/actualizar/{id}")
    public String actualizar(@PathVariable("id") Long id, Model model) {
        ProductoDto producto = productoService.getProductoById(id);
        if (producto == null) {
            return "redirect:/productos";
        }
        model.addAttribute("mensaje", "");
        model.addAttribute("producto", producto);
        return "producto";
    }

    @PostMapping("/procesar")
    public String procesarPost(@Valid @ModelAttribute("producto") ProductoDto productoDto,
                               BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("mensaje", "Error");
            return "producto";
        }
        productoService.actualizarProducto(productoDto);
        return "redirect:/productos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPorId(@PathVariable(value = "id") Long id) {
        productoService.eliminarProducto(id);
        return "redirect:/productos";
    }

    @GetMapping("/nuevo")
    public String nuevoProducto(Model model) {
        model.addAttribute("producto", new ProductoDto());
        return "producto";
    }

    @PostMapping("/crear")
    public String crearProducto(@Valid @ModelAttribute("producto") ProductoDto productoDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("producto", productoDto);
            return "producto"; // Stay on the same page to show errors
        }
        productoService.crearProducto(productoDto);
        return "redirect:/productos";
    }
}
