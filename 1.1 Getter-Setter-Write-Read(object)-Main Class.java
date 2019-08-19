package quanlysanpham.ver2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class Main {
public static void main(String[] args) throws IOException {
	
	SanPham Xiomi = new SanPham("XM01","Xiaomi Hub","Bộ trung tâm",50,10,1250000);
	SanPham Broadlink = new SanPham("BR01","RM mini 3","Bộ điều khiển thiết bị hồng ngoại",10,5,450000);
//Xiomi.showInfo_Chung();
Xiomi.showInfoSanpham();
//Broadlink.showInfoSanpham();

String fileName = "SanPham.txt";
try {
	ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fileName));
	os.writeObject(Xiomi);
	//os.writeObject(Broadlink);
	os.close();
} catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
finally {
	System.out.println(" COMPLETELY DONE WRITING");
	System.out.println(" CHECK AGAIN");
}

try {
	ObjectInputStream is = new ObjectInputStream(new FileInputStream(fileName));
	SanPham  Xiomi1 = (SanPham) is.readObject();
	System.out.println("\n Read mã số :" + Xiomi1.maso + " \n Read tên:" +Xiomi1.ten + "\n Read loại sản phẩm:" 
	+ Xiomi1.loaisanpham+ "\n Read số lượng:"+Xiomi1.soluongsanpham+ 
	"\n Read khuyến mãi :"+ Xiomi1.phantramkhuyenmai + " \n Read đơn giá:"+Xiomi1.dongiasanpham);
	
	
} catch (Exception e) {
	// TODO: handle exception
}
}

}
