# OOP_N05_T3_2025_GROUP_Hung_Linh_Minh
Ứng dụng quản lý sách thư viện

## Sơ đồ chức năng:
<img width="638" height="447" alt="image" src="https://github.com/user-attachments/assets/d6ca997e-c95c-4cdf-b92d-210d16ddf89c" />



## Sơ đồ thuật toán:
BookCRUD:
<img width="1836" height="701" alt="w" src="https://github.com/user-attachments/assets/924231f0-713a-4de2-a654-f2696fdc9ba8" />
Membercrud:

<img width="491" height="534" alt="Untitled (1)" src="https://github.com/user-attachments/assets/e76b95a2-96df-4db4-816c-c6f2b3880208" />

LoanCRUD:
<img width="926" height="706" alt="Untitled" src="https://github.com/user-attachments/assets/9e888296-ea51-4f53-92c8-be65c93d00e6" />

Fine:
<img width="317" height="513" alt="image" src="https://github.com/user-attachments/assets/67a0e96c-1df0-4a21-91f4-664c04a35794" />

Staff:
<img width="510" height="555" alt="image" src="https://github.com/user-attachments/assets/7b67c137-a656-4015-b0d5-ab384481778a" />




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

### 2. Người đọc (Member)

+ Mã người đọc (memberID): Mã duy nhất của bạn đọc.

+ Tên (name): Tên của người đọc.

+ Địa chỉ (address): Địa chỉ của người đọc.

+ Số điện thoại (phone): Số điện thoại liên hệ

### 3. Mượn sách (Loan)

+ Mã mượn (loanID): Mã duy nhất của giao dịch mượn sách.

+ Sách mượn (book): Sách được mượn.

+ Người đọc (member): Người mượn sách.

+ Ngày mượn (borrowDate): Ngày sách được mượn.

+ Ngày trả (returnDate): Ngày sách cần phải trả.

 + Danh sách sách mượn (borrowedBooks): Danh sách các sách mà người đọc đã mượn

### 4. Phạt (Fine)

+ Mã phạt (fineID): Mã duy nhất của khoản phạt.

+ Người đọc (member): Người bị phạt.

+ Số tiền phạt (amount): Số tiền phạt.

+ Lý do (reason): Lý do phạt (ví dụ: trả sách trễ).
### 5. Quản Lý (Staff)
+ Mã nhân viên – định danh duy nhất cho mỗi nhân viên

+ Họ và tên – tên đầy đủ của nhân viên

+ Chức vụ – ví dụ: Thủ thư, Quản lý, Trợ lý

+ Số điện thoại – liên hệ nội bộ hoặc với thành viên

+ Email – dùng cho trao đổi, thông báo

# Thành viên:
1. Trần Gia Hưng, MSV: 24100078
2. Nguyễn Xuân Minh, MSV: 24100172
3. Bùi Đoàn Phương Linh, MSV: 24100234
4. Nguyễn Lệ Thu
