package Test;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Reports {

    private Customer[] arrCustomer;

    public Customer[] getArrCustomer() {
        return this.arrCustomer;
    }

    private int[][] arrUrunBilgisi;

    public int[][] getArrUrunBilgisi() {
        return this.arrUrunBilgisi;
    }

    private int customerCount;

    public int getCustomerCount() {
        return this.customerCount;
    }
    private int fileCustomerCount;

    public int fileCustomerCount() {
        return this.fileCustomerCount;
    }

    /**
     * Constructor metot. Dosyanın okunduğu, Raporların hazırlandığı nesnedir.
     * Nesne ilk oluşturulduğunda müşteriler için 200 elemanlı bir dizi
     * oluşturulur.
     */
    public Reports() {
        this.arrCustomer = new Customer[200];
    }

    /**
     * Constructor metot. Dosya yolunu belirterek otomatik olarak dosyanın
     * içindeki verileri okur ve ilgili dizilerin içeriğine aktarır. Müşteriler
     * için 200 elemanlı bir dizi oluiturulur ve dosya yolu belirtilerek ilgili
     * dizilerin içi otomatik olarak doldurulur.
     *
     * @param dosyaYolu Nesne oluşturulurken dosya yolunu belirtirsek otomatik
     * olarak dosyayı okur ve ilgili dizilerin içindeki verileri doldurur.
     */
    public Reports(String dosyaYolu) {
        this.arrCustomer = new Customer[200];

        dosyaOku(dosyaYolu);
    }

    /**
     * Belirtilen dosyanın içindeki verileri satır satır okur. Okuduğu bu
     * satırları diziDoldur() metoduna gönderir.
     *
     * @param dosyaYolu okunacak dosyanın yolu verilmelidir.
     */
    public void dosyaOku(String dosyaYolu) {

        FileReader fileReader = null;
        BufferedReader br = null;

        String line;
        int fileLineNumber = 0;

        try {
            fileReader = new FileReader(new File(dosyaYolu));
            br = new BufferedReader(fileReader);

            while ((line = br.readLine()) != null) {
                diziDoldur(line, fileLineNumber);
                fileLineNumber++;
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                fileReader.close();
                br.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }

    }

    /**
     * Metodun amacı: dosyanın içindeki verileri belirli formatta okur. Dosyadan
     * okunan bu verileri arrCustomer ve arrUrunBilgisi dizilerini doldurur.
     *
     * char n_i_Flag : ulusal(n) ve uluslararası(i) durumlarına göre değer alır.
     * int boyut : arrUrunBilgisi dizisinin kaç adet ürün değerini alacağını
     * gösteriyor. Dosyadaki ilk değer bize ürün sayısını veriyor.
     *
     * @param line Okunan dosyadaki bir satırlık veri alınır.
     * @param fileLineNumber Dosyadaki kaçıncı satırı okuduğunu bildiriyor.
     */
    private void diziDoldur(String line, int fileLineNumber) {

        StringTokenizer st = new StringTokenizer(line, ",");
        char n_i_Flag;//
        int boyut;
        int index = (fileLineNumber - 1) / 2;
        while (st.hasMoreTokens()) {
            if (fileLineNumber == 0) {
                boyut = Integer.parseInt(st.nextToken());
                arrUrunBilgisi = new int[200][boyut];
                break;
            } else if (fileLineNumber % 2 == 1) {
                n_i_Flag = st.nextToken().charAt(0);
                if (n_i_Flag == 'n') {
                    arrCustomer[index] = new NationalCustomer(
                            Integer.parseInt(st.nextToken()),
                            st.nextToken(),
                            st.nextToken(),
                            Integer.parseInt(st.nextToken()),
                            st.nextToken());
                } else if (n_i_Flag == 'i') {
                    arrCustomer[index] = new InternationalCustomer(
                            Integer.parseInt(st.nextToken()),
                            st.nextToken(),
                            st.nextToken(),
                            st.nextToken(),
                            st.nextToken());
                }
                customerCount++;
                //System.out.println(arrCustomer[index].toString());//test
                //System.out.println(getArrCustomer()[index].toString());//test
            } else if (fileLineNumber % 2 == 0) {
                for (int j = 0; j < arrUrunBilgisi[index].length; j++) {
                    arrUrunBilgisi[index][j] = Integer.parseInt(st.nextToken());
                    //System.out.print(getArrUrunBilgisi()[index][j]);//test
                }
                //System.out.println("");//test
            }
            this.fileCustomerCount = this.customerCount;
        }
    }

    /**
     * Tüm ürünlerin ortalama puanı hesaplanır.
     *
     * @return Ortalamalar hesaplandıktan sonra double[] tipinde
     * ortalamapuanları geri döndürür.
     */
    public double[] urunlerinOrtalamaPuani() {
        double[] ortalamaPuan = new double[arrUrunBilgisi[0].length];
        System.out.println("Ürünlerin ortalama puanları :");
        for (int j = 0; j < arrUrunBilgisi[0].length; j++) {
            for (int i = 0; i < 200; i++) {
                if (arrUrunBilgisi[i][j] != 0) {
                    ortalamaPuan[j] += arrUrunBilgisi[i][j];
                } else {
                    ortalamaPuan[j] = (double) ortalamaPuan[j] / (double) i;
                    //System.out.print(ortalamaPuan[j] + "\t");
                    break;
                }
            }
        }
        return ortalamaPuan;
    }
    
    public double[] urunlerinOrtalamaPuani(int baslangicIndex) {
        double[] ortalamaPuan = new double[arrUrunBilgisi[0].length];
        System.out.println("Ürünlerin ortalama puanları :");
        for (int j = 0; j < arrUrunBilgisi[0].length; j++) {
            for (int i = baslangicIndex; i < 200; i++) {
                if (arrUrunBilgisi[i][j] != 0) {
                    ortalamaPuan[j] += arrUrunBilgisi[i][j];
                } else {
                    ortalamaPuan[j] = (double) ortalamaPuan[j] / (double) i;
                    //System.out.print(ortalamaPuan[j] + "\t");
                    break;
                }
            }
        }
        return ortalamaPuan;
    }
    /**
     * Müşterilerin durumuna göre (ulusal ya da uluslararası) ürünlerin ortalama
     * puanını hesaplar.
     *
     * @param customer Ortalaması hesaplanacak müşterilerin tipi belirtiliyor.
     * NationalCustomer veya InternationalCustomer
     *
     * @return
     */
    public double[] urunlerinOrtalamaPuani(Customer customer) {
        double[] ortalamaPuan = new double[arrUrunBilgisi[0].length];
        int count;
        for (int j = 0; j < arrUrunBilgisi[0].length; j++) {
            count = 0;
            for (int i = 0; i < 200; i++) {
                if (arrUrunBilgisi[i][j] != 0) {
                    if ((customer instanceof NationalCustomer) && (arrCustomer[i] instanceof NationalCustomer)) {
                        ortalamaPuan[j] += arrUrunBilgisi[i][j];
                        count++;
                    } else if ((customer instanceof InternationalCustomer) && (arrCustomer[i] instanceof InternationalCustomer)) {
                        ortalamaPuan[j] += arrUrunBilgisi[i][j];
                        count++;
                    }
                } else {
                    ortalamaPuan[j] = (double) ortalamaPuan[j] / (double) count;
                    break;
                }
            }
        }
        return ortalamaPuan;
    }

    /**
     * Ulusal müşterilerden occupation parametresine göre ürünlerin ortalamsını
     * hesaplar.
     *
     * @param occupation Müşterilerin mesleğini belirtiyor.
     * @return double[] tipinde ürünlerin ortalamalarını geri döndürür.
     */
    public double[] urunlerinOrtalamaPuani(String occupation) {
        double[] ortalamaPuan = new double[arrUrunBilgisi[0].length];
        int count;
        for (int j = 0; j < arrUrunBilgisi[0].length; j++) {
            count = 0;
            for (int i = 0; i < 200; i++) {
                if (arrUrunBilgisi[i][j] != 0) {
                    if ((arrCustomer[i] instanceof NationalCustomer)) {
                        NationalCustomer customer = new NationalCustomer();
                        customer = (NationalCustomer) arrCustomer[i];
                        if (customer.getOccupation().equals(occupation)) {
                            ortalamaPuan[j] += arrUrunBilgisi[i][j];
                            count++;
                        }
                    }
                } else {
                    ortalamaPuan[j] = (double) ortalamaPuan[j] / (double) count;
                    break;
                }
            }
        }
        return ortalamaPuan;
    }

    /**
     * Ürünlerin ortalama derecelerine göre müşterilerin verdiği puanları
     * karşılaştırır. Eğer ortalamanın altında puan verilmişse bunu ekrana
     * yazdırır.
     *
     * @param customer Müşterilerin tipini belirtir (National or International).
     * @param ortalama Ürünlerin ortalamasını belirtir.
     */
    public void dereceKarsilastir(Customer customer, double[] ortalama) {
        double sayi;
        for (int j = 0; j < arrUrunBilgisi[0].length; j++) {
            System.out.println((j + 1) + ". ürüne düşük puan veren kişiler:");
            for (int i = 0; i < getCustomerCount(); i++) {
                if (arrUrunBilgisi[i][j] != 0) {
                    sayi = (double) arrUrunBilgisi[i][j];

                    if (sayi < ortalama[j]) {
                        if ((customer instanceof NationalCustomer) && (arrCustomer[i] instanceof NationalCustomer)) {
                            System.out.println(arrCustomer[i].toString());
                            System.out.println("Ürüne verdiği puan :" + arrUrunBilgisi[i][j]);
                        } else if ((customer instanceof InternationalCustomer) && (arrCustomer[i] instanceof InternationalCustomer)) {
                            System.out.println(arrCustomer[i].toString());
                            System.out.println("Ürüne verdiği puan :" + arrUrunBilgisi[i][j]);
                        }
                    }
                } else {
                    break;
                }
            }
            System.out.println("");
        }
    }

    public void ortalamaEkranaYaz(double[] arrays, String baslik) {
        System.out.println(baslik);

        for (double array : arrays) {
            System.out.print(String.format("%.2f", array) + "\t");
        }
        System.out.println();
    }

    public boolean customerEqual(int id) {
        for (int i = 0; i < getCustomerCount(); i++) {
            if (arrCustomer[i].getCustomerID() == id) {
                return true;
            }
        }
        return false;
    }

    public void musteriGirisi() {
        Scanner sc = new Scanner(System.in);
        char musteriTipi = 0;
        char durum = 0;
        String ad, soyad;
        int id = 0;

        do {
            do {
                System.out.print("Müşteri tipini giriniz[n-Ulusal, i:Uluslararası] :");
                musteriTipi = sc.nextLine().toUpperCase().charAt(0);
            } while (!(musteriTipi == 'N' || musteriTipi == 'I' || musteriTipi == 'İ'));

            do {
                System.out.print("Müşteri numarası(ID):");
                id = sc.nextInt();
                sc.nextLine();
                
                if (customerEqual(id)) {
                    System.out.println(id + " müşteri numarası ile kayıtlı bir müşteri var..");
                }
            } while (customerEqual(id));

            System.out.print("Müşterinin adı:");
            ad = sc.nextLine();
            System.out.print("Müşterinin soyadı:");
            soyad = sc.nextLine();

            if (musteriTipi == 'N') {
                int licancePlateNumber;
                String occupation;
                System.out.print("Müşterinin il plaka kodu :");
                licancePlateNumber = sc.nextInt();
                sc.nextLine();
                System.out.print("Müşterinin mesleği :");
                occupation = sc.nextLine();
                NationalCustomer customer = new NationalCustomer(id, ad, soyad, licancePlateNumber, occupation);
                arrCustomer[getCustomerCount()] = new NationalCustomer(customer);
            } else if (musteriTipi == 'I' || musteriTipi == 'İ') {
                String country, city;
                System.out.print("Müşterinin yaşadığı ülke :");
                country = sc.nextLine();
                System.out.print("Müşterinin yaşadığı şehir :");
                city = sc.nextLine();
                InternationalCustomer customer = new InternationalCustomer(id, ad, soyad, country, city);
                arrCustomer[getCustomerCount()] = new InternationalCustomer(customer);
            }

            for (int i = 0; i < arrUrunBilgisi[getCustomerCount()].length - 1; i++) {
                System.out.print((i + 1) + ". ürüne ait puanınızı giriniz [1-5] :");
                arrUrunBilgisi[getCustomerCount()][i] = sc.nextInt();
                sc.nextLine();
            }
            arrUrunBilgisi[getCustomerCount() - 1][arrUrunBilgisi[0].length - 1] = (int) Math.round(sonPuanHesapla());
            System.out.println("Son ürüne ait tahmini puanı :" + arrUrunBilgisi[getCustomerCount() - 1][arrUrunBilgisi[0].length - 1]);
            this.customerCount++;
            System.out.print("Müşteri kaydına devam etmek için [E] tuşuna basınız :");
            durum = sc.nextLine().toUpperCase().charAt(0);
        } while (this.customerCount <= 200 && durum == 'E');
    }

    //hesaplamada sorun var düzeltilmesi gerekli
    private double sonPuanHesapla() {
        int benzerlikPuani = 0;
        int[][] temp = new int[200][2];//[ortalama benzerlik değerleri],[son ürüne ait puanı]
        int count = 0;
        int toplamBenzeyenPuan = 0;
        double ortalamaPuan;
        for (int i = 0; i < getCustomerCount(); i++) {
            for (int j = 0; j < arrUrunBilgisi[0].length - 1; j++) {
                benzerlikPuani += Math.abs(arrUrunBilgisi[getCustomerCount()][j] - arrUrunBilgisi[i][j]);
            }
            temp[i][0] = benzerlikPuani;
            temp[i][1] = arrUrunBilgisi[i][arrUrunBilgisi[0].length - 1];
            benzerlikPuani = 0;
        }

        benzerlikPuani = temp[0][0];
        toplamBenzeyenPuan = temp[0][1];
        for (int i = 1; i < getCustomerCount(); i++) {
            if (temp[i][0] < benzerlikPuani) {
                benzerlikPuani = temp[i][0];
                toplamBenzeyenPuan = temp[i][1];
                count = 1;
            } else if (benzerlikPuani == temp[i][0]) {
                toplamBenzeyenPuan += temp[i][1];
                count++;
            }
        }
        ortalamaPuan = (double) toplamBenzeyenPuan / (double) count;
        return ortalamaPuan;
    }

    public void girisYapilanMusteriler() {
        for (int i = fileCustomerCount; i < getCustomerCount(); i++) {
            System.out.println(arrCustomer[i].toString());
        }
    }

}
