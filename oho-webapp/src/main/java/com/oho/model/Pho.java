package com.oho.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * The PHO model class
 * 
 * @author namphung
 */
public class Pho {

    private Date       ngayNhap;
    private String     soXe;
    private BigDecimal tongThuA;
    private BigDecimal tongThuB;
    private BigDecimal chiBenBai;
    private BigDecimal chiAn;
    private BigDecimal chiKhac;

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getSoXe() {
        return soXe;
    }

    public void setSoXe(String soXe) {
        this.soXe = soXe;
    }

    public BigDecimal getTongThuA() {
        return tongThuA;
    }

    public void setTongThuA(BigDecimal tongThuA) {
        this.tongThuA = tongThuA;
    }

    public BigDecimal getTongThuB() {
        return tongThuB;
    }

    public void setTongThuB(BigDecimal tongThuB) {
        this.tongThuB = tongThuB;
    }

    public BigDecimal getChiBenBai() {
        return chiBenBai;
    }

    public void setChiBenBai(BigDecimal chiBenBai) {
        this.chiBenBai = chiBenBai;
    }

    public BigDecimal getChiAn() {
        return chiAn;
    }

    public void setChiAn(BigDecimal chiAn) {
        this.chiAn = chiAn;
    }

    public BigDecimal getChiKhac() {
        return chiKhac;
    }

    public void setChiKhac(BigDecimal chiKhac) {
        this.chiKhac = chiKhac;
    }

}
