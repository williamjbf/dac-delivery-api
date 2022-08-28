package com.github.williamjbf.dacdeliveryapi.endereco.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import com.vividsolutions.jts.geom.Geometry;

import javax.persistence.*;

@Entity
@Data
@SequenceGenerator(name ="seq_endereco_id", allocationSize = 1)
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_endereco_id")
    private long id;
    private String rua;
    private String numero;
    private String complemento;
    private String cep;
    private String cidade;
    private String uf;
    private Geometry pontoGeo;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String id_referencia;
}
