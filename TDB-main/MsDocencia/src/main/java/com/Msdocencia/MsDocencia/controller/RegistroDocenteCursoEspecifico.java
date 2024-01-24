public class RegistroDocenteEspecifico {
    @GetMapping("/curso/{cursoId}")
    public ResponseEntity<?> getDocentesByCurso(@PathVariable int cursoId) {
        try {
            List<DocenteDictaCursoResponse> docentes = docenteDistaCursoService.getByCursoId(cursoId);
            if (docentes != null && !docentes.isEmpty()) {
                return ResponseEntity.status(HttpStatus.OK).body(docentes);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron docentes para el curso con ID: " + cursoId);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
        }
    }
      
}
