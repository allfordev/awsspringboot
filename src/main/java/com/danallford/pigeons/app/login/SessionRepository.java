package com.danallford.pigeons.app.login;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called loginRepository

/**
 * Data store for login, logout, failed login events etc... Possible expansion into
 * 'register' and 'deregister/delete account' territory...
 */
@Repository()
public interface SessionRepository extends CrudRepository<LoginEvent, Integer> {

}
