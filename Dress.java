import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.time.LocalDate;
import java.util.Stack;

 public class Dress {
    class Node {
        String data; 
        Node next;
        public Node(String d1) { 
            data = d1; 
            next = null; 
        }
    }

    // Inisialisasi head (awal)
    Node head; 
    
    public boolean isEmpty() {
        return head == null; 
    }

    // Menyisipkan data dari depan head
    public void insertFront(String data) {
        
        Node baru = new Node(data);
        if (isEmpty()) { 
            head = baru;  
        } else {
            baru.next = head;
            head = baru;  
        }
        
    }

    
    // Menyisipkan data dari belakang
    public void insertBack(String data) {
        Node baru = new Node(data);
        if (isEmpty()) {
            head = baru;      
        } else {
            Node bantu = head;       
            while (bantu.next != null) { 
                bantu = bantu.next;  
            }
            bantu.next = baru;  
            
        }
    }

    
        //menghapus dari depan
        public void deleteFront() {
            Node hapus;
            if(!isEmpty()) {
                if(head.next != null) {
                    hapus = head;
                    head = head.next;
                } else {
                    head = null;
                }
            }
        }


            //menghapus dari belakang
            public void deleteEnd() {
                Node bantu;
                    if(!isEmpty()) {
                        if(head.next != null) {
                            bantu = head;
                        while(bantu.next.next != null){
                            bantu = bantu.next;
                        }
                        bantu.next = null;
                        } else {
                            head = null;
                        }
                    }
            }
                
   
    // Menghapus node dari posisi tertentu
    public void deleteMiddle(String cari) { 
        if (!isEmpty()) { 
            if (head.data == cari) { 
                head = head.next; 
            } else {
                Node bantu = head;
                
                while (bantu.next != null && bantu.next.data != cari) { 
                    bantu = bantu.next; 
                }
                if (bantu.next != null) {
                    bantu.next = bantu.next.next; 
                }
            }
        }
    }

    //mencetak data pada linkedlist
    public void printList(){
        if (!isEmpty()){
            Node sekarang = head; 
            while (sekarang != null){
                System.out.print(sekarang.data + " ");
                sekarang = sekarang.next;
            }
        }else{
            System.out.println("list dalam kondisi kosong");
        }
    }

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  Galery Abidah Dress Maker  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n");
        System.out.println("Berikut merupakan data dari Abidah Dress Maker:");
        System.out.println("1. Menghitung gaji");                                     
        System.out.println("2. Data Barang");
        System.out.println("3. Data Pegawai");
        System.out.println("4. Deadline pesanan");
        System.out.print("\nSilahkan pilih menu yang ingin anda lihat: ");

        int menu = scanner.nextInt();

        switch (menu) {
            case 1:

             // PROGRAM MENGHITUNG GAJI
             System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Menghitung Gaji Karyawan <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
             System.out.print("Masukkan jumlah karyawan: ");
             int jumlahKaryawan = scanner.nextInt();
             //Mendeklarasikan array untuk menyimpan data karyawan:
             int[] kehadiran = new int[jumlahKaryawan];
             int[] libur = new int[jumlahKaryawan];
             int[] lembur = new int[jumlahKaryawan];
             double[] gaji = new double[jumlahKaryawan];
             double[] gajiTotal = new double[jumlahKaryawan];

             // Menginput data kehadiran, gaji pokok, dan potongan libur untuk setiap karyawan
             for (int i = 0; i < jumlahKaryawan; i++) {
                 System.out.print("Masukkan jumlah kehadiran karyawan ke-" + (i+1) + ": ");
                 kehadiran[i] = scanner.nextInt();

                 System.out.print("Masukkan jumlah hari libur karyawan ke-" + (i+1) + ": ");
                 libur[i] = scanner.nextInt();

                 System.out.print("Masukkan jumlah hari lembur karyawan ke-" + (i+1) + ": ");
                 lembur[i] = scanner.nextInt();

                 System.out.print("Masukkan gaji harian karyawan ke-" + (i+1) + ": ");
                 gaji[i] = scanner.nextDouble();
                 
                 // Menghitung gaji total
                 int totalKehadiran = kehadiran[i] +(lembur[i]/2)- libur[i];
                 gajiTotal[i] = gaji[i] * totalKehadiran;
             }

             // Menampilkan gaji karyawan
             for (int i = 0; i < jumlahKaryawan; i++) {
                 System.out.println("======================================================"); 
                 System.out.println("Gaji karyawan ke-" + (i+1) + ": " + gajiTotal[i]);
                 System.out.println("------------------------------------------------------");   
             }
               
                
                break;
            case 2:
                // Program data barang
                Dress dres = new Dress();
                System.out.println("\n==========================================> Data Barang <==========================================");
        // data stok kain
                dres.insertFront("merah daces,");
                dres.insertBack("sage satin,");
                dres.insertBack("denim brokat cantili,");
                dres.insertBack("putih brokat fren lench,");
                dres.deleteMiddle("merah daces");
                System.out.println("Stok Kain yang tersedia: ");
                dres.printList();
                
                System.out.println("\n--------------------------------------------------------------------------------------------------");
        // data stok payet mutiara
                Dress dress = new Dress();
                dress.insertFront("putih,");
                dress.insertBack("maroon,");
                dress.insertBack("hitam,");
                dress.insertBack("sage");

                dress.deleteMiddle("sage");

                System.out.println(" ");
                System.out.println("Stok payet mutiara yang tersedia: ");
                dress.printList();
                System.out.println("\n--------------------------------------------------------------------------------------------------");


                // data stok payet daun
                Dress dres2 = new Dress();
                dres2.insertFront("putih,");
                dres2.insertBack("maroon,");
                dres2.insertBack("hitam,");
                dres2.insertBack("sage");

                dres2.deleteMiddle("sage");

                System.out.println(" ");
                System.out.println("Stok payet daun yang tersedia: ");
                dress.printList();
                System.out.println("\n--------------------------------------------------------------------------------------------------");

                // data stok payet koin
                Dress dres3 = new Dress();
                dres3.insertFront("putih,");
                dres3.insertBack("maroon,");
                dres3.insertBack("hitam,");
                dres3.insertBack("sage");

                dres3.deleteMiddle("sage");

                System.out.println(" ");
                System.out.println("Stok payet koin yang tersedia: ");
                dress.printList();
                System.out.println("\n--------------------------------------------------------------------------------------------------");

                // data stok payet pasir
                Dress dres4 = new Dress();
                dres4.insertFront("putih,");
                dres4.insertBack("maroon,");
                dres4.insertBack("hitam,");
                dres4.insertBack("sage");
        
                dres4.deleteMiddle("sage");
        
                System.out.println(" ");
                System.out.println("Stok payet pasir yang tersedia: ");
                dress.printList();
                 System.out.println("\n--------------------------------------------------------------------------------------------------");

                // data stok payet piringan
                Dress dres5 = new Dress();
                dres5.insertFront("putih,");
                dres5.insertBack("maroon,");
                dres5.insertBack("hitam,");
                dres5.insertBack("sage");
        
                dres5.deleteMiddle("sage");
        
                System.out.println(" ");
                System.out.println("Stok payet piringan yang tersedia: ");
                dress.printList();
                 System.out.println("\n--------------------------------------------------------------------------------------------------");

        // stok benang
                Dress dress2 = new Dress();
                dress2.insertFront("merah,");
                dress2.insertFront("kuning,");
                dress2.insertFront("hitam,");
                dress2.insertFront("sage,");
                dress2.insertFront("tera kota,");
                dress2.insertFront("gold,");
                dress2.insertFront("abu abu,");
                dress2.insertFront("putih,");
                dress2.insertFront("silver,");
                System.out.println(" ");
                System.out.println("Stok benang yang tersedia: ");
                dress2.printList();
                dress2.deleteMiddle("Putih");
                 System.out.println("\n--------------------------------------------------------------------------------------------------");


                break;
            case 3:

             // Program data pegawai
             Queue<String> s = new LinkedList<>();
             s.add("Ana");
             s.add("puspa");
             s.add("ayu");
             s.add("uswa");
             s.add("Tania");
             s.add("ivana");
             // s.remove();
             // s.clear();
             System.out.println("\n^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
             System.out.println("Pegawai yang bekerja pada Abidah Dress Maker antara lain: \n" + s);
             System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n");
             
             Stack<String> st = new Stack<String>();
             st.push("Ana");
             st.push("puspa");
             st.push("ayu");
             st.push("uswa");
             st.push("Tania");
             st.push("ivana");
             
             
                
                        break;
            case 4:

                // Program deadline pesanan
                LocalDate[] deadlinePesanan = { 
                    LocalDate.of(2023, 6, 10), 
                    LocalDate.of(2023, 6, 7),
                    LocalDate.of(2023, 6, 12),
                    LocalDate.of(2023, 6, 8) };

                    
                // Menemukan indeks deadline pesanan paling dekat
                int DeadlineTerdekat = 0;
                for (int i = 1; i < deadlinePesanan.length; i++) {
                    
                    if (deadlinePesanan[i].isBefore(deadlinePesanan[DeadlineTerdekat])) {
                        DeadlineTerdekat = i;
                        
                    }
                }
                

                // Menampilkan nama pesanan dengan deadline paling dekat
                String[] namaPesanan = { 
                    "Kebaya Maroon", 
                    "Kebaya hitam", 
                    "Gown coklat", 
                    "Slim Gown biru" };
                String pesananTerdekat = namaPesanan[DeadlineTerdekat];

                // Menampilkan deadline pesanan paling dekat
                LocalDate deadlineTerdekat = deadlinePesanan[DeadlineTerdekat];
                System.out.println("\n^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                System.out.println("Pesanan dengan deadline paling dekat adalah: " + pesananTerdekat + ", pada tanggal " + deadlineTerdekat);
                System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                
                System.out.println("\n========================================== Daftar Pesanan ==========================================");
                

                for (int i = 0; i < namaPesanan.length; i++) {
                    System.out.println(namaPesanan[i] + " ..................................... " + deadlinePesanan[i]);
                }
                break;

                    default:
                        System.out.println("Menu tidak valid.");
                }

        scanner.close();
    }
}
