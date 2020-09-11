package com.example.demo.dao;

import com.example.demo.domain.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;


public class BookDao {


    public static boolean addBook(Book book){
        Session session = HibernateConfigUtil.openSession();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            session.save(book);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static Book getBook(String author, String date){

        Session session = HibernateConfigUtil.openSession();
        Transaction transaction = null;
        List results = null;
        try{
            transaction = session.beginTransaction();

            String hql = "FROM Book b WHERE b.author = :author OR b.date =:date";
            Query query = session.createQuery(hql);
            query.setParameter("author",author);
            query.setParameter("date", date);
            results = query.list();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        if(results.size() != 0)
            return (Book)results.get(0);
        else
            return null;
    }

    public static boolean updateBook(int isbn, Book b){

        Session session = HibernateConfigUtil.openSession();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            Book book = session.get(Book.class, isbn);
            book.setAuthor(b.getAuthor());
            book.setDate(b.getDate());
            book.setName(b.getName());
            session.update(book);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
