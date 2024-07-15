package com.docconcierge.point_service.DTO;

public class UsuarioDTO {

    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String cargo;
    private String descricaoHorario;
    private String departamentoNome;
    private String gestorResponsavel;
    private Integer cargaHorariaSegunda;
    private Integer cargaHorariaTerca;
    private Integer cargaHorariaQuarta;
    private Integer cargaHorariaQuinta;
    private Integer cargaHorariaSexta;

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

    public String getDepartamentoNome() {
        return departamentoNome;
    }

    public void setDepartamentoNome(String departamentoNome) {
        this.departamentoNome = departamentoNome;
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
}
