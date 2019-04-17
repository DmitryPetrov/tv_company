
package com.example.name.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.name.mapper.FavoriteChennelMapper;
import com.example.name.model.Chennel;
import com.example.name.model.FavoriteChennel;
import com.example.name.model.Subscriber;
import com.example.name.service.MyBatisUtil;

@Repository
public class FavoriteChennelDAO {

    public void insert(Subscriber subscriber, Chennel chennel) {
        FavoriteChennel favoriteChennel =
                new FavoriteChennel(subscriber.getId(), chennel.getId());

        insert(favoriteChennel);
    }
    
    public void insert(FavoriteChennel favoriteChennel) {
        SqlSession sqlSession =
                MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            FavoriteChennelMapper favoriteChennelMapper =
                    sqlSession.getMapper(FavoriteChennelMapper.class);
            favoriteChennelMapper.insert(favoriteChennel);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public void delete(Subscriber subscriber, Chennel chennel) {
        FavoriteChennel favoriteChennel =
                new FavoriteChennel(subscriber.getId(), chennel.getId());

        delete(favoriteChennel);
    }
    
    public void delete(FavoriteChennel favoriteChennel) {
        SqlSession sqlSession =
                MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            FavoriteChennelMapper favoriteChennelMapper =
                    sqlSession.getMapper(FavoriteChennelMapper.class);
            favoriteChennelMapper.delete(favoriteChennel);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }
}
