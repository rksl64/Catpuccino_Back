package com.example.catpuccino_back.controller;

import com.example.catpuccino_back.converter.SolicitudMapper;
import com.example.catpuccino_back.dto.SolicitudDTO;
import com.example.catpuccino_back.service.SolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/solicitud")
public class SolicitudController {
    @Autowired
    private SolicitudService solicitudService;

    @Autowired
    private SolicitudMapper solicitudMapper;

    @GetMapping("/listar")
    public List<SolicitudDTO> listarSolicitud(){return solicitudService.listarSolicitudes();}

    @PostMapping(value = "/newSolicitud")
    public SolicitudDTO nuevaSolicitud(@RequestBody SolicitudDTO solicitudDTO){
        return solicitudService.newSolicitud(solicitudDTO);
    }

    @PatchMapping("/{id}/aceptar")
    public String aceptarSolicitud(@PathVariable int id){
        return solicitudService.aceptarSolicitud(id);
    }

    @PatchMapping("/{id}/rechazar")
    public String rechazarSolicitud(@PathVariable int id){
        return solicitudService.rechazarSolicitud(id);
    }


    //------------FILTROS---------------
    @GetMapping(value = "/estadoSolicitud")
    public List<SolicitudDTO> getSolicitudByEstado(@RequestParam int enumEstadoSolicitud){
        return solicitudService.getSolicitudByEstado(enumEstadoSolicitud);
    }

    @GetMapping(value = "/{idGato}/numSolicitudes")
    public Integer getNumSolicitudByGato(@PathVariable int idGato){
        return solicitudService.getNumSolicitudByGato(idGato);
    }

}
