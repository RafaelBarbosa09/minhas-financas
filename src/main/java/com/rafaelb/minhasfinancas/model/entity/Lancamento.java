package com.rafaelb.minhasfinancas.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import com.rafaelb.minhasfinancas.model.enums.StatusLancamento;
import com.rafaelb.minhasfinancas.model.enums.TipoLancamento;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "lancamento", schema = "financas")
public class Lancamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "mes")
	private Integer mes;

	@Column(name = "ano")
	private Integer ano;

	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	@Column(name = "valor")
	private BigDecimal valor;
	
	@Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
	@Column(name = "data_cadastro")
	private LocalDate dataCadastro;

	@Enumerated(value = EnumType.STRING)
	@Column(name = "tipo")
	private TipoLancamento tipo;

	@Enumerated(value = EnumType.STRING)
	@Column(name = "status")
	private StatusLancamento status;
}
