package pe.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pe.store.model.Rol;
import pe.store.model.UsuarioCliente;
import pe.store.repository.UsuClienteRepository;

import java.util.*;

@Service
public class UsuarioClienteService implements UserDetailsService, GenericService<UsuarioCliente,Integer> {

    @Autowired
    private UsuClienteRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UsuarioClienteService(){

    }

    @Override
    public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {

        Optional<UsuarioCliente> usuario = repository.findUserUsuarioClienteByNombreUsuCli(user);
        if(usuario.isEmpty())
            throw new UsernameNotFoundException("Usuario no encontrado " + user);
        else{
            UsuarioCliente userData = repository.findById(usuario.get().getIdUsuCli()).get();
            //List<Rol> roles= (List<Rol>) userData.getRolID();
            Rol roles= userData.getRolID();

            Set<GrantedAuthority> ga = new HashSet<>();
            //for(Rol rol : roles) {
                ga.add(new SimpleGrantedAuthority(roles.getNombreRol()));
            //}

            User springUserSession = new User(user, userData.getPasswordUsuCli(), ga);

            return springUserSession;
        }

    }

    public Integer saveUser(UsuarioCliente newUser){
        String passwd = newUser.getPasswordUsuCli();
        String encodePassword = passwordEncoder.encode(passwd);
        newUser.setPasswordUsuCli(encodePassword);
        newUser = repository.save(newUser);
        return newUser.getIdUsuCli();
    }

    @Override
    public void insert(UsuarioCliente obj) {

    }

    @Override
    public void update(UsuarioCliente obj) {
        repository.save(obj);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public UsuarioCliente findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Collection<UsuarioCliente> findAll() {
        return (Collection<UsuarioCliente>) repository.findAll();
    }

}
