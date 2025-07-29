package com.example.servingwebcontent.Controller;

import java.time.*;
import java.time.format.*;
import java.util.*;
import java.text.NumberFormat;
import java.util.stream.Collectors;

public class QuanNetConsoleApp {
    private static QuanLyMayTinh quanLyMayTinh = new QuanLyMayTinh();
    private static QuanLyKhachHang quanLyKhachHang = new QuanLyKhachHang();
    private static QuanLyThanhToan quanLyThanhToan = new QuanLyThanhToan(quanLyKhachHang, quanLyMayTinh);
    private static Scanner scanner = new Scanner(System.in);
    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");
    private static NumberFormat nf = NumberFormat.getNumberInstance(Locale.of("vi", "VN"));

    public static void test() {
        khoiTaoDuLieuMau();
        
        while (true) {
            System.out.println("\n╔════════════════════════════════╗");
            System.out.println("║   HỆ THỐNG QUẢN LÝ QUÁN NET    ║");
            System.out.println("╠════════════════════════════════╣");
            System.out.println("║ 1. Quản lý máy tính            ║");
            System.out.println("║ 2. Quản lý khách hàng          ║");
            System.out.println("║ 3. Quản lý thanh toán          ║");
            System.out.println("║ 4. Thống kê doanh thu          ║");
            System.out.println("║ 5. Thoát chương trình          ║");
            System.out.println("╚════════════════════════════════╝");
            System.out.print("Chọn chức năng (1-5): ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        quanLyMayTinhMenu();
                        break;
                    case 2:
                        quanLyKhachHangMenu();
                        break;
                    case 3:
                        quanLyThanhToanMenu();
                        break;
                    case 4:
                        thongKeDoanhThu();
                        break;
                    case 5:
                        System.out.println("\nCảm ơn đã sử dụng chương trình!");
                        System.exit(0);
                    default:
                        System.out.println("Lựa chọn không hợp lệ!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số từ 1 đến 5!");
            }
        }
    }

    private static void khoiTaoDuLieuMau() {
        // Thêm máy tính mẫu
        quanLyMayTinh.themMayTinh(new MayTinh(1, 15000));
        quanLyMayTinh.themMayTinh(new MayTinh(2, 20000));
        quanLyMayTinh.themMayTinh(new MayTinh(3, 18000));
        ;
        // Thêm phần mềm mẫu vào máy tính
        quanLyMayTinh.themPhanMemVaoMay(1, "Liên Minh ");
        quanLyMayTinh.themPhanMemVaoMay(2, "Valorant");
        quanLyMayTinh.themPhanMemVaoMay(3, "Minecraft");
       
        // Thêm khách hàng mẫu
        quanLyKhachHang.themKhachHang(new KhachHang("001", "Nguyễn Thị Kim Oanh", "0924899873"));
        quanLyKhachHang.themKhachHang(new KhachHang("002", "Hoàng Nhật Bảo Trâm", "0914324828"));
    }

