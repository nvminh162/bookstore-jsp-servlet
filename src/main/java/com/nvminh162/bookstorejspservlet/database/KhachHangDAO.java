package com.nvminh162.bookstorejspservlet.database;

import com.nvminh162.bookstorejspservlet.model.KhachHang;

import java.util.ArrayList;

public class KhachHangDAO implements DAOInterface<KhachHang>{
    private ArrayList<KhachHang> data = new ArrayList<>();

    @Override
    public ArrayList<KhachHang> selectAll() {
        return this.data;
    }

    @Override
    public KhachHang selectById(KhachHang t) {
        for (KhachHang KhachHang : data) {
            if(data.equals(t)) {
                return KhachHang;
            }
        }
        return null;
    }

    @Override
    public int insert(KhachHang t) {
        if (this.selectById(t)==null) {
            this.data.add(t);
            return 1;
        }
        return 0;
    }

    @Override
    public int insertAll(ArrayList<KhachHang> arr) {
        int dem = 0;
        for (KhachHang KhachHang : arr) {
            dem+=this.insert(KhachHang);
        }
        return dem;
    }

    @Override
    public int delete(KhachHang t) {
        if (this.selectById(t)!=null) {
            this.data.remove(t);
            return 1;
        }
        return 0;
    }

    @Override
    public int deleteAll(ArrayList<KhachHang> arr) {
        int dem = 0;
        for (KhachHang KhachHang : arr) {
            dem+=this.delete(KhachHang);
        }
        return dem;
    }

    @Override
    public int update(KhachHang t) {
        if (this.selectById(t)!=null) {
            this.data.remove(t);
            this.data.add(t);
            return 1;
        }
        return 0;
    }
}
