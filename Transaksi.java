import java.io.*;
import java.text.NumberFormat;

class Transaksi {
	InputStreamReader isr = new InputStreamReader(System.in);
	BufferedReader input = new BufferedReader(isr);
	NumberFormat nf = NumberFormat.getInstance();
	
	Buku data_buku = new Buku();
	Anggota data_anggota = new Anggota();
	
	int index_t = -1, ukuran;
//============================================ Transaksi =================================================
	String no_trans, npmt, kd_bukut, status;
	int tgl_pinjam, tgl_haruskembali, tgl_dikembalikan, lama_pinjam, denda;

	String NoTrans[], NomorT[], KodeBukuT[],  Status[];
	int TglPinjam[], TglHarusKembali[], TglDikembalikan[], LamaPinjam[], Denda[];

	void Transaksi(){
		if ( data_anggota.index_a >= 0 && data_buku.index_b >= 0) {
			System.out.println(data_anggota.index_a);
			try	{
				String ulang;
				int value = 0;
				do {
					boolean cek = false;
					new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
					System.out.println("\n Input Data Transaksi ");
					System.out.println("=============================");
					//===========================================
					do {
						System.out.print(" Nomor Transaksi       = ");
						this.no_trans = input.readLine().toUpperCase();

						int i = 0;
						value = 0;
						while( i <= index_t){
							if ( NoTrans[i].equals(this.no_trans)) {
								System.out.print("\n Nomor Transaksi tidak Bisa Duplikat..!! ");
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
					}while( cek == true || "".equals(this.no_trans) );
					//===========================================
					do {
						System.out.print(" NPM                   = ");
						this.npmt = input.readLine();

						int i = 0;
						value = 0;
						while( i <= data_anggota.index_a ){
							if (data_anggota.NomorA[i].equals(this.npmt)) {
								System.out.println(" Nama                  = " + data_anggota.Nama[i]);

								value++;
								cek = true;
							}
							i++;
						}
						if ( value == 0 || this.npmt == "" ){
							System.out.print("\n Maaf anggota yang anda cari tidak ada.. *Tekan Enter");
							input.readLine();

							cek = false;
							Clear();Clear();Clear();
						}
					}while( cek == false || "".equals(this.npmt));
					//===========================================
					do {
						System.out.print(" Kode Buku             = ");
						this.kd_bukut = input.readLine().toUpperCase();

						int i = 0;
						value = 0;
						while( i <= data_buku.index_b){
							if (data_buku.KodeBuku[i].equals(this.kd_bukut)) {
								System.out.println(" Judul Buku            = " + data_buku.JudulBuku[i]);

								value++;
								cek = true;
							}
							i++;
						}
						if ( value == 0 || this.npmt == "" ){
							System.out.print("\n Maaf buku yang anda cari tidak ada.. *Tekan Enter");
							input.readLine();

							cek = false;
							Clear();Clear();Clear();
						}
					}while( cek == false || "".equals(this.kd_bukut));
					//===========================================
					do {
						System.out.print(" Tanggal Pinjam        = ");
						this.tgl_pinjam = Integer.parseInt(input.readLine());

						if ( this.tgl_pinjam > 31 || this.tgl_pinjam <= 0) {
							System.out.print("\n Tanggal harus [1 - 31]..!! ");
							input.readLine();

							Clear();Clear();Clear();
						}
					}while( this.tgl_pinjam > 31 || this.tgl_pinjam <= 0 );
					//===========================================
					do {
						System.out.print(" Tanggal Harus Kembali = ");;
						this.tgl_haruskembali = Integer.parseInt(input.readLine());

						if ( this.tgl_haruskembali > 31 || this.tgl_haruskembali <= 0 ) {
							System.out.print("\n Tanggal harus [1 - 31]..!! ");
							input.readLine();

							Clear();Clear();Clear();
						}

						else if ( this.tgl_haruskembali < this.tgl_pinjam ) {
							System.out.print("\n Tanggal Kembali harus lebih dari Tanggal Pinjam.. ");
							input.readLine();

							Clear();Clear();Clear();
						}
					}while( this.tgl_haruskembali < this.tgl_pinjam || this.tgl_haruskembali > 31 || this.tgl_haruskembali <= 0 );
					//===========================================
					do {
						System.out.print(" Tanggal Dikembalikan  = ");
						this.tgl_dikembalikan = Integer.parseInt(input.readLine());

						if ( this.tgl_dikembalikan > 31 || this.tgl_dikembalikan <= 0 ) {
							System.out.print("\n Tanggal harus [1 - 31]..!! ");
							input.readLine();

							Clear();Clear();Clear();
						}
						if ( this.tgl_dikembalikan < this.tgl_pinjam ) {
							System.out.println("\n Tanggal Dikembalikan harus lebih dari Tanggal Pinjam.. ");

							Clear();Clear();Clear();
						}
					}while( this.tgl_dikembalikan < this.tgl_pinjam || this.tgl_dikembalikan > 31 || this.tgl_dikembalikan <= 0 );
					//===========================================
					this.lama_pinjam = this.tgl_dikembalikan - this.tgl_pinjam;
					System.out.println(" Lama Pinjam           = " + this.lama_pinjam);
					//===========================================
					if ( this.tgl_dikembalikan > this.tgl_haruskembali ) {
						this.denda = (this.tgl_dikembalikan - this.tgl_haruskembali) * 1000;
					}
					else {
						this.denda = 0;
					}
					System.out.println(" Denda                 = " + nf.format(this.denda));
					//===========================================
					System.out.print(" Status                = ");
					this.status = input.readLine();

					Tambah_Transaksi(this.no_trans, this.npmt, this.kd_bukut, this.tgl_pinjam, this.tgl_haruskembali, this.tgl_dikembalikan, this.status, this.lama_pinjam, this.denda);
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
		else {
			if ( data_anggota.index_a < 0 ) {
				System.out.println("\n Data Anggota tidak ada..!! ");
			}
			else if ( data_buku.index_b < 0 ) {
				System.out.println("\n Data Buku tidak ada..!! ");
			}
		}
	}

	void Tambah_Transaksi(String no_trans, String npmt, String kd_bukut, int tgl_pinjam, int tgl_haruskembali, int tgl_dikembalikan, String status, int lama_pinjam, int denda){
		index_t = index_t + 1;
		NoTrans[index_t] = no_trans;
		NomorT[index_t] = npmt;
		KodeBukuT[index_t] = kd_bukut;
		TglPinjam[index_t] = tgl_pinjam;
		TglHarusKembali[index_t] = tgl_haruskembali;
		TglDikembalikan[index_t] = tgl_dikembalikan;
		Status[index_t] = status;
		LamaPinjam[index_t] = lama_pinjam;
		Denda[index_t] = denda;
	}

	void View_Transaksi(){
		int i = 0, a = 0, b = 0;;
		System.out.println("\n Data Transaksi");
		System.out.println("=================================");

		if ( index_t < 0 ) {
			System.out.println(" Data tidak ada.. ");
		}
		else {
			while ( i <= index_t ){

				System.out.println(" Nomor Transaksi       = " + NoTrans[i]);
				System.out.println(" NPM                   = " + NomorT[i]);
				while( a <= data_anggota.index_a ){
					if (data_anggota.NomorA[a].equals(NomorT[i])) {
						System.out.println(" Nama                  = " + data_anggota.Nama[a]);
						break;
					}
					a++;
				}
				System.out.println(" Kode Buku             = " + KodeBukuT[i]);
				while( b <= data_buku.index_b ){
					if (data_buku.KodeBuku[b].equals(KodeBukuT[i])) {
						System.out.println(" Judul Buku            = " + data_buku.JudulBuku[b]);
						break;
					}
					b++;
				}
				System.out.println(" Tanggal Pinjam        = " + TglPinjam[i]);
				System.out.println(" Tanggal Harus Kembali = " + TglHarusKembali[i]);
				System.out.println(" Tanggal Dikembalikan  = " + TglDikembalikan[i]);
				System.out.println(" Lama Pinjam           = " + LamaPinjam[i]);
				System.out.println(" Denda                 = " + nf.format(Denda[i]));
				System.out.println(" Status                = " + Status[i]);
				System.out.println("---------------------------------");
				i++;
			}
		}
	}

	void Search_Transaksi(){
		if ( index_t >= 0 ) {
			try {
				int i = 0, value = 0, a = 0, b = 0;
				String search;

				System.out.println("\n Search Transaksi");
				System.out.println("=================================");

				System.out.print(" Masukkan NPM : ");
				search = input.readLine().toUpperCase();

				System.out.println("---------------------------------");
				while( i <= index_t ){
					if ( NomorT[i].equals(search) ) {
						System.out.println(" Nomor Transaksi       = " + NoTrans[i]);
						System.out.println(" NPM                   = " + NomorT[i]);
						while( a <= data_anggota.index_a ){
							if (data_anggota.NomorA[a].equals(NomorT[i])) {
								System.out.println(" Nama                  = " + data_anggota.Nama[a]);
								break;
							}
							a++;
						}
						System.out.println(" Kode Buku             = " + KodeBukuT[i]);
						while( b <= data_buku.index_b ){
							if (data_buku.KodeBuku[b].equals(KodeBukuT[i])) {
								System.out.println(" Judul Buku            = " + data_buku.JudulBuku[b]);
								break;
							}
							b++;
						}
						System.out.println(" Tanggal Pinjam        = " + TglPinjam[i]);
						System.out.println(" Tanggal Harus Kembali = " + TglHarusKembali[i]);
						System.out.println(" Tanggal Dikembalikan  = " + TglDikembalikan[i]);
						System.out.println(" Lama Pinjam           = " + LamaPinjam[i]);
						System.out.println(" Denda                 = " + nf.format(Denda[i]));
						System.out.println(" Status                = " + Status[i]);
						System.out.println("---------------------------------");
						value++;
					}
					i++;
				}
				if ( value == 0){
					System.out.println("\n Maaf Transaksi yang anda cari tidak ada.. *Tekan Enter");
				}
			}catch(Exception e){
				System.out.println(e);
			}
		}
		else {
			System.out.println("\n Data tidak ada.. ");
		}
	}

	void Delete_Transaksi(){
		if ( index_t >= 0 ) {
			try {
				int i = 0, value = 0;
				String search;

				System.out.println("\n Delete Transaksi");
				System.out.println("=================================");

				System.out.print(" Masukkan Nomor Transaksi : ");
				search = input.readLine().toUpperCase();

				while( i <= index_t ){
					if ( NoTrans[i].equals(search) ) {
						for ( int j = i; j <= index_t; j++ ) {
							NoTrans[j] = NoTrans[j+1];
							NomorT[j] = NomorT[j+1];
							KodeBukuT[j] = KodeBukuT[j+1];
							TglPinjam[j] = TglPinjam[j+1];
							TglHarusKembali[j] = TglHarusKembali[j+1];
							TglDikembalikan[j] = TglDikembalikan[j+1];
							LamaPinjam[j] = LamaPinjam[j+1];
							Denda[j] = Denda[j+1];
							Status[j] = Status[j+1];
						}
						System.out.println("\n Transaksi berhasil di Delete.. *Tekan Enter");
						value++;
						index_t--;
					}
					i++;
				}
				if ( value == 0){
					System.out.println("\n Maaf Transaksi yang anda ingin delete tidak ada.. *Tekan Enter");
				}

			}catch(Exception e){
				System.out.println(e);
			}
		}
		else {
			System.out.println("\n Data tidak ada.. ");
		}
	}

	void Print_Transaksi(){
		if ( index_t >= 0 ) {
			try {
				int a = 0, b = 0;
			    PrintWriter pr = new PrintWriter("Data Transaksi.txt");    

			    pr.println("\n Data Transaksi");
			    pr.println("=================================");
			    for (int i = 0; i <= index_t ; i++){
			        pr.println(" Nomor Transaksi       = " + NoTrans[i]);
					pr.println(" NPM                   = " + NomorT[i]);
					while( a <= data_anggota.index_a ){
						if (data_anggota.NomorA[a].equals(NomorT[i])) {
							pr.println(" Nama                  = " + data_anggota.Nama[a]);
							break;
						}
						a++;
					}
					pr.println(" Kode Buku             = " + KodeBukuT[i]);
					while( b <= data_buku.index_b ){
						if (data_buku.KodeBuku[b].equals(KodeBukuT[i])) {
							pr.println(" Judul Buku            = " + data_buku.JudulBuku[b]);
							break;
						}
						b++;
					}
					pr.println(" Tanggal Pinjam        = " + TglPinjam[i]);
					pr.println(" Tanggal Harus Kembali = " + TglHarusKembali[i]);
					pr.println(" Tanggal Dikembalikan  = " + TglDikembalikan[i]);
					pr.println(" Lama Pinjam           = " + LamaPinjam[i]);
					pr.println(" Denda                 = " + nf.format(Denda[i]));
					pr.println(" Status                = " + Status[i]);
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
		//========= Transaksi =========
		NoTrans = new String[ukuran];
		NomorT = new String[ukuran];
		KodeBukuT = new String[ukuran];
		TglPinjam = new int[ukuran];
		TglHarusKembali = new int[ukuran];
		TglDikembalikan = new int[ukuran];
		Status = new String[ukuran];
		LamaPinjam = new int[ukuran];
		Denda = new int[ukuran];
	}

	void Clear(){
		System.out.print(String.format("\033[%dA",0));
		System.out.print("\033[2K");
	}
}
