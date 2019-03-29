import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

import com.example.models.GameCharacter;
import com.example.models.Todo;
import com.example.util.HibernateUtil;

public class Application {
	
//	@PersistenceContext
//	private static EntityManager entityManager;
//	
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.example.api.catalog");
	
	public static void main(String[] args) {
		Session s = HibernateUtil.sf.openSession();
		Transaction t = s.beginTransaction();

		CriteriaQuery<GameCharacter> c = emf.getCriteriaBuilder().createQuery(GameCharacter.class);
		Root<GameCharacter> charRoot = c.from(GameCharacter.class);		
		c.select(charRoot);
		List<GameCharacter> allChars = emf.createEntityManager().createQuery(c).getResultList(); 
		
		System.out.println(allChars);
//		
//		List<GameCharacter> gc = s.createNamedQuery("select_all", GameCharacter.class).list();
//		System.out.println(gc);
//		
//		
//		Developer d = new Developer();
//		d.setName("Blizzard");
//		
//		List<Developer> devs = new ArrayList<Developer>();
//		devs.add(d);
//		
//		Game overwatch = new Game();
//		overwatch.setGenre("FPS");
//		overwatch.setName("Overwatch");
//		overwatch.setDevs(devs);
//		
//		GameCharacter dva = new GameCharacter(); 
//		dva.setName("Mei");
//		
//		List<Game> games = new ArrayList<Game>();
//		games.add(overwatch);
//		dva.setGames(games);
//		
//		s.persist(dva);
//		s.persist(overwatch);
		t.commit();
		s.close();
		HibernateUtil.sf.close();
	}
	
	public static void day1() {
		Todo todo = new Todo();
		todo.setDescription("Sleep");
		todo.setColor("red");
		todo.setName("My Todo");
		todo.setPriority(10);
		
		Session s = HibernateUtil.sf.openSession();
		Transaction transaction = s.beginTransaction();
		s.save(todo);		
		transaction.commit();
		
		Todo t = s.get(Todo.class, 1L);
		Todo t2 = s.load(Todo.class, 2L);
		
		List<Todo> l = s.createQuery("from Todo where description like '%Sleep%'").list();
		
		System.out.println(l);
		System.out.println(t);
		System.out.println(t2);
		
		System.out.println("=================");
		
		
		
		Criteria c = s.createCriteria(Todo.class);
		
		Criterion lowPriority = Restrictions.le("priority", 3);
		Criterion highPriority = Restrictions.ge("priority", 8);
		
		LogicalExpression priorityExtremeValues = Restrictions.or(lowPriority, highPriority);
		c.add(priorityExtremeValues);
		
		List<Todo> neededTodos = c.list();
		
		System.out.println(neededTodos);
		
		s.close();
		HibernateUtil.sf.close();
	}
}
