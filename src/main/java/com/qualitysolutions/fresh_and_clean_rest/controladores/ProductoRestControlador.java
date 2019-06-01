package com.qualitysolutions.fresh_and_clean_rest.controladores;

import com.qualitysolutions.fresh_and_clean_rest.modelos.Categoria;
import com.qualitysolutions.fresh_and_clean_rest.modelos.Marca;
import com.qualitysolutions.fresh_and_clean_rest.servicios.IProductoService;
import com.qualitysolutions.fresh_and_clean_rest.servicios.IUploadFileService;
import com.qualitysolutions.fresh_and_clean_rest.modelos.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.validation.Valid;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ProductoRestControlador {

    @Autowired
    IProductoService productoService;
    @Autowired
    IUploadFileService uploadFileService;

    @GetMapping(value = {"/", "productos"})
    public List<Producto> mostrarTodos() {
        List<Producto> productos = productoService.findAll();
        return productos;
    }

    @GetMapping("marcas")
    public List<Marca> mostrarTodasMarcas() {
        List<Marca> marcas = productoService.findAllMarca();
        return marcas;
    }
    @GetMapping("categorias")
    public List<Categoria> mostrarTodasCategorias() {
        List<Categoria> categorias = productoService.findAllCategorias();
        return categorias;
    }

    @GetMapping("/productos/pagina/{page}")
    public Page<Producto> mostrarTodosPaginable(@PathVariable Integer page)
    {
        return productoService.findAll(PageRequest.of(page,9));
    }

    @GetMapping("/productos/{id}")
    public ResponseEntity<?> mostrarUno(@PathVariable String id) {
        Long idReal;
        Producto producto;
        Map<String, Object> respuesta = new HashMap<>();

        try {
            idReal = Long.parseLong(id);
        } catch (Exception e) {
            respuesta.put("mensaje", "Error en la consulta en la BD");
            respuesta.put("error", String.format("Parametro %s Invalido", id));
            return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        producto = productoService.findById(idReal);

        if (producto == null) {
            respuesta.put("mensaje", String.format("El producto con el id %s no existe", id));
            return new ResponseEntity<>(respuesta, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(producto, HttpStatus.OK);
    }

    @PostMapping("/productos")
    public ResponseEntity<?> crear(@Valid @RequestBody Producto producto, BindingResult result) {
        Producto productoNuevo;
        Map<String, Object> respuesta = new HashMap<>();
        ArrayList<String> errores;
        if (result.hasErrors()) {
            errores = (ArrayList<String>) result.getFieldErrors()
                    .stream()
                    .map(e -> String.format("El campo %s %s", e.getField(), e.getDefaultMessage()))
                    .collect(Collectors.toList());
            respuesta.put("errores", errores);
            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
        try {
            productoNuevo = productoService.save(producto);
        } catch (DataAccessException e) {
            respuesta.put("mensaje", "Error al guardar el producto");
            respuesta.put("error", String.format("%s : %s", e.getMessage(), e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        respuesta.put("mensaje", "El producto ha sido creado con exito");
        respuesta.put("producto", productoNuevo);
        return new ResponseEntity<>(respuesta, HttpStatus.CREATED);
    }

    @PutMapping("/productos/{id}")
    public ResponseEntity<?> editar(@Valid @RequestBody Producto producto, BindingResult result, @PathVariable String id) {
        Long idReal;
        Long idGuardada;
        Producto productoActual;
        Producto productoUpdate;
        String imagenGuardada;
        Map<String, Object> respuesta = new HashMap<>();
        ArrayList<String> errores;
        try {
            idReal = Long.parseLong(id);
        } catch (Exception e) {
            respuesta.put("mensaje", "Error en la consulta");
            respuesta.put("error", String.format("Parametro %s es Invalido", id));
            return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        productoActual = productoService.findById(idReal);
        idGuardada = productoActual.getId();
        imagenGuardada = productoActual.getImagen();

        if (result.hasErrors()) {
            errores = (ArrayList<String>) result.getFieldErrors()
                    .stream()
                    .map(e -> String.format("El campo %s : %s", e.getField(), e.getDefaultMessage()))
                    .collect(Collectors.toList());
            respuesta.put("errores", errores);
            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
        if (productoActual == null) {
            respuesta.put("mensaje", String.format("El producto con el id %d no existe", idReal));
            return new ResponseEntity<>(respuesta, HttpStatus.NOT_FOUND);
        }
        try {
            productoActual = new Producto(producto.getNombre(), producto.getDescripcion(), producto.getMarca(), producto.getCategoria(), producto.getStock());
            productoActual.setId(idGuardada);
            productoActual.setImagen(imagenGuardada);
            productoUpdate = productoService.save(productoActual);
        } catch (DataAccessException e) {
            respuesta.put("mensaje", "Error al actualizar");
            respuesta.put("error", String.format("%s : %s", e.getMessage(), e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        respuesta.put("mensaje", "El producto ha sido actualizado con exito");
        respuesta.put("producto", productoUpdate);
        return new ResponseEntity<>(respuesta, HttpStatus.CREATED);
    }

    @DeleteMapping("productos/{id}")
    public ResponseEntity<?> eliminar(@PathVariable String id) {
        Long idReal;
        Map<String, Object> respuesta = new HashMap<>();
        Producto producto;
        try {
            idReal = Long.parseLong(id);
        } catch (Exception e) {
            respuesta.put("mensaje", "Error en la consulta");
            respuesta.put("error", String.format("Parametro %s invalido", id));
            return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
        }
        producto = productoService.findById(idReal);
        if (producto == null) {
            respuesta.put("mensaje", String.format("El producto con la id %d no existe", idReal));
            return new ResponseEntity<>(respuesta, HttpStatus.NOT_FOUND);
        }
        try {
            productoService.deleteById(idReal);
        } catch (DataAccessException e) {
            respuesta.put("mensaje", "Error al eliminar producto");
            respuesta.put("error", String.format("%s : %s", e.getMessage(), e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        respuesta.put("mensaje", "Producto eliminado con exito");
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @PostMapping("productos/upload")
    public ResponseEntity<?> upload(@RequestParam("archivo") MultipartFile archivo, @RequestParam("id") Long id)
    {
        Map<String, Object> respuesta = new HashMap<>();
        Producto producto = productoService.findById(id);
        if (!archivo.isEmpty()) {
            String nombreArchivo = null;
            try {
                nombreArchivo = uploadFileService.copiar(archivo);
            } catch (IOException e) {
                respuesta.put("mensaje", "Error al subir la imagen del cliente");
                respuesta.put("error", e.getMessage().concat(": ").concat(e.getCause().getMessage()));
                return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            String nombreFotoAnterior = producto.getImagen();
            uploadFileService.eliminar(nombreFotoAnterior);
            producto.setImagen(nombreArchivo);
            productoService.save(producto);
            respuesta.put("producto", producto);
            respuesta.put("mensaje", "Has subido correctamente la imagen: ".concat(nombreArchivo));
        }
        return new ResponseEntity<>(respuesta, HttpStatus.CREATED);
    }
    @GetMapping("/uploads/img/{nombreFoto:.+}")
    public ResponseEntity<Resource> verFoto(@PathVariable String nombreFoto) {
        Resource recurso = null;
        try {
            recurso	= uploadFileService.cargar(nombreFoto);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        HttpHeaders cabecera = new HttpHeaders();
        cabecera.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename() + "\"");
        return new ResponseEntity<>(recurso, cabecera, HttpStatus.OK);
    }
}
