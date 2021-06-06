package giadinh.edu.vn;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DanhSachPhongHoc {
	private List<PhongHoc> dsPhong;
	PhongHoc phong;
	Scanner sc = new Scanner(System.in);

	DanhSachPhongHoc() {
		this.dsPhong = new ArrayList<PhongHoc>();
	}

	void nhap() {
		String dayNha = null;
		double dienTich = 0.0;
		int soBongDen = 0;
		int maPhong = 0;
		do {
			System.out.println("nhập mã phòng: ");
			try {
				maPhong = sc.nextInt();
			} catch (Exception e) {
				System.out.println("mã phòng lỗi: " + e);
				// TODO: handle exception
			}
			sc.nextLine();
			System.out.println("nhập dãy nhà: ");
			try {
				dayNha = sc.nextLine();
			} catch (Exception e) {
				System.out.println("tên dãy nhà lỗi: " + e);
			}
			System.out.println("nhập diện tích phòng: ");
			try {
				dienTich = sc.nextDouble();
			} catch (Exception e) {
				System.out.println("diện tíchlỗi rồi:" + e);
			}
			sc.nextLine();
			System.out.println("nhập số bóng đèn trong phòng: ");
			try {
				soBongDen = sc.nextInt();
			} catch (Exception e) {
				System.out.println("số bóng đèn lỗi rồi " + e);
			}
			sc.nextLine();
			System.out.println("Chọn 1 phòng lý thuyết");
			System.out.println("Chọn 2 phòng máy tính");
			System.out.println("Chọn 3 phòng thí nghiệm");
			int n = sc.nextInt();
			if (n == 1) {
				boolean mayChieu = true;
				System.out.println("Phòng có máy chiếu hay không true/false: ");
				try {
					mayChieu = sc.nextBoolean();
				} catch (Exception e) {
					System.out.println("nhập lỗi " + e);
				}
				phong = new PhongLyThuyet(maPhong, dayNha, dienTich, soBongDen, mayChieu);
			} else if (n == 2) {
				int soMayTinh = 0;
				System.out.println("nhập số máy tính trong phòng: ");
				try {
					soMayTinh = sc.nextInt();
				} catch (Exception e) {
					System.out.println("Lỗi rồi " + e);
				}
				sc.nextLine();
				phong = new PhongMayTinh(maPhong, dayNha, dienTich, soBongDen, soMayTinh);
			} else {
				String chuyenNganh = null;
				int sucChua = 0;
				boolean bonRuaTay = true;
				sc.nextLine();
				System.out.println("nhập thông tin chuyên ngành: ");
				try {
					chuyenNganh = sc.nextLine();
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("lỗi " + e);
				}
				System.out.println("nhập sức chứa của phòng: ");
				try {
					sucChua = sc.nextInt();
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("lỗi " + e);
				}
				sc.nextLine();
				System.out.println("Phòng có bồn rửa tay hay không true/false: ");
				try {
					bonRuaTay = sc.nextBoolean();
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("lỗi " + e);
				}
				sc.nextLine();
				phong = new PhongThiNghiem(maPhong, dayNha, dienTich, soBongDen, chuyenNganh, sucChua, bonRuaTay);
			}

			themPhong(phong);
			System.out.println("1- Nhập thêm phòng nữa");
			System.out.println("2- Dừng lại");
		} while (sc.nextInt() == 1);
	}

	void xoaPhong() {
		System.out.println("Nhập vào mã phòng cần xóa: ");
		int maPhong = sc.nextInt();
		for (PhongHoc phongHoc : dsPhong) {
			if (phongHoc.getMaPhong() == maPhong) {
				dsPhong.remove(phongHoc);
				System.out.println("Xóa phòng có mã " + maPhong + " thành công!");
				return;
			}
		}
		System.out.println("Lỗi không tìm thấy mã phòng " + maPhong);
	}

	void suaMaPhong() {
		boolean tf = true;
		System.out.println("Nhập vào mã phòng cần sửa: ");
		int maPhong = sc.nextInt();
		for (PhongHoc phongHoc : dsPhong) {
			if (phongHoc.getMaPhong() == maPhong) {
				System.out.println("Bạn có muốn thay đổi mã phòng không: true/false");
				tf = sc.nextBoolean();
				sc.nextLine();
				if (tf) {
					System.out.println("Bạn muốn thay đổi mã phòng thành: ");
					dsPhong.get(dsPhong.indexOf(phongHoc)).setMaPhong(sc.nextInt());
				}
				System.out.println("Bạn có muốn thay đổi tên dãy nhà không: true/false");
				tf = sc.nextBoolean();
				if (tf) {
					System.out.println("Bạn muốn thay đổi tên dãy nhà thành: ");
					sc.nextLine();
					dsPhong.get(dsPhong.indexOf(phongHoc)).setDayNha(sc.nextLine());
				}
				System.out.println("Bạn có muốn thay đổi diện tích phòng: true/false");
				tf = sc.nextBoolean();
				if (tf) {
					System.out.println("Bạn muốn thay đổi diện tích thành: ");
					dsPhong.get(dsPhong.indexOf(phongHoc)).setDienTich(sc.nextDouble());
				}
				System.out.println("Bạn có muốn thay đổi số bóng đèn trong phòng không: true/false");
				tf = sc.nextBoolean();
				if (tf) {
					System.out.println("Bạn muốn thay đổi số bóng đèn trong phòng thành: ");
					dsPhong.get(dsPhong.indexOf(phongHoc)).setSoBongDen(sc.nextInt());
				}
				if (phongHoc instanceof PhongThiNghiem) {
					PhongThiNghiem phongtn = (PhongThiNghiem) phongHoc;
					System.out.println("Bạn có muốn thay đổi chuyênh ngành của phòng không: true/false");
					tf = sc.nextBoolean();
					if (tf) {
						System.out.println("Bạn muốn thay đổi chuyên ngành của phòng thành: ");
						phongtn.setChuyenNganh(sc.nextLine());
					}
					System.out.println("Bạn có muốn thay đổi sức chứa của phòng không: true/false");
					tf = sc.nextBoolean();
					if (tf) {
						System.out.println("Bạn muốn thay đổi sức chứa của phòng thành: ");
						phongtn.setSucChua(sc.nextInt());
					}
					System.out.println("Bạn có muốn thay đổi bồn rửa tay của phòng không: true/false");
					tf = sc.nextBoolean();
					if (tf) {
						System.out.println("Bạn muốn thay đổi bồn rửa tay của phòng thành: ");
						phongtn.setBonRuaTay(sc.nextBoolean());
					}
				}
				if (phongHoc instanceof PhongLyThuyet) {
					PhongLyThuyet phongLT = (PhongLyThuyet) phongHoc;
					System.out.println("Bạn có muốn thay đổi máy chiếu của phòng không: true/false");
					tf = sc.nextBoolean();
					if (tf) {
						System.out.println("Bạn muốn thay đổi máy chiếu của phòng thành: ");
						phongLT.setMayChieu(sc.nextBoolean());
					}
				}
				if (phongHoc instanceof PhongMayTinh) {
					PhongMayTinh phongMT = (PhongMayTinh) phongHoc;
					System.out.println("Bạn có muốn thay đổi số máy tính của phòng không: true/false");
					tf = sc.nextBoolean();
					if (tf) {
						System.out.println("Bạn muốn thay đổi số máy tính của phòng thành: ");
						phongMT.setSoMayTinh(sc.nextInt());
					}
				}
			}
		}
	}

	void timKiemPhong() {
		System.out.println("Nhập vào mã phòng cần tìm: ");
		int maPhong = sc.nextInt();
		for (PhongHoc phongHoc : dsPhong) {
			if (phongHoc.getMaPhong() == maPhong) {
				System.out.println("Tìm thấy phòng: " + phongHoc.toString());
				return;
			}
		}
		System.out.println("Không tìm thấy phòng có mã phòng " + maPhong);
	}

	void timKiemPhong(String dayNha, int maPhong) {
		for (PhongHoc phongHoc : dsPhong) {
			if (phongHoc.getDayNha().equalsIgnoreCase(dayNha) && phongHoc.getMaPhong() == maPhong) {
				System.out.println("Tìm thấy phòng: " + phongHoc.toString());
				return;
			}
		}
		System.out.println("Không tìm thấy phòng theo yêu cầu!");
	}

	PhongHoc timKiemPhong(String dayNha, int maPhong, double dientich) {
		for (PhongHoc phongHoc : dsPhong) {
			if (phongHoc.getDayNha().equalsIgnoreCase(dayNha) && phongHoc.getMaPhong() == maPhong) {
				if (phongHoc.getDienTich() == dientich) {
					return phongHoc;
				}
			}
		}
		return null;
	}

	void inDSPhong() {
		for (PhongHoc phongHoc : dsPhong) {
			System.out.println(phongHoc.toString());
		}
	}

	void inTongSoPhong() {
		System.out.println("Tổng số phòng là: " + dsPhong.size());
	}

	void inDSPhongLT() {
		System.out.println("Danh sách phòng lý thuyết: ");
		for (PhongHoc phongHoc : dsPhong) {
			if (phongHoc instanceof PhongLyThuyet) {
				System.out.println(phongHoc.toString());
			}
		}
	}

	void inDSPhongTN() {
		System.out.println("Danh sách phòng thí nghiệm: ");
		for (PhongHoc phongHoc : dsPhong) {
			if (phongHoc instanceof PhongThiNghiem) {
				System.out.println(phongHoc.toString());
			}
		}
	}

	void inDSPhongMT() {
		System.out.println("Danh sách phòng máy tính: ");
		for (PhongHoc phongHoc : dsPhong) {
			if (phongHoc instanceof PhongMayTinh) {
				System.out.println(phongHoc.toString());
			}
		}
	}

	void inSLTungPhong() {
		int phongLT = 0, phongMT = 0, phongTN = 0;
		for (PhongHoc phongHoc : dsPhong) {
			if (phongHoc instanceof PhongMayTinh) {
				phongMT++;
			} else if (phongHoc instanceof PhongThiNghiem) {
				phongTN++;
			} else {
				phongLT++;
			}
		}
		System.out.println("Tổng số lượng phòng lý thuyết là: " + phongLT);
		System.out.println("Tổng số lượng phòng máy tính là: " + phongMT);
		System.out.println("Tổng số lượng phòng thí nghiệm là: " + phongTN);
	}

	void sapXemTheoMaPhongTang() {
		PhongHoc temp = null;
		for (int i = 0; i < dsPhong.size() - 1; i++) {
			for (int j = i + 1; j < dsPhong.size(); j++) {
				if (dsPhong.get(i).getMaPhong() > dsPhong.get(j).getMaPhong()) {
					temp = dsPhong.get(i);
					dsPhong.set(i, dsPhong.get(j));
					dsPhong.set(j, temp);
				}
			}
		}
		System.out.println("Sắp xếp thành công");
	}

	void sapXemTheoMaPhongGiam() {
		PhongHoc temp = null;
		for (int i = 0; i < dsPhong.size() - 1; i++) {
			for (int j = i + 1; j < dsPhong.size(); j++) {
				if (dsPhong.get(i).getMaPhong() < dsPhong.get(j).getMaPhong()) {
					temp = dsPhong.get(i);
					dsPhong.set(i, dsPhong.get(j));
					dsPhong.set(j, temp);
				}
			}
		}
		System.out.println("Sắp xếp thành công");
	}

	void inDSPhongDatChuan() {
		System.out.println("Danh sách phòng đạt chuẩn và không đạt chuẩn: ");
		for (PhongHoc phongHoc : dsPhong) {
			if (phongHoc.kiemTraDatChuan()) {
				System.out.println("Phòng đạt chuẩn: " + phongHoc.toString());
			} else {
				System.out.println("Phòng không đạt chuẩn: " + phongHoc.toString());
			}
		}
	}

	public List<PhongHoc> getDsPhong() {
		return dsPhong;
	}

	public void setDsPhong(List<PhongHoc> dsPhong) {
		this.dsPhong = dsPhong;
	}

	void themPhong(PhongHoc phong) {
		dsPhong.add(phong);
	}
}