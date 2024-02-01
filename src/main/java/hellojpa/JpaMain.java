package hellojpa;

import jakarta.persistence.*;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        //code
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            Member member = new Member();

            member.setUsername("다운동");
            em.persist(member);

            Team team = new Team();
            team.setTeamname("드림팀");

            em.persist(team);
            team.getMembers().add(member);


            System.out.println("====================");
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }finally {
            em.close();
        }



        emf.close();
    }
}
