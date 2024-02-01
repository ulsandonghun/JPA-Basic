package hellojpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "team_id")
    private Long id;
    private String teamname;
    @OneToMany(mappedBy = "team")
    private List<Member> members = new ArrayList<>();


    public void setId(Long id) {
        this.id = id;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public Long getId() {
        return id;
    }

    public String getTeamname() {
        return teamname;
    }
}
