package art.dao;

import art.BaseTest;
import art.entity.chat.Chat;
import art.entity.enumeration.RoleType;
import art.entity.user.User;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ChatDaoTest extends BaseTest {

    private  ChatDao chatDao;
    private UserDao userDao;


    @Before
    public  void setUp(){
        super.setUp();
        chatDao=new ChatDao();
        userDao=new UserDao();
    }



    @Test
    public  void getUserChatsTest() {
        User user = new User("User1", "pass1", RoleType.TEACHER, "User1", 0, "email1", "adrsa1");
        User user1 = new User("User2", "pass1", RoleType.STUDENT, "User2", 1, "email2", "adrsa2");
        User user2 = new User("User3", "pass2", RoleType.STUDENT, "User3", 1, "email3", "adrsa3");

        userDao.insert(user);
        userDao.insert(user1);
        userDao.insert(user2);

        chatDao.insert("Salut", user, user1);
        chatDao.insert("Salut, ce faci?", user1, user);
        chatDao.insert("BIne",user,user2);
        chatDao.insert("Tu",user1,user2);
        List<Chat> chats = chatDao.findChatsOf(user);
        for (Chat chat : chats) {
            System.out.println(chat.getText());
        }


        assertEquals("Not enough messages",3,chats.size());


    }



}