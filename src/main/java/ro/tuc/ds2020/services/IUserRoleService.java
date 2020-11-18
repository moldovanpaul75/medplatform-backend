package ro.tuc.ds2020.services;

import ro.tuc.ds2020.dtos.UserRoleDTO;

import java.util.Optional;


public interface IUserRoleService extends IService<UserRoleDTO> {

    public abstract Optional<UserRoleDTO> findByName(String name);
}
