package com.docconcierge.user_service.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cpf;
    private String email;
    private String cargo;
    private String descricaoHorario;
    private String gestorResponsavel;
    private Integer cargaHorariaSegunda;
    private Integer cargaHorariaTerca;
    private Integer cargaHorariaQuarta;
    private Integer cargaHorariaQuinta;
    private Integer cargaHorariaSexta;
    private Integer cargaHorariaSabado;
    private Integer cargaHorariaDomingo;
    private LocalDate dataNascimento;
    private LocalDate dataAdmissao;
    private LocalDate dataDemissao;
    private String senha;

    private Long departamentoId;
    private Long filialId;

    public Usuario(){}

    public Usuario(Long id, String nome, String cpf, String email, String cargo, String descricaoHorario, String gestorResponsavel, Integer cargaHorariaSegunda, Integer cargaHorariaTerca, Integer cargaHorariaQuarta, Integer cargaHorariaQuinta, Integer cargaHorariaSexta, Integer cargaHorariaSabado, Integer cargaHorariaDomingo, LocalDate dataNascimento, LocalDate dataAdmissao, LocalDate dataDemissao, String senha, Long departamentoId, Long filialId) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.cargo = cargo;
        this.descricaoHorario = descricaoHorario;
        this.gestorResponsavel = gestorResponsavel;
        this.cargaHorariaSegunda = cargaHorariaSegunda;
        this.cargaHorariaTerca = cargaHorariaTerca;
        this.cargaHorariaQuarta = cargaHorariaQuarta;
        this.cargaHorariaQuinta = cargaHorariaQuinta;
        this.cargaHorariaSexta = cargaHorariaSexta;
        this.cargaHorariaSabado = cargaHorariaSabado;
        this.cargaHorariaDomingo = cargaHorariaDomingo;
        this.dataNascimento = dataNascimento;
        this.dataAdmissao = dataAdmissao;
        this.dataDemissao = dataDemissao;
        this.senha = senha;
        this.departamentoId = departamentoId;
        this.filialId = filialId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDescricaoHorario() {
        return descricaoHorario;
    }

    public void setDescricaoHorario(String descricaoHorario) {
        this.descricaoHorario = descricaoHorario;
    }

    public String getGestorResponsavel() {
        return gestorResponsavel;
    }

    public void setGestorResponsavel(String gestorResponsavel) {
        this.gestorResponsavel = gestorResponsavel;
    }

    public Integer getCargaHorariaSegunda() {
        return cargaHorariaSegunda;
    }

    public void setCargaHorariaSegunda(Integer cargaHorariaSegunda) {
        this.cargaHorariaSegunda = cargaHorariaSegunda;
    }

    public Integer getCargaHorariaTerca() {
        return cargaHorariaTerca;
    }

    public void setCargaHorariaTerca(Integer cargaHorariaTerca) {
        this.cargaHorariaTerca = cargaHorariaTerca;
    }

    public Integer getCargaHorariaQuarta() {
        return cargaHorariaQuarta;
    }

    public void setCargaHorariaQuarta(Integer cargaHorariaQuarta) {
        this.cargaHorariaQuarta = cargaHorariaQuarta;
    }

    public Integer getCargaHorariaQuinta() {
        return cargaHorariaQuinta;
    }

    public void setCargaHorariaQuinta(Integer cargaHorariaQuinta) {
        this.cargaHorariaQuinta = cargaHorariaQuinta;
    }

    public Integer getCargaHorariaSexta() {
        return cargaHorariaSexta;
    }

    public void setCargaHorariaSexta(Integer cargaHorariaSexta) {
        this.cargaHorariaSexta = cargaHorariaSexta;
    }

    public Integer getCargaHorariaSabado() {
        return cargaHorariaSabado;
    }

    public void setCargaHorariaSabado(Integer cargaHorariaSabado) {
        this.cargaHorariaSabado = cargaHorariaSabado;
    }

    public Integer getCargaHorariaDomingo() {
        return cargaHorariaDomingo;
    }

    public void setCargaHorariaDomingo(Integer cargaHorariaDomingo) {
        this.cargaHorariaDomingo = cargaHorariaDomingo;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public LocalDate getDataDemissao() {
        return dataDemissao;
    }

    public void setDataDemissao(LocalDate dataDemissao) {
        this.dataDemissao = dataDemissao;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Long getDepartamentoId() {
        return departamentoId;
    }

    public void setDepartamentoId(Long departamentoId) {
        this.departamentoId = departamentoId;
    }

    public Long getFilialId() {
        return filialId;
    }

    public void setFilialId(Long filialId) {
        this.filialId = filialId;
    }
}
