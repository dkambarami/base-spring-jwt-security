package com.base_security.dk_security.models;

import com.google.common.collect.Sets;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.Set;
import java.util.stream.Collectors;

import static com.base_security.dk_security.models.ApplicationUserPermission.*;

public enum ApplicationUserRole {

    STUDENT(Sets.newHashSet()), 
    ADMIN(Sets.newHashSet(IDEA_READ, IDEA_WRITE, USER_READ, USER_WRITE)),
    SUPPORT(Sets.newHashSet(IDEA_READ, USER_READ));

    private final Set<ApplicationUserPermission> permissions;

    private ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission())).collect(Collectors.toSet());

     permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));

     return permissions;
    }

}