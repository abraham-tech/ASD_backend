package miu.edu.springsecuritydemo.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

@RequiredArgsConstructor
public enum Role {
    ADMIN(
            Set.of(Permission.ADMIN_WRITE, Permission.ADMIN_READ)
    ),
    MEMBER(
            Set.of(Permission.MEMBER_READ, Permission.MEMBER_WRITE)
    );

    @Getter
    private final Set<Permission> permissions;

    public Collection<? extends GrantedAuthority> getAuthorities() {
        var authorities = new ArrayList<GrantedAuthority>();
        for(var permission : permissions) {
            authorities.add(new SimpleGrantedAuthority(permission.getPermission()));
        }
        authorities.add(new SimpleGrantedAuthority("ROLE_" + name()));
        return authorities;
    }
}


