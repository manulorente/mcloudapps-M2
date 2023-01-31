package mcloudapps.rest_db_auth.service;

import org.springframework.stereotype.Service;

import mcloudapps.rest_db_auth.dto.RoleCreateDTO;
import mcloudapps.rest_db_auth.dto.RoleDTO;
import mcloudapps.rest_db_auth.mapper.RoleMapper;
import mcloudapps.rest_db_auth.model.Eroles;
import mcloudapps.rest_db_auth.model.Role;
import mcloudapps.rest_db_auth.repository.RoleRepository;


@Service
public class RoleService {

    private final RoleMapper roleMapper;
    private final RoleRepository roleRepository;

    public RoleService(RoleMapper roleMapper, RoleRepository roleRepository) {
        this.roleMapper = roleMapper;
        this.roleRepository = roleRepository;
    }

    public RoleDTO save(RoleCreateDTO roleCreateDTO) {
        Role role = this.roleMapper.toDomain(roleCreateDTO);
        role = this.roleRepository.save(role);
        return roleMapper.toDTO(role);
    }

    public Role findByName(Eroles name) {
        return this.roleRepository.findByName(name)
        .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
    }
}
