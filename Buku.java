import java.io.*;

class Buku {
	InputStreamReader isr = new InputStreamReader(System.in);
	BufferedReader input = new BufferedReader(isr);

	int index_b = -1, ukuran;

//============================================   Buku    =================================================
	String kd_buku,judul_buku,pengarang,penerbit,jenis_buku;
	int thn_terbit;

	String KodeBuku[], JudulBuku[], Pengarang[], Penerbit[], JenisBuku[];
	int TahunTerbit[];

	void Buku(){
		try	{
			String ulang;
			int value;
			boolean cek = false;
			do {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
				System.out.println("\n Input Data Buku ");
				System.out.println("=============================");

				do {
					System.out.print(" Kode Buku    = ");
					this.kd_buku = input.readLine().toUpperCase();

					value = 0;
					for ( int i = 0; i <= index_b; i++ ) {
						if ( KodeBuku[i].equals(this.kd_buku) ) {
							System.out.print("\n Kode Buku tidak Bisa Duplikat..!! *Tekan Enter");
							input.readLine();

							value++;
							cek = true;
							Clear();Clear();Clear();
						}

						else if ( value == 0 ){
							cek = false;
						}
					}
				}while( cek == true || "".equals(this.kd_buku));

				System.out.print(" Judul Buku   = ");
				this.judul_buku = input.readLine();

				System.out.print(" Pengarang    = ");
				this.pengarang = input.readLine();

				System.out.print(" Penerbit     = ");
				this.penerbit = input.readLine();

				System.out.print(" Jenis Buku   = ");
				this.jenis_buku = input.readLine();

				do {
					System.out.print(" Tahun Terbit = ");
					this.thn_terbit = Integer.parseInt(input.readLine());

					if (this.thn_terbit > 2050 || this.thn_terbit < 1500 || "".equals(this.thn_terbit)) {
						System.out.print("\n Tahun Terbit harus [ 1501 - 2049 ]..!! *Tekan Enter");
						input.readLine();

						Clear();Clear();Clear();
					}
				}while(this.thn_terbit > 2050 || this.thn_terbit < 1500 || "".equals(this.thn_terbit));

				Tambah_Buku(this.kd_buku, this.judul_buku, this.pengarang, this.penerbit, this.jenis_buku, this.thn_terbit);
				System.out.println("=============================");

				System.out.print("\n Apakah anda ingin menambah lagi..? [ Y / T ] : ");
				ulang = input.readLine().toUpperCase();

			}while("".equals(ulang) || "IYA".equals(ulang) || "YA".equals(ulang) || "Y".equals(ulang));

			Clear();Clear();
		} 
		catch(Exception e){
			System.out.println(e);
		}
	}

	void Tambah_Buku(String kd_buku, String judul_buku, String pengarang, String penerbit, String jenis_buku, int thn_terbit){
		index_b = index_b + 1;
		KodeBuku[index_b] = kd_buku;
		JudulBuku[index_b] = judul_buku;
		Pengarang[index_b] = pengarang;
		Penerbit[index_b] = penerbit;
		JenisBuku[index_b] = jenis_buku;
		TahunTerbit[index_b] = thn_terbit;
	}

	void View_Buku(){
		System.out.println("\n Data Buku");
		System.out.println("=================================");

		if ( index_b < 0) {
			System.out.println("\n Data tidak ada.. ");
		}
		else {
			for ( int i = 0; i <= index_b; i++ ) {
				System.out.println(" Kode Buku    = " + KodeBuku[i]);
				System.out.println(" Judul Buku   = " + JudulBuku[i]);
				System.out.println(" Pengarang    = " + Pengarang[i]);
				System.out.println(" Penerbit     = " + Penerbit[i]);
				System.out.println(" Jenis Buku   = " + JenisBuku[i]);
				System.out.println(" Tahun Terbit = " + TahunTerbit[i]);
				System.out.println("---------------------------------");
			}
		}
	}

	void Search_Buku(){
		if( index_b >= 0 ){
			try {
				int value = 0;
				String search;

				System.out.println("\n Search Buku");
				System.out.println("=================================");

				System.out.print(" Masukkan Kode Buku : ");
				search = input.readLine().toUpperCase();;

				System.out.println("---------------------------------");
				for ( int i = 0; i <= index_b; i++ ) {
					if ( KodeBuku[i].equals(search) ) {
						System.out.println(" Kode Buku    = " + KodeBuku[i]);
						System.out.println(" Judul Buku   = " + JudulBuku[i]);
						System.out.println(" Pengarang    = " + Pengarang[i]);
						System.out.println(" Penerbit     = " + Penerbit[i]);
						System.out.println(" Jenis Buku   = " + JenisBuku[i]);
						System.out.println(" Tahun Terbit = " + TahunTerbit[i]);
						System.out.println("---------------------------------");
						value++;
					}
				}

				if ( value == 0){
					System.out.println("\n Maaf buku yang anda cari tidak ada.. *Tekan Enter");
				}
			}catch(Exception e){
				System.out.println(e);
			}
		}
		else {
			System.out.println("\n Data tidak ada..");
		}
	}

