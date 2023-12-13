package TDB.MsControlAcademico.services;

import TDB.MsControlAcademico.dtos.CarreraDTO;
import TDB.MsControlAcademico.dtos.CarrerasMapper;
import TDB.MsControlAcademico.dtos.FacultadDTO;
import TDB.MsControlAcademico.dtos.FacultadMapper;
import TDB.MsControlAcademico.interfaces.CarreraServiceInterface;
import TDB.MsControlAcademico.model.CarreraModel;
import TDB.MsControlAcademico.repository.CarreraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarreraService implements CarreraServiceInterface {

    @Autowired
    CarreraRepository carreraRepository;
    @Override
    public CarreraDTO crearCarrera(CarreraDTO carreraDTO) {
        CarreraModel carreraModel= CarrerasMapper.mapper.carreraDTOToCarreraModel(carreraDTO);
        return CarrerasMapper.mapper.carreraToCarreraDTO(carreraRepository.save(carreraModel));
    }

    @Override
    public CarreraDTO obtenerCarreraPorId(int id) {
       CarreraModel carreraModel= carreraRepository.findById(id).orElse(null);
        return CarrerasMapper.mapper.carreraToCarreraDTO(carreraModel);
    }

    @Override
    public List<CarreraDTO> obtenerTodasLasCarreras() {
        List<CarreraModel> carreras= (List<CarreraModel>) carreraRepository.findAll();
        List<CarreraDTO> carrerasDTO=carreras.stream().map(
                carrera -> CarrerasMapper.mapper.carreraToCarreraDTO(carrera)).collect(Collectors.toList());
        return carrerasDTO;
    }

    @Override
    public void eliminarCarrera(int cod_carrera) {
        CarreraModel mo= carreraRepository.findById(cod_carrera).orElse(null);
        if(mo!=null){
            carreraRepository.delete(mo);
        }
    }

    @Override
    public CarreraDTO updateCarrera( CarreraDTO carreraDTO) {
        CarreraModel carreraModel = CarrerasMapper.mapper.carreraDTOToCarreraModel(carreraDTO);
        if(carreraRepository.existsById(carreraDTO.getCod_carrera())){
            return CarrerasMapper.mapper.carreraToCarreraDTO(carreraRepository.save(carreraModel));
        }
        return null;
    }
}
