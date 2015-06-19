package dao;

//import by.itacademy.leonevich.User;
//import by.itacademy.leonevich.UserDetails;
import dao.exceptions.DaoException;
import entity.Book;
import utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

//import java.awt.print.Book;
import java.util.List;

public class BookDao extends BaseDao<Book> implements IBookDao {

    private static Logger log = Logger.getLogger(BookDao.class);
    private Transaction transaction = null;

    public void flush(Integer id, String newName) throws DaoException {
        try {
            Session session = HibernateUtil.getHibernateUtil().getSession();
            Book book = (Book) session.get(Book.class, id);
//            System.out.println(book);
            book.setName(newName);
//            System.out.println(book);
            session.flush();
//            System.out.println(book);
        } catch (HibernateException e) {
            log.error("Error Flush person" + e);
            throw new DaoException(e);
        }

    }



//    @Override
   /* public User getUserByEmail(String email) throws DaoException {
        try {
            Session session = HibernateUtil.getHibernateUtil().getSession();
            transaction = session.beginTransaction();
            String hql = "select U from by.itacademy.leonevich.User U where email=:email";
            Query query = session.createQuery(hql);
            query.setParameter("email", email);
            transaction.commit();
            List result = query.list();
            for (Object user : result) {
                return (User) user;
            }
        } catch (HibernateException e) {
            log.error("Error Flush person" + e);
            throw new DaoException(e);
        }
        return null;
    }*/
}
