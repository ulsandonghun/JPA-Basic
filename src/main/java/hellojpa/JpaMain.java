package hellojpa;

import jakarta.persistence.*;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        //code
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            //영속성 컨텍스트(entityManager) 내부 1차캐시 먼저조회
            Member member = em.find(Member.class, 5L);
            //미발견시 Connection을 이용해서 DB에서 직접 조회해서 영속성 컨텍스트 내 1차캐시저장
            Member member2 = em.find(Member.class, 5L);
            //한번 조회가 이루어 졌으므로, 1차캐시내에서 바로 조회(쿼리 안나감)

            member.setName("최동훈 6");
            //쓰기 지연으로 바로 쿼리 안나감.
            System.out.println("=============");



            //또한 JPA는 쓰기지연 을 통해서 트랜잭션일 끝날때 일괄적으로 DB에 insert나 update
            //쿼리를 날림.
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }finally {
            em.close();
        }



        emf.close();
    }
}
