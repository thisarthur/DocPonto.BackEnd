package com.docconcierge.point_service.feign;

import com.docconcierge.point_service.DTO.UsuarioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "user-service")
public interface UserServiceFeignClient {

    @GetMapping("/api/users/{id}")
    UsuarioDTO getUserById(@PathVariable("id") Long id);

    @GetMapping("/api/users")
    List<UsuarioDTO> getAllUsers();
}
