package giadinh.edu.vn;

public class PhongLyThuyet extends PhongHoc {
	private boolean mayChieu;

	public PhongLyThuyet() {
		super();
	}

	public PhongLyThuyet(int maPhong, String dayNha, double dienTich, int soBongDen, boolean mayChieu) {
		super(maPhong, dayNha, dienTich, soBongDen);
		this.setMayChieu(mayChieu);
	}

	@Override
	protected boolean kiemTraDatChuan() {
		if (this.mayChieu == true && this.kiemTraSoBongDen()) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return super.toString() + " PhongLyThuyet [mayChieu=" + mayChieu + "]";
	}

	public boolean isMayChieu() {
		return mayChieu;
	}

	public void setMayChieu(boolean mayChieu) {
		this.mayChieu = mayChieu;
	}

}
