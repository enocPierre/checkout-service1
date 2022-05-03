package com.mscompra.mscompra.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Entity(name = "tb_pedido")
public class Pedido implements Serializable {
   // private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Campo requerido")
    @Size(min = 5, max = 80, message = "nome deve ter entre 5 a 80 carateres")
    private String nome;

    @NotNull(message = "Campo requerido")
    private Long produto;

    @NotNull
    @Min(1)
    @Positive(message = "valor deve ser positivo")
    private BigDecimal valor;

    @NotNull
    @PastOrPresent(message = "A data do não deve ser data futuro")
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date dataCompra;

    @NotBlank(message = "Campo requerido")
    private String cpfCliente;

    @NotBlank(message = "Campo requerido")
    private String cep;
}
