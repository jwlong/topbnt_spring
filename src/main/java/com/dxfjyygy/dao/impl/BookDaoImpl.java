package com.dxfjyygy.dao.impl;

import com.dxfjyygy.dao.BookDao;
import com.dxfjyygy.vo.Book;

/**
 * Created by Administrator on 2017/11/11 0011.
 */
public class BookDaoImpl extends BaseDaoImpl implements BookDao{
    public int save(Book book) {
        return super.save(book);
    }

    public void update(Book book) {
        super.updateObject(book);
    }
}
