package com.salesianos.triana.ComiendoPorTriana.user.model;

import com.salesianos.triana.ComiendoPorTriana.bar.model.Bar;
import lombok.*;
import org.hibernate.annotations.NaturalId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Entity
@Table(name="USER_ENTITY")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class User implements UserDetails {

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(columnDefinition = "uuid")
    private UUID id;

    @NaturalId
    @Column(name = "USERNAME", unique = true, updatable = false)
    private String username;
    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "FULLNAME")
    private String fullName;

    @Column(name = "AVATAR")
    private String avatar;

    @Builder.Default
    @Column(name = "FAV_LIST")
    private List<Bar> favList = new ArrayList<Bar>();

    @Builder.Default
    @Column(name = "ACCOUNT_NON_EXPIRED")
    private boolean accountNonExpired = true;
    @Builder.Default
    @Column(name = "ACCOUNT_NON_LOCKED")
    private boolean accountNonLocked = true;
    @Builder.Default
    @Column(name = "CREDENTIALS_NON_EXPIRED")
    private boolean credentialsNonExpired = true;
    @Builder.Default
    @Column(name = "ENABLED")
    private boolean enabled = true;

    @ElementCollection(fetch = FetchType.EAGER)
    @Column(name = "ROLES")
    private Set<UserRole> roles;

    @CreatedDate
    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

    @Builder.Default
    @Column(name = "LAST_PASSWORD_CHANGE_AT")
    private LocalDateTime lastPasswordChangeAt = LocalDateTime.now();


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map(role -> "ROLE_" + role)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
    


}