	void Edit_Buku(){
		if ( index_b >= 0 ) {
			try {
				int value = 0;
				String search;

				System.out.println("\n Edit Buku");
				System.out.println("=================================");

				System.out.print(" Masukkan Kode Buku : ");
				search = input.readLine().toUpperCase();

				System.out.println("---------------------------------");
				for ( int i = 0; i <= index_b; i++ ) {
					if ( KodeBuku[i].equals(search) ) {
						System.out.println(" Kode Buku    = " + KodeBuku[i]);

						System.out.print(" Judul Buku   = ");
						JudulBuku[i] = input.readLine();

						System.out.print(" Pengarang    = ");
						Pengarang[i] = input.readLine();

						System.out.print(" Penerbit     = ");
						Penerbit[i] = input.readLine();

						System.out.print(" Jenis Buku   = ");
						JenisBuku[i] = input.readLine();
						
						do {
							System.out.print(" Tahun Terbit = ");
							TahunTerbit[i] = Integer.parseInt(input.readLine());

							if (TahunTerbit[i] > 2050 || TahunTerbit[i] < 1500 || "".equals(TahunTerbit[i])) {
								System.out.print("\n Tahun Terbit harus [ 1501 - 2049 ]..!! *Tekan Enter");
								input.readLine();

								Clear();Clear();Clear();
							}
						}while(TahunTerbit[i] > 2050 || TahunTerbit[i] < 1500 || "".equals(TahunTerbit[i]));

						System.out.println("---------------------------------");
						value++;
					}
				}
				if ( value == 0){
					System.out.println("\n Maaf buku yang anda cari tidak ada.. *Tekan Enter");
				}
			}catch(Exception e){
				System.out.println(e);
			}
		}
		else {
			System.out.println("\n Data tidak ada..");
		}
	}

	void Delete_Buku(){
		if ( index_b >= 0 ){
			try {
				int i = 0, value = 0, del = 0;
				String search;

				System.out.println("\n Delete Buku");
				System.out.println("=================================");

				System.out.print(" Masukkan Kode Buku : ");
				search = input.readLine().toUpperCase();

				while( i <= index_b ){
					if( KodeBuku[i].equals(search) ) {
						for ( int j = i; j <= index_b ; j++ ) {
							KodeBuku[j] = KodeBuku[j+1];
							JudulBuku[j] = JudulBuku[j+1];
							Pengarang[j] = Pengarang[j+1];
							Penerbit[j] = Penerbit[j+1];
							JenisBuku[j] = JenisBuku[j+1];
							TahunTerbit[j] = TahunTerbit[j+1];
						}
						System.out.println("\n Buku berhasil di Delete.. ");
						value++;
						index_b--;
					}
					i++;
				}
				if ( value == 0){
					System.out.println("\n Maaf buku yang anda delete tidak ada.. *Tekan Enter");
				}

			}catch(Exception e){
				System.out.println(e);
			}
		}
		else {
			System.out.println("\n Data tidak ada..");
		}
	}

	void Print_Buku(){
		if ( index_b >= 0 ) {
			try {
			    PrintWriter pr = new PrintWriter("Data Buku.txt");    

			    pr.println("\n Data Buku");
			    pr.println("=================================");
			    for (int i = 0; i <= index_b ; i++){
			        pr.println(" Kode Buku    = " + KodeBuku[i]);
					pr.println(" Judul Buku   = " + JudulBuku[i]);
					pr.println(" Pengarang    = " + Pengarang[i]);
					pr.println(" Penerbit     = " + Penerbit[i]);
					pr.println(" Jenis Buku   = " + JenisBuku[i]);
					pr.println(" Tahun Terbit = " + TahunTerbit[i]);
					pr.println("---------------------------------");
			    }
			    pr.close();

			    System.out.println("\n Data sudah ter-print.. ");

			}catch (Exception e){
			    e.printStackTrace();
			    System.out.println(" No such file exists..");
			}
		}
		else {
			System.out.println("\n Data tidak ada.. ");
		}
	}
//========================================================================================================
	void Tumpukan(int size){
		ukuran = size;
		//=========== Buku ============
		KodeBuku = new String[ukuran];
		JudulBuku = new String[ukuran];
		Pengarang = new String[ukuran];
		Penerbit = new String[ukuran];
		JenisBuku = new String[ukuran];
		TahunTerbit = new int[ukuran];
	}

	void Clear(){
		System.out.print(String.format("\033[%dA",0));
		System.out.print("\033[2K");
	}
}