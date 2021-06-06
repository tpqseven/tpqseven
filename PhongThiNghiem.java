package giadinh.edu.vn;

public class PhongThiNghiem extends PhongHoc {
	private String chuyenNganh;
	private int sucChua;
	private boolean bonRuaTay;

	public PhongThiNghiem() {
		super();
	}

	public PhongThiNghiem(int maPhong, String dayNha, double dienTich, int soBongDen, String chuyenNganh,
			int sucChua, boolean bonRuaTay) {
		super(maPhong, dayNha, dienTich, soBongDen);
		this.chuyenNganh = chuyenNganh;
		this.sucChua = sucChua;
		this.bonRuaTay = bonRuaTay;
	}

	@Override
	protected boolean kiemTraDatChuan() {
		// TODO Auto-generated method stub
		if (this.kiemTraSoBongDen() && this.bonRuaTay == true) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return super.toString() + " PhongThiNghiem [chuyenNganh=" + chuyenNganh + ", sucChua=" + sucChua
				+ ", bonRuaTay=" + bonRuaTay + "]";
	}

	public String getChuyenNganh() {
		return chuyenNganh;
	}

	public void setChuyenNganh(String chuyenNganh) {
		this.chuyenNganh = chuyenNganh;
	}

	public int getSucChua() {
		return sucChua;
	}

	public void setSucChua(int sucChua) {
		this.sucChua = sucChua;
	}

	public boolean isBonRuaTay() {
		return bonRuaTay;
	}

	public void setBonRuaTay(boolean bonRuaTay) {
		this.bonRuaTay = bonRuaTay;
	}

}
