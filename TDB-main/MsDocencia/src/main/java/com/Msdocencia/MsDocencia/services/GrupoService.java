package com.Msdocencia.MsDocencia.services;

import com.Msdocencia.MsDocencia.repository.IGrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GrupoService {
    @Autowired
    IGrupoRepository iGrupoRepository;
}
