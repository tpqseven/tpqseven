package giadinh.edu.vn;

import java.util.Scanner;

public abstract class PhongHoc {
	private String dayNha;
	private int maPhong;
	private double dienTich;
	private int soBongDen;
	Scanner sc = new Scanner(System.in);

	abstract protected boolean kiemTraDatChuan();

	protected boolean kiemTraSoBongDen() {
		if (this.dienTich / this.soBongDen <= 10) {
			return true;
		}
		return false;
	}

	public PhongHoc() {

	}

	public PhongHoc(int maPhong, String dayNha, double dienTich, int soBongDen) {
		super();
		this.maPhong = maPhong;
		this.dayNha = dayNha;
		this.dienTich = dienTich;
		this.soBongDen = soBongDen;
	}

	@Override
	public String toString() {
		return "PhongHoc [maPhong=" + maPhong + ", dayNha=" + dayNha + ", dienTich=" + dienTich + "m2" + ", soBongDen="
				+ soBongDen + ", kiemTraDatChuan()=" + kiemTraDatChuan() + "]";
	}

	public String getDayNha() {
		return dayNha;
	}

	public void setDayNha(String dayNha) {
		this.dayNha = dayNha;
	}

	public int getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(int maPhong) {
		this.maPhong = maPhong;
	}

	public double getDienTich() {
		return dienTich;
	}

	public void setDienTich(double dienTich) {
		while (dienTich < 0) {
			System.out.println("diện tích phải > 0 vui lòng nhập lại: ");
			dienTich = sc.nextDouble();
		}
		this.dienTich = dienTich;
	}

	public int getSoBongDen() {
		return soBongDen;
	}

	public void setSoBongDen(int soBongDen) {
		this.soBongDen = soBongDen;
	}

}
