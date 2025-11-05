package com.treino.cadastro_usuario.business;

import org.springframework.stereotype.Service;

import com.treino.cadastro_usuario.infrastructure.entitys.Usuario;
import com.treino.cadastro_usuario.infrastructure.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository){
        this.repository = repository;
    }


    public void salvarUsuario(Usuario usuario){
        repository.saveAndFlush(usuario);
    }

    public Usuario buscUsuarioPorEmail(String email){
        return repository.findByEmail(email).orElseThrow(
            () -> new RuntimeException("Email não econtrado")
        );
    }

    public void deletarUsuarioPorEmail(String email){
        repository.deleteByEmail(email);
    }
}
