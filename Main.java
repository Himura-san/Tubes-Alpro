import java.io.*;

class Main {
//============================================   Main    =================================================
	public static void main(String[] args) throws IOException, InterruptedException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader input = new BufferedReader(isr);

		Buku data_buku = new Buku();
		Anggota data_anggota = new Anggota();
		Transaksi data_transaksi = new Transaksi();

		data_buku.Tumpukan(100);
		data_anggota.Tumpukan(100);
		data_transaksi.Tumpukan(100);

		String ulang;
		try {
			do {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
				System.out.println("\n Perpustakaan Cahaya Ilahi ");
				System.out.println("=================================");
				System.out.println(" 1. Buku");
				System.out.println(" 2. Anggota");
				System.out.println(" 3. Transaksi");
				System.out.println(" 0. Exit");
				System.out.println("=================================");
				System.out.print(" Masukkan pilihan [ 0 - 3 ] : ");
				String pil = input.readLine();

				//================================= Menu =====================================
				switch(pil){
					case "0":
						System.exit(1);
						break;

					case "1":
					//============================== Menu Buku ===================================
						new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
						System.out.println("\n Menu Buku");
						System.out.println("=================================");
						System.out.println(" 1. Tambah Buku");
						System.out.println(" 2. Lihat Buku");
						System.out.println(" 3. Edit Buku");
						System.out.println(" 4. Search Buku");
						System.out.println(" 5. Delete Buku");
						System.out.println(" 6. Print Buku");
						System.out.println(" 0. Back");
						System.out.println("=================================");
						System.out.print(" Masukkan pilihan [ 0 - 6 ] : ");
						String pil2 = input.readLine();

						switch (pil2) {
							case "0":
								
								break;

							case "1":
								data_buku.Buku();
								break;

							case "2":
								data_buku.View_Buku();
								break;

							case "3":
								data_buku.Edit_Buku();
								break;

							case "4":
								data_buku.Search_Buku();
								break;

							case "5":
								data_buku.Delete_Buku();
								break;

							case "6":
								data_buku.Print_Buku();
								break;

							default:
								System.out.println("\n Masukkan Pilihan dari [0 - 6]... ");
								break;
						}
						break;

					case "2":
					//============================= Menu Anggota =================================
						new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
						System.out.println("\n Menu Anggota");
						System.out.println("=================================");
						System.out.println(" 1. Tambah Anggota");
						System.out.println(" 2. Lihat Anggota");
						System.out.println(" 3. Edit Anggota");
						System.out.println(" 4. Search Anggota");
						System.out.println(" 5. Delete Anggota");
						System.out.println(" 6. Print Anggota");
						System.out.println(" 0. Back");
						System.out.println("=================================");
						System.out.print(" Masukkan pilihan [ 0 - 6 ] : ");
						String pil3 = input.readLine();

						switch (pil3) {
							case "0":

								break;

							case "1":
								data_anggota.Anggota();
								break;

							case "2":
								data_anggota.View_Anggota();
								break;

							case "3":
								data_anggota.Edit_Anggota();
								break;

							case "4":
								data_anggota.Search_Anggota();
								break;

							case "5":
								data_anggota.Delete_Anggota();
								break;

							case "6":
								data_anggota.Print_Anggota();
								break;

							default:
								System.out.println("\n Masukkan Pilihan dari [0 - 6]... ");
								break;
						}
						break;

					case "3":
					//============================= Menu Transaksi ===============================
						new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
						System.out.println("\n Menu Transaksi");
						System.out.println("=================================");
						System.out.println(" 1. Tambah Transaksi");
						System.out.println(" 2. Lihat Transaksi");
						System.out.println(" 3. Search Transaksi");
						System.out.println(" 4. Delete Transaksi");
						System.out.println(" 5. Print Transaksi");
						System.out.println(" 0. Back");
						System.out.println("=================================");
						System.out.print(" Masukkan pilihan [ 0 - 5 ] : ");
						String pil4 = input.readLine();

						switch (pil4) {
							case "0":

								break;

							case "1":
								data_transaksi.Transaksi();
								break;

							case "2":
								data_transaksi.View_Transaksi();
								break;

							case "3":
								data_transaksi.Search_Transaksi();
								break;

							case "4":
								data_transaksi.Delete_Transaksi();
								break;

							case "5":
								data_transaksi.Print_Transaksi();
								break;

							default:
								System.out.println("\n Masukkan Pilihan dari [0 - 5]... ");
								break;
						}
						break;

					default:
						System.out.println("\n Masukkan Pilihan dari [0 - 3]... ");
						break;
				}

				System.out.print("\n Apakah anda ingin kembali ke menu awal..? [ Y / T ] : ");
				ulang = input.readLine().toUpperCase();
			}while("".equals(ulang) || "IYA".equals(ulang) || "YA".equals(ulang) || "Y".equals(ulang));

		}catch(Exception e){
			System.out.println(e);
		}
	}
}