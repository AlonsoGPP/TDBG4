package TDB.MsControlAcademico.interfaces;

import TDB.MsControlAcademico.dtos.CarreraDTO;

import java.util.List;

public interface CarreraServiceInterface {
    CarreraDTO crearCarrera(CarreraDTO carreraDTO);

    CarreraDTO obtenerCarreraPorId(int id);

    List<CarreraDTO> obtenerTodasLasCarreras();

    void eliminarCarrera(int cod_carrera);

    CarreraDTO updateCarrera( CarreraDTO carreraDTO);
}
