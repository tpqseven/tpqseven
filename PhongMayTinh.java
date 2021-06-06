package giadinh.edu.vn;

public class PhongMayTinh extends PhongHoc {
	private int soMayTinh;

	public PhongMayTinh() {
		super();
	}

	@Override
	protected boolean kiemTraDatChuan() {
		// TODO Auto-generated method stub
		if (this.kiemTraSoBongDen() && this.getDienTich() / this.soMayTinh <= 1.5) {
			return true;
		}
		return false;
	}

	public PhongMayTinh(int maPhong, String dayNha, double dienTich, int soBongDen, int soMayTinh) {
		super(maPhong, dayNha, dienTich, soBongDen);
		this.soMayTinh = soMayTinh;
	}

	@Override
	public String toString() {
		return super.toString() + " PhongMayTinh [soMayTinh=" + soMayTinh + "]";
	}

	public int getSoMayTinh() {
		return soMayTinh;
	}

	public void setSoMayTinh(int soMayTinh) {
		this.soMayTinh = soMayTinh;
	}

}
