# OOP_N05_T3_2025_GROUP_Hung_Linh_Minh
Ứng dụng quản lý sách thư viện

## Sơ đồ chức năng:
<img width="660" height="421" alt="project vpd (3)" src="https://github.com/user-attachments/assets/da348b0c-4bfd-400c-a259-4152b325f85d" />
## Sơ đồ thuật toán:
<img width="348" height="575" alt="515854980_2206650783113886_8801041328317978693_n" src="https://github.com/user-attachments/assets/a0311b2f-9105-4ad3-bc9b-f3127692ed50" />

# Describe and Analyse the Project
## Đối tượng:
### 1. Sách (Book)

+ Mã sách (bookID): Mỗi sách sẽ có một mã duy nhất.

+ Tên sách (title): Tên của cuốn sách.


+ Tác giả (author): Tác giả của cuốn sách.

+ Nhà xuất bản (publisher): Nhà xuất bản của sách.

+ Năm xuất bản (yearPublished): Năm xuất bản.

+ Thể loại (category): Thể loại sách (ví dụ: văn học, khoa học, lịch sử, ...).

+ Số lượng (quantity): Số lượng sách có trong thư viện.

### 2. Thư viện (Library)

+ Tên thư viện (libraryName): Tên của thư viện.

+ Địa chỉ (address): Địa chỉ của thư viện.

+ Danh sách sách (books): Danh sách các cuốn sách có trong thư viện.

+ Danh sách bạn đọc (members): Danh sách người sử dụng thư viện.

### 3. Người đọc (Member)

+ Mã người đọc (memberID): Mã duy nhất của bạn đọc.

+ Tên (name): Tên của người đọc.

+ Địa chỉ (address): Địa chỉ của người đọc.

+ Số điện thoại (phone): Số điện thoại liên hệ.

+ Danh sách sách mượn (borrowedBooks): Danh sách các sách mà người đọc đã mượn

### 4. Mượn sách (Loan)

+ Mã mượn (loanID): Mã duy nhất của giao dịch mượn sách.

+ Sách mượn (book): Sách được mượn.

+ Người đọc (member): Người mượn sách.

+ Ngày mượn (borrowDate): Ngày sách được mượn.

+ Ngày trả (returnDate): Ngày sách cần phải trả.

### 5. Quản lý hệ thống (SystemManager)

+ Danh sách thư viện (libraries): Danh sách các thư viện (nếu có hệ thống quản lý nhiều thư viện).

+ Danh sách bạn đọc (members): Danh sách các bạn đọc trong hệ thống.

### 6. Phạt (Fine)

+ Mã phạt (fineID): Mã duy nhất của khoản phạt.

+ Người đọc (member): Người bị phạt.

+ Số tiền phạt (amount): Số tiền phạt.

+ Lý do (reason): Lý do phạt (ví dụ: trả sách trễ).
# Thành viên:
1. Trần Gia Hưng, MSV: 24100078
2. Nguyễn Xuân Minh, MSV: 24100172
3. Bùi Đoàn Phương Linh, MSV: 24100234
4. Nguyễn Lệ Thu
