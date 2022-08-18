package com.github.williamjbf.dacdeliveryapi.empresa.model;

import com.vividsolutions.jts.geom.Geometry;
import lombok.Data;

import javax.persistence.*;

@Embeddable
@Data
public class Endereco {

    private String rua;
    private String numero;
    private String complemento;
    private String cep;
    private String cidade;
    private String uf;
    private Geometry pontoGeo;

}
