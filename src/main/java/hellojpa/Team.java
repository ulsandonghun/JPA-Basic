package hellojpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "team_id")
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    private String teamname;

    public Long getId() {
        return id;
    }

    public String getTeamname() {
        return teamname;
    }
}
