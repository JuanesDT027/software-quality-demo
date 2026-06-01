package qualitydemo.controller;

import qualitydemo.entity.Tarea;
import qualitydemo.service.TareaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tareas")
public class TareaController {

    private final TareaService tareaService;

    public TareaController(TareaService tareaService) {
        this.tareaService = tareaService;
    }

    @PostMapping
    public Tarea crearTarea(@RequestBody Tarea tarea) {
        return tareaService.crearTarea(tarea);
    }

    @GetMapping
    public List<Tarea> listarTareas() {
        return tareaService.listarTareas();
    }

    @GetMapping("/{id}")
    public Tarea buscarPorId(@PathVariable Long id) {
        return tareaService.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Tarea no encontrada"));
    }

    @PutMapping("/{id}")
    public Tarea actualizarTarea(
            @PathVariable Long id,
            @RequestBody Tarea tarea) {

        return tareaService.actualizarTarea(id, tarea);
    }

    @DeleteMapping("/{id}")
    public String eliminarTarea(@PathVariable Long id) {

        tareaService.eliminarTarea(id);

        return "Tarea eliminada correctamente";
    }
}