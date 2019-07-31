package art.dao;

import art.entity.chat.Chat;
import art.entity.enumeration.MessageStatus;
import art.entity.user.User;
import art.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ChatDao {

    private SessionFactory sessionFactory;


    public ChatDao(){ sessionFactory= HibernateUtils.getSessionJavaConfigFactory();
    }


    public List<Chat> findChatsOf(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Chat> chats = new ArrayList<Chat>();

        Query query = session.createQuery("Select c from Chat c inner join user u on c.sender.iduser=u.iduser or c.reciver.iduser =u.iduser where u.iduser=:iduser");
        query.setParameter("iduser", user.getIduser());
        List objects = query.list();
        for (Object o : objects)
            chats.add((Chat) o);
        return chats;

    }


    public void insert(String message, User from, User to){

        Chat chat= new Chat(from,to,message,new Timestamp(System.currentTimeMillis()), MessageStatus.SENT);

        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();

        session.persist(chat);

        transaction.commit();

        session.close();
    }
}