    private static void quanLyMayTinhMenu() {
        while (true) {
            System.out.println("\n╔════════════════════════════════╗");
            System.out.println("║      QUẢN LÝ MÁY TÍNH        ║");
            System.out.println("╠════════════════════════════════╣");
            System.out.println("║ 1. Thêm máy tính mới           ║");
            System.out.println("║ 2. Hiển thị danh sách máy      ║");
            System.out.println("║ 3. Cập nhật giá máy            ║");
            System.out.println("║ 4. Xóa máy tính                ║");
            System.out.println("║ 5. Quản lý trạng thái máy      ║");
            System.out.println("║ 6. Quản lý phần mềm            ║");
            System.out.println("║ 7. Quay lại menu chính         ║");
            System.out.println("╚════════════════════════════════╝");
            System.out.print("Chọn chức năng (1-7): ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                if (choice == 7) break;

                switch (choice) {
                    case 1:
                        themMayTinh();
                        break;
                    case 2:
                        hienThiDanhSachMayTinh();
                        break;
                    case 3:
                        capNhatGiaMayTinh();
                        break;
                    case 4:
                        xoaMayTinh();
                        break;
                    case 5:
                        quanLyTrangThaiMayTinh();
                        break;
                    case 6:
                         quanLyPhanMemMayTinh();
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số từ 1 đến 6!");
            }
        }
    }

    private static void quanLyKhachHangMenu() {
        while (true) {
            System.out.println("\n╔════════════════════════════════╗");
            System.out.println("║      QUẢN LÝ KHÁCH HÀNG        ║");
            System.out.println("╠════════════════════════════════╣");
            System.out.println("║ 1. Thêm khách hàng mới         ║");
            System.out.println("║ 2. Hiển thị danh sách KH       ║");
            System.out.println("║ 3. Cập nhật thông tin KH       ║");
            System.out.println("║ 4. Xóa khách hàng              ║");
            System.out.println("║ 5. Nạp tiền cho KH             ║");
            System.out.println("║ 6. Quay lại menu chính         ║");
            System.out.println("╚════════════════════════════════╝");
            System.out.print("Chọn chức năng (1-6): ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                if (choice == 6) break;

                switch (choice) {
                    case 1:
                        themKhachHang();
                        break;
                    case 2:
                        hienThiDanhSachKhachHang();
                        break;
                    case 3:
                        capNhatKhachHang();
                        break;
                    case 4:
                        xoaKhachHang();
                        break;
                    case 5:
                        napTienKhachHang();
                        break;
                    case 7:
                        xemLichSuThanhToan();
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số từ 1 đến 6!");
            }
        }
    }

    private static void quanLyThanhToanMenu() {
        while (true) {
            System.out.println("\n╔════════════════════════════════╗");
            System.out.println("║      QUẢN LÝ THANH TOÁN        ║");
            System.out.println("╠════════════════════════════════╣");
            System.out.println("║ 1. Bắt đầu sử dụng máy         ║");
            System.out.println("║ 2. Kết thúc sử dụng máy        ║");
            System.out.println("║ 3. Xem lịch sử thanh toán      ║");
            System.out.println("║ 4. Quay lại menu chính         ║");
            System.out.println("╚════════════════════════════════╝");
            System.out.print("Chọn chức năng (1-4): ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                if (choice == 4) break;

                switch (choice) {
                    case 1:
                        batDauSuDungMay();
                        break;
                    case 2:
                        ketThucSuDungMay();
                        break;
                    case 3:
                        xemLichSuThanhToan();
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số từ 1 đến 4!");
            }
        }
    }

    // Các phương thức quản lý máy tính
    private static void themMayTinh() {
        System.out.println("\n--- THÊM MÁY TÍNH MỚI ---");
        System.out.print("Nhập ID máy tính: ");
        int id = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Nhập giá tiền theo giờ (VND): ");
        double giaTien = Double.parseDouble(scanner.nextLine());
        
        MayTinh mayTinh = new MayTinh(id, giaTien);
        quanLyMayTinh.themMayTinh(mayTinh);
        System.out.println("Đã thêm máy tính thành công!");
    }

    private static void hienThiDanhSachMayTinh() {
        System.out.println("\n--- DANH SÁCH MÁY TÍNH ---");
        List<MayTinh> danhSach = quanLyMayTinh.getDanhSachMayTinh();
        
        if (danhSach.isEmpty()) {
            System.out.println("Không có máy tính nào trong hệ thống!");
            return;
        }
        
        System.out.printf("%-5s %-15s %-20s %-15s %-20s%n", 
            "ID", "Trạng thái", "Giá/giờ", "Phần mềm", "Thời gian sử dụng");
        System.out.println("--------------------------------------------------------------------------------");
        
        for (MayTinh may : danhSach) {
            String trangThai = may.getTrangThai().toString();
            String giaTien = nf.format(may.getGiaTienTheoGio()) + " VND";
            String phanMem = may.getDanhSachPhanMem().isEmpty() ? "Không có" 
                : String.join(", ", may.getDanhSachPhanMem());
            
            String thoiGian = "Chưa sử dụng";
            if (may.getThoiGianBatDau() != null) {
                if (may.getThoiGianKetThuc() != null) {
                    long phut = Duration.between(may.getThoiGianBatDau(), may.getThoiGianKetThuc()).toMinutes();
                    thoiGian = String.format("%d phút", phut);
                } else {
                    thoiGian = "Đang sử dụng từ " + may.getThoiGianBatDau().format(dtf);
                }
            }
            
            System.out.printf("%-5d %-15s %-20s %-15s %-20s%n", 
                may.getId(), trangThai, giaTien, phanMem, thoiGian);
        }
    }

    private static void capNhatGiaMayTinh() {
        System.out.println("\n--- CẬP NHẬT GIÁ MÁY TÍNH ---");
        System.out.print("Nhập ID máy tính: ");
        int id = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Nhập giá mới (VND/giờ): ");
        double giaMoi = Double.parseDouble(scanner.nextLine());
        
        if (quanLyMayTinh.capNhatGiaMayTinh(id, giaMoi)) {
            System.out.println("Cập nhật giá thành công!");
        } else {
            System.out.println("Không tìm thấy máy tính hoặc có lỗi!");
        }
    }

    private static void xoaMayTinh() {
        System.out.println("\n--- XÓA MÁY TÍNH ---");
        System.out.print("Nhập ID máy tính cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        
        if (quanLyMayTinh.xoaMayTinh(id)) {
            System.out.println("Đã xóa máy tính thành công!");
        } else {
            System.out.println("Không tìm thấy máy tính!");
        }
    }

    private static void quanLyTrangThaiMayTinh() {
        System.out.println("\n--- QUẢN LÝ TRẠNG THÁI MÁY ---");
        System.out.print("Nhập ID máy tính: ");
        int id = Integer.parseInt(scanner.nextLine());
        
        MayTinh may = quanLyMayTinh.timMayTinh(id);
        if (may == null) {
            System.out.println("Không tìm thấy máy tính!");
            return;
        }
        
        System.out.println("1. Đặt trạng thái RẢNH");
        System.out.println("2. Đặt trạng thái BẢO TRÌ");
        System.out.print("Chọn trạng thái (1-2): ");
        int choice = Integer.parseInt(scanner.nextLine());
        
        switch (choice) {
            case 1:
                may.setTrangThai(MayTinh.TrangThaiMay.DANG_RANH);
                System.out.println("Đã cập nhật trạng thái!");
                break;
            case 2:
                may.setTrangThai(MayTinh.TrangThaiMay.DANG_BAO_TRI);
                System.out.println("Đã cập nhật trạng thái!");
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ!");
        }
    }
     
      private static void quanLyPhanMemMayTinh() {
        while (true) {
            System.out.println("\n--- QUẢN LÝ PHẦN MỀM ---");
            System.out.println("1. Thêm phần mềm vào máy");
            System.out.println("2. Xóa phần mềm khỏi máy");
            System.out.println("3. Quay lại menu quản lý máy tính");
            System.out.print("Chọn chức năng (1-3): ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice == 3) break;

                switch (choice) {
                    case 1:
                        themPhanMemVaoMay();
                        break;
                    case 2:
                        xoaPhanMemKhoiMay();
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số từ 1 đến 3!");
            }
        }
    }

    private static void themPhanMemVaoMay() {
        System.out.println("\n--- THÊM PHẦN MỀM VÀO MÁY ---");
        System.out.print("Nhập ID máy tính: ");
        int idMay = Integer.parseInt(scanner.nextLine());

        System.out.print("Nhập tên phần mềm muốn thêm: ");
        String tenPhanMem = scanner.nextLine();

        if (quanLyMayTinh.themPhanMemVaoMay(idMay, tenPhanMem)) {
            System.out.println("Đã thêm phần mềm '" + tenPhanMem + "' vào máy ID " + idMay + " thành công!");
        } else {
            System.out.println("Không tìm thấy máy tính hoặc có lỗi!");
        }
    }

    private static void xoaPhanMemKhoiMay() {
        System.out.println("\n--- XÓA PHẦN MỀM KHỎI MÁY ---");
        System.out.print("Nhập ID máy tính: ");
        int idMay = Integer.parseInt(scanner.nextLine());

        System.out.print("Nhập tên phần mềm muốn xóa: ");
        String tenPhanMem = scanner.nextLine();

        if (quanLyMayTinh.xoaPhanMemKhoiMay(idMay, tenPhanMem)) {
            System.out.println("Đã xóa phần mềm '" + tenPhanMem + "' khỏi máy ID " + idMay + " thành công!");
        } else {
            System.out.println("Không tìm thấy máy tính hoặc phần mềm không có trên máy!");
        }
    }

    // Các phương thức quản lý khách hàng
    private static void themKhachHang() {
        System.out.println("\n--- THÊM KHÁCH HÀNG MỚI ---");
        System.out.print("Nhập mã khách hàng: ");
        String maKH = scanner.nextLine();
        
        System.out.print("Nhập tên khách hàng: ");
        String tenKH = scanner.nextLine();
        
        System.out.print("Nhập số điện thoại: ");
        String sdt = scanner.nextLine();
        
        KhachHang khachHang = new KhachHang(maKH, tenKH, sdt);
        quanLyKhachHang.themKhachHang(khachHang);
        System.out.println("Đã thêm khách hàng thành công!");
    }
    private static void hienThiDanhSachKhachHang() {
        System.out.println("\n--- DANH SÁCH KHÁCH HÀNG ---");
        List<KhachHang> danhSach = quanLyKhachHang.getDanhSachKhachHang();
        
        if (danhSach.isEmpty()) {
            System.out.println("Không có khách hàng nào trong hệ thống!");
            return;
        }
        
        System.out.printf("%-10s %-20s %-15s%n", "Mã KH", "Tên khách hàng", "Số điện thoại");
        System.out.println("-----------------------------------------------------");
        
        for (KhachHang kh : danhSach) {
            System.out.printf("%-10s %-20s %-15s%n", 
                kh.getMaKhachHang(), kh.getTenKhachHang(), kh.getSoDienThoai());
        }
    }
    

    private static void capNhatKhachHang() {
        System.out.println("\n--- CẬP NHẬT THÔNG TIN KHÁCH HÀNG ---");
        System.out.print("Nhập mã khách hàng: ");
        String maKH = scanner.nextLine();
        
        KhachHang kh = quanLyKhachHang.timKhachHang(maKH);
        if (kh == null) {
            System.out.println("Không tìm thấy khách hàng!");
            return;
        }
        
        System.out.print("Nhập tên mới: ");
        String tenMoi = scanner.nextLine();
        kh.setTenKhachHang(tenMoi);
        
        System.out.print("Nhập số điện thoại mới: ");
        String sdtMoi = scanner.nextLine();
        kh.setSoDienThoai(sdtMoi);
        
        System.out.println("Đã cập nhật thông tin khách hàng!");
    }

    private static void xoaKhachHang() {
        System.out.println("\n--- XÓA KHÁCH HÀNG ---");
        System.out.print("Nhập mã khách hàng cần xóa: ");
        String maKH = scanner.nextLine();
        
        if (quanLyKhachHang.xoaKhachHang(maKH)) {
            System.out.println("Đã xóa khách hàng thành công!");
        } else {
            System.out.println("Không tìm thấy khách hàng!");
        }
    }

    private static void napTienKhachHang() {
        System.out.println("\n--- NẠP TIỀN CHO KHÁCH HÀNG ---");
        System.out.print("Nhập mã khách hàng: ");
        String maKH = scanner.nextLine();
        
        KhachHang kh = quanLyKhachHang.timKhachHang(maKH);
        if (kh == null) {
            System.out.println("Không tìm thấy khách hàng!");
            return;
        }
        
        System.out.print("Nhập số tiền cần nạp (VND): ");
        double soTien = Double.parseDouble(scanner.nextLine());
        
        quanLyKhachHang.napTien(maKH, soTien);
        System.out.println("Đã nạp tiền thành công! Số dư mới: " + nf.format(kh.getSoDuTaiKhoan()) + " VND");
    }

    // Các phương thức quản lý thanh toán
    private static void batDauSuDungMay() {
        System.out.println("\n--- BẮT ĐẦU SỬ DỤNG MÁY ---");
        System.out.print("Nhập mã khách hàng: ");
        String maKH = scanner.nextLine();
        
        System.out.print("Nhập ID máy tính: ");
        int idMay = Integer.parseInt(scanner.nextLine());
        
        if (quanLyMayTinh.batDauSuDungMay(idMay, maKH)) {
            System.out.println("Đã bắt đầu sử dụng máy thành công!");
        } else {
            System.out.println("Không thể bắt đầu sử dụng máy (máy đang bận hoặc không tồn tại)!");
        }
    }

    private static void ketThucSuDungMay() {
        System.out.println("\n--- KẾT THÚC SỬ DỤNG MÁY ---");
        System.out.print("Nhập mã khách hàng: ");
        String maKH = scanner.nextLine();
        
        System.out.print("Nhập ID máy tính: ");
        int idMay = Integer.parseInt(scanner.nextLine());
        
        if (quanLyThanhToan.thanhToan(maKH, idMay)) {
            System.out.println("Đã thanh toán thành công!");
        } else {
            System.out.println("Thanh toán thất bại (không đủ tiền hoặc máy không đang sử dụng)!");
        }
    }

    private static void xemLichSuThanhToan() {
        System.out.println("\n--- LỊCH SỬ THANH TOÁN ---");
        List<ThanhToan> danhSach = quanLyThanhToan.getDanhSachHoaDon();
        
        if (danhSach.isEmpty()) {
            System.out.println("Không có lịch sử thanh toán!");
            return;
        }
        
        System.out.printf("%-10s %-10s %-5s %-20s %-20s %15s%n", 
            "Mã HD", "Mã KH", "Máy", "Bắt đầu", "Kết thúc", "Thành tiền");
        System.out.println("--------------------------------------------------------------------------------");
        
        for (ThanhToan hd : danhSach) {
            System.out.printf("%-10s %-10s %-5d %-20s %-20s %15s VND%n", 
                hd.getMaHoaDon(), hd.getMaKhachHang(), hd.getIdMayTinh(),
                hd.getThoiGianBatDau().format(dtf), hd.getThoiGianKetThuc().format(dtf),
                nf.format(hd.getThanhTien()));
        }
    }

    private static void thongKeDoanhThu() {
        System.out.println("\n--- THỐNG KÊ DOANH THU ---");
        
        // Thống kê theo ngày
        Map<LocalDate, Double> doanhThuTheoNgay = quanLyThanhToan.getDanhSachHoaDon().stream()
            .collect(Collectors.groupingBy(
                hd -> hd.getThoiGianThanhToan().toLocalDate(),
                Collectors.summingDouble(ThanhToan::getThanhTien)
            ));
        
        System.out.println("\nDoanh thu theo ngày:");
        System.out.printf("%-15s %-15s%n", "Ngày", "Doanh thu");
        System.out.println("-------------------------------");
        doanhThuTheoNgay.entrySet().stream()
            .sorted(Map.Entry.comparingByKey())
            .forEach(entry -> {
                System.out.printf("%-15s %15s VND%n", 
                    entry.getKey().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), 
                    nf.format(entry.getValue()));
            });
        
        // Tổng doanh thu
        double tongDoanhThu = quanLyThanhToan.getDanhSachHoaDon().stream()
            .mapToDouble(ThanhToan::getThanhTien)
            .sum();
        
        System.out.println("\nTổng doanh thu: " + nf.format(tongDoanhThu) + " VND");
    }
}