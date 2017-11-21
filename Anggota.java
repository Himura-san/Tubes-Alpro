import java.io.*;

class Anggota {
	InputStreamReader isr = new InputStreamReader(System.in);
	BufferedReader input = new BufferedReader(isr);

	int index_a = -1, ukuran;

//============================================  Anggota  =================================================
	String npm,nama,kelas,jurusan,jk,tgl_lahir,no_hp;

	String NomorA[], Nama[], Kelas[], Jurusan[], JenisKelamin[], TanggalLahir[], NoHP[];

	void Anggota(){
		try	{
			String ulang;
			int value = 0;
			boolean cek = false;
			do {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
				System.out.println("\n Input Data Anggota ");
				System.out.println("=============================");
				
				do {
					System.out.print(" NPM           = ");
					this.npm = input.readLine();

					int i = 0;
					value = 0;
					while( i <= index_a){
						if ( NomorA[i].equals(this.npm) ) {
							System.out.print("\n Kode Anggota tidak Bisa Duplikat..!! ");
							input.readLine();

							value++;
							cek = true;
							Clear();Clear();Clear();
						}
						else if ( value == 0) {
							cek = false;
						}
						i++;
					}
				}while( cek == true || "".equals(this.npm));

				System.out.print(" Nama          = ");
				this.nama = input.readLine();

				System.out.print(" Kelas         = ");
				this.kelas = input.readLine();

				System.out.print(" Jurusan       = ");
				this.jurusan = input.readLine();

				System.out.print(" Jenis Kelamin = ");
				this.jk = input.readLine();

				System.out.print(" Tanggal Lahir = ");
				this.tgl_lahir = input.readLine();

				System.out.print(" Nomor HP      = ");
				this.no_hp = input.readLine();

				Tambah_Anggota(this.npm, this.nama, this.kelas, this.jurusan, this.jk, this.tgl_lahir, this.no_hp);
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

	void Tambah_Anggota(String npm, String nama, String kelas, String jurusan, String jk, String tgl_lahir, String no_hp){
		index_a = index_a + 1;
		NomorA[index_a] = npm;
		Nama[index_a] = nama;
		Kelas[index_a] = kelas;
		Jurusan[index_a] = jurusan;
		JenisKelamin[index_a] = jk;
		TanggalLahir[index_a] = tgl_lahir;
		NoHP[index_a] = no_hp;
	}

	void View_Anggota(){
		int i = 0;
		System.out.println("\n Data Anggota");
		System.out.println("=================================");
		if ( index_a >= 0 ) {
			while ( i <= index_a ){
				System.out.println(" NPM           = " + NomorA[i]);
				System.out.println(" Nama          = " + Nama[i]);
				System.out.println(" Kelas         = " + Kelas[i]);
				System.out.println(" Jurusan       = " + Jurusan[i]);
				System.out.println(" Jenis Kelamin = " + JenisKelamin[i]);
				System.out.println(" Tanggal Lahir = " + TanggalLahir[i]);
				System.out.println(" Nomor HP      = " + NoHP[i]);
				System.out.println("---------------------------------");
				i++;
			}
		}
		else {
			System.out.println("\n Data tidak ada.. ");
		}

	}

	void Search_Anggota(){
		if ( index_a >= 0 ){
			try {
				int i = 0, value = 0;
				String search;

				System.out.println("\n Search Anggota");
				System.out.println("=================================");

				System.out.print(" Masukkan NPM : ");
				search = input.readLine();

				System.out.println("---------------------------------");
				while( i <= index_a ){
					if ( NomorA[i].equals(search) ) {
						System.out.println(" NPM           = " + NomorA[i]);
						System.out.println(" Nama          = " + Nama[i]);
						System.out.println(" Kelas         = " + Kelas[i]);
						System.out.println(" Jurusan       = " + Jurusan[i]);
						System.out.println(" Jenis Kelamin = " + JenisKelamin[i]);
						System.out.println(" Tanggal Lahir = " + TanggalLahir[i]);
						System.out.println(" Nomor HP      = " + NoHP[i]);
						System.out.println("---------------------------------");
						value++;
					}
					i++;
				}
				if ( value == 0){
					System.out.println("\n Maaf anggota yang anda cari tidak ada.. *Tekan Enter");
				}
			}catch(Exception e){
				System.out.println(e);
			}
		}
		else {
			System.out.println("\n Data tidak ada.. ");
		}
	}

	void Edit_Anggota(){
		if ( index_a >= 0 ){
			try {
				int i = 0, value = 0;
				String search;

				System.out.println("\n Edit Anggota");
				System.out.println("=================================");

				System.out.print(" Masukkan NPM : ");
				search = input.readLine();

				System.out.println("---------------------------------");

				while( i <= index_a ){
					if ( NomorA[i].equals(search) ) {
						System.out.println(" NPM           = " + NomorA[i]);

						System.out.print(" Nama          = ");
						Nama[i] = input.readLine();

						System.out.print(" Kelas         = " );
						Kelas[i] = input.readLine();

						System.out.print(" Jurusan       = ");
						Jurusan[i] = input.readLine();

						System.out.print(" Jenis Kelamin = ");
						JenisKelamin[i] = input.readLine();

						System.out.print(" Tanggal Lahir = ");
						TanggalLahir[i] = input.readLine();

						System.out.print(" Nomor HP      = ");
						NoHP[i] = input.readLine();

						System.out.println("---------------------------------");
						value++;
					}
					i++;
				}
				
				if ( value == 0 ){
					System.out.println("\n Maaf anggota yang anda cari tidak ada.. *Tekan Enter");
				}
			}catch(Exception e){
				System.out.println(e);
			}
		}
		else {
			System.out.println("\n Data tidak ada.. ");
		}
	}

	void Delete_Anggota(){
		if ( index_a >= 0 ){
			try {
				int i = 0, value = 0;
				String search;

				System.out.println("\n Delete Anggota");
				System.out.println("=================================");

				System.out.print(" Masukkan NPM : ");
				search = input.readLine();

				while( i <= index_a ){
					if ( NomorA[i].equals(search) ) {
						for ( int j = i; j <= index_a ; j++ ) {
							NomorA[j] = NomorA[j+1];
							Nama[j] = Nama[j+1];
							Kelas[j] = Kelas[j+1];
							Jurusan[j] = Jurusan[j+1];
							JenisKelamin[j] = JenisKelamin[j+1];
							TanggalLahir[j] = TanggalLahir[j+1];
							NoHP[j] = NoHP[j+1];
						}
						System.out.println("\n Anggota berhasil di Delete.. ");
						value++;
						index_a--;
					}
					i++;
				}
				if ( value == 0){
					System.out.println("\n Maaf anggota yang anda ingin delete tidak ada.. *Tekan Enter");
				}

			}catch(Exception e){
				System.out.println(e);
			}
		}
		else {
			System.out.println("\n Data tidak ada..");
		}
	}

	void Print_Anggota(){
		if ( index_a >= 0 ) {
			try {
			    PrintWriter pr = new PrintWriter("Data Anggota.txt");

			    pr.println(" Data Anggota");
			    pr.println("=================================");
			    for (int i = 0; i <= index_a ; i++){
			        pr.println(" NPM           = " + NomorA[i]);
					pr.println(" Nama          = " + Nama[i]);
					pr.println(" Kelas         = " + Kelas[i]);
					pr.println(" Jurusan       = " + Jurusan[i]);
					pr.println(" Jenis Kelamin = " + JenisKelamin[i]);
					pr.println(" Tanggal Lahir = " + TanggalLahir[i]);
					pr.println(" Nomor HP      = " + NoHP[i]);
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
//============================================   Other   =================================================
	void Tumpukan(int size){
		ukuran = size;
		//========== Anggota ==========
		NomorA = new String[ukuran];
		Nama = new String[ukuran];
		Kelas = new String[ukuran];
		Jurusan = new String[ukuran];
		JenisKelamin = new String[ukuran];
		TanggalLahir = new String[ukuran];
		NoHP = new String[ukuran];
	}

	void Clear(){
		System.out.print(String.format("\033[%dA",0));
		System.out.print("\033[2K");
	}
}