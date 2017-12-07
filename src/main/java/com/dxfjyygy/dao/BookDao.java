package com.dxfjyygy.dao;

import com.dxfjyygy.vo.Book;

/**
 * Created by Administrator on 2017/11/11 0011.
 */
public interface BookDao {
    public int save(Book book);
    public void update(Book book);
}
