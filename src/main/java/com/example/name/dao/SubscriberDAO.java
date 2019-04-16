package com.example.name.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.name.mapper.SubscriberMapper;
import com.example.name.model.Subscriber;
import com.example.name.service.MyBatisUtil;

@Repository
public class SubscriberDAO {
    
    
    public void insert(Subscriber subscriber) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            SubscriberMapper SubscriberMapper = sqlSession.getMapper(SubscriberMapper.class);
            SubscriberMapper.insert(subscriber);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public Subscriber getById(Long subscriberId) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            SubscriberMapper SubscriberMapper = sqlSession.getMapper(SubscriberMapper.class);
            return SubscriberMapper.getById(subscriberId);
        } finally {
            sqlSession.close();
        }
    }

    public List<Subscriber> getAll() {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            SubscriberMapper SubscriberMapper = sqlSession.getMapper(SubscriberMapper.class);
            return SubscriberMapper.getAll();
        } finally {
            sqlSession.close();
        }
    }

    public void update(Subscriber subscriber) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            SubscriberMapper SubscriberMapper = sqlSession.getMapper(SubscriberMapper.class);
            SubscriberMapper.update(subscriber);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public void delete(Subscriber subscriber) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            SubscriberMapper SubscriberMapper = sqlSession.getMapper(SubscriberMapper.class);
            SubscriberMapper.delete(subscriber.getId());
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }

    }
}
