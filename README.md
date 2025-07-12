# OOP_N05_T3_2025_GROUP_Hung_Linh_Minh
Ứng dụng quản lý sách thư viện

## Sơ đồ chức năng:
<img width="603" height="379" alt="Untitled (1)" src="https://github.com/user-attachments/assets/95a95a80-605d-402f-8ee9-b737d1a094bf" />


## Sơ đồ thuật toán:
BookCRUD:
<img width="1836" height="701" alt="w" src="https://github.com/user-attachments/assets/924231f0-713a-4de2-a654-f2696fdc9ba8" />
Membercrud:

<img width="491" height="534" alt="Untitled (1)" src="https://github.com/user-attachments/assets/e76b95a2-96df-4db4-816c-c6f2b3880208" />

LoanCRUD:
<img width="926" height="706" alt="Untitled" src="https://github.com/user-attachments/assets/9e888296-ea51-4f53-92c8-be65c93d00e6" />



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

+ Số điện thoại (phone): Số điện thoại liên hệ

### 4. Mượn sách (Loan)

+ Mã mượn (loanID): Mã duy nhất của giao dịch mượn sách.

+ Sách mượn (book): Sách được mượn.

+ Người đọc (member): Người mượn sách.

+ Ngày mượn (borrowDate): Ngày sách được mượn.

+ Ngày trả (returnDate): Ngày sách cần phải trả.

 + Danh sách sách mượn (borrowedBooks): Danh sách các sách mà người đọc đã mượn

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
