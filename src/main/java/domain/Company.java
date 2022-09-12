package domain;

import base.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Company extends BaseEntity {
    private String name;
    private String username;
    private String password;
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<ComService> services;
}
