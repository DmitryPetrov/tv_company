
package com.example.name.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.name.mapper.ChennelMapper;
import com.example.name.model.Chennel;
import com.example.name.service.MyBatisUtil;

@Repository
public class ChennelDAO {

    public void insert(Chennel chennel) {
        SqlSession sqlSession =
                MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            ChennelMapper ChennelMapper =
                    sqlSession.getMapper(ChennelMapper.class);
            ChennelMapper.insert(chennel);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }


    public Chennel getById(Long chennelId) {
        SqlSession sqlSession =
                MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            ChennelMapper ChennelMapper =
                    sqlSession.getMapper(ChennelMapper.class);
            return ChennelMapper.getById(chennelId);
        } finally {
            sqlSession.close();
        }
    }


    public List<Chennel> getAll() {
        SqlSession sqlSession =
                MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            ChennelMapper ChennelMapper =
                    sqlSession.getMapper(ChennelMapper.class);
            return ChennelMapper.getAll();
        } finally {
            sqlSession.close();
        }
    }


    public List<Chennel> getFavoriteChannelForSubscriber(Long subscriberId) {
        SqlSession sqlSession =
                MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            ChennelMapper ChennelMapper =
                    sqlSession.getMapper(ChennelMapper.class);
            return ChennelMapper.getFavoriteChannelForSubscriber(subscriberId);
        } finally {
            sqlSession.close();
        }
    }


    public void update(Chennel chennel) {
        SqlSession sqlSession =
                MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            ChennelMapper ChennelMapper =
                    sqlSession.getMapper(ChennelMapper.class);
            ChennelMapper.update(chennel);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }


    public void delete(Chennel chennel) {
        SqlSession sqlSession =
                MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            ChennelMapper ChennelMapper =
                    sqlSession.getMapper(ChennelMapper.class);
            ChennelMapper.delete(chennel.getId());
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }

    }

}
