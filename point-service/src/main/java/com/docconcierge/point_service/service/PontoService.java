package com.docconcierge.point_service.service;

import com.docconcierge.point_service.DTO.UsuarioDTO;
import com.docconcierge.point_service.feign.UserServiceFeignClient;
import com.docconcierge.point_service.model.RegistroPonto;
import com.docconcierge.point_service.model.TipoPonto;
import com.docconcierge.point_service.model.Usuario;
import com.docconcierge.point_service.repository.RegistroPontoRepository;
import com.docconcierge.point_service.repository.BancoHorasRepository;
import com.docconcierge.point_service.model.BancoHoras;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class PontoService {

    @Autowired
    private RegistroPontoRepository registroPontoRepository;

    @Autowired
    private BancoHorasRepository bancoHorasRepository;

    @Autowired
    private UserServiceFeignClient userServiceFeignClient;

    public void registrarPonto(Long usuarioId, TipoPonto tipo) {
        UsuarioDTO usuarioDTO = userServiceFeignClient.getUserById(usuarioId);

        RegistroPonto registro = new RegistroPonto();
        registro.setUsuario(usuarioDTO); // Converter UsuarioDTO para Usuario se necessário
        registro.setData(LocalDate.now());
        registro.setHorario(LocalTime.now());
        registro.setTipo(tipo);
        registroPontoRepository.save(registro);

        if (tipo == TipoPonto.SAIDA) {
            calcularBancoHoras(usuarioDTO, registro.getData());
        }
    }

    public void registrarPontoTeste(Long usuarioId, TipoPonto tipo, LocalTime horario, LocalDate data) {
        RegistroPonto registro = new RegistroPonto(usuarioId, data, horario, tipo);
        registroPontoRepository.save(registro);

        if (tipo == TipoPonto.SAIDA) {
            calcularBancoHoras(usuarioId, registro.getData());
        }
    }

    private void calcularBancoHoras(Long usuarioId, LocalDate data) {
        List<RegistroPonto> registros = registroPontoRepository.findByUsuarioIdAndData(usuarioId, data);

        LocalTime entrada = null;
        LocalTime saidaAlmoco = null;
        LocalTime voltaAlmoco = null;
        LocalTime saidaExtra = null;
        LocalTime voltaExtra = null;
        LocalTime saida = null;

        for (RegistroPonto registro : registros) {
            switch (registro.getTipo()) {
                case ENTRADA:
                    entrada = registro.getHorario();
                    break;
                case SAIDA_ALMOCO:
                    saidaAlmoco = registro.getHorario();
                    break;
                case VOLTA_ALMOCO:
                    voltaAlmoco = registro.getHorario();
                    break;
                case SAIDA_EXTRA:
                    saidaExtra = registro.getHorario();
                    break;
                case VOLTA_EXTRA:
                    voltaExtra = registro.getHorario();
                    break;
                case SAIDA:
                    saida = registro.getHorario();
                    break;
                default:
                    break;
            }
        }

        long minutosTrabalhados = 0;
        if (entrada != null && saidaAlmoco != null) {
            minutosTrabalhados += Duration.between(entrada, saidaAlmoco).toMinutes();
        }
        if (voltaAlmoco != null && saida != null) {
            minutosTrabalhados += Duration.between(voltaAlmoco, saida).toMinutes();
        }
        if (voltaExtra != null && saida != null) {
            minutosTrabalhados += Duration.between(voltaExtra, saida).toMinutes();
        }

        int cargaHorariaDiaria = obterCargaHorariaDiaria(usuarioId, data.getDayOfWeek());
        long saldoHoras = minutosTrabalhados - cargaHorariaDiaria;

        BancoHoras bancoHoras = bancoHorasRepository.findByUsuarioIdAndData(usuarioId, data)
                .orElse(new BancoHoras(usuarioId, data, 0));
        bancoHoras.setSaldo(bancoHoras.getSaldo() + saldoHoras);

        bancoHorasRepository.save(bancoHoras);
    }

    private int obterCargaHorariaDiaria(Long usuarioId, DayOfWeek diaDaSemana) {
        Usuario usuario = usuarioServiceClient.obterPorId(usuarioId);
        switch (diaDaSemana) {
            case MONDAY:
                return usuario.getCargaHorariaSegunda();
            case TUESDAY:
                return usuario.getCargaHorariaTerca();
            case WEDNESDAY:
                return usuario.getCargaHorariaQuarta();
            case THURSDAY:
                return usuario.getCargaHorariaQuinta();
            case FRIDAY:
                return usuario.getCargaHorariaSexta();
            default:
                return 0; // Dias sem carga horária definida
        }
    }

    public List<RegistroPonto> obterRegistrosPorUsuario(Long usuarioId) {
        return registroPontoRepository.findByUsuarioId(usuarioId);
    }

    public List<BancoHoras> obterBancoHorasPorUsuario(Long usuarioId) {
        return bancoHorasRepository.findByUsuarioId(usuarioId);
    }
}
