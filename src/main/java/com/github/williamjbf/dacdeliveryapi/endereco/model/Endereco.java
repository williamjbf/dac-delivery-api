package com.github.williamjbf.dacdeliveryapi.endereco.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import com.vividsolutions.jts.geom.Geometry;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@SequenceGenerator(name ="seq_endereco_id", allocationSize = 1)
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_endereco_id")
    private long id;

    @NotNull(message = "rua inválida, null")
    @NotEmpty(message = "rua inválida, vazio")
    private String rua;

    @NotNull(message = "numero inválido, null")
    @NotEmpty(message = "numero inválido, vazio")
    private String numero;

    @NotNull(message = "complemento, null")
    @NotEmpty(message = "complemento inválido, vazio")
    private String complemento;

    @NotNull(message = "cep inválido, null")
    @NotEmpty(message = "cep inválido, vazio")
    private String cep;

    @NotNull(message = "cidade inválida, null")
    @NotEmpty(message = "cidade inválida, vazio")
    private String cidade;

    @NotNull(message = "uf inválida, null")
    @NotEmpty(message = "uf inválida, vazio")
    @Size(max = 2, message = "unidade federativa inválida")
    private String uf;

    private Geometry pontoGeo;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String id_referencia;
}
